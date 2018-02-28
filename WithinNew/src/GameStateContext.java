import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
public class GameStateContext implements KeyListener, MouseListener{
	
	private ArrayList <GameState> estados = new ArrayList <GameState>();
	private GameState current;
	
	public GameStateContext(){
		estados.add(StateFactory.getInstance().getState(1));
		estados.add(StateFactory.getInstance().getState(2));
		estados.add(StateFactory.getInstance().getState(3));
		estados.add(StateFactory.getInstance().getState(4));
		for(int i = 0;i<estados.size();i++){
			estados.get(i).setGc(this);
		}
		current = estados.get(3);
		
	}
	
	public GameState getRun(){
		return estados.get(0);
	}
	
	public GameState getPause(){
		return estados.get(1);
	}
	
	public GameState getGameOver(){
		return estados.get(2);
	}
	
	public void setCurrent(GameState gs){
		current = gs;
	}
	
	public void end(){
		current.end();
	}
	
	public void resume(){
		current.resume();
	}
	
	public void pause(){
		current.pause();
	}
	
	public void update(){
		current.update();
	}
	
	public void paint(Graphics g){
		current.paint(g);
	}

	@Override
	public synchronized void keyPressed(KeyEvent k) {
		int keyCode = k.getKeyCode();
		if(keyCode == KeyEvent.VK_RIGHT){current.keyboard(1);}
		if(keyCode == KeyEvent.VK_LEFT){current.keyboard(2);}
		if(keyCode == KeyEvent.VK_UP){current.keyboard(3);}
		if(keyCode == KeyEvent.VK_C){current.keyboard(4);}
		if(keyCode == KeyEvent.VK_ESCAPE){current.keyboard(5);}
		
	}

	@Override
	public synchronized void keyReleased(KeyEvent k) {
		int keyCode = k.getKeyCode();
		if(keyCode == KeyEvent.VK_RIGHT){current.keyboardReleased(-1);}
		if(keyCode == KeyEvent.VK_LEFT){current.keyboardReleased(-2);}
		if(keyCode == KeyEvent.VK_UP){current.keyboardReleased(-3);}
		if(keyCode == KeyEvent.VK_C){current.keyboardReleased(-4);}
	//	current.keyboardReleased(r);
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public synchronized void mouseClicked(MouseEvent e) {
		current.mouseClicked(e.getX(),e.getY());
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

