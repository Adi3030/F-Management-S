import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class ModifyDept extends JFrame implements ActionListener

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
   ModifyDept()
   {
      	  setTitle("Modify Department");
	  setSize(600,300);
	  setLayout(null);
	  setVisible(true);
	  setLocationRelativeTo(null);
	   setResizable(false);
	   img=new ImageIcon("d:/dv/images/dept1.jpg");
	  lpic=new JLabel(img);
	   lpic.setBounds(320,20,250,250);
		add(lpic);
	  l1=new JLabel("<<  Modify Department >>");
          l1.setBounds(50,20,300,30);
	  add(l1);
	  l2=new JLabel("Department No :");
          l2.setBounds(30,70,100,30);
	  add(l2);
	  l3=new JLabel("Department Name :");
          l3.setBounds(30,120,120,30);
	  add(l3);
          l4=new JLabel("course fee :");
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


	  b1=new JButton("<< search >>");
          b1.setBounds(40,220,130,30);	
	   add(b1);
	  b2=new JButton("<< update >>");
          b2.setBounds(180,220,130,30);	
	   add(b2);
	   b3=new JButton("<< Back >>");
          b3.setBounds(330,220,130,30);	
	   add(b3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
	b1.setEnabled(true);

}

public void actionPerformed(ActionEvent ae)
{
   if(ae.getSource()==b1)
    {
      try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		  con=DriverManager.getConnection("jdbc:odbc:davdsn");
		  st=con.createStatement();
		  rs=st.executeQuery("select * from Deparment where deptid="+Integer.parseInt(t1.getText())+"");
		  if(rs.next())
		  {
			 t2.setText(rs.getString(2));
			 t3.setText(rs.getString(3));
			 			
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
	if(ae.getSource()==b2)
	{
		try
	  	{
			int i=st.executeUpdate("update deparment set deptname='"+t2.getText()+"',deptsalary='"+t3.getText()+"'  where deptid="+Integer.parseInt(t1.getText())+"");
			if(i>0)
			{
				JOptionPane.showMessageDialog(null,"Record Updated.....");
				b1.setEnabled(true);
				b2.setEnabled(false);
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


if(ae.getSource()==b3)
    {
	Department d1=new Department();
	hide();
   }
}




public static void main(String arg[])
{
  ModifyDept n1=new ModifyDept();
}
}


	 

