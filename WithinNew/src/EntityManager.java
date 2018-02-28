///*
//* Actualizado el 27/octubre/2017 16:45 hrs
// */
//import java.awt.Color;
//import java.awt.Graphics;
//import java.util.ArrayList;
//
//public class EntityManager {
//	
//	GameStateContext gc;
//	private Hero hero;
//	private ArrayList<Enemy> enemigos = new ArrayList<Enemy>();
//	private ArrayList<Block> pisos = new ArrayList<Block>();
//	private Block piso;
//	private Block piso2;
//	private Block col;
//	private ImageLoader img = ImageLoader.getInstance();
//	private BackGround bd;
//	private Camera cam;
//	private Plataforms plat;
//	Enemy go;
//	
//	
//	
//	public EntityManager() {
//		
//		this.hero = new Hero(200, 200);
//
//		Enemy tmp = EnemyFactory.getInstance().getEnemy(400,287,50,100,Color.RED);
//		//TODO corregir size
//		enemigos.add(tmp);
//		cam = new Camera(hero);
//		this.piso = new Block(0,500,1600,50,Color.WHITE, cam);
//		this.piso2 = new Block(1950,500,1600,50,Color.WHITE, cam);
//		pisos.add(piso); pisos.add(piso2);
//		this.col = new Block(2650,70,50,500,Color.WHITE, cam);
//		bd = new BackGround(cam);
//		plat = new Plataforms(cam);
//	}
//	
//	public void paint(Graphics g){
//		bd.paint(g);
//		hero.paint(g);
//		plat.paint(g);
////		for(int i = 0; i<enemigos.size();i++){
////			go = enemigos.get(i);
////			go.paint(g);	
////		}
//	}
//	
//	public void update(){
//		plat.update();
//		hero.update();
//		piso.update();
//		piso2.update();
//		col.update();
//		cam.update();
//		bd.update();
//		for(int i = 0; i<enemigos.size();i++){
//			go = enemigos.get(i);
//			go.update();
//			
//		}
//		checkCollision();
//		checkCollisionPiso();
//		checkCollisionPared();
//	}
//	
//	public void keyboard(int k){
//			hero.move(k);
//	}
//	public void keyboardReleased(int k){
//		hero.move(k);
//	}
//	public void checkCollision(){
//		for(int i = 0; i<enemigos.size();i++){
//			go = enemigos.get(i);
//			if(hero.rect.intersects(go.getRect())){
//				go.setMoveX(-1*go.getMoveX());
//				//hero.setOffx(0);
//			}
//			
//			
//		}
//		
//	}
//	public void checkCollisionPiso(){
//		
//		if(hero.getRect().intersects(piso.getRect()) || hero.getRect().intersects(piso2.getRect())){
//			hero.setFloorCollide(true);
//		}
//		else{
//			hero.setFloorCollide(false);
//		}
//	}
//	
//	public void checkCollisionPared(){
//		if(hero.getRect().intersects(col.getRect())){
//			//hero.setFloorCollide(true);
//			hero.setWallCollide(true);
//			hero.setSide(col.getRect().getCenterX());
//		}
//		else{
//			hero.setSide(-250);
//			hero.setWallCollide(false);
//		}
//	}
//}

/*
* Actualizado el 27/octubre/2017 16:45 hrs
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class EntityManager {
	
	GameStateContext gc;
	private Hero hero;
	private ArrayList<Enemy> enemigos = new ArrayList<Enemy>();
	private Block col;
	private Block wall,wall2;
	private BackGround bd;
	private Camera cam;
	private Plataforms plat;
	private int enemiesKilled = 0;
	private int time = 0;
	Enemy go;
	
	
	
	public ArrayList<Enemy> getEnemigos() {
		return enemigos;
	}

	public EntityManager() {
		
		this.hero = new Hero(200, 200);

		//TODO corregir size;
		cam = new Camera(hero);
		this.col = new Block(2650,70,50,500,Color.WHITE, cam);
		this.wall = new Block(0, 0, 5,1000, Color.WHITE, cam);
		this.wall2 = new Block(6300, 0, 5,1000, Color.WHITE, cam);
		bd = new BackGround(cam);
		plat = new Plataforms(cam);
	}
	
	public void paint(Graphics g){
		
		bd.paint(g);

		plat.paint(g);
		hero.paint(g);
		
		for(int i = 0; i<enemigos.size();i++){
			go = enemigos.get(i);
			go.paint(g);
			
			
		}
		//for(int i = 0; i<enemigos.size();i++){
		//	go = enemigos.get(i);
		//	go.paint(g);	
		//}
	}
	
	public void update(){
		wall.update();
		wall2.update();
		hero.update();
		plat.update();
		col.update();
		cam.update();
		bd.update();
		for(int i = 0; i<enemigos.size();i++){
			go = enemigos.get(i);
			go.update();
			
			
		}
		checkCollisionPiso();
		checkCollisionPared();
		if(hero.getX()<200){
			fall();
		}
		checkCollisionEnemy();
		spawnEnemies();
	}
	
	public void keyboard(int k){
			hero.move(k);
	}
	public void keyboardReleased(int k){
		hero.move(k);
	}
		
	public void spawnEnemies() {
		if(enemigos.size()<5)  {
			Enemy temp=EnemyFactory.getInstance().getEnemy(cam);
			if(temp!=null)
				enemigos.add(temp);
			
			
		}
	}
	
	public void fall(){
		if(wall.getRect().intersects(hero.getRect())){
			hero.setWallCollide(true);
			hero.setSide1(wall.getRect().getCenterX());
		}
		else{
			hero.setSide1(-250);
			hero.setWallCollide(false);
		}
	}
	
	public void checkCollisionPiso(){	
		if(plat.checkCollision(hero.getRect())){hero.setFloorCollide(true);}
		else{hero.setFloorCollide(false);}	
	}
	
	public void checkCollisionPared(){
		if(hero.getRect().intersects(col.getRect())){
			hero.setWallCollide(true);
			hero.setSide(col.getRect().getCenterX());
		}
		else if(hero.getRect().intersects(wall2.getRect())){
			hero.setWallCollide(true);
			hero.setSide(wall2.getRect().getCenterX());
		}
		else{
			hero.setSide(-250);
			hero.setWallCollide(false);
		}
		
	}
	
	public void checkCollisionEnemy(){
		Enemy ene;
		for(int i=0;i<enemigos.size();i++) {
			ene = enemigos.get(i);
			if(!(time==0)){
				time++;
			}
			if(time>200){
				time=0;
			}
			if(hero.getRect().intersects(ene.getRect())){
					if(hero.getAtacking()) {
						enemigos.remove(i);
						enemiesKilled++;
						hero.setEnemiesKilled(enemiesKilled);
					}
					else {
						if(time==0){
							hero.setLives(hero.getLives()-1);
							time++;
						}
					}
			}
		}

	}

	public Hero getHero() {
		return hero;
	}
}
