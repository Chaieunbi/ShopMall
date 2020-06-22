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
	
	//��ü ��� ��ȸ
	public List<NoticeVO> listNotice() {
		System.out.println("==> Mybatis�� listNotice() ��� ó��");
		return mybatis.selectList("NoticeDAO.listNotice");
	}
	
	
	//�Ϸù�ȣ�� �������� ��� ��ȸ
	public NoticeVO getNotice(NoticeVO noticeVO) {
		System.out.println("==> Mybatis�� getNotice() ��� ó��");
		return mybatis.selectOne("NoticeDAO.getNotice",noticeVO);
	}
	
	public List<NoticeVO> listAllNotice(String id){
		System.out.println("==> Mybatis�� listAllNotice() ��� ó��");
		return mybatis.selectList("NoticeDAO.listAllNotice",id);
	}
	
	public void insertNotice(NoticeVO noticeVO) {
		System.out.println("Mybatis�� insertNotice() ��� ó��");
		
		mybatis.insert("NoticeDAO.insertNotice",noticeVO);
	}
	
	public void updateNotice(NoticeVO noticeVO) {
		System.out.println("Mybatis�� updateNotice() ��� ó��");
		
		mybatis.update("NoticeDAO.updateNotice",noticeVO);
	}
	
	public List<NoticeVO> getListWithPaging(Criteria criteria, String key) {
		System.out.println("==>Mybatis�� getListWithPaging() ��� ó��");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("NoticeDAO.getListWithPaging",map);
	}
	
	public int countNoticeList(String subject) {
		System.out.println("Mybatis�� countNoticeList() ��� ó��");
		
		return mybatis.selectOne("NoticeDAO.countNoticeList",subject);
	}
	
	/*
	 * ��ǰ�� ���� �޼ҵ�
	 */
	public List<NoticeCommentVO> getCommentNoticeList(int nseq){
		System.out.println("Mybatis�� getCommentNoticeList() ��� ó��");
		
		return mybatis.selectList("CommentDAO.getCommentNoticeList",nseq);
	}
	
	public void saveNoticeComment(NoticeCommentVO commentVO) {
		System.out.println("Mybatis�� saveNoticeComment() ��� ó��");
		
		mybatis.insert("CommentDAO.saveNoticeComment",commentVO);
	}
	
	public void updateNoticeComment(NoticeCommentVO commentVO) {
		System.out.println("Mybatis�� updteNoticeComment() ��� ó��");
		
		mybatis.update("CommentDAO.updateNoticeComment",commentVO);
	}
	
	public void deleteNoticeComment(int commentseq) {
		System.out.println("Mybatis�� deleteNoticeComment() ��� ó��");
		
		mybatis.delete("CommentDAO.deleteNoticeComment",commentseq);
	}
	
}
