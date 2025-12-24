package com.info.router;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.info.model.Person;
import com.info.service.PersonServiceImpl;


@Path("/users")
public class RestRouter {

	PersonServiceImpl ps = new PersonServiceImpl();

	@GET
	@Path("/affiche")
	@Produces(MediaType.APPLICATION_JSON)
	public Person[] getAllUsers() {
		return ps.getAllPersons();
	}

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Map<String, Object> addUser(Person user) {

	    Map<String, Object> response = new HashMap<>();
	    
	    try {
	    	System.out.println("Received person: name=" + user.getName() + ", age=" + user.getAge());
	    	
	    	if (user.getName() == null || user.getName().isEmpty()) {
	    		response.put("state", "ko");
	    		response.put("message", "Name cannot be empty");
	    		return response;
	    	}
	    	
	    	if (user.getAge() <= 0) {
	    		response.put("state", "ko");
	    		response.put("message", "Age must be greater than 0");
	    		return response;
	    	}

	        if (ps.addPerson(user)) {
	            response.put("state", "ok");
	            response.put("message", "Person added successfully");
	        } else {
	            response.put("state", "ko");
	            response.put("message", "Failed to add person");
	        }
	    } catch (Exception e) {
	        System.out.println("Error in addUser: " + e.getMessage());
	        e.printStackTrace();
	        response.put("state", "error");
	        response.put("message", e.getMessage());
	    }

	    return response;
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> getUserById(@PathParam("id") int id) {
		Map<String, Object> response = new HashMap<>();
		try {
			System.out.println("Getting person with id: " + id);
			Person person = ps.getPerson(id);
			if (person != null) {
				response.put("state", "ok");
				response.put("data", person);
			} else {
				response.put("state", "ko");
				response.put("message", "Person not found");
			}
		} catch (Exception e) {
			System.out.println("Error in getUserById: " + e.getMessage());
			e.printStackTrace();
			response.put("state", "error");
			response.put("message", e.getMessage());
		}
		return response;
	}

	@DELETE
	@Path("/remove/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> deleteUser(@PathParam("id") int id) {
		Map<String, Object> response = new HashMap<>();

		try {
			if (ps.deletePerson(id)) {
				response.put("state", "ok");
			} else {
				response.put("state", "ko: id doesn't exist");
			}
			return response;
		} catch (Exception e) {
			response.put("state", "error");
			response.put("msg", e.getMessage());
			return response;
		}
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Map<String, Object> updateUser(Person user) {

	    Map<String, Object> response = new HashMap<>();
	    
	    try {
	    	System.out.println("Updating person: id=" + user.getId() + ", name=" + user.getName() + ", age=" + user.getAge());
	    	
	    	if (user.getId() <= 0) {
	    		response.put("state", "ko");
	    		response.put("message", "ID must be greater than 0");
	    		return response;
	    	}
	    	
	    	if (user.getName() == null || user.getName().isEmpty()) {
	    		response.put("state", "ko");
	    		response.put("message", "Name cannot be empty");
	    		return response;
	    	}

	        if (ps.update(user)) {
	            response.put("state", "ok");
	            response.put("message", "User updated");
	        } else {
	            response.put("state", "ko");
	            response.put("message", "User not found");
	        }
	    } catch (Exception e) {
	        System.out.println("Error in updateUser: " + e.getMessage());
	        e.printStackTrace();
	        response.put("state", "error");
	        response.put("message", e.getMessage());
	    }

	    return response;
	}
}