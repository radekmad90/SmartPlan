package pl.pcz.wimii.zpi.smartplan.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import pl.pcz.wimii.zpi.smartplan.entities.RokKierunek;
import pl.pcz.wimii.zpi.smartplan.entities.services.RokKierunekService;
import pl.pcz.wimii.zpi.smartplan.parser.Parser;
import pl.pcz.wimii.zpi.smartplan.parser.RokKierunekToJSONConverter;

@Path("/json")
public class RokKierunekResource {

    private Logger logger = Logger.getLogger(this.getClass());

    public RokKierunekResource() {
    }

    @GET
    @Path("rokKierunek/{id}")
    @Produces("application/json")
    public Response getStudentList(@PathParam("id") Integer id) {
//        Parser parser = new Parser();
//        parser.parse("http://wimii.pcz.pl/download/plan/studia_niestacjonarne/o21f.html","2015/2016" , 1 , "Informatyka", "ABiBD", 2, 1,  null, null);

        RokKierunek rokKierunek = RokKierunekService.getRokKierunekById(id);
        RokKierunekToJSONConverter conv = new RokKierunekToJSONConverter();
        RokKierunekWrapper wrapper = conv.convert(rokKierunek);
        return Response.status(200).entity(wrapper).build();
    }

//    @GET
//    @Path("overAge/{age}")
//    @Produces("application/json")
//    public Response getStudentOverAgeList(@PathParam("age") String anAge) {
//        StudentWrapper wrapper = new StudentWrapper();
//        
//        List<Student> newList = new ArrayList<Student>();
//        for (Student student : students) {
//            if (student.getAge() > Integer.parseInt(anAge)) {
//                newList.add(student);
//            }
//        }
//        wrapper.setList(newList);
//        return Response.status(200).entity(wrapper).build();
//    }
//
//    /**
//     * Pass concatenated names as a single string
//     *
//     * @param namesString
//     * @return
//     */
//    @GET
//    @Path("studentsByName")
//    @Produces("application/json")
//    public Response getStudentsByNames(@QueryParam("names") String namesString) {
//        StudentWrapper wrapper = new StudentWrapper();
//        
//        List<String> nameList = converter.fromString(namesString);
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
