/**
 * 
 */
package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


/**
 * @author punitha
 *
 */
@RestController
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class HelloController {
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!s";
	}

	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		System.out.println("test212312312123123");
		return new ModelAndView("welcome");
	}

	@RequestMapping(value = "/api", method = RequestMethod.POST)
	@Secured("ROLE_TELLER")
	// public ResponseEntity<List> welcomeAPI() throws IOException {
	public ResponseEntity<List> welcomeAPI(@RequestBody List<Student> students) {
		System.out.println("test212312312123123");
		List<Student> stuList = new ArrayList<Student>();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.valueOf("application/json"));
		responseHeaders.add("testHeader", "testheaderValue");

		System.out.println("payload" + students);

		// Set<String> keys = payload.keySet();

		/*
		 * for(String key:keys) {
		 * 
		 * System.out.println("key" + key); System.out.println("Map pair class" +
		 * ((List)payload.get("students")).get(0).getClass());
		 * 
		 * }
		 * 
		 * 
		 * 
		 * System.out.println("key" + payload.get("students"));
		 * 
		 * List<Student> students = (List<Student>) payload.get("students");
		 */

		for (Student student : students)
			System.out.println(
					"student RollNum" + student.getRollNum() + "  " + "student name" + student.getStudentName());

		System.out.println("students" + students);

		stuList.add(new Student(101, "ABC"));
		stuList.add(new Student(102, "DEF"));
		// Response resp = new Response();
		// resp.setHeader("test", "test123");
		// response.sendError(Response.SC_FORBIDDEN);
		return new ResponseEntity<List>(stuList, responseHeaders, HttpStatus.CONFLICT);
	}

	@RequestMapping(value = "/api", method = RequestMethod.PUT)
	// public ResponseEntity<List> welcomeAPI() throws IOException {
	public ResponseEntity<List> welcomeMap(@RequestBody Map<String, Student> payload) {
		List<Student> stuList = new ArrayList<Student>();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.valueOf("application/json"));
		responseHeaders.add("testHeader", "testheaderValue");

		System.out.println("payload" + payload);

		Set<String> keys = payload.keySet();

		for (String key : keys) {

			System.out.print("key" + key);
			System.out.print(" Roll Number" + ((Student) payload.get(key)).getRollNum());
			System.out.println(" Name" + ((Student) payload.get(key)).getStudentName());

		}

		System.out.println("key" + payload.get("students"));

		stuList.add(new Student(101, "ABC"));
		stuList.add(new Student(102, "DEF"));
		// Response resp = new Response();
		// resp.setHeader("test", "test123");
		// response.sendError(Response.SC_FORBIDDEN);
		return new ResponseEntity<List>(stuList, responseHeaders, HttpStatus.CONFLICT);
	}

	@RequestMapping(value = "/api/rollNum/{rollNum}", method = RequestMethod.GET)
	public ResponseEntity welcome(@PathVariable(value = "rollNum", required = false) Integer rollNum) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.valueOf("application/json"));
		responseHeaders.add("testHeader", "testheaderValue:"+rollNum);

		System.out.println("payload path variable" + rollNum);
		if(rollNum == null)
			return new ResponseEntity(responseHeaders, HttpStatus.NO_CONTENT);

		return new ResponseEntity(responseHeaders, HttpStatus.OK);
	}

}
