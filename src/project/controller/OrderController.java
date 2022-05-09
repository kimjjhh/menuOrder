package project.controller;

import java.sql.Date;
import java.util.Scanner;

import project.dto.MemberShipDTO;
import project.dto.OrderDTO;
import project.dto.OrderJoinVO;
import project.model.OrderService;
import project.util.DateUtilA;
import project.view.MemberView;
import project.view.MenuView;
import project.view.OrderView;

public class OrderController {

	static OrderService service = new OrderService();
	static Scanner sc = new Scanner(System.in);
	static String id;
	
	public static void main(String[] args) {
		 boolean flag = true;
		 while(flag) {
			//메인메뉴	
			 int select_job = displayMenu();
				
			//메인 1.회원가입
				if(select_job==1) {
					System.out.println("====회원가입====");					
					register();				
					}
			//메인 2.로그인
				else if(select_job==2) {
				if(login()==0) {continue;}
				boolean flag2 = true;				
				aa:while(flag2) {			
					System.out.println(id+"님 로그인...");
					int login_no = loginNo();
					
					//2.1 주문
					if(login_no == 1) {
						boolean flag3 = true;
						int order_no = orderNo();
						
						//2.1.1 주문
						if(order_no == 1) {
						menuAll();
						order();
						}
						
						//2.2.2 돌아가기
						else if(order_no == 2) {flag3 = false;}
						}
					
					//2.2 예약			
					else if(login_no == 2) {
						boolean flag4 = true;
						int rsv_no = rsvNo();
						
						//2.2.1 예약주문
						if(rsv_no == 1) {
						    
							menuAll();
							order_rsv();
						}
						
						//2.2.2 돌아가기
						else if(rsv_no == 2) {flag4 = false;}
					}
					
					//2.3 픽업
					else if(login_no == 3) {
						pickUp();
					}
					
					//2.4 로그아웃		
					else if(login_no == 4) {
						System.out.println(id+"님 로그아웃...");
						flag2 = false;}
			
					//2.5 마이페이지			
					else if(login_no == 5) {
						boolean flag5 = true;
						
						while(flag5) {
							int mypage = myPageNo();
							
							//2.5.1 회원정보수정
							if(mypage == 1) {modify();}
							
							//2.5.2 주문/예약조회
							else if(mypage == 2) {
								boolean flag6 = true;
								while(flag6) {
								int order_detail = orderDtail(); 
								
								//2.5.2.1 전체주문조회
								if(order_detail == 1) { orderAll(); }
								
								//2.5.2.2 예약주문조회
								else if(order_detail == 2) { orderRsv(); }
								
								//2.5.2.3 날짜별조회
								else if(order_detail == 3) { orderDate(); }
								
								//2.5.2.4 돌아가기
								else if(order_detail == 4) {flag6 = false;}
								}
							}
							
							//2.5.3 주문취소
							else if(mypage == 3) {cancell();}
							
							//2.5.4 회원탈퇴
							else if(mypage == 4) {
							//	order_cancell();
								if(withdraw()==0) { break aa;}
							
							}
							
							//2.5.5 돌아가기
							else if(mypage == 5) {flag5 = false;}
							
					}
				}


				}}
				
				//메인 3.메뉴검색
				else if(select_job==3) {
					boolean flag6 = true;
					while(flag6) {
						int menusearch = menuSearch();
						
						//3.1 전체메뉴
						if(menusearch == 1) {menuAll();}
						
						//3.2 메뉴이름
						else if(menusearch == 2) {menuName();}
						
						//3.3 돌아가기
						else if(menusearch == 3) {flag6 = false;}
					}
				}
				//메인 4.종료	
				else if(select_job==4) {
					flag = false;}
			}
			System.out.println("===========프로그램종료============");
		
		
	}
	
	private static int displayMenu() {
		System.out.println("====================MENU===================");
		System.out.println("1.회원가입 2.로그인 3.메뉴검색 4.종료");
		System.out.println("===========================================");
		System.out.print("번호 선택>>");
		
		return Integer.parseInt(sc.nextLine());
	}
	
	private static int loginNo() {
		System.out.println("====================MENU===================");
		System.out.println("1.주문 2.예약 3.픽업 4.로그아웃 5.마이페이지");
		System.out.println("===========================================");
		System.out.print("번호 선택>>");
		
		return Integer.parseInt(sc.nextLine());
	}
	
	private static int orderNo() {
		System.out.println("====================MENU===================");
		System.out.println("1.주문 2.돌아가기");
		System.out.println("===========================================");
		System.out.print("번호 선택>>");
		
		return Integer.parseInt(sc.nextLine());
	}
	private static int rsvNo() {
		System.out.println("====================MENU===================");
		System.out.println("1.예약 2.돌아가기");
		System.out.println("===========================================");
		System.out.print("번호 선택>>");
	
	return Integer.parseInt(sc.nextLine());}
	
	private static int myPageNo() {
		System.out.println("====================MENU===================");
		System.out.println("1.회원정보수정 2.주문/예약조회 3.주문취소 4.회원탈퇴 5.돌아가기");
		System.out.println("===========================================");
		System.out.print("번호 선택>>");
	
	return Integer.parseInt(sc.nextLine());
	}
	
	private static int orderDtail() {
		System.out.println("====================MENU===================");
		System.out.println("1.전체주문조회 2.예약주문조회 3.날짜별조회 4.돌아가기");
		System.out.println("===========================================");
		System.out.print("번호 선택>>");
		
		return Integer.parseInt(sc.nextLine());
	}
	
