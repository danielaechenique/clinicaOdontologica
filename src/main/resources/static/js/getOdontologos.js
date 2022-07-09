window.addEventListener('load', function () {

    (function(){
      event.preventDefault();
      const url = '/odontologos/list';
      const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
         for(odontologo of data){
              var table = document.getElementById("odontologoTable");
              var odontologoRow =table.insertRow();
              let tr_id = 'tr_' + odontologo.id;
              odontologoRow.id = tr_id;

               let deleteButton = '<button' +
                                          ' id=' + '\"' + 'btn_delete_' + odontologo.id + '\"' +
                                          ' type="button" onclick="deleteBy('+odontologo.id+')" class="btn btn-danger btn_delete">' +
                                          '&times' +
                                          '</button>';


              let updateButton = '<button' +
                                          ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                          ' type="button" onclick="findBy('+odontologo.id+')" class="btn btn-info btn_id">' +
                                         odontologo.id +
                                          '</button>';

             odontologoRow.innerHTML = '<td>' + updateButton + '</td>' +
                                  '<td class=\"td_first_name\">' + odontologo.nombre + '</td>' +
                                  '<td class=\"td_last_name\">' + odontologo.apellido + '</td>' +
                                  '<td class=\"td_matricula\">' + odontologo.matricula+ '</td>' +
                                  '<td>' + deleteButton + '</td>';
            $('#odontologoTable tbody').append(odontologoRow);
        };

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/odontologosList.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})