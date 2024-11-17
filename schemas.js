// метод узловых потенциалов
let R1 = 10; // например, 10 Ом
let R2 = 20; // например, 20 Ом
let R3 = 20; // например, 30 Ом
let E1 = 100;  // например, 5 В
let E3 = 50;  // например, 3 В
let J = 3;   // например, 2 А

// Вычисления по формулам
let G1 = 1 / R1;
let G2 = 1 / R2;
let G3 = 1 / R3;

let U = (E1 * G1 - E3 * G3 + J) / (G1 + G2 + G3);

let I1 = (E1 - U) * G1;
let I2 = U * G2;
let I3 = (U + E3) * G3;

// Проверка условия
let check = I1 - I2 - I3 + J;

console.log(`I1: ${I1}`);
console.log(`I2: ${I2}`);
console.log(`I3: ${I3}`);
console.log(`Проверка (I1 - I2 - I3 + J): ${check}`);
