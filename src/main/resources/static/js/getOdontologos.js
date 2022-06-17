window.addEventListener('load', function () {

(function(){
  event.preventDefault();
  const url = '/odontologos';
  const settings = {
    method: 'GET'
}
  fetch(url,settings)
  .then(response => response.json())
  .then(data => {
    $.each(data, (i, odontologo) => {

      let deleteButton = '<button ' +
                              'id=' +
                              '\"' + 'btn_delete_' + odontologo.id + '\"'+
                              ' type="button" class="btn btn-danger btn_delete" data-toggle="modal"  data-target="#delete-modal"' +
                              '>&times</button>';

      let get_More_Info_Btn = '<button' +
                                  ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                  ' type="button" onclick="find('+odontologo.id+')" class="btn btn-info btn_id">' +
                                  odontologo.id +
                                  '</button>';

      let tr_id = 'tr_' + odontologo.id;
      let odontologoRow = '<tr id=\"' + tr_id + "\"" + '>' +
                '<td>' + get_More_Info_Btn + '</td>' +
                '<td class=\"td_first_name\">' + odontologo.nombrr.toUpperCase() + '</td>' +
                '<td class=\"td_address\">' + odontologo.apellido + '</td>' +
                '<td>' + deleteButton + '</td>' +
                '</tr>';
      $('#odontologoTable tbody').append(odontologoRow);
    });

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/odontologos.html") {
      $(".nav .nav-item a:last").addClass("active");
  }
})
})