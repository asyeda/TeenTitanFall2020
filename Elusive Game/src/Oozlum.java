
public class Oozlum extends Monster{
	public Oozlum() {
		super();
		name = "Oozlum";
		monsterID = "M01";
		//super.itemDrops = new Item[1];
		//itemDrops[0] = new Item("Oozlum Wings");
		healthPoints = 100;
		// some monster abilities thing
		monsterDesc = "A tiny fuzzy round-shaped creature. The creature seems sweet and cuddly at first glance.";
	}
	public void FirstAttack(Player p) {
		String attackName = "Bite";
		double attackDmg = 20;
		System.out.println(name + " has used " + attackName);
		p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
		damagedHealth = p.getCurrentHealth();
	}
	
	public void SecondAttack(Player p) {
		String attackName = "Bash";
		double attackDmg = 35;
		System.out.println(name + " has used " + attackName);
		p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
		damagedHealth = p.getCurrentHealth();
	}
	public void ThirdAttack(Player p) {
		String attackName = "Wing Slash";
		double attackDmg = 25;
		System.out.println(name + " has used " + attackName);
		p.setCurrentHealth(p.getCurrentHealth() - (attackDmg - (attackDmg * (p.getDefense() / 100) )));
		damagedHealth = p.getCurrentHealth();
	}
}
