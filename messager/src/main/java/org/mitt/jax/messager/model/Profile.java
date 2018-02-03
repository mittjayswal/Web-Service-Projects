package org.mitt.jax.messager.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	private long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private String profileName;
	private String firstName;
	private String lastName;
	private String created;
	
	public Profile() {
		// TODO Auto-generated constructor stub
	}

	

	public Profile(long id, String profileName, String firstName, String lastName, String created) {
		super();
		this.id = id;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = created;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
	
}
