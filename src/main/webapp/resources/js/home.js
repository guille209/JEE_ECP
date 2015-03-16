
function solicitarCodigo() {
	var mensajeCodigo = prompt(
			"Porfavor introduzca el identificador de autorizacion", "");
	if (mensajeCodigo != "") {
		$.get( "/JEE_ECP/jsp/eliminarTema", { identificadorAutorizacion: mensajeCodigo } );
	}
	
}