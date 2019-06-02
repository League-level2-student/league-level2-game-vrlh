import java.awt.Dimension;
import javax.swing.JFrame;

public class Runner {
	JFrame frame;
	final static int width = 500;
	final static int height = 800;
	RunnerPanel runnerPanel;
public static void main(String[] args) {
	Runner runner = new Runner();
	runner.createUI();
}
public Runner(){
	frame = new JFrame();
	runnerPanel = new RunnerPanel();
}
void createUI() {
	frame.add(runnerPanel);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(width, height);
	
	frame.addKeyListener(runnerPanel);
	
	
	frame.getContentPane().setPreferredSize(new Dimension(width, height));
	frame.pack();
	
	runnerPanel.startGame();
}
}
