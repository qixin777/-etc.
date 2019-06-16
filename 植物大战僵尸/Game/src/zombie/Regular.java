package zombie;

import manager.GameObjectManager;

public class Regular  extends Zombies{
	public  Regular (GameObjectManager gom)
	 {
	    super(gom,50, "R");
	    accessory = 0;
	 }
    public Regular() {
        super(50, "R");
        accessory = 0;
    }

    @Override
    public int getHealth() {
        return this.life;
    }

    @Override
    public void takeDamage(int d) {
        this.life -= d;
    }



	@Override
	public boolean isMetal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Zombies zombies) {
		gom.removeZombies(zombies);
		// TODO Auto-generated method stub
		System.out.println("this Regular dies.");

	}
}
