import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;

public class VictoryCelebration implements Behavior {

	public boolean takeControl() {
		if(Basketball.END == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void action() {
		Basketball.power.rotateRight();
		Motor.B.setSpeed(720);
		Motor.B.rotate(-360, true);
		

	}

	public void suppress() {
		
	}

}
