import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class SearchEmpResult extends JFrame implements ActionListener
{
JTextField textbox;
JLabel label;
JButton button,btnback;
JPanel panel;
static JTable table;
DefaultTableModel model;
Connection con;
   Statement st;
   ResultSet rs;

String[] columnNames = {"EMPID", "EMPNAME", "EMPDEPT","EMPADD","EMPCONTACT","EMPEMAIL"};
String empid,empname,empdept,empadd,empcontact,empemail;
 SearchEmpResult()
 {
		setTitle("**database search**");
		setVisible(true);
		setLayout(null);
		setSize(600,600);
		setLocationRelativeTo(null);
		setResizable(false);	
	button=new JButton("search");
	button.setBounds(400,400,150,30);
	btnback=new JButton("back");
	btnback.setBounds(400,430,150,30);
	setLayout(new BorderLayout()); 
	model = new DefaultTableModel();
	model.setColumnIdentifiers(columnNames);
	table = new JTable();
	table.setModel(model); 
	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	table.setFillsViewportHeight(true);
	JScrollPane scroll = new JScrollPane(table);
	scroll.setHorizontalScrollBarPolicy(
	JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
	add(button);
	add(scroll);
	//add(btnback);
	button.addActionListener(this);

 }
 public void actionPerformed(ActionEvent ae)
 {
	 if (ae.getSource()==button)
	 {
		try
		{ 
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		  con=DriverManager.getConnection("jdbc:odbc:davdsn");
		  st=con.createStatement();
		  rs=st.executeQuery("select * from davemp");
		while(rs.next())
		{
		empid = rs.getString(1);
		empname = rs.getString(2);
		empdept= rs.getString(3); 
		empadd=rs.getString(4);
		empcontact=rs.getString(5);
		empemail=rs.getString(6);
		model.addRow(new Object[]{empid,empname,empdept,empadd,empcontact,empemail });
	
		}
	
		}
	catch(Exception e)
	{
		System.out.print(e);
	}
 }}
public static void main(String args[])
{
SearchEmpResult sr = new SearchEmpResult();
 
}
}