	private static int menuSearch() {
		System.out.println("====================MENU===================");
		System.out.println("1.전체메뉴 2.메뉴이름 3.돌아가기");
		System.out.println("===========================================");
		System.out.print("번호 선택>>");
		return Integer.parseInt(sc.nextLine());
	}


	
	//1. 회원가입
	private static void register() {
		MemberShipDTO member = new MemberShipDTO();
		System.out.print("아이디>>");
		member.setM_id(sc.nextLine());
		System.out.print("비밀번호>>");
		member.setM_pw(sc.nextLine());
		System.out.print("이름>>");
		member.setM_name(sc.nextLine());
		System.out.print("핸드폰번호 입력 Y/N >>");	
		String answer2 = sc.nextLine();
		if(answer2.equalsIgnoreCase("y")) {	
			System.out.print("입력하세요>>");
			member.setPhone(sc.nextLine());}
		else {member.setPhone(null);}
		System.out.print("생년월일  Y/N >>");	
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			System.out.print("입력하세요(YYYY-MM-DD)>>");
			member.setM_birth(DateUtilA.convertToDate2(sc.nextLine()));}
		else {member.setM_birth(null);}
		

		int result = service.register(member);
		MemberView.print(result>0?"회원가입 성공":"회원가입 실패");	
	}

	//2. 회원정보수정
	private static void modify() {
		MemberShipDTO member = new MemberShipDTO();
		System.out.print("비밀번호>>");
		member.setM_pw(sc.nextLine());
		System.out.print("핸드폰번호 입력 Y/N>>");	
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("y")) {	
			System.out.print("입력하세요>>");
			member.setPhone(sc.nextLine());}
		else{member.setPhone(null);}
		member.setM_id(id);
		int result = service.modify(member);
		MemberView.print(result>0?"정보수정이 정상적으로 이루어 졌습니다":"정보수정에 실패 하셨습니다");	
		
	}

	//3.회원탈퇴
	private static int withdraw() {
		System.out.print("탈퇴하시겠습니까? Y or N>>");
		String answer = sc.nextLine();
		int result = 0;
		if(answer.equalsIgnoreCase("y")) 
		result = service.withdraw(id);
		MemberView.print(result>0?"회원탈퇴성공":"회원탈퇴실패");
		return result>0?0:1;
//		if(result>0) {MemberView.print("회원탈퇴 성공");}	
	
	}
	//3.1 회원탈퇴시 주문메뉴도 삭제되어야 한다
//	private static void order_cancell(){
//		
//		System.out.print("탈퇴하시겠습니까? Y or N>>");
//		String answer = sc.nextLine();
//		if(answer.equalsIgnoreCase("n")) {return;}
//		 service.order_cancell(id);
////		int result = service.order_cancell(id);
////		OrderView.print(result>0?"주문정보삭제 성공":"주문정보 없음");
//	}
	
	//4. 로그인
	private static int login() {
		System.out.println("====로그인====");
		System.out.print("아이디>>");
		id = sc.nextLine();
		System.out.print("비밀번호>>");
		String pw = sc.nextLine();	
		MemberShipDTO member = service.login(id, pw);
		MemberView.print(member);
	    return member==null?0:1;
		
	}
	
	//5.메뉴전체
	private static void menuAll() {
		MenuView.print(service.menuAll());
	}
	
	//5.1 메뉴이름
	private static void menuName() {
		System.out.print("메뉴이름입력>>");
		MenuView.print(service.menuName(sc.nextLine()));
	}
	
	//6.주문하기
	private static void order() {
		OrderDTO order = new OrderDTO();
		System.out.print("메뉴번호>>");
		order.setMenu_code(Integer.parseInt(sc.nextLine()));
		order.setM_id(id);
		System.out.print("요청사항>>");
		order.setRequest(sc.nextLine());
		System.out.print("주문하시겠습니까? Y or N>>");
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("n")) {return;}
		int result = service.order(order);
		if(result>0)OrderView.print("주문이 성공적으로 이루어졌습니다");
	}
	
	//6.1 예약주문하기
	private static void order_rsv() {
		OrderDTO order = new OrderDTO();
		System.out.print("메뉴번호>>");
		order.setMenu_code(Integer.parseInt(sc.nextLine()));
		order.setM_id(id);
		//System.out.print("픽업날짜(YY-MM-DD hh:mm)>>");
		//order.setPick_date(DateUtilA.convertToDate(sc.nextLine()));
		System.out.print("요청사항>>");
		order.setRequest(sc.nextLine());
		System.out.print("주문하시겠습니까? Y or N>>");
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("n")) {return;}
		int result = service.order_rsv(order);
		if(result>0)OrderView.print("예약이 성공적으로 이루어 졌습니다");
			
	}
	
	//6.2 픽업
	private static void pickUp() {
		OrderDTO order = new OrderDTO();
		System.out.print("주문번호>>");
		order.setOreder_no(Integer.parseInt(sc.nextLine()));
		int result = service.pickUp(order);
		OrderView.print(result>0?"픽업 성공":"주문번호를 잘못 입력 하셨습니다");

	}
	
	//7.전체 주문조회
	private static void orderAll() {
		OrderView.print(service.orderAll());
	}
	
	//7.1 날짜별주문조회
	private static void orderDate() {
		System.out.print("start date>>");
		Date date1 = DateUtilA.convertToDate2(sc.nextLine());
		System.out.print("end date>>");
		Date date2 = DateUtilA.convertToDate2(sc.nextLine());
		OrderView.print(service.orderDate(date1, date2));
	}
	//7.2 예약조회
	private static void orderRsv() {
		OrderView.print(service.orderRsv());
	}
	
	//8.주문취소
	private static void cancell() {
		System.out.print("취소할주문번호>>");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("취소하시겠습니까? Y or N>>");
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("n")) {return;}
		int result = service.cancell(no);
		OrderView.print(result>0?"주문이 취소 되었습니다":"주문 취소 실패");	
	}
	
	}
