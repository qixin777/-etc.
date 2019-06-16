package manager;

import java.util.ArrayList;
import java.util.List;

import zombie.Zombies;
import static main.Main.attackIndex;

public class GameObjectManager {
	public  List<Zombies> zombiesList = new ArrayList<Zombies>();

	public void update(){
		attackIndex++;
	}

	
	public void attach(Zombies observer) {
		// TODO Auto-generated method stub
		zombiesList.add(observer);
	}

	
	public void removeZombies(Zombies observer) {
		// TODO Auto-generated method stub
		zombiesList.remove(observer);
	}
	public void notifyObservers(Zombies observer) {
		
		if(observer.die())
		{
			//attackIndex++;
			/*for (Zombies ob : zombiesList) {
				if(ob.die())
				{
					
				}
		      }*/
			observer.update(observer);
		}
		
		
	}
	
}

