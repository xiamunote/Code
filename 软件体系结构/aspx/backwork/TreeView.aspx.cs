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

public partial class backwork_login : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        this.Label1.Text =Convert.ToString(Session["user_name"]);
    }
    
    protected void unlogin_b_Click1(object sender, ImageClickEventArgs e)
    {
        Session["user_name"] = "";
        Response.Redirect("../DomesticSelecet.aspx");
    }

}
