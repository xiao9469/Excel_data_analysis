package demo03_function;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function {
	//统计字符出现的次数
		public List<String> static_char(List<String> list){
			int count = 0;
			System.out.println("请输入要统计的字符：");
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
			System.out.println("【"+tem_in+"】共出现了 "+count+"次");
			return list;
		}
	//去除叠词
		public List<String> remove_morechar(List<String> list){
			String reg_rule = "(.)\\1+";
			for(int i = 0 ; i< list.size();i++) {
				String s = list.get(i);
				String s2 = list.get(i).replaceAll(reg_rule, "$1");
				list.set(i, s2);
			}
			System.out.println("叠词已清除");
			return list;
		}
	//正则替换
		public List<String> replace_char(List<String> list){
			
			Scanner sc = new Scanner(System.in);
			System.out.print("请输入替换前的旧内容：");
			String reg_str_pas = sc.nextLine();
			System.out.print("请输入替换后的新内容：");
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
			System.out.println("没有更多的【" + reg_str_pas + "】了");
			return list;
		}
	//正则删除
		public List<String> Delete_char(List<String> list){
			System.out.println("请输入删除的内容");
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
			System.out.println("没有更多的【" + reg_str + "】了");
			return list;
		}
	
	
	//正则查找
	public List<String> Search_char(List<String> list){
		System.out.println("请输入查找的内容");
		Scanner sc = new Scanner(System.in);
		String reg_str = sc.nextLine();
		Pattern p = Pattern.compile(reg_str);
		for(int i = 0 ; i < list.size() ;i++) {
			String s = list.get(i);
			
			Matcher m = p.matcher(s);
			while(m.find() ) {
				String tem = s.substring(m.start(),m.end());
				System.out.println(list.get(i));
				System.out.println(tem + " ，开始位置" + m.start() + " ,结束位置" + m.end());
				System.out.println("===========================");
			}
		}
		System.out.println("没有更多的【" + reg_str + "】了");
		return list;
	}
	//去除无关的空格
	public List<String> clean_space(List<String> list) {
		for(int i = 0 ; i<list.size();i++) {
			String s  = list.get(i).replaceAll("\\s+", "");
			//去除首位空格
			s.trim();
			list.set(i, s);
		}
		System.out.println("=====无关空格已清除=====");
	return list;
	}
	//去除无关字符
	public List<String> clean_char(List<String> list){
		//配置正则
		String reg_rule = "[\\n`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]" ;
		for(int i = 0 ; i<list.size();i++) {
			String s = list.get(i).replaceAll(reg_rule,"");
			list.set(i, s);
		}
		return list;
	}
}