package manager;

import zombie.Zombies;

public abstract class Observer {
	protected GameObjectManager gom;
	public abstract void update(Zombies zombies);
}
