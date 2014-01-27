package database.layers;

public class Employee {
	private int id;
	private int dept_id;
	private String full_name;
	private String gender;
	
	private String address;
	private String phone;
	/**
	 * @param dept_id the dept_id to set
	 */
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setUser_id(int user_id) {
		this.dept_id = user_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
