package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.green.biz.member.MemberVO;
import com.green.biz.notice.NoticeCommentVO;
import com.green.biz.notice.NoticeService;
import com.green.biz.product.ProductCommentVO;
import com.green.biz.product.ProductService;

// 결과 Data를 전송하는 컨트롤러
@RestController
public class CommentController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	NoticeService noticeService; 

	@RequestMapping(value="save_comment", method=RequestMethod.POST)
	@ResponseBody
	public String saveComment(ProductCommentVO commentVO, HttpSession session) {
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			
			return ("fail");
		} else {
			String userId= loginUser.getId();
			
			commentVO.setWriter(userId);
			
			productService.saveComment(commentVO);
			return "success";
		}
	}
	
	@RequestMapping(value="/comment_list", method=RequestMethod.GET)
	public List<ProductCommentVO> getCommentList(ProductCommentVO commentVO) {
	
		int pseq = commentVO.getPseq();
		System.out.println("상품번호="+pseq);
		
		List<ProductCommentVO> commentList = productService.getCommentList(pseq);
		
		return commentList;
}
	
	@RequestMapping(value="save_notice_comment", method=RequestMethod.POST)
	@ResponseBody
	public String saveNoticeComment(NoticeCommentVO commentVO, HttpSession session) {
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			
			return ("fail");
		} else {
			String userId= loginUser.getId();
			
			commentVO.setWriter(userId);
			
			noticeService.saveNoticeComment(commentVO);
			return "success";
		}
	}
	
	@RequestMapping(value="/comment_notice_list", method=RequestMethod.GET)
	public List<NoticeCommentVO> getCommentList(NoticeCommentVO commentVO){
		
		int nseq = commentVO.getNseq();
		System.out.println("댓글번호="+nseq);
		
		List<NoticeCommentVO> commentList = noticeService.getCommentNoticeList(nseq);
		
		return commentList;
	}
	
	

}