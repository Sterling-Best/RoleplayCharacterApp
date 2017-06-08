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
            //Knowledge (Arcana)  - Class Skill
            setFieldName("Knowledge (Arcana)  - Class Skill", 49);
            //Knowledge (Dungeoneering)  - Class Skill
            setFieldName("Knowledge (Dungeoneering)  - Class Skill", 50);
            //Knowledge (Engineering)  - Class Skill
            setFieldName("Knowledge (Engineering)  - Class Skill", 51);
            //Knowledge (Geography)  - Class Skill
            setFieldName("Knowledge (Geography)  - Class Skill", 52);
            //Knowledge (History)  - Class Skill
            setFieldName("Knowledge (History)  - Class Skill", 53);
            //Knowledge (Local)  - Class Skill
            setFieldName("Knowledge (Local)  - Class Skill", 54);
            //Knowledge (Nature)  - Class Skill
            setFieldName("Knowledge (Nature)  - Class Skill", 55);
            //Knowledge (Nobility)  - Class Skill
            setFieldName("Knowledge (Nobility)  - Class Skill", 56);
            //Knowledge (Planes)  - Class Skill
            setFieldName("Knowledge (Planes)  - Class Skill", 57);
            //Knowledge (Religion)  - Class Skill
            setFieldName("Knowledge (Religion)  - Class Skill", 58);
            //Linguistics  - Class Skill
            setFieldName("Linguistics  - Class Skill", 59);
            //Perception  - Class Skill
            setFieldName("Perception  - Class Skill", 60);
            //Perform1  - Class Skill
            setFieldName("Perform1  - Class Skill", 61);
            //Perform2  - Class Skill
            setFieldName("Perform2  - Class Skill", 62);
            //Profession1  - Class Skill
            setFieldName("Profession1  - Class Skill", 63);
            //Profession2  - Class Skill
            setFieldName("Profession2  - Class Skill", 64);
            //Ride  - Class Skill
            setFieldName("Ride  - Class Skill", 65);
            //Sense Motive  - Class Skill
            setFieldName("Sense Motive - Class Skill", 66);
            //Sleight of Hand  - Class Skill
            setFieldName("Sleight of Hand  - Class Skill", 67);
            //Spellcraft  - Class Skill
            setFieldName("Spellcraft  - Class Skill", 68);
            //Stealth  - Class Skill
            setFieldName("Stealth - Class Skill", 69);
            //Survival  - Class Skill
            setFieldName("Survival - Class Skill", 70);
            //Swim  - Class Skill
            setFieldName("Swim - Class Skill", 71);
            //Use Magic Device - Class Skill
            setFieldName("Use Magic Device - Class Skill - Class Skill", 72);
            //Craft1 - Name
            setFieldName("Craft1 - Name", 73);
            //Craft2 - Name
            setFieldName("Craft2 - Name", 74);
            //Craft3 - Name
            setFieldName("Craft3 - Name", 75);
            //Perform1 - Name
            setFieldName("Perform1 - Name", 76);
            //Perform2 - Name
            setFieldName("Perform2 - Name", 77);
            //Profession1 - Name
            setFieldName("Profession1 - Name", 78);
            //Profession2 - Name
            setFieldName("Profession2 - Name", 79);
            //Acrobatics - Total Bonus
            setFieldName("Acrobatics - Total Bonus", 80);
            //Appraise - Total Bonus
            setFieldName("Appraise - Total Bonus", 81);
            //Bluff - Total Bonus
            setFieldName("Bluff - Total Bonus", 82);
            //Climb - Total Bonus
            setFieldName("Climb - Total Bonus", 83);
            //Craft1 - Total Bonus
            setFieldName("Craft1 - Total Bonus", 84);
            //Craft2 - Total Bonus
            setFieldName("Craft2 - Total Bonus", 85);
            //Craft3 - Total Bonus
            setFieldName("Craft3 - Total Bonus", 86);
            //Diplomacy - Total Bonus
            setFieldName("Diplomacy - Total Bonus", 87);
            //Disable Device - Total Bonus
            setFieldName("Disable Device - Total Bonus", 88);
            //Disguise - Total Bonus
            setFieldName("Disguise - Total Bonus", 89);
            //Escape Artist - Total Bonus
            setFieldName("Escape Artist - Total Bonus", 90);
            //Fly - Total Bonus
            setFieldName("Fly - Total Bonus", 91);
            //Handle Animal - Total Bonus
            setFieldName("Handle Animal - Total Bonus", 92);
            //Heal - Total Bonus
            setFieldName("Heal - Total Bonus", 93);
            //Intimidate - Total Bonus
            setFieldName("Intimidate - Total Bonus", 94);
            //Knowledge (Arcana) - Total Bonus
            setFieldName("Knowledge (Arcana) - Total Bonus", 95);
            //Knowledge (Dungeoneering) - Total Bonus
            setFieldName("Knowledge (Dungeoneering) - Total Bonus", 96);
            //Knowledge (Engineering) - Total Bonus
            setFieldName("Knowledge (Engineering) - Total Bonus", 97);
            //Knowledge (Geography) - Total Bonus
            setFieldName("Knowledge (Geography) - Total Bonus", 98);
            //Knowledge (History) - Total Bonus
            setFieldName("Knowledge (History) - Total Bonus", 99);
            //Knowledge (Local) - Total Bonus
            setFieldName("Knowledge (Local) - Total Bonus", 100);
            //Knowledge (Nature) - Total Bonus
            setFieldName("Knowledge (Nature) - Total Bonus", 101);
            //Knowledge (Nobility) - Total Bonus
            setFieldName("Knowledge (Nobility) - Total Bonus", 102);
            //Knowledge (Plants) - Total Bonus
            setFieldName("Knowledge (Plants) - Total Bonus", 103);
            //Knowledge (Religion) - Total Bonus
            setFieldName("Knowledge (Religion) - Total Bonus", 104);
            //Linguistics - Total Bonus
            setFieldName("Linguistics - Total Bonus", 105);
            //Perception - Total Bonus
            setFieldName("Perception - Total Bonus", 106);
            //Perform1 - Total Bonus
            setFieldName("Perform1 - Total Bonus", 107);
            //Perform2 - Total Bonus
            setFieldName("Perform2 - Total Bonus", 108);
            //Profession1 - Total Bonus
            setFieldName("Profession1 - Total Bonus", 109);
            //Profession2 - Total Bonus
            setFieldName("Profession2 - Total Bonus", 110);
            //Ride - Total Bonus
            setFieldName("Ride - Total Bonus", 111);
            //Sense Motive - Total Bonus
            setFieldName("Sense Motive - Total Bonus", 112);
            //Sleight of Hand - Total Bonus
            setFieldName("Sleight of Hand - Total Bonus", 113);
            //Spellcraft - Total Bonus
            setFieldName("Spellcraft - Total Bonus", 114);
            //Stealth - Total Bonus
            setFieldName("Stealth - Total Bonus", 115);
            //Survival - Total Bonus
            setFieldName("Survival - Total Bonus", 116);
            //Swim - Total Bonus
            setFieldName("Swim - Total Bonus", 117);
            //Use Magical Device - Total Bonus
            setFieldName("Use Magical Device - Total Bonus", 118);
            //\slot 119 is null type... reason unknown
            //Acrobatics - Ability Modifier
            setFieldName("Acrobatics - Ability Modifier", 120);
            //Appraise - Ability Modifier
            setFieldName("Appraise - Ability Modifier", 120);
            //Bluff - Ability Modifier
            setFieldName("Bluff - Ability Modifier", 120);
            //Climb - Ability Modifier
            setFieldName("Climb - Ability Modifier", 120);
            //Craft1 - Ability Modifier
            setFieldName("Craft1 - Ability Modifier", 120);
            //Craft2 - Ability Modifier
            setFieldName("Craft2 - Ability Modifier", 120);
            //Craft3 - Ability Modifier
            setFieldName("Craft3 - Ability Modifier", 120);
            //Diplomacy - Ability Modifier
            setFieldName("Diplomacy - Ability Modifier", 120);
            //Disable Device - Ability Modifier
            setFieldName("Disable Device - Ability Modifier", 120);
            //Disguise - Ability Modifier
            setFieldName("Disguise - Ability Modifier", 120);
            //Escape Artist - Ability Modifier
            setFieldName("Escape Artist - Ability Modifier", 120);
            //Fly - Ability Modifier
            setFieldName("Fly - Ability Modifier", 120);
            //Handle Animal - Ability Modifier
            setFieldName("Handle Animal - Ability Modifier", 120);
            //Heal - Ability Modifier
            setFieldName("Heal - Ability Modifier", 120);
            //Intimidate - Ability Modifier
            setFieldName("Intimidate - Ability Modifier", 120);
            //Knowledge (Arcana) - Ability Modifier
            setFieldName("Knowledge (Arcana) - Ability Modifier", 95);
            //Knowledge (Dungeoneering) - Ability Modifier
            setFieldName("Knowledge (Dungeoneering) - Ability Modifier", 96);
            //Knowledge (Engineering) - Ability Modifier
            setFieldName("Knowledge (Engineering) - Ability Modifier", 97);
            //Knowledge (Geography) - Ability Modifier
            setFieldName("Knowledge (Geography) - Ability Modifier", 98);
            //Knowledge (History) - Ability Modifier
            setFieldName("Knowledge (History) - Ability Modifier", 99);
            //Knowledge (Local) - Ability Modifier
            setFieldName("Knowledge (Local) - Ability Modifier", 100);
            //Knowledge (Nature) - Ability Modifier
            setFieldName("Knowledge (Nature) - Ability Modifier", 101);
            //Knowledge (Nobility) - Ability Modifier
            setFieldName("Knowledge (Nobility) - Ability Modifier", 102);
            //Knowledge (Plants) - Ability Modifier
            setFieldName("Knowledge (Plants) - Ability Modifier", 103);
            //Knowledge (Religion) - Ability Modifier
            setFieldName("Knowledge (Religion) - Ability Modifier", 104);
            //Linguistics - Ability Modifier
            setFieldName("Linguistics - Ability Modifier", 104);
            //Perception - Ability Modifier
            setFieldName("Perception - Ability Modifier", 104);
            //Perform1 - Ability Modifier
            setFieldName("Perform1 - Ability Modifier", 104);
            //Perform2 - Ability Modifier
            setFieldName("Perform2 - Ability Modifier", 104);
            //Profession1 - Ability Modifier
            setFieldName("Profession1 - Ability Modifier", 104);
            //Profession2 - Ability Modifier
            setFieldName("Profession2 - Ability Modifier", 104);
            //Ride - Ability Modifier
            setFieldName("Ride - Ability Modifier", 104);
            //Sense Motive - Ability Modifier
            setFieldName("Sense Motive - Ability Modifier", 104);
            //Test - Ability Modifier
            setFieldName("Test - Ability Modifier", 104);




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
            System.out.println(field.getFieldType() + " type");
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
