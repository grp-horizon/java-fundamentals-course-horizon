// Compila y ejecuta cada Main.java de starter-files/ y completed-examples/ y compara la salida con salida-esperada.txt.
// Si existe entrada.txt se usa como entrada estándar. Requiere JDK 21 y Node.js 20 o superior.
// Uso: node scripts/verificar.mjs [filtro]      (por ejemplo: node scripts/verificar.mjs leccion-3)
import { spawnSync } from "node:child_process";
import { existsSync, mkdtempSync, readdirSync, readFileSync, rmSync, statSync } from "node:fs";
import os from "node:os";
import path from "node:path";
import { fileURLToPath } from "node:url";

const raiz = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");
const filtro = process.argv[2] ?? "";

const buscar = (nombre) => {
  const home = process.env.JAVA_HOME;
  if (home) {
    for (const ext of ["", ".exe"]) {
      const f = path.join(home, "bin", nombre + ext);
      if (existsSync(f)) return f;
    }
  }
  return nombre; // el que esté en el PATH
};
const javac = buscar("javac");
const java = buscar("java");

const carpetasConJava = (dir) => {
  const salida = [];
  for (const e of readdirSync(dir)) {
    const f = path.join(dir, e);
    if (statSync(f).isDirectory()) salida.push(...carpetasConJava(f));
  }
  if (readdirSync(dir).includes("Main.java")) salida.push(dir);
  return salida;
};

const norm = (s) => s.replace(/\r\n/g, "\n").trimEnd();
let fallos = 0;
let total = 0;
for (const base of ["starter-files", "completed-examples"]) {
  const dirBase = path.join(raiz, base);
  if (!existsSync(dirBase)) continue;
  for (const dir of carpetasConJava(dirBase)) {
    const nombre = path.relative(raiz, dir).replaceAll("\\", "/");
    if (!nombre.includes(filtro)) continue;
    total++;
    const tmp = mkdtempSync(path.join(os.tmpdir(), "java-curso-"));
    const c = spawnSync(javac, ["-encoding", "UTF-8", "-d", tmp, path.join(dir, "Main.java")], { encoding: "utf8" });
    if (c.status !== 0) {
      fallos++;
      console.log(`✗ ${nombre}: no compila\n${c.stderr || c.error}`);
      rmSync(tmp, { recursive: true, force: true });
      continue;
    }
    const entrada = path.join(dir, "entrada.txt");
    const r = spawnSync(java, ["-Dfile.encoding=UTF-8", "-Dstdout.encoding=UTF-8", "-cp", tmp, "Main"], {
      encoding: "utf8",
      input: existsSync(entrada) ? readFileSync(entrada, "utf8") : "",
      timeout: 15000,
    });
    rmSync(tmp, { recursive: true, force: true });
    if (r.status !== 0) {
      fallos++;
      console.log(`✗ ${nombre}: falla al ejecutar\n${r.stderr}`);
      continue;
    }
    const esperada = path.join(dir, "salida-esperada.txt");
    if (existsSync(esperada) && norm(r.stdout) !== norm(readFileSync(esperada, "utf8"))) {
      fallos++;
      console.log(`✗ ${nombre}: la salida no coincide`);
      continue;
    }
    console.log(`✓ ${nombre}`);
  }
}
console.log(`\n${total - fallos}/${total} programas correctos`);
process.exit(fallos ? 1 : 0);
