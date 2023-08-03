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
        console.log(response)
        if(response.password === 'abc') {
            window.location = "tms_member.html"
        } else if(response.password === "yyz" + 1) {
            window.location = "tms_pm.html"
        }
        
    })
    .catch(err=>{alert("Loadding error")})
}





