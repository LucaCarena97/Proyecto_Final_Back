/*
window.addEventListener('load', function () {

    const formulario = document.querySelector('#form_turno');
    formulario.addEventListener('submit', function (event) {
        
        let turno_id = document.querySelector('#turno_id').value;

        const formData = {
            id: document.querySelector('#turno_id').value,
            fechaTurno: document.querySelector('#fechaTurno').value
        };

        const url = '/turno/update';
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
    const url = '/turno/' + id;
    const settings = {
        method: 'GET'
    }
    fetch(url, settings)

        .then(response => response.json())

        .then(data => {
            let turno = data;
            document.querySelector('#turno_id').value = turno.id;
            document.querySelector('#fechaTurno').value = turno.fechaTurno;
        })
        
        .catch(error => {
            alert("Error: " + error);
        })
}

*/