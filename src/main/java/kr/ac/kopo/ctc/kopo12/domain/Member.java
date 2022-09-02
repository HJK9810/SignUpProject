package kr.ac.kopo.ctc.kopo12.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Member {

	@Id
	@Column
	@ApiModelProperty(example = "User Id")
	private String id; // User ID
	@Column
	@ApiModelProperty(example = "Password")
	private String passwd; // User Password
	@Column
	@ApiModelProperty(example = "User Name")
	private String Name; // User Name
	@Temporal(TemporalType.DATE)
	@Column
	@ApiModelProperty(example = "Birthday yyyy-MM-dd")
	private Date birthday; // Birthday
	@Column
	@ApiModelProperty(example = "phone Number")
	private String phone;
	@Column
	@ApiModelProperty(example = "Address")
	private String address;
	@Column
	private String salt; // Salt for password Encryption
	
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
