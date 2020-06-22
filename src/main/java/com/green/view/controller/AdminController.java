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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.green.biz.admin.WorkerService;
import com.green.biz.admin.WorkerVO;
import com.green.biz.member.MemberService;
import com.green.biz.member.MemberVO;
import com.green.biz.notice.NoticeService;
import com.green.biz.notice.NoticeVO;
import com.green.biz.order.OrderService;
import com.green.biz.order.OrderVO;
import com.green.biz.product.ProductService;
import com.green.biz.product.ProductVO;
import com.green.biz.product.SalesQuantity;
import com.green.biz.qna.QnaService;
import com.green.biz.qna.QnaVO;
import com.green.biz.utils.Criteria;
import com.green.biz.utils.PageMaker;

@Controller
@SessionAttributes("loginWorker")
public class AdminController {

	@Autowired
	WorkerService workerService;

	@Autowired
	ProductService productService;

	@Autowired
	OrderService orderService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	QnaService qnaService;
	
	@Autowired
	NoticeService noticeService;
	
	// ������ �α��� ȭ�� ������ �̵�
	@RequestMapping(value = "admin_login_form") // RequestMapping�� value ���� url�̴�
	public String adminLoginView() {

		return "admin/main";
	}

	/*
	 * ������ �α���
	 */
	@RequestMapping(value = "admin_login")
	public String adminLogin(@RequestParam(value = "workerId") String id, // RequestParma�� VO�� Į����� jsp�� �̸�(name)�� �ٸ� ���
																			// ����Ѵ�.
			@RequestParam(value = "workerPwd") String pwd, Model model) {

		System.out.println("admin�α���");
		int result = workerService.workerCheck(id, pwd);

		if (result == 1) {

			// ������ ������ db���� ��ȸ
			WorkerVO loginWorker = workerService.getEmployee(id);

			model.addAttribute("loginWorker", loginWorker);

			return "redirect:admin_product_list"; // redirect�� �ϸ� �����ͱ��� ���� �Ѱ�����
		} else if (result == 0) {
			model.addAttribute("message", "��й�ȣ�� Ȯ���ϼ���");
			return "admin/main";
		} else {
			model.addAttribute("message", "���̵� Ȯ���ϼ���");
			return "admin/main";
		}
	}

	@RequestMapping(value = "admin_logout")
	public String adminLogout(SessionStatus status) {

		status.setComplete();

		return "admin/main";
	}

