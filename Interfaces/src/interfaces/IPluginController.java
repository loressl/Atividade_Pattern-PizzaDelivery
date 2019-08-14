package interfaces;

import java.net.URL;
import java.util.List;

public interface IPluginController {
    public boolean initialize();
    public URL[] getJars();
    public String[] getPlugins();
    public List<String> getPluginsDecorators();
    public List<String> getPluginsPizzas();
}
