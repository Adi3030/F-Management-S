import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Emp extends JFrame implements ActionListener
{
   JButton btnadd,btnmod,btnsearch,btndel,btnback,btnallrecord;	
   JLabel lblpic;
   ImageIcon img;
   Emp()
   {
      setTitle("Employee information");
	  setSize(590,400);
	  setLayout(null);
	  setVisible(true);
	  setBackground(Color.RED);
	  setLocationRelativeTo(null);
	  btnadd=new JButton("Add");
	  btnadd.setBounds(10,20,80,30);
	  add(btnadd);
	  btnmod=new JButton("Modify");
	  btnmod.setBounds(100,20,80,30);
	  add(btnmod);
	  btnsearch=new JButton("Search");
	  btnsearch.setBounds(190,20,80,30);
	  add(btnsearch);
	  btndel=new JButton("Delete");
	  btndel.setBounds(280,20,80,30);
	  add(btndel);
	  btnallrecord=new JButton(" all record");
	  btnallrecord.setBounds(370,20,100,30);
	  add(btnallrecord);
	  btnback=new JButton("Back");
	  btnback.setBounds(480,20,80,30);
	  add(btnback);
	  img=new ImageIcon("C:/mus/image/strong-employee-handbook-640x302.jpg");
	  lblpic=new JLabel(img);
	  lblpic.setBounds(10,30,550,350);
	  add(lblpic);
	   btnadd.addActionListener(this);
	  btnmod.addActionListener(this);
	  btnsearch.addActionListener(this);
	  btndel.addActionListener(this);
	  btnback.addActionListener(this);
	  btnallrecord.addActionListener(this);
		
      }


	public void actionPerformed(ActionEvent ae)
  	{
     		if(ae.getSource()==btnadd)
		{
			Employee n1=new Employee();
			hide();
		}
		if(ae.getSource()==btnmod)
		{
			ModifyEmployee n1=new ModifyEmployee();
			hide();
		}
		if(ae.getSource()==btnsearch)
		{
			SearchEmployee n1=new SearchEmployee();
			hide();
		}
		if(ae.getSource()==btndel)
		{
			DeleteEmployee n1=new DeleteEmployee();
			hide();
		}
		if(ae.getSource()==btnallrecord)
		{
			SearchEmpResult n1=new SearchEmpResult();
			hide();
		}
		if(ae.getSource()==btnback)
		{
			MainForm n1=new MainForm();
			hide();
		}
		
	}
	  public  static void main(String arg[])
	  {
	     Emp D1=new Emp();
		}
}
		