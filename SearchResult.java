import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class SearchResult extends JFrame implements ActionListener
{
JTextField textbox;
JLabel label;
JButton button;
JPanel panel;
static JTable table;
DefaultTableModel model;
Connection con;
   Statement st;
   ResultSet rs;

String[] columnNames = {"DEPT ID", "DEPT NAME", "DEPT FEE"};
String deptid,deptname,deptfee;
 SearchResult()
 {
		setTitle("**database search**");
		setVisible(true);
		setLayout(null);
		setSize(700,700);
		setLocationRelativeTo(null);
		setResizable(false);	
	button=new JButton("search");
	button.setBounds(400,400,150,30);
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
		  rs=st.executeQuery("select * from Deparment");
		while(rs.next())
		{
		deptid = rs.getString(1);
		deptname = rs.getString(2);
		deptfee= rs.getString(3); 
		model.addRow(new Object[]{deptid,deptname,deptfee });
	
		}
	
		}
	catch(Exception e)
	{
		System.out.print(e);
	}
	}
  /*if(ae.getSource()==btnback)
	 {
		 Department d=new Department();
		 hide();
	 }
	 */
 }	
	public static void main(String args[])
	{
	SearchResult sr = new SearchResult();
 
	}
}
