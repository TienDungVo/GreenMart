package com.duan1.utils;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.List;
import javax.swing.JFileChooser;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ExportListToPDFWithFileChooser {

    public void exportListToPDFWithFileChooser(List<?> list, String title, int hoadon, int tongtien, String... columnHeaders) {

        Document document = new Document();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(fileToSave.getAbsolutePath() + ".pdf"));
                document.open();
                
                // Tạo một font với font chữ và kích thước mong muốn
                Font font = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK);
                Paragraph Tenphieu = new Paragraph(title, font);
                Tenphieu.setAlignment(Element.ALIGN_CENTER);
                document.add(Tenphieu);
                
                
                int mahoadon = hoadon;
                if (mahoadon != 0) {
                    document.add(new Paragraph("Ma Hoa Don : " + mahoadon));
                }
                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String formattedDateTime = currentDateTime.format(formatter);
                document.add(new Paragraph("Thoi Gian : " + formattedDateTime));

                document.add(new Paragraph("\n"));
                PdfPTable pdfTable = new PdfPTable(columnHeaders.length);

                for (String columnHeader : columnHeaders) {
                    pdfTable.addCell(columnHeader);
                }

                if (list != null && !list.isEmpty()) {
                    Object firstObject = list.get(0);
                    Field[] fields = firstObject.getClass().getDeclaredFields();

                    for (Object obj : list) {
                        for (Field field : fields) {
                            field.setAccessible(true);
                            Object value = field.get(obj);
                            pdfTable.addCell(String.valueOf(value));
                        }
                    }
                }

                document.add(pdfTable);

                int thanhtien = tongtien;
                if (thanhtien != 0) {
                    Paragraph outLine= new Paragraph("-----------------------------------------------------------------------------------------------------------");
                    outLine.setAlignment(Element.ALIGN_CENTER);
                    document.add(outLine);
                    
                    
                    document.add(new Paragraph("Tong Tien : " + thanhtien));
                }
                document.add(new Paragraph("\n"));
                Paragraph tenTh = new Paragraph("Powered by Green Mart ");
                tenTh.setAlignment(Element.ALIGN_CENTER);
                document.add(tenTh);
                document.close();
//                System.out.println("Xuất File thàng công " + fileChooser);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
