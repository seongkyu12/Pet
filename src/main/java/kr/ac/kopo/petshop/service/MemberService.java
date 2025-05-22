package kr.ac.kopo.petshop.service;

import java.util.List;

import kr.ac.kopo.petshop.model.Member;

public interface MemberService {

	List<Member> list();

	boolean login(Member item);

	void signup(Member item);

	void add(Member item);

	Member item(String memberId);

	void update(Member item);

	void delete(String memberId);

	boolean isUnique(String memberId);

}
