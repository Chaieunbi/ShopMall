package com.green.biz.review;

import java.util.Date;

public class ReviewVO {

	private int rseq;	//번호
	private String id;	//글쓴이
	private String image;	//이미지
	private String subject;		//제품명
	private String content;		//내용
	private Date indate;
	
	public int getRseq() {
		return rseq;
	}
	public void setRseq(int rseq) {
		this.rseq = rseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "ReviewVO [rseq=" + rseq + ", id=" + id + ", image=" + image + ", subject=" + subject + ", content="
				+ content + ", indate=" + indate + "]";
	}
	
}
