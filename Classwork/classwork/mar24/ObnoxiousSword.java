package mar24;

public class ObnoxiousSword extends Weapon {
	
	public void hitPlayer(Player p) {
		int taunt = (int) (Math.random() * 5);
		switch(taunt) {
		case 0: System.out.println("I don't want to talk to you no more, you empty-headed animal food trough wiper!"); break;
		case 1: System.out.println("I fart in your general direction!"); break;
		case 2: System.out.println("Your mother was a hamster and your father smelt of elderberries! "); break;
		case 3: System.out.println("Go and boil your bottoms, you sons of a silly person."); break;
		case 4: System.out.println("I'm French. Why do you think I have this outrageous accent, you silly king?"); break;
		}		
		super.hitPlayer(p);
	}

}
