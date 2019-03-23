<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="GB2312"%>
<%

		String username = request.getParameter("username");
		
		//		 加载驱动
    Class.forName("oracle.jdbc.driver.OracleDriver").newInstance()
    ;
    String url = "jdbc:oracle:thin:@localhost:1521:xdf";
    String user = "scott";
    String password = "tiger";
	// 建立连接
	Connection conn = DriverManager.getConnection(url,user,password);
	Statement st = conn.createStatement();
	String sql = "select * from Userinfo where username = '" + username + "'";
	// 执行命令
	ResultSet  rs = st.executeQuery(sql);
	
	if (rs.next()){
		out.print(1);
	}else{
		out.print(0);
	}
	
	// 释放资源
    rs.close();
	st.close();
    conn.close();
	


%>
