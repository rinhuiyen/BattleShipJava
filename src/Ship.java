import java.util.ArrayList;
import java.util.Random;

public class Ship {
	private int count = 0;
	private int row;
	private int col;
	
	public void createShipRow(){
		Random random = new Random();
		row = random.nextInt(20);
		
	}
	public int getShipRow(){
		return row;
	}
	
	
	public void createShipCol(){
		Random random = new Random();
		col = random.nextInt(60);
	}
	
	public int getShipCol(){
		return col;
	}
	
	
}