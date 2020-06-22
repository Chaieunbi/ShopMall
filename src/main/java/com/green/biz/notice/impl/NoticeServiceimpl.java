package com.green.biz.notice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.notice.NoticeCommentVO;
import com.green.biz.notice.NoticeService;
import com.green.biz.notice.NoticeVO;
import com.green.biz.utils.Criteria;

@Service
public class NoticeServiceimpl implements NoticeService {

	@Autowired
	private NoticeDAO noticeDao;
	
	@Override
	public List<NoticeVO> listNotice() {
		// TODO Auto-generated method stub
		return noticeDao.listNotice();
	}
	
	@Override
	public NoticeVO getNotice(NoticeVO noticeVO) {
		// TODO Auto-generated method stub
		return noticeDao.getNotice(noticeVO);
	}
	
	@Override
	public List<NoticeVO> listAllNotice(String id){
		
		return noticeDao.listAllNotice(id);
	}
	
	@Override
	public void insertNotice(NoticeVO noticeVO) {
		
		noticeDao.insertNotice(noticeVO);
	}
	
	@Override
	public void updateNotice(NoticeVO noticeVO) {
		
		noticeDao.updateNotice(noticeVO);
	}
	
	@Override
	public List<NoticeVO> getListWithPaging(Criteria criteria, String key){
		
		return noticeDao.getListWithPaging(criteria, key);
	}
	
	@Override
	public int countNoticeList(String subject) {
		
		return noticeDao.countNoticeList(subject);
	}
	
	@Override
	public List<NoticeCommentVO> getCommentNoticeList(int nseq){
		 return noticeDao.getCommentNoticeList(nseq);
	}
	
	@Override
	public void saveNoticeComment(NoticeCommentVO commentVO) {
		noticeDao.saveNoticeComment(commentVO);
	}
	
	@Override
	public void updateNoticeComment(NoticeCommentVO commentVO) {
		noticeDao.updateNoticeComment(commentVO);
	}
	
	@Override
	public void deleteNoticeComment(int commentSeq) {
		noticeDao.deleteNoticeComment(commentSeq);
	}
	
}
