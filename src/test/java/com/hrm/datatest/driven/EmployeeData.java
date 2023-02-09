package com.hrm.datatest.driven;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class EmployeeData {
	
	
	public static EmployeeData getEmployee() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/src/test/java/testdata/com/hrm/datatest/driven/Employee.json"), EmployeeData.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@JsonProperty("firstname")
	private String firstname;
	
	@JsonProperty("lastname")
	private String lastname;
	
	@JsonProperty("username")
	private String username;
	
	@JsonProperty("passwod")
	private String passwod;
	
	@JsonProperty("usernameAdmin")
	private String usernameAdmin;
	
	@JsonProperty("passwordAdmin")
	private String passwordAdmin;
	
	@JsonProperty("statusValue")
	private String statusValue;
	
	@JsonProperty("fullnameUser")
	private String fullnameUser;
	
	@JsonProperty("MyInfo")
	MyInfo myInfo;
	public static class MyInfo {
	@JsonProperty("avatar")
	private String avatar;
	}
	
	@JsonProperty("PersonalDetails")
	PersonalDetails personalDetails;
	
	public static class PersonalDetails{
		
	@JsonProperty("edit_Firstname")
	private String edit_Firstname;
	
	@JsonProperty("edit_Lastname")
	private String edit_Lastname;
	
	@JsonProperty("otherId")
	private String otherId;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("nationality")
	private String nationality;
	
	@JsonProperty("maritalStatus")
	private String maritalStatus;
	
	@JsonProperty("licenseExpiryDate")
	private String licenseExpiryDate;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getUsername() {
		return username;
	}

	public String getPasswod() {
		return passwod;
	}

	public String getUsernameAdmin() {
		return usernameAdmin;
	}

	public String getPasswordAdmin() {
		return passwordAdmin;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public String getFullnameUser() {
		return fullnameUser;
	}

	public String getAvatar() {
		return myInfo.avatar;
	}

	public String getEdit_Firstname() {
		return personalDetails.edit_Firstname;
	}

	public String getEdit_Lastname() {
		return personalDetails.edit_Lastname;
	}

	public String getOtherId() {
		return personalDetails.otherId;
	}

	public String getGender() {
		return personalDetails.gender;
	}

	public String getNationality() {
		return personalDetails.nationality;
	}

	public String getMaritalStatus() {
		return personalDetails.maritalStatus;
	}

	public String getLicenseExpiryDate() {
		return personalDetails.licenseExpiryDate;
	}
	

}
