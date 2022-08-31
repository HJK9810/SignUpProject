package kr.ac.kopo.ctc.kopo12.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.kopo.ctc.kopo12.service.MemberService;
import kr.ac.kopo.ctc.kopo12.service.MemberServiceImpl;

@Entity
public class Member {

	@Id
	@Column
	private String id;
	@Column
	private String passwd;
	@Column
	private String Name;
	@Temporal(TemporalType.DATE)
	@Column
	private Date birthday;
	@Column
	private String phone;
	@Column
	private String address;
	@Column
	private String salt;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
}
