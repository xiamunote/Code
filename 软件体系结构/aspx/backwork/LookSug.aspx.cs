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

public partial class backwork_LookSug : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        this.bind();
    }
    private void bind()
    {
        SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
        ts.Open();        //打开数据库连接
        SqlDataAdapter sda = new SqlDataAdapter("select * from ConsumerSuggestion", ts);        //设置SQL语句，查询出所有用户信息
        DataSet ds = new DataSet();
        sda.Fill(ds, "ConsumerSuggestion");
        GridView1.DataSource = ds.Tables["ConsumerSuggestion"];       //设置GridView控件的数据源
        GridView1.DataKeyNames = new string[] { "id" };         //将航班信息id设置为GridView主键
        GridView1.DataBind();
    }


    protected void GridView1_RowDeleting1(object sender, GridViewDeleteEventArgs e)
    {
        SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
        ts.Open();
        string id = GridView1.DataKeys[e.RowIndex].Value.ToString();
        SqlCommand scd = new SqlCommand("delete from ConsumerSuggestion  where id=" + id, ts);
        scd.ExecuteNonQuery();
        this.bind();
    }
    protected void GridView1_PageIndexChanging(object sender, GridViewPageEventArgs e)
    {
        GridView1.PageIndex = e.NewPageIndex;
        this.bind();
    }
    protected void GridView1_RowEditing(object sender, GridViewEditEventArgs e)
    {
        string id = GridView1.DataKeys[e.NewEditIndex].Value.ToString();
        Response.Redirect("DetaildeSuggestion.aspx?id=" + id + "");
    }
    protected void GridView1_RowDataBound(object sender, GridViewRowEventArgs e)
    {
        if (e.Row.RowType == DataControlRowType.DataRow)
        {
            e.Row.Attributes.Add("OnMouseOver", "Color=this.style.backgroundColor;this.style.backgroundColor='lightgrey'");
            e.Row.Attributes.Add("OnMouseOut", "this.style.backgroundColor=Color;");

        }

        if (e.Row.RowType == DataControlRowType.DataRow)
        {
            if (e.Row.Cells[1].Text.Length > 6)
            {
                e.Row.Cells[1].Text = (e.Row.Cells[1].Text).Substring(0,6)+"...";
            }
        }
    }
}
