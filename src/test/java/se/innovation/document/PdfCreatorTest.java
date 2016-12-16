package se.innovation.document;

import com.itextpdf.text.DocumentException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
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

        Path path = Paths.get(PDF);

        String extractedText = extractPdfText(Files.readAllBytes(path));

        String searchField = "hell";
        Pattern pattern = Pattern.compile("hell");
        Matcher matcher = pattern.matcher(extractedText);

        assertEquals(false, matcher.matches());

        pattern = Pattern.compile("(\\bhello\\b)");
        matcher = pattern.matcher(extractedText);

        assertEquals(false, matcher.find());

        pattern = Pattern.compile("(\\bHello\\b)");
        matcher = pattern.matcher(extractedText);

        assertEquals(true, matcher.find());

        assertEquals("Hello", matcher.group(1));
    }

    private static String extractPdfText(byte[] pdfData) throws IOException {
        PDDocument pdfDocument = PDDocument.load(new ByteArrayInputStream(pdfData));
        try {
            return new PDFTextStripper().getText(pdfDocument);
        } finally {
            pdfDocument.close();
        }
    }

}
