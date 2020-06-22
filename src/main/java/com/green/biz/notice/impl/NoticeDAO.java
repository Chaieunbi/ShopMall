package com.green.biz.notice.impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.notice.NoticeCommentVO;
import com.green.biz.notice.NoticeVO;
import com.green.biz.utils.Criteria;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	//전체 목록 조회
	public List<NoticeVO> listNotice() {
		System.out.println("==> Mybatis로 listNotice() 기능 처리");
		return mybatis.selectList("NoticeDAO.listNotice");
	}
	
	
	//일련번호를 조건으로 목록 조회
	public NoticeVO getNotice(NoticeVO noticeVO) {
		System.out.println("==> Mybatis로 getNotice() 기능 처리");
		return mybatis.selectOne("NoticeDAO.getNotice",noticeVO);
	}
	
	public List<NoticeVO> listAllNotice(String id){
		System.out.println("==> Mybatis로 listAllNotice() 기능 처리");
		return mybatis.selectList("NoticeDAO.listAllNotice",id);
	}
	
	public void insertNotice(NoticeVO noticeVO) {
		System.out.println("Mybatis로 insertNotice() 기능 처리");
		
		mybatis.insert("NoticeDAO.insertNotice",noticeVO);
	}
	
	public void updateNotice(NoticeVO noticeVO) {
		System.out.println("Mybatis로 updateNotice() 기능 처리");
		
		mybatis.update("NoticeDAO.updateNotice",noticeVO);
	}
	
	public List<NoticeVO> getListWithPaging(Criteria criteria, String key) {
		System.out.println("==>Mybatis로 getListWithPaging() 기능 처리");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("NoticeDAO.getListWithPaging",map);
	}
	
	public int countNoticeList(String subject) {
		System.out.println("Mybatis로 countNoticeList() 기능 처리");
		
		return mybatis.selectOne("NoticeDAO.countNoticeList",subject);
	}
	
	/*
	 * 상품평 관련 메소드
	 */
	public List<NoticeCommentVO> getCommentNoticeList(int nseq){
		System.out.println("Mybatis로 getCommentNoticeList() 기능 처리");
		
		return mybatis.selectList("CommentDAO.getCommentNoticeList",nseq);
	}
	
	public void saveNoticeComment(NoticeCommentVO commentVO) {
		System.out.println("Mybatis로 saveNoticeComment() 기능 처리");
		
		mybatis.insert("CommentDAO.saveNoticeComment",commentVO);
	}
	
	public void updateNoticeComment(NoticeCommentVO commentVO) {
		System.out.println("Mybatis로 updteNoticeComment() 기능 처리");
		
		mybatis.update("CommentDAO.updateNoticeComment",commentVO);
	}
	
	public void deleteNoticeComment(int commentseq) {
		System.out.println("Mybatis로 deleteNoticeComment() 기능 처리");
		
		mybatis.delete("CommentDAO.deleteNoticeComment",commentseq);
	}
	
}
