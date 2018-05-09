<#include "/plot/layout.ftl"/>
<@head>
    <style>
        .body {
            text-align: center;
        }

        .wrapper {
            text-align: center;
        }
    </style>

    <!--ck editor-->
    <script src="/plugin/Ckeditor/ckeditor.js"></script>
</@head>

<@body>
    <video src="https://famous.co/7ba7b98749fb7648346cafeddd7afeb6.mp4" autoplay="autoplay" preload="auto"
           loop="loop"></video>

    <#include "/edit/common/ckeditor.ftl"/>
</@body>

<@javascript>

</@javascript>