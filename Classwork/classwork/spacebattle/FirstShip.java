package spacebattle;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import ihs.apcs.spacebattle.*;
import ihs.apcs.spacebattle.commands.*;

public class FirstShip extends BasicSpaceship{

	private List<ShipCommand> commandQueue;
	private Point startLocation;
	private Point center;
	public static final double distanceTolerance = 1/100;
	
	public static void main(String[] args) {
		TextClient.run("10.1.17.118", new FirstShip());
	}
	
	@Override
	public ShipCommand getNextCommand(BasicEnvironment arg0) {
//		if(degreesToCenter()!=0) {
//			if(arg0.getShipStatus().getSpeed()!=0) {
//				return new BrakeCommand(0);
//			} else if(arg0.getShipStatus().getRotationSpeed()!=0){
//				return new RotateCommand(degreesToCenter());
//			}
//		}
		if(commandQueue.size()==0){
			moveToPoint(center, arg0);
//			thrust(85);
		}
		if(commandQueue.size()>0) {
			return commandQueue.remove(0);
		}
		System.out.println("Idling");
		return new IdleCommand(1);
	}
//	private void move(BasicEnvironment arg0) {
//		System.out.println("Trying to Move");
//		if(arg0.getShipStatus().getSpeed()<0.1) {
//			System.out.println("Moving");
//			commandQueue.add(new ThrustCommand('B', 10.0, 1.0));
//			commandQueue.add(new IdleCommand(11));
//			commandQueue.add(new ThrustCommand('F', 10.0, 1.0));
//			commandQueue.add(new IdleCommand(11));
//			commandQueue.add(new BrakeCommand(0));
//			commandQueue.add(new IdleCommand(3));
//		}
//	}
	
	private void moveToPoint(Point point, BasicEnvironment arg0) {
		System.out.println("Attempting to move");
		if(arg0.getShipStatus().getSpeed()<.1&&arg0.getShipStatus().getPosition().getDistanceTo(center)>center.getX()*distanceTolerance) {
			startLocation = arg0.getShipStatus().getPosition();
			if(Math.abs(arg0.getShipStatus().getPosition().getAngleTo(center) - arg0.getShipStatus().getOrientation())%360 > 5 ) {
				commandQueue.add(new RotateCommand(arg0.getShipStatus().getPosition().getAngleTo(center) - arg0.getShipStatus().getOrientation()));
				commandQueue.add(new IdleCommand(3));
			}
		}
		if(Math.abs(arg0.getShipStatus().getPosition().getAngleTo(center) - arg0.getShipStatus().getOrientation())%360 < 10) {
			if(arg0.getShipStatus().getPosition().getDistanceTo(center)>startLocation.getDistanceTo(center)/1.9) {
				commandQueue.add(new ThrustCommand('B', 1, 1.0));
				commandQueue.add(new IdleCommand(1));
				System.out.println("Moving");
			}
			if(arg0.getShipStatus().getPosition().getDistanceTo(center)<startLocation.getDistanceTo(center)/1.9) {
				System.out.println("Decelerating");
				commandQueue.add(new BrakeCommand(0));
				commandQueue.add(new IdleCommand(5));
			}
		}
	}

//	private void moveToPoint(Point point, Environment arg0) {
//		System.out.println("Attempting to move");
//		if(arg0.getShipStatus().getSpeed()<.1&&arg0.getShipStatus().getPosition().getDistanceTo(center)>center.getX()*distanceTolerance) {
//			startLocation = arg0.getShipStatus().getPosition();
//			System.out.println("Fixed start location");
//		}
//		if(arg0.getShipStatus().getPosition().getDistanceTo(center)>startLocation.getDistanceTo(center)/2) {
//			thrust(arg0.getShipStatus().getPosition().getAngleTo(center)-arg0.getShipStatus().getOrientation());
//			System.out.println("Moving");
//		}
//		if(arg0.getShipStatus().getPosition().getDistanceTo(center)<startLocation.getDistanceTo(center)/2) {
//			System.out.println("Decelearating");
//			thrust(arg0.getShipStatus().getPosition().getAngleTo(center)-arg0.getShipStatus().getOrientation() + 180);
//		}
//	}

public void thrust(double d) {
		double yThrust = 0;
		double xThrust = 0;
		while(Math.abs(d)>180) {
			if(d<0) {
				d+=360;
			} else {
				d-=360;
			}
		}
		if(d>=0&&d<90) {
			yThrust = 1 / (1 + Math.tan(d* 2 * Math.PI/360));
			xThrust = 1 - yThrust;
			if(xThrust<0.1) {
				xThrust = 0.1;
			}
			if(yThrust<0.1) {
				yThrust = 0.1;
			}
			commandQueue.add(new ThrustCommand('B', 1, yThrust));
			commandQueue.add(new ThrustCommand('R', 1, xThrust));
			commandQueue.add(new IdleCommand(1));
		}
		if(d>=180&&d<-90) {
			yThrust = 1 / (1 + Math.tan(d* 2 * Math.PI/360));
			xThrust = 1 - yThrust;
			if(xThrust<0.1) {
				xThrust = 0.1;
			}
			if(yThrust<0.1) {
				yThrust = 0.1;
			}
			commandQueue.add(new ThrustCommand('F', 1, yThrust));
			commandQueue.add(new ThrustCommand('L', 1, xThrust));
			commandQueue.add(new IdleCommand(1));
		}
		if(d>=-90&&d<0) {
			yThrust = 1 / (1 + -Math.tan(d* 2 * Math.PI/360));
			xThrust = 1 - yThrust;
			if(xThrust<0.1) {
				xThrust = 0.1;
			}
			if(yThrust<0.1) {
				yThrust = 0.1;
			}
			commandQueue.add(new ThrustCommand('B', 1, yThrust));
			commandQueue.add(new ThrustCommand('L', 1, xThrust));
			commandQueue.add(new IdleCommand(1));
		}
		if(d>=90&&d<=180) {
			yThrust = 1 / (1 + -Math.tan(d* 2 * Math.PI/360));
			xThrust = 1 - yThrust;
			if(xThrust<0.1) {
				xThrust = 0.1;
			}
			if(yThrust<0.1) {
				yThrust = 0.1;
			}
			commandQueue.add(new ThrustCommand('F', 1, yThrust));
			commandQueue.add(new ThrustCommand('R', 1, xThrust));
			commandQueue.add(new IdleCommand(1));
		}
	}

//	private double degreesToCenter() {
//		return ;
//	}
	

	@Override
	public RegistrationData registerShip(int numImages, int worldWidth, int worldHeight) {
		commandQueue = new LinkedList<ShipCommand>();
		center = new Point(worldWidth/2, worldHeight/2);
		return new RegistrationData("Yo dawg I heard you like strs", Color.WHITE, 1);
	}

	@Override
	public void shipDestroyed() {
		// TODO Auto-generated method stub
		
	}

	
}
