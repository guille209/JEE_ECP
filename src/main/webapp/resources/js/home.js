
function solicitarCodigo() {
	var mensajeCodigo = prompt(
			"Porfavor introduzca el identificador de autorizacion", "");
	if (mensajeCodigo != "") {alert("Hago  un get al servidor");
		$.get( "/JEE_ECP/jsp/eliminarTema", { identificadorAutorizacion: mensajeCodigo } );
	}
	
}