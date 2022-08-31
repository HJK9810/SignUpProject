package kr.ac.kopo.ctc.kopo12.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Override
	public String getSalt() {
		// 1. Make Random, byte object
		SecureRandom r = new SecureRandom();
		byte[] salt = new byte[20];

		// 2. generate random number
		r.nextBytes(salt);

		// 3. byte to String == change decimal string
		StringBuffer sb = new StringBuffer();
		for (byte b : salt) {
			sb.append(String.format("%02x", b));
		}

		return sb.toString();
	}

	@Override
	public String getEncrypt(String pwd, String salt) {
		StringBuffer sb = new StringBuffer();

		try {
			// 1. make SHA256 Algolisthm object
			MessageDigest md = MessageDigest.getInstance("SHA-256");

			// 2. Apply SHA256 to (pwd + salt)
			md.update((pwd + salt).getBytes());
			byte[] applied = md.digest();

			// 3. byte to String == change decimal string
			for (byte b : applied) {
				sb.append(String.format("%02x", b));
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

}
