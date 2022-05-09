package project.model;

import java.sql.Date;
import java.util.List;

import project.dto.MemberShipDTO;
import project.dto.MenuDTO;
import project.dto.OrderDTO;
import project.dto.OrderJoinVO;

public class OrderService {
	
	private OrderDAO oDAO = new OrderDAO();
	
	
	
	//1. ȸ������
	public int register(MemberShipDTO member) {
		return oDAO.register(member);
	}
	
	//2. ȸ���������� = ���ϴ� ���·� ���� �ʾ���.. ����Բ� �����
		public int modify(MemberShipDTO member) {
			return oDAO.modify(member);		
		}
		
	//3. ȸ��Ż��
		public int withdraw(String m_id) {
			return oDAO.withdraw(m_id);
			
		}
		
//	//3.1 ȸ��Ż��� �ֹ��޴��� �����Ǿ�� �Ѵ�
//		public int order_cancell(String m_id) {
//			return oDAO.order_cancell(m_id);
//		}
	
	//4. �α���	
	public MemberShipDTO login(String m_id, String m_pw) {
		return oDAO.login(m_id, m_pw);
	}
	
//	//5. �α׾ƿ�
//	public void logout(){
//		System.out.println("�α׾ƿ�");
//		oDAO = null;
//	}
	
	//5. �޴� ��ü �˻�(��ȸ��,ȸ��)
	public List<MenuDTO> menuAll() {
		return oDAO.menuAll();
	}
	
	//5.1 �޴� �̸� �˻�
	public List<MenuDTO> menuName(String menu_name) {
		return oDAO.menuName(menu_name);
	}
	
	//6.�ֹ��ϱ�
	public int order(OrderDTO order) {
		return oDAO.order(order);
	}
	
	//6.1 �����ֹ��ϱ�
	public int order_rsv(OrderDTO order) {
		return oDAO.order_rsv(order);
	}
	
	//6.2 �Ⱦ�
	public int pickUp(OrderDTO order) {
		return oDAO.pickUp(order);
	}
	
	
	//7.��ü�ֹ���ȸ
	public List<OrderJoinVO> orderAll() {
		return oDAO.orderAll();
	}
	
	//7.1 �ֹ���¥����ȸ
	public List<OrderJoinVO> orderDate(Date date1, Date date2) {
		return oDAO.orderDate(date1, date2);
	}
	
	//7.2 �����ֹ���ȸ
	public List<OrderJoinVO> orderRsv() {
		return oDAO.orderRsv();
	}
	
	//8.�ֹ����
	public int cancell(int order_no) {
		return oDAO.cancell(order_no);
	}
	
}
