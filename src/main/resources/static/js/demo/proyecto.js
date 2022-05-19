

async function registrarProyecto() {
    let datosPort = {};
    let datosProg = {};
    let datosProy = {};

    datosPort.tituloPort = document.getElementById("inputTituloPort").value;

    datosProg.tituloProg = document.getElementById("inputTituloProg").value;
    datosProg.idPort = document.getElementById("inputPort").value;
    
    datosProy.tituloProy = document.getElementById("inputTituloProy").value;
    datosProy.F_inicio = document.getElementById("inputFechaI").value;
    datosProy.F_termino = document.getElementById("inputFechaT").value;
    datosProy.idProg = document.getElementById("inputProg").value;

    const request1 = await fetch('registrarProyecto', {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(datosProy)
    });

    const request2 = await fetch('registrarPort', {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(datosPort)
    });

    const reques3 = await fetch('registrarProg', {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(datosProg)
    });
}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authentication': localStorage.token
    };
}