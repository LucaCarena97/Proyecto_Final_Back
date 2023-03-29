window.addEventListener('load', function () {

  (function () {
    //con fetch invocamos a la API de estudiantes con el método GET
    //nos devolverá un JSON con una colección de estudiantes
    const url = '/odontologo/all';
    const settings = {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    }
    fetch(url, settings)

      .then(function (response) {
        return response.json();
      })

      .then(function (data) {

        

        //recorremos la colección de estudiantes del JSON
        for (odontologo of data) {

          console.log(odontologo);

          console.log("nombre:" + odontologo.nombre);
          console.log("id:" + odontologo.id);
          //por cada estudiante armaremos una fila de la tabla
          //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos
          //el estudiante
          var table = document.querySelector("#odontologoTable");
          var odontologoRow = table.insertRow();
          
          let tr_id = 'tr_' + odontologo.id;
          odontologoRow.id = tr_id;


          let updateButton = '<button' +
            ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
            ' type="button" onclick="findBy(' + odontologo.id + ')" class="btn btn-info btn_id">' +
            odontologo.id +
            '</button>';

          //por cada estudiante creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
          //dicho boton invocara a la funcion de java script deleteByKey que se encargará
          //de llamar a la API para eliminar al estudiante
          let deleteButton = '<button' +
            ' id=' + '\"' + 'btn_delete_' + odontologo.id + '\"' +
            ' type="button" onclick="deleteBy(' + odontologo.id + ')" class="btn btn-danger btn_delete">' +
            '&times' +
            '</button>';

          //por cada estudiante creamos un boton que muestra el id y que al hacerle clic invocará
          //a la función de java script findBy que se encargará de buscar al estudiante que queremos
          //modificar y mostrar los datos del mismo en un formulario.
      
          //armamos cada columna de la fila

          //como primer columna pondremos el boton modificar
          //luego los datos del estudiante
          //como ultima columna el boton eliminar

          odontologoRow.innerHTML = '<td>' + updateButton + '</td>' +
            '<td class=\"td_nombre\">' + odontologo.nombre + '</td>' +
            '<td class=\"td_apellido\">' + odontologo.apellido + '</td>' +
            '<td class=\"td_matricula\">' + odontologo.matricula + '</td>' +
            '<td>' + deleteButton + '</td>';

        };
      })

  })

    (function () {
      let pathname = window.location.pathname;
      if (pathname == "/listaOdontologo.html") {
        document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


})