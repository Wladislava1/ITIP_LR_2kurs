let R1 = 10;
let R2 = 20;
let R3 = 20;
let E1 = 100;
let E3 = 50;
let J = 3;

// Задаем I33
let I33 = J;

// Вычисление I11 и I22

let I22 = (E3*R2 + E3*R1 - 3*R2*R3 - 3*R3*R1 + R2*E1)/(R2*R3 + R3*R1 + R2*R1);
let I11 = (E1 + R2*I22)/(R2 +R1);

// Вычисление токов
let I1 = I11;
let I2 = I11 - I22;
let I3 = I33 + I22;

// Вывод результатов
console.log(`I1 = ${I1.toFixed(2)}`);
console.log(`I2 = ${I2.toFixed(2)}`);
console.log(`I3 = ${I3.toFixed(2)}`);
