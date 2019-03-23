function queryBookType() {
    $.ajax({
        url: "/BookType/query.action",
        type: "get",
        dataType: "json",
        success: function (data) {
            $(data).each(function () {
                $("#bookType").append('<option value="' + this.id + '">' + this.typeName + '</option>');
            });
        }
    });
}

function back() {
    window.history.go(-1);
}