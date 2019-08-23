package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.dto.HotelDTO;

public class HotelReportPdfView extends AbstractPdfView {
	
	@Override
	public void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<HotelDTO> listDTO=null;
		Paragraph p=null;
		Table t=null;
		
		listDTO=(List<HotelDTO>)map.get("hotels");
		p=new Paragraph("HotelReport",new Font(Font.BOLD));
        t=new Table(5,listDTO.size());
        document.add(p);
        for(HotelDTO dto:listDTO) {
        	t.addCell(String.valueOf(dto.getHotelId()));
        	t.addCell(dto.getHotelName());
        	t.addCell(dto.getHotelType());
        	t.addCell(dto.getLocation());
        	t.addCell(dto.getPriceRange());
        }
        document.add(t);

	}
}
