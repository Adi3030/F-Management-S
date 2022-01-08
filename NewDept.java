import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class NewDept extends JFrame implements ActionListener
{
   JLabel lblpic;
   JLabel l1,l2,l3,l4,lpic;
   JTextField t1,t2,t3;
   JButton b1,b2,b3;
   ImageIcon img;
   Font f1;
   Connection con;
   Statement st;
   ResultSet rs;
   NewDept()
   {
      	  setTitle("New Department");
	  setSize(600,300);
	  setLayout(null);
	  setVisible(true);
	  setLocationRelativeTo(null);
	   setResizable(false);
	   img=new ImageIcon("d:/dv/images/dept1.jpg");
	  lpic=new JLabel(img);
	   lpic.setBounds(320,20,250,250);
		add(lpic);
	  l1=new JLabel("<< Add New Department >>");
          l1.setBounds(50,20,300,30);
	  add(l1);
	  l2=new JLabel("Department No :");
          l2.setBounds(30,70,100,30);
	  add(l2);
	  l3=new JLabel("Department Name :");
          l3.setBounds(30,120,120,30);
	  add(l3);
          l4=new JLabel("salary :");
          l4.setBounds(30,170,100,30);
	  add(l4);
	  f1=new Font("Monotype corsiva", Font.BOLD,20);
	  l1.setFont(f1);
	  

	  t1=new JTextField();
          t1.setBounds(160,70,150,30);	
	   add(t1);
	  t2=new JTextField();
          t2.setBounds(160,120,150,30);	
	   add(t2);
	  t3=new JTextField();
          t3.setBounds(160,170,150,30);	
	   add(t3);


	  b1=new JButton("<< Save >>");
          b1.setBounds(40,220,100,30);	
	   add(b1);
			b2=new JButton("<< Back >>");
          b2.setBounds(160,220,100,30);	
			add(b2);
			b1.addActionListener(this);	
	        b2.addActionListener(this);
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:davdsn");
		st=con.createStatement();
		rs=st.executeQuery("select max(deptid) from deparment");
		if(rs.next())
		{
			int n=rs.getInt(1);
			n++;
			t1.setText(String.valueOf(n));
			t1.setEnabled(false);
		}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		b1.setEnabled(true);

}

public void actionPerformed(ActionEvent ae)
{
   if(ae.getSource()==b1)
    {
      try
	{
		int i=st.executeUpdate("insert into Deparment values("+Integer.parseInt(t1.getText())+",'"+t2.getText()+"','"+t3.getText()+"')");
		if(i>0)
		{
			JOptionPane.showMessageDialog(null,"Record Successfully saved....");
			b1.setEnabled(false);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Record not Successfully saved....");
		}
	}
    catch(Exception e)
	{
		System.out.print(e);
	}
}

if(ae.getSource()==b2)
    {
	Department d1=new Department();
	hide();
   }
}



public static void main(String arg[])
{
  NewDept n1=new NewDept();
}
}


	 

