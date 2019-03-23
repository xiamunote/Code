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

public partial class Suggest : System.Web.UI.Page
{
    public static string dt;
    public static string week;
    protected void Page_Load(object sender, EventArgs e)
    {
        date.Text = DateTime.Now.ToLongDateString();
        dt = DateTime.Today.DayOfWeek.ToString();
        switch (dt)
        {
            case "Monday":
                week = "星期一";
                break;
            case "Tuesday":
                week = "星期二";
                break;
            case "Wednesday":
                week = "星期三";
                break;
            case "Thursday":
                week = "星期四";
                break;
            case "Friday":
                week = "星期五";
                break;
            case "Saturday":
                week = "星期六";
                break;
            case "Sunday":
                week = "星期日";
                break;
        }
        weekdate.Text = week;
    }
   

    protected void submit_button_Click1(object sender, EventArgs e)
    {
        string inf = this.inform.Text.ToString();
        string rel = this.relator.Text.ToString();
        string ema = this.email.Text.ToString();
        string mph = this.mobilephone.Text.ToString();
        string tph = this.telephone.Text.ToString();
        SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
        ts.Open();
        SqlCommand intable = new SqlCommand("insert into ConsumerSuggestion (suggestion,consumer_name,email,mobile_phone,telephone)values('" + inf + "','" + rel + "','" + ema + "','" + mph + "','" + tph + "')", ts);
        intable.ExecuteNonQuery();
        ts.Close();
        Response.Write("<script language=javascript>alert('提交成功！');location='Suggest.aspx'</script>");
      
    }
}
