// Call the dataTables jQuery plugin
$(document).ready(function() {
  loadUsers();
  $('#UsersTable').DataTable();
});
async function loadUsers() {
  const request = await fetch('getUsers', {
    method: 'GET',
    headers: getHeaders()
  });
  const users = await request.json();
  console.log(users);
  let usersHTML = '';
  for (let user of users) {
    let userHTML = '<tr><td>'
      +user.nombre+'</td><td>'
      +user.rut+'</td><td>'
      +user.email+'</td><td>'
      +user.telefono+'</td><td>'
      +user.contrasena+'</td><td><a href="#" onclick="eliminarUser('+user.rut+')" method="DELETE" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td></tr>';
      
    usersHTML += userHTML;
  }
  document.querySelector('#UsersTable tbody').outerHTML = usersHTML;
}

async function eliminarUser(rut) {
  if (!confirm("¿Desea eliminar el usuario?")) {
    return;
  }
  const request = await fetch('eliminarUser/'+rut ,{
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