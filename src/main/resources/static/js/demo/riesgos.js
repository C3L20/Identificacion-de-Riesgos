$(document).ready(function() {
    loadRisks();loadSoluciones();
    //$('#RisksTable').DataTable();
    //$('#SolutionsTable').DataTable();
});

async function registrarRisk() {
    let datos = {};
    datos.titulo = document.getElementById("inputTitulo").value;
    datos.dueño = document.getElementById("inputDueño").value;
    datos.categoria = document.getElementById("inputCategoria").value;
    datos.causa = document.getElementById("inputCausa").value;
    datos.gatillante = document.getElementById("inputGatillante").value;
    datos.fuente = document.getElementById("inputFuente").value;
    datos.ocurrencia = document.getElementById("inputOcurrencia").value;
    datos.caducidad = document.getElementById("inputCaducidad").value;
    datos.idproy = document.getElementById("inputProyecto").value;
    console.log(datos);
    const request = await fetch('registrarRisk', {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(datos)
    });
}

async function loadSoluciones() {
    const request = await fetch('getSoluciones', {
        method: 'GET',
        headers: getHeaders()
      });
      const soluciones = await request.json();
      let solsHTML = '';
      for (let sol of soluciones) {
          let solHTML = '<tr><td>'
          +sol.idsol_mig+'</td><td>'
          +sol.titulo+'</td><td>'
          +sol.idrisk+'</td><td>'
          +sol.descripcion+'</td><td><a href="#" onclick="eliminarSol('+sol.idsol_mig+')" method="DELETE" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td></tr>';
  
          solsHTML += solHTML;
      }
      document.querySelector('#SolutionsTable tbody').outerHTML = solsHTML;
}

async function eliminarSol(idsol) {
    if (!confirm("¿Desea eliminar el usuario?")) {
      return;
    }
    const request = await fetch('eliminarSol/'+idsol,{
      method: 'DELETE',
      headers: getHeaders()
    });
    location.reload();
}

async function loadRisks() {
    const request = await fetch('getRisks', {
      method: 'GET',
      headers: getHeaders()
    });
    const risks = await request.json();
    let risksHTML = '';
    for (let risk of risks) {
        let riskHTML = '<tr><td>'
        +risk.idrisk+'</td><td>'
        +risk.titulo+'</td><td>'
        +risk.dueño+'</td><td>'
        +risk.categoria+'</td><td>'
        +risk.causa+'</td><td>'
        +risk.gatillante+'</td><td>'
        +risk.fuente+'</td><td>'
        +risk.ocurrencia+'</td><td>'
        +risk.caducidad+'</td><td>'
        +risk.idproy+'</td><td><a href="#" onclick="eliminarRisk('+risk.idrisk+')" method="DELETE" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td></tr>';

        risksHTML += riskHTML;
    }
    document.querySelector('#RisksTable tbody').outerHTML = risksHTML;
}

async function eliminarRisk(idRisk) {
    if (!confirm("¿Desea eliminar el usuario?")) {
      return;
    }
    const request = await fetch('eliminarRisk/'+idRisk ,{
      method: 'DELETE',
      headers: getHeaders()
    });
    location.reload();
  }

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authentication': localStorage.token
    };
}