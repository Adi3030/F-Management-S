import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

class DeleteEmployee extends Frame implements ActionListener
{
JLabel l1;
JButton b1,b2;
JTextField t1;
JLabel lblpic;
  ImageIcon img;
Connection con;
  Statement st;
  ResultSet rs;

DeleteEmployee()
  {
    setTitle("Delete Employee information");
    setSize(430,480);
    setLayout(null);
    setVisible(true);
    setLocationRelativeTo(null);
    setResizable(false);
	img=new ImageIcon("C:/mus/image/administrator_delete.png");
	lblpic=new JLabel(img);
	lblpic.setBounds(10,5,420,380);
	l1=new JLabel("Enter Emp id :");
l1.setBounds (30,370,150,50);
t1=new JTextField();
	t1.setBounds(120,380,210,30);
	
					b1=new JButton("<< Delete >>");
					b1.setBounds(60,430,120,30);
					b2=new JButton("<< Back >>");
					b2.setBounds(220,430,120,30);
					
					
add(lblpic);
add(l1);
add(b1);
add(t1);
add(b2);

b2.addActionListener(this);
b1.addActionListener(this);
	addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e)
    {
      System.exit(0);
   }
});

}

public void actionPerformed(ActionEvent ae)
{
//============================================================================================   
if(ae.getSource()==b2)
   {
	   Emp M1=new Emp();
		  hide();
	  }
//==================================================================================================
if(ae.getSource()==b1)
	{
		try
	  	{
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		  con=DriverManager.getConnection("jdbc:odbc:davdsn");
		  st=con.createStatement();
		  int i=st.executeUpdate("delete from davemp where empid="+Integer.parseInt(t1.getText())+"");
		if(i>0)
		JOptionPane.showMessageDialog(null,"Record Deleted......");
		else
		JOptionPane.showMessageDialog(null,"Record not found......");
	  }
	  catch(Exception e)
	  {
		  System.out.print(e);
	  }
	
	}

} 
   public static void main(String arg[])
   {
     DeleteEmployee D1=new DeleteEmployee();
   }
}

