package kr.ac.kopo.ctc.kopo12.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import kr.ac.kopo.ctc.kopo12.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor<Member> {
	
	Optional<Member> findById(String Id);
	
	List<Member> findAll();
}
