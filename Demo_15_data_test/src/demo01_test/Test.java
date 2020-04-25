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
	//����������������
	public static List<String > list_theme = new ArrayList<String>();
	//����������������
	public static List<String> list_detail_content = new ArrayList<String>();
	//�ļ�·��
    public static File xlsFile = new File("ceshi.xls");
	//function����
    public static Function f = new Function();
    //�û�����
    public static Scanner sc = new Scanner(System.in);
    //�������
	public static void main(String[] args) throws BiffException, IOException {
    	//��ʼ��ʶ
    	System.out.println("===��ʼ��ʶ===");
        //������
    	jxl.Workbook book = jxl.Workbook.getWorkbook(xlsFile);
    	//���
    	Sheet[] sheets = book.getSheets();
    	// ��ȡ��������
		//list_theme = Tools.Get_index_columns(sheets, 2);
		// ��ȡ������������
		list_detail_content = Tools.Get_index_columns(sheets, 4);
    	//�û�����
    	int choice = 0 ;
    	function_notice();
		choice = sc.nextInt();
    	while(choice!=0) {
	    	switch (choice) {
				case 1:
					//ȥ���ո�
					list_detail_content = f.clean_space(list_detail_content);
					
					break;
				case 2:
					//ȥ�������ַ�
					list_detail_content = f.clean_char(list_detail_content);
					break;
				case 3:
					//�������
					list_detail_content = f.Search_char(list_detail_content);
					break;
				case 4:
					//����ɾ��
					list_detail_content = f.Delete_char(list_detail_content);
					break;
				case 5:
					//�����滻
					list_detail_content = f.replace_char(list_detail_content);
					break;
				case 6:
					//ȥ������
					list_detail_content = f.remove_morechar(list_detail_content);
					break;
				case 7:
					//����ͳ��
					list_detail_content = f.static_char(list_detail_content);
					break;
				case 8:
					//��ӡ��ǰ����
					Tools.print_detail_list(list_detail_content);
					break;
		
				default:
					break;
				}
		
		//ȥ���ո�
		//list_detail_content = f.clean_space(list_detail_content);
		//ȥ�������ַ�
		//list_detail_content = f.clean_char(list_detail_content);
		//�������
		//list_detail_content = f.Search_char(list_detail_content);
		//����ɾ��
		//list_detail_content = f.Delete_char(list_detail_content);
		//�����滻
		//list_detail_content = f.replace_char(list_detail_content);
		//ȥ������
		//list_detail_content = f.remove_morechar(list_detail_content);
		//����ͳ��
		//list_detail_content = f.static_char(list_detail_content);
		//��ӡ��ǰ����
		//Tools.print_detail_list(list_detail_content);
		  
		System.out.println("========������ʶ========");
		function_notice();
		choice = sc.nextInt();
		
    	}
    	book.close();
    }
	
	public static void function_notice() {
		System.out.println();
		System.out.println("========����ѡ��======");
		System.out.println("1��ȥ���ո� 2��ȥ�������ַ� 3��������� 4������ɾ�� 5�������滻 6��ȥ������ 7��ͳ�ƴ�Ƶ 8����ӡ��ǰ��ȡ������ 0���˳�");
		System.out.println("��������Ҫ���еĲ�����");
	}
}
