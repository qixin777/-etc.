package attact;

import zombie.Zombies;
import static main.Main.zombiesList;
import static main.Main.attackIndex;
public class Watermelon extends Attact {

	public Watermelon(int zombiesIndex) {
		super(zombiesIndex,"Watermelon");
		// TODO Auto-generated constructor stub
		doDamage();
	}
	@Override
	public void doDamage() {
		// TODO Auto-generated method stub
		doDamage(30, zombiesIndex);
	}
	
	
	public void doDamage(int damage, int zombiesIndex) {
		// TODO Auto-generated method stub
		Zombies zomAttack=(Zombies)zombiesList.get(zombiesIndex);
		  zomAttack.takeDamage(damage);
          // If the zombie dies, attacks next
          if(zomAttack.die()){
              attackIndex++;
          }
	}

	

}
