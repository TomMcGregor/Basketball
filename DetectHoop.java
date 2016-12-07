import lejos.nxt.Sound;
import lejos.robotics.subsumption.Behavior;

public class DetectHoop implements Behavior {

	public boolean takeControl() {

		if (Basketball.us.getDistance() < 15)

		{
			return true;

		} else {
			return false;
		}

	}

	public void action() {
		if (Basketball.DC == true) {
			Basketball.power.quickStop();
			if (Basketball.ls.getLightValue() < 25 && Basketball.WHITE == true) {
				Basketball.power.stop();
				Basketball.WHITE = false;
				Basketball.DETECTED = true;
				
			} else if (((Basketball.ls.getLightValue() >= (Basketball.GREYCOLOR -15)) && (Basketball.ls.getLightValue() <= (Basketball.GREYCOLOR + 15))) && (Basketball.GREY == true))
			{
				Sound.buzz();
				Basketball.power.stop();
				Basketball.GREY = false;
				Basketball.DETECTED = true;
			}
			else {
				
				Basketball.power.travel(-100);
				Basketball.power.rotate(90);
				
			}
			Basketball.DC = false;
			
			

		}
	}

	public void suppress() {

	}

}