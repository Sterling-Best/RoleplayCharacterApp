package charactertemplate;

import java.nio.file.Paths;
import java.util.Arrays;

import java.io.File;
import java.nio.file.*;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


/**
 * Character Template Representation
 *
 * Extracts data from selected spreadsheet and applies to variables. The prints character info in a text format.
 *
 * Using JExcelAPI for excel document manipulation.
 * https://sourceforge.net/projects/jexcelapi/?source=navbar
 * JExcelAPI documentation: http://jexcelapi.sourceforge.net/resources/javadocs/2_6_10/docs/index.html
 */

public class charactertemplate {

    // Character
    public String playerName;
    public String characterName;

    //Roleplay details
    public String alignment;
    public String race;
    String size;
    String gender;
    int age;
    int weight;
    String hair;
    String deity;
    String homeland;

    //Lvl EXP
    int experience;
    int totalLevel;
    String[] classes = {};
    int[] classlvl = {};

    // Ability Stats
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;

    // Ability Modifiers
    int strModifier;
    int dexModifier;
    int conModifier;
    int intModifier;
    int wisModifier;
    int charModifier;

    //Combat
    int initiative;
    int maxHitPoints;
    String[] damred;
    int armorClass;
    int touchArmorClass;
    int flatFootedArmorClass;
    int baseAttackBonus;
    int sizeAttackModifier;
    int meleeAttackBonus;
    int rangeAttackBonus;
    int spellResistance;
    int cmBonus;
    int cmDefense;

    //Saving throws
    int sav_fort;
    int sav_ref;
    int sav_wil;

    //Speed
    int basespeed;

    //Skills
    //Boolean with CS represents class skills, bonus +3.
    boolean cs_acrobatics = false;
    int acrobatics = 0;
    boolean cs_appriase = false;
    int appraise = 0;
    boolean cs_bluff = false;
    int bluff = 0;
    boolean cs_climb = false;
    int climb = 0;
    boolean cs_craft = false;
    int craft = 0;
    boolean cs_diplomacy = false;
    int diplomacy = 0;
    boolean cs_disableDevice = false;
    int disableDevice = 0;
    boolean cs_disguise = false;
    int disguise = 0;
    boolean cs_escapeArtist = false;
    int escapeArtist = 0;
    boolean cs_fly = false;
    int fly = 0;
    boolean cs_handleAnimal = false;
    int handleAnimal = 0;
    boolean cs_heal = false;
    int heal = 0;
    boolean cs_intimidate = false;
    int intimidate = 0;
    boolean cs_arcaneknw = false;
    int arcaneknw = 0;
    boolean cs_dungknw = false;
    int dungknw = 0;
    boolean cs_engknw = false;
    int engknw = 0;
    boolean cs_hisknw= false;
    int hisknw = 0;
    boolean cs_locknw = false;
    int locknw = 0;
    boolean cs_nobknw = false;
    int nobknw = 0;
    boolean cs_planknw = false;
    int planknw = 0;
    boolean cs_relknw = false;
    int relknw = 0;
    boolean cs_linguistics = false;
    int linguistics = 0;
    boolean cs_perception = false;
    int perception = 0;
    boolean cs_perform = false;
    int perform = 0;
    boolean cs_ride = false;
    int ride = 0;
    boolean cs_senmot = false;
    int senmot = 0;
    boolean cs_slghthnd = false;
    int slghthnd = 0;
    boolean cs_spllcrft = false;
    int splcrft = 0;
    boolean cs_stealth = false;
    int stealth = 0;
    boolean cs_survival = false;
    int survival = 0;
    boolean cs_swim = false;
    int swim = 0;
    boolean cs_umd = false;
    int umd = 0;

    //Languages
    String[] languages = {"Common"};

    //==========================================================\\
    //Stat's Plain Text Print Strings\\
    //Plain text variables begin with pt_

