function CreateSaveController() {
  this.init = function() {
    $(document).ready(function () {
      $("form").on("submit", function (e) {
        e.preventDefault();
    
        var data = new FormData(document.querySelector("form"));
        var object = {};
    
        data.forEach(function (value, key) {
          object[key] = value;
        });
    
        var url = $("form").prop("action");
    
        $.post(url, object, function (response) {
          if (!response.success) {
            alert(`Erro ao realizar requisição, contate o administrador.`)
            return;
          }
          window.location.href = $("form").data("redirect-url");
        }); 
      });
    });
  }
}
var createSaveController;

$(document).ready(function() {
    createSaveController = new CreateSaveController();
    createSaveController.init();
});