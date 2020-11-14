import java.util.Scanner;

public class InnKeeper extends NPC {
	public InnKeeper() {
		npcID = "N04";
		npcName = "Innkeeper";
		npcDesc = "Hey Adventurer, welcome to my Inn. For 5 Elusive coins we will restore your Health to full. Yes or No?";
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
		}
		else {
			System.out.println("invalid command");
		}
	}

}
