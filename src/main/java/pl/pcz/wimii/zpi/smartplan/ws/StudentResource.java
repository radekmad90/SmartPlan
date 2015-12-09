package pl.pcz.wimii.zpi.smartplan.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import pl.pcz.wimii.zpi.smartplan.entities.Godziny;
import pl.pcz.wimii.zpi.smartplan.entities.services.GodzinyService;

@Path("/json")
public class StudentResource {

    List<Student> students = new ArrayList<Student>();
    StringListConverter converter = new StringListConverter();
    private Logger logger = Logger.getLogger(this.getClass());

    public StudentResource() {
        // Populate test data. Later each WS method will retrieve data from DB.
        students.add(new Student(12344, "Mike", 17));
        students.add(new Student(12345, "Jane", 19));
        students.add(new Student(12346, "Bob", 19));
        students.add(new Student(12347, "Susan", 22));
        students.add(new Student(12348, "Daniel", 25));
        students.add(new Student(12349, "John", 26));
        students.add(new Student(12350, "Debbie", 28));
    }

    @GET
    @Path("students")
    @Produces("application/json")
    public Response getStudentList() {
        StudentWrapper wrapper = new StudentWrapper();
        students.add(new Student());
        wrapper.setList(students);
        List<Godziny> godziny = GodzinyService.getGodziny();
        logger.error(godziny.get(0).getGodz());
        wrapper.setGodziny(godziny);
        return Response.status(200).entity(wrapper).build();
    }

    @GET
    @Path("overAge/{age}")
    @Produces("application/json")
    public Response getStudentOverAgeList(@PathParam("age") String anAge) {
        StudentWrapper wrapper = new StudentWrapper();

        List<Student> newList = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getAge() > Integer.parseInt(anAge)) {
                newList.add(student);
            }
        }
        wrapper.setList(newList);
        return Response.status(200).entity(wrapper).build();
    }

    /**
     * Pass concatenated names as a single string
     *
     * @param namesString
     * @return
     */
    @GET
    @Path("studentsByName")
    @Produces("application/json")
    public Response getStudentsByNames(@QueryParam("names") String namesString) {
        StudentWrapper wrapper = new StudentWrapper();

        List<String> nameList = converter.fromString(namesString);
        List<Student> newList = new ArrayList<Student>();

        for (Student student : students) {
            if (nameList.contains(student.getName())) {
                newList.add(student);
            }
        }
        wrapper.setList(newList);
        return Response.status(200).entity(wrapper).build();
    }

    /**
     * Pass concatenated names as a single string
     *
     * @param namesString
     * @return
     */
    @PUT
    @Path("studentsByNameJson")
    @Produces("application/json")
    public Response getStudentsByNamesJson(String namesJson) {
        StudentWrapper wrapper = new StudentWrapper();

        List<String> nameList = converter.fromJson(namesJson);
        List<Student> newList = new ArrayList<Student>();

        for (Student student : students) {
            if (nameList.contains(student.getName())) {
                newList.add(student);
            }
        }
        wrapper.setList(newList);
        return Response.status(200).entity(wrapper).build();
    }

}
