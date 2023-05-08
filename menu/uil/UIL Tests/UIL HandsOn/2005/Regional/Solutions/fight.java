/*
 * Created on Feb 6, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author thornalt
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class fight {

	public static void main(String[] args) {
		int num_datasets;
		int playerHP, playerSTR, playerDEF;
		int monsterHP, monsterSTR, monsterDEF;
		int damage;
		
		UILFileReader input = new UILFileReader("fight.in");
				
		/* Read the number of data sets */
		num_datasets = input.readInt();
				
		/* Process each data set */
		for (int ds=0; ds<num_datasets; ds++) {
			playerHP = input.readInt();
			playerSTR = input.readInt();
			playerDEF = input.readInt();
			monsterHP = input.readInt();
			monsterSTR = input.readInt();
			monsterDEF = input.readInt();
			
			System.out.println("BATTLE " + (ds + 1));
			for (;;)
			{
				damage = playerHP + playerSTR - monsterDEF - monsterHP;
				if (damage <= 0)
					damage = (int)Math.ceil((playerHP + playerSTR) * .10);
				System.out.println("The player attacks the monster for " + damage + " damage!");
				monsterHP -= damage;
				if (monsterHP <= 0)
				{
					System.out.println("The monster has been slain!");
					break;
				}
				damage = monsterHP + monsterSTR - playerDEF - playerHP;
				if (damage <= 0)
					damage = (int)Math.ceil((monsterHP + monsterSTR) * .10);
				System.out.println("The monster attacks the player for " + damage + " damage!");
				playerHP -= damage;
				if (playerHP <= 0)
				{
					System.out.println("The player has been slain!");
					break;
				}
			}
		}
	}
}