    //Plaint Text Stats/Info Variables
    //Names
    private String pt_playerName;
    private String pt_characterName;
    //Roleplay
    private String pt_alignment;
    private String pt_race;
    private String pt_size;
    private String pt_gender;
    private String pt_age;
    private String pt_weight;
    private String pt_hair;
    private String pt_deity;
    private String pt_homeland;
    //Level/Exp/Class(es)
    private String pt_experience;
    private String pt_totalLevel;
    //Ability Stats
    private String pt_strength;
    private String pt_dexterity;
    private String pt_constitution;
    private String pt_intelligence;
    private String pt_wisdom;
    private String pt_charisma;
    //Ability Modifiers
    private String pt_strModifier;
    private String pt_dexModifier;
    private String pt_conModifier;
    private String pt_intModifier;
    private String pt_wisModifier;
    private String pt_chaModifier;
    //Combat Stats
    private String pt_initiative;
    private String pt_maxHitPoints;
    private String pt_damageResistence;
    private String pt_armorClass;
    private String pt_touchArmorClass;
    private String pt_flatFootedArmorClass;
    private String pt_baseAttackBonus;
    private String pt_sizeAttackModifier;
    private String pt_meleeAttackBonus;
    private String pt_rangeAttackBonus;
    private String pt_spellResistance;
    private String pt_cmBonus;
    private String pt_cmDefense;
    //Skills
    private String pt_acrobatics;
    private String pt_appraise;
    private String pt_bluff;
    private String pt_climb;
    private String pt_craft;
    private String pt_diplomacy;
    private String pt_disableDevice;
    private String pt_disguise;
    private String pt_escapeArtist;
    private String pt_fly;
    private String pt_handleAnimal;
    private String pt_heal;
    //Todo: Finish Skills




    ////Code Variables\\\\-
    String inputFile;
    String directory = System.getProperty("user.dir");
    String workingDir;

    public charactertemplate() {
    }

    public static void main(String[] args) throws IOException {
        charactertemplate a = new charactertemplate();
        a.setInputFile(a.directory + "\\data\\characterdata.xls");
        a.extractdata("#1");
        a.updateAllVar();
        a.print();
        a.createplaintextpdftemplate();
    }

    //====================\\
    //Update Variables\\

    private void updateAllVar(){
        updatePlainTextVar();
    }

    private void updatePlainTextVar(){
        //Names
        pt_playerName = playerName;
        pt_characterName = "---" + characterName + "---";
        //Roleplay
        pt_alignment = "Alignment: " + alignment;
        pt_race = "Race: " + race;
        pt_size = "Size: " + size;
        pt_gender = "Gender: " + gender;
        pt_age = "Age: " + age;
        pt_weight = "Weight: " + weight + " lbs";
        pt_hair = "Hair: " + hair;
        pt_deity = "Deity: " + deity;
        pt_homeland = "Homeland: " + homeland;
        //Level/Exp/Class(es)
        pt_experience = "Experience: " + experience;
        pt_totalLevel = "Level: " + totalLevel;
        //Todo: Classes and class levels go here
        //Ability Stats
        pt_strength = "Strength: " + strength;
        pt_dexterity = "Dexterity: " + dexterity;
        pt_constitution = "Constitution: " + constitution;
        pt_intelligence = "Intelligence: " + intelligence;
        pt_wisdom = "Wisdom: " + wisdom;
        pt_charisma = "Charisma: " + charisma;
        //Ability Modifiers
        pt_strModifier = "Strength Modifier: " + checkmodprops(strModifier);
        pt_dexModifier = "Dexterity Modifier: " + checkmodprops(dexModifier);
        pt_conModifier = "Constitution Modifier: " + checkmodprops(conModifier);
        pt_intModifier = "Intelligence Modifier: " + checkmodprops(intModifier);
        pt_wisModifier = "Wisdom Modifier: " + checkmodprops(wisModifier);
        pt_chaModifier = "Charisma Modifier: " + checkmodprops(charModifier);
        //Combat Stats
        pt_initiative = "Initiative: " + initiative;
        pt_maxHitPoints = "Max Hit-Points: " + maxHitPoints;
        //Todo: Damage Resistence List Goes here
        pt_armorClass = "Armor Class: " + armorClass;
        pt_touchArmorClass = "Touch Armor Class: " + touchArmorClass;
        pt_flatFootedArmorClass = "Flat Footed Armor Class: " + flatFootedArmorClass;
        pt_baseAttackBonus = "Base Attack Bonus: " + baseAttackBonus;
        pt_sizeAttackModifier = "Size Attack Modifier: " + sizeAttackModifier;
        pt_meleeAttackBonus = "Melee Attack Bonus: " + meleeAttackBonus;
        pt_rangeAttackBonus = "Range Attack Bonus: " + rangeAttackBonus;
        pt_spellResistance = "Spell Resistance: " + spellResistance;
        pt_cmBonus = "Combat Maneuvering Bonus: " + cmBonus;
        pt_cmDefense = "Combat Maneuvering Defense: " + cmDefense;
        //Skills
        pt_acrobatics = "(DEX) Acrobatics: " + acrobatics + " (Class Skill: " + classskillcheck(cs_acrobatics) + ")";
        pt_appraise = "(INT) Appraise: " + appraise + " (Class Skill: " + classskillcheck(cs_appriase) + ")";
        pt_bluff = "(CHA) Bluff: " + bluff + " (Class Skill: " + classskillcheck(cs_bluff) + ")";
        pt_climb = "(STR) Climb: " + climb + " (Class Skill: " + classskillcheck(cs_climb) + ")";
        pt_craft = "(INT) Craft: " + craft + " (Class Skill: " + classskillcheck(cs_craft) + ")";
        pt_diplomacy = "(CHA) Diplomacy: " + diplomacy + " (Class Skill: " + classskillcheck(cs_diplomacy) + ")";
        pt_disableDevice = "(DEX) Disable Device: " + disableDevice + " (Class Skill: " + classskillcheck(cs_disableDevice) + ")";
        pt_disguise = "(CHA) Disguise: " + disguise + " (Class Skill: " + classskillcheck(cs_disguise) + ")";
        pt_escapeArtist = "(DEX) Escape Artist: " + escapeArtist + " (Class Skill: " + classskillcheck(cs_escapeArtist) + ")";
        pt_fly = "(DEX) Fly: " + fly + " (Class Skill: " + classskillcheck(cs_fly) + ")";
        pt_handleAnimal = "(CHA) Handle Animal: " + handleAnimal + " (Class Skill: " + classskillcheck(cs_handleAnimal) + ")";
        pt_heal = "(WIS) Heal: " + heal + " (Class Skill: " + classskillcheck(cs_heal) + ")";
        //Todo: Finish Skills

    }

