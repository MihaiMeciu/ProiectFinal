package Client;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by Devene on 5/12/2016.
 */
public class Rezervare {
    private String cont;
    private String dataB;
    private String dataE;
    private Timestamp timp;

    public static void createDoc(String r){
        PDDocument doc = null;
        PDPage page = null;
        String[] date = r.split(",");
        try{
            doc = new PDDocument();
            page = new PDPage();
            doc.addPage(page);
            PDFont font = PDType1Font.TIMES_ROMAN;
            PDPageContentStream cont = new PDPageContentStream(doc,page);
            cont.beginText();
            cont.setFont(font,12);
            cont.moveTextPositionByAmount(20,100);
            cont.drawString("Rezervare:"+date[0]);
            cont.moveTextPositionByAmount(0,80);
            cont.drawString("Masina rezervata:"+date[2]+" "+date[3]);
            cont.moveTextPositionByAmount(0,60);
            cont.drawString("Client: "+date[0]+"  Email:"+date[1]);
            cont.moveTextPositionByAmount(0,40);
            cont.drawString("Data de inceput:"+date[4]+"   Data de sfarsit:"+date[5]+" .");
            cont.moveTextPositionByAmount(0,20);
            cont.drawString("Semnatura Client:                      Semnatura operator:             ");
            cont.endText();
            cont.close();
            doc.save(date[0]+date[3]+".pdf");
            doc.close();
        }catch(Exception e){

        }
    }
}
