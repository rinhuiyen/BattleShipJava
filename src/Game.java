import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private int x;
	private int y;
	private int count = 0;
	private static Game ga = new Game();
	ArrayList<int [][]> tlist = new ArrayList<int [][]>();
	ArrayList<int [][]> slist = new ArrayList<int [][]>();
	

	public void setRow(int r) {
		// TODO Auto-generated method stub
		x = r;
	}

	public int getRow() {
		return x;
	}

	public void setCol(int c) {
		y = c;
	}

	public int getCol() {
		return y;
	}
	private int getShipDiff(int ui){
		if(ui==1){
			return 80;
		} else if (ui == 2){
			return 50;
		}
		else if(ui == 3){
			return 20;
		}
		return 0;
	}
	public int[][] makegridcheckship(int[][] backgrid,int ui) {
		int ship = getShipDiff(ui);
		Random random = new Random();
		
		count = 0;
		while (count < ship) {
			Ship r = new Ship();
			r.createShipCol();
			r.createShipRow();
			int shipcol = r.getShipCol();
			int shiprow = r.getShipRow();

			boolean hvship = false;
			
			int length = random.nextInt(3) + 3;
			
			
			if (shipcol < 54) {
				for (int a = shipcol; a < shipcol + (length + 1); a++) {

					if (backgrid[shiprow][shipcol] == 1) {

						hvship = true;

					}
				}
				if (shipcol > 0) {
					if (backgrid[shiprow][shipcol - 1] == 1) {
						hvship = true;
					}
				}
				if (!hvship) {
					for (int a = shipcol; a < shipcol + length; a++) {
						backgrid[shiprow][a] = 1;
					}
				}
			} else {
				for (int a = shipcol; a > shipcol - (length + 1); a--) {
					if (backgrid[shiprow][a] == 1) {
						hvship = true;
					}
				}
				if (shipcol < 59) {
					if (backgrid[shiprow][shipcol + 1] == 1) {
						hvship = true;
					}
				}
				if (!hvship) {
					for (int a = shipcol; a > shipcol - length; a--) {
						backgrid[shiprow][a] = 1;
					}
				}
			}
			count++;
			slist.add(backgrid);

			if (hvship) {
				hvship = false;

				count -= 1;
			} else {
				
				backgrid[shiprow][shipcol] = 1;
			}
			

		}
		
		return backgrid;
	}
	public void checkship(int[] useri){
		Grid g = new Grid();
		int[][] ships = g.getGrid();
		
		for(int i = 1; i > 0; i++){
			ships[useri[0+i]][useri[1+i]] = 1;
			
		}
		ships[useri[0]][useri[1]] = 0;
		for(int j = ships[useri[0]][useri[1]]; j < 0; j--){
			
		}
	}
	
	private int getTrapDiff(int ui){
		if(ui==1){
			return 10;
		} else if (ui == 2){
			return 20;
		}
		else if(ui == 3){
			return 30;
		}
		return 0;
	}
	
	public int[][] makechecktrap(int[][] backgrid, int ui){
		int traplevel = getTrapDiff(ui);
		count = 0;
		
		
	while(count < traplevel){
		Trap t = new Trap();
		t.setTRow();
		t.setTCol();
		t.setTType();
		int trow = t.getTRow();
		int tcol = t.getTCol();
		
		
		if(backgrid[trow][tcol] == 0){
			backgrid[trow][tcol] = 3;
		}
		else {
			count--;
		}
		
		count++;
		tlist.add(backgrid);
	}
	return backgrid;
	}
	
	public int[][] checkpotion(int[][] backgrid){
		int potion = 18;
		count = 0;
	while(count < potion){
		Potion p = new Potion();
		p.createPotionRow();
		p.createPotionCol();
		int prow = p.getPotionRow();
		int pcol = p.getPotionCol();
		
		
		boolean placepotion = false;
		
		if(backgrid[prow][pcol] != 1){
			backgrid[prow][pcol] = 4;
			placepotion = true;
			}
		else if(backgrid[prow][pcol] != 3){
			backgrid[prow][pcol] = 4;
			placepotion = true;
		}
		
		count++;
		if(placepotion = false){
			count --;
			}else {
				backgrid[prow][pcol] = 4;
			}
		}
	return backgrid;
	}
	public ArrayList<int[][]> getshiplist(){
		
		return slist;
	}
public ArrayList<int[][]> gettraplist(){
		
		return tlist;
	}
}
