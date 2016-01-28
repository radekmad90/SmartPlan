package pl.pcz.wimii.zpi.smartplan.ws;

import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.core.Application;
import org.jboss.resteasy.plugins.interceptors.CorsFilter;

public class ApplicationConfiguration extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet<Class<?>>();

    public ApplicationConfiguration() {

        singletons.add(new RokKierunekResource());
        CorsFilter corsFilter = new CorsFilter();
        corsFilter.getAllowedOrigins().add("wimii.pl");
        corsFilter.getAllowedOrigins().add("http://wimii.pl");
        singletons.add(corsFilter);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return empty;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
