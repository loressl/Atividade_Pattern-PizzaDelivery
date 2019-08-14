package application;

import interfaces.IPluginController;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PluginController implements IPluginController {

	@Override
	public boolean initialize() {
		File currentDir = new File("./plugins");
		plugins = currentDir.list();
		int i;
		jars = new URL[plugins.length];
		System.out.println("Encontrei " + plugins.length + " plugins instalados!");
		for (i = 0; i < plugins.length; i++)
			try {
				jars[i] = (new File("./plugins/" + plugins[i])).toURI().toURL();
			} catch (MalformedURLException ex) {
				Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
			}
		for (i = 0; i < plugins.length; i++) {
			if (plugins[i].contains("D")) {
				pluginsDecorators.add(plugins[i].split("D")[0]);
			} else
				pluginsPizzas.add(plugins[i].split("\\.")[0]);
		}
		return true;
	}

	@Override
	public URL[] getJars() {
		return jars;
	}
	@Override
	public String[] getPlugins() {
		return plugins;
	}
	@Override
	public List<String> getPluginsDecorators() {
		return pluginsDecorators;
	}
	@Override
	public List<String> getPluginsPizzas() {
		return pluginsPizzas;
	}

	private URL[] jars;
	private String[] plugins;
	private List<String> pluginsDecorators = new ArrayList<>();
	private List<String> pluginsPizzas = new ArrayList<>();

}
