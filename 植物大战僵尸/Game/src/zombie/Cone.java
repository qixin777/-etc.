package zombie;

import manager.GameObjectManager;

public class Cone  extends Zombies {
   
	 public  Cone(GameObjectManager gom)
	 {
	    super(gom,50, "C");
	    accessory = 25;
	 }
    public Cone() {
        super(50, "C");
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
		return false;
	}
	@Override
	public void update(Zombies zombies) {
		gom.removeZombies(zombies);
		// TODO Auto-generated method stub
		System.out.println("this Cone dies.");

	}

}
