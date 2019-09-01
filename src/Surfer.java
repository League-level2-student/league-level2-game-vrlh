import java.awt.Color;
import java.awt.Graphics;

public class Surfer extends GameObject{
int speed;
boolean isOnTrain;
	Surfer(int x, int y, int width, int height, boolean isOnTrain) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 5;
		this.isOnTrain = isOnTrain;
	}
void update() {
	super.update();
}
void draw(Graphics g) {
	 g.setColor(Color.BLUE);
     //g.fillRect(x, y, width, height);
	 g.drawImage(RunnerPanel.surferImg, x, y, width, height, null);
}
}
