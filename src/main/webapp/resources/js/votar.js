$(document).ready(function() {
	$(".oculto").hide();
    $("button").click(function(event) {  
    	$(".oculto").hide();
        var idPregunta = "pregunta"+event.target.id;
        $("#"+idPregunta).show();
        $("form").show();
        
        $("#nombreTema").val(event.target.id);
    });
});

function updateTextInput(val) {
    document.getElementById('textInput').value=val; 
  }