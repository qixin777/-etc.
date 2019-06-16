package zombie;

import manager.GameObjectManager;
import static main.Main.attackIndex;

public class Bucket extends Zombies {

    public  Bucket(GameObjectManager gom)
    {
    	super(gom,50, "B");
        accessory = 100;
    }
    public Bucket() {
        super(50, "B");
        accessory = 100;
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
		System.out.println("this Bucket dies.");
	
	}
}
