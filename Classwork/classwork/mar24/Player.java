package mar24;

public class Player {

	protected int life = 10;
	
	public void damage() {
		life--;
	}
	
	public boolean checkDeath() {
		return life > 0;
	}
}
