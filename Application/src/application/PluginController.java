package application;

import interfaces.IPlugin;
import interfaces.IPluginController;
import java.util.List;

public class PluginController implements IPluginController{

    @Override
    public boolean initialize() {
       return true;
    }

    @Override
    public List<IPlugin> getLoadedPlugins() {
        return null;
    }

    @Override
    public <T> List<T> getLoadedPluginsByType(Class<T> decorator) {
        return null;
    }
    
}
