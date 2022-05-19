

async function registrarSolucion() {
    let datos = {};
    datos.titulo = document.getElementById("inputTitulo").value;
    datos.descripcion = document.getElementById("inputDescripcion").value;
    datos.idrisk = document.getElementById("inputRisk").value;
    console.log(datos);
    const request = await fetch('registrarSol', {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(datos)
    });
}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authentication': localStorage.token
    };
}