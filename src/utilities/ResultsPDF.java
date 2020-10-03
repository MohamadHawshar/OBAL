/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import Controllers.AnalyseController;
import Entities.Analysis;
import Entities.Order;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

/**
 *
 * @author lenovo
 */
public class ResultsPDF {

    
    Order o;

    public ResultsPDF(Order o)  {
        this.o = o;
      
        
    }

    public void printTable(PdfPTable analysisTable) {

        analysisTable.addCell("Analysis");
        analysisTable.addCell("Results");
        analysisTable.addCell("Unit");       
        analysisTable.addCell("Ref. Value");
        
        
        for (Analysis list1 : o.getListOrders()) {
            for (int j = 0; j < 4; j++) {
                Analysis val = list1;
                String x = val.getResult() + "";
                if (j == 0) {
                    analysisTable.addCell(val.getName());
                }
                if (j == 1) {
                    analysisTable.addCell(x);
                }
                if (j == 2) {
                    analysisTable.addCell(val.getUnit());
                }
                if (j == 3) {
                    analysisTable.addCell(val.getValue());
                }
            }
        }
    }

    public void printResultsPDF() throws FileNotFoundException, DocumentException {
        System.out.println("PRINTRESULTT");
        String pdfName = o.getClient().getFirstName() + "_" + o.getClient().getLastName() + "_" + o.getDate() + "_Results";
        Document doc = new Document(PageSize.A4.rotate());
        PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("Bills PDF\\"
                + pdfName + ".pdf"));
        System.out.println("Printing pdf...");
        doc.open();

        Font fontTest = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL);

        Paragraph parag = new Paragraph();
        parag.add(new Paragraph("OBAL ANALYSIS LABORATORY - WWW.OBAL.LU \n\n",
                fontTest));

        parag.add(new Paragraph("Concerning order Nº" + o.getId() + "                      " + "On:" + o.getDate() + "\n \n", font2));
        parag.add(new Paragraph("Patient:           " + o.getClient().getId(), font2));
        parag.add(new Paragraph("                   " + o.getClient().getFirstName() + " " + o.getClient().getLastName(), font2));
        parag.add(new Paragraph("                   " + o.getClient().getLocation() + "\n \n", font2));
        parag.add(new Paragraph("Results Date:   " + LocalDate.now().toString() + "\n \n \n", font2));
        PdfPTable analysisTable = new PdfPTable(4);
        printTable(analysisTable);
        doc.add(parag);
        doc.add(analysisTable);
        doc.close();
    }


            
    
}
