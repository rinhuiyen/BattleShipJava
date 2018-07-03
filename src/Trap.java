import java.util.Random;


public class Trap {
	private int traprow;
	private int trapcol;
	private int traptype;

	
		
	public void setTRow(){
		Random random = new Random();
		traprow = random.nextInt(20);
	}
	public int getTRow(){
		return traprow;
	}
	
	public void setTCol(){
		Random random = new Random();
		trapcol = random.nextInt(60);
	}
	
	public int getTCol(){
		return trapcol;
	}
	public void setTType(){
		Random random = new Random();
		traptype = random.nextInt(1);
		
	}
	
	public int getTType(){
		return traptype;
	}

}
