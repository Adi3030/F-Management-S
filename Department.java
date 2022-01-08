
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Department extends JFrame implements ActionListener

{
   JButton b1,b2,b3,b4,b5,b6;	
   JLabel lblpic;
   ImageIcon img;
   Department()
   {
      setTitle("Department");
	  setSize(750,700);
	  setLayout(null);
	  setVisible(true);
	  setBackground(Color.RED);
	  setLocationRelativeTo(null);
	  b1=new JButton("ADD");
	  b1.setBounds(10,20,100,30);
	  add(b1);
	  b2=new JButton("MODIFY");
	  b2.setBounds(130,20,100,30);
	  add(b2);
	  b3=new JButton("SEARCH");
	  b3.setBounds(250,20,100,30);
	  add(b3);
	  b4=new JButton("DELETE");
	  b4.setBounds(370,20,100,30);
	  add(b4);
	  b5=new JButton("ALLDEPAT");
	  b5.setBounds(490,20,100,30);
	  add(b5);
	  b6=new JButton("BACK");
	  b6.setBounds(610,20,100,30);
	  add(b6);
	  img=new ImageIcon("c:/mus/image/tmpa640-2etmp-tcm20-163128.jpg");
	  lblpic=new JLabel(img);
	  lblpic.setBounds(100,90,500,500);
	  add(lblpic);
	  b1.addActionListener(this);
	  b2.addActionListener(this);
	  b3.addActionListener(this);
	  b4.addActionListener(this);
	  b5.addActionListener(this);
	  b6.addActionListener(this);	
      }


	public void actionPerformed(ActionEvent ae)
  	{
     		if(ae.getSource()==b1)
		{
			NewDept n1=new NewDept();
			hide();
		}
		if(ae.getSource()==b2)
		{
			ModifyDept n1=new ModifyDept();
			hide();
		}
		if(ae.getSource()==b3)
		{
			SearchDept n1=new SearchDept();
			hide();
		}
		if(ae.getSource()==b4)
		{
			DelDept n1=new DelDept();
			hide();
		}
		if(ae.getSource()==b5)
		{
			SearchResult n1=new SearchResult();
			hide();
		}
		
		if(ae.getSource()==b6)
		{
			MainForm n1=new MainForm();
			hide();
		}
	}
	  public  static void main(String arg[])
	  {
	     Department D1=new Department();
		}
}
		