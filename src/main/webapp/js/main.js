var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {
    
    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {

        $("#mi-perfil-btn").attr("href","profile.html?username=" + username);

        getGuias(false, "ASC");

        $("#ordenar-ciudad").click(ordenarGuias);
    });
});

async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}

function getGuias(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletGuiaListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                mostrarGuias(parsedResult);
            } else {
                console.log("Error recuperando los datos de los guías");
            }
        }
    });
}
function mostrarGuias(guia_turistas) {

    let contenido = "";

    $.each(guia_turistas, function (index, guia_turista) {

        guia_turista = JSON.parse(guia_turista);


        contenido += '<tr><th scope="row">' + guia_turista.id + '</th>' +
                '<td>' + guia_turista.nombre + '</td>' +
                '<td>' + guia_turista.apellido + '</td>' +
                '<td>' + guia_turista.ciudad + '</td>' +
                '<td>' + guia_turista.zona + '</td>' +
                '<td>' + guia_turista.telefono + '</td>' +
                '<td>' + guia_turista.correo + '</td>';
        contenido += '></td>' +
                '<td><button onclick="reservarGuia(' + guia_turista.id +');" class="btn btn-success" ';
        contenido += '<td>Reservar</button></td></tr>'


    });
    $("#guias-tbody").html(contenido);
}
function ordenarGuias() {

    if ($("#icono-ordenar").hasClass("fa-sort")) {
        getGuias(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort");
        $("#icono-ordenar").addClass("fa-sort-down");
    } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
        getGuias(true, "DESC");
        $("#icono-ordenar").removeClass("fa-sort-down");
        $("#icono-ordenar").addClass("fa-sort-up");
    } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
        getGuias(false, "ASC");
        $("#icono-ordenar").removeClass("fa-sort-up");
        $("#icono-ordenar").addClass("fa-sort");
    }
}
function reservarGuia(id) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletGuiaReservar",
        data: $.param({
            id: id,
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            
            if (parsedResult != false) {

                    location.reload();
            }
            else {
                console.log("Error en la reserva del guía");
            }
        }
    });
}