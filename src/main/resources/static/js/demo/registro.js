$(document).ready(function() {
});

async function registrarUser() {
    let datos = {};
    datos.rut = document.getElementById("inputRut").value;
    datos.nombre = document.getElementById("inputNombre").value;
    datos.email = document.getElementById("inputEmail").value;
    datos.telefono = document.getElementById("inputTelefono").value;
    datos.contrasena = document.getElementById("inputContrasena").value;
    let rContrasena = document.getElementById("inputRContrasena").value;
    if (datos.contrasena != rContrasena) {
        alert("Las contraseñas ingresadas no son identicas.");
        return;
    }
    const request = await fetch('registrarUser', {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(datos)
    });
    alert("Se registro con exito!");
}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authentication': localStorage.token
    };
}