    //Stat Format Methods

    //Adds a '+' to the Modfier, if its a positive number
    private String checkmodprops(int abilitystat){
        if (abilitystat >= 0){
            return "+" + abilitystat;
        }else{
            return Integer.toString(abilitystat);
        }

    }

    //Class Skills, True = Yes, False = No
    private String classskillcheck(boolean csboolean){
        if (csboolean){
            return "Yes";
        }else{
            return "No";
        }
    }

    //====================\\


    //====================\\
    //--Read Character from Spreadsheet--\\

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void extractdata(String charid) throws IOException  {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            Cell targetid = sheet.findCell(charid);
            int targetrow = targetid.getRow();
            //Character
            this.playerName = assignstring(sheet, 1, targetrow);
            this.characterName = assignstring(sheet, 2, targetrow);
            //Roleplay Details
            this.alignment = assignstring(sheet, 3, targetrow);
            this.race = assignstring(sheet, 4, targetrow);
            this.size = assignstring(sheet, 5, targetrow);
            this.gender = assignstring(sheet, 6, targetrow);
            this.age = assignint(sheet, 7, targetrow);
            this.weight = assignint(sheet, 8, targetrow);
            this.hair = assignstring(sheet, 9, targetrow);
            this.deity = assignstring(sheet, 10, targetrow);
            this.homeland = assignstring(sheet, 11, targetrow);
            //Lvl-Class-Exp
            this.experience = assignint(sheet, 12, targetrow);
            this.totalLevel = assignint(sheet, 13, targetrow);
            //Need to add classes
            //need to add class levels
            //Ability Stats
            this.strength = assignint(sheet, 15, targetrow);
            this.dexterity = assignint(sheet, 16, targetrow);
            this.constitution = assignint(sheet, 17, targetrow);
            this.intelligence = assignint(sheet, 18, targetrow);
            this.wisdom = assignint(sheet, 19, targetrow);
            this.charisma = assignint(sheet, 20, targetrow);
            //Ability Modifiers
            this.strModifier = assignint(sheet, 21, targetrow);
            this.dexModifier = assignint(sheet, 22, targetrow);
            this.conModifier = assignint(sheet, 23, targetrow);
            this.intModifier = assignint(sheet, 24, targetrow);
            this.wisModifier = assignint(sheet, 25, targetrow);
            this.charModifier = assignint(sheet, 26, targetrow);
            //Combat
            this.initiative = assignint(sheet, 27, targetrow);
            this.maxHitPoints = assignint(sheet, 28, targetrow);
            this.armorClass = assignint(sheet, 29, targetrow);
            this.touchArmorClass = assignint(sheet, 30, targetrow);
            this.flatFootedArmorClass = assignint(sheet, 31, targetrow);
            this.baseAttackBonus = assignint(sheet, 32, targetrow);
            this.sizeAttackModifier = assignint(sheet, 33, targetrow);
            this.meleeAttackBonus = assignint(sheet, 34, targetrow);
            this.rangeAttackBonus = assignint(sheet, 35, targetrow);
            this.spellResistance = assignint(sheet, 36, targetrow);
            this.cmBonus = assignint(sheet, 37, targetrow);
            this.cmDefense = assignint(sheet, 38, targetrow);
            //Saving Throw
            this.sav_fort = assignint(sheet, 39, targetrow);
            this.sav_ref = assignint(sheet, 40, targetrow);
            this.sav_wil = assignint(sheet, 41, targetrow);
            //Speed Stats
            this.basespeed = assignint(sheet, 42, targetrow);

            //----------\\
            //Update other variables;
            //Plain Text Strings


        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    private String assignstring(Sheet target, int col, int row){
        Cell cell = target.getCell(col, row);
        return cell.getContents();
    }

    private int assignint(Sheet target, int col, int row){
        Cell cell = target.getCell(col, row);
        String contents  = cell.getContents();
        return Integer.parseInt(contents);
    }
    //====================\\

    //====================\\
    //--Printing Functions--\\
    //To display stats of object

    public void print() {
        printnames();
        printroleplay();
        printlvlexp();
        printabilstats();
        printcombat();
        printsavingthrows();
        printspeedstats();
        printskillstats();
    }

    private void printnames() {
        System.out.println(playerName);
        System.out.println( "--" + characterName + "--");
        System.out.println("");
    }

    private void printroleplay() {
        System.out.println( "//Roleplay\\\\");
        System.out.println("Alignment: " + alignment);
        System.out.println("Race: " + race);
        System.out.println("Size: " + size);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight + " lbs");
        System.out.println("Hair: " + hair);
        System.out.println("Diety: " + deity);
        System.out.println("Homeland: " + homeland);
        System.out.println("");
    }

