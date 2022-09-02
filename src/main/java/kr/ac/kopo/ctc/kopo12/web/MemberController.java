package kr.ac.kopo.ctc.kopo12.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import kr.ac.kopo.ctc.kopo12.domain.Member;
import kr.ac.kopo.ctc.kopo12.repository.MemberRepository;
import kr.ac.kopo.ctc.kopo12.service.MemberService;
import kr.ac.kopo.ctc.kopo12.service.MemberServiceImpl;

@Controller
@RequestMapping("/signUp")
public class MemberController {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	MemberService memberService = new MemberServiceImpl();

	@PostMapping("/WRITE") // add member
	public ResponseEntity<Member> addMember(@RequestBody Member member) {
		member.setPhone(member.getPhone().replaceAll("-", ""));
		member.setSalt(memberService.getSalt());
		member.setPasswd(memberService.getEncrypt(member.getPasswd(), member.getSalt()));
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
			item.setPasswd(memberService.getEncrypt(member.getPasswd(), item.getSalt()));
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
			@RequestParam(value = "birthday", required = false) String birthday,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "address", required = false) String address) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		memberRepository.findById(id).ifPresent(item -> {
			// if (var != null ) input var into item
			if (passwd != null) item.setPasswd(memberService.getEncrypt(passwd, item.getSalt()));
			if (name != null) item.setName(name);
			if (phone != null) item.setPhone(phone.replaceAll("-", ""));
			if (address != null) item.setAddress(address);
			
			try {
				Date date = format.parse(birthday);
				if (birthday != null) item.setBirthday(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			memberRepository.save(item);
		});

		Member item = memberRepository.findById(id).get();
		return new ResponseEntity<Member>(item, HttpStatus.OK);
	}
}
