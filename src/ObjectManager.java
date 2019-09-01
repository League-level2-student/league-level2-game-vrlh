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
double enemySpawnTime = 2000;
int score = 0;
Random randy = new Random();

int trainSpeed = 5;

boolean ramp = false;
int i = 0;

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
    	
    	int length = 50;
    	int rHeight = randy.nextInt(4);
    	int rampChooser = randy.nextInt(3);
    	
    	
    	if (rHeight == 0) {
    		length = 50;
    		ramp = false;
    	}else if (rHeight == 1) {
    		length = 100;
    		ramp = false;
    	}else if (rHeight == 2) {
    		length = 150;
    		if (rampChooser == 0) {
    			ramp = true;
    		}
    	}else if (rHeight == 3) {
    		length = 200;
    		if (rampChooser == 0) {
    			ramp = true;
    		}
    	}
    	
 
    	
            addTrain(new Trains (trainPosition, -length, 50, length, randy.nextInt(3)+trainSpeed, ramp));
            i++;
    		System.out.println("Train: " + i + " Ramp: " + ramp + " Size: " + length);
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
			 if (a.ramp == true) {
				 surfer.isAlive = true;
				surfer.isOnTrain = true;
				System.out.println("Surfer is on train");
				 System.out.println("RAMP");
				 
			 }
			 else if (a.ramp == false) {
             surfer.isAlive = false;
             	if(surfer.isOnTrain == true) {
             	surfer.isAlive = true;
			 }
			 	else if(surfer.isOnTrain == false) {
				 surfer.isAlive = false;
             //System.out.println("NO RAMP");
			 }
					
				}
			 break;
	}
		surfer.isOnTrain = false; 
		//System.out.println("Surfer is not on train");
  }
	
}
void increaseSpeed() {
	
}
}
