package exam_swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingCal extends JFrame implements ActionListener {

	JPanel jp1, jp2;
	JTextField jtf;
	JButton[] jbtn = new JButton[16];
	String[] label = {"9", "8", "7",  "+", "6", "5", "4", "-", "3", "2", "1", "*", "C", "0", 
			          "=", "/"};
	
	String cal = "";
	
	public SwingCal() {
		super("cal test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400, 300, 800, 600);	
		
		jtf = new JTextField(70);
		
		jp1 = new JPanel(new FlowLayout());
		jp1.setBackground(Color.CYAN);
		jp1.add(jtf);
		
		jp2 = new JPanel(new GridLayout(4, 4));
		jp2.setBackground(Color.BLACK);		
		
		for(int i=0; i<jbtn.length; i++) {
			jbtn[i] = new JButton(label[i]);
			jp2.add(jbtn[i]);
			jbtn[i].addActionListener(this);
		}
		
		add(jp1, "North");
		add(jp2, "Center");
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new SwingCal();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Object result;
		
		if(e.getActionCommand().equals("=")) {
			try {
				
				result = engine.eval(cal);
				jtf.setText(String.valueOf(result));
			} catch (ScriptException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
		}else if(e.getActionCommand().equals("C")){
			jtf.setText("");
		}else {
			cal += e.getActionCommand();
			jtf.setText(cal);
		}
		
	}
	
}
