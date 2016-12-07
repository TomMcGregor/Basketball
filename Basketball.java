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
	public static boolean WHITE = true;
	public static boolean GREY = true;
	public static boolean END = false;
	public static boolean DC = true;
	public static int GREYCOLOR;

	public static void main(String[] args) {

		LCD.drawString("Black", 1, 1);

		Button.ENTER.waitForPressAndRelease();

		ls.calibrateHigh();

		LCD.clear();
		
		
		LCD.drawString("White", 1, 1);

		Button.ENTER.waitForPressAndRelease();

		ls.calibrateLow();

		LCD.clear();

	LCD.drawString("Grey", 1, 1);

		Button.ENTER.waitForPressAndRelease();

		GREYCOLOR = ls.getLightValue();

		LCD.clear();
		
		Button.ENTER.waitForPressAndRelease();
		

		
		
		Behavior b1 = new Forward();

		Behavior b2 = new Rotate();

		Behavior b3 = new DetectHoop();

		Behavior b4 = new SeeHoop();

		Behavior b5 = new Fire();

		Behavior b6 = new VictoryCelebration();

		Behavior[] bArray = { b1, b2, b3, b4, b5, b6 };

		Arbitrator arby = new Arbitrator(bArray);

		arby.start();

	}

}