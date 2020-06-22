package com.green.biz.review;

import java.util.List;

public interface ReviewService {

	List<ReviewVO> listReview(String id);
	
	ReviewVO getReview(ReviewVO reviewVO);
	
	void insertReview(ReviewVO reviewVO);
	
	void insertComment(ReviewVO reviewVO);
	
	//¸®ºä ¼öÁ¤
	public void updateReview(ReviewVO reviewVO);
}
