package zombie;


import manager.GameObjectManager;

public class ZombiesFactory {
	GameObjectManager gom;
	public ZombiesFactory(GameObjectManager gom)
	{
		this.gom=gom;
	}
    public static  Zombies createZombies(String zomType){
        Zombies zombies = null;
        switch (zomType){
            case "1":
            	
              //  zombies = new Regular();
                break;
            case "2":
              //  zombies = new Cone();
                break;
            case "3":
               // zombies = new Bucket();
                break;
            case "4":
               // zombies = new ScreenDoor();
                break;
            default:
                break;
        }
        return zombies;
    }
    public  Zombies createZombiesEX(String zomType){
        Zombies zombies = null;
        switch (zomType){
            case "1":
            	 new Regular(gom);
              //  zombies = new Regular();
                break;
            case "2":
            	new Cone(gom);
              //  zombies = new Cone();
                break;
            case "3":
            	new Bucket(gom);
               // zombies = new Bucket();
                break;
            case "4":
            	new ScreenDoor(gom);
               // zombies = new ScreenDoor();
                break;
            default:
                break;
        }
        return zombies;
    }
}
