import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
public class Plataforms extends GameObject {
	private Camera c1;
	private LinkedList<Block> plat = new LinkedList<>();
	
	public Plataforms(Camera c1){
		this.c1 = c1;
		
		plat.add(new Block(0, 500, 1600, 50, Color.WHITE, c1));
		plat.add(new Block(1950, 500, 6000, 50, Color.WHITE, c1));
		plat.add(new Block(1655, 345, 300, 5, Color.WHITE, c1));
		plat.add(new Block(2070, 240, 300, 5, Color.WHITE, c1));
		plat.add(new Block(2470, 91, 180, 5, Color.WHITE, c1));
		plat.add(new Block(2650,-6,900,30, Color.WHITE,c1));
		
	}

	@Override
	public void paint(Graphics g) {
//		for(int i = 0; i < plat.size(); i++){
//			plat.get(i).paint(g);
//		}
		
	}

	@Override
	public void update() {
		for(int i = 0; i < plat.size(); i++){
			plat.get(i).update();
		}
		
	}
	public boolean checkCollision(Rectangle player){
		for(int i = 0; i < plat.size(); i++){
			if(plat.get(i).getRect().intersects(player)){
				return true;
			}
		}
		return false;
	}

}
