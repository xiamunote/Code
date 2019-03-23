using System;
using System.Data;
using System.Configuration;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Data.SqlClient;

/// <summary>
/// form 的摘要说明
/// </summary>
public class form
{
   static SqlConnection  con;
	public form()
	{
		//
		// TODO: 在此处添加构造函数逻辑
		//
	}
    //执行数据库的添加删除更新操作
    public static bool execSQL(string sql)
    {
        SqlConnection con = createCon();
        con.Open();
        SqlCommand com = new SqlCommand(sql, con);
        try
        {
            com.ExecuteNonQuery();
            con.Close();
        }
        catch (Exception e)
        {
            con.Close();
            return false;
        }
        return true;
    }
    //查找记录是否存在
    public static bool seleSQL(string sql)
    {
        int i;
        SqlConnection con = createCon();
        con.Open();
        SqlCommand com = new SqlCommand(sql, con);
        try
        {
            i = Convert.ToInt32(com.ExecuteScalar());
            con.Close();
        }
        catch (Exception e)
        {
            con.Close();
            return false;
        }
        if (i > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
       

    }
    //返回所有记录
    public static DataSet getDataset(string sql, string table)
    {

        SqlConnection con = createCon();
        con.Open();
        DataSet ds;

        SqlDataAdapter sda = new SqlDataAdapter(sql, con);
        ds = new DataSet();
        sda.Fill(ds, table);
        return ds;
    }
    //返回一条记录
    public static SqlDataReader getRow(string sql)
    {
        SqlConnection con = createCon();
        con.Open();
        SqlCommand com = new SqlCommand(sql, con);
        return com.ExecuteReader();


    }

    public static SqlConnection createCon()
    {
        con = new SqlConnection("Data Source=.;Initial Catalog=TicketSaler;User ID=sa;Password=585858");
        return con;
    }




    public static void seleSQL()
    {
        throw new Exception("The method or operation is not implemented.");
    }
}
