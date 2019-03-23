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

public partial class OverseaSelect : System.Web.UI.Page
{
    public static string dt;
    public static string week;
    protected void Page_Load(object sender, EventArgs e)
    {
        TextBox1.Attributes.Add("onfocus", "javascript:calendar()");

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

    protected void select_button_Click(object sender, EventArgs e)
    {

        Session["sta"] = this.DropDownList1.Text.ToString();
        Session["arr"] = this.st_city.Text.ToString();
        Session["stdate"] = this.TextBox1.Text.ToString();
        Response.Redirect("ShowDomestic.aspx");
    }
    protected void Calendar1_SelectionChanged(object sender, EventArgs e)
    {
        TextBox1.Text = Calendar1.SelectedDate.ToShortDateString();
        Calendar1.Visible = false;
    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        Calendar1.Visible = true;
    }
}
