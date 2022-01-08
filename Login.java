import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Login extends Frame implements ActionListener 
{
  JLabel lbluser,lblpass;
  JTextField txtuser;
  JPasswordField txtpass;
  JButton btnlogin,btnexit;
  JLabel lblpic;
  ImageIcon img;
  Login()
  {
    setTitle("Login Form");
    setSize(600,300);
    setLayout(null);
    setVisible(true);
    setLocationRelativeTo(null);
    setResizable(false);
    img=new ImageIcon("C:/mus/image/log.jpg");
    lblpic=new JLabel(img);
    lblpic.setBounds(20,10,200,200);
    lbluser=new JLabel("User Name");
    lbluser.setBounds(330,100,170,30);
    lblpass=new JLabel("Password");
    lblpass.setBounds(330,150,170,30);
    txtuser=new JTextField();
    txtuser.setBounds(420,100,150,30);
    txtpass=new JPasswordField();
    txtpass.setBounds(420,150,150,30);
	btnlogin=new JButton("Login");
    btnlogin.setBounds(330,220,100,30);
    btnexit=new JButton("Exit");
    btnexit.setBounds(480,220,100,30);
    add(lbluser);
    add(lblpass);
    add(txtuser);
    add(txtpass);
    add(btnlogin);
    add(btnexit);
    add(lblpic);
	btnlogin.setMnemonic('L');
	btnexit.setMnemonic('E');
    addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e)
    {
      System.exit(0);
	  
   }
});

btnlogin.addActionListener(this);
btnexit.addActionListener(this);

}

public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==btnlogin)
		{
			if(txtuser.getText().equals("aditya") && txtpass.getText().equals("510"))
			{
				JOptionPane.showMessageDialog(null,"Login Successful");
				Welcome w1=new Welcome();
				hide();
			}
			else
			{
			JOptionPane.showMessageDialog(null,"Invalid User Name or Password");	
			txtuser.setText("");
			txtpass.setText("");
			}
		}
	if(ae.getSource()==btnexit)
		{
			System.exit(0);
		}

}

   public static void main(String arg[])
   {
     Login L1=new Login();
   }

}