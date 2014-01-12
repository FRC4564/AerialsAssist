/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/* This version modified by team 4564 for 2014 robot "Natasha" competition.   */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

public class Natasha2014 extends SimpleRobot {
    
    // Global constants  
    public static final int PWM_DRIVE_FL = 4;
    public static final int PWM_DRIVE_RL = 3;
    public static final int PWM_DRIVE_FR = 2;
    public static final int PWM_DRIVE_RR = 1;
    
    public static final int JB_DRIVE_SLOW = 2;
    
    public static final double TIMER_DELAY_SECS = .01;
    
    // Global variables
    
    // Define robot components
    Talon leftForward = new Talon(PWM_DRIVE_FL);
    Talon leftBackward = new Talon(PWM_DRIVE_RL);
    Talon rightForward = new Talon(PWM_DRIVE_FR);
    Talon rightBackward = new Talon(PWM_DRIVE_RR);
    
    RobotDrive chassis = new RobotDrive(leftForward,leftBackward,rightForward,rightBackward);
    Joystick leftstick = new Joystick(1);
    Joystick rightstick = new Joystick(2);   
    
    /**
     * Robot initialization runs once at startup
     */ 
    protected void robotInit() {
       chassis.setInvertedMotor(RobotDrive.MotorType.kFrontLeft,true);
       chassis.setInvertedMotor(RobotDrive.MotorType.kRearLeft,true);
       chassis.setInvertedMotor(RobotDrive.MotorType.kFrontRight,true);
       chassis.setInvertedMotor(RobotDrive.MotorType.kRearRight,true);

    }
    
    /**
     * Autonomous mode is called once and must exit before 10 sec period expires
     */
    public void autonomous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        chassis.setSafetyEnabled(true);
        while(isOperatorControl() && isEnabled()){
            if (leftstick.getRawButton(JB_DRIVE_SLOW)) {
                chassis.arcadeDrive(leftstick.getY() * .7, leftstick.getX() * .5);
            } else {
                chassis.arcadeDrive(leftstick.getY(), leftstick.getX() * .7);
            }
           
            Timer.delay(TIMER_DELAY_SECS);
        }        

    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
