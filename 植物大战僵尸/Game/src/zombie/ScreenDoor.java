package zombie;

import manager.GameObjectManager;

public class ScreenDoor extends Zombies{

	public  ScreenDoor(GameObjectManager gom)
	 {
	    super(gom,50, "S");
        accessory = 25;
	 }
    public ScreenDoor() {
        super(50, "S");
        accessory = 25;
    }
    @Override
    public int getHealth(){
        return this.accessory + this.life;
    }

    @Override
    public void takeDamage(int d) {
        if(this.accessory > d){
            this.accessory -= d;
        } else {
            this.life -= (d - this.accessory);
            this.accessory = 0;
            this.zomType = "R";
        }
    }
	@Override
	public boolean isMetal() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void update(Zombies zombies) {
		gom.removeZombies(zombies);
		// TODO Auto-generated method stub
		System.out.println("this ScreenDoor dies.");

	}
}
