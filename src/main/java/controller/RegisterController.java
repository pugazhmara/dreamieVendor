package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import models.RegisterModel;

public class RegisterController {
	String name,pass,email,phone;
	String dbUrl="jdbc:mysql://srv1113.hstgr.io/u222487541_portal";
    String dbUname="u222487541_mara";
    String dbPassword="Hello105@";
    String dbDriver="com.mysql.cj.jdbc.Driver";
    RegisterModel rm;
	public RegisterController(RegisterModel rm){
		this.rm=rm;
	}
	public void toStore(){
		Connection con = null;
   		try{
   			Class.forName(dbDriver);  //class not found exception
 			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception
 			String sql = "insert into VendorTable (username,password,email,phone)"
 					+ "values('"+rm.getName()+"','"+rm.getPass()+"','"+rm.getEmail()+"','"+rm.getPhone()+"')";
 			Statement s = con.createStatement();
 			s.execute(sql);
 		   	con.close();
		 }catch(Exception e){      
			e.printStackTrace();
		 }
	
	
	
	}

}
