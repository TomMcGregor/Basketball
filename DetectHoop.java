import lejos.robotics.subsumption.Behavior;

public class DetectHoop implements Behavior {


	public boolean takeControl() {
		if (Basketball.us.getDistance() < 15)
		{
			
			return true;
		}
		
		return false;
	}

	public void action() {
		
		Basketball.power.stop();
		Basketball.DETECTED  = true;
	
 
	}

	public void suppress() {


	}

}
