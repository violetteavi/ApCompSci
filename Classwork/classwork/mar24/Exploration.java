package mar24;

public class Exploration {

	public static void main(String[] args) {
//		Bird bird = new Bird();
//		bird.fly();
//		bird.layEgg();
//		bird.doStuff();
//		Penguin peng = new Penguin();
//		peng.fly();
//		peng.doStuff();
//		bird.eat();
//		peng.eat();
		Player p = new Player();
		while(p.checkDeath()) {
			p.damage();
		}
		System.out.println("Player is dead");
		WeakPlayer weakP = new WeakPlayer();
		while(weakP.checkDeath()) {
			weakP.damage();
		}
		System.out.println("WeakPlayer is dead");
		ObnoxiousSword sword = new ObnoxiousSword();
		Player p2 = new Player();
		while(p2.checkDeath()) {
			sword.hitPlayer(p2);
		}
		
	}

}
