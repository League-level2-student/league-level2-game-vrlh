import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RunnerPanel extends JPanel implements ActionListener, KeyListener{
Timer timer;
//GameObject gameObject;
final int MENU_STATE = 0;
final int GAME_STATE = 1;
final int END_STATE = 2;
int currentState = MENU_STATE;

Font titleFont;
Font enterFont;
Font spaceFont;

Font endFont;
Font killFont;
Font restartFont;

Surfer surfer = new Surfer(225, 700, 50, 50);

int rX = 250;
int rY = 700;

int aisle = 1;

int timeRecorder = 0;
double nextTime = 500;

public static BufferedImage surferImg;
public static BufferedImage trainImg;
public static BufferedImage rampImg;

ObjectManager objectManager = new ObjectManager(surfer);
void updateMenuState() {
	
}
void updateGameState() {
	//surfer.update();
	objectManager.update();
	objectManager.manageEnemies();
	objectManager.checkCollision();
	objectManager.purgeObjects();
	if(surfer.isAlive == false) {
		currentState++;
	}
	
	
}
void updateEndState() {
	
}
void drawMenuState(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, Runner.width, Runner.height);  
	
	g.setFont(titleFont);
	g.setColor(Color.WHITE);
	g.drawString("Subway Surfer Rip Off", 10, 200);
	
	g.setFont(enterFont);
	g.setColor(Color.WHITE);
	g.drawString("Press ENTER to start", 100, 350);
	
	g.setFont(spaceFont);
	g.setColor(Color.WHITE);
	g.drawString("Press SPACE for instructions", 60, 500);
}
void drawGameState(Graphics g) {
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, Runner.width, Runner.height); 
	
	objectManager.draw(g);
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, Runner.width, Runner.height); 
	
	g.setFont(endFont);
	g.setColor(Color.BLACK);
	g.drawString("GAME OVER", 100, 200);
	
	g.setFont(killFont);
	g.setColor(Color.BLACK);
	g.drawString("Your score is " + timeRecorder, 100, 350);
	
	g.setFont(restartFont);
	g.setColor(Color.BLACK);
	g.drawString("Press ENTER to restart", 80, 500);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	//System.out.println("Action Performed in the Runner Panel");
	repaint();
	//gameObject.update();
	repaint();
	
	  if(currentState == MENU_STATE){
          updateMenuState();
  }else if(currentState == GAME_STATE){
          updateGameState();
          if(surfer.isAlive == true) {
     		 timeRecorder++;
     		if (timeRecorder > nextTime) {
     			nextTime=nextTime+=500;
     			objectManager.enemySpawnTime*=.69;
     			System.out.println("SPEED: " + objectManager.enemySpawnTime);
     			objectManager.trainSpeed +=1;
     		}      		 
     		 System.out.println(timeRecorder);
     	 }
  }else if(currentState == END_STATE){
          updateEndState();
  }
	
	 
}

RunnerPanel(){
	timer = new Timer(1000 / 60, this);
	//gameObject = new GameObject(10, 10, 100, 100);
	titleFont = new Font("Arial", Font.PLAIN, 48);
	enterFont = new Font("Arial", Font.PLAIN, 30);
	spaceFont = new Font("Arial", Font.PLAIN, 30);
	
	endFont = new Font("Arial", Font.PLAIN, 48);
	killFont = new Font("Arial", Font.PLAIN, 30);
	restartFont = new Font("Arial", Font.PLAIN, 30);
	
try {
	surferImg =  ImageIO.read(this.getClass().getResourceAsStream("/image/sufer.png"));
	trainImg =  ImageIO.read(this.getClass().getResourceAsStream("/image/train.png"));
	rampImg = ImageIO.read(this.getClass().getResourceAsStream("/image/ramp.png"));

} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
}
void startGame() {
	timer.start();
}
@Override
public void paintComponent(Graphics g){
	 g.fillRect(10, 10, 100, 100);
	 //gameObject.draw(g);
	  if(currentState == MENU_STATE){
          drawMenuState(g);
  }else if(currentState == GAME_STATE){
          drawGameState(g);
  }else if(currentState == END_STATE) {
          drawEndState(g);
  }
  }
  

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("RunnerPanel Class, keyTyped");
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("RunnerPanel Class, keyPressed");
	if(e.getKeyCode() == KeyEvent.VK_ENTER) {
		currentState++;
		if(currentState > END_STATE){
            currentState = MENU_STATE;
    }
		if(currentState == MENU_STATE) {
			surfer = new Surfer(225, 700, 50, 50);
			objectManager = new ObjectManager (surfer);
			aisle = 1;
			position();
			timeRecorder = 0;
			
		}
	}
	if(e.getKeyCode() == KeyEvent.VK_LEFT) {
		/*rX = rX-surfer.speed;
		surfer.x = rX;*/
		aisle = aisle - 1;
		position();
		
	}if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
		/*rX = rX+surfer.speed;
		surfer.x = rX;*/
		aisle = aisle + 1;
		position();
	}
	
}

void position() {
	if (aisle == 0) {
		surfer.x = 100;
	}if (aisle == 1) {
		surfer.x = 225;
	}if (aisle == 2) {
		surfer.x = 350;
	}if (aisle < 0) {
		aisle = 0;
	}if (aisle > 2) {
		aisle = 2;
	}
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("RunnerPanel Class, keyReleased");
}
}
