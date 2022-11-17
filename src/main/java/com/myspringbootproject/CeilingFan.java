package com.myspringbootproject;

import org.springframework.stereotype.Component;

/**
 * A simple ceiling fan which has 2 pull cords to control the speed and direction of the fan,
 * and 1 button to control the color of the fan.
 * 
 * <p>One cord increases the speed each time it is pulled. There are 3 speed settings, and an “off” (speed 0) setting.
 * If the cord is pulled on speed 3, the fan returns to the “off” setting.
 * 
 * <p>Another cord reverses the direction of the fan at the current speed setting.
 * Once the direction has been reversed, it remains reversed as we cycle through the speed settings, until reversed again.
 * 
 * <p>The button controls the color of the fan (blue/red/green/yellow).
 * 
 * <p>Assume the unit is always powered (no wall switch)
 */
@Component
public class CeilingFan {
	
	private static final int maxSpeed = 3;
	
	private int speed;
	private boolean reverse;
	private String color;
	
	 // Constructors

    /**
     * Constructs a {@code CeillingFan} that contains 3 properties 'speed', 'reverse'(fan direction) and color.
     * The default fan speed is off (speed 0) and the default fan direction is non-reverse.
     * The default color of the fan is empty.
     */
	
	public CeilingFan() {
		this.speed = 0;
		this.reverse = false;
		this.color = "";
	}
	
	public CeilingFan(int speed, boolean reverse, String color) {
		this.speed = speed;
		this.reverse = reverse;
		this.color = color;
	}

	 /**
     * Set the color of the ceiling fan, possible values are blue, red, green, yellow.
     */
	public void setColor(String color) {
		this.color = color;
	}

	 /**
     * Returns the color of the ceiling fan
     *
     * @return  The color of the ceiling fan, possible values are empty(default), blue, red, green, yellow.
     */
	public String getColor() {
		return color;
	}
	
	 /**
     * Returns the speed of the ceiling fan
     *
     * @return  The speed of the ceiling fan, possible values are 0 (off), 1, 2, 3.
     */
	public int getSpeed() {
		return speed;
	}
	
	/**
     * Returns the fan direction (reverse) of the ceiling fan.
     *
     * @return  The fan direction (reverse) in boolean, {@code true} means reverse and {@code false} means non-reverse.
     */
	public boolean getReverse() {
		return reverse;
	}
	
	/**
     * Pulls the speed cord to increase the speed of the ceiling fan.
     * If the cord is pulled on speed 3, the fan returns to the “off” setting (speed 0). 
     *
     * @return  The fan speed after the cord is pulled. Possible values are 0 (off), 1, 2, 3.
     */
	public int pullSpeedCord() {
		if (speed == maxSpeed)
			speed = 0;
		else
			speed++;
		return speed;
	}
	
	/**
     * Pulls the fan direction cord to reverse the direction of the ceiling fan.
     *
     * @return  The fan direction (reverse) after the cord is pulled. {@code true} means reverse and {@code false} means non-reverse.
     */
	public boolean pullReverseCord() {
		reverse = !reverse;
		return reverse;
	}
	
/*
	/**
     * Main method of the class. It reads the user input instruction to change the speed or direction of the ceiling fan.
     * It outputs the changes and the status of the fan speed & direction after each operation.
     * Program stops when user input 'Quit'.
     */
	/*
	public static void main(String[] args) {

		CeilingFan ceilingFan = new CeilingFan();
		Scanner in = new Scanner(System.in);
		do {
			System.out.print("Please enter 'Speed' or 'Reverse' to control the Ceiling Fan or 'Quit' to stop the program:");
			String instruction = in.nextLine();
			switch (instruction.toUpperCase()) {
				case "SPEED":
					int s = ceilingFan.pullSpeedCord();
					System.out.println("Fan speed is changed to " + (s==0?"off":s));
					break;
				case "REVERSE":
					boolean r = ceilingFan.pullReverseCord();
					System.out.println("Fan direction is changed to " + (r?"reverse":"non-reverse"));
					break;
				case "QUIT":
					in.close();
					System.out.println("Program stopped.");
					return;
				default:
					System.out.println("Wrong Instruction.");
			}
			System.out.println("Current Speed : "+ ceilingFan.getSpeed() + " , Reverse : "+ (ceilingFan.getReverse()?"Yes":"No"));
			System.out.println("");
		}
		while (true);
	}
*/

}
