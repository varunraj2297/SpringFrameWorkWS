package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;


import com.nt.dto.HotelDTO;

public class HotelReportExcelView extends AbstractXlsView{

	@Override
	public void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<HotelDTO> listDTO=null;
		Sheet sheet=null;
		Row row=null;
		int i=0,j=0;
		
		sheet=workbook.createSheet("Hotel Report");
		
		listDTO=(List<HotelDTO>) map.get("hotels");
		for(HotelDTO dto:listDTO) {
	        j=0;
			row=sheet.createRow(i);
		    row.createCell(j).setCellValue(dto.getHotelId());
            row.createCell(j+1).setCellValue(dto.getHotelName());
            row.createCell(j+2).setCellValue(dto.getHotelType());
            row.createCell(j+3).setCellValue(dto.getLocation());
            row.createCell(j+4).setCellValue(dto.getPriceRange());
            i++;
		}
	}

	
}
