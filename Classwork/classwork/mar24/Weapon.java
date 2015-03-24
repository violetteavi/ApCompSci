package mar24;

public class Weapon {
	
	protected int strength;
	
	public Weapon() {
		strength = (int) (Math.random() * 5 + 1);
	}
	
	public void hitPlayer(Player p) {
		for(int i = 0; i < strength; i++) {
			p.damage();
		}
	}

}
