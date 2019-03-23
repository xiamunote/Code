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

public partial class backwork_UpDateStock : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            string id = Request["id"];
            Session["updata_id"] = Convert.ToString(id);
            SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
            ts.Open();
            SqlDataAdapter sda = new SqlDataAdapter("select * from FlightInformation where id="+id, ts);
            DataSet ds = new DataSet();
            sda.Fill(ds, "FlightInformation");
            DataRowView rowview = ds.Tables["FlightInformation"].DefaultView[0];
            this.TextBox1.Text = rowview["starting_date"].ToString();
            this.TextBox2.Text = rowview["arriving_date"].ToString();
            this.TextBox3.Text = rowview["company_type"].ToString();
            this.TextBox4.Text = rowview["flight_type"].ToString();
            this.TextBox5.Text = rowview["bunk_type"].ToString();
            this.TextBox6.Text = rowview["num"].ToString();
            this.TextBox7.Text = rowview["OneWay_price"].ToString();
            this.TextBox8.Text = rowview["starting_city"].ToString();
            this.TextBox9.Text = rowview["terminus_city"].ToString();
            this.TextBox10.Text = rowview["starting_time"].ToString();
            this.TextBox11.Text = rowview["arriving_time"].ToString();
            this.TextBox12.Text = rowview["GoAndBack_price"].ToString();
            this.TextBox13.Text = rowview["starting_airport"].ToString();
            this.TextBox14.Text = rowview["arriving_airport"].ToString();            
            
        }
    }
    protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
    {
        string starting_date = this.TextBox1.Text.ToString();
        string arriving_date = this.TextBox2.Text.ToString();
        string company_type = this.TextBox3.Text.ToString();
        string flight_type = this.TextBox4.Text.ToString();
        string bunk_type = this.TextBox5.Text.ToString();
        string num = this.TextBox6.Text.ToString();
        string OneWay_price = this.TextBox7.Text.ToString();
        string starting_city = this.TextBox8.Text.ToString();
        string terminus_city = this.TextBox9.Text.ToString();
        string starting_time = this.TextBox10.Text.ToString();
        string arriving_time = this.TextBox11.Text.ToString();
        string GoAndBack_price = this.TextBox12.Text.ToString();
        string starting_airport = this.TextBox13.Text.ToString();
        string arriving_airport = this.TextBox14.Text.ToString();
        SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
        ts.Open();
        SqlCommand intable = new SqlCommand("update FlightInformation set company_type='" + company_type + "',starting_city ='" + starting_city + "' ,terminus_city='" + terminus_city + "' ,OneWay_price='" + OneWay_price + "', GoAndBack_price='" + GoAndBack_price + "' ,flight_type='" + flight_type + "', starting_date='" + starting_date + "' ,arriving_date='" + arriving_date + "' ,starting_time='" + starting_time + "' ,arriving_time='" + arriving_time + "',num='" + num + "', bunk_type='" + bunk_type + "',starting_airport='" + starting_airport + "',arriving_airport='" + arriving_airport + "' where id='" + Session["updata_id"] + "'", ts);
        intable.ExecuteNonQuery();
        ts.Close();
        Response.Write("<script language=javascript>alert('更新提交成！')</script>");
    }
}
