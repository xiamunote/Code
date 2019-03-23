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
public partial class ManageOrder : System.Web.UI.Page
{
    public static int p;
    protected void Page_Load(object sender, EventArgs e)
    {
        //判断是否首次加载
        if (!IsPostBack) 
        {
            string id = Request["id"];
            SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
            ts.Open();
            SqlDataAdapter sda = new SqlDataAdapter("select * from FlightInformation where id=" + Request["id"], ts);
            DataSet ds = new DataSet();
            sda.Fill(ds, "FlightInformation");
            DataRowView rowview = ds.Tables["FlightInformation"].DefaultView[0];
            this.company.Text = rowview["company_type"].ToString();
            this.ftype.Text = rowview["flight_type"].ToString();
            Session["sc"] = rowview["starting_city"].ToString();
            Session["ac"] = rowview["terminus_city"].ToString();
            this.aport.Text = rowview["starting_airport"].ToString();
            this.bport.Text = rowview["arriving_airport"].ToString();
            this.aprice.Text = rowview["OneWay_price"].ToString();
            this.bprice.Text = rowview["GoAndBack_price"].ToString();
            this.at.Text = rowview["starting_time"].ToString();
            this.bt.Text = rowview["arriving_time"].ToString();
            Session["tdate"] = rowview["starting_date"].ToString();
            Session["num0"] = rowview["num"].ToString();
            Session["fid"]=rowview["id"].ToString();
            Session["bunktype"] = rowview["bunk_type"].ToString();
            p = Convert.ToInt32(Session["num0"]);
            date.Text = DateTime.Now.ToLongDateString();
            weekdate.Text = DateTime.Today.DayOfWeek.ToString();
        }

        this.Button2.Attributes.Add("onclick","window.close()");//关闭窗口
    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        Session["fc"] = this.company.Text.ToString();
        Session["ap"] = this.aprice.Text.ToString();
        Session["bp"] = this.bprice.Text.ToString();
        Session["ft"] = this.ftype.Text.ToString();
        Session["num"] = this.num.Text.ToString(); ;
        Session["aap"] = this.aport.Text.ToString();
        Session["bbp"] = this.bport.Text.ToString();
        Session["by"] = this.bunktype.Text.ToString();
        Session["at"] = this.at.Text.ToString();
        Session["bt"] = this.bt.Text.ToString();
        string bunkt = Convert.ToString(Session["by"]);
        int i = Convert.ToInt32(Session["num"]);
        if (!bunkt.Equals(Session["bunktype"]))
        {
            Response.Write("<script>alert('" + Session["by"] + "机票已售空！');window.history.go(-1)</script>");
        }
        if (p < i)
        {
            Response.Write("<script>alert('剩余机票数量不足，建议换乘其他航班！');window.history.go(-1)</script>");
        }
        else
        {
            Response.Write("<script>window.open('OrderForm.aspx?','','width=520,height=500')</script>");
        }
       
    }
}
