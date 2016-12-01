
import lejos.robotics.subsumption.Behavior;

public class Rotate implements Behavior {
	static double ROTATEANGLE;
	static double ROTATEDIRECTION;
	static long time = 0;

	public Rotate() {

	}

	public boolean takeControl() {
		// TODO Auto-generated method stub
		if (Basketball.ls.getLightValue() > 50) {
			return true;
		} else {
			return false;
		}
	}

	public void action() {
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
