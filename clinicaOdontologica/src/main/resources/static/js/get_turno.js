/*
window.addEventListener('load', function () {

    (function () {
        const url = '/turno/all';
        const settings = {
            method: 'GET'
        }
        fetch(url, settings)

            .then(function (response) {
                return response.json();
            })

            .then(function (data) {

                for (turno of data) {

                    //Mostrando los datos por consola           
                    console.log("odontologo:" + turno.odontologo.id);
                    console.log("odontologo:" + turno.odontologo.nombre);
                    console.log("odontologo:" + turno.paciente.id);
                    
                    var table = document.querySelector("#turnoTable");
                    var turnoRow = table.insertRow();

                    let tr_id = 'tr_' + turno.id;
                    turnoRow.id = tr_id;

                    let updateButton = '<button' +
                        ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                        ' type="button" onclick="findBy(' + turno.id + ')" class="btn btn-info btn_id">' +
                        turno.id +
                        '</button>';

                    let deleteButton = '<button' +
                        ' id=' + '\"' + 'btn_delete_' + turno.id + '\"' +
                        ' type="button" onclick="deleteBy(' + turno.id + ')" class="btn btn-danger btn_delete">' +
                        '&times' +
                        '</button>';

                    turnoRow.innerHTML = '<td>' + updateButton + '</td>' +
                        '<td class=\"td_fechaTurno\">' + turno.fechaTurno + '</td>' +
                        '<td class=\"td_paciente.id\">' + turno.paciente.nombre + '</td>' +
                        '<td class=\"td_odontologo.id\">' + turno.odontologo.nombre + '</td>' +
                        '<td>' + deleteButton + '</td>';

                };
            })
    })

        (function () {
            let pathname = window.location.pathname;
            if (pathname == "/listaTurno.html") {
                document.querySelector(".nav .nav-item a:last").addClass("active");
            }
        })


})
*/