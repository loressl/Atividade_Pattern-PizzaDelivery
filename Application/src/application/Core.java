
package application;

import interfaces.ICore;
import interfaces.IPluginController;
import interfaces.IUIController;

public class Core implements ICore{

    private Core() {}

    public static ICore getInstance(){
        if(instance == null){
            instance = new Core();
            uiController = new UIController();
            pluginController = new PluginController();
            pluginController.initialize();
            uiController.initialize();
        }
        return instance;
    }
    
    @Override
    public IUIController getUIController() {
       return uiController; 
    }

    @Override
    public IPluginController getPluginController() {
        return pluginController;
    }
    
    private static ICore instance = null;
    private static IUIController uiController;
    private static IPluginController pluginController;
}
