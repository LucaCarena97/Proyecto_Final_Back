function deleteBy(id) {
    //con fetch invocamos a la API de estudiantes con el método DELETE
    //pasandole el id en la URL
    const url = '/odontologo/' + id;
    const settings = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        },
    }
    fetch(url, settings)
        .then(response => response.json())

    //borrar la fila del estudiante eliminado
    let row_id = "#tr_" + id;
    document.querySelector(row_id).remove();

}