// THE-PLAN HTML JAVASCRIPT
// SENTIMANTAL ITEMS CHECKLIST
// Create a "close" button and append it to each list item
let myNodelist = document.getElementsByTagName("LI");
let i;
for (i = 0; i < myNodelist.length; i++) {
    let span = document.createElement("SPAN");
    let txt = document.createTextNode("\u00D7");
    span.className = "close";
    span.appendChild(txt);
    myNodelist[i].appendChild(span);
}

// Click on a close button to hide the current list item
let close = document.getElementsByClassName("close");
for (i = 0; i < close.length; i++) {
    close[i].onclick = function() {
        let div = this.parentElement;
        div.style.display = "none";
    }
}

// Add a "checked" symbol when clicking on a list item
let list = document.querySelector('ul');
list.addEventListener('click', function(ev) {
    if (ev.target.tagName === 'LI') {
        ev.target.classList.toggle('checked');
    }
}, false);

// Create a new list item when clicking on the "Add" button
function newElement() {
    let li = document.createElement("li");
    let inputValue = document.getElementById("myInput").innerText;
    let t = document.createTextNode(inputValue);
    li.appendChild(t);
    if (inputValue === '') {
        alert("You must write something!");
    } else {
        document.getElementById("myUL").appendChild(li);
    }
    document.getElementById("myInput").value = "";

    let span = document.createElement("SPAN");
    let txt = document.createTextNode("\u00D7");
    span.className = "close";
    span.appendChild(txt);
    li.appendChild(span);

    for (i = 0; i < close.length; i++) {
        close[i].onclick = function() {
            let div = this.parentElement;
            div.style.display = "none";
        }
    }
}

// THE-PLAN HTML JAVASCRIPT
// MAPBOX JAVASCRIPT
mapboxgl.accessToken = mapboxKey;
let map = new mapboxgl.Map({
    container: 'map',
    style: 'mapbox://styles/mapbox/streets-v11',
    //default center
    center: [-98.4951,29.4246],
    zoom: 12,
    preserveDrawingBuffer: true
});

let directions = new MapboxDirections({
    accessToken: mapboxKey
});

map.scrollZoom.disable();

map.addControl(directions,'top-left');

//takes text value for element rallyPoint (pulling modelAttribute)
let rallyPoint = document.getElementById("rallyPoint").innerText;
console.log(rallyPoint)

map.on('load',  function() {
    directions.setDestination(rallyPoint); // can be address
})

// NAVIGATION BUTTONS
const btn1 = function () {
    map.setZoom(19);
};
document.getElementById("btn1").addEventListener("click", btn1);

const btn2 = function () {
    map.setZoom(12);
};
document.getElementById("btn2").addEventListener("click", btn2);

const btn3 = function () {
    map.setZoom(9);
};
document.getElementById("btn3").addEventListener("click", btn3);

$('#downloadLink').click(function() {
    let img = map.getCanvas().toDataURL('image/png')
    this.href = img
})