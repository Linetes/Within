import java.awt.BorderLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class MyWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	MyCanvas canvas;
	
	public MyWindow(){
		super();
		setLayout(new BorderLayout());
		
		canvas = new MyCanvas();
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		add(canvas,BorderLayout.CENTER);
		threadExecutor.execute(canvas);
		
		threadExecutor.shutdown();//No funciona
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
//Listo