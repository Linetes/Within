import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		MyWindow mw=new MyWindow();
		//int width=320,height=240;
		mw.setSize(1080,640);
		mw.setVisible(true);
		mw.setTitle("Within");
		mw.setFocusable(true);
		mw.setResizable(false);
		mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mw.setAlwaysOnTop(true);
		mw.playSound();
	}
}
