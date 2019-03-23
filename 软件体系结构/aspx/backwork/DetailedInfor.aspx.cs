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

public partial class backwork_DetailedInfor : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            string id = Request["id"];
            SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
            ts.Open();
            SqlDataAdapter sda = new SqlDataAdapter("select * from ManageOrder where id=" + Request["id"], ts);
            DataSet ds = new DataSet();
            sda.Fill(ds, "ManageOrder");
            DataRowView rowview = ds.Tables["ManageOrder"].DefaultView[0];
            this.Label19.Text = rowview["tdate"].ToString();
            this.Label20.Text = rowview["relationer"].ToString();
            this.Label21.Text = rowview["code"].ToString();
            this.Label22.Text = rowview["email"].ToString();
            this.Label23.Text = rowview["mobile_phone"].ToString();
            this.Label24.Text = rowview["telephone"].ToString();
            this.Label26.Text = rowview["company"].ToString();
            this.Label27.Text = rowview["flighttype"].ToString();
            this.Label28.Text = rowview["bunktype"].ToString();
            this.Label29.Text = rowview["cusmnum"].ToString();
            this.Label30.Text = rowview["onewayprice"].ToString();
            this.Label31.Text = rowview["stacity"].ToString();
            this.Label32.Text = rowview["arrcity"].ToString();
            this.Label33.Text = rowview["startingtime"].ToString();
            this.Label34.Text = rowview["arrivingtime"].ToString();
            this.Label35.Text = rowview["startairport"].ToString();
            this.Label36.Text = rowview["arrivingairport"].ToString();
            this.TextBox1.Text=rowview["address"].ToString();
        }
    }
    protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
    {
        Response.Redirect("LookOrder.aspx");
    }
    protected void ImageButton2_Click(object sender, ImageClickEventArgs e)
    {
       
        string id = Request["id"];
        SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
        ts.Open();
        SqlCommand sda = new SqlCommand("select cusmnum from ManageOrder where id =" + id,ts);
        int num1 = Convert.ToInt32(sda.ExecuteScalar());
        
        SqlCommand sd = new SqlCommand("select num from ManageOrder where id=" + id,ts);
        int num2 = Convert.ToInt32(sd.ExecuteScalar());
        int num3 = num2 - num1;
        
        SqlCommand da = new SqlCommand("select flight_id from ManageOrder where id=" + id, ts);
        int fid = Convert.ToInt32(da.ExecuteScalar());
        
        SqlCommand sdd = new SqlCommand("update FlightInformation set num ='" + num3 + "' where id = " + fid ,ts);
        sdd.ExecuteNonQuery();
        
        SqlCommand ssd = new SqlCommand("select num from FlightInformation where id=" + fid, ts);
        int com=Convert.ToInt32(ssd.ExecuteScalar());
        if (com == num3)
        {
            Response.Write("<script language=javascript>alert('出票成功！')</script>");
        }
        ts.Close();
        
    }
    
}
