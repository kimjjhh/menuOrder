package project.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.dto.MemberShipDTO;
import project.dto.OrderDTO;
import project.dto.MenuDTO;
import project.util.DBUtilA;
import project.view.MemberView;
import project.view.OrderView;
import project.dto.OrderJoinVO;

public class OrderDAO {
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;
	
	//1.ȸ������
	static final String SQL_RIGISTER = "INSERT INTO MEMBERSHIP values(?,?,?,?,?)";
	
	//2.ȸ����������
	static final String SQL_MODIFY = "update MEMBERSHIP set "
							       + " m_pw = ?,"
							       + " phone = ?"
							       + " where m_id = ?";
	//3.ȸ��Ż��
	static final String SQL_WITHDRAW = "delete FROM MEMBERSHIP where m_id = ?";
	
	//3.1 ȸ��Ż��� �ֹ������� �����Ǿ���Ѵ�
	static final String SQL_ORDER_CANCELL = "DELETE FROM ORDER_DETAILS WHERE M_ID = ?";
	
	//4.�α���
	static final String SQL_LOGIN = "select * from membership where m_id = ? and m_pw = ?";
	
	//5.��ü�޴��˻�
	static final String SQL_MENUALL = "SELECT * FROM MENU";
	
	//5.1 �޴��̸� �˻�
	static final String SQL_MENUNAME = "select * from menu where menu_name like ?";
	
	//6.�ֹ��ϱ�
	static final String SQL_ORDER = "insert into ORDER_DETAILS values(seq_orderno.nextval,?,?,sysdate,sysdate+10/(24*60),'�ֹ�',?)";
	
	//6.1 �����ֹ�
	static final String SQL_ORDER_RSV = "insert into ORDER_DETAILS values(seq_orderno.nextval,?,?,sysdate,sysdate+30/(24*60),'����',?)";
	
	//6.2 �Ⱦ�
	static final String SQL_PICKUP = "update ORDER_DETAILS set ORDER_STATUS = '�Ⱦ�', pick_date = sysdate where ORDER_NO = ? and pick_date>=sysdate" ;
	
	//6.3 �ֹ��� �ֹ���ȣ ��ȯ
//	static final String SQL_ORDER_NO = "SELECT * FROM ORDER_DETAILS WHERE ORDER_NO = ? ";
	
	//7.��ü �ֹ� ��ȸ	
	static final String SQL_ORDERALL = "SELECT od.ORDER_NO,m.M_NAME,m2.MENU_NAME,m2.PRICE,od.ORDER_DATE ,od.PICK_DATE,to_char(od.PICK_DATE, 'yy-mm-dd hh24:mi') pick_date_str ,od.ORDER_STATUS ,od.REQUEST "
										+ "FROM ORDER_DETAILS od JOIN MEMBERSHIP m \r\n"
										+ "ON od.M_ID = m.M_ID \r\n"
										+ "JOIN MENU m2 ON od.MENU_CODE = m2.MENU_CODE"
										+ " order by od.ORDER_NO";
	//7.1 �ֹ���¥��ȸ
	static final String SQL_ORDERDATE = "SELECT od.ORDER_NO,m.M_NAME,m2.MENU_NAME,m2.PRICE,od.ORDER_DATE ,od.PICK_DATE, to_char(od.PICK_DATE, 'yy-mm-dd hh24:mi') pick_date_str ,od.ORDER_STATUS ,od.REQUEST "
										+ " FROM ORDER_DETAILS od JOIN MEMBERSHIP m "
										+ " ON ( od.M_ID = m.M_ID) "
										+ " JOIN MENU m2 ON  (od.MENU_CODE = m2.MENU_CODE) "
										+ " WHERE od.ORDER_DATE BETWEEN ? AND ? "
										+ " order by od.ORDER_NO";
	//7.2 �����ֹ���ȸ
	static final String SQL_ORDERRSV = "SELECT od.ORDER_NO,m.M_NAME,m2.MENU_NAME,m2.PRICE,od.ORDER_DATE ,od.PICK_DATE,to_char(od.PICK_DATE, 'yy-mm-dd hh24:mi') pick_date_str ,od.ORDER_STATUS ,od.REQUEST"
										+ " FROM ORDER_DETAILS od JOIN MEMBERSHIP m"
										+ " ON od.M_ID = m.M_ID"
										+ " JOIN MENU m2 ON od.MENU_CODE = m2.MENU_CODE"
										+ " WHERE od.ORDER_STATUS = '����' "
										+ " order by od.ORDER_NO";
	
	//8.�ֹ����
	static final String SQL_CANCELL = "DELETE FROM ORDER_DETAILS WHERE PICK_DATE > SYSDATE AND ORDER_NO = ?";

	
	
