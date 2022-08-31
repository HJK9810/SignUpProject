package kr.ac.kopo.ctc.kopo12.service;

public interface MemberService {
	
	// make Salt
	String getSalt();
	
	// passwd encrypt
	String getEncrypt(String pwd, String salt);
}
