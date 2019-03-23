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
//51aspx源码专家
public partial class ShowOversea : System.Web.UI.Page
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
    private void bind()
    {
        SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
        //打开数据库连接
        ts.Open();
        //设置SQL语句，查询出所有航班信息
        SqlDataAdapter sda = new SqlDataAdapter("select * from FlightInformation order by id desc", ts);
        //创建数据集
        DataSet ds = new DataSet();
        //装载数据集
        sda.Fill(ds, "FlightInformation");
        //数据绑定
        GridView1.DataSource = ds.Tables["FlightInformation"];
        //将航班信息id设置为GridView主键
        GridView1.DataKeyNames = new string[] { "id" };
        GridView1.DataBind();
    }
    protected void GridView1_PageIndexChanging(object sender, GridViewPageEventArgs e)
    {
        GridView1.PageIndex = e.NewPageIndex;
        this.bind();
    }
}
