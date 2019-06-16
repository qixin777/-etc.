package attact;

import zombie.Zombies;

public abstract class Attact {
	protected int zombiesIndex;
	protected String attactType;
	public Attact(int zombiesIndex,String attactType)
	{
		this.zombiesIndex=zombiesIndex;
		this.attactType=attactType;
	}
	public abstract void doDamage();

}