	//1.ȸ������ insert
	public int  register(MemberShipDTO member) {
		result = 0;
		conn = DBUtilA.getConnection();
		
		try {
			pst = conn.prepareStatement(SQL_RIGISTER);
			pst.setString(1, member.getM_id()); 
			pst.setString(2, member.getM_pw()); 
			pst.setString(3, member.getM_name()); 
			pst.setDate(5, member.getM_birth()); 
			pst.setString(4, member.getPhone()); 
			result = pst.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtilA.dbClose(rs, pst, conn);
		}
		return result;

		
	}
	
	//2. ȸ������ ���� update
	public int modify(MemberShipDTO member) {
		result = 0;
		conn = DBUtilA.getConnection();
		
		try {
			pst = conn.prepareStatement(SQL_MODIFY);
			pst.setString(3, member.getM_id()); 
			pst.setString(1, member.getM_pw()); 
			pst.setString(2, member.getPhone()); 
			result = pst.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtilA.dbClose(rs, pst, conn);
		}
		return result;
	}
	
	//3. ȸ��Ż�� delete
	public int withdraw(String m_id) {
		result = 0;
		conn = DBUtilA.getConnection();
		
		try {
			pst = conn.prepareStatement(SQL_WITHDRAW);
			pst.setString(1, m_id); 
			result = pst.executeUpdate(); 
		} catch (SQLException e) {
			
		} finally {
			DBUtilA.dbClose(rs, pst, conn);
		}
		return result;
		
	}
	
	//3.1 ȸ��Ż��� �ֹ��޴��� �����Ǿ�� �Ѵ�
//	public int order_cancell(String m_id) {
//		result = 0;
//		conn = DBUtilA.getConnection();
//		
//		try {
//			pst = conn.prepareStatement(SQL_ORDER_CANCELL);
//			pst.setString(1, m_id); 
//			result = pst.executeUpdate(); 
//		} catch (SQLException e) {
//			MemberView.print("ȸ��Ż�����");
//		} finally {
//			DBUtilA.dbClose(rs, pst, conn);
//		}
//		return result;
//		
//	}
	
	
	
	
	
