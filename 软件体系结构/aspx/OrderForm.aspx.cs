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

public partial class OrderForm : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
       
    }
    protected void submit_button_Click(object sender, EventArgs e)
    {
        string rel = this.relator.Text.ToString();
        string ema = this.email.Text.ToString();
        string mph = this.mobilephone.Text.ToString();
        string tph = this.telephone.Text.ToString();
        string add = this.address.Text.ToString();
        string code = this.id.Text.ToString();
        string fc = Convert.ToString(Session["fc"]);
        string ap = Convert.ToString(Session["ap"]);
        string bp = Convert.ToString(Session["bp"]);
        string ft = Convert.ToString(Session["ft"]);
        int num = Convert.ToInt32(Session["num"]);
        string aap = Convert.ToString(Session["aap"]);
        string bbp = Convert.ToString(Session["bbp"]);
        string by = Convert.ToString(Session["by"]);
        string at = Convert.ToString(Session["at"]);
        string bt = Convert.ToString(Session["bt"]);
        string tdate = Convert.ToString(Session["tdate"]);
        string fid = Convert.ToString(Session["fid"]);
        SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
        ts.Open();
        SqlCommand intable = new SqlCommand("insert into ConsumerOrder (address,code,relationer,email,mobile_phone,telephone)values('" + add + "','" + code + "','" + rel + "','" + ema + "','" + mph + "','" + tph + "')", ts);
        intable.ExecuteNonQuery();
        SqlCommand it = new SqlCommand("insert into ManageFlightInfor (company,flighttype,stacity,arrcity,startairport,arrivingairport,onewayprice,backprice,startingtime,arrivingtime,cusmnum,bunktype,tdate,flight_id)values('" + fc + "','" + ft + "','" + Convert.ToString(Session["sc"]) + "','" + Convert.ToString(Session["ac"]) + "','" + aap + "','" + bbp + "','" + ap + "','" + bp + "','" + at + "','" + bt + "','" + num + "','" + by + "','" + tdate + "','" + Convert.ToInt32(fid) + "')", ts);
        it.ExecuteNonQuery();
        ts.Close();
        Response.Write("<script language=javascript>alert('您的订单已提交成功，请耐心等待回复！');window.close()</script>");
    }
}
