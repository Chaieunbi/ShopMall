package com.green.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.green.biz.member.MemberVO;
import com.green.biz.review.ReviewService;
import com.green.biz.review.ReviewVO;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	// 리뷰 리스트
	@RequestMapping(value="/review_list")
	public String reviewList(HttpSession session, Model model) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser"); //사용자 확인
		
		if(loginUser == null) {
			return "member/login"; //로그인 페이지 호출
		}else {
			List<ReviewVO> reviewList = reviewService.listReview(loginUser.getId());
			
			model.addAttribute("reviewList",reviewList);
			
			return "review/reviewList";
		}
	}
	
	@RequestMapping(value="review_view")
	public String reviewView(ReviewVO vo, HttpSession session, Model model) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "memeber/login";
		} else {
			ReviewVO reviewVO = reviewService.getReview(vo);
			
			model.addAttribute("reviewVO",reviewVO);
			
			return "review/reviewView";
		}
	}
	
	// 리뷰 작성페이지
		@RequestMapping(value="/review_write_form")
		public String reviewWriteView(ReviewVO reviewVO,HttpSession session, Model model) {
			
			MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
			
			if(loginUser == null) {
				return "memeber/login";
			} else {
				reviewVO.setId(loginUser.getId());
				return "review/reviewWrite";
			}
		}
	
	// 리뷰 등록
		@RequestMapping(value="/review_write")
		public String reviewWrite(ReviewVO reviewVO, HttpSession session, Model model) {
			
			MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
			
			if(loginUser == null) {
				return "memeber/login";
			} else{
				reviewVO.setId(loginUser.getId());
				
				reviewService.insertReview(reviewVO);
				
				return "redirect:review_list";
			}
		}
		
		@RequestMapping(value="/comment_review")
		public String commentReview(ReviewVO reviewVO, HttpSession session, Model model) {
			
			MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
			
			if(loginUser == null) {
				return "memeber/login";
			} else{
				reviewVO.setId(loginUser.getId());
				
				reviewService.insertComment(reviewVO);
				
				return "redirect:review_list";
			}
		}
		
		@RequestMapping(value="review_update_form")
		public String reviewUpdateView(ReviewVO reviewVO, Model model, HttpSession session) {
			
			MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
			
			if(loginUser == null) {
				return "member/login";
			}else {
			ReviewVO vo = reviewService.getReview(reviewVO);
			
			model.addAttribute("reviewVO",vo);
			
			return "review/reviewUpdate";
			}
		}
		
		@RequestMapping(value="review_update")
		public String reviewUpdate(@RequestParam(value="review_image") MultipartFile uploadFile, ReviewVO vo, Model model, HttpSession session) {
			
			MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
			
			if(loginUser == null) {
				return "member/login";
		} else {
			String fileName = "";
			
			if(!uploadFile.isEmpty()) {
				String root_path = session.getServletContext().getRealPath("WEB-INF/resources/product_images/");
				
				System.out.println("Root 경로=" + root_path);
				
				fileName = uploadFile.getOriginalFilename();
				
				try {
					File file = new File(root_path + fileName);
					uploadFile.transferTo(file);
				} catch (IllegalStateException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				vo.setImage(fileName);
			}
			System.out.println("업데이트 정보:" + vo);
			reviewService.updateReview(vo);
			
			return "redirect:review_list?rseq"+vo.getRseq();
		}	
	}
}
