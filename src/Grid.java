import java.util.ArrayList;



public class Grid {
	
	private int row = 20;
	private int col = 60;
	private String mapDisplay = "";
	private int[][] show = new int[row][col];
	String[][] usermap = new String[row][col];
	Game g = new Game();
	ArrayList<Integer [][]> tlist=  new ArrayList<Integer [][]>();
	ArrayList<Integer[][]> slist = new ArrayList<Integer [][]>();

	
	
	public void map(int ui){
		/*slist = new ArrayList<int [][]>();
		tlist = new ArrayList<int [][]>();*/
		show= g.checkpotion(show);
		show= g.makegridcheckship(show,ui);
		show= g.makechecktrap(show,ui);
		getGrid();
		
		mapDisplay = "";
		
		for (int i = 0; i <show.length;i++) {
			for ( int j = 0; j < show[i].length; j++) {
				mapDisplay += Integer.toString(show[i][j]);
				
				}
			mapDisplay += "\n";
			}
		System.out.println(mapDisplay);
		populateUserMap();
		displayUserMap();
		
		
	}
	public void populateUserMap() {
		
		for (int i = 0; i <row;i++) {
			for ( int j = 0; j < col; j++) {
				usermap[i][j] = "#";
				}
			}
	}
	
	public void displayUserMap() {
		mapDisplay += "\n";
		mapDisplay += ("   "); 
		for(int k=1; k<=6; k++) {
			for(int m=1; m<=10; m++) {
				if(m==10) {
					mapDisplay += (m-10);
				}else {
					mapDisplay += m;
				}
			}
		}
		mapDisplay += ("\n");
		mapDisplay += ("   "); 
		int p=1;
		for(int k=0; k<1;k++) {
			for(int h=1; h<=60; h++) {
				if(h==10*p) {
					mapDisplay += h/10;
					p++;
				}else {
					mapDisplay += " ";
				}
			}
		}
		mapDisplay += ("\n");
		for (int i = 0; i <row;i++) {
			if(i<9) {
	    		mapDisplay += " " + (i+1) + " ";
	    	}else {
	    		mapDisplay += (i+1) + " ";
	    	}
			for ( int j = 0; j < col; j++) {
				mapDisplay += usermap[i][j];
				}
			mapDisplay += "\n";
			}
		System.out.println(mapDisplay);
		mapDisplay = "";
	}
	
	public void setUserMap(int row, int col, String item) {
		usermap[row][col] = item;
	}
	
	public String getusermap(){
		return mapDisplay;
	}
	
public ArrayList<Integer[][]> getshiplist(){
		
		return slist;
	}
	
public ArrayList<Integer[][]> gettraplist(){
		
		return tlist;
	}

	
	public void setGrid(int x, int y,int obj){
		//show[20-1]
		show[x][y]=obj;
		
	}
	
	public int checkGrid(int x, int y) {
		return show[x][y];
	}
	
	public void setGridShip(int[][] backgrid){
		show = backgrid;
		
	}
	
	public int[][] getGrid(){
		return show;
	}
	
}