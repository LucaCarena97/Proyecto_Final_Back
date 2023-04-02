window.addEventListener('load', function () {

    const formulario = document.querySelector('#form_paciente');
    formulario.addEventListener('submit', function (event) {
        
        let paciente_id = document.querySelector('#paciente_id').value;

        const formData = {
            id: document.querySelector('#paciente_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            fecha: document.querySelector('#fecha').value
        };

        const url = '/paciente/update';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
        fetch(url, settings)
            .then(response => response.json())

    })
})

function findBy(id) {
    const url = '/paciente/' + id;
    const settings = {
        method: 'GET'
    }
    fetch(url, settings)

        .then(response => response.json())

        .then(data => {
            let paciente = data;
            document.querySelector('#paciente_id').value = paciente.id;
            document.querySelector('#nombre').value = paciente.nombre;
            document.querySelector('#apellido').value = paciente.apellido;
            document.querySelector('#dni').value = paciente.dni;
            document.querySelector('#fecha').value = paciente.fecha;
            document.querySelector('#div_paciente_put').style.display = "block";
        })
        
        .catch(error => {
            alert("Error: " + error);
        })
}