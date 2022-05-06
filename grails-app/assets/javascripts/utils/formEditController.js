function FormEditController() {
  this.init = function () {
    $(document).ready(function () {
      let inputsReference = $("input");

      $(".js-edit").on("click", function (e) {
        e.preventDefault();
        $(this).hide();
        $(".js-send-button").removeClass("hiddenBtn");

        inputsReference.each(function (i, input) {
          $(input).removeAttr("readonly");
        });
      });
    });
  };
}
var formEditController;

$(document).ready(function () {
  formEditController = new FormEditController();
  formEditController.init();
});
