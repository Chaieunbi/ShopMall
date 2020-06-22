package com.green.biz.review.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.review.ReviewVO;

@Repository
public class ReviewDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<ReviewVO> listReview(String id) {
		System.out.println("==> Mybatis로 listReview() 기능 처리");
		return mybatis.selectList("ReviewDAO.listReview",id);
	}
	
	public ReviewVO getReview(ReviewVO reviewVO) {
		System.out.println("==> Mybatis로 getReview() 기능 처리");
		return mybatis.selectOne("ReviewDAO.getReview",reviewVO);
	}
	
	public void insertReview(ReviewVO reviewVO) {
		System.out.println("==> Mybatis로 insertReview() 기능 처리");
		mybatis.insert("ReviewDAO.insertReview",reviewVO);
	}
	
	public void insertComment(ReviewVO reviewVO) {
		System.out.println("==> Mybatis로 insertComment() 기능 처리");
		mybatis.insert("ReviewDAO.insertComment",reviewVO);
	}
	
	public void updateReview(ReviewVO reviewVO) {
		System.out.println("Mybatis로 updateReview() 기능 처리");
		
		mybatis.update("ReviewDAO.updateReview",reviewVO);
	}
}
