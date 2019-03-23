/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-01-16 06:37:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <script type=\"text/javascript\" src=\"/js/jquery-1.8.3.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"/js/jquery.form.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"/js/load.js\"></script>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        #div {\n");
      out.write("            width: 1000px;\n");
      out.write("            height: 900px;\n");
      out.write("            margin: 0px auto;\n");
      out.write("            border: 1px solid red;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        $(function () {\n");
      out.write("            queryBookType();\n");
      out.write("            query(1);\n");
      out.write("\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        function changeBox(check) {\n");
      out.write("            $(\"input[name='bookcode']\").attr(\"checked\", check);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function queryByPage() {\n");
      out.write("            var now = $(\"#page\").val();\n");
      out.write("            query(now)\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function query(pageNo) {\n");
      out.write("\n");
      out.write("\n");
      out.write("            $(\"#tbody\").html(\"\");\n");
      out.write("            $(\"#tfoot\").html(\"\");\n");
      out.write("            var bookType = $(\"select[name='book_Type']\").val();\n");
      out.write("            var bookName = $(\"input[name='bookName']\").val();\n");
      out.write("            var borrow = $(\"select[name='borrow']\").val();\n");
      out.write("            $.ajax({\n");
      out.write("                url: \"/BookInfo//query.action\",\n");
      out.write("                type: \"post\",\n");
      out.write("                dataType: \"json\",\n");
      out.write("                data: {\"pageNo\": pageNo, \"bookTypeId\": bookType, \"bookName\": bookName, \"borrow\": borrow},\n");
      out.write("                success: function (data) {\n");
      out.write("                    var size = $(data.list).length;\n");
      out.write("                    if (size == 0) {\n");
      out.write("                        $(\"#tbody\").html(\"<h1 s>暂无数据</h1>\");\n");
      out.write("                        return;\n");
      out.write("                    }\n");
      out.write("                    $(data.list).each(function (index) {\n");
      out.write("                        var borrow = this.isBorrow == 0 ? '未借阅' : '已借阅';\n");
      out.write("                        $(\"#tbody\").append(' <tr> <td><input type=\"checkbox\" name=\"bookcode\" value=\"' + this.bookCode + '\" > </td> <td>' + this.bookCode + '</td>  <td>' + this.bookType.typeName + '</td>  <td>' + this.bookName + '</td> <td>' + this.bookAuthor + '</td> <td>' + this.publishPress + '</td>   <td>' + this.publishDate + '</td><td><img src=\"' + this.imagepath + '\"> </td> <td>' + borrow + '</td>   <td><a href=\"/BookInfo/detail.action?code=' + this.bookCode + '\">详情</a></td> <td><a href=\"javascript:deleteByCode(\\' ' + this.bookCode + ' \\')\">删除</a></td><td><a href=\"/BookInfo/queryUpdate.action?code=' + this.bookCode + '\">修改</a></td> </tr>');\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                    $(\"#tfoot\").append('<tr>  <td colspan=\"11\">  <a href=\"javascript:query(1)\">首页</a> <a href=\"javascript:query(' + (data.pageNum - 1) + ')\">上一页</a>  <a href=\"javascript:query(' + (data.pageNum + 1) + ')\">下一页</a> <a href=\"javascript:query(' + data.pages + ')\">末页</a>&nbsp;<span id=\"pageNow\"> ' + data.pageNum + '</span>/' + data.pages + ' &nbsp; <input type=\"text\" id=\"page\">&nbsp;  <button onclick=\"queryByPage()\">go</button> </td>  </tr>');\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function deleteBook() {\n");
      out.write("            //1.异步删除 选择的图书\n");
      out.write("            $(\"#delete\").ajaxSubmit();\n");
      out.write("            //2.异步查询更新后的图书信息\n");
      out.write("            query(1);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function deleteByCode(code) {\n");
      out.write("            var code1 = $.trim(code);\n");
      out.write("            //1.找到图书编号相同的复选框\n");
      out.write("            $(\"input[name='bookcode']\").each(function () {\n");
      out.write("                if (code1 == $(this).val()) {\n");
      out.write("                    $(this).attr(\"checked\", true);\n");
      out.write("                    return true;\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            deleteBook();\n");
      out.write("        };\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id=\"div\">\n");
      out.write("    <h1 style=\"text-align: center;\">图书借阅系统</h1>\n");
      out.write("    <div style=\"text-align: center;\">\n");
      out.write("        <input type=\"hidden\" value=\"1\">\n");
      out.write("        图书分类\n");
      out.write("        <select id=\"bookType\" name=\"book_Type\">\n");
      out.write("            <option value=\"0\">全部</option>\n");
      out.write("        </select>&nbsp;\n");
      out.write("\n");
      out.write("        图书名称<input type=\"text\" name=\"bookName\" value=\"\">&nbsp;\n");
      out.write("        是否借阅\n");
      out.write("        <select name=\"borrow\">\n");
      out.write("            <option value=\"-1\">请选择</option>\n");
      out.write("            <option value=\"0\">未借阅</option>\n");
      out.write("            <option value=\"1\">已借阅</option>\n");
      out.write("        </select>&nbsp;\n");
      out.write("        <input type=\"button\" value=\"查询\" onclick=\"query(1);\">\n");
      out.write("\n");
      out.write("        <a href=\"/add.html\">添加</a>\n");
      out.write("        <button onclick=\"deleteBook();\">批量删除</button>\n");
      out.write("    </div>\n");
      out.write("    <hr>\n");
      out.write("    <div style=\"margin: 0px auto; width: 1000px;\" id=\"table\">\n");
      out.write("        <form id=\"delete\" action=\"/BookInfo/delete.action\">\n");
      out.write("            <table border=\"1px\" style=\"text-align: center; margin: 0px auto\">\n");
      out.write("                <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <td><input type=\"checkbox\" onclick=\"changeBox(this.checked);\"></td>\n");
      out.write("                    <td>图书编号</td>\n");
      out.write("                    <td>图书分类</td>\n");
      out.write("                    <td>图书名称</td>\n");
      out.write("                    <td>作者</td>\n");
      out.write("                    <td>出版社</td>\n");
      out.write("                    <td>出版日期</td>\n");
      out.write("                    <td>图片</td>\n");
      out.write("                    <td>操作</td>\n");
      out.write("                    <td>详情</td>\n");
      out.write("                    <td>删除</td>\n");
      out.write("                    <td>修改</td>\n");
      out.write("                </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody id=\"tbody\">\n");
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("                <tfoot id=\"tfoot\">\n");
      out.write("\n");
      out.write("                </tfoot>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
