$(document).ready(function () {
  let inputsReference = $("input");

  $(".js-editCustomer").on("click", function (e) {
    e.preventDefault();
    $(this).hide();
    $(".js-send-button").removeClass("hiddenBtn");

    inputsReference.each(function (i, input) {
      $(input).removeAttr("readonly");
    });
  });
});
