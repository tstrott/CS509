package client.abuse_report;

/** 
 * Individual describes the common attributes between all persons involved with
 * an abuse report.
 * 
 * @author Matt Orsini
 */

public class Individual {

	protected String firstName;
	protected String lastName;
	protected String address;
	protected String telephone;
	private String relationshipToVictim;

	/**
	 * Constructor. This class is meant to be extended.
	 */
	public Individual() {
		// FIXME: Empty constructor?
	}


	/**
	 * Get the relationship to the victim. Each individual in the report has
	 * a relationship to the alleged victim.
	 * @return relationshipToVictim
	 */
	public String getRelationshipToVictim() {
		return relationshipToVictim;
	}
	/**
	 * Set the relationship to the victim. Each individual in the report has
	 * a relationship to the alleged victim.
	 * @param relationshipToVictim
	 */
	public void setRelationshipToVictim(String relationshipToVictim) {
		this.relationshipToVictim = relationshipToVictim;
	}

	/**
	 * Get the name of the required individual.
	 * @return name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Set the name of the required individual.
	 * @param name
	 */
	public void setFirstName(String name) {
		this.firstName = name;
	}

	/**
	 * Return the address of the individual.
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Set the address of the individual.
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get the telephone number of the individual.
	 * @return telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Set the telephone number of the individual.
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Get the last name of the individual.
	 * @return
	 */
	public String getLastName(){
		return lastName;
	}

	/**
	 * Set the last name of the individual.
	 * @param name
	 */
	public void setLastName(String name){
		this.lastName = name;
	}

}