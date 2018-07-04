
public class Player {
	private int life;
	
	public void adduserlife(){
		life += 1;
	}
	public void life(){
		life = 15;
	}
	public int getuserlife(){
		return life;
	}
	public void reduceuserlife(int l){
		for(int i = 0; i < l; i++) {
            life -= 1;
	}
}
}