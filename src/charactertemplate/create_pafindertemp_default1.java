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
            setFieldName("Character Name", 0);
            //Set Alignment
            setFieldName("Alignment", 1);
            //Set Player
            setFieldName("Player", 2);
            //Character Level
            setFieldName("Character Level", 3);
            //Deity
            setFieldName("Deity", 4);
            //Homeland
            setFieldName("Homeland", 5);
            //Race
            setFieldName("Race", 6);
            //Size
            setFieldName("Size", 7);
            //Gender
            setFieldName("Gender", 8);
            //Age
            setFieldName("Age", 9);
            //Height
            setFieldName("Height", 10);
            //Test
            setFieldName("Weight", 11);
            //Hair
            setFieldName("Hair", 12);
            //Test
            setFieldName("Eyes", 13);
            //Armor Class - Natural Armor
            setFieldName("Armor Class - Natural Armor", 14);
            //Armor Class - Deflection Modifier
            setFieldName("Armor Class - Deflection Modifier", 15);
            //Max Hit Points
            setFieldName("Hit Points - Max", 16);
            //Damage Reduction
            setFieldName("Damage Reduction", 17);
            //Current Hit Points
            setFieldName("Hit Points - Current", 18);
            //NonLethal Damage
            setFieldName("NonLethal Damage", 19);
            //Armor Class - Total
            setFieldName("Armor Class - Total", 20);
            //Initiative - Total
            setFieldName("Initiative - Total", 21);
            //Armor Class - Armor Bonus
            setFieldName("Armor Class - Armor Bonus", 22);
            //Armor Class - Shield Bonus
            setFieldName("Armor Class - Shield Bonus", 23);
            //Armor Class - Dexterity Modifier
            setFieldName("Dexterity Modifier", 24);
            //Speed - Base
            setFieldName("Speed - Base", 25);
            //Speed - Temporary Modifier
            setFieldName("Speed - Temporary Modifier", 26);
            //Speed - Fly
            setFieldName("Speed - Fly", 27);
            //Speed - Swim
            setFieldName("Speed - Swim", 28);
            //Speed - Climb
            setFieldName("Speed - Climb", 29);
            //Speed - Burrow
            setFieldName("Speed - Burrow", 30);
            //Speed - With Armor
            setFieldName("Speed - With Armor", 31);
            //Armor Class - Touch
            setFieldName("Armor Class - Touch", 32);
            //Armor Class - Flat-Footed
            setFieldName("Armor Class - Flat-Footed", 33);
            //Climb - Class Skill
            setFieldName("Climb - Class Skill", 34);
            //Craft1 - Class Skill
            setFieldName("Craft1 - Class Skill", 35);
            //Craft2 - Class Skill
            setFieldName("Craft2 - Class Skill", 36);
            //Craft3 - Class Skill
            setFieldName("Craft3 - Class Skill", 37);
            //Acrobatics - Class Skill
            setFieldName("Acrobatics - Class Skill", 38);
            //Appraise - Class Skill
            setFieldName("Appraise - Class Skill", 39);
            //Bluff - Class Skill
            setFieldName("Buff - Class Skill", 40);
            //Diplomacy - Class Skill
            setFieldName("Diplomacy - Class Skill", 41);
            //Disable Device - Class Skill
            setFieldName("Disable Device - Class Skill", 42);
            //Disguise - Class Skill
            setFieldName("Disguise - Class Skill", 43);
            //Escape Artist - Class Skill
            setFieldName("Escape Artist - Class Skill", 44);
            //Fly - Class Skill
            setFieldName("Fly - Class Skill", 45);
            //Handle Animal - Class Skill
            setFieldName("Handle Animal - Class Skill", 46);
            //Heal - Class Skill
            setFieldName("Heal - Class Skill", 47);
            //Intimidate - Class Skill
            setFieldName("Intimidate - Class Skill", 48);

            //Test
            setFieldName("Test", 49);

            //----------------\\
            newtemp.save(this.directory + "\\data\\templates\\default_pathtemp1.pdf"); // save changes to another file
            newtemp.close();
        }catch (Exception e) {
            System.out.println(e);

        }
    }

    private void setFieldName(String fieldName, int fieldNum) throws IOException {
        try {
            Object obj = fieldList.get(fieldNum);
            PDField field = (PDField) obj;
            System.out.println(field.getAlternateFieldName() + " confirmed");
            field.setAlternateFieldName(fieldName);
            System.out.println(field.getAlternateFieldName() + " changed");
            if (field.getFieldType() == "Btn") {
                field.setValue("Yes");
            }else{
                field.setValue(fieldName);
            }
        }catch (Exception e) {
            System.out.println(e);

        }
    }
}
