package com.sergpvr.springadv.view;

import beans.models.Event;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PdfEventsView  extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(
            Map<String, Object> model,
            Document document,
            PdfWriter writer,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        document.add(new Paragraph("#Events: (PDF created by Serhiy Povoroznyuk)"));
        document.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(6);
        PdfPCell header1 = new PdfPCell(new Phrase("Id"));
        PdfPCell header2 = new PdfPCell(new Phrase("Name"));
        PdfPCell header3 = new PdfPCell(new Phrase("Rate"));
        PdfPCell header4 = new PdfPCell(new Phrase("BasePrice"));
        PdfPCell header5 = new PdfPCell(new Phrase("DateTime"));
        PdfPCell header6 = new PdfPCell(new Phrase("Auditorium"));
        header1.setHorizontalAlignment(Element.ALIGN_LEFT);
        header2.setHorizontalAlignment(Element.ALIGN_LEFT);
        header3.setHorizontalAlignment(Element.ALIGN_LEFT);
        header4.setHorizontalAlignment(Element.ALIGN_LEFT);
        header5.setHorizontalAlignment(Element.ALIGN_LEFT);
        header6.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(header1);
        table.addCell(header2);
        table.addCell(header3);
        table.addCell(header4);
        table.addCell(header5);
        table.addCell(header6);


        //Get data from model
        List<Event> events = (List<Event>) model.get("eventList");
        for (Event event : events) {
            table.addCell(String.valueOf(event.getId()));
            table.addCell(event.getName());
            table.addCell(event.getRate().toString());
            table.addCell(String.valueOf(event.getBasePrice()));
            table.addCell(event.getDateTime()== null? "" : event.getDateTime().toString());
            table.addCell(event.getAuditorium() == null ? "" : event.getAuditorium().getName());
        }
        document.add(table);
    }

}
