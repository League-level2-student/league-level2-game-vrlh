import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class RunnerPanel extends JPanel implements ActionListener{
Timer timer;

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Action Performed in the Runner Panel");
}

RunnerPanel(){
	timer = new Timer(1000 / 60, this);
	
}
}
