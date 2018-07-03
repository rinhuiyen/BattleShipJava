import java.util.Random;


public class Potion {
	private int row;
	private int col;
	private int potiontype;
	
	public void createPotionRow(){
		Random random = new Random();
		row = random.nextInt(20);
		
	}
	public int getPotionRow(){
		return row;
	}
	
	
	public void createPotionCol(){
		Random random = new Random();
		col = random.nextInt(60);
	}
	
	public int getPotionCol(){
		return col;
	}
	public void potion(){
		Random random = new Random();
		potiontype = random.nextInt(2);
		if(potiontype== 0){
		
		}
		else if(potiontype == 1){
			Game p1 = new Game();
			for(int i = 0; i < 20; i++){
				System.out.println(p1.getshiplist());
			}
		}else if(potiontype == 2){
			Game p1 = new Game();
			for(int i = 0; i < 10; i++){
				System.out.println(p1.gettraplist());
			}
		}
	}

}