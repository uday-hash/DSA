function getLaserSetting(magic){
    if (magic === 'please') {
        return "OFF";
    }
    else {
        return "ON";
    }
}

const politelaser = getLaserSetting("please");
console.log('My laser staus' + politelaser);