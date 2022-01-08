import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class DelDept extends JFrame implements ActionListener

{
   JLabel lblpic;

   JLabel l1,l2,l3,l4,lpic;
   JTextField t1,t2,t3;
   JButton b1,b2;
   ImageIcon img;
   Font f1;
   Connection con;
   Statement st;
   ResultSet rs;
   DelDept()
   {
      	  setTitle("Delete Department");
	  setSize(600,300);
	  setLayout(null);
	  setVisible(true);
	  setLocationRelativeTo(null);
	   setResizable(false);
	   img=new ImageIcon("d:/dv/images/dept1.jpg");
	  lpic=new JLabel(img);
	   lpic.setBounds(320,20,250,250);
		add(lpic);
	  l1=new JLabel("<< Delete Exiting Department >>");
          l1.setBounds(50,20,300,30);
	  add(l1);
	  l2=new JLabel("Department No :");
          l2.setBounds(30,70,100,30);
	  add(l2);
	  f1=new Font("Monotype corsiva", Font.BOLD,20);
	  l1.setFont(f1);
	  
		t1=new JTextField();
          t1.setBounds(160,70,150,30);	
	   add(t1);
	  

	  b1=new JButton("<< delete >>");
          b1.setBounds(40,220,100,30);	
	   add(b1);
	  b2=new JButton("<< Back >>");
          b2.setBounds(160,220,100,30);	
	   add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		

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
		  int i=st.executeUpdate("delete from deparment where deptid="+Integer.parseInt(t1.getText())+"");
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

if(ae.getSource()==b2)
    {
	Department d1=new Department();
	hide();
   }
}




public static void main(String arg[])
{
  DelDept n1=new DelDept();
}
}


	 

