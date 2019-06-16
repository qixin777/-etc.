package attact;

import zombie.Zombies;

import static main.Main.attackIndex;
import static main.Main.zombiesList;
public class Peashooter extends Attact{

	public Peashooter(int zombiesIndex ) {
		super(zombiesIndex,"Peashooter");
		// TODO Auto-generated constructor stub
		doDamage();
	}
	@Override
	public void doDamage() {
		// TODO Auto-generated method stub
		doDamage(25,zombiesIndex);
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
