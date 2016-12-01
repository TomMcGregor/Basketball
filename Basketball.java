
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Arbitrator;



public class Basketball {
	final static float DIAMETER = 41;
	final static float AXLE = 133;
	static DifferentialPilot power = new DifferentialPilot(DIAMETER, AXLE, Motor.A, Motor.C);
	static UltrasonicSensor us = new UltrasonicSensor(SensorPort.S2);
	static LightSensor ls = new LightSensor(SensorPort.S4);
	public static boolean DETECTED = false;
	public static boolean FIRING = false;    
	public static boolean BLACK = false;
	public static boolean WHITE = false;
	public static boolean GREY = false;

	public static void main(String[] args) {
		LCD.drawString("High", 1, 1);
		Button.ENTER.waitForPressAndRelease();
		ls.calibrateHigh();
		LCD.clear();
		LCD.drawString("Low", 1, 1);
		Button.ENTER.waitForPressAndRelease();
		ls.calibrateLow();
		LCD.clear();
		Behavior b1 = new Forward();
		Behavior b2 = new Rotate();
		Behavior b3 = new DetectHoop();
		Behavior b4 = new SeeHoop();
		Behavior b5 = new Fire();
		Behavior[] bArray = {b1, b2,b3,b4,b5};
		Arbitrator arby = new Arbitrator(bArray);
		arby.start();		
		
	}

}
