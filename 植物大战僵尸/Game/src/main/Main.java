package main;



import java.util.List;
import java.util.Scanner;

import manager.GameEventManager;
import manager.GameObjectManager;
import zombie.Zombies;
import zombie.ZombiesFactory;

public class Main {
	
	public static int attackIndex;
    // out put menu
    public static void displayMenu(){
        System.out.println("1. Create zombies?");
        System.out.println("2. Demo game play?");
    }
    public static void attactMenu()
    {
    	System.out.println("Which type of the attact");
    	System.out.println("1. Peashooter attact");
        System.out.println("2. Watermelon attact");
        System.out.println("3. Magnet-shroom attact");
    }

    // output all zombies state
    public static void displayZombiesStatus(List zombiesList){
        String outString = "[";

        for (int i = 0; i <  zombiesList.size(); i++){
            Zombies zom = (Zombies)zombiesList.get(i);
            outString+=(zom.getZomType() + "/" + zom.getHealth());
            if(i!=zombiesList.size()-1){
                outString += ", ";
            }
        }
        outString += "]";
        System.out.println(outString);
    }

/*    public static void playGame(Scanner sc, List zombiesList){
        System.out.println("Please enter y to attack!");
        //attack after input y
        while(sc.nextLine().equals("y")){
        	attactMenu();
        	GameEventManager gem=new GameEventManager();
        	gem.simulateCollisionDetection(sc.nextLine());

            
            displayZombiesStatus(zombiesList);
            Zombies lastZom = (Zombies) zombiesList.get(zombiesList.size() - 1);
            // the last zombie dies, end the game
            if(lastZom.die()){
                break;
            }
            System.out.println("Please enter y to attack!");
        }
    }
    public static void gotoGame()
    {
    	Scanner sc = new Scanner(System.in);
    	while(true){
            displayMenu();
            String choice = sc.nextLine();
            // create zombie
            if(choice.equals("1")){
                System.out.println("Which kind?\n1. Regular\n2. Cone\n3. Bucket\n4. ScreenDoor\n");
                String zomType = sc.nextLine();
                // create different zombies
                Zombies zom = ZombiesFactory.createZombies(zomType);
                
                GameObjectManager gom=new GameObjectManager();
                if(zom!=null){
                	//gom.addZombies(zom);
                    // put zombies in to array
                    zombiesList.add(zom);
                    System.out.println("add success");
                }
            } else if(choice.equals("2")){
                // Set the power of plantshooter
                // start to attack
                playGame(sc, zombiesList);
                System.out.println("Gongratulation!You Win The Game!");
                break;
            } else {
                System.out.println();
            }
        }
    }*/
    public static void playGame(Scanner sc, GameObjectManager gom){
        System.out.println("Please enter y to attack!");
        //attack after input y
        while(sc.nextLine().equals("y")){
        	
        	attactMenu();
        	GameEventManager gem=new GameEventManager(gom);
        	gem.simulateCollisionDetection2(sc.nextLine());

            
            displayZombiesStatus(gom.zombiesList);
            System.out.println("Please enter y to attack!");
            if(gom.zombiesList.isEmpty())
            {
            	break;
            }
            /*Zombies lastZom = (Zombies) gom.zombiesList.get(gom.zombiesList.size() - 1);
            // the last zombie dies, end the game
            if(lastZom.die()){
                break;
            }*/
            
        }
    }
    public static void gotoGame()
    {
    	GameObjectManager gom=new GameObjectManager();
    	Scanner sc = new Scanner(System.in);
    	while(true){
            displayMenu();
            String choice = sc.nextLine();
            // create zombie
            if(choice.equals("1")){
                System.out.println("Which kind?\n1. Regular\n2. Cone\n3. Bucket\n4. ScreenDoor\n");
  
                
                ZombiesFactory zf=new ZombiesFactory( gom);
                String zombiesType=sc.nextLine();
                if(zombiesType.equals("1")||zombiesType.equals("2")||zombiesType.equals("3")||zombiesType.equals("4")){
                	//gom.addZombies(zom);
                    // put zombies in to array
                	 zf.createZombiesEX(zombiesType);
                    //zombiesList.add(zom);
                    System.out.println("add success");
                }
            } else if(choice.equals("2")){
                // Set the power of plantshooter
                // start to attack
                playGame(sc, gom);
                System.out.println("Gongratulation!You Win The Game!");
                break;
            } else {
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
    	
    	gotoGame();
    	
    }
}