    private void printlvlexp() {
        System.out.println("//Level/Exp/Class\\\\");
        System.out.println("Experience: " + experience);
        System.out.println("Level: " + totalLevel);
        for (String cl: classes){
            int index = Arrays.asList(classes).indexOf(cl);
            System.out.println("Class: " + cl + " (" + classlvl[index] + ")");
        }
        System.out.println("");
    }

    private void printabilstats() {
        System.out.println("//Ability Stats\\\\");
        System.out.println("Strength: " + strength);
        if (strModifier >= 0) {
            System.out.println("Strength Modifier: +" + strModifier);
        }else{
            System.out.println("Strength Modifier: " + strModifier);
        }
        System.out.println("Dexterity: " + dexterity);
        if (dexModifier >= 0) {
            System.out.println("Dexterity Modifier: +" + dexModifier);
        }else{
            System.out.println("Dexterity Modifier: " + strModifier);
        }
        System.out.println("Constitution: " + constitution);
        if (dexModifier >= 0) {
            System.out.println("Constitution Modifier: +" + conModifier);
        }else{
            System.out.println("Constitution Modifier: " + conModifier);
        }
        System.out.println("Intelligence: " + intelligence);
        if (dexModifier >= 0) {
            System.out.println("Intelligence Modifier: +" + intModifier);
        }else{
            System.out.println("Intelligence Modifier: " + intModifier);
        }
        System.out.println("Wisdom: " + wisdom);
        if (dexModifier >= 0) {
            System.out.println("Wisdom Modifier: +" + wisModifier);
        }else{
            System.out.println("Wisdom Modifier: " + wisModifier);
        }
        System.out.println("Charisma: " + charisma);
        if (dexModifier >= 0) {
            System.out.println("Charisma Modifier: +" + charModifier);
        }else{
            System.out.println("Charisma Modifier: " + charModifier);
        }
        System.out.println("");
    }

    private void printcombat() {
        System.out.println("//Combat Stats\\\\");
        System.out.println("Initiative: " + initiative);
        System.out.println("Hit Points: " + maxHitPoints);
        System.out.println("-Armor Class-");
        System.out.println("Armor Class: " + armorClass);
        System.out.println("Touch Armor Class: " + touchArmorClass);
        System.out.println("Flat Footed Armor Class: +" + flatFootedArmorClass);
        System.out.println("-Damage Bonus-");
        System.out.println("Base Damage Bonus: " + baseAttackBonus);
        System.out.println("Size Modifier: " + sizeAttackModifier);
        System.out.println("Melee Damage Bonus: " + meleeAttackBonus);
        System.out.println("Range Damage Bonus: " + rangeAttackBonus);
        System.out.println("-Resistence-");
        System.out.println("Spell Resistence: " + spellResistance);
        System.out.println("-Combat Maneuvers-");
        System.out.println("Combat Maneuver Bonus: " + cmBonus);
        System.out.println("Combat Maneuver Defense: " + cmDefense);
        System.out.println("");
    }

