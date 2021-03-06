package org.data.location.chicken;

import org.data.enums.MONSTER;
import org.data.location.CombatLocation;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

import viking.api.banking.enums.BankLocation;

public class LumbridgeChickens extends CombatLocation
{
	
	@Override
	public Area constructArea()
	{
		return new Area(3225, 3300, 3236, 3287);
	}

	@Override
	public Position constructDepositBoxTile()
	{
		return null;
	}

	@Override
	public Position getCenterTile()
	{
		return new Position(3232, 3293, 0);
	}

	@Override
	protected MONSTER[] getSupportedMonsters()
	{
		return new MONSTER[]{MONSTER.CHICKEN};
	}

	@Override
	protected int[] getRequiredItems()
	{
		return null;
	}

	@Override
	protected Position[] getSafeSpots()
	{
		return null;
	}

	@Override
	protected BankLocation getBank()
	{
		return BankLocation.LUMBRIDGE_UPPER;
	}
	
}
