import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

Surfer surfer = new Surfer(250, 700, 50, 50);

int rX = 250;
int rY = 700;

ObjectManager objectManager = new ObjectManager(surfer);
void updateMenuState() {
	
}
void updateGameState() {
	//surfer.update();
	objectManager.update();
}
void updateEndState() {
	
}
void drawMenuState(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, Runner.width, Runner.height);  
	
	g.setFont(titleFont);
	g.setColor(Color.WHITE);
	g.drawString("LEAGUE INVADERS", 25, 200);
	
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
	g.drawString("You killed enemies", 100, 350);
	
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
	}
	if(e.getKeyCode() == KeyEvent.VK_LEFT) {
		rX = rX-surfer.speed;
		surfer.x = rX;
	}if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
		rX = rX+surfer.speed;
		surfer.x = rX;
	}
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("RunnerPanel Class, keyReleased");
}
}
