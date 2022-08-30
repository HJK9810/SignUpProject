package kr.ac.kopo.ctc.kopo12.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.kopo12.domain.Member;
import kr.ac.kopo.ctc.kopo12.repository.MemberRepository;

@Controller
@RequestMapping("/signUp")
public class MemberController {
	
	@Autowired
	MemberRepository memberRepository;
	
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
}
