<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<html>
<head>
    <title>详细</title>
    <script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
<div id="body">
    <div style="margin: 0px auto; width: 500px;">

            <table border="1px" style="text-align: center;">
                <tr>
                    <td>图书编号</td>
                    <td> ${bookInfo.bookCode}  </td>
                </tr>
                <tr>
                    <td>图书名称</td>
                    <td>${bookInfo.bookName}</td>
                </tr>
                <tr>
                    <td>图书分类</td>
                    <td style="text-align: left;">
                    ${bookInfo.bookType.typeName}
                    </td>
                </tr>
                <tr>
                    <td>作者</td>
                    <td>${bookInfo.bookAuthor}</td>
                </tr>
                <tr>
                    <td>出版社</td>

                </tr>
                <tr>
                    <td>出版时间</td>
                    <td>${bookInfo.publishDate}</td>
                </tr>
                <tr>
                    <td>图片上传</td>  <td>${bookInfo.publishPress}</td>
                    <td><img id="img" src="${bookInfo.imagepath}"><!-- 显示图片的 -->

                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input  onclick="back();" type="button" value="返回"> </td>

                </tr>
            </table>

    </div>


</div>

</body>
</html>
