import java.awt.Dimension;
import javax.swing.JFrame;

public class Runner {
	JFrame frame;
	final int width = 500;
	final int height = 800;
public static void main(String[] args) {
	Runner runner = new Runner();
	runner.createUI();
}
public Runner(){
	frame = new JFrame();
}
void createUI() {
	
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(width, height);
	
	
}
}
