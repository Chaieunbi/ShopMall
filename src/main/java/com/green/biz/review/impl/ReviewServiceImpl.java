package com.green.biz.review.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.review.ReviewService;
import com.green.biz.review.ReviewVO;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDAO reviewDao;
	
	@Override
	public List<ReviewVO> listReview(String id) {
		// TODO Auto-generated method stub
		return reviewDao.listReview(id);
	}

	@Override
	public ReviewVO getReview(ReviewVO reviewVO) {
		// TODO Auto-generated method stub
		return reviewDao.getReview(reviewVO);
	}

	@Override
	public void insertReview(ReviewVO reviewVO) {
		// TODO Auto-generated method stub
		reviewDao.insertReview(reviewVO);
	}
	
	@Override
	public void insertComment(ReviewVO reviewVO) {
		reviewDao.insertComment(reviewVO);
	}

	@Override
	public void updateReview(ReviewVO reviewVO) {
		reviewDao.updateReview(reviewVO);
	}

}