	//4.�α��� select
	public MemberShipDTO login(String m_id, String m_pw) {
		MemberShipDTO member = null;
		conn = DBUtilA.getConnection();
		
		try {
			pst = conn.prepareStatement(SQL_LOGIN);
			pst.setString(1, m_id); 
			pst.setString(2, m_pw); 
			rs = pst.executeQuery(); 
			while(rs.next()) {
				member = members(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtilA.dbClose(rs, pst, conn);
		}
		return member;

		
	}
	
	private MemberShipDTO members(ResultSet rs2) throws SQLException {
		MemberShipDTO member = new MemberShipDTO();
		member.setM_id(rs.getString("M_id"));
		member.setM_pw(rs.getString("M_pw"));
		member.setM_name(rs.getString("M_name"));
		member.setM_birth(rs.getDate("M_birth"));
		member.setPhone(rs.getString("Phone"));
		return member;
	}

	//5. �޴� ��ü �˻�(��ȸ��,ȸ��)
	public List<MenuDTO> menuAll() {
		List<MenuDTO> mList = new ArrayList<>();
		conn = DBUtilA.getConnection();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL_MENUALL); 
			while(rs.next()) {
				mList.add(makeMenu(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtilA.dbClose(rs, st, conn);
		}
		return mList;

		
	}

	private MenuDTO makeMenu(ResultSet rs2) throws SQLException {
		MenuDTO menu = new MenuDTO();
		menu.setMenu_code(rs2.getInt("Menu_code"));
		menu.setMenu_name(rs2.getString("Menu_name"));
		menu.setCategory(rs2.getString("Category"));
		menu.setMenu_size(rs2.getString("Menu_size"));
		menu.setHot_ice_condition(rs2.getString("Hot_ice_condition"));
		menu.setPrice(rs2.getInt("Price"));
		return menu;
	}
	

	//5.1 �޴��̸� �˻�
	public List<MenuDTO> menuName(String menu_name) {
		List<MenuDTO> mList = new ArrayList<>();
		MenuDTO menu = null;
		conn = DBUtilA.getConnection();
		
		try {
			pst = conn.prepareStatement(SQL_MENUNAME);
			pst.setString(1, "%"+menu_name+"%"); 
			rs = pst.executeQuery(); 
			while(rs.next()) {
				mList.add(makeMenu(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtilA.dbClose(rs, pst, conn);
		}
		return mList;
		
		}
	
	//6.�ֹ��ϱ�
	public int order(OrderDTO order) {
		result = 0;
		conn = DBUtilA.getConnection();
		
		try {
			pst = conn.prepareStatement(SQL_ORDER);
			pst.setInt(1, order.getMenu_code()); 
			pst.setString(2, order.getM_id()); 
			pst.setString(3, order.getRequest()); 
			result = pst.executeUpdate(); 
		} catch (SQLException e) {
			//e.printStackTrace(); �̰� �����޼��� ������ִ°�
			OrderView.print("�ֹ� ������ �ٽ� Ȯ�����ּ���");
		} finally {
			DBUtilA.dbClose(rs, pst, conn);
		}
		return result;

		
	}

 
	
	//6.1 �����ֹ�
	public int order_rsv(OrderDTO order) {
		result = 0;
		conn = DBUtilA.getConnection();
		
		try {
			pst = conn.prepareStatement(SQL_ORDER_RSV);
			pst.setInt(1, order.getMenu_code()); 
			pst.setString(2, order.getM_id()); 
	//		pst.setDate(3, order.getPick_date()); 
			pst.setString(3, order.getRequest()); 
			result = pst.executeUpdate(); 
		} catch (SQLException e) {
		//	e.printStackTrace();
			OrderView.print("�ֹ� ������ �ٽ� Ȯ�����ּ���");
		} finally {
			DBUtilA.dbClose(rs, pst, conn);
		}
		return result;

		
	}
	
	//6.2 �Ⱦ�
	public int pickUp(OrderDTO order) {
		result = 0;
		conn = DBUtilA.getConnection();
		
		try {
			pst = conn.prepareStatement(SQL_PICKUP);
			pst.setInt(1, order.getOreder_no()); 
			result = pst.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtilA.dbClose(rs, pst, conn);
		}
		return result;
	}
	
	//6.3 �ֹ��� �ֹ���ȣ ��ȯ
//	public OrderVO orderNo(int ono) {
//		OrderVO order = null;
//		conn = DBUtilA.getConnection();
//		try {
//			pst = conn.prepareStatement(SQL_ORDER_NO);
//			pst.setInt(1, ono); 
//			rs = pst.executeQuery(); 
//			if(rs.next()) {
//				order = makeOrder2(rs);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.dbClose(rs, pst, conn);
//		}
//		return board;
//	}
	

	
	
	//7.��ü �ֹ� ��ȸ
	public List<OrderJoinVO> orderAll() {
		List<OrderJoinVO> oList = new ArrayList<>();
		conn = DBUtilA.getConnection();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL_ORDERALL); 
			while(rs.next()) {
				oList.add(makeOrder2(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtilA.dbClose(rs, st, conn);
		}
		return oList;		
	}	
	
	private OrderJoinVO makeOrder2(ResultSet rs2) throws SQLException {
		OrderJoinVO order = new OrderJoinVO();
		order.setOrder_no(rs2.getInt("Order_no"));
		order.setM_name(rs2.getString("M_name"));
		order.setMenu_name(rs2.getString("Menu_name"));
		order.setPrice(rs2.getInt("Price"));
		order.setOrder_date(rs2.getDate("Order_date"));
		order.setPick_date(rs2.getDate("Pick_date"));
		order.setOrder_status(rs2.getString("Order_status"));
		order.setRequest(rs2.getString("Request"));		
		order.setPick_date_str(rs2.getString("pick_date_str"));
 
		return order;
	}

	private OrderJoinVO makeOrder(ResultSet rs2) throws SQLException {
		OrderJoinVO order = new OrderJoinVO();
		order.setOrder_no(rs2.getInt("Order_no"));
		order.setM_name(rs2.getString("M_name"));
		order.setMenu_name(rs2.getString("Menu_name"));
		order.setPrice(rs2.getInt("Price"));
		order.setOrder_date(rs2.getDate("Order_date"));
		order.setPick_date(rs2.getDate("Pick_date"));
		order.setOrder_status(rs2.getString("Order_status"));
		order.setRequest(rs2.getString("Request"));		
	 
 
		return order;
	}
	
	
	//7.1 �ֹ���¥��ȸ
	public List<OrderJoinVO> orderDate(Date date1, Date date2) {
		List<OrderJoinVO> oList = new ArrayList<>();
		OrderJoinVO order = null;
		conn = DBUtilA.getConnection();
		try {
			pst = conn.prepareStatement(SQL_ORDERDATE);
			pst.setDate(1, date1); 
			pst.setDate(2, date2); 
			rs = pst.executeQuery(); 
			while(rs.next()) {
				oList.add(makeOrder2(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtilA.dbClose(rs, pst, conn);
		}
		return oList;
	}
	
	//7.2 �����ֹ���ȸ
	public List<OrderJoinVO> orderRsv() {
		List<OrderJoinVO> oList = new ArrayList<>();
		conn = DBUtilA.getConnection();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL_ORDERRSV); 
			while(rs.next()) {
				oList.add(makeOrder2(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtilA.dbClose(rs, st, conn);
		}
		return oList;	
	}
	
	//8.�ֹ����
	public int cancell(int order_no) {
		result = 0;
		conn = DBUtilA.getConnection();
		
		try {
			pst = conn.prepareStatement(SQL_CANCELL);
			pst.setInt(1, order_no); 
			result = pst.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtilA.dbClose(rs, pst, conn);
		}
		return result;
		
	}

}
