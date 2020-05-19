package me.afroninja.afrocore;

import me.afroninja.afrocore.debug.Debug;
import me.afroninja.afrocore.managers.CommandManager;
import me.afroninja.afrocore.managers.SettingManager;
import me.afroninja.afrocore.modules.crophopper.CropHopper;
import me.afroninja.afrocore.users.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class AfroCore extends JavaPlugin {
	public static AfroCore instance;
	public static SettingManager settings = SettingManager.getInstance();
	public static Debug debug = Debug.getInstance();
	public static UserManager users = UserManager.getInstance();
	public static CropHopper cropHopper = CropHopper.getInstance();

	public static AfroCore getInstance() {
		return instance;
	}

	public void onEnable() {
		instance = this;
		settings.setup(this);
		users.setup(this);

		enableModules();
	}

	public void onDisable(){
		users.saveAll();
	}

	public int getOnlineCount(String group) {
		return 0;
	}

	private void enableModules(){

		if (settings.moduleEnabled("debug")) {
			debug.setup(this);
		}

		if (settings.moduleEnabled("crophopper")) {
			cropHopper.setup(this);
		}

		if (settings.moduleEnabled("fly")) {
			this.getCommand("fly").setExecutor(new CommandManager());
		}

		if (settings.moduleEnabled("flytimer")) {
			this.getCommand("flytimer").setExecutor(new CommandManager());
		}

		if (settings.moduleEnabled("help")) {
			this.getCommand("help").setExecutor(new CommandManager());
		}

		if (settings.moduleEnabled("repair")) {
			this.getCommand("repair").setExecutor(new CommandManager());
			this.getCommand("fix").setExecutor(new CommandManager());
		}

		if (settings.moduleEnabled("trash")) {
			this.getCommand("trash").setExecutor(new CommandManager());
		}

		if (settings.moduleEnabled("feed")) {
			this.getCommand("feed").setExecutor(new CommandManager());
		}

		if (settings.moduleEnabled("heal")) {
			this.getCommand("heal").setExecutor(new CommandManager());
		}

		if (settings.moduleEnabled("crophopper")) {
			this.getCommand("crophopper").setExecutor(new CommandManager());
		}
	}
}