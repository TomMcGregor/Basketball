import lejos.nxt.Sound;
import lejos.robotics.subsumption.Behavior;

public class Rotate implements Behavior {

	static double ROTATEANGLE;

	static double ROTATEDIRECTION;

	static long time = 0;

	public Rotate() {

	}

	public boolean takeControl() {

		if (Basketball.ls.getLightValue() > 85) {

			return true;

		} else {

			return false;

		}

	}

	public void action() {
		Sound.beep();

		Basketball.power.travel(-100);

		ROTATEANGLE = Math.random() * 90 + 90;

		ROTATEDIRECTION = Math.random();

		if (ROTATEDIRECTION > 0.5) {

			ROTATEANGLE *= -1;

		}

		Basketball.power.setRotateSpeed(360);

		Basketball.power.rotate(ROTATEANGLE);

	}

	public void suppress() {

		Basketball.power.stop();

	}

}