    private void printsavingthrows() {
        System.out.println("//Saving Throws\\\\");
        System.out.println("Fortitude Save (Con): " + sav_fort);
        System.out.println("Reflex Save (Dex): " + sav_ref);
        System.out.println("Will Save (Wil): " + sav_wil);
        System.out.println("");
    }

    private void printspeedstats() {
        System.out.println("//Speed Stats\\\\");
        System.out.println("Base Speed: " + basespeed);
        System.out.println("");
    }

    private void printskillstats() {
        System.out.println("//Skill Stats\\\\");
        System.out.println("Acrobatics: " + acrobatics + " (Class Skill: " + classskillcheck(cs_acrobatics) + ")");
        System.out.println("Appraise: " + appraise + " (Class Skill: " + classskillcheck(cs_appriase) + ")");
        System.out.println("Bluff: " + bluff + " (Class Skill: " + classskillcheck(cs_bluff) + ")");
        System.out.println("Climb: " + climb + " (Class Skill: " + classskillcheck(cs_climb) + ")");
        System.out.println("Craft: " + craft + " (Class Skill: " + classskillcheck(cs_craft) + ")");
        System.out.println("Diplomacy: " + diplomacy + " (Class Skill: " + classskillcheck(cs_diplomacy) + ")");
        System.out.println("Disable Device: " + disableDevice + " (Class Skill: " + classskillcheck(cs_disableDevice) + ")");
        System.out.println("Disguise: " + disguise + " (Class Skill: " + classskillcheck(cs_disguise) + ")");
        System.out.println("Escape Artist: " + escapeArtist + " (Class Skill: " + classskillcheck(cs_escapeArtist) + ")");
        System.out.println("Fly: " + fly + " (Class Skill: " + classskillcheck(cs_fly) + ")");
        System.out.println("Handle Animal: " + handleAnimal + " (Class Skill: " + classskillcheck(cs_handleAnimal) + ")");
        System.out.println("Heal: " + heal + " (Class Skill: " + classskillcheck(cs_heal) + ")");
    }

    //====================\\


    //====================\\
    //--Import to PDF--\\

