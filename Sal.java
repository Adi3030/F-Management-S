
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Sal extends JFrame //implements ActionListener

{
   JButton b1,b2,b3,b4;	
   JLabel lblpic;
   ImageIcon img;
   Sal()
   {
      setTitle("Department");
	  setSize(700,400);
	  setLayout(null);
	  setVisible(true);
	  setBackground(Color.RED);
	  setLocationRelativeTo(null);
	  b1=new JButton("<<  Add Salary   >>");
	  b1.setBounds(10,20,150,30);
	  add(b1);
	  b2=new JButton("<< Search Salary >>");
	  b2.setBounds(180,20,150,30);
	  add(b2);
	  b3=new JButton("<< Salay with leave  >>");
	  b3.setBounds(350,20,200,30);
	  add(b3);
	  
	  b4=new JButton("<< Back  >>");
	  b4.setBounds(570,20,120,30);
	  add(b4);
	  
	  img=new ImageIcon("d:/dv/images/sal.jpg");
	  lblpic=new JLabel(img);
	  lblpic.setBounds(10,50,670,350);
	  add(lblpic);
	  //b1.addActionListener(this);
	  //b2.addActionListener(this);
	  //b3.addActionListener(this);
	  //b4.addActionListener(this);
		
      }


	/*public void actionPerformed(ActionEvent ae)
  	{
     		if(ae.getSource()==b1)
		{
			Salary n1=new Salary();
			hide();
		}
		if(ae.getSource()==b2)
		{
			SearchSalary n1=new SearchSalary();
			hide();
		}
		if(ae.getSource()==b3)
		{
			LeaveSalary n1=new LeaveSalary();
			hide();
		}
		if(ae.getSource()==b4)
		{
			MainForm n1=new MainForm();
			hide();
		}
	}*/
	
	  public  static void main(String arg[])
	  {
	     Sal D1=new Sal();
		}
}
		