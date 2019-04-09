function scrollDiv() {
    console.log("Scrolling!");
    
}


let y = document.getElementById("Rotated").children;

console.log(y);

let percent = (2 * Math.PI) / y.length;
console.log(percent);
const radius =  130;

let x = document.getElementById("BODY");
if (x.addEventListener) {
    // IE9, Chrome, Safari, Opera
    x.addEventListener("mousewheel", MouseWheelHandler, false);
    // Firefox
    x.addEventListener("DOMMouseScroll", MouseWheelHandler, false);
}



for (let index = 0; index < y.length; index++) {
    y[index].setAttribute("style", "transform:rotate(" + percent * index + "rad) translateX("+radius+"px)");
    // y[index].setAttribute("style", "transform:translate(" + radius * Math.cos(percent * index)+"," + radius * Math.sin(percent * index)+")");
}

let rotationAngle = 0;
let minRotation = 1;

function MouseWheelHandler(e) {
    console.log("DETECTED EVENT",e);
    
    // cross-browser wheel delta
    var e = window.event || e; // old IE support
    var delta = Math.max(-1, Math.min(1, (e.wheelDelta || -e.detail)));

    // console.log(delta);
    rotationAngle+= delta*minRotation
    document.getElementById("Rotated").style.transform = 'rotate('+rotationAngle+'deg)';
}