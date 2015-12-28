/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pcz.wimii.zpi.smartplan.utils;

/**
 *
 * @author Radek
 */
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

public class InitializationListener implements ServletContextListener {    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        CacheManager singletonManager = CacheManager.create();
        Cache memoryOnlyCache = new Cache("dbCache", 100, false, true, 86400,86400);
        singletonManager.addCache(memoryOnlyCache);
        Cache cache = singletonManager.getCache("dbCache");       
        ctx.setAttribute("dbCache", cache );           
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}