package com.green.biz.notice;

import java.util.List;

import com.green.biz.utils.Criteria;

public interface NoticeService {

	List<NoticeVO> listNotice();
	
	NoticeVO getNotice(NoticeVO noticeVO);
	
	List<NoticeVO> listAllNotice(String id);
	
	//�������� ���
	public void insertNotice(NoticeVO noticeVO);
	
	public void updateNotice(NoticeVO noticeVO);
	
	//�������� ��� ��ȸ
	public List<NoticeVO> getListWithPaging(Criteria criteria, String key);
	
	public int countNoticeList(String subject);
	
	//----------------------------------------------------------
	public List<NoticeCommentVO> getCommentNoticeList(int nseq);
	
	public void saveNoticeComment(NoticeCommentVO commentVO);
	
	public void updateNoticeComment(NoticeCommentVO commentVO);
	
	public void deleteNoticeComment(int commentseq);
	
}
