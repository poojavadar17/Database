import java.sql.*;
import java.util.*;
class database
{
public static void main(String args[])
{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("\n Driver class loaded");

Connection Con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:3306:xe","1IAIHXc8Va","TEMA3CTgGO");
System.out.println("\n Connection Created successfully");

Statement stmt=Con.createStatement();

int ch;
Scanner Sc=new Scanner(System.in);
System.out.println("\n 1.Create table \n 2.Insert record \n 3.Update Data \n4.Display Record \n5.Delete Record");
System.out.println("\nEnter choice");
ch=Sc.nextInt();

      switch(ch)
         {
	case 1: ResultSet rs=stmt.executeQuery("Create table Student(Id int,DOJ int,DOB int,name varchar2(20))");
		System.out.println("\n Table created successfully");
		break;

	case 2:ResultSet rs2=stmt.executeQuery("Insert into student values(1,20/02/2017,17/02/1998,'Pooja')");
		System.out.println("\n Record inserted successfully");
		break;

	case 3:ResultSet rs3=stmt.executeQuery("Update student set name='Disha' where ID=1");
		System.out.println("\n Update Record successfully");
		break;

	case 4:ResultSet rs4=stmt.executeQuery("select *from Student");
		while(rs4.next())
		System.out.println("\n ID="+rs4.getInt(1)+"\n DOJ="+rs4.getInt(1)+"\n DOB="+rs4.getInt(1)+"\n name="+rs4.getString(2));
		break;

	case 5:ResultSet rs5=stmt.executeQuery("Delete from student where ID=1");
       		break;

	default:System.out.println("Invalid choice");
	}

        Con.close();

	}
	catch(Exception e)
	     {
		System.out.println(e);
	     }
}
}











