package me.afroninja.afrocore;

import me.afroninja.afrocore.debug.Debug;
import me.afroninja.afrocore.managers.CommandManager;
import me.afroninja.afrocore.managers.SettingManager;
import me.afroninja.afrocore.users.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class AfroCore extends JavaPlugin {
	public static AfroCore instance;
	public static SettingManager settings = SettingManager.getInstance();
	public static Debug debug = Debug.getInstance();
	public static UserManager users = UserManager.getInstance();

	public static AfroCore getInstance() {
		return instance;
	}

	public void onEnable() {
		instance = this;
		settings.setup(this);
		debug.setup(this);

		setupListeners();
		setupCommands();

	}

	public void onDisable(){
		users.saveAll();
	}

	public int getOnlineCount(String group) {
		return 0;
	}

	private void setupListeners() {
		Bukkit.getPluginManager().registerEvents(new UserManager(), this);
	}

	private void setupCommands(){
		this.getCommand("fly").setExecutor(new CommandManager());
		this.getCommand("flytimer").setExecutor(new CommandManager());
		this.getCommand("help").setExecutor(new CommandManager());
		this.getCommand("repair").setExecutor(new CommandManager());
		this.getCommand("trash").setExecutor(new CommandManager());
		this.getCommand("feed").setExecutor(new CommandManager());
		this.getCommand("heal").setExecutor(new CommandManager());
	}
}