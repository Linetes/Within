//import java.awt.Color;
//
//public class EnemyFactory {
//    private Enemy e;
//    private static EnemyFactory instance;
//    
//    public static synchronized EnemyFactory getInstance(){
//    	if(instance == null){
//    	    instance = new EnemyFactory();
//    	}
//    	return instance;
//    }
//    public Enemy getEnemy(int x, int y,int sizeX,int sizeY, Color color){
//    	e = new Enemy(x,y,sizeX,sizeY,color);
//    	return e;
//    	
//    }
//    
//
//}

import java.awt.Color;
import java.util.Random;

public class EnemyFactory {
    private static EnemyFactory instance;
    private Random rand=new Random();
    
    
    public static synchronized EnemyFactory getInstance(){
    	if(instance == null){
    	    instance = new EnemyFactory();
    	}
    	return instance;
    }
    public Enemy getEnemy(Camera cam){
		int  n = rand.nextInt(50) + 1;
		if(n==1) {
			n = rand.nextInt(3) + 1;
			Enemy tmp;
			switch(n) {
				case 1:
					tmp = new Enemy(400,287,50,100,Color.RED,1000,cam);
					return tmp;

				case 2:
					tmp = new Enemy(2600,-200,50,100,Color.RED,800,cam);
					return tmp;

				case 3:
					tmp = new Enemy(4000,287,50,100,Color.RED,1000,cam);
					return tmp;
			}

		}
		return null;
	
    	
    }
    
    

}