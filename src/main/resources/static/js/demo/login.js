$(document).ready(function() {
});

async function logIn() {
    let datos = {};
    datos.email = document.getElementById("inputEmail").value;
    datos.contrasena = document.getElementById("inputContrasena").value;
    
    const request = await fetch('logIn', {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(datos)
    });
    const res = await request.text();
    if (res != "Fail") {
        localStorage.token = res;
        localStorage.email = datos.email;
        window.location.href = "tables.html";
    } else {
        localStorage.token = null;
        alert("Las credenciales son incorrectas.");
    }
}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authentication': localStorage.token
    };
}