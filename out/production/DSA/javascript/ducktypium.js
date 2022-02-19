const VALID_COLORS = ["red", "yellow", "blue"];
const mixPurple = (a,b) =>  (a == 'red' && b == 'blue') || (a == 'blue' && b == 'red');
const mixOrange = (a,b) =>  (a == 'red' && b == 'yellow') || (a == 'yellow' && b == 'red');
const mixGreen = (a,b) =>   (a == 'yellow' && b == 'blue') || (a == 'blue' && b == 'yellow');
 
class Ducktypium {
  constructor(color) {
    if (!VALID_COLORS.includes(color)) {
      throw new TypeError("Color must be red, yellow, or blue!");
    }
    this.color = color;
    this.calibrationSequence = [];
  }


 refract(pickColor) {

    if (!VALID_COLORS.includes(pickColor)) {
      throw new TypeError("Color must be red, yellow, or blue!");
    } else if (mixPurple(this.color,pickColor)) {
      return "purple";
    } else if (mixOrange(this.color,pickColor)) {
      return "orange";
    } else if (mixGreen(this.color,pickColor)) {
      return "green";
    } else {
      return this.color;
    }

  }
  
  calibrate(arrayOfNumber) {
    let currentArray = arrayOfNumber.sort();

    currentArray.forEach(item => {
      let multiply = item * 3;
      this.calibrationSequence.push(multiply);
    }); 
 }
}


// The following lines of code are not required for the solution, but can be
// used by you to test your solution.
const dt = new Ducktypium("red");

console.log(dt.color); // prints 'red'

console.log(dt.refract("blue")); // prints 'purple'
console.log(dt.refract("red")); // prints 'red'
console.log(dt.refract("yellow"));

dt.calibrate([3, 5, 1]);

console.log(dt.calibrationSequence); // prints [3, 9, 15]