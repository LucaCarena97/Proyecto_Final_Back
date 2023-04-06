window.addEventListener('load', function () {

    const formulario = document.querySelector('#nuevo_turno');

    formulario.addEventListener('submit', function (event) {

    event.preventDefault();

        const formData = {
            fechaTurno: document.querySelector('#fechaTurno').value
        };

        const url = '/turno';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)

            .then(function (response) {
                return response.json();
            })

            .then(function (data) {

                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong></strong> Turno agregado </div>';

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();
            })

            .catch(error => {

                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error intente nuevamente</strong> </div>'

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();
            })

    });

    function resetUploadForm() {
        document.querySelector('#fechaTurno').value = "";
        
    }

    (function () {
        let pathname = window.location.pathname;
        if (pathname === "/") {
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/listaTurno.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});