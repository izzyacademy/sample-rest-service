package com.izzyacademy.event.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.izzyacademy.event.filters.AuthFilter;
import com.izzyacademy.event.resources.EventWebservice;
import com.izzyacademy.event.resources.EventWebserviceImplementation;

import ch.qos.logback.core.net.SocketConnector.ExceptionHandler;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;

@Component
@ApplicationPath(EventWebservice.SERVICE_BASE_PATH)
public class ApplicationConfig extends ResourceConfig{

	public ApplicationConfig() {
		
		BeanConfig swaggerConfig = new BeanConfig();
        swaggerConfig.setBasePath(EventWebservice.SERVICE_BASE_PATH);
        SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);
        
        String package0 = EventWebserviceImplementation.class.getPackage().getName();
        String package1 = ExceptionHandler.class.getPackage().getName();
        String package2 = AuthFilter.class.getPackage().getName();
        String package3 = ApiListingResource.class.getPackage().getName();
        
		//packages("com.izzyacademy.event.resources", "com.izzyacademy.event.exceptions", "com.izzyacademy.event.filters");
        
        super.packages(package0, package1, package2, package3);
	}
}
