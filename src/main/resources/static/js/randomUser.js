function randomUser() {
    fetch("https://randomuser.me/api")
        .then(function(res){
            return res.json();
        })
        .then(function(data){
            var user = data.results[0];
            var name = user.name.title + " " + user.name.first + " " + user.name.last;
            document.getElementById("user-name").innerHTML = name;
            document.getElementById("user-gender").innerText = user.gender;
            document.getElementById("user-image").src = user.picture.large;
        })
        .catch(function(err){
            console.log("Error " + err);
        })
}