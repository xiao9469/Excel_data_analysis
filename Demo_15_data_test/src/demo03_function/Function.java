package demo03_function;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function {
	//ͳ���ַ����ֵĴ���
		public List<String> static_char(List<String> list){
			int count = 0;
			System.out.println("������Ҫͳ�Ƶ��ַ���");
			Scanner sc = new Scanner(System.in);
			String tem_in = sc.nextLine();
			String static_char_str =   tem_in ;
			
			Pattern p = Pattern.compile(static_char_str);
			for(int i = 0 ; i< list.size();i++) {
				String s = list.get(i);
				Matcher m = p.matcher(s);
				while(m.find()) {
					 count +=1 ;
				}
			}
			System.out.println("��"+tem_in+"���������� "+count+"��");
			return list;
		}
	//ȥ������
		public List<String> remove_morechar(List<String> list){
			String reg_rule = "(.)\\1+";
			for(int i = 0 ; i< list.size();i++) {
				String s = list.get(i);
				String s2 = list.get(i).replaceAll(reg_rule, "$1");
				list.set(i, s2);
			}
			System.out.println("���������");
			return list;
		}
	//�����滻
		public List<String> replace_char(List<String> list){
			
			Scanner sc = new Scanner(System.in);
			System.out.print("�������滻ǰ�ľ����ݣ�");
			String reg_str_pas = sc.nextLine();
			System.out.print("�������滻��������ݣ�");
			String reg_str_new = sc.nextLine();
			Pattern p = Pattern.compile(reg_str_pas);
			
			for(int i = 0 ; i < list.size() ;i++) {
				String s = list.get(i);
				
				Matcher m = p.matcher(s);
				while(m.find() ) {
					String s2 = list.get(i).replaceAll(reg_str_pas,reg_str_new);
					list.set(i, s2);
				}
			}
			System.out.println("û�и���ġ�" + reg_str_pas + "����");
			return list;
		}
	//����ɾ��
		public List<String> Delete_char(List<String> list){
			System.out.println("������ɾ��������");
			Scanner sc = new Scanner(System.in);
			String reg_str = sc.nextLine();
			Pattern p = Pattern.compile(reg_str);
			for(int i = 0 ; i < list.size() ;i++) {
				String s = list.get(i);
				
				Matcher m = p.matcher(s);
				while(m.find() ) {
					String s2 = list.get(i).replaceAll(reg_str,"");
					list.set(i, s2);
				}
			}
			System.out.println("û�и���ġ�" + reg_str + "����");
			return list;
		}
	
	
	//�������
	public List<String> Search_char(List<String> list){
		System.out.println("��������ҵ�����");
		Scanner sc = new Scanner(System.in);
		String reg_str = sc.nextLine();
		Pattern p = Pattern.compile(reg_str);
		for(int i = 0 ; i < list.size() ;i++) {
			String s = list.get(i);
			
			Matcher m = p.matcher(s);
			while(m.find() ) {
				String tem = s.substring(m.start(),m.end());
				System.out.println(list.get(i));
				System.out.println(tem + " ����ʼλ��" + m.start() + " ,����λ��" + m.end());
				System.out.println("===========================");
			}
		}
		System.out.println("û�и���ġ�" + reg_str + "����");
		return list;
	}
	//ȥ���޹صĿո�
	public List<String> clean_space(List<String> list) {
		for(int i = 0 ; i<list.size();i++) {
			String s  = list.get(i).replaceAll("\\s+", "");
			//ȥ����λ�ո�
			s.trim();
			list.set(i, s);
		}
		System.out.println("=====�޹ؿո������=====");
	return list;
	}
	//ȥ���޹��ַ�
	public List<String> clean_char(List<String> list){
		//��������
		String reg_rule = "[\\n`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~��@#��%����&*��������+|{}�������������������� ����]" ;
		for(int i = 0 ; i<list.size();i++) {
			String s = list.get(i).replaceAll(reg_rule,"");
			list.set(i, s);
		}
		return list;
	}
}