package me.avankziar.pe;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class PotionExtender extends JavaPlugin {
	
	private static PotionExtender plugin;
	private File c = null;
	private YamlConfiguration cfg = new YamlConfiguration();
	private File de = null;
	private YamlConfiguration ger = new YamlConfiguration();
	private File en = null;
	private YamlConfiguration eng = new YamlConfiguration();
	
	public void onEnable() {
		plugin=this;
		c = new File(plugin.getDataFolder(), "config.yml");
		de = new File(plugin.getDataFolder(), "german.yml");
		en = new File(plugin.getDataFolder(), "english.yml");
		mkdir();
	    loadYamls();
	    GeneralUpdate();
	    this.getCommand("potion").setExecutor(new CMD_Potion());
	    this.getServer().getPluginManager().registerEvents(new EVENT_onPotionEffect(), this);
	    getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Potion Extender" + ChatColor.WHITE + " is " + ChatColor.DARK_GREEN + "running" + ChatColor.WHITE + "!");
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Potion Extender" + ChatColor.WHITE + " is " +
			    ChatColor.DARK_GREEN + "development " + ChatColor.WHITE + "by " + ChatColor.GOLD + "Avankziar"+ ChatColor.WHITE+ "!");
	}
	
	public void onDisable() {
		saveCon();
		saveGer();
		saveEng();
	}
	
	public void GeneralUpdate() 
	{
		
	}
	
	private void mkdir() {
		if(!c.exists()) {
			saveResource("config.yml", false);
		}
		if(!de.exists()) {
			saveResource("german.yml", false);
		}
		if(!en.exists()) {
			saveResource("english.yml", false);
		}
	}
	
	public void saveCon() {
	    try {
	        cfg.save(c);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public void saveGer() {
	    try {
	        ger.save(de);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public void saveEng() {
	    try {
	        eng.save(en);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void loadYamls() {
		try {
			cfg.load(c);
		} catch (IOException | InvalidConfigurationException e1) {
			e1.printStackTrace();
		}
		try {
			ger.load(de);
		} catch (IOException | InvalidConfigurationException e1) {
			e1.printStackTrace();
		}
		try {
			eng.load(en);
		} catch (IOException | InvalidConfigurationException e1) {
			e1.printStackTrace();
		}
	}
	
	public YamlConfiguration lg() {
		if(cfg.getString("PE.language").equalsIgnoreCase("german")) {
			return ger;
		} else if(cfg.getString("PE.language").equalsIgnoreCase("english")) {
			return eng;
		}
		return cfg;
	}
	
	public static PotionExtender getPlugin() {
		return plugin;
	}
	
	public YamlConfiguration cfg() {
		return cfg;
	}

}
