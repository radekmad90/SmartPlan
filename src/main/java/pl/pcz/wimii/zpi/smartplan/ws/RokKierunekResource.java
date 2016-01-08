package pl.pcz.wimii.zpi.smartplan.ws;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.apache.log4j.Logger;
import pl.pcz.wimii.zpi.smartplan.entities.RokKierunek;
import pl.pcz.wimii.zpi.smartplan.entities.services.RokKierunekService;
import pl.pcz.wimii.zpi.smartplan.json.beans.RokKierunekAndUrlJSON;
import pl.pcz.wimii.zpi.smartplan.json.beans.RokKierunekJSON;
import pl.pcz.wimii.zpi.smartplan.parser.Parser;
import pl.pcz.wimii.zpi.smartplan.parser.RokKierunekListToJSONConverter;
import pl.pcz.wimii.zpi.smartplan.parser.RokKierunekToJSONConverter;

@Path("/json")
@ApplicationScoped
public class RokKierunekResource {

    private Logger logger = Logger.getLogger(this.getClass());

    public RokKierunekResource() {
    }

    @GET
    @Path("rokKierunek/{id}")
    @Produces("application/json; charset=UTF-8")
    public Response getRokKierunek(@PathParam("id") Integer id, @Context ServletContext servletContext) {
        RokKierunekWrapper wrapper = null;
        Cache cache = (Cache) servletContext.getAttribute("rokKierunekCache");
        Element e = cache.get(id);
        if (e != null) {
            wrapper = (RokKierunekWrapper) e.getObjectValue(); // get object from cache
        } else {
            RokKierunek rokKierunek = RokKierunekService.getRokKierunekById(id);
            RokKierunekToJSONConverter conv = new RokKierunekToJSONConverter();
            wrapper = conv.convert(rokKierunek);
            Element resultCacheElement = new Element(id, wrapper);
            cache.put(resultCacheElement);
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600").entity(wrapper).build();
    }

    @GET
    @Path("rokKierunek")
    @Produces("application/json; charset=UTF-8")
    public Response getRokKierunekList(@Context ServletContext servletContext) {

        RokKierunekListWrapper wrapper = new RokKierunekListWrapper();
        Cache cache = (Cache) servletContext.getAttribute("rokKierunekCache");
        Element e = cache.get(Integer.MAX_VALUE);
        if (e != null) {
            wrapper = (RokKierunekListWrapper) e.getObjectValue(); // get object from cache
        } else {
            List<RokKierunek> rokKierList = RokKierunekService.getRokKierunekList();
            RokKierunekListToJSONConverter conv = new RokKierunekListToJSONConverter();
            Set<RokKierunekJSON> rokKierunekList = conv.convert(wrapper.getRokKierunekList(), rokKierList);
            wrapper.setRokKierunekList(rokKierunekList);
            Element resultCacheElement = new Element(Integer.MAX_VALUE, wrapper);
            cache.put(resultCacheElement);
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600").entity(wrapper).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addPlan")
    public Response addPlan(RokKierunekAndUrlJSON rokKierunekJSON, @Context ServletContext servletContext) throws IOException {
        Cache cache = (Cache) servletContext.getAttribute("rokKierunekCache");
        try {
            Parser parser = new Parser();
            logger.info(rokKierunekJSON.getUrl());
            logger.info(rokKierunekJSON.getRokAkademicki());
            parser.parse(cache, rokKierunekJSON.getUrl().trim(), rokKierunekJSON.getRokAkademicki().trim(), rokKierunekJSON.getKierunek().trim(), rokKierunekJSON.getSpecjalizacja().trim(), rokKierunekJSON.getStopien(), rokKierunekJSON.getSemestr(), rokKierunekJSON.getGrupaDziekan(), rokKierunekJSON.getGrupaLab());

        } catch (Exception e) {
            logger.error(e.getCause() + " \nmessage " + e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600").build();
    }

//
//    /**
//     * Pass concatenated names as a single string
//     *
//     * @param namesString
//     * @return
//     */
//    @PUT
//    @Path("studentsByNameJson")
//    @Produces("application/json")
//    public Response getStudentsByNamesJson(String namesJson) {
//        StudentWrapper wrapper = new StudentWrapper();
//        
//        List<String> nameList = converter.fromJson(namesJson);
//        List<Student> newList = new ArrayList<Student>();
//        
//        for (Student student : students) {
//            if (nameList.contains(student.getName())) {
//                newList.add(student);
//            }
//        }
//        wrapper.setList(newList);
//        return Response.status(200).entity(wrapper).build();
//    }
}
