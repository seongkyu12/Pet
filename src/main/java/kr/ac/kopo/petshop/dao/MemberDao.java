package kr.ac.kopo.petshop.dao;

import java.util.List;

import kr.ac.kopo.petshop.model.Member;

public interface MemberDao {

	List<Member> list();

	Member item(String memberId);

	void add(Member item);

	void update(Member item);

	void delete(String memberId);

}
