import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		Grid grid = new Grid();
		int checkplayer = 0;
		int life = 15;


		Scanner input = new Scanner(System.in);
		System.out.println("Please choose a level by typing in the number.\n 1.Beginner\n 2.Intermediate\n 3.Advance");
		int userinput = input.nextInt();	
		grid.map(userinput);
		System.out.println(life);
	
		for(int counter =1; counter >0; counter++){
			if(checkplayer != 5 && life != 0){
			
			System.out.println("Please enter the row.");
			int coorrow = input.nextInt();
			System.out.println("Please enter the col.");
			int coorcol = input.nextInt();
			
			
			int[][] show = grid.getGrid();
			if(show[coorrow-1][coorcol-1] == 1){
				System.out.println("You have revealed a ship");
				
				grid.setUserMap(coorrow-1, coorcol-1, "O");
				for(int k=2; k>1; k++){
					if(show[coorrow-1][coorcol-k] == 1 && coorcol>=1){
						grid.setUserMap(coorrow-1, coorcol-k, "O");
						grid.displayUserMap();
					}
					else if(show[coorrow-1][coorcol+k-2] == 1){
						grid.setUserMap(coorrow-1, coorcol+k-2, "O");
						grid.displayUserMap();
					}else{
						k=0;
					}
				}
				checkplayer +=1;
			}
			else if(show[coorrow-1][coorcol-1] == 3){
				grid.setUserMap(coorrow-1, coorcol-1, "T");
				grid.displayUserMap();
				Trap t = new Trap();
				t.setTType();
				int tr = t.getTType();
				
				System.out.println("You have revealed a low level trap." );
				if(tr == 0){
					life -= 1;
					System.out.println("You have revealed a high level trap" + life);
				}
				else{
					life -= 2;
					
				}
				
			}
			else if(show[coorrow-1][coorcol-1] == 4){
				System.out.println("You have revealed a potion.");
				grid.setUserMap(coorrow-1, coorcol-1, "P");
				grid.displayUserMap();
				Potion p = new Potion();
				p.potion();
				int potiontype = p.getpotiontype();
				if(potiontype== 0){
					life += 1;
				}
				else if(potiontype == 1){
					for(int i = 0; i < 20; i++){
						System.out.println(grid.getshiplist());
					}
				}else if(potiontype == 2){
					Game p1 = new Game();
					for(int i = 0; i < 10; i++){
						System.out.println(grid.gettraplist());
					}
				}
				life -= 1;
				
		}
			else{
				System.out.println("You missed a ship please try again.");
				grid.setUserMap(coorrow-1, coorcol-1, " ");
				grid.displayUserMap();
				life -= 1;
				
			}
			}
			System.out.println(life);
}
}
}