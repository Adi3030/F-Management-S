import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class MainForm  extends JFrame implements ActionListener 
	{
	JButton btnemp,btnsal,btndept,btnexit,b5,b6,b7;
        JLabel lblpic;
        ImageIcon img;
	MainForm()
	{
		setTitle("**MAIN PAGE**");
		setVisible(true);
		setLayout(null);
		setSize(700,600);
		setLocationRelativeTo(null);
		setResizable(false);
		
               btnemp=new JButton("<< Employee >>");
              btnemp.setBounds(20,450,130,30);
              add(btnemp);
			  
              btnsal=new JButton("<< Salary >>");
              btnsal.setBounds(200,450,120,30);
              add(btnsal);
              btndept=new JButton("<< Deaprtment >>");
              btndept.setBounds(380,450,135,30);
              add(btndept);
              
              btnexit=new JButton("<< Exit >>");
              btnexit.setBounds(540,450,120,30);
              add(btnexit);
              img=new ImageIcon("C:/mus/image/employee1212-768x432.jpg");
              lblpic=new JLabel(img);
              lblpic.setBounds(40,30,600,400);
              add(lblpic);
			  btnemp.addActionListener(this);
			  btnsal.addActionListener(this);
			  btndept.addActionListener(this);
			  btnexit.addActionListener(this);
	}
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==btnemp)
	{
		Emp e1=new Emp();
		hide();
	}
	if(ae.getSource()==btnsal)
	{
		Salary e1=new Salary();
		hide();
	}
	if(ae.getSource()==btndept)
	{
		//Department e1=new Department();
		hide();
	}
	if(ae.getSource()==btnexit)
	{
		//Login e1=new Login();
		hide();
	}
}
public static void main(String arg[])
{
  MainForm m1=new MainForm();
}
}