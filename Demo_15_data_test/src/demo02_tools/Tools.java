package demo02_tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;

public class Tools {
	//打印列表用
	public static void print_detail_list(List<String> list ) {
		for(int i=0 ; i <list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	//获取指定列内容
	public static List<String> Get_index_columns(Sheet[] sheets,int index_columns) {
		List<String> list = new ArrayList<>();
		
		if(sheets!=null) {
			 for(Sheet sheet :sheets) {
				 int row = sheet.getRows();//行
				 int columns= index_columns; //列
		       	 for(int m=0; m<row; m++) {
		       		 Cell cell = sheet.getCell(columns,m);
		       		 list.add(cell.getContents());
		       	 }
	        }
		}
		return list;
		//System.out.println(sheets.length);
	}
	//获取指定行内容
	public static void Get_index_row(Sheet[] sheets,int index_row) {
		//String [] = new String [sheets.]
		 for(Sheet sheet :sheets) {
			 int row = index_row;//行
			 int columns=sheet.getColumns(); //列
	       	 for(int m=0;m<columns;m++) {
	       		 Cell cell = sheet.getCell(m,index_row);
	       		 
	       		 System.out.println(cell.getContents());
	       	 }
        }
	}
	

}
