package com.sergpvr.springadv.view;

import beans.models.User;
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

public class PdfUsersView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(
            Map<String, Object> model,
            Document document,
            PdfWriter writer,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        document.add(new Paragraph("#Users: (PDF created by Serhiy Povoroznyuk)"));
        document.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(5);
        PdfPCell header1 = new PdfPCell(new Phrase("Id"));
        PdfPCell header2 = new PdfPCell(new Phrase("Email"));
        PdfPCell header3 = new PdfPCell(new Phrase("Name"));
        PdfPCell header4 = new PdfPCell(new Phrase("Birthday"));
        PdfPCell header5 = new PdfPCell(new Phrase("Roles"));
        header1.setHorizontalAlignment(Element.ALIGN_LEFT);
        header2.setHorizontalAlignment(Element.ALIGN_LEFT);
        header3.setHorizontalAlignment(Element.ALIGN_LEFT);
        header4.setHorizontalAlignment(Element.ALIGN_LEFT);
        header5.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(header1);
        table.addCell(header2);
        table.addCell(header3);
        table.addCell(header4);
        table.addCell(header5);

        //Get data from model
        List<User> users = (List<User>) model.get("userList");
        for (User user : users) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getEmail());
            table.addCell(user.getName());
            table.addCell(user.getBirthday() == null ? "" : user.getBirthday().toString());
            table.addCell(user.getRoles());
        }
        document.add(table);
    }

}
