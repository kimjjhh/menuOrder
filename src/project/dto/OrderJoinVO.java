package project.dto;

import java.sql.Date;

import project.util.DateUtilA;

public class OrderJoinVO {
	
	private int order_no;
	private String m_name;
	private String menu_name;
	private int price;
	private Date order_date;
	private Date pick_date;
	private String pick_date_str;
	private String order_status;
	private String request;
	public OrderJoinVO() {
		super();
	}
	public OrderJoinVO(int order_no, String menu_name, int price, String m_name, Date order_date, Date pick_date,
			String order_status, String request) {
		super();
		this.order_no = order_no;
		this.menu_name = menu_name;
		this.price = price;
		this.m_name = m_name;
		this.order_date = order_date;
		this.pick_date = pick_date;
		this.order_status = order_status;
		this.request = request;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public Date getPick_date() {
		return pick_date;
	}
	public void setPick_date(Date pick_date) {
		this.pick_date = pick_date;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	
	
	public String getPick_date_str() {
		return pick_date_str;
	}
	public void setPick_date_str(String pick_date_str) {
		this.pick_date_str = pick_date_str;
	}
	@Override
	public String toString() {
		return "주문번호 : " + order_no + " 회원이름 : " + m_name + " 메뉴이름 : " + menu_name + " 가격 : " + price
				+ " 주문날짜 : " + order_date + " 픽업날짜 : " + pick_date_str + " 주문상태 : " + order_status
				+ " 요청사항 : " + request;
	}

	
	

}
