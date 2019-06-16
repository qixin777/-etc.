package manager;

import static main.Main.attackIndex;


import java.util.List;
import java.util.Scanner;


import zombie.Zombies;
import zombie.ZombiesFactory;

public class GameEventManager {
	GameObjectManager gom=new GameObjectManager();
	/*public  GameEventManager()
	{
		
	}*/
	public  GameEventManager(GameObjectManager gom)
	{
		this.gom=gom;
	}
	
	/*public void doDamage(int damage, int zombiesIndex) {
		Zombies zomAttack=(Zombies)zombiesList.get(zombiesIndex);
		if(zomAttack.getZomType().equals("S")&&damage==30){
        	zomAttack.life-=30;
        }else{
        	zomAttack.takeDamage(damage);
        }
      // If the zombie dies, attacks next
      if(zomAttack.die()){
    	  GameObjectManager gom=new GameObjectManager();
    	  gom.update();
      }
	}
	
	public void applyMagnetForce(int zombiesIndex)
	{
		Zombies zomAttack=(Zombies)zombiesList.get(zombiesIndex);
        if(zomAttack.getZomType().equals("B")||zomAttack.getZomType().equals("S")){
        	zomAttack.accessory=0;
        }
	}
	
	public void simulateCollisionDetection(String plant)
	{
		switch(plant)
		{
		case "1":
			doDamage(25,attackIndex);
            break;
        case "2":
        	doDamage(30, attackIndex);
            break;
        case "3":
        	applyMagnetForce(attackIndex);
            break;
        default:
            break;
		}
	}*/
	public void doDamage2(int damage, int zombiesIndex) {
		Zombies zomAttack=(Zombies)gom.zombiesList.get(zombiesIndex);
		if(zomAttack.getZomType().equals("S")&&damage==30){
        	zomAttack.life-=30;
        }else{
        	zomAttack.takeDamage(damage);
        }
      // If the zombie dies, attacks next
	
	    	  gom.notifyObservers(zomAttack);
      /*if(zomAttack.die()){
    	  gom.notifyObservers();

      }*/
	}
	
	public void applyMagnetForce2(int zombiesIndex)
	{
		Zombies zomAttack=(Zombies)gom.zombiesList.get(zombiesIndex);
        if(zomAttack.getZomType().equals("B")||zomAttack.getZomType().equals("S")){
        	zomAttack.accessory=0;
        }
	}
	
	public void simulateCollisionDetection2(String plant)
	{
		switch(plant)
		{
		case "1":
			doDamage2(25,attackIndex);
            break;
        case "2":
        	doDamage2(30, attackIndex);
            break;
        case "3":
        	applyMagnetForce2(attackIndex);
            break;
        default:
            break;
		}
	}


	
}
