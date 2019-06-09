import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Surfer surfer;
ObjectManager (Surfer surfers){
	surfer = surfers;
}
ArrayList<Trains> train = new ArrayList<>();

long enemyTimer = 0;
int enemySpawnTime = 1000;
int score = 0;
Random randy = new Random();

void update() {
	surfer.update();
	for(int i = 0; i < train.size(); i++) {
		train.get(i).update();
	}
}
void draw(Graphics g) {
	surfer.draw(g);
	for(int i = 0; i < train.size(); i++) {
		train.get(i).draw(g);
	}
}
void addTrain(Trains train) {
	this.train.add(train);
}
public void manageEnemies(){
    if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
    	int trainPosition = 1;
    	int rand = randy.nextInt(3);
    	if (rand == 0) {
    		trainPosition = 100;
    	}if (rand == 1) {
    		trainPosition = 225;
    	}if (rand == 2) {
    		trainPosition = 350;
    	}
            addTrain(new Trains (trainPosition, 0, 50, 50));

enemyTimer = System.currentTimeMillis();
    }
}
void purgeObjects() {
	for(int i = 0; i < train.size(); i++) {
		if(train.get(i).height > Runner.height || train.get(i).isAlive == false)  {
			train.remove(i);
		}
	}
	
}
void checkCollision() {
	//System.out.println("ObjectManager, checkCollsision");
	for(Trains a: train) {
		 if(surfer.collisionBox.intersects(a.collisionBox)){
             surfer.isAlive = false;
     }
	}
}
}
