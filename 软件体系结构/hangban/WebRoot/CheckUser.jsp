<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="GB2312"%>
<%

		String username = request.getParameter("username");
		
		//		 ��������
    Class.forName("oracle.jdbc.driver.OracleDriver").newInstance()
    ;
    String url = "jdbc:oracle:thin:@localhost:1521:xdf";
    String user = "scott";
    String password = "tiger";
	// ��������
	Connection conn = DriverManager.getConnection(url,user,password);
	Statement st = conn.createStatement();
	String sql = "select * from Userinfo where username = '" + username + "'";
	// ִ������
	ResultSet  rs = st.executeQuery(sql);
	
	if (rs.next()){
		out.print(1);
	}else{
		out.print(0);
	}
	
	// �ͷ���Դ
    rs.close();
	st.close();
    conn.close();
	


%>
