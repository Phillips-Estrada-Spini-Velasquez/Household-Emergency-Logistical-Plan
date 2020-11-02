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