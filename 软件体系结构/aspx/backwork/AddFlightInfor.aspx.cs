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

public partial class backwork_AddFlightInfor : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        statedate.Attributes.Add("onfocus", "javascript:calendar()");
        bdate.Attributes.Add("onfocus", "javascript:calendar()");
    }
    protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
    {
        string fc = this.DropDownList1.Text.ToString();
        string sc = this.DropDownList3.Text.ToString();
        string ac = this.backcity.Text.ToString();
        string ap = this.aprice.Text.ToString();
        string bp = this.bprice.Text.ToString();
        string ft = this.DropDownList2.Text.ToString();
        string num = this.num.Text.ToString();
        string sp = this.DropDownList5.Text.ToString();
        string aap = this.DropDownList6.Text.ToString();
        string by = this.DropDownList4.Text.ToString();
        string at = this.atime.Text.ToString();
        string bt = this.btime.Text.ToString();
        string ad = this.statedate.Text.ToString();
        string bd = this.bdate.Text.ToString();
        //连接数据库
        SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
        //打开数据库连接
        ts.Open();
        //初始化查询语句
        SqlCommand it = new SqlCommand("insert into FlightInformation (company_type,num,starting_city,terminus_city,OneWay_price,GoAndBack_price,flight_type,starting_date,arriving_date,starting_time,arriving_time,starting_airport,arriving_airport,bunk_type)values('" + fc + "','" + num + "','" + sc + "','" + ac + "','" + ap + "','" + bp + "','" + ft + "','" + ad + "','" + bd + "','" + at + "','" + bt + "','" + sp + "','" + aap + "','" + by + "')", ts);
        //对SQL Server数据库执行一个transact-SQL语句
        it.ExecuteNonQuery();
        //关闭数据库连接
        ts.Close();
        //弹出java脚本提示信息
        Response.Write("<script language = javascript> alert('提交成功');location='AddFlightInfor.aspx'</script>");
    }
    protected void ImageButton2_Click(object sender, ImageClickEventArgs e)
    {
        backcity.Text = "";
        aprice.Text = "";
        bprice.Text = "";
        atime.Text = "";
        btime.Text = "";
    }
    protected void adate_TextChanged(object sender, EventArgs e)
    {

    }
}



