package com.appx.demo.jackson;

import java.util.ArrayList;
import java.util.List;

import com.appx.demo.jackson.dto.Department;
import com.appx.demo.jackson.dto.User;
import com.appx.demo.jackson.view.JsonViews;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
	public static void main(String[] args) throws Exception {
		App app = new App();

		app.runObjectToJson();

		app.runJsonToObject();

		app.runObjectToJsonWithView();
	}

	private Department prepareObj() {
		Department d = new Department("IT");

		List<User> users = new ArrayList<>();
		users.add(new User("Ken", 30, "team leader", "password1"));
		users.add(new User("Owen", 28, "senior engineer", "password2"));

		d.setUsers(users);
		return d;
	}

	public void runObjectToJson() throws Exception {
		Department d = this.prepareObj();

		ObjectMapper om = new ObjectMapper();

		// Convert object to JSON string
		String jsonString = om.writeValueAsString(d);
		System.out.println("===== Convert object to JSON string =====");
		System.out.println(jsonString);

		// Convert object to JSON string and pretty print
		jsonString = om.writerWithDefaultPrettyPrinter().writeValueAsString(d);
		System.out.println("===== Convert object to JSON string and pretty print =====");
		System.out.println(jsonString);

		// Convert object to JSON string and save to file
		// om.writeValue(new File("D:/temp.json"), d);
	}

	public void runJsonToObject() throws Exception {
		String json = "{\"name\":\"IT\",\"users\":[{\"name\":\"Ken\",\"age\":30,\"title\":\"team leader\",\"password\":\"password1\"},{\"name\":\"Owen\",\"age\":28,\"title\":\"senior engineer\",\"password\":\"password2\"}]}";

		ObjectMapper om = new ObjectMapper();

		// Convert JSON sring to object
		Department d = om.readValue(json, Department.class);

		// or read from JSON file
		// Department d = om.readValue(new File("D:/temp.json") ,Department.class);

		String jsonString = om.writerWithDefaultPrettyPrinter().writeValueAsString(d);
		System.out.println("===== Convert JSON string to object =====");
		System.out.println(jsonString);

	}

	public void runObjectToJsonWithView() throws Exception {
		Department d = this.prepareObj();

		ObjectMapper om = new ObjectMapper();

		// Convert object to JSON string with Public view
		String jsonString = om.writerWithView(JsonViews.Public.class).writeValueAsString(d);
		System.out.println("===== Convert object to JSON string with Public view =====");
		System.out.println(jsonString);

		jsonString = om.writerWithView(JsonViews.Private.class).writeValueAsString(d);
		System.out.println("===== Convert object to JSON string with Private view =====");
		System.out.println(jsonString);
	}
}
