package spacebattle;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import ihs.apcs.spacebattle.*;
import ihs.apcs.spacebattle.commands.*;
import ihs.apcs.spacebattle.games.*;

public class RandomWalkerShip implements Spaceship<DiscoveryQuestGameInfo>{
	private List<ShipCommand> commandQueue;
	private List<Integer> scannedIDs;
	private Point startLocation;
	private Point center;
	private double timeThrusted;
	private boolean oriented = false;
	private int justStarted = 2;
	private int steeredDirection = 1;
	private int numThrusts = 0;
	private static final double fracMaxSpeed = 2/3;
	private static final double distanceTolerance = 1/50;
	private static final double minSpeed = .1;
	private static final int maxNumThrusts = 12;

	public static void main(String[] args) {
		TextClient.run("10.1.17.158", new RandomWalkerShip());
	}
	
	@Override
	public ShipCommand getNextCommand(Environment<DiscoveryQuestGameInfo> arg0) {
		if(commandQueue.size()==0){
			if(arg0.getShipStatus().getEnergy()<5) {
				commandQueue.add(new IdleCommand(20));
			}
			if(arg0.getRadar()!=null) {
				scanThings(arg0);
			}
			if(justStarted == 2) {
				justStarted--;
			} else if(justStarted == 1) {
				justStarted--;
				commandQueue.add(new IdleCommand(3.5));
			} else {
				randomWalk(arg0);
			}
			commandQueue.add(new RadarCommand(2));
		}
		if(commandQueue.size()>0) {
			return commandQueue.remove(0);
		}
		System.out.println("Idling");
		return new IdleCommand(1);
	}

	private void scanThings(Environment<DiscoveryQuestGameInfo> arg0) {
		List<ObjectStatus> statuses = arg0.getRadar();
		for(ObjectStatus status: statuses) {
			if(status.getPosition().getDistanceTo(arg0.getShipStatus().getPosition())<150) {
				if(!scannedIDs.contains(status.getId())) {
					commandQueue.add(new ScanCommand(status.getId()));
					scannedIDs.add(status.getId());
					if(!isBraking()) {
						commandQueue.add(new BrakeCommand(0));
					}
				}
			}
		}		
	}

	private boolean isBraking() {
		for(ShipCommand command: commandQueue) {
			if(command.getClass().equals(BrakeCommand.class)) {
				return true;
			}
		}
		return false;
	}

	private void randomWalk(Environment<DiscoveryQuestGameInfo> arg0) {		
		commandQueue.add(new ThrustCommand('B', 2, 1.0));
		numThrusts++;
		double rotation = steeredDirection*Math.random()*180;
		commandQueue.add(new RotateCommand(rotation));
		commandQueue.add(new SteerCommand(rotation));
		steeredDirection*=-1;
	}

	@Override
	public RegistrationData registerShip(int numImages, int worldWidth, int worldHeight) {
		scannedIDs = new LinkedList<Integer>();
		commandQueue = new LinkedList<ShipCommand>();
		center = new Point(worldWidth/2, worldHeight/2);
		return new RegistrationData("Players Connected", Color.WHITE, 1);
	}

	@Override
	public void shipDestroyed(String killer) {
		justStarted = 2;
	}

}
