package exam_swing;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingThreadEx extends JFrame {
	
	JLabel jlb;
	
	public SwingThreadEx() {
		super("Thread 활용");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		jlb = new JLabel("GO");
		jlb.setFont(new Font("Gothic", Font.ITALIC, 50));
		
		TimeThread th = new TimeThread(jlb);
		Thread te = new Thread(th);	
		
		add(jlb);
		
		
		te.start();
		
		
		setSize(300, 200);
		setLocation(600, 400);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new SwingThreadEx();
	}
		
}

class TimeThread implements Runnable {
	JLabel jlb;
	
	public TimeThread(JLabel jlb) {
		this.jlb = jlb;
	}	
	
	@Override
	public void run() {
		int n = 0;
		
		while(true) {
			jlb.setText(""+Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}















