import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Employee extends Frame implements ActionListener
{
   JLabel lblmemid,lblname,lbldept,lbladdress,lblcontact,lblemail;
   JTextField txtmemid,txtname,txtaddress,txtcontect,txtemail;
   JButton btnadd,btnsave,btnback;
   
   JComboBox com;
  JLabel lblpic;
  ImageIcon img;
  Connection con;
  Statement st;
  ResultSet rs;
  
  Employee()
  {
    setTitle("Add employee information ");
    setSize(590,620);
    setLayout(null);
    setVisible(true);
    setLocationRelativeTo(null);
    setResizable(false);
	img=new ImageIcon("C:/mus/image/Lib.jpg");
	lblpic=new JLabel(img);
	lblpic.setBounds(1,5,590,370);
	add(lblpic);
	
	lblmemid=new JLabel("Member Id");
	lblmemid.setBounds (40,360,150,50);
	lblname=new JLabel("Member name");
	lblname.setBounds (40,400,150,50);
	lbldept=new JLabel("Department");
	lbldept.setBounds (40,440,100,50);
	com=new JComboBox();
	com.addItem("Bca");
	com.addItem("Bba");
	com.addItem("mca");
	com.addItem("mba");
	com.addItem("mcom");
	com.setBounds (190,450,200,30);
	add(com);
	com.setEnabled(false);

	lbladdress=new JLabel("Address");
	lbladdress.setBounds (40,480,150,50);
	lblcontact=new JLabel("Contact no.");
	lblcontact.setBounds (40,520,150,50);
	lblemail=new JLabel("email id");
	lblemail.setBounds (40,560,150,50);
			txtmemid=new JTextField();
			txtmemid.setEnabled(false);
			txtmemid.setBounds(190,370,200,30);
			txtname=new JTextField();
			txtname.setEnabled(false);
			txtname.setBounds(190,410,200,30);
	
			txtaddress=new JTextField();
			txtaddress.setEnabled(false);
			txtaddress.setBounds(190,490,200,30);
			txtcontect=new JTextField();
			txtcontect.setEnabled(false);
			txtcontect.setBounds(190,530,200,30);
			txtemail=new JTextField();
			txtemail.setEnabled(false);
			txtemail.setBounds(190,570,200,30);
					btnadd=new JButton("Add");
					btnadd.setBounds(430,400,120,30);
					btnsave=new JButton("Save");
					btnsave.setEnabled(false);
					btnsave.setBounds(430,450,120,30);
					btnback=new JButton("Back");
					btnback.setBounds(430,500,120,30);

	add(lblmemid);
	add(lblname);
	add(lbldept);
	add(lbladdress);
	add(lblcontact);
	add(lblemail);
	add(txtmemid);
	add(txtname);
	add(txtaddress);
	add(txtcontect);
	add(txtemail);
	add(btnadd);
	add(btnsave);
	add(btnback);
	
    btnadd.addActionListener(this);
	btnsave.addActionListener(this);
	btnback.addActionListener(this);
	
	 addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e)
    {
      System.exit(0);
   }
    });
		/*try
	  {
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		  con=DriverManager.getConnection("jdbc:odbc:kk");
		  st=con.createStatement();
		  rs=st.executeQuery("select * from department");
		  while(rs.next())
		  {
			com.addItem(rs.getString(1));
		   }
       }
       catch(Exception e)
           {
		System.out.print(e);
			}
      */
}

 public void actionPerformed(ActionEvent ae)
 {
   if(ae.getSource()==btnadd)
   {
	   
	  txtaddress.setEnabled(true);
	  txtaddress.setText("");
	  txtcontect.setEnabled(true);
	  txtcontect.setText("");
	  txtemail.setEnabled(true);
	  txtemail.setText("");
	  txtname.setEnabled(true);
	  txtname.setText("");
	  com.setEnabled(true);
	
	  btnsave.setEnabled(true);
	  btnadd.setEnabled(false);
	  try
	  {
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		  con=DriverManager.getConnection("jdbc:odbc:davdsn");
		  st=con.createStatement();
		  rs=st.executeQuery("select max(empid) from davemp");
		  if(rs.next())
		  {
			  int n=rs.getInt(1);
			  n++;
			  txtmemid.setText(String.valueOf(n));
		  }
	  }
	  catch(Exception e)
	  {
		  System.out.print(e);
	  }

		  
	  }
	  if(ae.getSource()==btnsave)
	  {
		  try
		  {
			  int i=st.executeUpdate("insert into davemp values("+Integer.parseInt(txtmemid.getText())+",'"+txtname.getText()+"','"+com.getSelectedItem()+"','"+txtaddress.getText()+"','"+txtcontect.getText()+"','"+txtemail.getText()+"')");
			  if(i>0)
			  {
				  JOptionPane.showMessageDialog(null,"Record saved.....");
				  btnsave.setEnabled(false);
				  btnadd.setEnabled(true);
				  

				  
			  }
			  else
			  {
				   JOptionPane.showMessageDialog(null,"Record not saved.....");
			  }
		  }
		  catch(Exception e)
		  {
			  System.out.print(e);
		  }
	  }
	  if (ae.getSource()==btnback)
	  {
		  Emp e1=new Emp();
		  hide();
	  }
	  
} 


   public static void main(String arg[])
   {
     Employee M1=new Employee();
   }
}