
package Tester;
 
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.pdf.PdfWriter;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class Tab {
 
    public static final String DEST = "results/objects/tabs.pdf";
 
    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new Tab().createPdf(DEST);
    }
 
    public void createPdf(String dest) throws FileNotFoundException, DocumentException {
        Document document = new Document();
 
        PdfWriter.getInstance(document, new FileOutputStream(dest));
 
        document.open();
 
        Paragraph p = new Paragraph("Hello World.");
 
        document.add(p);
 
        p = new Paragraph();
        p.setTabSettings(new TabSettings(56f));
        p.add(Chunk.TABBING);
        p.add(new Chunk("Hello World with tab."));
 
        document.add(p);
 
        p = new Paragraph();
        p.add(new Chunk("Hello World with"));
        p.setTabSettings(new TabSettings(200f));
        p.add(Chunk.TABBING);
        p.add(new Chunk("an inline tab."));
        document.add(p);
               
        p = new Paragraph();
        p.add(new Chunk("H"));
        p.setTabSettings(new TabSettings(200f));
        p.add(Chunk.TABBING);
        p.add(new Chunk("an inline tab."));
 
        document.add(p);
 
        document.close();
    }
 
}