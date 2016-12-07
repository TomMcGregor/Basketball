import lejos.nxt.Motor;

import lejos.robotics.subsumption.Behavior;

public class Fire implements Behavior {

	public boolean takeControl() {

		if (Basketball.FIRING == true) {

			return true;

		} else {

			return false;

		}

	}

	public void action() {

		Motor.B.setSpeed(100);

		Motor.B.rotate(-360);

		Basketball.power.backward();

		Basketball.power.travel(-120);

		Basketball.power.rotate(-100);
		if (Basketball.GREY == false && Basketball.WHITE == false)
		{
			Basketball.END = true;
		}

		Basketball.FIRING = false;

	}

	public void suppress() {

		Motor.B.stop();

	}

}