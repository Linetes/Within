import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

public class ImageLoader {
	private Hashtable <String, BufferedImage> images = new Hashtable<String, BufferedImage>();
	private static ImageLoader instance;
	
	 public static synchronized ImageLoader getInstance(){
			if(instance == null){
			    instance = new ImageLoader();
			}
			return instance;
	    }
	private ImageLoader(){
		try {
			images.put("start", ImageIO.read(ImageLoader.class.getResourceAsStream("rsrc/principal.png")));
			images.put("about", ImageIO.read(ImageLoader.class.getResourceAsStream("rsrc/about.png")));
			images.put("over", ImageIO.read(ImageLoader.class.getResourceAsStream("rsrc/gameOver.png")));
			images.put("hero", ImageIO.read(ImageLoader.class.getResourceAsStream("rsrc/png/Jesus/Idle.png")));
			images.put("attack", ImageIO.read(ImageLoader.class.getResourceAsStream("rsrc/attack.png")));
			images.put("background", ImageIO.read(ImageLoader.class.getResourceAsStream("rsrc/fondo.png")));
			images.put("enemy", ImageIO.read(ImageLoader.class.getResourceAsStream("rsrc/png/Enemy/EnemyLeft.png")));
			images.put("atacking", ImageIO.read(ImageLoader.class.getResourceAsStream("rsrc/PowerD.png")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BufferedImage getImage(String k){
		return images.get(k);
	}
	
	public BufferedImage getImageStrip(int x,int y,int height, String name){
		return images.get(name).getSubimage(x*y, 0, y, height);
	}
}