    //Plain Text PDF\\
    private void createplaintextpdftemplate() throws IOException {
        System.out.println("");
        System.out.println("//------------------------------\\\\");
        PDDocument plainTextTemp;
        PDPage newPage;
        PDPage statsPage;
        PDPageContentStream statsStream;
        try {
            System.out.println("Creating Plain Text PDF");
            plainTextTemp = new PDDocument();
            System.out.println("-New Document Specified");
            newPage = new PDPage();
            System.out.println("-New Page Specified");
            plainTextTemp.addPage(newPage);
            statsPage = plainTextTemp.getPage(0);
            System.out.println("-Added New Page to Document");
            statsStream = new PDPageContentStream(plainTextTemp, statsPage);
            System.out.println("-Start Writing Process");

            //Start Writing Header
            statsStream.beginText();
            System.out.println("-Start Writing Header");
            statsStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            statsStream.setLeading(14.5f);
            statsStream.newLineAtOffset(25, 750);
            System.out.println("-Set Header Specifications");

            //Names
            statsStream.showText(pt_playerName);
            statsStream.newLine();
            statsStream.showText(pt_characterName);
            statsStream.newLine();
            statsStream.newLine();
            System.out.println("-Wrote Names");

            //Finish Header
            statsStream.endText();
            System.out.println("-Finish Header");

            //Next Line, Stats Column
            statsStream.beginText();
            System.out.println("-Start Writing Stats Column");
            statsStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            statsStream.setLeading(14.5f);
            statsStream.newLineAtOffset(25, 700);
            System.out.println("-Set Stats Column Specifications");

            //Roleplay
            statsStream.showText("//Roleplay\\\\");
            statsStream.newLine();
            statsStream.showText(pt_alignment);
            statsStream.newLine();
            statsStream.showText(pt_race);
            statsStream.newLine();
            statsStream.showText(pt_size);
            statsStream.newLine();
            statsStream.showText(pt_gender);
            statsStream.newLine();
            statsStream.showText(pt_age);
            statsStream.newLine();
            statsStream.showText(pt_weight);
            statsStream.newLine();
            statsStream.showText(pt_hair);
            statsStream.newLine();
            statsStream.showText(pt_deity);
            statsStream.newLine();
            statsStream.showText(pt_homeland);
            statsStream.newLine();
            statsStream.newLine();
            System.out.println("-Wrote Roleplay Details");

            //Level/EXP/Class(es)\\
            statsStream.showText("//Level / Experience / Class(es)\\\\");
            statsStream.newLine();
            statsStream.showText(pt_experience);
            statsStream.newLine();
            statsStream.showText(pt_totalLevel);
            statsStream.newLine();
            //Todo: Need classes and class levels
            statsStream.newLine();

            //Ability Stats\\
            statsStream.showText("//Ability Stats\\\\");
            statsStream.newLine();
            statsStream.showText(pt_strength);
            statsStream.newLine();
            statsStream.showText(pt_strModifier);
            statsStream.newLine();
            statsStream.showText(pt_dexterity);
            statsStream.newLine();
            statsStream.showText(pt_dexModifier);
            statsStream.newLine();
            statsStream.showText(pt_constitution);
            statsStream.newLine();
            statsStream.showText(pt_conModifier);
            statsStream.newLine();
            statsStream.showText(pt_intelligence);
            statsStream.newLine();
            statsStream.showText(pt_intModifier);
            statsStream.newLine();
            statsStream.showText(pt_wisdom);
            statsStream.newLine();
            statsStream.showText(pt_wisModifier);
            statsStream.newLine();
            statsStream.showText(pt_charisma);
            statsStream.newLine();
            statsStream.showText(pt_chaModifier);
            statsStream.newLine();
            statsStream.newLine();

            //Combat Stats\\
            statsStream.showText("//Combat Stats\\\\");
            statsStream.showText(pt_initiative);
            statsStream.newLine();
            statsStream.showText(pt_maxHitPoints);
            statsStream.newLine();
            //Todo: Damage Resistence Goes Here
            statsStream.showText(pt_armorClass);
            statsStream.newLine();
            statsStream.showText(pt_touchArmorClass);
            statsStream.newLine();
            statsStream.showText(pt_flatFootedArmorClass);
            statsStream.newLine();
            statsStream.showText(pt_baseAttackBonus);
            statsStream.newLine();
            statsStream.showText(pt_sizeAttackModifier);
            statsStream.newLine();
            statsStream.showText(pt_meleeAttackBonus);
            statsStream.newLine();
            statsStream.showText(pt_rangeAttackBonus);
            statsStream.newLine();
            statsStream.showText(pt_spellResistance);
            statsStream.newLine();
            statsStream.showText(pt_cmBonus);
            statsStream.newLine();
            statsStream.showText(pt_cmDefense);
            statsStream.newLine();
            statsStream.newLine();

            //Finish Stats Column
            statsStream.endText();

            //Start Skills Column
            statsStream.beginText();
            System.out.println("-Start Writing Header");
            statsStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            statsStream.setLeading(14.5f);
            statsStream.newLineAtOffset(250, 700);
            System.out.println("-Set Header Specifications");

            //Skills
            statsStream.showText("//Skills\\\\");
            statsStream.newLine();
            statsStream.showText(pt_acrobatics);
            statsStream.newLine();
            statsStream.showText(pt_appraise);
            statsStream.newLine();
            statsStream.showText(pt_bluff);
            statsStream.newLine();
            statsStream.showText(pt_climb);
            statsStream.newLine();
            statsStream.showText(pt_craft);
            statsStream.newLine();
            statsStream.showText(pt_diplomacy);
            statsStream.newLine();
            statsStream.showText(pt_disableDevice);
            statsStream.newLine();
            statsStream.showText(pt_disguise);
            statsStream.newLine();
            statsStream.showText(pt_escapeArtist);
            statsStream.newLine();
            statsStream.showText(pt_fly);
            statsStream.newLine();
            statsStream.showText(pt_handleAnimal);
            statsStream.newLine();
            statsStream.showText(pt_heal);
            statsStream.newLine();
            //Todo: Finish Skills
            statsStream.newLine();


            //Finish Skills Column
            statsStream.endText();

            //Close Editing
            System.out.println("-Finished Writing");
            statsStream.close();
            System.out.println("-Closed Writer");
            plainTextTemp.save(this.directory + "\\output\\pdfs\\new.pdf");
            System.out.println("Document Created");
            plainTextTemp.close();
            System.out.println("//------------------------------\\\\");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    //====================\\
}
