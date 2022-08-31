package kr.ac.kopo.ctc.kopo12.service;

public interface MemberService {
	
	// make Salt
	public String getSalt();
	
	// passwd encrypt
	public String getEncrypt(String pwd, String salt);
}
