import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Welcome  extends JFrame implements ActionListener
	{
		JLabel lbldelp,lbln,lblname,lblc,lblcourse,lblr,lblrno,lblsub,lblsn,lblsname,lblspost;
		JButton btnnext,btnback,btnproject,btncollege;
		JLabel lblpic ,lblpic1,lblpic2;
		ImageIcon img,img1,img2;
		Font f1;
		//JFrame j1;
		Welcome()
		{		
				setTitle("**Welcome page**");
				setVisible(true);
				setLayout(null);
				setSize(700,700);
				setLocationRelativeTo(null);
				setResizable(false);
				img=new ImageIcon("C:/mus/image/7.jpg");
				lblpic2=new JLabel(img);
				lblpic2.setBounds(1,1,700,100);
				add(lblpic2);
				
				img=new ImageIcon("C:/mus/image/2.jpg");
				lblpic=new JLabel(img);
				lblpic.setBounds(10,330,680,200);
				add(lblpic);
				
				img1=new ImageIcon("C:/mus/image/6.jpg");
				lblpic1=new JLabel(img1);
				lblpic1.setBounds(250,100,200,200);
				add(lblpic1);
				
				lbldelp=new JLabel("Develped By:");
				lbldelp.setBounds(450,520,150,30);
				add(lbldelp);
				
				lbln=new JLabel("Stu Name:-");
				lbln.setBounds(450,550,150,30);
				add(lbln);
				lblname=new JLabel("Aditya Sharma");
				lblname.setBounds(550,550,150,30);
				add(lblname);
				lblc=new JLabel("Stu Course:-");
				lblc.setBounds(450,570,150,30);
				add(lblc);
				lblcourse=new JLabel("Bca 6 Sem.");
				lblcourse.setBounds(550,570,150,30);
				add(lblcourse);
				lblc=new JLabel("Stu RollNo:-");
				lblc.setBounds(450,590,150,30);
				add(lblc);
				lblcourse=new JLabel("169269510");
				lblcourse.setBounds(550,590,150,30);
				add(lblcourse);
				lblsub=new JLabel("Submitted:");
				lblsub.setBounds(100,520,150,30);
				add(lblsub);
				
				lblsn=new JLabel("Name :-");
				lblsn.setBounds(100,550,150,30);
				add(lblsn);
				lblsname=new JLabel("Dr.Sanjeev Tayal");
				lblsname.setBounds(170,550,150,30);
				add(lblsname);
				lblsn=new JLabel(" (HOD-BCA) ");
				lblsn.setBounds(170,565,150,30);
				add(lblsn);
							
				btnproject=new JButton("     PROJECT NAME   : - EMPLOYEE   INFORMATION   SYSTEM    ");
				btnproject.setBounds(70,300,600,30);
				add(btnproject);
				btncollege=new JButton("COLLEGE NAME :- S.D.COLLEGE OF MANAGEMENT STUDIES MZN  ");
				btncollege.setBounds(20,620,500,30);
				add(btncollege);
				
				btnnext=new JButton("<< Next >>");
				btnnext.setBounds(530,620,100,30);
				add(btnnext);
				f1=new Font("Monotype corsiva", Font.BOLD,16);
				btncollege.setFont(f1);
				
				btnproject.setForeground(Color.red);
				btnproject.setBackground(Color.blue);
				lblname.setForeground(Color.yellow);
				btnnext.addActionListener(this);
				addWindowListener(new WindowAdapter()
				{
			public void windowClosing(WindowEvent e)
			{
           System.exit(0);
             }
	});
	
			}
		public void actionPerformed(ActionEvent ae)
			{
			   if(ae.getSource()==btnnext)
			   {
			    MainForm m1=new MainForm();
				 hide();
				  }
				 
						}		
		
			
				  
			
	public static void main(String arg[])
			{
				Welcome w1=new Welcome();
			}
}			