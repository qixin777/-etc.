package zombie;

import manager.GameObjectManager;
import manager.Observer;

public abstract class Zombies extends  Observer {
    public Integer life;
    public String zomType;
    public Integer accessory;
    public Zombies(GameObjectManager gom,Integer life, String zomType){
    	this.gom=gom;
    	this.gom.attach(this);
    	this.life = life;
        this.zomType =zomType;
    }
    
    public Zombies(Integer life, String zomType){
        this.life = life;
        this.zomType =zomType;
    }

    public Integer getLife() {
        return life;
    }

    public String getZomType() {
        return zomType;
    }
    public abstract int getHealth();
    public abstract void takeDamage(int d);
    public abstract  boolean isMetal();
    public boolean die(){
        if(this.life <= 0){
            return true;
        } else {
            return false;
        }
    }
}