	@RequestMapping(value = "admin_product_list")
	public String listProduct(@RequestParam(value="key", defaultValue="") String key, 
			Criteria criteria, Model model, HttpSession session) {

		WorkerVO loginWorker = (WorkerVO) session.getAttribute("loginWorker");

		if (loginWorker == null) {
			return "admin/main";
		} else {
			System.out.println("������ ����:"+criteria);
			
			
			
			// ��ȸ
			//List<ProductVO> productList = productService.listProduct(""); // "" : ���ڿ�(Ư���ϰ� �����Ұ� ����)
			List<ProductVO> productList = productService.getListWithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);
			
			// �� ��� ���� DB���� ��ȸ
			int totalCount = productService.countProductList(key);
			pageMaker.setTotalCount(totalCount);
			System.out.println("����¡ ����:"+pageMaker);
			
			model.addAttribute("productList", productList); // "productList"�� productList.jsp���� ${productList}��. ������ productList�� ������ ������ ������
			model.addAttribute("productListSize", productList.size());					
			model.addAttribute("pageMaker", pageMaker);
			
			return "admin/product/productList";
		}
	}

	@RequestMapping(value = "admin_product_write_form")
	public String adminProductWriteView(Model model) {
		String kindList[] = { "����", "����", "�Ƿ�"};

		model.addAttribute("kindList", kindList);

		return "admin/product/productWrite";
	}
	

	@RequestMapping(value = "admin_product_write")
	public String adminProductWrite(@RequestParam(value = "product_image") MultipartFile uploadFile, ProductVO pVo,
			Model model, HttpSession session) {

		// �α��� üũ
		WorkerVO loginWorker = (WorkerVO) session.getAttribute("loginWorker");

		if (loginWorker == null) {
			return "admin/main";
		} else {
			String fileName = "";

			if (!uploadFile.isEmpty()) { // ��ǰ �̹����� ���ε��
				String root_path = session.getServletContext().getRealPath("WEB-INF/resources/product_images/"); // session.getServletContext()��
																													// ������Ʈ
																													// ����
																													// -
																													// webapp����

				System.out.println("Root ���=" + root_path);

				// ���ε�� ���ϸ��� ���´�.
				fileName = uploadFile.getOriginalFilename();

				try {
					File file = new File(root_path + fileName);
					uploadFile.transferTo(file);
				} catch (IllegalStateException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			pVo.setImage(fileName); // image �÷��� �̹��� ���ϸ� ����
			System.out.println(pVo);

			productService.insertProduct(pVo);

			return "redirect:admin_product_list";
		}
	}

	@RequestMapping(value = "admin_product_detail")
	public String adminProductDetail(ProductVO vo, Criteria criteria, Model model) { // ProductVO vo �ȿ� pseq�� ����

		String kindList[] = { "����", "����", "�Ƿ�"};

		ProductVO product = productService.getProduct(vo);

		model.addAttribute("productVO", product); // productDetail.jsp���� ����ϴ� �̸�

		int index = Integer.parseInt(product.getKind());
		model.addAttribute("kind", kindList[index]);
		model.addAttribute("criteria", criteria);
		return "admin/product/productDetail";

	}

	@RequestMapping(value = "admin_product_update_form")
	public String adminProductUpdateView(ProductVO vo, Model model) {

		String kindList[] = { "����", "����", "�Ƿ�"};

		ProductVO product = productService.getProduct(vo);

		model.addAttribute("productVO", product); // productDetail.jsp���� ����ϴ� �̸�

		model.addAttribute("kindList", kindList);

		return "admin/product/productUpdate";
	}

	@RequestMapping(value="admin_product_update")
	public String adminProductUpdate(@RequestParam(value="product_image") MultipartFile uploadFile, ProductVO vo, Model model, HttpSession session) {
		//�α��� üũ
			WorkerVO loginWorker = (WorkerVO)session.getAttribute("loginWorker");
				
				if(loginWorker == null) {
					return "admin/main";
				}else {
					String fileName = "";
					
					if(!uploadFile.isEmpty()) { // ��ǰ �̹����� ���ε��
						String root_path = session.getServletContext().getRealPath("WEB-INF/resources/product_images/");  //session.getServletContext()�� ������Ʈ ���� - webapp����
						
						System.out.println("Root ���=" + root_path);
						
						//���ε�� ���ϸ��� ���´�.
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
					if(vo.getBestyn() == null) {
						vo.setBestyn("n");
					}
					if(vo.getUseyn() == null) {
						vo.setUseyn("n");
					}
					
					System.out.println("������Ʈ ����:" +vo);
					productService.updateProduct(vo);
					
					return "redirect:admin_product_detail?pseq="+vo.getPseq();
				}
	}

	/*
	 * ��ǰ�� �Ǹ� ����
	 */
	@RequestMapping(value="admin_sales_record_form")
	public String adminProductSalesChart(Model model) {
		
		return "admin/order/salesRecords";
	}

	
	@RequestMapping(value="sales_record_chart", 
			produces="application/json; charset=utf-8")
@ResponseBody
public List<SalesQuantity> sales_record_chart() {
	
	List<SalesQuantity> listSales = productService.getProductSales();
	
	System.out.println("�Ǹ� ����>>>>>>");
	System.out.println("   ��ǰ��      ����");
	System.out.println("--------------");
	for(SalesQuantity item : listSales) {
		System.out.printf("%10s%3d\n", item.getPname(), item.getQuantity());
	}
	System.out.println("==============");
	return listSales;
}
	
	/*
	 * �ֹ� ��� ǥ��
	 */
	@RequestMapping(value="admin_order_list")
	public String adminOrderList(OrderVO vo, Model model, HttpSession session){
		
		List<OrderVO> orderList =orderService.listOrder(""); //�Է°� ������ �� ���ڿ��� ��
		
		model.addAttribute("orderList", orderList);
		
		return "admin/order/orderList";
	}
	
	/*
	 * �ֹ� �Ϸ� ó�� (�Ա� Ȯ��)
	 */
	@RequestMapping(value="admin_order_save")
	public String adminOrderSave(@RequestParam(value="result") int[] odseq) { //üũ�ڽ� name
		
		//ȭ�鿡�� ������ �ֹ� ó�� üũ �׸��� odseq�� �迭�� �����Ѵ�.
		for(int i=0; i<odseq.length; i++) {
			orderService.updateOrderResult(odseq[i]);
		}
		
		//�ٽ� �ֹ�����Ʈ �θ�
		return "redirect:admin_order_list";
	}
	
	/*
	 * ȸ�� ��� ǥ��
	 */
	@RequestMapping(value="admin_member_list")
	public String adminMemberList(@RequestParam(value="key", defaultValue="") String name, Model model) {
		
		System.out.println("�˻�Ű="+name);
		List<MemberVO> listMember = memberService.listMember(name);
		
		//items="${memberList}"�̸����� ���� ==> memberList.jsp
		model.addAttribute("memberList", listMember); //�Ű����� �κп� �� �߰�
		
		return "admin/member/memberList";
		
	}
	
	//qna
	
	/*
	 * �Խ��� ��� ���
	 */
	@RequestMapping(value="admin_qna_list")
	public String adminQnaList(Model model){
		
		List<QnaVO> qnaList = qnaService.listAllQna();
		
		model.addAttribute("qnaList", qnaList);
		
		return "admin/qna/qnaList";
	}
	
	
	/*
	 * �Խñ� �� ����
	 */
	@RequestMapping(value="admin_qna_detail")
	public String adminQnaDetail(QnaVO vo, Model model) {
		
		//QnaVO ��ü�� �޾ƿ��� �� �ȿ��� qseq ������
		QnaVO qnaVO = qnaService.getQna(vo.getQseq());
		
		model.addAttribute("qnaVO", qnaVO);
		
		return "admin/qna/qnaDetail";
		
	}
	
	/*
	 * �亯 ó��
	 */
	@RequestMapping(value="admin_qna_repsave")
	public String adminQnaRepsave(QnaVO vo, Model model) {
		
		qnaService.updateQna(vo);
		
		return "redirect:admin_qna_list";
	}
	
	//notice
	
	/*�������� �󼼺���*/
	@RequestMapping(value="admin_notice_detail")
	public String adminNoticeDetail(NoticeVO vo, Model model,HttpSession session) {
		
		WorkerVO loginWorker = (WorkerVO)session.getAttribute("loginWorker");
		
		vo.setId(loginWorker.getId());
		NoticeVO noticeVO = noticeService.getNotice(vo);
		
		model.addAttribute("noticeVO", noticeVO);
		
		return "admin/notice/noticeDetail";
	}
	
	/*�������� ��� ���*/
	@RequestMapping(value="admin_notice_list")
	public String adminNoticeList(NoticeVO vo, Model model, HttpSession session) {
		
		WorkerVO loginWorker = (WorkerVO)session.getAttribute("loginWorker");
		
		List<NoticeVO> noticeList = noticeService.listAllNotice(loginWorker.getId());
		
		model.addAttribute("noticeList",noticeList);
		
		return "admin/notice/noticeList";
		
	}
	
	@RequestMapping(value="admin_notice_write_form")
	public String adminNoticeWriteView(NoticeVO noticeVO,Model model,HttpSession session) {
		
		WorkerVO loginWorker = (WorkerVO)session.getAttribute("loginWorker");
		
		noticeVO.setId(loginWorker.getId());
		return "admin/notice/noticeWrite";
		
	}
	
	/*�������� �۾���*/
	@RequestMapping(value="admin_notice_write")
	public String adminNoticeWrite(@RequestParam(value="notice_image")MultipartFile uploadFile, NoticeVO nVo, Model model, HttpSession session) {
		
		WorkerVO loginWorker = (WorkerVO)session.getAttribute("loginWorker");
		
		
		if(loginWorker == null) {
			return "admin/main";
		}else {
			nVo.setId(loginWorker.getId());
			String fileName = "";
			
			if (!uploadFile.isEmpty()) { // ��ǰ �̹����� ���ε��
				String root_path = session.getServletContext().getRealPath("WEB-INF/resources/product_images/"); // session.getServletContext()��
				
				System.out.println("Root ���=" + root_path);

				// ���ε�� ���ϸ��� ���´�.
				fileName = uploadFile.getOriginalFilename();

				try {
					File file = new File(root_path + fileName);
					uploadFile.transferTo(file);
				} catch (IllegalStateException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			nVo.setImage(fileName);
			System.out.println(nVo);
			
			noticeService.insertNotice(nVo);
			
			return "redirect:admin_notice_list";
		}
	}
	
	@RequestMapping(value = "admin_notice_update_form")
	public String adminNoticeUpdateView(NoticeVO noticeVO,Model model) {
		
		NoticeVO vo = noticeService.getNotice(noticeVO);
		
		model.addAttribute("noticeVO", vo);
		
		return "admin/notice/noticeUpdate";
	}
	
	/*�������� ����*/
	@RequestMapping(value="admin_notice_update")
	public String adminNoticeUpdate(@RequestParam(value="notice_image")MultipartFile uploadFile, NoticeVO vo, Model model, HttpSession session) {
		
		WorkerVO loginWorker = (WorkerVO)session.getAttribute("loginWorker");
		
		if(loginWorker == null ) {
			return "admin/main";
		} else {
			String fileName = "";
			
			if(!uploadFile.isEmpty()) {
				String root_path = session.getServletContext().getRealPath("WEB-INF/resources/product_images/");
				
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
			System.out.println("������Ʈ����:"+vo);
			noticeService.updateNotice(vo);
			
			return "redirect:admin_notice_list?nseq"+vo.getNseq();
		}
	}
}
	


