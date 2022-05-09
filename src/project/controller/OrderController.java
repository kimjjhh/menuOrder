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
			//���θ޴�	
			 int select_job = displayMenu();
				
			//���� 1.ȸ������
				if(select_job==1) {
					System.out.println("====ȸ������====");					
					register();				
					}
			//���� 2.�α���
				else if(select_job==2) {
				if(login()==0) {continue;}
				boolean flag2 = true;				
				aa:while(flag2) {			
					System.out.println(id+"�� �α���...");
					int login_no = loginNo();
					
					//2.1 �ֹ�
					if(login_no == 1) {
						boolean flag3 = true;
						int order_no = orderNo();
						
						//2.1.1 �ֹ�
						if(order_no == 1) {
						menuAll();
						order();
						}
						
						//2.2.2 ���ư���
						else if(order_no == 2) {flag3 = false;}
						}
					
					//2.2 ����			
					else if(login_no == 2) {
						boolean flag4 = true;
						int rsv_no = rsvNo();
						
						//2.2.1 �����ֹ�
						if(rsv_no == 1) {
						    
							menuAll();
							order_rsv();
						}
						
						//2.2.2 ���ư���
						else if(rsv_no == 2) {flag4 = false;}
					}
					
					//2.3 �Ⱦ�
					else if(login_no == 3) {
						pickUp();
					}
					
					//2.4 �α׾ƿ�		
					else if(login_no == 4) {
						System.out.println(id+"�� �α׾ƿ�...");
						flag2 = false;}
			
					//2.5 ����������			
					else if(login_no == 5) {
						boolean flag5 = true;
						
						while(flag5) {
							int mypage = myPageNo();
							
							//2.5.1 ȸ����������
							if(mypage == 1) {modify();}
							
							//2.5.2 �ֹ�/������ȸ
							else if(mypage == 2) {
								boolean flag6 = true;
								while(flag6) {
								int order_detail = orderDtail(); 
								
								//2.5.2.1 ��ü�ֹ���ȸ
								if(order_detail == 1) { orderAll(); }
								
								//2.5.2.2 �����ֹ���ȸ
								else if(order_detail == 2) { orderRsv(); }
								
								//2.5.2.3 ��¥����ȸ
								else if(order_detail == 3) { orderDate(); }
								
								//2.5.2.4 ���ư���
								else if(order_detail == 4) {flag6 = false;}
								}
							}
							
							//2.5.3 �ֹ����
							else if(mypage == 3) {cancell();}
							
							//2.5.4 ȸ��Ż��
							else if(mypage == 4) {
							//	order_cancell();
								if(withdraw()==0) { break aa;}
							
							}
							
							//2.5.5 ���ư���
							else if(mypage == 5) {flag5 = false;}
							
					}
				}


				}}
				
				//���� 3.�޴��˻�
				else if(select_job==3) {
					boolean flag6 = true;
					while(flag6) {
						int menusearch = menuSearch();
						
						//3.1 ��ü�޴�
						if(menusearch == 1) {menuAll();}
						
						//3.2 �޴��̸�
						else if(menusearch == 2) {menuName();}
						
						//3.3 ���ư���
						else if(menusearch == 3) {flag6 = false;}
					}
				}
				//���� 4.����	
				else if(select_job==4) {
					flag = false;}
			}
			System.out.println("===========���α׷�����============");
		
		
	}
	
	private static int displayMenu() {
		System.out.println("====================MENU===================");
		System.out.println("1.ȸ������ 2.�α��� 3.�޴��˻� 4.����");
		System.out.println("===========================================");
		System.out.print("��ȣ ����>>");
		
		return Integer.parseInt(sc.nextLine());
	}
	
	private static int loginNo() {
		System.out.println("====================MENU===================");
		System.out.println("1.�ֹ� 2.���� 3.�Ⱦ� 4.�α׾ƿ� 5.����������");
		System.out.println("===========================================");
		System.out.print("��ȣ ����>>");
		
		return Integer.parseInt(sc.nextLine());
	}
	
	private static int orderNo() {
		System.out.println("====================MENU===================");
		System.out.println("1.�ֹ� 2.���ư���");
		System.out.println("===========================================");
		System.out.print("��ȣ ����>>");
		
		return Integer.parseInt(sc.nextLine());
	}
	private static int rsvNo() {
		System.out.println("====================MENU===================");
		System.out.println("1.���� 2.���ư���");
		System.out.println("===========================================");
		System.out.print("��ȣ ����>>");
	
	return Integer.parseInt(sc.nextLine());}
	
	private static int myPageNo() {
		System.out.println("====================MENU===================");
		System.out.println("1.ȸ���������� 2.�ֹ�/������ȸ 3.�ֹ���� 4.ȸ��Ż�� 5.���ư���");
		System.out.println("===========================================");
		System.out.print("��ȣ ����>>");
	
	return Integer.parseInt(sc.nextLine());
	}
	
	private static int orderDtail() {
		System.out.println("====================MENU===================");
		System.out.println("1.��ü�ֹ���ȸ 2.�����ֹ���ȸ 3.��¥����ȸ 4.���ư���");
		System.out.println("===========================================");
		System.out.print("��ȣ ����>>");
		
		return Integer.parseInt(sc.nextLine());
	}
	
	private static int menuSearch() {
		System.out.println("====================MENU===================");
		System.out.println("1.��ü�޴� 2.�޴��̸� 3.���ư���");
		System.out.println("===========================================");
		System.out.print("��ȣ ����>>");
		return Integer.parseInt(sc.nextLine());
	}


	
	//1. ȸ������
	private static void register() {
		MemberShipDTO member = new MemberShipDTO();
		System.out.print("���̵�>>");
		member.setM_id(sc.nextLine());
		System.out.print("��й�ȣ>>");
		member.setM_pw(sc.nextLine());
		System.out.print("�̸�>>");
		member.setM_name(sc.nextLine());
		System.out.print("�ڵ�����ȣ �Է� Y/N >>");	
		String answer2 = sc.nextLine();
		if(answer2.equalsIgnoreCase("y")) {	
			System.out.print("�Է��ϼ���>>");
			member.setPhone(sc.nextLine());}
		else {member.setPhone(null);}
		System.out.print("�������  Y/N >>");	
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			System.out.print("�Է��ϼ���(YYYY-MM-DD)>>");
			member.setM_birth(DateUtilA.convertToDate2(sc.nextLine()));}
		else {member.setM_birth(null);}
		

		int result = service.register(member);
		MemberView.print(result>0?"ȸ������ ����":"ȸ������ ����");	
	}

	//2. ȸ����������
	private static void modify() {
		MemberShipDTO member = new MemberShipDTO();
		System.out.print("��й�ȣ>>");
		member.setM_pw(sc.nextLine());
		System.out.print("�ڵ�����ȣ �Է� Y/N>>");	
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("y")) {	
			System.out.print("�Է��ϼ���>>");
			member.setPhone(sc.nextLine());}
		else{member.setPhone(null);}
		member.setM_id(id);
		int result = service.modify(member);
		MemberView.print(result>0?"���������� ���������� �̷�� �����ϴ�":"���������� ���� �ϼ̽��ϴ�");	
		
	}

	//3.ȸ��Ż��
	private static int withdraw() {
		System.out.print("Ż���Ͻðڽ��ϱ�? Y or N>>");
		String answer = sc.nextLine();
		int result = 0;
		if(answer.equalsIgnoreCase("y")) 
		result = service.withdraw(id);
		MemberView.print(result>0?"ȸ��Ż�𼺰�":"ȸ��Ż�����");
		return result>0?0:1;
//		if(result>0) {MemberView.print("ȸ��Ż�� ����");}	
	
	}
	//3.1 ȸ��Ż��� �ֹ��޴��� �����Ǿ�� �Ѵ�
