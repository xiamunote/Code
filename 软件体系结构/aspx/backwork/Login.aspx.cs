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
using System.Drawing;
//51aspx源码专家
public partial class backwork_login : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        
    }

   

    protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
    {
        string un = TextBox1.Text;
        //string pw = TextBox2.Text;
        string pw = FormsAuthentication.HashPasswordForStoringInConfigFile(this.TextBox2.Text.ToString(), "MD5");
        SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
        ts.Open();
        SqlCommand cop = new SqlCommand("select count(*) from SystemUser where user_name = '" + un +"'and pass_word = '" + pw + "'",ts);
        
        int c = Convert.ToInt32(cop.ExecuteScalar());
        if (c == 0)
        {
            Response.Write("<script>alert('用户名密码错误！');history.back()</script>");
        }
        
        else
        {
            if (this.TextBox3.Text.ToLower() != Session["ck"].ToString().ToLower())
            {
                Response.Write("<script>alert('验证码错误！');history.back()</script>");
            }
            else
            {
                Session["user_name"] = un;
                Response.Redirect("TreeView.aspx");
            }
        }
    }
    protected void changeidcode_Click(object sender, EventArgs e)
    {
        this.showidcode.ImageUrl = "ValiCode.aspx";//获取随机字符
    }
    protected void ImageButton2_Click(object sender, ImageClickEventArgs e)
    {
        TextBox1.Text = "";
        TextBox2.Text = "";
        TextBox3.Text = "";
    }
}

