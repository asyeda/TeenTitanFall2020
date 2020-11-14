import java.util.Scanner;

public class BarTender extends NPC {
	public BarTender() {
		npcID = "N03";
		npcName = "Bartender";
		npcDesc = "Hey Adventurer, welcome to my Tavern. For 5 Elusive coins we will restore your Health to full. Yes or No?";
	}
	@Override
	public void talkTo(Player p) {
		System.out.println(npcDesc);
		Scanner scan = new Scanner(System.in);
		String ans = scan.nextLine();
		if(ans.equalsIgnoreCase("yes")) {
			if(p.coins >= 5) {
				p.coins -= 5;
				p.setCurrentHealth(p.getBASE_HEALTH());
				System.out.println("Your health bar has been restored");
			}
			else {
				System.out.println("You don't have enough coins.");
			}
		}
		else if(ans.equalsIgnoreCase("no")){
			System.out.println("Thanks for visiting.");
			return;
		}
		else {
			System.out.println("invalid command");
		}
		System.out.println("Thanks for visiting.");
	}

}
