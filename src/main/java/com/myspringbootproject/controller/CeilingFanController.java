package com.myspringbootproject.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myspringbootproject.CeilingFan;
import com.myspringbootproject.exception.InputParamException;

/**
 * This is the Rest Controller of the ceiling fan.
 * 
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
@RestController
public class CeilingFanController {
	
	@Autowired
	CeilingFan ceilingFan;
	
	 /**
     * A RESTful API to return the current speed of the ceiling fan
     *
     * @return  The speed of the ceiling fan, possible values are 0 (off), 1, 2, 3.
     */
	@GetMapping("/status/speed")
	public int currentSpeed() {
	    return ceilingFan.getSpeed();
	}

	 /**
     * A RESTful API to return the current direction of the ceiling fan
     *
     * @return  The fan direction (reverse) in boolean, {@code true} means reverse and {@code false} means non-reverse.
     */
	@GetMapping("/status/direction")
	public String currentDirection() {
	    return (ceilingFan.getReverse()?"reverse":"non-reverse");
	}
	
	 /**
     * A RESTful API to update the speed of the ceiling fan and return the current speed of the ceiling fan after update
     *
     * @return  The speed of the ceiling fan, possible values are 0 (off), 1, 2, 3.
     */
	@PutMapping("/update/speed")
	public int updateSpeed() { 
		return ceilingFan.pullSpeedCord();
	}

	 /**
     * A RESTful API to update the direction of the ceiling fan and return the current direction of the ceiling fan after update
     *
     * @return  The fan direction (reverse) in boolean, {@code true} means reverse and {@code false} means non-reverse.
     */
	@PutMapping("/update/direction")
	public String updateDirection() { 
		return (ceilingFan.pullReverseCord()?"reverse":"non-reverse");
	}

	 /**
     * A RESTful API to update the current color of the ceiling fan and return the ceiling fan object in JSON
     *
     * @return  The ceiling fan object.
     */
	@PutMapping("/update/color")
	public ResponseEntity<CeilingFan> updateColor(@RequestBody CeilingFan cf) {
		String[] color = new String[] {"blue","red","green","yellow"};
		if (!Arrays.stream(color).anyMatch(cf.getColor()::equals)) {
			throw new InputParamException("no such color");
		}
		this.ceilingFan.setColor(cf.getColor());
		return new ResponseEntity<CeilingFan>(ceilingFan, HttpStatus.OK);
		
	}
	 
}
