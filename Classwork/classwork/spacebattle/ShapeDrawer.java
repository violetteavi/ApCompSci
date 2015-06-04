package spacebattle;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import ihs.apcs.spacebattle.*;
import ihs.apcs.spacebattle.commands.*;

public class ShapeDrawer extends BasicSpaceship{

	private List<ShipCommand> commandQueue;
	private Point startLocation;
	private Point center;
	private double timeThrusted;
//	private boolean oriented = true;
	public static final double distanceTolerance = 1/100;

	public static void main(String[] args) {
		TextClient.run("10.1.17.158", new ShapeDrawer());
	}
	
	@Override
	public ShipCommand getNextCommand(BasicEnvironment arg0) {
		if(commandQueue.size()==0){
				drawSquare(true);
				drawStar(true);
				drawOctosquare(true);
		}
		if(commandQueue.size()>0) {
			return commandQueue.remove(0);
		}
		System.out.println("Idling");
		return new IdleCommand(1);
	}

	private void drawOctosquare(boolean destroy) {
		drawOctogon(false);
		commandQueue.add(new RotateCommand(90));
		commandQueue.add(new ThrustCommand('B', 3, 1.0));
		commandQueue.add(new IdleCommand(3));
		commandQueue.add(new ThrustCommand('F', 3, 1.0));
		commandQueue.add(new IdleCommand(3));
		commandQueue.add(new BrakeCommand(0));
		commandQueue.add(new RotateCommand(-90));
		drawSquare(false);
		if(destroy) {
			commandQueue.add(new IdleCommand(10));
			commandQueue.add(new DestroyAllLaserBeaconsCommand());
		}
	}

	private void drawOctogon(boolean destroy) {
		for(int i = 0; i < 8; i++) {
			drawLine(45);
		}
		if(destroy) {
			commandQueue.add(new IdleCommand(10));
			commandQueue.add(new DestroyAllLaserBeaconsCommand());
		}		
	}

	private void drawStar(boolean destroy) {
		for(int i = 0; i < 5; i++) {
			drawLine(144);
		}
		if(destroy) {
			commandQueue.add(new IdleCommand(10));
			commandQueue.add(new DestroyAllLaserBeaconsCommand());
		}
	}

	private void drawSquare(boolean destroy) {
		for(int i = 0; i < 4; i++) {
			drawLine(90);
		}
		if(destroy) {
			commandQueue.add(new IdleCommand(10));
			commandQueue.add(new DestroyAllLaserBeaconsCommand());
		}
	}

	private void drawLine(int degreesFromStraight) {
		commandQueue.add(new RotateCommand(degreesFromStraight));
		commandQueue.add(new DeployLaserBeaconCommand());
		commandQueue.add(new ThrustCommand('B', 3, 1.0));
		commandQueue.add(new IdleCommand(3));
		commandQueue.add(new ThrustCommand('F', 3, 1.0));
		commandQueue.add(new IdleCommand(3));
		commandQueue.add(new BrakeCommand(0));
		commandQueue.add(new DeployLaserBeaconCommand());
	}
	
//	private void moveToPoint(Point point, BasicEnvironment arg0) {
//		if(arg0.getShipStatus().getSpeed()<.1&&arg0.getShipStatus().getPosition().getDistanceTo(center)>center.getX()*distanceTolerance) {
//			startLocation = arg0.getShipStatus().getPosition();
//			timeThrusted = 0;
//			if(Math.abs(arg0.getShipStatus().getPosition().getAngleTo(center) - arg0.getShipStatus().getOrientation())%360 > 5 ) {
//				commandQueue.add(new RotateCommand(arg0.getShipStatus().getPosition().getAngleTo(center) - arg0.getShipStatus().getOrientation()));
//				commandQueue.add(new IdleCommand(3));
//			}
//		}
//		if(Math.abs(arg0.getShipStatus().getPosition().getAngleTo(center) - arg0.getShipStatus().getOrientation())%360 < 10) {
//			if(arg0.getShipStatus().getPosition().getDistanceTo(center)>startLocation.getDistanceTo(center)/1.9) {
//				commandQueue.add(new ThrustCommand('B', .5, 1.0));
//				commandQueue.add(new IdleCommand(.5));
//				timeThrusted += .5;
//			}
//			if(arg0.getShipStatus().getPosition().getDistanceTo(center)<startLocation.getDistanceTo(center)/1.9&&arg0.getShipStatus().getSpeed()>.001) {
//				commandQueue.add(new BrakeCommand(0));
//				commandQueue.add(new IdleCommand(timeThrusted));
//			}
//			if(arg0.getShipStatus().getSpeed()<.1&&arg0.getShipStatus().getPosition().getDistanceTo(center)<center.getX()*distanceTolerance) {
//				System.out.println("Braking");
//				commandQueue.add(new BrakeCommand(0));
//				commandQueue.add(new IdleCommand(3));
//				oriented = true;
//			}
//		}
//		
//	}

	@Override
	public RegistrationData registerShip(int numImages, int worldWidth, int worldHeight) {
		commandQueue = new LinkedList<ShipCommand>();
//		center = new Point(worldWidth/2, worldHeight/2);
		return new RegistrationData("Yo d0g I heard you like strs", Color.WHITE, 1);
	}

}
