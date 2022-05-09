package project.dto;

public class MenuDTO {

	private int menu_code;
	private String menu_name;
	private String category;
	private String menu_size;
	private String hot_ice_condition;
	private int price;
	
	public MenuDTO() { super(); }
	
	public MenuDTO(int menu_code, String menu_name, String category, String menu_size, String hot_ice_condition,
			int price) {
		super();
		this.menu_code = menu_code;
		this.menu_name = menu_name;
		this.category = category;
		this.menu_size = menu_size;
		this.hot_ice_condition = hot_ice_condition;
		this.price = price;
	}

	public int getMenu_code() {
		return menu_code;
	}

	public void setMenu_code(int menu_code) {
		this.menu_code = menu_code;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMenu_size() {
		return menu_size;
	}

	public void setMenu_size(String menu_size) {
		this.menu_size = menu_size;
	}

	public String getHot_ice_condition() {
		return hot_ice_condition;
	}

	public void setHot_ice_condition(String hot_ice_condition) {
		this.hot_ice_condition = hot_ice_condition;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "번호 : "+menu_code+"  종류 : "+category+"     이름 : "
				+menu_name+"  핫/아이스 : "+hot_ice_condition + "  사이즈 : " +menu_size
				+"  가격 : "+price;
			  
	}

//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("MenuDTO [menu_code=").append(menu_code).append(", menu_name=").append(menu_name)
//				.append(", category=").append(category).append(", menu_size=").append(menu_size)
//				.append(", hot_ice_condition=").append(hot_ice_condition).append(", price=").append(price).append("]");
//		return builder.toString();
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
}
