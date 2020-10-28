// THE-PLAN HTML JAVASCRIPT
// SENTIMANTAL ITEMS CHECKLIST
// Create a "close" button and append it to each list item
var myNodelist = document.getElementsByTagName("LI");
var i;
for (i = 0; i < myNodelist.length; i++) {
    var span = document.createElement("SPAN");
    var txt = document.createTextNode("\u00D7");
    span.className = "close";
    span.appendChild(txt);
    myNodelist[i].appendChild(span);
}

// Click on a close button to hide the current list item
var close = document.getElementsByClassName("close");
var i;
for (i = 0; i < close.length; i++) {
    close[i].onclick = function() {
        var div = this.parentElement;
        div.style.display = "none";
    }
}

// Add a "checked" symbol when clicking on a list item
var list = document.querySelector('ul');
list.addEventListener('click', function(ev) {
    if (ev.target.tagName === 'LI') {
        ev.target.classList.toggle('checked');
    }
}, false);

// Create a new list item when clicking on the "Add" button
function newElement() {
    var li = document.createElement("li");
    var inputValue = document.getElementById("myInput").value;
    var t = document.createTextNode(inputValue);
    li.appendChild(t);
    if (inputValue === '') {
        alert("You must write something!");
    } else {
        document.getElementById("myUL").appendChild(li);
    }
    document.getElementById("myInput").value = "";

    var span = document.createElement("SPAN");
    var txt = document.createTextNode("\u00D7");
    span.className = "close";
    span.appendChild(txt);
    li.appendChild(span);

    for (i = 0; i < close.length; i++) {
        close[i].onclick = function() {
            var div = this.parentElement;
            div.style.display = "none";
        }
    }
}

// THE-PLAN HTML JAVASCRIPT
// MAPBOX JAVASCRIPT
mapboxgl.accessToken = mapboxKey;
var map = new mapboxgl.Map({
    container: 'map',
    style: 'mapbox://styles/mapbox/streets-v11',
    center: [-95.2839, 38.9075],
    zoom: 4,
    preserveDrawingBuffer: true
});


map.addControl(
    new MapboxDirections({
        accessToken: mapboxgl.accessToken
    }),
    'top-left'
);

// NAVIGATION BUTTONS
const btn1 = function () {
    map.setZoom(16);
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
    var img = map.getCanvas().toDataURL('image/png')
    this.href = img
})

// FILESTACK API JAVASCRIPT
const client = filestack.init(filestackKey);
const options = {
    uploadConfig: {
        tags: {
            "foo": "bar"
        }
    },
    fromSources: ["local_file_system","instagram","facebook"],
};

// THE-CHECKLIST HTML JAVASCRIPT
// TOOLTIP HEADER JAVASCRIPT
function toolTipHeader() {
    var tt = document.getElementById("tooltipHeader");
    tt.classList.toggle("show");
}

// TOOLTIPS 1-25 JAVASCRIPT
function toolTipClickMe() {
    var tt = document.getElementById("tooltipClickMe");
    tt.classList.toggle("show");
}

function toolTipOne() {
    var tt = document.getElementById("tooltip1");
    tt.classList.toggle("show");
}

function toolTipTwo() {
    var tt = document.getElementById("tooltip2");
    tt.classList.toggle("show");
}

function toolTipThree() {
    var tt = document.getElementById("tooltip3");
    tt.classList.toggle("show");
}

function toolTipFour() {
    var tt = document.getElementById("tooltip4");
    tt.classList.toggle("show");
}

function toolTipFive() {
    var tt = document.getElementById("tooltip5");
    tt.classList.toggle("show");
}

function toolTipSix() {
    var tt = document.getElementById("tooltip6");
    tt.classList.toggle("show");
}

function toolTipSeven() {
    var tt = document.getElementById("tooltip7");
    tt.classList.toggle("show");
}

function toolTipEight() {
    var tt = document.getElementById("tooltip8");
    tt.classList.toggle("show");
}

function toolTipNine() {
    var tt = document.getElementById("tooltip9");
    tt.classList.toggle("show");
}

function toolTipTen() {
    var tt = document.getElementById("tooltip10");
    tt.classList.toggle("show");
}

function toolTipEleven() {
    var tt = document.getElementById("tooltip11");
    tt.classList.toggle("show");
}

function toolTipTwelve() {
    var tt = document.getElementById("tooltip12");
    tt.classList.toggle("show");
}

function toolTipThirteen() {
    var tt = document.getElementById("tooltip13");
    tt.classList.toggle("show");
}

function toolTipFourteen() {
    var tt = document.getElementById("tooltip14");
    tt.classList.toggle("show");
}

function toolTipFifteen() {
    var tt = document.getElementById("tooltip15");
    tt.classList.toggle("show");
}

function toolTipSixteen() {
    var tt = document.getElementById("tooltip16");
    tt.classList.toggle("show");
}

function toolTipSeventeen() {
    var tt = document.getElementById("tooltip17");
    tt.classList.toggle("show");
}

function toolTipEighteen() {
    var tt = document.getElementById("tooltip18");
    tt.classList.toggle("show");
}

function toolTipNineteen() {
    var tt = document.getElementById("tooltip19");
    tt.classList.toggle("show");
}

function toolTipTwenty() {
    var tt = document.getElementById("tooltip20");
    tt.classList.toggle("show");
}

function toolTipTwentyone() {
    var tt = document.getElementById("tooltip21");
    tt.classList.toggle("show");
}

function toolTipTwentytwo() {
    var tt = document.getElementById("tooltip22");
    tt.classList.toggle("show");
}

function toolTipTwentythree() {
    var tt = document.getElementById("tooltip23");
    tt.classList.toggle("show");
}

function toolTipTwentyfour() {
    var tt = document.getElementById("tooltip24");
    tt.classList.toggle("show");
}

function toolTipTwentyfive() {
    var tt = document.getElementById("tooltip25");
    tt.classList.toggle("show");
}