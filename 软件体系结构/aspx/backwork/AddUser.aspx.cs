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

public partial class backwork_AddUser : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
    {
        string un = this.newname.Text.ToString();
        string cp = FormsAuthentication.HashPasswordForStoringInConfigFile(this.TextBox1.Text.ToString(), "MD5");
        SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
        ts.Open();

        SqlCommand sd = new SqlCommand("select count(*) as aa from SystemUser where user_name='" + un + "'", ts);
        //0
        int count = Convert.ToInt32(sd.ExecuteScalar());
        if (count > 0)
        {
            Response.Write("<script>alert('用户已存在');history.back()</script>");

        }

        else
        {
            SqlCommand intable = new SqlCommand("insert into SystemUser(user_name,pass_word)values('" + un + "','" + cp + "')", ts);
            intable.ExecuteNonQuery();
            Response.Write("<script language = javascript>alert('用户创建成功，请记住您的密码！')</script>");
        }
        }
    protected void ImageButton2_Click(object sender, ImageClickEventArgs e)
    {
        newname.Text = "";
        inputpw.Text = "";
        TextBox1.Text = "";
    }
}
