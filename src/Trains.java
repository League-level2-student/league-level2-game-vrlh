import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Trains extends GameObject{
	
	Trains(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

void update() {
	super.update();
	
	y = y+5;
	
}
void draw(Graphics g) {
	
	g.setColor(Color.YELLOW);
    g.fillRect(x, y, width, height);
}
}
