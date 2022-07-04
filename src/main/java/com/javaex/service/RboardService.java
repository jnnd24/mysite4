package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.RboardDao;
import com.javaex.vo.RboardVo;

@Service
public class RboardService {
	
	@Autowired
	private RboardDao rboardDao;
	
	public List<RboardVo> getRboardList() {
		System.out.println(" RboardService > list");
		
		List<RboardVo> rboardList = rboardDao.getRboardList();
		
		return rboardList;
	}
	
	//게시물 작성
	public int write(RboardVo rboardVo) {
		System.out.println(" RboardService > write");
		
		int count = rboardDao.write(rboardVo);
		
		return count;
	}
	
	//글 읽기
	public RboardVo read(int no) {
		System.out.println(" RboardService > read");

		rboardDao.hit(no);
		
		return rboardDao.read(no);
	}
	
	//답글 작성
	public int reply(RboardVo rboardVo) {
		System.out.println(" RboardService > reply");
		
		//같은 그룹의 같거나 큰 orderId를 올리기
		rboardDao.orderNo(rboardVo);
		
		//답글 작성 하기
		int count = rboardDao.reply(rboardVo);
		
		return count;
	}

}
