package demo01_test;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.lang.model.SourceVersion;
import javax.tools.Tool;

import demo02_tools.Tools;
import demo03_function.Function;
import jxl.*;
import jxl.read.biff.BiffException;   
public class Test{  
	//接收留言主题内容
	public static List<String > list_theme = new ArrayList<String>();
	//接收留言详情内容
	public static List<String> list_detail_content = new ArrayList<String>();
	//文件路径
    public static File xlsFile = new File("ceshi.xls");
	//function对象
    public static Function f = new Function();
    //用户输入
    public static Scanner sc = new Scanner(System.in);
    //程序入口
	public static void main(String[] args) throws BiffException, IOException {
    	//起始标识
    	System.out.println("===开始标识===");
        //工作区
    	jxl.Workbook book = jxl.Workbook.getWorkbook(xlsFile);
    	//表格
    	Sheet[] sheets = book.getSheets();
    	// 获取留言主题
		//list_theme = Tools.Get_index_columns(sheets, 2);
		// 获取留言主题内容
		list_detail_content = Tools.Get_index_columns(sheets, 4);
    	//用户输入
    	int choice = 0 ;
    	function_notice();
		choice = sc.nextInt();
    	while(choice!=0) {
	    	switch (choice) {
				case 1:
					//去除空格
					list_detail_content = f.clean_space(list_detail_content);
					
					break;
				case 2:
					//去除特殊字符
					list_detail_content = f.clean_char(list_detail_content);
					break;
				case 3:
					//正则查找
					list_detail_content = f.Search_char(list_detail_content);
					break;
				case 4:
					//正则删除
					list_detail_content = f.Delete_char(list_detail_content);
					break;
				case 5:
					//正则替换
					list_detail_content = f.replace_char(list_detail_content);
					break;
				case 6:
					//去除叠词
					list_detail_content = f.remove_morechar(list_detail_content);
					break;
				case 7:
					//数据统计
					list_detail_content = f.static_char(list_detail_content);
					break;
				case 8:
					//打印当前集合
					Tools.print_detail_list(list_detail_content);
					break;
		
				default:
					break;
				}
		
		//去除空格
		//list_detail_content = f.clean_space(list_detail_content);
		//去除特殊字符
		//list_detail_content = f.clean_char(list_detail_content);
		//正则查找
		//list_detail_content = f.Search_char(list_detail_content);
		//正则删除
		//list_detail_content = f.Delete_char(list_detail_content);
		//正则替换
		//list_detail_content = f.replace_char(list_detail_content);
		//去除叠词
		//list_detail_content = f.remove_morechar(list_detail_content);
		//数据统计
		//list_detail_content = f.static_char(list_detail_content);
		//打印当前集合
		//Tools.print_detail_list(list_detail_content);
		  
		System.out.println("========结束标识========");
		function_notice();
		choice = sc.nextInt();
		
    	}
    	book.close();
    }
	
	public static void function_notice() {
		System.out.println();
		System.out.println("========功能选择======");
		System.out.println("1、去除空格 2、去除特殊字符 3、正则查找 4、正则删除 5、正则替换 6、去除叠词 7、统计词频 8、打印当前获取的数据 0、退出");
		System.out.println("请输入你要进行的操作：");
	}
}
