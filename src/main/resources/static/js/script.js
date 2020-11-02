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

map.scrollZoom.disable();

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
    onUploadDone : updateDocument ,
    accept: 'image/*',
    maxSize: 10* 1000* 1000,
    uploadInBackground: false
}
// FUNCTIONALITY THE-PLAN
function updateDocument(result){
    const filedata = result.filesUploaded[0];
    console.log(filedata);
    $("#documentUrl").val(filedata.url);
    const formData = new FormData();
    formData.append('url', filedata.url);
    fetch("/profile/submit-document", {method: "POST", body: formData}).catch(function(error) {
        console.log(error)
    });
}
//jquery
$(document).ready(function() {
    //filestack
    console.log(url);
    $("#containerBlueButton2").click(function(){
        client.picker(options).open();
    });
})
