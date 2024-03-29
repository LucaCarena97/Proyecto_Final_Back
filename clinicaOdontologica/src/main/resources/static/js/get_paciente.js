window.addEventListener('load', function () {

    (function () {
        const url = '/paciente/all';
        const settings = {
            method: 'GET'
        }
        fetch(url, settings)

            .then(function (response) {
                return response.json();
            })

            .then(function (data) {

                for (paciente of data) {

                    //Mostrando los datos por consola
                    console.log("nombre:" + paciente.nombre);
                    console.log("fecha:" + paciente.fecha);
                    console.log("fechaDeIngreso:" + paciente.fechaDeIngreso);

                    var table = document.querySelector("#pacienteTable");
                    var pacienteRow = table.insertRow();

                    let tr_id = 'tr_' + paciente.id;
                    pacienteRow.id = tr_id;

                    let updateButton = '<button' +
                        ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                        ' type="button" onclick="findBy(' + paciente.id + ')" class="btn btn-info btn_id">' +
                        paciente.id +
                        '</button>';

                    let deleteButton = '<button' +
                        ' id=' + '\"' + 'btn_delete_' + paciente.id + '\"' +
                        ' type="button" onclick="deleteBy(' + paciente.id + ')" class="btn btn-danger btn_delete">' +
                        '&times' +
                        '</button>';

                    pacienteRow.innerHTML = '<td>' + updateButton + '</td>' +
                        '<td class=\"td_nombre\">' + paciente.nombre + '</td>' +
                        '<td class=\"td_apellido\">' + paciente.apellido + '</td>' +
                        '<td class=\"td_dni\">' + paciente.dni + '</td>' +
                        '<td class=\"td_fechaDeIngreso\">' + paciente.fechaDeIngreso + '</td>' +
                        '<td>' + deleteButton + '</td>';

                };
            })
    })

        (function () {
            let pathname = window.location.pathname;
            if (pathname == "./listaPaciente.html") {
                document.querySelector(".nav .nav-item a:last").addClass("active");
            }
        })


})