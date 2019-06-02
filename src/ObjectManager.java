import java.awt.Graphics;

public class ObjectManager {
Surfer surfer;
ObjectManager (Surfer surfers){
	surfer = surfers;
}
void update() {
	surfer.update();
}
void draw(Graphics g) {
	surfer.draw(g);
}
}
