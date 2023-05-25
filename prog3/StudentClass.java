package threeagain;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class StudentClass implements ActionListener {
	ArrayList<Student> studentList=new ArrayList<Student>();
	JFrame jf1=new JFrame("Student INFO");
	JFrame jf2=new JFrame("Student List");
	JPanel jp1=new JPanel();
	
	JLabel jl1=new JLabel("Enter name: ");
	JTextField jtf1=new JTextField(20);
	JLabel jl2=new JLabel("Enter Age: ");
	JTextField jtf2=new JTextField(20);
	JLabel jl3=new JLabel("Enter sem1: ");
	JTextField jtf3=new JTextField(20);
	JLabel jl4=new JLabel("Enter sem2: ");
	JTextField jtf4=new JTextField(20);
	JLabel jl5=new JLabel("Result: ");
	JTextField jtf5=new JTextField(20);
	
	JTextArea jta1=new JTextArea(200,200);
	JButton jb1=new JButton("Compute");
	JButton jb2=new JButton("Save");
	JButton jb3=new JButton("Display");
	
	StudentClass(){
		jf2.setSize(500,500);
		jf2.add(jta1);
		
		jf1.setSize(350,500);
		jf1.add(jp1);
		
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jl2);
		jp1.add(jtf2);
		jp1.add(jl3);
		jp1.add(jtf3);
		jp1.add(jl4);
		jp1.add(jtf4);
		jp1.add(jl5);
		jp1.add(jtf5);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
		jf2.setVisible(true);
		jf1.setVisible(true);
	}
	
	public static void main(String args[]) {
		StudentClass sc1 = new StudentClass();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1) {
			try {
				int age=Integer.parseInt(jtf2.getText());
				if(age>30 || age<18) {
					JOptionPane.showMessageDialog(jtf2,"enter valid age ");
				}
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(jtf2,"Invalid age");
			}
			
			check(jtf3);
			check(jtf4);
			double avg=CGPAcalc();
			jtf5.setText(Double.toString(avg));
		}
		else if(e.getSource()==jb2) {
			Student s1=new Student(jtf1.getText(),Integer.parseInt(jtf2.getText()),Double.parseDouble(jtf5.getText()));
			studentList.add(s1);
		}
		else {
			jta1.setText(" ");
			for(Student s:studentList) {
				jta1.append(s.printDetails());
				jta1.append("\n");
			}
		}
	}
	
	double CGPAcalc() {
		double v1=Float.parseFloat(jtf3.getText());
		double v2=Float.parseFloat(jtf4.getText());
		return (v1+v2)/2;
	}
	
	void check(JTextField cgpa) {
		try {
			double c=Double.parseDouble(cgpa.getText());
			if(c>10) {
				JOptionPane.showMessageDialog(cgpa,"enter valid cgpa");
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(cgpa,"invalid entry");
		}
	}
		
}
