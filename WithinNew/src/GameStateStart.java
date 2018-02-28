import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;

public class GameStateStart implements GameState {

	GameStateContext gc;
	private Rectangle play;
	private Rectangle about;
	private Rectangle back;
	private String image = "start";
	
	public GameStateStart(){
		play = new Rectangle(355, 70, 340, 150);
		about = new Rectangle(355, 250, 340, 150);
		back = new Rectangle(300, 480, 465, 150);
	}
	@Override
	public void end() {
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGc(GameStateContext gc) {
		this.gc = gc;
		
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(ImageLoader.getInstance().getImage(image), 0, 0, null);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void keyboard(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyboardReleased(int k) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void mouseClicked(int x, int y) {
		if(play.contains(x,y) && image!="about"){
			gc.setCurrent(gc.getRun());
		}
		if(about.contains(x,y)){
			image = "about";
		}
		if(back.contains(x,y)){
			image = "start";
		}
		
	}

}
