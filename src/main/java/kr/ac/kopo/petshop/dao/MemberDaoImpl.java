package kr.ac.kopo.petshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.petshop.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	SqlSession sql;
	
	@Override
	public List<Member> list() {
		return sql.selectList("member.list");
	}

	@Override
	public Member item(String memberId) {
		return sql.selectOne("member.item", memberId);
	} 

	@Override
	public void add(Member item) {
		sql.insert("member.add", item);
	}

	@Override
	public void update(Member item) {
		sql.update("member.update", item);

	}

	@Override
	public void delete(String memberId) {
		sql.delete("member.delete", memberId);

	}

}
