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
public partial class ShowDomestic : System.Web.UI.Page
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

        string stdate = Convert.ToString(Session["stdate"]);
        Label1.Text = stdate;
        string sta = Convert.ToString(Session["sta"]);
        string arr = Convert.ToString(Session["arr"]);
        
        string tssql = "select * from FlightInformation where starting_city='" + sta + "' and terminus_city='" + arr + "' and starting_date='" + stdate + "' order by id desc";
        SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
        ts.Open();
        SqlDataAdapter sda = new SqlDataAdapter(tssql, ts);
        DataSet ds = new DataSet();
        sda.Fill(ds, "select");
        GridView1.DataSource = ds.Tables["select"];
        GridView1.DataKeyNames = new string[] { "id" };
        GridView1.DataBind();
    }
    protected void GridView1_RowEditing(object sender, GridViewEditEventArgs e)
    {
        //获取当前行的键(id)值
        string id = GridView1.DataKeys[e.NewEditIndex].Value.ToString();
        //打开新窗口，显示订票的详细信息
        Response.Write("<script>window.open('ManageOrder.aspx?id=" + id + "','','width=500,height=450')</script>");
        Response.Write("<script>location='javascript:history.go(-1)'</script>");
    }
    protected void GridView1_RowDataBound(object sender, GridViewRowEventArgs e)//设置鼠标所在行的样式
    {
        if (e.Row.RowType == DataControlRowType.DataRow)
        {
            e.Row.Attributes.Add("OnMouseOver", "Color=this.style.backgroundColor;this.style.backgroundColor='lightgrey'");
            e.Row.Attributes.Add("OnMouseOut", "this.style.backgroundColor=Color;");

        }
    }
    protected void GridView1_PageIndexChanging(object sender, GridViewPageEventArgs e)
    {
        GridView1.PageIndex = e.NewPageIndex;
    }
}
