package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.member.MemberVO;
import com.green.biz.notice.NoticeService;
import com.green.biz.notice.NoticeVO;
import com.green.biz.qna.QnaVO;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/notice_list")
	public String noticeList(HttpSession session, Model model) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			List<NoticeVO> noticeList = noticeService.listNotice();
			model.addAttribute("noticeList",noticeList);
			return "notice/noticeList";
		}
	}
	
	
	@RequestMapping(value="/notice_view")
	public String noticeView(NoticeVO vo, HttpSession session, Model model) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			NoticeVO noticeVO = noticeService.getNotice(vo); //화면에서 받은 qseq를 얻음, qnaVO 값으로 넘겨주는 것(qnaView에서 ${qnaVO.~})
			
			model.addAttribute("noticeVO", noticeVO);
			
			return "notice/noitceView";
		}
	}
	
}
