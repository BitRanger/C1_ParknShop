/**
 * Created by Kaidi on 5/31/2014.
 */

$(".buyerControlItem").click(function() {
    $(".buyerContent").hide();
    $($(this).data("target")).show();
}).mouseenter(function() {
    $(this).css("background-color", "#166496");
}).mouseleave(function() {
    $(this).css("background-color", "#133D58");
});

function confirm_address() {
    var province = document.getElementById("address_div").province.value;
    var city = document.getElementById("address_div").city.value;
    var town = document.getElementById("address_div").town.value;
    var zipcode = document.getElementById("address_div").zipcode.value;
    var street = document.getElementById("address_div").street.value;
    var receiver = document.getElementById("address_div").receiver.value;
    var phonenum = document.getElementById("address_div").phonenum.value;

    $newtr = $("<tr>" +
        "<td>" + receiver + "</td>" +
        "<td>" + province + " " + city + " " + town + "</td>" +
        "<td>" + street + "</td>" +
        "<td>" + zipcode + "</td>" +
        "<td>" + phonenum + "</td>" +
        "<td><a href='#'>Modify</a> <a href='#'>Delete</a></td>");
    $("#saveAddressTable").append($newtr);
}



