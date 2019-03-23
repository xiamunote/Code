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

public partial class domesticselecet : System.Web.UI.Page
{
    public static string dt;
    public static string week;
    protected void Page_Load(object sender, EventArgs e)
    {
        startdate_box.Attributes.Add("onfocus", "javascript:calendar()");

        backdate_box.Attributes.Add("onfocus", "javascript:calendar()");

        string[] selectinf = { "国内机票实时查询", "国外机票", "航班类型：", "出发城市：", "到达城市：", "出发日期：", "返程日期：" };
        dmselect.Text = selectinf[0];
        extra_table.Text = selectinf[1];
        startcity.Text = selectinf[3];
        arrivelcity.Text = selectinf[4];
        startdate.Text = selectinf[5];
        backdate.Text = selectinf[6];
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

        this.bind();

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
    protected void select_button_Click(object sender, ImageClickEventArgs e)
    {
        string start = this.startcity_list.Text;
        
        string arrived = this.arrivelcity_box.Text;

        string startdate_box = this.startdate_box.Text;
        
        if (arrivelcity_box.Text == "")
        {
            Response.Write("<script language = javascript>alert('请确认您填写的信息！');location='DomesticSelecet.aspx'</script>");
        }
        //获取查询条件字符串
        string sql = "select * from FlightInformation where starting_city = '" + start + "' and terminus_city ='" + arrived + "'and starting_date='" + startdate_box + "' order by id desc ";
       
        SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
        ts.Open();
        SqlDataAdapter ss = new SqlDataAdapter(sql, ts);
        DataSet dd = new DataSet();
        ss.Fill(dd, "select");
        GridView1.DataSource = dd.Tables["select"];
        GridView1.DataKeyNames = new string[] { "id" };
        GridView1.DataBind();

    
        
    }

    protected void reset_button_Click(object sender, ImageClickEventArgs e)
    {
        startcity_list.Text = "";
        arrivelcity_box.Text = "";
    }

   
    protected void GridView1_RowDataBound(object sender, GridViewRowEventArgs e)
    {
        if (e.Row.RowType == DataControlRowType.DataRow)
        {
            e.Row.Attributes.Add("OnMouseOver","Color=this.style.backgroundColor;this.style.backgroundColor='lightgrey'");
            e.Row.Attributes.Add("OnMouseOut","this.style.backgroundColor=Color;");
        
        }
    }

    protected void GridView1_PageIndexChanging(object sender, GridViewPageEventArgs e)
    {
        GridView1.PageIndex = e.NewPageIndex;
        this.bind();
    }



    protected void GridView1_RowEditing(object sender, GridViewEditEventArgs e)
    {
        string id = GridView1.DataKeys[e.NewEditIndex].Value.ToString();
        Response.Write("<script>window.open('ManageOrder.aspx?id=" + id + "','','width=500,height=450')</script>");
        Response.Write("<script>location='javascript:history.go(-1)'</script>");
    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        Calendar1.Visible = true;
    }
    protected void Button2_Click(object sender, EventArgs e)
    {
        Calendar2.Visible = true;
    }
    protected void Calendar1_SelectionChanged(object sender, EventArgs e)
    {
        backdate_box.Text = Calendar1.SelectedDate.ToShortDateString();
        Calendar1.Visible = false;
    }
    protected void Calendar2_SelectionChanged(object sender, EventArgs e)
    {
        startdate_box.Text = Calendar2.SelectedDate.ToShortDateString();
        Calendar2.Visible = false;
    }
    protected void suggesttion_button_Click(object sender, EventArgs e)
    {

    }
}

