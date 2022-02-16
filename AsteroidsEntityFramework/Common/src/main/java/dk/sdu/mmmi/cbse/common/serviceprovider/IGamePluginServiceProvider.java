package dk.sdu.mmmi.cbse.common.serviceprovider;

import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public class IGamePluginServiceProvider {
    public static IGamePluginServiceProvider service;
    private ServiceLoader<IGamePluginService> loader;

    private IGamePluginServiceProvider() {loader = ServiceLoader.load(IGamePluginService.class);}

    public static synchronized IGamePluginServiceProvider getInstance() {
        if (service == null) {
            service = new IGamePluginServiceProvider();
        }
        return service;
    }

    public IGamePluginService getPluginByInterface(String search) {
        System.out.println("Plugin");
        System.out.println(search);
        IGamePluginService plugin = null;
        try {
            Iterator<IGamePluginService> iterator = loader.iterator();
            while(iterator.hasNext()) {
                IGamePluginService p = iterator.next();
                System.out.println("are you alive");
            }
        } catch (ServiceConfigurationError se) {

        }
        return plugin;
    }
}
