const myargv = process.argv[2];
const fizzbuzz = Number(myargv);

if (fizzbuzz % 3 == 0 && fizzbuzz % 5 == 0) {
  console.log('JavaScript');
} else if (fizzbuzz % 3 == 0) {
  console.log('Java');
} else if (fizzbuzz % 5 == 0) {
  console.log('Script');
} else {
  console.log(fizzbuzz);
}