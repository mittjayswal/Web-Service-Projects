package org.mitt.jax.messager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mitt.jax.messager.database.DatabaseClass;
import org.mitt.jax.messager.model.Profile;

public class ProfileService {

	
	 private Map<String, Profile> profiles = DatabaseClass.getProfile();
	
	 public ProfileService() {
		profiles.put("Mitt", new Profile(1L, "Mitt", "Max", "Jayswal", "xyz"));
		profiles.put("Dil", new Profile(2L, "Shivam", "Max", "Jayswal", "xyz"));
	}
	 public List<Profile> getAllProfiles(){
		 return new ArrayList<Profile>(profiles.values());
	 }
	 
	 public Profile getProfile(String ProfileName) {
		 return profiles.get(ProfileName);
	 }
	 
	 public Profile addProfile(Profile profile) {
		 profile.setId(profiles.size()+1);
		 profiles.put(profile.getProfileName(), profile);
		 return profile;
	 }
	 
	 public Profile updateProfile(Profile profile) {
		 if (profile.getProfileName().isEmpty() ) {
			 return null;
		 }
		 profiles.put(profile.getProfileName(), profile);
		 return profile;
	 }
	 
	 public Profile removeProfile (String ProfileName) {
		 return profiles.remove(ProfileName);
	 }
}
