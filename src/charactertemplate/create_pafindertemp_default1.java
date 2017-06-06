package charactertemplate;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Methlodis on 2017-06-06.
 */
public class create_pafindertemp_default1 {
    String directory = System.getProperty("user.dir");
    ArrayList<Object> fieldList = new ArrayList<Object>();

    public static void main(String[] args) throws IOException {
        create_pafindertemp_default1 a = new create_pafindertemp_default1();

        a.formatpdftemplate();
    }

    private void formatpdftemplate() throws IOException {
        System.out.println("");
        System.out.println("//------------------------------\\\\");
        File template = new File(this.directory + "\\data\\templates\\default_pathtemp1.pdf");
        PDDocument newtemp = PDDocument.load(template);
        System.out.println("Template Loaded");
        try {
            PDDocumentCatalog docCatalog = newtemp.getDocumentCatalog();
            PDAcroForm acroForm = docCatalog.getAcroForm();
            System.out.println("Fields Loaded");
            for (Object fieldObj : acroForm.getFields()) {
                PDField field = (PDField) fieldObj;
                fieldList.add(field);
                System.out.println(field.getAlternateFieldName() + " added to list"); // print field's name
            }
            //Set Character Name
            Object obj_alignment = fieldList.get(0);
            PDField field1 = (PDField) obj_alignment;
            System.out.println(field1.getAlternateFieldName() + " confirmed");
            field1.setAlternateFieldName("Character Name");
            System.out.println(field1.getAlternateFieldName() + " changed");
            field1.setValue("Character Name");
            //Set Alignment
            Object ob_player = fieldList.get(1);
            PDField field2 = (PDField) ob_player;
            System.out.println(field2.getAlternateFieldName() + " confirmed");
            field2.setAlternateFieldName("Alignment");
            System.out.println(field2.getAlternateFieldName() + " changed");
            field2.setValue("Alignment");
            //Set Player
            Object obj3 = fieldList.get(2);
            PDField field3 = (PDField) obj3;
            System.out.println(field3.getAlternateFieldName() + " confirmed");
            field3.setAlternateFieldName("Player");
            System.out.println(field3.getAlternateFieldName() + " changed");
            field3.setValue("Player");
            newtemp.save(this.directory + "\\data\\templates\\default_pathtemp1.pdf"); // save changes to another file
            newtemp.close();
        }catch (Exception e) {
            System.out.println(e);

        }
    }
}
