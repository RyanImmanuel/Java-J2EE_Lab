package four;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class Market implements ActionListener {	
	JLabel label1   	= new JLabel("Customer Phone: ");
	JTextField phone	= new JTextField(10);
	JLabel label2		= new JLabel("Enter customer id");
	JTextField cid		= new JTextField(10);
	JButton check		= new JButton("Check cid ");
	JLabel label3      	= new JLabel("#1  APPLE 100rs/Kg   #2 Orange 50rs/kg");
	JLabel label4      	= new JLabel("Enter item number you want to purchase ");
	JTextField item_no 	= new JTextField(5);
	JLabel label5		= new JLabel("Quantity kg ");
	JTextField kg		= new JTextField(5);
	JRadioButton rb1	= new JRadioButton("Discount 30%");
	JButton Bill		= new JButton("Bill");
	JTextField am		= new JTextField(20);
	
	HashMap<String,Integer> hm=new HashMap<String,Integer>();
	HashMap<Integer,Double>	item= new HashMap<Integer,Double>();
	void add_coll()
	{
		hm.put("9999",1);
		hm.put("8888",2);
		hm.put("7777",3);
	}
	void add_item()
	{
		item.put(1,100.0);
		item.put(2,50.0);
	}
	
	Market()
	{
		JFrame f1		= new JFrame("CUSTOMER INFORMATION");
		String uname	        = JOptionPane.showInputDialog(null,"Enter USERNAME");
		String psw		= JOptionPane.showInputDialog(null,"Enter PASSWORD");
		add_coll();
		add_item();
		if(uname.equals("admin")&& psw.equals("admin"))
		{
			
			JOptionPane.showMessageDialog(null, "LOGIN VALID");
			f1.setSize(340,300);
			f1.setVisible(true);
			f1.setLayout(new FlowLayout());
			f1.add(label1);
			f1.add(phone);
			f1.add(check);
			f1.add(label2);
			f1.add(cid);
			check.addActionListener(this);
			f1.add(label3);
			f1.add(label4);
			f1.add(item_no);
			f1.add(label5);
			f1.add(kg);
			f1.add(rb1);
			f1.add(Bill);
			Bill.addActionListener(this);
			f1.add(am);			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "LOGIN INVALID");
		}
		
	}

	public static void main(String[] args) {
		Market ob=new Market();	

	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==check)
		{
			String p1=phone.getText();
			if(hm.containsKey(p1))
			{
				JOptionPane.showMessageDialog(null, "OLD CUSTEMER ID DETECTED : "+hm.get(p1));
				cid.setText(Integer.toString(hm.get(p1)));
			}
			else
			{
				hm.put(p1,4);
				JOptionPane.showMessageDialog(null, "NEW CUSTOMER ID : 4");
				cid.setText(Integer.toString(hm.get(p1)));
			}
		}
		
		else
		{
			double amount=0;
			if(item_no.getText().equals("1"))
				amount=100*Integer.parseInt(kg.getText());
			if(item_no.getText().equals("2"))
				amount=50*Integer.parseInt(kg.getText());
			if(rb1.isSelected())
				amount = amount*0.70;
			am.setText("amount: "+amount);
		}

	}
	

}
