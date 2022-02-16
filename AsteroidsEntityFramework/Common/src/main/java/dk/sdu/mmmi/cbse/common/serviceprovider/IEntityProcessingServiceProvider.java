package dk.sdu.mmmi.cbse.common.serviceprovider;

import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.ServiceLoader;

public class IEntityProcessingServiceProvider {
    public static IEntityProcessingServiceProvider service;
    private ServiceLoader<IEntityProcessingService> loader;

    private IEntityProcessingServiceProvider() {loader = ServiceLoader.load(IEntityProcessingService.class);}

    public static synchronized IEntityProcessingServiceProvider getInstance() {
        if (service == null) {
            service = new IEntityProcessingServiceProvider();
        }
        return service;
    }
}
