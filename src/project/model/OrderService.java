package project.model;

import java.sql.Date;
import java.util.List;

import project.dto.MemberShipDTO;
import project.dto.MenuDTO;
import project.dto.OrderDTO;
import project.dto.OrderJoinVO;

public class OrderService {
	
	private OrderDAO oDAO = new OrderDAO();
	
	
	
	//1. 회원가입
	public int register(MemberShipDTO member) {
		return oDAO.register(member);
	}
	
	//2. 회원정보수정 = 원하는 형태로 되지 않았음.. 강사님께 물어보기
		public int modify(MemberShipDTO member) {
			return oDAO.modify(member);		
		}
		
	//3. 회원탈퇴
		public int withdraw(String m_id) {
			return oDAO.withdraw(m_id);
			
		}
		
//	//3.1 회원탈퇴시 주문메뉴도 삭제되어야 한다
//		public int order_cancell(String m_id) {
//			return oDAO.order_cancell(m_id);
//		}
	
	//4. 로그인	
	public MemberShipDTO login(String m_id, String m_pw) {
		return oDAO.login(m_id, m_pw);
	}
	
//	//5. 로그아웃
//	public void logout(){
//		System.out.println("로그아웃");
//		oDAO = null;
//	}
	
	//5. 메뉴 전체 검색(비회원,회원)
	public List<MenuDTO> menuAll() {
		return oDAO.menuAll();
	}
	
	//5.1 메뉴 이름 검색
	public List<MenuDTO> menuName(String menu_name) {
		return oDAO.menuName(menu_name);
	}
	
	//6.주문하기
	public int order(OrderDTO order) {
		return oDAO.order(order);
	}
	
	//6.1 예약주문하기
	public int order_rsv(OrderDTO order) {
		return oDAO.order_rsv(order);
	}
	
	//6.2 픽업
	public int pickUp(OrderDTO order) {
		return oDAO.pickUp(order);
	}
	
	
	//7.전체주문조회
	public List<OrderJoinVO> orderAll() {
		return oDAO.orderAll();
	}
	
	//7.1 주문날짜로조회
	public List<OrderJoinVO> orderDate(Date date1, Date date2) {
		return oDAO.orderDate(date1, date2);
	}
	
	//7.2 예약주문조회
	public List<OrderJoinVO> orderRsv() {
		return oDAO.orderRsv();
	}
	
	//8.주문취소
	public int cancell(int order_no) {
		return oDAO.cancell(order_no);
	}
	
}
