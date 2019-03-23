﻿using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Drawing;

public partial class backwork_ValiCode : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        string checkcode = CreateRandomCode(4);
        Session["ck"] = checkcode;
        CreateImage(checkcode);
    }
    private string CreateRandomCode(int codecount)//产生4个随机字符方法
    {
        string allchar = "0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
        string[] allchararray = allchar.Split(',');
        string randomcode = "";
        int temp;
        Random rand = new Random();
        for (int i = 0; i < codecount; i++)
        {
            int t = rand.Next(35);
            temp = t;
            randomcode += allchararray[t];
        }
        return randomcode;
    }

    private void CreateImage(string checkcode)//给随机字符加干扰线
    {
        int iwidth = (int)(checkcode.Length * 11.5);
        System.Drawing.Bitmap image = new System.Drawing.Bitmap(iwidth, 20);
        Graphics g = Graphics.FromImage(image);
        Font f = new System.Drawing.Font("Arial", 10, System.Drawing.FontStyle.Bold);
        Brush b = new System.Drawing.SolidBrush(Color.White);
        g.Clear(Color.Red);
        g.DrawString(checkcode, f, b, 3, 3);
        Pen blackpen = new Pen(Color.Blue, 0);
        Random rand = new Random();
        for (int i = 0; i < 4; i++)
        {
            int y = rand.Next(image.Height);
            g.DrawLine(blackpen, 0, y, image.Width, y);
        }
        System.IO.MemoryStream ms = new System.IO.MemoryStream();
        image.Save(ms, System.Drawing.Imaging.ImageFormat.Jpeg);
        Response.ClearContent();
        Response.ContentType = "image/Jpeg";
        Response.BinaryWrite(ms.ToArray());
        g.Dispose();
        image.Dispose();
    }
}
