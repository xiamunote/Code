
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
    <script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="/js/jquery.form.js"></script>
    <script type="text/javascript" src="/js/load.js"></script>
    <script type="text/javascript">
        $(function () {
            selectBookType();
        });

        function selectBookType() {
            $.ajax({
                url: "/BookType/query.action",
                type: "get",
                dataType: "json",
                success: function (data) {
                   var myType= ${bookInfo.bookType.id};

                    $(data).each(function () {
                        if(myType==this.id) {
                            $("#bookType").append('<option selected  value="' + this.id + '">' + this.typeName + '</option>');
                        }else{
                            $("#bookType").append('<option   value="' + this.id + '">' + this.typeName + '</option>');
                        }

                    });
                }
            });
        }

        function uploadImage()
        {
            var  obj={
                url:"/uploadImage.action",
                type:"post",
                dataType:"json",
                success:function (data) {
                    $("#img").attr("src",data);
                    $("#pic").val(data);
                }
            }
            $("#imm").ajaxSubmit(obj);

        }

    </script>
</head>
<body>
<div id="body">
    <div style="margin: 0px auto; width: 500px;">
        <form id="imm" action="/BookInfo/update.action" method="post"  enctype="multipart/form-data" >
            <table border="1px" style="text-align: center;">
                <tr>
                    <td>图书编号</td>
                    <td><input id="code" value="${bookInfo.bookCode}"  readonly name="bookCode" ></td>
                </tr>
                <tr>
                    <td>图书名称</td>
                    <td><input name="bookName" value="${bookInfo.bookName}" ></td>
                </tr>
                <tr>
                    <td>图书分类</td>
                    <td style="text-align: left;">
                        <select id="bookType" name="bookType.id">
                            <option value="0">全部</option>
                        </select>
                        &nbsp;</td>
                </tr>
                <tr>
                    <td>作者</td>
                    <td><input name="bookAuthor" value="${bookInfo.bookAuthor}"></td>
                </tr>
                <tr>
                    <td>出版社</td>
                    <td><input name="publishPress" va value="${bookInfo.publishPress}"></td>
                </tr>
                <tr>
                    <td>出版时间</td>
                    <td><input type="date" name="publishDate" value="${publishDate}" ></td>
                </tr>
                <tr>
                    <td>图片上传</td>
                    <td><img id="img" src="${bookInfo.imagepath}"><!-- 显示图片的 -->
                        <input name="fileImage" type="file" onchange="uploadImage();">
                        <input type="hidden" name="imagepath" id="pic" value="${bookInfo.imagepath}" >
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="提交">
                        <input type="button" value="返回" onclick="back();"></td>

                </tr>
            </table>
        </form>
    </div>


</div>
</body>
</html>
