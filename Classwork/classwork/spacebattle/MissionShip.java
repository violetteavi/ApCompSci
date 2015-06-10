package spacebattle;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import ihs.apcs.spacebattle.*;
import ihs.apcs.spacebattle.commands.*;
import ihs.apcs.spacebattle.games.*;

public class MissionShip implements Spaceship<DiscoveryQuestGameInfo>{
	private List<ShipCommand> commandQueue;
	private List<Integer> seenIDs;
	private List<Integer> actuallyScannedIDs;
	private int justStarted = 2;
	private int steeredDirection = 1;
	private int numThrusts = 0;

	public static void main(String[] args) {
		TextClient.run("10.1.24.254", new MissionShip());
	}
	
	@Override
	public ShipCommand getNextCommand(Environment<DiscoveryQuestGameInfo> arg0) {
		updateIDs(arg0);
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

	private void updateIDs(Environment<DiscoveryQuestGameInfo> arg0) {
		for(Integer id: arg0.getGameInfo().getLastSuccessfulIds()) {
			actuallyScannedIDs.add(id);
		}
		System.out.println("Seen: " + seenIDs.size()+ " Actually scanned: " + actuallyScannedIDs.size());
		
	}

	private void scanThings(Environment<DiscoveryQuestGameInfo> arg0) {
		List<ObjectStatus> statuses = arg0.getRadar();
		for(ObjectStatus status: statuses) {
			if(status.getPosition().getDistanceTo(arg0.getShipStatus().getPosition())<150) {
//				if(!scannedIDs.contains(status.getId())) {
				if(scannable(status.getId(), arg0)) {
					commandQueue.add(new ScanCommand(status.getId()));
					seenIDs.add(status.getId());
					if(!isBraking()) {
						commandQueue.add(new BrakeCommand(0));
					}
				}
			}
		}		
	}

	private boolean scannable(int id, Environment<DiscoveryQuestGameInfo> arg0) {
		for(Integer scanned: actuallyScannedIDs) {
			if(scanned==id) {
				return false;
			}
		}
		for(Integer scanning: arg0.getGameInfo().getScanIdsInProgress()) {
			if(scanning==id) {
				return false;
			}
		}
		return true;
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
		seenIDs = new LinkedList<Integer>();
		actuallyScannedIDs = new LinkedList<Integer>();
		commandQueue = new LinkedList<ShipCommand>();
		return new RegistrationData("Players Connected", Color.WHITE, 1);
	}

	@Override
	public void shipDestroyed(String killer) {
		justStarted = 2;
	}

}
