console.log("connected");


function userLogIn() {

    let url = "http://localhost:8080/userLogin";

    let logInInfo = {
        "userName" : document.getElementById("Uname").value,
        "password" : document.getElementById("password").value
    }
    
    let body = {
        method: "POST",
        body : JSON.stringify(logInInfo),
        headers : {
            "Content-type" : "application/json"
        }
    }
    
    fetch(url, body)
    .then(response => response.json())
    .then(response => {
        localStorage.setItem("tmsLogged", JSON.stringify(response))
        console.log(response.password)
        if(response.password === "abc2" || "def2") {
            window.location = "tms_member.html"
        } else if(response.password == 'yyz1') {
            window.location = "tms_pm.html"
        }
        
    })
    .catch(err=>{alert("Loadding error")})
}

function retrieveUserInfo() {
    let info = localStorage.getItem("tmsLogged");
    console.log(info);
    let parseInfo = JSON.parse(info);
    console.log(parseInfo.userName)
    loadUserInfo(parseInfo.id);
}

function loadUserInfo(id) {

    let url = "http://localhost:8080/personalContact/emp_id/" + id;
    console.log(url);
    fetch(url)
    .then(response => response.json())
    .then(response => {
        console.log(response)
        console.log(response.personalContact)
    })

}

























