package project.dto;

import java.sql.Date;

public class MemberShipDTO {

	private String m_id;
	private String m_pw;
	private String m_name;
	private Date m_birth;
	private String phone;
	
	public MemberShipDTO() { super(); }

	public MemberShipDTO(String m_id, String m_pw, String m_name, Date m_birth, String phone) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_birth = m_birth;
		this.phone = phone;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public Date getM_birth() {
		return m_birth;
	}

	public void setM_birth(Date m_birth) {
		this.m_birth = m_birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberShipDTO [m_id=").append(m_id).append(", m_pw=").append(m_pw).append(", m_name=")
				.append(m_name).append(", m_birth=").append(m_birth).append(", phone=").append(phone).append("]");
		return builder.toString();
	}


	

	
	
	
}
