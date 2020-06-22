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
		System.out.println("==> Mybatis�� listReview() ��� ó��");
		return mybatis.selectList("ReviewDAO.listReview",id);
	}
	
	public ReviewVO getReview(ReviewVO reviewVO) {
		System.out.println("==> Mybatis�� getReview() ��� ó��");
		return mybatis.selectOne("ReviewDAO.getReview",reviewVO);
	}
	
	public void insertReview(ReviewVO reviewVO) {
		System.out.println("==> Mybatis�� insertReview() ��� ó��");
		mybatis.insert("ReviewDAO.insertReview",reviewVO);
	}
	
	public void insertComment(ReviewVO reviewVO) {
		System.out.println("==> Mybatis�� insertComment() ��� ó��");
		mybatis.insert("ReviewDAO.insertComment",reviewVO);
	}
	
	public void updateReview(ReviewVO reviewVO) {
		System.out.println("Mybatis�� updateReview() ��� ó��");
		
		mybatis.update("ReviewDAO.updateReview",reviewVO);
	}
}
