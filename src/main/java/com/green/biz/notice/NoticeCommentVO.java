package com.green.biz.notice;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeCommentVO{
	private int comment_seq;
	private int nseq;
	private String content;
	private String writer;
	private Date regDate;
	private Date modifyDate;
}