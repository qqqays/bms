<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<h2>fk aa cd dad das c</h2>

<form>
    <input type="file" required="required" id="img-upload">
    <button type="button" id="upload">upload</button>
</form>

<img src="" id="show">
<script>
    function generalAjax4img(formData, class1, showId) {
        var url = '/uploads';

        $.ajax({
            url: url,
            type: 'POST',
            contentType: false,
            processData: false,
            data: formData,
            success: function (d, s) {
                console.log(d);
                if (showId != '') {
                    var json = JSON.parse(d);

                    var $show = $('#' + showId);

                    $.each(json, function (index, info) {
                        $show.attr('src', info);
                    });
                }
            },
            error: function (d, s) {
                console.log(d + s);
            }
        });
    }

    // 上传图片
    function pushImg(id, alt, title, showId) {

        var formData = new FormData();

        var $x = $('#' + id);

        formData.append('alt', alt);
        formData.append('title', title);

        for (var i = 0; i < $x[0].files.length; i++) {

            var file = $x[0].files[i];

            var reader = new FileReader;

            formData.append('files', file);

            reader.onload = function () {

                var image = new Image();

                image.onload = function () {
                    formData.append('width', this.width);
                    formData.append('height', this.height);

                    generalAjax4img(formData, showId);//上传图片ajax
                };
                image.src = this.result;
            };

            reader.readAsDataURL(file);
        }
    }

    $('document').ready(function () {
        $('#upload').click(function () {
            pushImg('img-upload','','','show')
        });
    });

</script>
</body>
</html>