function openPopup() {
    document.getElementById("popup").style.display = "block";
}

function closePopup() {
    document.getElementById("popup").style.display = "none";
}

var button = document.getElementById("book");

button.addEventListener('click',function(){
    document.getElementById("popup").style.display = "none";
});


var closeUpdate = document.getElementById("editProf");

closeUpdate.addEventListener('click',function(){
    document.getElementById("popup").style.display = "none";
})


// Booked Info

function openBooked(){
    document.getElementById("bookInfo").style.display = "block";
}

function closeBooked() {
    document.getElementById("bookInfo").style.display = "none";
}

var back = document.getElementById("info");

back.addEventListener('click',function(){
    document.getElementById("bookInfo").style.display = "none";
});


// Edit Profile

function openEdit(){
    document.getElementById("editProfile").style.display = "block";
}

function closeEdit() {
    document.getElementById("editProfile").style.display = "none";
}

var ret = document.getElementById("return");
ret.addEventListener('click', function(){
    document.getElementById("editProfile").style.display = "none";
});



// Play audio

function playAudio(audioId){
    var audio = document.getElementById(audioId);

    audio.play();
}
