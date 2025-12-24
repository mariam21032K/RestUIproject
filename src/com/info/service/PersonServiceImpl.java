package com.info.service;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.info.db.ConnexionDB;
import com.info.model.Person;

@WebService(endpointInterface = "com.info.service.PersonService")
public class PersonServiceImpl implements PersonService {
	
	private Connection cn;
	
	private Connection getConnection() {
		if (cn == null) {
			cn = ConnexionDB.getConnexion();
		}
		return cn;
	}

	@Override
	public boolean addPerson(Person p) {
	    String sql = "INSERT INTO `person` (`Name`, `Age`) VALUES (?, ?)";
	    try {
	    	System.out.println("Adding person: " + p.getName() + ", " + p.getAge());
	        PreparedStatement pst = getConnection().prepareStatement(sql);
	        pst.setString(1, p.getName());
	        pst.setInt(2, p.getAge());
	        int result = pst.executeUpdate();
	        System.out.println("Ajout avec succès - Rows affected: " + result);
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Erreur add: " + e.getMessage());
	        return false;
	    }
	}

	@Override
	public boolean deletePerson(int id) {
	    String sql = "DELETE FROM `person` WHERE id = ?";
	    try {
	        PreparedStatement pst = getConnection().prepareStatement(sql);
	        pst.setInt(1, id);
	        int rows = pst.executeUpdate();
	        return rows > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Erreur delete: " + e.getMessage());
	        return false;
	    }
	}

	@Override
	public Person getPerson(int id) {
	    Person person = null;
	    String sql = "SELECT `id`, `Name`, `Age` FROM `person` WHERE id = ?";
	    try {
	        PreparedStatement pst = getConnection().prepareStatement(sql);
	        pst.setInt(1, id);
	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            person = new Person();
	            person.setId(rs.getInt("id"));
	            person.setAge(rs.getInt("Age"));
	            person.setName(rs.getString("Name"));
	        }
	        return person;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println(e.getMessage());
	        return null;
	    }
	}
	
	@Override
	public Person getPersonByName(String name) {
	    Person person = null;
	    String sql = "SELECT `id`, `Name`, `Age` FROM `person` WHERE Name = ?";
	    try {
	        PreparedStatement pst = getConnection().prepareStatement(sql);
	        pst.setString(1, name);
	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            person = new Person();
	            person.setId(rs.getInt("id"));
	            person.setAge(rs.getInt("Age"));
	            person.setName(rs.getString("Name"));
	        }
	        return person;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Erreur getPersonByName: " + e.getMessage());
	        return null;
	    }
	}
	
	@Override
	public Person[] getAllPersons() {
	    List<Person> persons = new ArrayList<>();
	    String sql = "SELECT `id`, `Name`, `Age` FROM `person`";
	    try {
	        Statement st = getConnection().createStatement();
	        ResultSet rs = st.executeQuery(sql);
	        
	        while (rs.next()) {
	            Person person = new Person();
	            person.setId(rs.getInt("id"));
	            person.setName(rs.getString("Name"));
	            person.setAge(rs.getInt("Age"));
	            persons.add(person);
	        }
	        return persons.toArray(new Person[0]);
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Erreur getAllPersons: " + e.getMessage());
	        return null;
	    }
	}
	
	@Override
	public boolean update(Person person) {
	    String sql = "UPDATE `person` SET `Name` = ?, `Age` = ? WHERE `id` = ?";
	    try {
	    	System.out.println("Updating person: id=" + person.getId() + ", name=" + person.getName() + ", age=" + person.getAge());
	        PreparedStatement pst = getConnection().prepareStatement(sql);
	        pst.setString(1, person.getName());
	        pst.setInt(2, person.getAge());
	        pst.setInt(3, person.getId());
	        int rows = pst.executeUpdate();
	        System.out.println("Update result - Rows affected: " + rows);
	        return rows > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Erreur update: " + e.getMessage());
	        return false;
	    }
	}
}