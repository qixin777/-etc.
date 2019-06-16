package attact;

import static main.Main.attackIndex;
import static main.Main.zombiesList;
import zombie.Zombies;

public class MagnetShroom extends Attact {

	public MagnetShroom(int zombiesIndex) {
		super(zombiesIndex,"MagnetShroom");
		// TODO Auto-generated constructor stub
		doDamage();
	}
	@Override
	public void doDamage() {
		// TODO Auto-generated method stub
		applyMagnetForce(zombiesIndex);
	}

	public void applyMagnetForce(int zombiesIndex) {
		// TODO Auto-generated method stub
		Zombies zomAttack=(Zombies)zombiesList.get(zombiesIndex);
		 
        if(zomAttack.getZomType().equals("B")||zomAttack.getZomType().equals("S")){
        	zomAttack.accessory=0;
        }
	}

	

}
