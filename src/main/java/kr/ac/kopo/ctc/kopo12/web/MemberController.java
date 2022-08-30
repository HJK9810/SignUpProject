package kr.ac.kopo.ctc.kopo12.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.kopo12.domain.Member;
import kr.ac.kopo.ctc.kopo12.repository.MemberRepository;

@Controller
@RequestMapping("/signUp")
public class MemberController {

	@Autowired
	MemberRepository memberRepository;

	@PostMapping("/WRITE") // add member
	public ResponseEntity<Member> addMember(@RequestBody Member member) {
		memberRepository.save(member);

		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}

	@GetMapping("/READ") // find all members list
	public ResponseEntity<List<Member>> getMemberList() {
		List list = memberRepository.findAll();

		return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
	}

	@GetMapping("/READ/{id}") // find one member by id
	public ResponseEntity<Member> getMemberOne(@PathVariable("id") String id) {
		Member member = memberRepository.findById(id).get();

		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}

	@PostMapping("/UPDATE/{id}") // update all field
	public ResponseEntity<Member> updateAll(@PathVariable("id") String id, @RequestBody Member member) {
		memberRepository.findById(id).ifPresent(item -> {
			item.setPasswd(member.getPasswd());
			item.setName(member.getName());
			item.setBirthday(member.getBirthday());
			item.setPhone(member.getPhone());
			item.setAddress(member.getAddress());

			memberRepository.save(item);
		});

		Member item = memberRepository.findById(id).get();
		return new ResponseEntity<Member>(item, HttpStatus.OK);
	}

	@PutMapping("/UPDATE/{id}") // update specific field
	public ResponseEntity<Member> updateSeper(@PathVariable("id") String id,
			@RequestParam(value = "passwd", required = false) String passwd,
			@RequestParam(value = "Name", required = false) String name,
			@RequestParam(value = "birthday", required = false) Date birthday,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "address", required = false) String address) {

		memberRepository.findById(id).ifPresent(item -> {
			if (passwd != null) item.setPasswd(passwd);
			if (name != null) item.setName(name);
			if (birthday != null) item.setBirthday(birthday);
			if (phone != null) item.setPhone(phone);
			if (address != null) item.setAddress(address);

			memberRepository.save(item);
		});

		Member item = memberRepository.findById(id).get();
		return new ResponseEntity<Member>(item, HttpStatus.OK);
	}
}
