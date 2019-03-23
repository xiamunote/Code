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

public partial class backwork_DetaildeSuggestion : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            string id = Request["id"];
            SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
            ts.Open();
            SqlDataAdapter sda = new SqlDataAdapter("select * from ConsumerSuggestion where id=" + Request["id"], ts);
            DataSet ds = new DataSet();
            sda.Fill(ds, "ConsumerSuggestion");
            DataRowView rowview = ds.Tables["ConsumerSuggestion"].DefaultView[0];
            this.Label5.Text = rowview["consumer_name"].ToString();
            this.Label6.Text = rowview["email"].ToString();
            this.Label7.Text = rowview["mobile_phone"].ToString();
            this.Label7.Text = rowview["telephone"].ToString();
            this.TextBox1.Text = rowview["suggestion"].ToString();
            
        }
    }
    protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
    {
        Response.Redirect("LookSug.aspx");
    }
}
