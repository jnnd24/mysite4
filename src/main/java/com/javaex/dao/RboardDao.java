package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.RboardVo;

@Repository
public class RboardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//리스트 불러오기
	public List<RboardVo> getRboardList() {
		System.out.println(" RboardDao > list");
		
		List<RboardVo> rboardList = sqlSession.selectList("rboard.getrboardList");
		
		return rboardList;
	}
	
	
	//게시물 등록
	public int write(RboardVo rboardVo) {
		System.out.println(" RboardDao > insert");
		
		int count = sqlSession.insert("rboard.write", rboardVo);
		
		return count;
	}

	//글 읽기
	public RboardVo read(int no) {
		System.out.println(" RboardDao > read");
		
		return sqlSession.selectOne("rboard.read", no);
	}
	
	//조회수 올리기
	public int hit(int no) {
		
		int count = sqlSession.update("rboard.hit", no);
		
		return count;
	}
	
	//답글 작성
	public int reply(RboardVo rboardVo) {
		System.out.println(" RboardDao > reply");

		return sqlSession.insert("rboard.reply", rboardVo);
	}
	
	//같은 그룹의 같거나 큰 orderId를 올리기
	public void orderNo(RboardVo rboardVo) {
		System.out.println(" RboardDao > orderNo");
		
		sqlSession.update("rboard.orderNo", rboardVo);
		
	}
	
}
