import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

class ModifyEmployee extends Frame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6;
JButton b1,btnupdate,btnback;
JTextField t1,t2,t3,t4,t5,t6;
JLabel lblpic;
  ImageIcon img;
Connection con;
  Statement st;
  ResultSet rs;
  ModifyEmployee()
  {
    setTitle("Modify Employee information");
    setSize(500,500);
    setLayout(null);
    setVisible(true);
    setLocationRelativeTo(null);
    setResizable(false);
	img=new ImageIcon("C:/mus/image/employee.jpg");
	lblpic=new JLabel(img);
	lblpic.setBounds(15,20,460,160);
	
	
	l1=new JLabel("Enter Emp. id :");
l1.setBounds (20,180,150,50);
t1=new JTextField();
t1.setBounds(150,190,160,30);
	
					b1=new JButton("Search");
					b1.setBounds(320,190,110,30);
					
add(lblpic);
add(l1);
add(b1);
add(t1);
	


	l2=new JLabel("Employee Name :");
	l2.setBounds (20,220,150,50);
l3=new JLabel("Department :");
l3.setBounds (20,260,150,50);
	l4=new JLabel("Address :");
	l4.setBounds (20,300,150,50);
l5=new JLabel("Contact:");
l5.setBounds (20,340,150,50);
l6=new JLabel("Email:");
l6.setBounds (20,380,150,50);

	


	t2=new JTextField();
	t2.setBounds(150,230,160,30);
		t3=new JTextField();
		t3.setBounds(150,270,160,30);
	t4=new JTextField();
	t4.setBounds(150,310,160,30);
		t5=new JTextField();
		t5.setBounds(150,350,160,30);
		t6=new JTextField();
		t6.setBounds(150,390,160,30);
		btnupdate=new JButton("Update");
				btnupdate.setBounds(30,450,120,30);
				btnback=new JButton("Back");
				btnback.setBounds(180,450,120,30);
						

add(l2);
add(l3);
add(l4);
add(l5);
add(l6);


add(t2);
add(t3);
add(t4);
add(t5);
add(t6);

add(btnupdate);
add(btnback);

btnback.addActionListener(this);
b1.addActionListener(this);	
btnupdate.addActionListener(this);
btnupdate.setEnabled(false);
	
	addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e)
    {
      System.exit(0);
   }
});

}

public void actionPerformed(ActionEvent ae)
{
//==========================================================================================
   if(ae.getSource()==btnback)
   {
	   	Emp e1=new Emp();
		  hide();
	  }
//===========================================================================================	
if(ae.getSource()==b1)
	{
		try
	  	{
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		  con=DriverManager.getConnection("jdbc:odbc:davdsn");
		  st=con.createStatement();
		  rs=st.executeQuery("select * from davemp where empid="+Integer.parseInt(t1.getText())+"");
		  if(rs.next())
		  {
			 t2.setText(rs.getString(2));
			 t3.setText(rs.getString(3));
			 t4.setText(rs.getString(4));
			 t5.setText(rs.getString(5));
			 t6.setText(rs.getString(6));
			 
			b1.setEnabled(false);
			btnupdate.setEnabled(true);
		  }
	  }
	  catch(Exception e)
	  {
		  System.out.print(e);
	  }
	
	}
//=============================================================================================
if(ae.getSource()==btnupdate)
	{
		try
	  	{
			int i=st.executeUpdate("update davemp set empname='"+t2.getText()+"',empdept='"+t3.getText()+"',empadd='"+t4.getText()+"',empemail='"+t5.getText()+"'  where empid="+Integer.parseInt(t1.getText())+"");
			if(i>0)
			{
				JOptionPane.showMessageDialog(null,"Record Updated.....");
				b1.setEnabled(true);
				btnupdate.setEnabled(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Record not found.....");
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
}
				
} 


   public static void main(String arg[])
   {
     ModifyEmployee M1=new ModifyEmployee();
   }
}