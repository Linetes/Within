/*
 * GameStateRunning.java
 * 
 * Copyright 2017 Edgar Daniel Fernández Rodríguez <edgar.fernandez@me.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */

import java.awt.*;
public class GameStateRunning implements GameState {
	
	GameStateContext gc;
	EntityManager entity;
	private int timer = 3600;
	
	public GameStateRunning(GameStateContext gc){
		this.gc = gc;
		entity=new EntityManager();
	}
	
	
	public GameStateContext getGc() {
		return gc;
		
	}


	public void setGc(GameStateContext gc) {
		this.gc = gc;
	}


	public GameStateRunning() {
		// TODO Auto-generated constructor stub
		entity=new EntityManager();
	}

	public void end(){
		gc.setCurrent(gc.getGameOver());
	}
	
	public void pause(){
		gc.setCurrent(gc.getPause());
	}
	
	public void resume(){
		//no pasa nada
	}
	
	public void paint(Graphics g){
		entity.paint(g);
		g.setFont(new Font("Arial", Font.PLAIN,30));
		g.drawString("Vidas: " + entity.getHero().getLives(), 5, 30);
		g.drawString("Enemigos matados: " + entity.getHero().getEnemiesKilled(), 150, 30);
		g.drawString("Time: " +timer/60, 550, 30);
		
	}
	
	public void update(){
		entity.update();
		if(entity.getHero().getLives() == 0){gc.setCurrent(gc.getGameOver());}
		timer--;
		if(timer == 0){gc.setCurrent(gc.getGameOver());}
	}

	@Override
	public void keyboard(int k) {
		
		if(k==5){pause();}
		else{entity.keyboard(k);}
		
	}
	public void keyboardReleased(int k) {
		entity.keyboardReleased(k);
		
	}


	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		
	}


}

