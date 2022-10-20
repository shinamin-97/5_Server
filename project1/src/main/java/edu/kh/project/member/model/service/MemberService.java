package edu.kh.project.member.model.service;

import static edu.kh.project.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.vo.Member;



/** 회원 전용 기능 제공
 * @author SAM
 */
public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	/** 로그인 Service
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Member member) throws Exception{
		
		Connection conn = getConnection();
		
		Member loginMember = dao.login(conn,member);
		
		close(conn);
		
		return loginMember;
	}

	public int signUp(Member member)throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, member);
		
		close(conn);
		
		
		return result;
	}

	public int UpdateMember(Member member) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updateMmeber(conn, member);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		close(conn);
		
		
		return result;
	}

}
