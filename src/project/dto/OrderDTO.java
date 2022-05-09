package project.dto;

import java.sql.Date;

public class OrderDTO {
	private int oreder_no;
	private int menu_code;
	private String m_id;
	private Date order_date;
	private Date pick_date;
	private String order_status;
	private String request;
	
	public OrderDTO() {
		super();
	}

	public OrderDTO(int oreder_no, int menu_code, String m_id, Date order_date, Date pick_date,
			String order_status, String request) {
		super();
		this.oreder_no = oreder_no;
		this.menu_code = menu_code;
		this.m_id = m_id;
		this.order_date = order_date;
		this.pick_date = pick_date;
		this.order_status = order_status;
		this.request = request;
	}

	public int getOreder_no() {
		return oreder_no;
	}

	public void setOreder_no(int oreder_no) {
		this.oreder_no = oreder_no;
	}

	public int getMenu_code() {
		return menu_code;
	}

	public void setMenu_code(int menu_code) {
		this.menu_code = menu_code;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDetailsDTO [oreder_no=").append(oreder_no).append(", menu_code=").append(menu_code)
				.append(", nickname=").append(m_id).append(", order_date=").append(order_date)
				.append(", pick_name=").append(pick_date).append(", order_status=").append(order_status)
				.append(", request=").append(request).append("]");
		return builder.toString();
	}
	
	
	
}
