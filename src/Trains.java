import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Trains extends GameObject{
	int speed = 5;
	Trains(int x, int y, int width, int height, int speed) {
		super(x, y, width, height);
		this.speed = speed;
		// TODO Auto-generated constructor stub
	}

void update() {
	super.update();
	
	y = y+speed;
	
}
void draw(Graphics g) {
	
	g.setColor(Color.YELLOW);
    //g.fillRect(x, y, width, height);
	 g.drawImage(RunnerPanel.trainImg, x, y, width, height, null);
}
}
