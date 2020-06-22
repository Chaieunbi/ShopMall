package com.green.biz.order.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.order.CartVO;

@Repository
public class CartDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	//��ٱ��Ͽ� ���
	public void insertCart(CartVO vo) {
		System.out.println("mybatis�� insertCart() ���ó��");
		
		mybatis.insert("CartDAO.insertCart", vo);
	}
	
	//��ٱ��� ���
	public List<CartVO> listCart(String userId){
		System.out.println("mybatis�� listCart() ���ó��");
		
		return mybatis.selectList("CartDAO.listCart", userId);
	}
	
	//��ٱ��� ���
	public void deleteCart(int cseq) {
		System.out.println("mybatis�� deleteCart() ���ó��");
		mybatis.delete("CartDAO.deleteCart", cseq);
	}
	
	//��ٱ��� ���� - �ֹ�ó���� ��쿡 ���
	public void updateCart(int cseq) {
		System.out.println("mybatis�� updateCart() ���ó��");
		mybatis.update("CartDAO.updateCart", cseq);
	}
}