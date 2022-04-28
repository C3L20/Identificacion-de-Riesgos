$(document).ready(function() {
    loadRisks();loadSoluciones();
    $('#RisksTable').DataTable();
    $('#SolutionsTable').DataTable();
});

async function loadSoluciones() {
    const request = await fetch('getSoluciones', {
        method: 'GET',
        headers: getHeaders()
      });
      const soluciones = await request.json();
      console.log(soluciones);
      let solsHTML = '';
      for (let sol of soluciones) {
          let solHTML = '<tr><td>'
          +sol.idsol_mig+'</td><td>'
          +sol.titulo+'</td><td>'
          +sol.idrisk+'</td><td>'
          +sol.descripcion+'</td><td><a href="#" onclick="eliminarUser('+sol.idsol_mig+')" method="DELETE" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td></tr>';
  
          solsHTML += solHTML;
      }
      document.querySelector('#SolutionsTable tbody').outerHTML = solsHTML;
}

async function loadRisks() {
    const request = await fetch('getRisks', {
      method: 'GET',
      headers: getHeaders()
    });
    const risks = await request.json();
    console.log(risks);
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
        +risk.idproy+'</td><td><a href="#" onclick="eliminarUser('+risk.idrisk+')" method="DELETE" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td></tr>';

        risksHTML += riskHTML;
    }
    document.querySelector('#RisksTable tbody').outerHTML = risksHTML;
}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authentication': localStorage.token
    };
}