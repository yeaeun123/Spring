package himedia.myportal.repositories.vo;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserVo {
	private Long no;	//pk
	
	@NotEmpty
	@Length(min=2, max=8)	//이름 길이가 2~8자 사이
	private String name;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Length(min=4, max=20) //최소 4자리~최대 20자리
	private String password;
	
	@NotNull
	private String gender;
	private Date joinDate;	//java.util.Date

	// 생성자
	public UserVo() {
		
	}
	
	public UserVo(String name, String email, String password, String gender) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}
	
	// Getters / Sertters
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	// toString
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", joinDate=" + joinDate + "]";
	}
	
	
}
