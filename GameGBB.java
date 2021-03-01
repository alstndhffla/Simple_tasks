package exam_swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameGBB extends JFrame{
	
	ImageIcon [] img = {
		new ImageIcon("src/images/kawi.jpg"),
		new ImageIcon("src/images/bawi.jpg"),
		new ImageIcon("src/images/bo.jpg")
	};
	
	SelectPanel select = new SelectPanel();
	ResultDisplay resultDisplay = new ResultDisplay();
	
	public GameGBB(){
		super("가위 바위 보 게임");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(resultDisplay, "Center" );
		add(select, "South");
		
		setSize(500,500);
		setVisible(true);
	}
	
	
	class SelectPanel extends JPanel{
		JButton [] btn = new JButton[3];
		public SelectPanel(){
			setBackground(Color.green);
			for(int i=0; i<img.length; i++){
				btn[i] = new JButton(img[i]);
				this.add(btn[i]);
				
				btn[i].addActionListener(new EventHandler());
			}
		}
		
	}
	
	class ResultDisplay extends JPanel{
		JLabel userlb = new JLabel("you");
		JLabel com = new JLabel("computer");
		JLabel result = new JLabel("winner");
		
		public ResultDisplay() {
			setBackground(Color.yellow);
			add(userlb);
			add(result);
			add(com);
		}
		
		public void output(Icon img, Icon comImage, String res){
			userlb.setIcon(img);
			userlb.setHorizontalTextPosition(JLabel.LEFT);
			com.setIcon(comImage);
			result.setText(res);
			result.setForeground(Color.red);
			result.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		}
	}
	
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			JButton btnSrc = (JButton)ae.getSource();
			int selCom = (int)(Math.random()*3); // 0: 가위 , 1: 바위, 2: 보
			
			String res = "";
			
			// user 가 이기는 경우
			if(btnSrc.getIcon() == img[0] && selCom ==2 ||
			   btnSrc.getIcon() == img[1] && selCom ==0 ||
			   btnSrc.getIcon() == img[2] && selCom ==1 )
				res = "당신이 이겼습니다!!";
			else if(btnSrc.getIcon() == img[0] && selCom == 0 ||
					btnSrc.getIcon() == img[1] && selCom == 1 ||
					btnSrc.getIcon() == img[2] && selCom == 2 
					)
				res = "비겼습니다!!!";
			else 
				res = "당신이 졌습니다!!!";
			
			resultDisplay.output(btnSrc.getIcon(), img[selCom], res);
		}
	}
	
	public static void main(String[] args) {
		new GameGBB();

	}

}
