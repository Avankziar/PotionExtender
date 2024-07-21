package me.avankziar.pe;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CMD_Potion implements CommandExecutor 
{
	
	public String tl(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
	
	public YamlConfiguration lg() {
		return PotionExtender.getPlugin().lg();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		if(!(sender instanceof Player)) 
		{
			return false;
		}
		Player p = (Player)sender;
		if(args.length < 1 || args.length > 1) 
		{
			p.sendMessage(tl(lg().getString("PE.cmd_potion.msg05")));
			return false;
		}
		if(args[0].equals("duration") || args[0].equals("dauer")) 
		{
			if(!p.hasPermission("potionextender.cmd")) 
			{
				p.sendMessage(tl(lg().getString("PE.cmd_potion.msg01")));
				return false;
			}
			String text = "";
			if(p.getActivePotionEffects().isEmpty()) {
				text += lg().getString("PE.cmd_potion.msg03");
			} else
			{
				for(PotionEffect effect : p.getActivePotionEffects()) {
					if(effect.getType().toString().equals(PotionEffectType.ABSORPTION.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.ABSORPTION"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.BAD_OMEN.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.BAD_OMEN"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.BLINDNESS.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.BLINDNESS"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.CONDUIT_POWER.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.CONDUIT_POWER"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.BLINDNESS.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.CONFUSION"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.RESISTANCE.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.DAMAGE_RESISTANCE"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.DOLPHINS_GRACE.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.DOLPHINS_GRACE"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.HASTE.toString()))
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.FAST_DIGGING"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.FIRE_RESISTANCE.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.FIRE_RESISTANCE"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.GLOWING.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.GLOWING"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.INSTANT_DAMAGE.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.HARM"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.INSTANT_HEALTH.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.HEAL"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.HEALTH_BOOST.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.HEALTH_BOOST"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.HUNGER.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.HUNGER"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.STRENGTH.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.INCREASE_DAMAGE"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.INVISIBILITY.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.INVISIBILITY"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.JUMP_BOOST.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.JUMP"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.LEVITATION.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.LEVITATION"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.LUCK.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.LUCK"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.NIGHT_VISION.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.NIGHT_VISION"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.POISON.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.POISON"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.REGENERATION.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.REGENERATION"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.SATURATION.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.SATURATION"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.SLOWNESS.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.SLOW"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.MINING_FATIGUE.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.SLOW_DIGGING"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.SLOW_FALLING.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.SLOW_FALLING"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.SPEED.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.SPEED"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.UNLUCK.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.UNLUCK"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.WATER_BREATHING.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.WATER_BREATHING"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.WEAKNESS.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.WEAKNESS"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					} else if(effect.getType().toString().equals(PotionEffectType.WITHER.toString())) 
					{
						text += lg().getString("PE.cmd_potion.msg02").replaceAll("%Potion%", lg().getString("PE.potioneffect.WITHER"))
								.replaceAll("%Level%",LvLtl(effect.getAmplifier()))
								.replaceAll("%Time%",Timetl(effect.getDuration()));
					}
				}
			}
			p.sendMessage(tl(text.substring(0,text.length()-2)));
			return true;
		} else 
		{
			p.sendMessage(tl(lg().getString("PE.cmd_potion.msg05")));
			return false;
		}
	}
	
	private static String LvLtl(int zahl) //fin
	{
		String rn = "";
		while(zahl >= 1000){rn+="M";zahl -= 1000;}
		while(zahl >= 900) {rn += "CM";zahl -= 900;}
	    while (zahl >= 500) {rn += "D";zahl -= 500;}
	    while (zahl >= 400) {rn += "CD";zahl -= 400;}
	    while (zahl >= 100) {rn += "C";zahl -= 100;}
	    while (zahl >= 90) {rn += "XC";zahl -= 90;}
	    while (zahl >= 50) {rn += "L";zahl -= 50;}
	    while (zahl >= 40) {rn += "XL";zahl -= 40;}
	    while (zahl >= 10) {rn += "X";zahl -= 10;}
	    while (zahl >= 9) {rn += "IX";zahl -= 9;}
	    while (zahl >= 5) {rn += "V";zahl -= 5;}
	    while (zahl >= 4) {rn += "IV";zahl -= 4;}
	    while (zahl >= 1) {rn += "I";zahl -= 1;}
		return rn;
	}
	
	private String Timetl(Integer time) {
		long t = time.longValue();
		if(t<=20) {
			return lg().getString("PE.cmd_potion.msg04");
		}
		long days = t/(20*60*60*24);
		String ss = lg().getString("PE.time.seconds");
	    String mm = lg().getString("PE.time.minutes");
	    String HH = lg().getString("PE.time.hours");
	    String dd = lg().getString("PE.time.days");
	    String msg = "";
	    if(days>=1) {
	    	msg += days+dd;
	    	t -= days*20*60*60*24;
	    }
	    long hours = t/(20*60*60);
	    if(hours>=1) {
	    	msg += hours+HH;
	    	t -= hours*20*60*60;
	    }
	    long minutes = t/(20*60);
	    if(minutes>=1) {
	    	msg += minutes+mm;
	    	t -= minutes*20*60;
	    }
	    long seconds = t/(20);
	    if(seconds>1) {
	    	msg += seconds+ss;
	    }
	    String MSG = msg.substring(0,msg.length()-1);
	    return MSG;
	}

}
