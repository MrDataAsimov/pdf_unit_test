package se.innovation.document;

import com.itextpdf.text.DocumentException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class PdfCreatorTest {

    static final String path = "./target/document/pdf/";
    static final String PDF =  path + "hello_itext.pdf";

    @Test
    public void testPdfCreator() throws IOException, DocumentException {
        File file = new File(PDF);
        file.getParentFile().mkdirs();

        new PdfCreator().createPdf(PDF);

        File fileCreated = new File(PDF);

        assertTrue(fileCreated.exists());
    }
}
