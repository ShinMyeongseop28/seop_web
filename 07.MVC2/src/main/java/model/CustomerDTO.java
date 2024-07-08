package model;

public class CustomerDTO {
	//DB의 table의 컬럼명과 동일한 필드명으로 선언 + getter, setter 메소드 선언
	private int id;
	private String name, gender, phone, email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
//    ID      NUMBER CONSTRAINT customer_id_pk PRIMARY KEY,
//    NAME    VARCHAR2(50) NOT NULL,
//    GENDER  VARCHAR2(3) DEFAULT '남' NOT NULL,
//    PHONE   VARCHAR2(13),
//    EMAIL   VARCHAR2(50)
}