//	private static void order_cancell(){
//		
//		System.out.print("Ż���Ͻðڽ��ϱ�? Y or N>>");
//		String answer = sc.nextLine();
//		if(answer.equalsIgnoreCase("n")) {return;}
//		 service.order_cancell(id);
////		int result = service.order_cancell(id);
////		OrderView.print(result>0?"�ֹ��������� ����":"�ֹ����� ����");
//	}
	
	//4. �α���
	private static int login() {
		System.out.println("====�α���====");
		System.out.print("���̵�>>");
		id = sc.nextLine();
		System.out.print("��й�ȣ>>");
		String pw = sc.nextLine();	
		MemberShipDTO member = service.login(id, pw);
		MemberView.print(member);
	    return member==null?0:1;
		
	}
	
	//5.�޴���ü
	private static void menuAll() {
		MenuView.print(service.menuAll());
	}
	
	//5.1 �޴��̸�
	private static void menuName() {
		System.out.print("�޴��̸��Է�>>");
		MenuView.print(service.menuName(sc.nextLine()));
	}
	
	//6.�ֹ��ϱ�
	private static void order() {
		OrderDTO order = new OrderDTO();
		System.out.print("�޴���ȣ>>");
		order.setMenu_code(Integer.parseInt(sc.nextLine()));
		order.setM_id(id);
		System.out.print("��û����>>");
		order.setRequest(sc.nextLine());
		System.out.print("�ֹ��Ͻðڽ��ϱ�? Y or N>>");
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("n")) {return;}
		int result = service.order(order);
		if(result>0)OrderView.print("�ֹ��� ���������� �̷�������ϴ�");
	}
	
	//6.1 �����ֹ��ϱ�
	private static void order_rsv() {
		OrderDTO order = new OrderDTO();
		System.out.print("�޴���ȣ>>");
		order.setMenu_code(Integer.parseInt(sc.nextLine()));
		order.setM_id(id);
		//System.out.print("�Ⱦ���¥(YY-MM-DD hh:mm)>>");
		//order.setPick_date(DateUtilA.convertToDate(sc.nextLine()));
		System.out.print("��û����>>");
		order.setRequest(sc.nextLine());
		System.out.print("�ֹ��Ͻðڽ��ϱ�? Y or N>>");
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("n")) {return;}
		int result = service.order_rsv(order);
		if(result>0)OrderView.print("������ ���������� �̷�� �����ϴ�");
			
	}
	
	//6.2 �Ⱦ�
	private static void pickUp() {
		OrderDTO order = new OrderDTO();
		System.out.print("�ֹ���ȣ>>");
		order.setOreder_no(Integer.parseInt(sc.nextLine()));
		int result = service.pickUp(order);
		OrderView.print(result>0?"�Ⱦ� ����":"�ֹ���ȣ�� �߸� �Է� �ϼ̽��ϴ�");

	}
	
	//7.��ü �ֹ���ȸ
	private static void orderAll() {
		OrderView.print(service.orderAll());
	}
	
	//7.1 ��¥���ֹ���ȸ
	private static void orderDate() {
		System.out.print("start date>>");
		Date date1 = DateUtilA.convertToDate2(sc.nextLine());
		System.out.print("end date>>");
		Date date2 = DateUtilA.convertToDate2(sc.nextLine());
		OrderView.print(service.orderDate(date1, date2));
	}
	//7.2 ������ȸ
	private static void orderRsv() {
		OrderView.print(service.orderRsv());
	}
	
	//8.�ֹ����
	private static void cancell() {
		System.out.print("������ֹ���ȣ>>");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("����Ͻðڽ��ϱ�? Y or N>>");
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("n")) {return;}
		int result = service.cancell(no);
		OrderView.print(result>0?"�ֹ��� ��� �Ǿ����ϴ�":"�ֹ� ��� ����");	
	}
	
	}
