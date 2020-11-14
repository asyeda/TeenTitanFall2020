
public class Ghoul extends Monster {
	public Ghoul() {
		super();
		name = "Ghoul";
		monsterID = "M08";
		potionDrop = 1;
		coinDrop = 15;
		healthPoints = 50;
		// some monster abilities thing
		monsterDesc = "You come across a husk of something that resembles a human."
				+ " It gnaws at its own flesh until it sees you, changing its target.";
	}
	
	public void SecondAttack(Player p) {
		String attackName = "Bite";
		double attackDmg = 20;
		System.out.println(name + " has used " + attackName);
		p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
	}
}
