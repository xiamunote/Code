using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Data.SqlClient;

public partial class backwork_AlterPassword : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        this.uname.Text = Convert.ToString(Session["user_name"]);//获取此时登录的用户名
    }

    private void HashPasswordForStoringInConfigFile(object p, string p_2)
    {
        throw new Exception("The method or operation is not implemented.");
    }
    protected void no_button_Click(object sender, EventArgs e)
    {
        newpw.Text = "";
        surepw.Text = "";
    }
    protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
    {
        string newps = this.newpw.Text.ToString();
        SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
        ts.Open();
        string atpw = FormsAuthentication.HashPasswordForStoringInConfigFile(this.newpw.Text.ToString(), "MD5");
        SqlCommand apw = new SqlCommand("update SystemUser set pass_word='" + atpw + "' where user_name='" + Convert.ToString(Session["user_name"]) + "'", ts);
        apw.ExecuteNonQuery();
        ts.Close();
        Response.Write("<script>alert('密码修改成功！')</script>");
    }
    protected void ImageButton2_Click(object sender, ImageClickEventArgs e)
    {
        newpw.Text = "";
        surepw.Text = "";
    }
}