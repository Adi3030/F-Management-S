import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
class SearchEmployee extends Frame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6;
JButton b1,btnback;
JTextField t1,t2,t3,t4,t5,t6;
JLabel lblpic;
ImageIcon img;
Connection con;
  Statement st;
  ResultSet rs;
  SearchEmployee()
  {
    setTitle("##Search Employee information##");
    setSize(420,550);
    setLayout(null);
    setVisible(true);
    setLocationRelativeTo(null);
    setResizable(false);
	img=new ImageIcon("C:/mus/image/4.jpg");
	lblpic=new JLabel(img);
	lblpic.setBounds(15,5,400,260);
	
	
	l1=new JLabel("Enter Emp. id :");
	l1.setBounds (20,270,150,50);
	t1=new JTextField();
	t1.setBounds(110,280,160,30);
	
					b1=new JButton("Search");
					b1.setBounds(290,280,110,30);
					
add(lblpic);
add(l1);
add(b1);
add(t1);
	


	l2=new JLabel("Employee Name :");
	l2.setBounds (20,310,150,50);
	l3=new JLabel("Department :");
	l3.setBounds (20,350,150,50);
	l4=new JLabel("Address :");
	l4.setBounds (20,390,150,50);
	l5=new JLabel("Contact :");
	l5.setBounds (20,430,150,50);
	l6=new JLabel("email id :");
	l6.setBounds (20,470,150,50);
	t2=new JTextField();
	t2.setBounds(110,320,160,30);
	t3=new JTextField();
	t3.setBounds(110,360,160,30);
	t4=new JTextField();
	t4.setBounds(110,410,160,30);
	t5=new JTextField();
	t5.setBounds(110,450,160,30);
t6=new JTextField();
	t6.setBounds(110,490,160,30);	
		btnback=new JButton("Back");
		btnback.setBounds(290,320,110,30);
					
						

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

add(btnback);

btnback.addActionListener(this);
b1.addActionListener(this);
	
	
	addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e)
    {
      System.exit(0);
   }
});

t2.setEnabled(false);
t3.setEnabled(false);
t4.setEnabled(false);
t5.setEnabled(false);
t6.setEnabled(false);
}

public void actionPerformed(ActionEvent ae)
{
//===========================================================================================
   if(ae.getSource()==btnback)
   {
	   Emp M1=new Emp();
		  hide();
	  }
//===============================================================================================
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
			
			
		  }
		 
		  else
		  {
		  
		  JOptionPane.showMessageDialog(null,"Record not found......");
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
    SearchEmployee S1=new SearchEmployee();
   }
}