const myargv = process.argv[2];
const treeLifeStatus = Number(myargv);

if (treeLifeStatus === 0) {
  console.log('alive');
} else {
  console.log('other');
}
