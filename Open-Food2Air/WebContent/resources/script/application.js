/*
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
*/
/* 
    Created on : Aug 27, 2019, 11:42:28 AM
    Author     : Zayar Thant
*/
$(document).ready(function () {
    $("#open_btn").click(function (){
        $("#slide_bar").addClass("w3-show");
    });
    $("#close_btn").click(function (){
         $("#slide_bar").removeClass("w3-show");
    });
    $(".submit").click(function(){
    	$(this).closest("form").submit();
    });
    $(".messages").click(function () {
        $(this).hide(1000);
    });
});