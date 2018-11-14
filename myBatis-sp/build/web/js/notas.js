function promedio(idalumno) {
    $.ajax({
        url: "../Notas?accion=PRO&idalumno="+idalumno,
        success: function(data) {
            alert(data);
        }
    });
}

function ins() {
    if(confirm("¿Nuevo Alumno?")) {
        window.location = "notasIns.jsp";
    }
}

function del(idalumno) {
    if(confirm("¿Retirar Alumno?")) {
        window.location = "../Notas?accion=DEL&idalumno="+idalumno;
    }
}

function upd(idalumno) {
    if(confirm("¿Actualizar Alumno?")) {
        window.location = "../Notas?accion=GET&idalumno="+idalumno;
    }
}

function valida() {
    if($("#alumno").val().trim().length == 0) {
        alert("Ingrese Nombre de Alumno");
        return false;
    }

    return true;
}