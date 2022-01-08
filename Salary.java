import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class Salary extends JFrame implements ActionListener,FocusListener

{
   JLabel lblpic;
   ImageIcon img;
   JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,lpic,lleave,lgsal;
   JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,tleave,tgsal;
   JButton b1,b2,b3,b5,b4,bgs;
   int bs,ta,da,hra,gs=0;
   Connection con;
   Statement st;
   ResultSet rs;
   Salary()
   {
      setTitle("Salary Details");
	  setSize(750,500);
	  setLayout(null);
	  setVisible(true);
	  setBackground(Color.RED);
	setLocationRelativeTo(null);
	img=new ImageIcon("c:/dv/images/s2.jpg");
	lpic=new JLabel(img);
	lpic.setBounds(350,10,380,390);
	add(lpic);
	 l1=new JLabel("EmpId :");
     l1.setBounds(70,20,400,30);
	 t1=new JTextField();
     t1.setBounds(180,20,150,30);
	 t1.setEnabled(false);	
	  add(l1);
	   add(t1);
      l2=new JLabel("Name :");
      l2.setBounds(70,70,400,30);
      t2=new JTextField();
	  t2.setEnabled(false);
      t2.setBounds(180,70,150,30);
	  add(l2);
	   add(t2);
	   l3=new JLabel("Department id :");
      l3.setBounds(70,120,400,30);
      t3=new JTextField();
      t3.setBounds(180,120,150,30);
	  t3.setEnabled(false);
	  add(l3);
	   add(t3);
	   l9=new JLabel("Department name:");
      l9.setBounds(340,120,400,30);
      t9=new JTextField();
      t9.setBounds(500,120,150,30);
	  t9.setEnabled(false);
	  add(l9);
	   add(t9);
	   l4=new JLabel("Basic Salary :");
      l4.setBounds(70,170,400,30);
      t4=new JTextField();
		t4.setEnabled(false);
      t4.setBounds(180,170,150,30);
	  add(l4);
	   add(t4);
	   l5=new JLabel("TA(8%) :");
      l5.setBounds(70,220,400,30);
      t5=new JTextField();
		t5.setEnabled(false);
      t5.setBounds(180,220,150,30);
	  add(l5);
	   add(t5);
	   l6=new JLabel("DA(15%) :");
      l6.setBounds(70,270,400,30);
      t6=new JTextField();
		t6.setEnabled(false);
      t6.setBounds(180,270,150,30);
	  add(l6);
	   add(t6);
	   l7=new JLabel("HRA(5%) :");
      l7.setBounds(70,320,400,30);
      t7=new JTextField();
		t7.setEnabled(false);
      t7.setBounds(180,320,150,30);
	  add(l7);
	  add(t7);
	l8=new JLabel("Gross Salary :");
	l8.setBounds(70,370,400,30);
	add(l8);
	t8=new JTextField();
	t8.setEnabled(false);
	add(t8);
    t8.setBounds(180,370,150,30);
	b1=new JButton("<< calculate Salary>>");
    b1.setBounds(20,420,120,30);
	add(b1);
    b2=new JButton("<< Save >>");
    b2.setBounds(150,420,120,30);
	b2.setEnabled(false);
	//add(b2);
	b3=new JButton("<< Back >>");
    b3.setBounds(150,420,120,30);
	add(b3);
	b4=new JButton("<< s_depat>>");
    b4.setBounds(300,420,100,30);
	add(b4);
	b5=new JButton("<< sname >>");
    b5.setBounds(490,420,100,30);
	add(b5);
	bgs=new JButton("<< salary given >>");
    bgs.setBounds(600,420,100,30);
	add(bgs);
	lleave=new JLabel("enter leave:");
      lleave.setBounds(340,170,400,30);
      tleave=new JTextField();
      tleave.setBounds(500,170,150,30);
	  //t9.setEnabled(false);
	  add(lleave);
	   add(tleave);
	  lgsal=new JLabel("given salary:");
      lgsal.setBounds(340,220,400,30);
      tgsal=new JTextField();
      tgsal.setBounds(500,220,150,30);
	  //t9.setEnabled(false);
	  add(lgsal);
	   add(tgsal);
	b1.addActionListener(this);
	b4.addActionListener(this);
    b5.addActionListener(this);
	b3.addActionListener(this);
	t4.addFocusListener(this);
	t5.addFocusListener(this);
	t6.addFocusListener(this);
	t7.addFocusListener(this);
	bgs.addActionListener(this);

   }


	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			t1.setEnabled(true);
			//t2.setEnabled(true);
			t3.setEnabled(true);
			t4.setEnabled(true);
			t5.setEnabled(true);
			t6.setEnabled(true);
			t7.setEnabled(true);
			t8.setEnabled(true);
			//t9.setEnabled(true);
		}
		if(ae.getSource()==bgs)
		{
			int gsal =Integer.parseInt(t8.getText());
			System.out.println(gsal);
			int oneday=gsal/30;
			System.out.println(oneday);
			int leaveday=Integer.parseInt(tleave.getText());
			
			int leavesal=gsal-(leaveday*oneday);
			//int amount = gsal - leavesal; 
			tgsal.setText(String.valueOf( leavesal));
			
					
		}
		
		if(ae.getSource()==b4)
		{
			try
	    	{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		  con=DriverManager.getConnection("jdbc:odbc:davdsn");
		  st=con.createStatement();
		  rs=st.executeQuery("select * from deparment where deptid="+Integer.parseInt(t3.getText())+"");
		  
				if(rs.next())
					{
					t9.setText(rs.getString(2));
					t4.setText(rs.getString(3));
			 			
					}
			}
		 
		  
	  
		
			catch(Exception e)
				{
				System.out.print(e);

				}
		
		}
		if(ae.getSource()==b5)
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
				 			
				}
			}
		 
		  		
			catch(Exception e)
			{
			System.out.print(e);

			}
		
		}
		
		if(ae.getSource()==b3)
		{
			MainForm f1=new MainForm();
			hide();
		
		}		
		
		
		
		
		
		

}

public void focusGained(FocusEvent fe)
{
	if(fe.getSource()==t5)
		{
			ta=bs*8/100;
			t5.setText(String.valueOf(ta));
			gs=gs+ta;
			t8.setText(String.valueOf(gs));
		}
	if(fe.getSource()==t6)
		{
			da=bs*15/100;
			t6.setText(String.valueOf(da));
			gs=gs+da;
			t8.setText(String.valueOf(gs));
		}
	if(fe.getSource()==t7)
		{
			hra=bs*5/100;
			t7.setText(String.valueOf(hra));
			gs=gs+hra;
			t8.setText(String.valueOf(gs));
		}
		
}

public void focusLost(FocusEvent fe)
{
		if(fe.getSource()==t4)
		{
			bs=Integer.parseInt(t4.getText());
			gs=gs+bs;
			t8.setText(String.valueOf(gs));
		}
		
			
}

   public static void main(String arg[])
   {
	   Salary s1=new Salary();
   }
}   
	  
	  
	  