<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="/js/jquery.form.js"></script>
    <script type="text/javascript" src="/js/load.js"></script>
    <style type="text/css">
        #div {
            width: 1000px;
            height: 900px;
            margin: 0px auto;
            border: 1px solid red;
        }

    </style>
    <script type="text/javascript">
        <%-- 1.编写ajax加载函数--%>

        $(function () {
            queryBookType();
            query(1);

        });

        function changeBox(check) {
            $("input[name='bookcode']").attr("checked", check);
        }

        function queryByPage() {
            var now = $("#page").val();
            query(now)
        }

        function query(pageNo) {


            $("#tbody").html("");
            $("#tfoot").html("");
            var bookType = $("select[name='book_Type']").val();
            var bookName = $("input[name='bookName']").val();
            var borrow = $("select[name='borrow']").val();
            $.ajax({
                url: "/BookInfo//query.action",
                type: "post",
                dataType: "json",
                data: {"pageNo": pageNo, "bookTypeId": bookType, "bookName": bookName, "borrow": borrow},
                success: function (data) {
                    var size = $(data.list).length;
                    if (size == 0) {
                        $("#tbody").html("<h1 s>暂无数据</h1>");
                        return;
                    }
                    $(data.list).each(function (index) {
                        var borrow = this.isBorrow == 0 ? '未借阅' : '已借阅';
                        $("#tbody").append(' <tr> <td><input type="checkbox" name="bookcode" value="' + this.bookCode + '" > </td> <td>' + this.bookCode + '</td>  <td>' + this.bookType.typeName + '</td>  <td>' + this.bookName + '</td> <td>' + this.bookAuthor + '</td> <td>' + this.publishPress + '</td>   <td>' + this.publishDate + '</td><td><img src="' + this.imagepath + '"> </td> <td>' + borrow + '</td>   <td><a href="/BookInfo/detail.action?code=' + this.bookCode + '">详情</a></td> <td><a href="javascript:deleteByCode(\' ' + this.bookCode + ' \')">删除</a></td><td><a href="/BookInfo/queryUpdate.action?code=' + this.bookCode + '">修改</a></td> </tr>');
                    });

                    $("#tfoot").append('<tr>  <td colspan="11">  <a href="javascript:query(1)">首页</a> <a href="javascript:query(' + (data.pageNum - 1) + ')">上一页</a>  <a href="javascript:query(' + (data.pageNum + 1) + ')">下一页</a> <a href="javascript:query(' + data.pages + ')">末页</a>&nbsp;<span id="pageNow"> ' + data.pageNum + '</span>/' + data.pages + ' &nbsp; <input type="text" id="page">&nbsp;  <button onclick="queryByPage()">go</button> </td>  </tr>');
                }

            });

        }

        function deleteBook() {
            //1.异步删除 选择的图书
            $("#delete").ajaxSubmit();
            //2.异步查询更新后的图书信息
            query(1);
        }

        function deleteByCode(code) {
            var code1 = $.trim(code);
            //1.找到图书编号相同的复选框
            $("input[name='bookcode']").each(function () {
                if (code1 == $(this).val()) {
                    $(this).attr("checked", true);
                    return true;
                }
            });

            deleteBook();
        };

    </script>


</head>
<body>
<div id="div">
    <h1 style="text-align: center;">图书借阅系统</h1>
    <div style="text-align: center;">
        <input type="hidden" value="1">
        图书分类
        <select id="bookType" name="book_Type">
            <option value="0">全部</option>
        </select>&nbsp;

        图书名称<input type="text" name="bookName" value="">&nbsp;
        是否借阅
        <select name="borrow">
            <option value="-1">请选择</option>
            <option value="0">未借阅</option>
            <option value="1">已借阅</option>
        </select>&nbsp;
        <input type="button" value="查询" onclick="query(1);">

        <a href="/add.html">添加</a>
        <button onclick="deleteBook();">批量删除</button>
    </div>
    <hr>
    <div style="margin: 0px auto; width: 1000px;" id="table">
        <form id="delete" action="/BookInfo/delete.action">
            <table border="1px" style="text-align: center; margin: 0px auto">
                <thead>
                <tr>
                    <td><input type="checkbox" onclick="changeBox(this.checked);"></td>
                    <td>图书编号</td>
                    <td>图书分类</td>
                    <td>图书名称</td>
                    <td>作者</td>
                    <td>出版社</td>
                    <td>出版日期</td>
                    <td>图片</td>
                    <td>操作</td>
                    <td>详情</td>
                    <td>删除</td>
                    <td>修改</td>
                </tr>
                </thead>
                <tbody id="tbody">

                </tbody>
                <tfoot id="tfoot">

                </tfoot>
            </table>
        </form>
    </div>
</div>
</body>
</html>
