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

public partial class backwork_LookOrder : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        this.bind();
    }
    private void bind()
    {
        SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
        //打开数据库连接
        ts.Open();
        //设置SQL语句，查询出所有用户信息
        SqlDataAdapter sda = new SqlDataAdapter("select * from ManageOrder", ts);
        DataSet ds = new DataSet();
        sda.Fill(ds, "ManageOrder");
        //设置GridView控件的数据源
        GridView1.DataSource = ds.Tables["ManageOrder"];
        //将航班信息id设置为GridView主键
        GridView1.DataKeyNames = new string[] { "id" };
        GridView1.DataBind();
    }

   
    protected void GridView1_PageIndexChanging(object sender, GridViewPageEventArgs e)
    {
        GridView1.PageIndex = e.NewPageIndex;
        this.bind();
    }
    protected void GridView1_RowDeleting1(object sender, GridViewDeleteEventArgs e)
    {
        SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
        ts.Open();
        string id = GridView1.DataKeys[e.RowIndex].Value.ToString();
        SqlCommand scd = new SqlCommand("delete from ConsumerOrder  where id=" + id, ts);
        scd.ExecuteNonQuery();
        SqlCommand sed = new SqlCommand("delete from ManageFlightInfor where id="+id,ts);
        sed.ExecuteNonQuery();
        this.bind();//调用bind方法，显示所有用户信息
    }
    protected void GridView1_PageIndexChanging1(object sender, GridViewPageEventArgs e)
    {
        GridView1.PageIndex = e.NewPageIndex;
        this.bind();
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
            if (e.Row.Cells[6].Text == "已处理")
            {
                e.Row.Cells[6].Text = "<font color=blue>已处理</font>";
            }
            else
            {
                e.Row.Cells[6].Text = "<font color=red>未处理</font>";
            }
        }
    }
    protected void GridView1_SelectedIndexChanging(object sender, GridViewSelectEventArgs e)
    {
        string id = this.GridView1.DataKeys[e.NewSelectedIndex].Value.ToString();

        SqlConnection ts = new SqlConnection(System.Configuration.ConfigurationManager.AppSettings["ts"]);
        //打开数据库连接
        ts.Open();
        SqlCommand cmd = new SqlCommand("select try from ManageOrder where id='" + id + "'", ts);

        string count = cmd.ExecuteScalar().ToString();
        if (count == "已处理")
        {
            count = "未处理";
        }
        else
        {
            count = "已处理";
        }
        cmd.CommandText = "update ConsumerOrder set try='" + count + "'where id='" + id + "'";
        cmd.ExecuteNonQuery();
        ts.Close();
        this.bind();
    }
   
    protected void GridView1_RowEditing(object sender, GridViewEditEventArgs e)
    {
        string id = GridView1.DataKeys[e.NewEditIndex].Value.ToString();
        Response.Redirect("DetailedInfor.aspx?id=" + id + "");
    }
}



