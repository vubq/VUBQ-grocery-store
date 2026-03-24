package com.vubq.grocerystore.config;

import java.io.IOException;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class SpaWebConfig implements WebMvcConfigurer {

    private static final String STATIC_RESOURCE_LOCATION = "classpath:/static/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
            .addResourceLocations(STATIC_RESOURCE_LOCATION)
            .resourceChain(true)
            .addResolver(new SpaPageResourceResolver());
    }

    private static final class SpaPageResourceResolver extends PathResourceResolver {

        @Override
        protected Resource getResource(String resourcePath, Resource location) throws IOException {
            Resource requestedResource = location.createRelative(resourcePath);
            if (requestedResource.exists() && requestedResource.isReadable()) {
                return requestedResource;
            }

            if (isFrameworkPath(resourcePath)) {
                return null;
            }

            Resource indexHtml = location.createRelative("index.html");
            if (indexHtml.exists() && indexHtml.isReadable()) {
                return indexHtml;
            }

            return null;
        }

        private boolean isFrameworkPath(String resourcePath) {
            return resourcePath.equals("api")
                || resourcePath.startsWith("api/")
                || resourcePath.equals("actuator")
                || resourcePath.startsWith("actuator/")
                || resourcePath.startsWith("v3/api-docs")
                || resourcePath.startsWith("swagger-ui");
        }
    }
}

