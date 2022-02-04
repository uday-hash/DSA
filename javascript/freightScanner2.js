function scan(freightItems) {
  let contrabandIndexes = [];

  freightItems.forEach((value, index) => {
    if (value == 'contraband') {
      contrabandIndexes.push(index);
    }
  });
  return contrabandIndexes;
}

const indexes = scan(['dog', 'contraband', 'cat', 'zippers', 'contraband']);
console.log('Contraband Indexes: ' + indexes); // should be [1, 4]