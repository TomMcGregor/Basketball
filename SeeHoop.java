import lejos.robotics.subsumption.Behavior;

public class SeeHoop implements Behavior {

	public boolean takeControl() {

		if (Basketball.DETECTED == true) {

			return true;

		} else {

			return false;

		}

	}

	public void action() {

		double right = 5.0;

		while (Basketball.us.getDistance() <= 30) {

			Basketball.power.rotate(right);

		}

		double left = -5.0;

		double totalLeft = 0;

		Basketball.power.rotate(left);

		while (Basketball.us.getDistance() <= 30) {

			Basketball.power.rotate(left);

			totalLeft += (-1 * (left));

		}

		double amountToTurn = ((totalLeft) / 2);

		Basketball.power.rotate(amountToTurn);

		Basketball.DETECTED = false;

		Basketball.FIRING = true;

	}

	public void suppress() {

		Basketball.power.stop();

	}

}