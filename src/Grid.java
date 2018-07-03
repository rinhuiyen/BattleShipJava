

public class Grid {
	
	private int row = 20;
	private int col = 60;
	private String mapDisplay = "";
	private int[][] show = new int[row][col];
	String[][] usermap = new String[row][col];
	Game g = new Game();
	
	
	
	public void map(int ui){
		
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
		mapDisplay ="";
		for (int i = 0; i <row;i++) {
			for ( int j = 0; j < col; j++) {
				mapDisplay += usermap[i][j];
				}
			mapDisplay += "\n";
			}
		System.out.println(mapDisplay);
		
	}
	
	public void setUserMap(int row, int col, String item) {
		usermap[row][col] = item;
	}
	
	public String getusermap(){
		return mapDisplay;
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