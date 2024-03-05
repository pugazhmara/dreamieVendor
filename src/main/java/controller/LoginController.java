package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
   

public class LoginController {
	String email,pass;
	String dbUrl="jdbc:mysql://srv1113.hstgr.io/u222487541_portal";
    String dbUname="u222487541_mara";
    String dbPassword="Hello105@";
    String dbDriver="com.mysql.cj.jdbc.Driver";
	public LoginController(String email,String pass){
		this.email=email;
		this.pass=pass;
	}
	public boolean toStore(){
		 Connection con = null;
	   		try{
	   			Class.forName(dbDriver);  //class not found exception
	 			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception
//	 			String sql = "select * from VendorTable where email='"+email+"' and password='"+pass+"'";	 		
	 		    String sql="SELECT JSON_ARRAYAGG(JSON_OBJECT('username', username, 'email', email,'phone',phone)) from VendorTable";
	 		  
	 			Statement s = con.createStatement();
	 			ResultSet rs=s.executeQuery(sql);
	 			
	 			if(rs.next()) {
	 				System.out.println(rs.getString(1));
//	 				try {
//	 					
//	 				     JSONObject jsonObject = new JSONObject("{\"phonetype\":\"N95\",\"cat\":\"WP\"}");
//	 				}catch (JSONException err){
//	 				     Log.d("Error", err.toString());
//	 				}
	 				con.close();
	 				return true;
	 			}
	 			
	 			con.close();
	 		   	
			 }catch(Exception e){      
				e.printStackTrace();
			 }
	   		return false;
		
	}
	

}
