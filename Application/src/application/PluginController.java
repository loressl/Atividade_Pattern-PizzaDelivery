package application;

import interfaces.IPlugin;
import interfaces.IPluginController;
import interfaces.Pizza;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PluginController implements IPluginController {

	@Override
	public boolean initialize() {
		File currentDir = new File("./plugins");
		String[] plugins = currentDir.list();
		int i;
		URL[] jars = new URL[plugins.length];
		System.out.println("Encontrei " + plugins.length + " plugins instalados!");
		for (i = 0; i < plugins.length; i++)
			try {
				jars[i] = (new File("./plugins/" + plugins[i])).toURI().toURL();
			} catch (MalformedURLException ex) {
				Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
			}
		URLClassLoader ulc = new URLClassLoader(jars);
		Pizza pizza = null;
		String pluginName = null;
		for (i = 0; i < plugins.length; i++) {
			pluginName = plugins[i].split("\\.")[0];
			IPlugin plugin = null;
			try {
				Class<?> pluginClass = Class.forName(pluginName.toLowerCase() + "." + pluginName, true, ulc);
				Constructor<?>[] pluginConstructors = pluginClass.getDeclaredConstructors();
				for (Constructor<?> constructor : pluginConstructors) {
					Class<?>[] params = constructor.getParameterTypes();
					if (params.length == 0 && pizza == null) {
						pizza = (Pizza) constructor.newInstance();
						plugin = (IPlugin) pizza;
						i = -1;
					} else if (params.length == 1 && params[0] == Pizza.class) {
						if (pizza != null)
							plugin = (IPlugin) constructor.newInstance(pizza);
					}
				}
				if (plugin != null)
					if (plugin.initialize())
						loadedPlugins.add(plugin);
			} catch (Exception e) {
				Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		return true;
	}

	@Override
	public List<IPlugin> getLoadedPlugins() {
		return loadedPlugins;
	}

	@Override
	public <T> List<T> getLoadedPluginsByType(Class<T> decorator) {
		return null;
	}

	private List<IPlugin> loadedPlugins = new ArrayList<IPlugin>();

}
