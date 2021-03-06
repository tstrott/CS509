package client.abuse_report;





/**
 * A victim is an Individual who has been allegedly abused by an Abuser.
 * @author Matt Orsini
 *
 */
public class Victim extends Individual {

	// Configurable? Probably not in Java.
	private static final int MAX_NUM_COMMUNICATION_NEEDS = 3;
	private static final int MAX_NUM_DISABILITIES        = 20;
		
	private boolean male;
	private boolean female;
	private String dateOfBirth;
	private String age;
	private String maritalStatus; 
	
	private String[] disabilities = new String[MAX_NUM_DISABILITIES];
	private String ethnicity;
	private String[] comNeeds = new String [MAX_NUM_COMMUNICATION_NEEDS];

	/**
	 * Constructor for Victim. Superclass is an Individual.
	 */
	public Victim(){
		// FIXME: Empty constructor.
	}

	/**
	 * Returns if the Victim is a male.
	 * @return male
	 */
	public boolean isMale() {
		return male;
	}
	/**
	 * Sets the Victim to male. Victims cannot be male and female, so female will be cleared.
	 * @param male
	 */
	public void setMale(boolean male) {
		if(male) {
			this.male = male;
			setFemale(false);
		}
	}

	/**
	 * Returns if the Victim is a female.
	 * @return female
	 */
	public boolean isFemale() {
		return female;
	}
	/**
	 * Sets the Victim is a female. Victims cannot be male and female, so male will be cleared.
	 * @param female
	 */
	public void setFemale(boolean female) {
		if(female){
			this.female = female;
			setMale(false);
		}
	}

	/**
	 * Returns the date of birth for the Victim.
	 * @return dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * Set the date of birth for the Victim.
	 * @param dateOfBirth
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Returns the age of the Victim.
	 * @return age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * Set the age of the Victim.
	 * @param string
	 */
	public void setAge(String string) {
		this.age = string;
	}

	/**
	 * Returns the marital status of the Victim.
	 * @return
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}
	/**
	 * Sets the marital status of the Victim. 
	 * 	@param maritalStatus
	 */
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	/**
	 * Sets the disabilities for this client.
	 * @param disability  - the disability
	 * @param n           - the index
	 */
	public void setDisabilities(String disability, int n){
		this.disabilities[n] = disability;
	}
	
	/**
	 * Gets all disabilities for this client.
	 * @return disabilities - the disability array.
	 */
	public String[] getDisabilities(){
		return disabilities;
	}
	
	/**
	 * Gets the disability at the specified index.
	 * @return disabilities[n] - the disability at the position n.
	 */
	public String getDisabilityAt(int n) {
		return disabilities[n];
	}

	/**
	 * Get the ethnicity for this client.
	 * @return ethnicity - the ethnicity of the client.
	 */
	public String getEthnicity() {
		return ethnicity;
	}

	/**
	 * Set the ethnicity for this client.
	 * @param ethnicity - the ethnicity of the client.
	 */
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	
	/**
	 * Set the communication needs for thsi client.
	 * @param comNeeds
	 */
	public void setComNeeds(String comNeeds, int n){
		this.comNeeds[n] = comNeeds;
	}
	
	/**
	 * Get the communication needs for this client.
	 */
	public String[] getComNeeds() {
		return comNeeds;
	}
	
	
}