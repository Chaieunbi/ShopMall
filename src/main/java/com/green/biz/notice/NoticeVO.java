package com.green.biz.notice;

import java.util.Date;

public class NoticeVO {

	private int nseq;
	private String id;
	private String subject;
	private String content;
	private String image;
	private Date indate;
	
	public int getNseq() {
		return nseq;
	}
	public void setNseq(int nseq) {
		this.nseq = nseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	
	@Override
	public String toString() {
		return "NoticeVO [nseq=" + nseq + ", id=" + id + ", subject=" + subject + ", content=" + content + ", image="
				+ image + ", indate=" + indate + "]";
	}
	
}
