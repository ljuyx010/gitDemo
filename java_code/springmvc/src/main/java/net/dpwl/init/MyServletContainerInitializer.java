package net.dpwl.init;

import net.dpwl.controller.QuickController;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/26 14:08
 */
@HandlesTypes({QuickController.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("MyServletContainerInitializer onStartup...");
    }
}
