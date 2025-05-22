package kr.ac.kopo.petshop.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.petshop.dao.MemberDao;
import kr.ac.kopo.petshop.model.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao dao;
	
	@Override
	public List<Member> list() {
		return dao.list();
	}

	@Override
	public boolean login(Member item) {
		Member member = dao.item(item.getMemberId());
		
		if(member != null) {
			if(item.getPasswd().equals(member.getPasswd() )) {
				BeanUtils.copyProperties(member, item);
				item.setPasswd(null);
				
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void signup(Member item) {
		dao.add(item);
	}

	@Override
	public void add(Member item) {
		dao.add(item);
		
	}

	@Override
	public Member item(String memberId) {
		return dao.item(memberId);
	}

	@Override
	public void update(Member item) {
		dao.update(item);
		
	}

	@Override
	public void delete(String memberId) {
		dao.delete(memberId);
		
	}

	@Override
	public boolean isUnique(String memberId) {
		if(dao.item(memberId) == null)
			return true;
		return false;
	}

}
