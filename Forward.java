
import lejos.robotics.subsumption.Behavior;

public class Forward implements Behavior {
	

	public boolean takeControl() {
		return true;
	}

	public void action() {
		Basketball.power.setTravelSpeed(720);
		Basketball.power.travel(100);

	}

	public void suppress() {
		Basketball.power.stop();
	}

	
}
