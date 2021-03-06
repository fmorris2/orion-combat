package org.data.enums.equipment;

import java.util.ArrayList;
import java.util.List;

import org.data.enums.CombatType;
import org.data.enums.equipment.melee.MeleeArmor;
import org.data.enums.equipment.melee.MeleeWeapon;
import org.osbot.rs07.api.ui.Skill;

import viking.framework.goal.impl.SkillGoal;
import viking.framework.goal.impl.TimeGoal;
import viking.framework.item_management.IMEntry;
import viking.framework.mission.Mission;

public class EquipmentIMGenerator
{
	public static IMEntry[] generate(Mission m, CombatType type)
	{
		if(type == CombatType.MELEE)
			return generateMelee(m);
		else if(type == CombatType.RANGE)
			return generateRange(m);
		
		return generateMagic(m);
	}
	
	private static IMEntry[] generateMelee(Mission m)
	{
		
		List<IMEntry> entries = new ArrayList<>();
		
		for(MeleeArmor armor : MeleeArmor.values())
		{
			if(armor == MeleeArmor.WOODEN_SHIELD)
				continue;
			
			entries.add(new IMEntry(m, armor.ITEM_ID, 1, armor.PRICE, armor.name().replaceAll("_", " ").toLowerCase(), 
					new SkillGoal(m.skills, Skill.DEFENCE, armor.DEF_LVL), new TimeGoal(60000 * 7)));
		}
		for(MeleeWeapon wep : MeleeWeapon.values())
		{
			if(wep == MeleeWeapon.BRONZE_SWORD)
				continue;
			
			entries.add(new IMEntry(m, wep.ITEM_ID, 1, wep.PRICE, wep.name().replaceAll("_", " ").toLowerCase(), 
					new SkillGoal(m.skills, Skill.ATTACK, wep.ATT_REQ), new TimeGoal(60000 * 7)));
		}	
		return entries.toArray(new IMEntry[entries.size()]);
	}
	
	private static IMEntry[] generateRange(Mission m)
	{
		return null;
	}
	
	private static IMEntry[] generateMagic(Mission m)
	{
		return null;
	}
}
