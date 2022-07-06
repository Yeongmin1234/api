package org.zerock.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcelController {
	
	@RequestMapping(value = "/poiExcel", method = RequestMethod.POST)
	public void poiTest(Model model, HttpServletResponse response,
			HttpServletRequest request) throws Exception{

		
		/*
		�����δ� DB �����͸� �����ϴ� ��찡 ���� ������ ��¥�����͸� ���÷� ��ٸ�.
		������ ����ڰ� day1 �� day2 �� �Ѱ��ְ�. ��Ʈ�ѷ����� service�� �����͸� �ѱ��.
		dao���� mapper�� ����  day1 �� day2 ��¥ ������ �����͵��� ����� ���̴�.
		�� �����͵��� list �� ��Ƽ� Ȱ���Ѵٰ� �����غ��� !
		 */

		List<String> list = new ArrayList<String>();
		
		list.add("�ڻ���"); // ���õ�����1
		list.add("�趧��"); // ���õ�����2
		list.add("�ȸԾ�"); // ���õ�����3
		list.add("��ö��"); // ���õ�����4
		list.add("������"); // ���õ�����5
		
		Workbook wb = new HSSFWorkbook(); // �������� ��ü ����
		Sheet sheet = wb.createSheet("�׽�Ʈ ��Ʈ"); //��Ʈ ���� ( ù��° ��Ʈ�̸�, ��Ʈ���� �׽�Ʈ ��Ʈ )
		
		CellStyle style = wb.createCellStyle(); // �� ��Ÿ�� ����
		Font font = wb.createFont(); // ��Ʈ ��Ÿ�� ����
		
//       font.setFontHeight((short)(16*18)); // ���� ũ��
//       font.setFontName("���� ���"); // �۾�ü
       
       // �ڹ��� �迭ó�� ù��° �ε����� 0 ���� �����Ѵ�.  ù��°�� 0 , �ι�°�� 1 , ����°�� 2
        Row titleRow = sheet.createRow(0); // Ÿ��Ʋ���� �����Ѵ�. ù��°���̱⶧���� createRow(0)
        int titleColNum = 0; // ù��° ���̱� ������ 0 
		Cell titleCell = titleRow.createCell(titleColNum); // ù��°���� ù��°���� �����Ѵ�. 
		titleCell.setCellValue("�ȳ��ϼ��� �׽�Ʈ�Դϴ�."); // setCellValue ���� ���ֱ�.
		titleRow.setHeight((short)300); // Row���� setHeight�� �ϸ� �� ���̰� �����ȴ�. 
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,4)); // �� ����  ù��°��~��ȩ��° ������ ���� 
		// new CellRangeAddress(���� row, �� row, ���� col, �� col) 

		style.setWrapText(true); //���ڿ��� �Է��Ҷ� \n ���� ������ �ν����ش�.
		style.setFont(font); // ��Ÿ�Ͽ� font ��Ÿ�� �����ϱ�
		titleCell.setCellStyle(style); // ������ ��Ÿ�ϵ��� titleCell�� ���������� !
		
		//��� �����
		Row headerRow = sheet.createRow(3); // �׹�°�� ����
		int headerCol = 0;
		Cell headerCell = headerRow.createCell(headerCol++);
		headerCell.setCellValue("����");
		headerCell = headerRow.createCell(headerCol);
		headerCell.setCellValue("�̸�");

		//===============================================================================
		
		CellStyle dataStyle = wb.createCellStyle(); // �����ͽ�Ÿ���� �׵θ��� ������
		
		
		//������ �����ϱ�
		int rowNum = 4; // �׹�°���� ����ϱ� �� �ؿ������� ������ ����
		int cellNum = 0;
		Row dataRow = null; // for���� �����ֱ�����.
		Cell dataCell = null;
		
		for(int i = 0; i<list.size(); i++) {
			cellNum = 0;
			dataRow = sheet.createRow(rowNum++); // for�� ���鼭 �� 1�پ� �߰�
			
			dataCell = dataRow.createCell(cellNum++); //�� ���پ� �߰�
			dataCell.setCellValue(i+1); // ù��°ĭ�� �����̱⶧���� 
			dataCell.setCellStyle(dataStyle); // �׵θ� ��Ÿ�� ����
			
			dataCell = dataRow.createCell(cellNum); // �ι�° ���� �̸��̴ϱ�
			dataCell.setCellValue(list.get(i)); // list�� ����� �̸� ���
			dataCell.setCellStyle(dataStyle); // �׵θ� ��Ÿ�� ����
		}
		
		dataRow = sheet.createRow(rowNum++); // �� �ο��� �ۼ��غ���
		dataCell = dataRow.createCell(0); // ù����ĭ
		dataCell.setCellValue("�� �ο�");
		dataCell = dataRow.createCell(1); // �ι���ĭ
		dataCell.setCellFormula("COUNT(A5:A9)"); // �Լ����� �Է��� �� �ִ� ���
		
			
		 /* ���� ���� ���� */
	    response.setContentType("ms-vnd/excel");
	    response.setHeader("Content-Disposition", "attachment;filename=poiTest.xls");
	    wb.write(response.getOutputStream());
	    
	}
}
 
 