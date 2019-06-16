package attact;

import static main.Main.attackIndex;

public class AttactFactory {
	public static void simulateCollisionDetection(String attactType)
	{
		Attact attact;
		switch(attactType)
		{
		case "1":
			attact = new Peashooter(attackIndex);
            break;
        case "2":
        	attact = new Watermelon(attackIndex);
            break;
        case "3":
        	attact = new MagnetShroom(attackIndex);
            break;
        default:
            break;
		}
	}

}
