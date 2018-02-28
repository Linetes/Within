import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MyCanvas extends Canvas implements  Runnable {

	private static final long serialVersionUID = 1L;
	private GameStateContext context;
	volatile boolean running = false;
	private volatile boolean gameOver = false;
	private volatile boolean isPaused = false;
	private Thread animator;
	private Graphics dbg;
	private Image dbImage = null;
	BufferedImage image;

	

	public MyCanvas() {
		super();
		setFocusable(true);
		context=new GameStateContext();
		addKeyListener(context);
		addMouseListener(context);
	}
	BufferedImage im = new BufferedImage(1080,640,BufferedImage.TYPE_INT_RGB);
	public void paint(Graphics g) {
		Graphics b = im.createGraphics();
		b.setColor(Color.GRAY);
		b.fillRect(0,0,1080,640);
		context.paint(b);
		g.drawImage(im, 0, 0, null);
	}
	public void update(Graphics g){
		paint(g);
	}
	private void startGame(){
		if(animator == null || !running){
			animator = new Thread(this);
			animator.start();
		}
	}//startGame()
	
	public void stopGame(){
		running = false;
	}//stopGame()

	@Override
	public void run() {
		running=true;
		while (running) {
			gameupdate();
			gameRender();
			printScreen();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private void gameRender(){
		if(dbImage == null){
			dbImage = createImage(1080,640);
			if(dbImage == null){
				return;
			}
			else{
				dbg = dbImage.getGraphics();
			}
		}
		context.paint(dbg);
	}
	
	private void printScreen(){
		Graphics g = getGraphics();
		if((g != null ) && (dbImage != null)){
			g.drawImage(dbImage, 0, 0, null);
		}
		Toolkit.getDefaultToolkit().sync();
		if(g != null){
			g.dispose();
		}
	}
	
	public void gameupdate(){ //Example of animation running in the back
		context.update();
		
	}
	public synchronized void playSound() 
    {
            new Thread(new Runnable() 
            {
                public void run() 
                {
                    try
                    {
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResource("rsrc/Theme Song.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(inputStream);
                        clip.start(); 
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                    } 
                    catch (Exception e) 
                    {
                        System.err.println(e.getMessage());
                    }
                }
            }).start();
        }
}