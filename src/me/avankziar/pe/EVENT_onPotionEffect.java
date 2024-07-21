package me.avankziar.pe;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent.Action;
import org.bukkit.event.entity.LingeringPotionSplashEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EVENT_onPotionEffect implements Listener 
{
	
	public YamlConfiguration cfg() 
	{
		return PotionExtender.getPlugin().cfg();
	}
	
	@EventHandler
	public void onLingeringPotionSplash(LingeringPotionSplashEvent event) 
	{
		float alpha = 0.6F;
		int beta = cfg().getInt("PE.lingering-potion.radius");
		float gamma = alpha * (float) beta;
		event.getAreaEffectCloud().setRadius(gamma);
		float delta = (float)-cfg().getDouble("PE.lingering-potion.radius_on_use");
		event.getAreaEffectCloud().setRadiusOnUse(delta);
		float epsilon = (float)-cfg().getDouble("PE.lingering-potion.radius_per_tick");
		event.getAreaEffectCloud().setRadiusPerTick(epsilon);
		int zeta = cfg().getInt("PE.lingering-potion.reapplication_delay");
		event.getAreaEffectCloud().setReapplicationDelay(zeta);
	}
	
	/*@EventHandler
	public void aonPotionEffectChange(EntityPotionEffectEvent event)
	{
		if(!(event.getEntity() instanceof LivingEntity))
		{
			return;
		}
		if(event.getEntity()==null)
		{
			return;
		}
		
		int dur = 0;
		int amp = 0;
		PotionEffect effect = null;
		
		if(event.getOldEffect() == null)
		{
			return;
		}
		dur = event.getOldEffect().getDuration();
		amp = event.getOldEffect().getAmplifier();
		effect = event.getOldEffect();
		
		PotionEffect potion = null;
		PotionEffectType meta = null;
		
		LivingEntity all = (LivingEntity) event.getEntity();
		
		int Dur = 0;
        int Amp = 0;
        if(event.getNewEffect() == null)
		{
			return;
		}
        potion = event.getNewEffect();
		meta = potion.getType();
		for(PotionEffectType pets : getPet())
		{
			if(meta.equals(pets)) 
	    	{
	    		Dur = potion.getDuration();
	    		Amp = potion.getAmplifier();
	    	}
		}
        EntityPotionEffectEvent.Action ac = event.getAction();
		
		if(ac == Action.ADDED)
		{
			for(PotionEffectType pets : getPet())
			{
				if(meta.equals(pets)) 
		    	{
					all.addPotionEffect(new PotionEffect(pets, Dur, Amp));
		    	}
			}
		}
		if(ac == Action.CHANGED)
		{
			for(PotionEffectType pets : getPet())
			{
				if(effect.getType().toString().equals(pets.toString())) 
	    		{
	    			if(meta.equals(pets))
	    			{
	            		if(amp==Amp)
	            		{
	            			event.setCancelled(true);
	            			all.removePotionEffect(PotionEffectType.ABSORPTION);
							all.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, dur+Dur, Amp));
	            		} else if(amp!=Amp)
	            		{
	            			event.setCancelled(true);
	            			all.removePotionEffect(PotionEffectType.ABSORPTION);
							all.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, Dur, Amp));
	            		}
	    			}
	    		}
			}
			
		}
	}
	
	private List<PotionEffectType> getPet()
	{
		List<PotionEffectType> pet = new ArrayList<PotionEffectType>();
		pet.add(PotionEffectType.ABSORPTION);
		pet.add(PotionEffectType.BAD_OMEN);
		pet.add(PotionEffectType.BLINDNESS);
		pet.add(PotionEffectType.CONDUIT_POWER);
		pet.add(PotionEffectType.BLINDNESS);
		pet.add(PotionEffectType.RESISTANCE);
		pet.add(PotionEffectType.DOLPHINS_GRACE);
		pet.add(PotionEffectType.HASTE);
		pet.add(PotionEffectType.FIRE_RESISTANCE);
		pet.add(PotionEffectType.GLOWING);
		pet.add(PotionEffectType.INSTANT_DAMAGE);
		pet.add(PotionEffectType.HEAL);
		pet.add(PotionEffectType.HEALTH_BOOST);
		pet.add(PotionEffectType.HERO_OF_THE_VILLAGE);
		pet.add(PotionEffectType.HUNGER);
		pet.add(PotionEffectType.INCREASE_DAMAGE);
		pet.add(PotionEffectType.INVISIBILITY);
		pet.add(PotionEffectType.JUMP);
		pet.add(PotionEffectType.LEVITATION);
		pet.add(PotionEffectType.LUCK);
		pet.add(PotionEffectType.NIGHT_VISION);
		pet.add(PotionEffectType.POISON);
		pet.add(PotionEffectType.REGENERATION);
		pet.add(PotionEffectType.SATURATION);
		pet.add(PotionEffectType.SLOW);
		pet.add(PotionEffectType.SLOW_DIGGING);
		pet.add(PotionEffectType.SLOW_FALLING);
		pet.add(PotionEffectType.SPEED);
		pet.add(PotionEffectType.UNLUCK);
		pet.add(PotionEffectType.WATER_BREATHING);
		pet.add(PotionEffectType.WEAKNESS);
		pet.add(PotionEffectType.WITHER);
		return pet;
	}*/
	
	@EventHandler
	public void onPotionEffectChange(EntityPotionEffectEvent event)
	{
		if(!(event.getEntity() instanceof LivingEntity))
		{
			return;
		}
		if(event.getEntity()==null)
		{
			return;
		}
		int dur = 0;
		int amp = 0;
		PotionEffect effect = null;
		if(event.getOldEffect() == null)
		{
			return;
		}
		dur = event.getOldEffect().getDuration();
		amp = event.getOldEffect().getAmplifier();
		effect = event.getOldEffect();
		PotionEffect potion = null;
		PotionEffectType meta = null;
		LivingEntity all = (LivingEntity) event.getEntity();
		int Dur_ABSORPTION = 0;
        int Amp_ABSORPTION = 0;
        int Dur_BAD_OMEN = 0;
        int Amp_BAD_OMEN = 0;
        int Dur_BLINDNESS = 0;
        int Amp_BLINDNESS = 0;
        int Dur_CONDUIT_POWER = 0;
        int Amp_CONDUIT_POWER = 0;
        int Dur_NAUSEA = 0;
        int Amp_NAUSEA = 0;
        int Dur_DAMAGE_RESISTANCE = 0;
        int Amp_DAMAGE_RESISTANCE = 0;
        int Dur_DARKNESS = 0;
        int Amp_DARKNESS = 0;
        int Dur_DOLPHINS_GRACE = 0;
        int Amp_DOLPHINS_GRACE = 0;
        int Dur_FAST_DIGGING = 0;
        int Amp_FAST_DIGGING = 0;
        int Dur_FIRE_RESISTANCE = 0;
		int Amp_FIRE_RESISTANCE = 0;
        int Dur_GLOWING = 0;
        int Amp_GLOWING = 0;
        int Dur_HARM = 0;
        int Amp_HARM = 0;
        int Dur_HEAL = 0;
        int Amp_HEAL = 0;
        int Dur_HEALTH_BOOST = 0;
        int Amp_HEALTH_BOOST = 0;
        int Dur_HERO_OF_THE_VILLAGE = 0;
        int Amp_HERO_OF_THE_VILLAGE = 0;
        int Dur_HUNGER = 0;
        int Amp_HUNGER = 0;
        int Dur_INCREASE_DAMAGE = 0;
        int Amp_INCREASE_DAMAGE = 0;
        int Dur_INVISIBILITY = 0;
        int Amp_INVISIBILITY = 0;
        int Dur_JUMP = 0;
        int Amp_JUMP = 0;
        int Dur_LEVITATION = 0;
        int Amp_LEVITATION = 0;
        int Dur_LUCK = 0;
        int Amp_LUCK = 0;
        int Dur_NIGHT_VISION = 0;
        int Amp_NIGHT_VISION = 0;
        int Dur_POISON = 0;
        int Amp_POISON = 0;
        int Dur_REGENERATION = 0;
        int Amp_REGENERATION = 0;
        int Dur_SATURATION = 0;
        int Amp_SATURATION = 0;
        int Dur_SLOW = 0;
        int Amp_SLOW = 0;
        int Dur_SLOW_DIGGING = 0;
        int Amp_SLOW_DIGGING = 0;
        int Dur_SLOW_FALLING = 0;
        int Amp_SLOW_FALLING = 0;
        int Dur_SPEED = 0;
        int Amp_SPEED = 0;
        int Dur_UNLUCK = 0;
        int Amp_UNLUCK = 0;
        int Dur_WATER_BREATHING = 0;
        int Amp_WATER_BREATHING = 0;
        int Dur_WEAKNESS = 0;
        int Amp_WEAKNESS = 0;
        int Dur_WITHER = 0;
        int Amp_WITHER = 0;
        int Dur_TRIAL_OMEN = 0;
        int Amp_TRIAL_OMEN = 0;
        int Dur_RAID_OMEN = 0;
        int Amp_RAID_OMEN = 0;
        int Dur_WIND_CHARGED = 0;
        int Amp_WIND_CHARGED = 0;
        int Dur_WEAVING = 0;
        int Amp_WEAVING = 0;
        int Dur_OOZING = 0;
        int Amp_OOZING = 0;
        int Dur_INFESTED = 0;
        int Amp_INFESTED = 0;
		if(event.getNewEffect() == null)
		{
			return;
		}
		
		potion = event.getNewEffect();
		meta = potion.getType();
		
		if(meta.equals(PotionEffectType.ABSORPTION)) 
    	{
    		Dur_ABSORPTION = potion.getDuration();
    		Amp_ABSORPTION = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.BAD_OMEN)) 
    	{
    		Dur_BAD_OMEN = potion.getDuration();
    		Amp_BAD_OMEN = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.BLINDNESS)) 
    	{
    		Dur_BLINDNESS = potion.getDuration();
    		Amp_BLINDNESS = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.CONDUIT_POWER))
    	{
    		Dur_CONDUIT_POWER = potion.getDuration();
    		Amp_CONDUIT_POWER = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.NAUSEA)) 
    	{
    		Dur_NAUSEA = potion.getDuration();
    		Amp_NAUSEA = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.RESISTANCE)) 
    	{
    		Dur_DAMAGE_RESISTANCE = potion.getDuration();
    		Amp_DAMAGE_RESISTANCE = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.DARKNESS)) 
    	{
    		Dur_DARKNESS = potion.getDuration();
    		Amp_DARKNESS = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.DOLPHINS_GRACE))
    	{
    		Dur_DOLPHINS_GRACE = potion.getDuration();
    		Amp_DOLPHINS_GRACE = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.HASTE)) 
    	{
    		Dur_FAST_DIGGING = potion.getDuration();
    		Amp_FAST_DIGGING = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.FIRE_RESISTANCE))
    	{
    		Dur_FIRE_RESISTANCE = potion.getDuration();
    		Amp_FIRE_RESISTANCE = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.GLOWING)) 
    	{
    		Dur_GLOWING = potion.getDuration();
    		Amp_GLOWING = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.INSTANT_DAMAGE)) 
    	{
    		Dur_HARM = potion.getDuration();
    		Amp_HARM = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.INSTANT_HEALTH)) 
    	{
    		Dur_HEAL = potion.getDuration();
    		Amp_HEAL = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.HEALTH_BOOST)) 
    	{
    		Dur_HEALTH_BOOST = potion.getDuration();
    		Amp_HEALTH_BOOST = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.HERO_OF_THE_VILLAGE)) 
    	{
    		Dur_HERO_OF_THE_VILLAGE = potion.getDuration();
    		Amp_HERO_OF_THE_VILLAGE = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.HUNGER)) 
    	{
    		Dur_HUNGER = potion.getDuration();
    		Amp_HUNGER = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.STRENGTH)) 
    	{
    		Dur_INCREASE_DAMAGE = potion.getDuration();
    		Amp_INCREASE_DAMAGE = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.INVISIBILITY)) 
    	{
    		Dur_INVISIBILITY = potion.getDuration();
    		Amp_INVISIBILITY = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.JUMP_BOOST))
        {
     		Dur_JUMP = potion.getDuration();
     		Amp_JUMP = potion.getAmplifier();	
        } else if(meta.equals(PotionEffectType.LEVITATION)) 
    	{
    		Dur_LEVITATION = potion.getDuration();
    		Amp_LEVITATION = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.LUCK)) 
    	{
    		Dur_LUCK = potion.getDuration();
    		Amp_LUCK = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.NIGHT_VISION)) 
    	{
    		Dur_NIGHT_VISION = potion.getDuration();
    		Amp_NIGHT_VISION = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.POISON)) 
    	{
    		Dur_POISON = potion.getDuration();
    		Amp_POISON = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.REGENERATION)) 
    	{
    		Dur_REGENERATION = potion.getDuration();
    		Amp_REGENERATION = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.SATURATION)) 
    	{
    		Dur_SATURATION = potion.getDuration();
    		Amp_SATURATION = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.SLOWNESS)) 
    	{
    		Dur_SLOW = potion.getDuration();
    		Amp_SLOW = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.MINING_FATIGUE)) 
    	{
    		Dur_SLOW_DIGGING = potion.getDuration();
    		Amp_SLOW_DIGGING = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.SLOW_FALLING)) 
    	{
    		Dur_SLOW_FALLING = potion.getDuration();
    		Amp_SLOW_FALLING = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.SPEED)) 
    	{
    		Dur_SPEED = potion.getDuration();
    		Amp_SPEED = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.UNLUCK)) 
    	{
    		Dur_UNLUCK = potion.getDuration();
    		Amp_UNLUCK = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.WATER_BREATHING)) 
    	{
    		Dur_WATER_BREATHING = potion.getDuration();
    		Amp_WATER_BREATHING = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.WEAKNESS)) 
    	{
    		Dur_WEAKNESS = potion.getDuration();
    		Amp_WEAKNESS = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.WITHER)) 
    	{
    		Dur_WITHER = potion.getDuration();
    		Amp_WITHER = potion.getAmplifier();
    	} else if(meta.equals(PotionEffectType.TRIAL_OMEN)) 
     	{
     		Dur_TRIAL_OMEN = potion.getDuration();
     		Amp_TRIAL_OMEN = potion.getAmplifier();
     	} else if(meta.equals(PotionEffectType.RAID_OMEN)) 
     	{
     		Dur_RAID_OMEN = potion.getDuration();
     		Amp_RAID_OMEN = potion.getAmplifier();
     	} else if(meta.equals(PotionEffectType.WIND_CHARGED)) 
     	{
     		Dur_WIND_CHARGED = potion.getDuration();
     		Amp_WIND_CHARGED = potion.getAmplifier();
     	} else if(meta.equals(PotionEffectType.WEAVING)) 
     	{
     		Dur_WEAVING = potion.getDuration();
     		Amp_WEAVING = potion.getAmplifier();
     	} else if(meta.equals(PotionEffectType.OOZING)) 
     	{
     		Dur_OOZING = potion.getDuration();
     		Amp_OOZING = potion.getAmplifier();
     	} else if(meta.equals(PotionEffectType.INFESTED)) 
     	{
     		Dur_INFESTED = potion.getDuration();
     		Amp_INFESTED = potion.getAmplifier();
     	}
		
		EntityPotionEffectEvent.Action ac = event.getAction();
		
		if(event.getEntity() instanceof Player)
		{
			boolean usePermission = cfg().getBoolean("PE.usePermission", false);
			Player player = (Player) event.getEntity();
			EntityPotionEffectEvent.Cause cause = event.getCause();
			if(usePermission)
			{
				if(!player.hasPermission("pe.cause."+cause.toString().toLowerCase()))
				{
					return;
				}
			}
		}
		
		if(ac == Action.ADDED)
		{
			if(meta.equals(PotionEffectType.ABSORPTION)) 
            {
        		all.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION,Dur_ABSORPTION, Amp_ABSORPTION));
            }
			if(meta.equals(PotionEffectType.BAD_OMEN)) 
            {
        		all.addPotionEffect(new PotionEffect(PotionEffectType.BAD_OMEN,Dur_BAD_OMEN, Amp_BAD_OMEN));
            }
        	if(meta.equals(PotionEffectType.BLINDNESS)) 
            {
        		all.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,Dur_BLINDNESS, Amp_BLINDNESS));
            }
        	if(meta.equals(PotionEffectType.CONDUIT_POWER)) 
            {
            	all.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER,Dur_CONDUIT_POWER, Amp_CONDUIT_POWER));
            }
        	if(meta.equals(PotionEffectType.NAUSEA)) 
            {
       		 	all.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA,Dur_NAUSEA, Amp_NAUSEA));
            }
        	if(meta.equals(PotionEffectType.RESISTANCE)) 
            {
       		 	all.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE,Dur_DAMAGE_RESISTANCE, Amp_DAMAGE_RESISTANCE));
            }
        	if(meta.equals(PotionEffectType.DARKNESS)) 
            {
       		 	all.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS,Dur_DARKNESS, Amp_DARKNESS));
            }
        	if(meta.equals(PotionEffectType.DOLPHINS_GRACE)) 
            {
            	all.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER,Dur_DOLPHINS_GRACE, Amp_DOLPHINS_GRACE));
            }
        	if(meta.equals(PotionEffectType.HASTE)) 
            {
       		 	all.addPotionEffect(new PotionEffect(PotionEffectType.HASTE,Dur_FAST_DIGGING, Amp_FAST_DIGGING));
            }
        	if(meta.equals(PotionEffectType.FIRE_RESISTANCE)) 
        	{
        		all.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,Dur_FIRE_RESISTANCE, Amp_FIRE_RESISTANCE));
            }
        	if(meta.equals(PotionEffectType.GLOWING)) 
            {
        		all.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,Dur_GLOWING, Amp_GLOWING));
            }
        	if(meta.equals(PotionEffectType.INSTANT_DAMAGE)) 
            {
       		 	all.addPotionEffect(new PotionEffect(PotionEffectType.INSTANT_DAMAGE,Dur_HARM, Amp_HARM));
            }
        	if(meta.equals(PotionEffectType.INSTANT_HEALTH))
            {
       		 	all.addPotionEffect(new PotionEffect(PotionEffectType.INSTANT_HEALTH,Dur_HEAL, Amp_HEAL));
            }
       	 	if(meta.equals(PotionEffectType.HEALTH_BOOST)) 
            {
       	 		all.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,Dur_HEALTH_BOOST, Amp_HEALTH_BOOST));
            }
       	 	if(meta.equals(PotionEffectType.HERO_OF_THE_VILLAGE)) 
       	 	{
    	 		all.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE,Dur_HERO_OF_THE_VILLAGE, Amp_HERO_OF_THE_VILLAGE));
       	 	}
       	 	if(meta.equals(PotionEffectType.HUNGER)) 
       	 	{
       	 		all.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER,Dur_HUNGER, Amp_HUNGER));
       	 	}
       	 	if(meta.equals(PotionEffectType.STRENGTH)) 
       	 	{
	    		all.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH,Dur_INCREASE_DAMAGE, Amp_INCREASE_DAMAGE));
	        }
       	 	if(meta.equals(PotionEffectType.INVISIBILITY)) 
			{
       	 		all.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,Dur_INVISIBILITY, Amp_INVISIBILITY));
			}
        	if(meta.equals(PotionEffectType.JUMP_BOOST))
        	{
        		all.addPotionEffect(new PotionEffect(PotionEffectType.JUMP_BOOST,Dur_JUMP, Amp_JUMP));
        	}
        	if(meta.equals(PotionEffectType.LEVITATION)) 
            {
       		 	all.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,Dur_LEVITATION, Amp_LEVITATION));
            }
        	if(meta.equals(PotionEffectType.LUCK)) 
            {
        		all.addPotionEffect(new PotionEffect(PotionEffectType.LUCK,Dur_LUCK, Amp_LUCK));
            }
        	if(meta.equals(PotionEffectType.NIGHT_VISION)) 
            {
        		all.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,Dur_NIGHT_VISION, Amp_NIGHT_VISION));
			}
        	if(meta.equals(PotionEffectType.POISON)) 
            {
       		 	all.addPotionEffect(new PotionEffect(PotionEffectType.POISON,Dur_POISON, Amp_POISON));
            }
        	if(meta.equals(PotionEffectType.REGENERATION)) 
       		{
        		all.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,Dur_REGENERATION, Amp_REGENERATION));
            }
        	if(meta.equals(PotionEffectType.SATURATION)) 
            {
        		all.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION,Dur_SATURATION, Amp_SATURATION));
            }
        	if(meta.equals(PotionEffectType.SLOWNESS)) 
            {
        		all.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS,Dur_SLOW, Amp_SLOW));
            }
        	if(meta.equals(PotionEffectType.MINING_FATIGUE)) 
       	 	{
        		all.addPotionEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE,Dur_SLOW_DIGGING, Amp_SLOW_DIGGING));
            }
        	if(meta.equals(PotionEffectType.SLOW_FALLING)) 
            {
        		all.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,Dur_SLOW_FALLING, Amp_SLOW_FALLING));
            }
        	if(meta.equals(PotionEffectType.SPEED)) 
            {
        		all.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,Dur_SPEED, Amp_SPEED));
            }
        	if(meta.equals(PotionEffectType.UNLUCK)) 
            {
        		all.addPotionEffect(new PotionEffect(PotionEffectType.UNLUCK,Dur_UNLUCK, Amp_UNLUCK));
            }
        	if(meta.equals(PotionEffectType.WATER_BREATHING)) 
            {
        		all.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,Dur_WATER_BREATHING, Amp_WATER_BREATHING));
            }
        	if(meta.equals(PotionEffectType.WEAKNESS)) 
            {
        		all.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,Dur_WEAKNESS, Amp_WEAKNESS));
            }
        	if(meta.equals(PotionEffectType.WITHER)) 
       		{
       		 	all.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,Dur_WITHER, Amp_WITHER));
       		}
        	if(meta.equals(PotionEffectType.TRIAL_OMEN)) 
       		{
       		 	all.addPotionEffect(new PotionEffect(PotionEffectType.TRIAL_OMEN,Dur_TRIAL_OMEN, Amp_TRIAL_OMEN));
       		}
        	if(meta.equals(PotionEffectType.RAID_OMEN)) 
       		{
       		 	all.addPotionEffect(new PotionEffect(PotionEffectType.RAID_OMEN,Dur_RAID_OMEN, Amp_RAID_OMEN));
       		}
        	if(meta.equals(PotionEffectType.WIND_CHARGED)) 
       		{
       		 	all.addPotionEffect(new PotionEffect(PotionEffectType.WIND_CHARGED,Dur_WIND_CHARGED, Amp_WIND_CHARGED));
       		}
        	if(meta.equals(PotionEffectType.WEAVING)) 
       		{
       		 	all.addPotionEffect(new PotionEffect(PotionEffectType.WEAVING,Dur_WEAVING, Amp_WEAVING));
       		}
        	if(meta.equals(PotionEffectType.OOZING)) 
       		{
       		 	all.addPotionEffect(new PotionEffect(PotionEffectType.OOZING,Dur_OOZING, Amp_OOZING));
       		}
        	if(meta.equals(PotionEffectType.INFESTED)) 
       		{
       		 	all.addPotionEffect(new PotionEffect(PotionEffectType.INFESTED,Dur_INFESTED, Amp_INFESTED));
       		}
        	return;
		}
		if(ac == Action.CHANGED)
		{
			if(effect.getType().toString().equals(PotionEffectType.ABSORPTION.toString())) 
    		{
    			if(meta.equals(PotionEffectType.ABSORPTION))
    			{
            		if(amp==Amp_ABSORPTION)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.ABSORPTION);
						all.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION,dur+Dur_ABSORPTION, Amp_ABSORPTION));
            		} else if(amp!=Amp_ABSORPTION)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.ABSORPTION);
						all.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION,Dur_ABSORPTION, Amp_ABSORPTION));
            		}
    			}
    		}
			if(effect.getType().toString().equals(PotionEffectType.BAD_OMEN.toString())) 
    		{
    			if(meta.equals(PotionEffectType.BAD_OMEN))
    			{
            		if(amp==Amp_BAD_OMEN)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.BAD_OMEN);
						all.addPotionEffect(new PotionEffect(PotionEffectType.BAD_OMEN,dur+Dur_BAD_OMEN, Amp_BAD_OMEN));
            		} else if(amp!=Amp_BAD_OMEN)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.BAD_OMEN);
						all.addPotionEffect(new PotionEffect(PotionEffectType.BAD_OMEN,Dur_BAD_OMEN, Amp_BAD_OMEN));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.BLINDNESS.toString())) 
    		{
    			if(meta.equals(PotionEffectType.BLINDNESS))
    			{
            		if(amp==Amp_BLINDNESS)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.BLINDNESS);
						all.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,dur+Dur_BLINDNESS, Amp_BLINDNESS));
            		} else if(amp!=Amp_BLINDNESS)
            		{
            			all.removePotionEffect(PotionEffectType.BLINDNESS);
						all.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,Dur_BLINDNESS, Amp_BLINDNESS));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.CONDUIT_POWER.toString())) 
    		{
    			if(meta.equals(PotionEffectType.CONDUIT_POWER))
    			{
            		if(amp==Amp_CONDUIT_POWER)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.CONDUIT_POWER);
						all.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER,dur+Dur_CONDUIT_POWER, Amp_CONDUIT_POWER));
            		} else if(amp!=Amp_CONDUIT_POWER)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.CONDUIT_POWER);
						all.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER,Dur_CONDUIT_POWER, Amp_CONDUIT_POWER));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.NAUSEA.toString())) 
    		{
    			if(meta.equals(PotionEffectType.NAUSEA))
    			{
            		if(amp==Amp_NAUSEA)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.NAUSEA);
						all.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA,dur+Dur_NAUSEA, Amp_NAUSEA));
            		} else if(amp!=Amp_NAUSEA)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.NAUSEA);
						all.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA,Dur_NAUSEA, Amp_NAUSEA));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.RESISTANCE.toString())) 
    		{
    			if(meta.equals(PotionEffectType.RESISTANCE))
    			{
            		if(amp==Amp_DAMAGE_RESISTANCE)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.RESISTANCE);
						all.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE,dur+Dur_DAMAGE_RESISTANCE, Amp_DAMAGE_RESISTANCE));
            		} else if(amp!=Amp_DAMAGE_RESISTANCE)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.RESISTANCE);
						all.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE,Dur_DAMAGE_RESISTANCE, Amp_DAMAGE_RESISTANCE));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.DOLPHINS_GRACE.toString())) 
    		{
    			if(meta.equals(PotionEffectType.DOLPHINS_GRACE))
    			{
            		if(amp==Amp_DOLPHINS_GRACE)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.DOLPHINS_GRACE);
						all.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE,dur+Dur_DOLPHINS_GRACE, Amp_DOLPHINS_GRACE));
            		} else if(amp!=Amp_DOLPHINS_GRACE)
            		{
            			all.removePotionEffect(PotionEffectType.DOLPHINS_GRACE);
						all.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE,Dur_DOLPHINS_GRACE, Amp_DOLPHINS_GRACE));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.HASTE.toString())) 
    		{
    			if(meta.equals(PotionEffectType.HASTE))
    			{
            		if(amp==Amp_FAST_DIGGING)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.HASTE);
						all.addPotionEffect(new PotionEffect(PotionEffectType.HASTE,dur+Dur_FAST_DIGGING, Amp_FAST_DIGGING));
            		} else if(amp!=Amp_FAST_DIGGING)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.HASTE);
						all.addPotionEffect(new PotionEffect(PotionEffectType.HASTE,Dur_FAST_DIGGING, Amp_FAST_DIGGING));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.FIRE_RESISTANCE.toString())) 
    		{
    			if(meta.equals(PotionEffectType.FIRE_RESISTANCE))
    			{
            		if(amp==Amp_FIRE_RESISTANCE)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
						all.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,dur+Dur_FIRE_RESISTANCE, Amp_FIRE_RESISTANCE));
            		} else if(amp!=Amp_FIRE_RESISTANCE)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
						all.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,Dur_FIRE_RESISTANCE, Amp_FIRE_RESISTANCE));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.GLOWING.toString())) 
    		{
    			if(meta.equals(PotionEffectType.GLOWING))
    			{
            		if(amp==Amp_GLOWING)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.GLOWING);
						all.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,dur+Dur_GLOWING, Amp_GLOWING));
            		} else if(amp!=Amp_GLOWING)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.GLOWING);
						all.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,Dur_GLOWING, Amp_GLOWING));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.HEALTH_BOOST.toString())) 
    		{
    			if(meta.equals(PotionEffectType.HEALTH_BOOST))
    			{
            		if(amp==Amp_HEALTH_BOOST)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.HEALTH_BOOST);
						all.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,dur+Dur_HEALTH_BOOST, Amp_HEALTH_BOOST));
            		} else if(amp!=Amp_HEALTH_BOOST)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.HEALTH_BOOST);
						all.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,Dur_HEALTH_BOOST, Amp_HEALTH_BOOST));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.HERO_OF_THE_VILLAGE.toString())) 
    		{
    			if(meta.equals(PotionEffectType.HERO_OF_THE_VILLAGE))
    			{
            		if(amp==Amp_HERO_OF_THE_VILLAGE)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE);
						all.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE,dur+Dur_HERO_OF_THE_VILLAGE, Amp_HERO_OF_THE_VILLAGE));
            		} else if(amp!=Amp_HERO_OF_THE_VILLAGE)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE);
						all.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE,Dur_HERO_OF_THE_VILLAGE, Amp_HERO_OF_THE_VILLAGE));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.HUNGER.toString())) 
    		{
    			if(meta.equals(PotionEffectType.HUNGER))
    			{
            		if(amp==Amp_HUNGER)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.HUNGER);
						all.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER,dur+Dur_HUNGER, Amp_HUNGER));
            		} else if(amp!=Amp_HUNGER)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.HUNGER);
						all.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER,Dur_HUNGER, Amp_HUNGER));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.STRENGTH.toString())) 
    		{
    			if(meta.equals(PotionEffectType.STRENGTH))
    			{
            		if(amp==Amp_INCREASE_DAMAGE)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.STRENGTH);
						all.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH,dur+Dur_INCREASE_DAMAGE, Amp_INCREASE_DAMAGE));
            		} else if(amp!=Amp_INCREASE_DAMAGE)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.STRENGTH);
						all.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH,Dur_INCREASE_DAMAGE, Amp_INCREASE_DAMAGE));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.INVISIBILITY.toString())) 
    		{
    			if(meta.equals(PotionEffectType.INVISIBILITY))
    			{
            		if(amp==Amp_INVISIBILITY)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.INVISIBILITY);
						all.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,dur+Dur_INVISIBILITY, Amp_INVISIBILITY));
            		} else if(amp!=Amp_INVISIBILITY)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.INVISIBILITY);
						all.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,Dur_INVISIBILITY, Amp_INVISIBILITY));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.JUMP_BOOST.toString()))
    		{
    			if(meta.equals(PotionEffectType.JUMP_BOOST))
    			{
            		if(amp==Amp_JUMP)
            		{
            			event.setCancelled(true);
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.JUMP_BOOST);
						all.addPotionEffect(new PotionEffect(PotionEffectType.JUMP_BOOST,dur+Dur_JUMP, Amp_JUMP));
            		} else if(amp!=Amp_JUMP)
            		{
            			event.setCancelled(true);
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.JUMP_BOOST);
						all.addPotionEffect(new PotionEffect(PotionEffectType.JUMP_BOOST,Dur_JUMP, Amp_JUMP));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.LEVITATION.toString())) 
    		{
    			if(meta.equals(PotionEffectType.LEVITATION))
    			{
            		if(amp==Amp_LEVITATION)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.LEVITATION);
						all.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,dur+Dur_LEVITATION, Amp_LEVITATION));
            		} else if(amp!=Amp_LEVITATION)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.LEVITATION);
						all.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,Dur_LEVITATION, Amp_LEVITATION));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.LUCK.toString())) 
    		{
    			if(meta.equals(PotionEffectType.LUCK))
    			{
            		if(amp==Amp_LUCK)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.LUCK);
						all.addPotionEffect(new PotionEffect(PotionEffectType.LUCK,dur+Dur_LUCK, Amp_LUCK));
            		} else if(amp!=Amp_LUCK)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.LUCK);
						all.addPotionEffect(new PotionEffect(PotionEffectType.LUCK,Dur_LUCK, Amp_LUCK));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.NIGHT_VISION.toString())) 
    		{
    			if(meta.equals(PotionEffectType.NIGHT_VISION))
    			{
            		if(amp==Amp_NIGHT_VISION)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.NIGHT_VISION);
						all.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,dur+Dur_NIGHT_VISION, Amp_NIGHT_VISION));
            		} else if(amp!=Amp_NIGHT_VISION)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.NIGHT_VISION);
						all.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,Dur_NIGHT_VISION, Amp_NIGHT_VISION));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.POISON.toString())) 
    		{
    			if(meta.equals(PotionEffectType.POISON))
    			{
            		if(amp==Amp_POISON)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.POISON);
						all.addPotionEffect(new PotionEffect(PotionEffectType.POISON,dur+Dur_POISON, Amp_POISON));
            		} else if(amp!=Amp_POISON)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.POISON);
						all.addPotionEffect(new PotionEffect(PotionEffectType.POISON,Dur_POISON, Amp_POISON));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.REGENERATION.toString())) 
    		{
    			if(meta.equals(PotionEffectType.REGENERATION))
    			{
            		if(amp==Amp_REGENERATION)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.REGENERATION);
						all.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,dur+Dur_REGENERATION, Amp_REGENERATION));
            		} else if(amp!=Amp_REGENERATION)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.REGENERATION);
						all.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,Dur_REGENERATION, Amp_REGENERATION));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.SATURATION.toString())) 
    		{
    			if(meta.equals(PotionEffectType.SATURATION))
    			{
            		if(amp==Amp_SATURATION)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.SATURATION);
						all.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION,dur+Dur_SATURATION, Amp_SATURATION));
            		} else if(amp!=Amp_SATURATION)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.SATURATION);
						all.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION,Dur_SATURATION, Amp_SATURATION));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.MINING_FATIGUE.toString())) 
    		{
    			if(meta.equals(PotionEffectType.MINING_FATIGUE))
    			{
            		if(amp==Amp_SLOW_DIGGING)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.MINING_FATIGUE);
						all.addPotionEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE,dur+Dur_SLOW_DIGGING, Amp_SLOW_DIGGING));
            		} else if(amp!=Amp_SLOW_DIGGING)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.MINING_FATIGUE);
						all.addPotionEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE,Dur_SLOW_DIGGING, Amp_SLOW_DIGGING));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.SLOW_FALLING.toString())) 
    		{
    			if(meta.equals(PotionEffectType.SLOW_FALLING))
    			{
            		if(amp==Amp_SLOW_FALLING)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.SLOW_FALLING);
						all.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,dur+Dur_SLOW_FALLING, Amp_SLOW_FALLING));
            		} else if(amp!=Amp_SLOW_FALLING)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.SLOW_FALLING);
						all.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,Dur_SLOW_FALLING, Amp_SLOW_FALLING));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.SLOWNESS.toString())) 
    		{
    			if(meta.equals(PotionEffectType.SLOWNESS))
    			{
            		if(amp==Amp_SLOW)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.SLOWNESS);
						all.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS,dur+Dur_SLOW, Amp_SLOW));
            		} else if(amp!=Amp_SLOW)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.SLOWNESS);
						all.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS,Dur_SLOW, Amp_SLOW));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.SPEED.toString())) 
    		{
    			if(meta.equals(PotionEffectType.SPEED))
    			{
            		if(amp==Amp_SPEED)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.SPEED);
						all.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,dur+Dur_SPEED, Amp_SPEED));
            		} else if(amp!=Amp_SPEED)
            		{
            			all.removePotionEffect(PotionEffectType.SPEED);
						all.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,Dur_SPEED, Amp_SPEED));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.UNLUCK.toString())) 
    		{
    			if(meta.equals(PotionEffectType.UNLUCK))
    			{
            		if(amp==Amp_UNLUCK)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.UNLUCK);
						all.addPotionEffect(new PotionEffect(PotionEffectType.UNLUCK,dur+Dur_UNLUCK, Amp_UNLUCK));
            		} else if(amp!=Amp_UNLUCK)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.UNLUCK);
						all.addPotionEffect(new PotionEffect(PotionEffectType.UNLUCK,Dur_UNLUCK, Amp_UNLUCK));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.WATER_BREATHING.toString())) 
    		{
    			if(meta.equals(PotionEffectType.WATER_BREATHING))
    			{
            		if(amp==Amp_WATER_BREATHING)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.WATER_BREATHING);
						all.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,dur+Dur_WATER_BREATHING, Amp_WATER_BREATHING));
            		} else if(amp!=Amp_WATER_BREATHING)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.WATER_BREATHING);
						all.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,Dur_WATER_BREATHING, Amp_WATER_BREATHING));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.WEAKNESS.toString())) 
    		{
    			if(meta.equals(PotionEffectType.WEAKNESS))
    			{
            		if(amp==Amp_WEAKNESS)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.WEAKNESS);
						all.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,dur+Dur_WEAKNESS, Amp_WEAKNESS));
            		} else if(amp!=Amp_WEAKNESS)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.WEAKNESS);
						all.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,Dur_WEAKNESS, Amp_WEAKNESS));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.WITHER.toString()))
    		{
    			if(meta.equals(PotionEffectType.WITHER))
    			{
            		if(amp==Amp_WITHER)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.WITHER);
						all.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,dur+Dur_WITHER, Amp_WITHER));
            		} else if(amp!=Amp_WITHER)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.WITHER);
						all.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,Dur_WITHER, Amp_WITHER));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.TRIAL_OMEN.toString()))
    		{
    			if(meta.equals(PotionEffectType.TRIAL_OMEN))
    			{
            		if(amp==Amp_TRIAL_OMEN)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.TRIAL_OMEN);
						all.addPotionEffect(new PotionEffect(PotionEffectType.TRIAL_OMEN,dur+Dur_TRIAL_OMEN, Amp_TRIAL_OMEN));
            		} else if(amp!=Amp_TRIAL_OMEN)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.TRIAL_OMEN);
						all.addPotionEffect(new PotionEffect(PotionEffectType.TRIAL_OMEN,Dur_TRIAL_OMEN, Amp_TRIAL_OMEN));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.RAID_OMEN.toString()))
    		{
    			if(meta.equals(PotionEffectType.RAID_OMEN))
    			{
            		if(amp==Amp_RAID_OMEN)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.RAID_OMEN);
						all.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,dur+Dur_RAID_OMEN, Amp_RAID_OMEN));
            		} else if(amp!=Amp_RAID_OMEN)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.RAID_OMEN);
						all.addPotionEffect(new PotionEffect(PotionEffectType.RAID_OMEN,Dur_RAID_OMEN, Amp_RAID_OMEN));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.WIND_CHARGED.toString()))
    		{
    			if(meta.equals(PotionEffectType.WIND_CHARGED))
    			{
            		if(amp==Amp_WIND_CHARGED)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.WIND_CHARGED);
						all.addPotionEffect(new PotionEffect(PotionEffectType.WIND_CHARGED,dur+Dur_WIND_CHARGED, Amp_WIND_CHARGED));
            		} else if(amp!=Amp_WIND_CHARGED)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.WIND_CHARGED);
						all.addPotionEffect(new PotionEffect(PotionEffectType.WIND_CHARGED,Dur_WIND_CHARGED, Amp_WIND_CHARGED));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.WEAVING.toString()))
    		{
    			if(meta.equals(PotionEffectType.WEAVING))
    			{
            		if(amp==Amp_WEAVING)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.WEAVING);
						all.addPotionEffect(new PotionEffect(PotionEffectType.WEAVING,dur+Dur_WEAVING, Amp_WEAVING));
            		} else if(amp!=Amp_WEAVING)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.WEAVING);
						all.addPotionEffect(new PotionEffect(PotionEffectType.WEAVING,Dur_WEAVING, Amp_WEAVING));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.OOZING.toString()))
    		{
    			if(meta.equals(PotionEffectType.OOZING))
    			{
            		if(amp==Amp_OOZING)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.OOZING);
						all.addPotionEffect(new PotionEffect(PotionEffectType.OOZING,dur+Dur_OOZING, Amp_OOZING));
            		} else if(amp!=Amp_OOZING)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.OOZING);
						all.addPotionEffect(new PotionEffect(PotionEffectType.OOZING,Dur_OOZING, Amp_OOZING));
            		}
    			}
    		}
    		if(effect.getType().toString().equals(PotionEffectType.INFESTED.toString()))
    		{
    			if(meta.equals(PotionEffectType.INFESTED))
    			{
            		if(amp==Amp_INFESTED)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.INFESTED);
						all.addPotionEffect(new PotionEffect(PotionEffectType.INFESTED,dur+Dur_INFESTED, Amp_INFESTED));
            		} else if(amp!=Amp_INFESTED)
            		{
            			event.setCancelled(true);
            			all.removePotionEffect(PotionEffectType.INFESTED);
						all.addPotionEffect(new PotionEffect(PotionEffectType.INFESTED,Dur_INFESTED, Amp_INFESTED));
            		}
    			}
    		}
			return;
		}
	}
}