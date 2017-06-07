package charactertemplate;

import java.util.Arrays;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;


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
    int savThrowFortitude;
    int savThrowReflex;
    int savThrowWisdom;

    //Speed
    int baseSpeed;

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
    boolean cs_knowledgeArcana = false;
    int knowledgeArcana = 0;
    boolean cs_knowledgeDungeoneering = false;
    int knowledgeDungeoneering = 0;
    boolean cs_knowledgeEngineering = false;
    int knowledgeEngineering = 0;
    boolean cs_knowledgeGeography = false;
    int knowledgeGeography = 0;
    boolean cs_knowledgeHistory = false;
    int knowledgeHistory = 0;
    boolean cs_knowledgeLocal = false;
    int knowledgeLocal = 0;
    boolean cs_knowledgeNature = false;
    int knowledgeNature = 0;
    boolean cs_knowledgeNobility = false;
    int knowledgeNobility = 0;
    boolean cs_knowledgePlanes = false;
    int knowledgePlanes = 0;
    boolean cs_knowledgeReligion = false;
    int knowledgeReligion = 0;
    boolean cs_linguistics = false;
    int linguistics = 0;
    boolean cs_perception = false;
    int perception = 0;
    boolean cs_perform = false;
    int perform = 0;
    boolean cs_profession = false;
    int profession = 0;
    boolean cs_ride = false;
    int ride = 0;
    boolean cs_senseMotive = false;
    int senseMotive = 0;
    boolean cs_slieghtOfHand = false;
    int slieghtOfHand = 0;
    boolean cs_spellcraft = false;
    int spelllcraft = 0;
    boolean cs_stealth = false;
    int stealth = 0;
    boolean cs_survival = false;
    int survival = 0;
    boolean cs_swim = false;
    int swim = 0;
    boolean cs_useMagicDevice = false;
    int useMagicDevice = 0;

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
    //Saving Throws
    private String pt_savThrowFortitude;
    private String pt_savThrowReflex;
    private String pt_savThrowWisdom;
    //Speed
    private String pt_baseSpeed;
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
    private String pt_intimidate;
    private String pt_knowledgeArcana;
    private String pt_knowledgeDungeoneering;
    private String pt_knowledgeEngineering;
    private String pt_knowledgeGeography;
    private String pt_knowledgeHistory;
    private String pt_knowledgeLocal;
    private String pt_knowledgeNature;
    private String pt_knowledgeNobility;
    private String pt_knowledgePlanes;
    private String pt_knowledgeReligion;
    private String pt_linguistics;
    private String pt_perception;
    private String pt_perform;
    private String pt_profession;
    private String pt_ride;
    private String pt_senseMotive;
    private String pt_sleightOfHand;
    private String pt_spellcraft;
    private String pt_stealth;
    private String pt_survival;
    private String pt_swim;
    private String pt_useMagicalDevice;

    //====================\\

    ////Code Variables\\\\-
    String inputFile;
    String directory = System.getProperty("user.dir");

    public charactertemplate() {
    }

    public static void main(String[] args) throws IOException {
        charactertemplate a = new charactertemplate();
        a.setInputFile(a.directory + "\\data\\characterdata.xls");
        a.extractdata("#1");
        a.updateAllVar();
        a.print();
        a.createplaintextpdftemplate();
        a.createpathfindertemppdf();
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
        //Saving Throws
        pt_savThrowFortitude = "Fortitude Save (Con): " + savThrowFortitude;
        pt_savThrowReflex = "Reflex Save (Dex): " + savThrowReflex;
        pt_savThrowWisdom = "Will Save (Wis): " + savThrowWisdom;
        //Speed
        pt_baseSpeed = "Base Speed: " + baseSpeed;
        //Skills
        pt_acrobatics = "(DEX) Acrobatics: " + acrobatics + " (Class Skill: " + classskillcheck(cs_acrobatics) + ")";
        pt_appraise = "(INT) Appraise: " + appraise + " (Class Skill: " + classskillcheck(cs_appriase) + ")";
        pt_bluff = "(CHA) Bluff: " + bluff + " (Class Skill: " + classskillcheck(cs_bluff) + ")";
        pt_climb = "(STR) Climb: " + climb + " (Class Skill: " + classskillcheck(cs_climb) + ")";
        pt_craft = "(INT) Craft: " + craft + " (Class Skill: " + classskillcheck(cs_craft) + ")";
        pt_diplomacy = "(CHA) Diplomacy: " + diplomacy + " (Class Skill: " + classskillcheck(cs_diplomacy) + ")";
        pt_disableDevice = "(DEX) Disable Device*: " + disableDevice + " (Class Skill: " + classskillcheck(cs_disableDevice) + ")";
        pt_disguise = "(CHA) Disguise: " + disguise + " (Class Skill: " + classskillcheck(cs_disguise) + ")";
        pt_escapeArtist = "(DEX) Escape Artist: " + escapeArtist + " (Class Skill: " + classskillcheck(cs_escapeArtist) + ")";
        pt_fly = "(DEX) Fly: " + fly + " (Class Skill: " + classskillcheck(cs_fly) + ")";
        pt_handleAnimal = "(CHA) Handle Animal*: " + handleAnimal + " (Class Skill: " + classskillcheck(cs_handleAnimal) + ")";
        pt_heal = "(WIS) Heal: " + heal + " (Class Skill: " + classskillcheck(cs_heal) + ")";
        pt_intimidate = "(CHA) Intimidate: " + intimidate + " (Class Skill: " + classskillcheck(cs_intimidate) + ")";
        pt_knowledgeArcana = "(INT) Knowledge (Arcana)*: " + knowledgeArcana + " (Class Skill: " + classskillcheck(cs_knowledgeArcana) + ")";
        pt_knowledgeDungeoneering = "(INT) Knowledge (Dungeoneering)*: " + knowledgeDungeoneering + " (Class Skill: " + classskillcheck(cs_knowledgeDungeoneering) + ")";
        pt_knowledgeEngineering = "(INT) Knowledge (Engineering)*: " + knowledgeEngineering + " (Class Skill: " + classskillcheck(cs_knowledgeEngineering) + ")";
        pt_knowledgeGeography = "(INT) Knowledge (Geography)*: " + knowledgeGeography + " (Class Skill: " + classskillcheck(cs_knowledgeGeography) + ")";
        pt_knowledgeHistory = "(INT) Knowledge (History)*: " + knowledgeHistory + " (Class Skill: " + classskillcheck(cs_knowledgeHistory) + ")";
        pt_knowledgeLocal = "(INT) Knowledge (Local)*: " + knowledgeLocal + " (Class Skill: " + classskillcheck(cs_knowledgeLocal) + ")";
        pt_knowledgeNature = "(INT) Knowledge (Nature)*: " + knowledgeNature + " (Class Skill: " + classskillcheck(cs_knowledgeNature) + ")";
        pt_knowledgeNobility = "(INT) Knowledge (Nobility)*: " + knowledgeNobility + " (Class Skill: " + classskillcheck(cs_knowledgeNobility) + ")";
        pt_knowledgePlanes = "(INT) Knowledge (Planes)*: " + knowledgePlanes + " (Class Skill: " + classskillcheck(cs_knowledgePlanes) + ")";
        pt_knowledgeReligion = "(INT) Knowledge (Religion)*: " + knowledgeReligion + " (Class Skill: " + classskillcheck(cs_knowledgeReligion) + ")";
        pt_linguistics = "(INT) Linguistics*: " + linguistics + " (Class Skill: " + classskillcheck(cs_linguistics) + ")";
        pt_perception = "(WIS) Perception: " + perception + " (Class Skill: " + classskillcheck(cs_perception) + ")";
        pt_perform  = "(CHA) Perform: " + perform + " (Class Skill: " + classskillcheck(cs_perform) + ")";
        pt_profession = "(WIS) Profession*: " + profession + " (Class Skill: " + classskillcheck(cs_profession) + ")";
        pt_ride = "(DEX) Ride " + ride + " (Class Skill: " + classskillcheck(cs_ride) + ")";
        pt_senseMotive = "(WIS) Sense Motive: " + senseMotive + " (Class Skill: " + classskillcheck(cs_senseMotive) + ")";
        pt_sleightOfHand = "(DEX) Sleight of Hand*: " + slieghtOfHand + " (Class Skill: " + classskillcheck(cs_slieghtOfHand) + ")";
        pt_spellcraft = "(INT) Spellcraft*: " + spelllcraft + " (Class Skill: " + classskillcheck(cs_spellcraft) + ")";
        pt_stealth = "(DEX) Stealth: " + stealth + " (Class Skill: " + classskillcheck(cs_stealth) + ")";
        pt_survival = "(WIS) Survival: " + survival + " (Class Skill: " + classskillcheck(cs_survival) + ")";
        pt_swim = "(STR) Swim: " + swim + " (Class Skill: " + classskillcheck(cs_swim) + ")";
        pt_useMagicalDevice = "(CHA) Use Magic Device*: " + useMagicDevice + " (Class Skill: " + classskillcheck(cs_useMagicDevice) + ")";
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
            this.savThrowFortitude = assignint(sheet, 39, targetrow);
            this.savThrowReflex = assignint(sheet, 40, targetrow);
            this.savThrowWisdom = assignint(sheet, 41, targetrow);
            //Speed Stats
            this.baseSpeed = assignint(sheet, 42, targetrow);

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
        System.out.println(pt_playerName);
        System.out.println(pt_characterName);
        System.out.println("");
    }

    private void printroleplay() {
        System.out.println( "//Roleplay\\\\");
        System.out.println(pt_alignment);
        System.out.println(pt_race);
        System.out.println(pt_size);
        System.out.println(pt_gender);
        System.out.println(pt_age);
        System.out.println(pt_weight);
        System.out.println(pt_weight);
        System.out.println(pt_deity);
        System.out.println(pt_homeland);
        System.out.println("");
    }

    private void printlvlexp() {
        System.out.println("//Level/Exp/Class\\\\");
        System.out.println(pt_experience);
        System.out.println(pt_totalLevel);
        for (String cl: classes){
            int index = Arrays.asList(classes).indexOf(cl);
            System.out.println("Class: " + cl + " (" + classlvl[index] + ")");
        }
        System.out.println("");
    }

    private void printabilstats() {
        System.out.println("//Ability Stats\\\\");
        System.out.println(pt_strength);
        System.out.println(pt_strModifier);
        System.out.println(pt_dexterity);
        System.out.println(pt_dexModifier);
        System.out.println(pt_constitution);
        System.out.println(pt_conModifier);
        System.out.println(pt_intelligence);
        System.out.println(pt_intModifier);
        System.out.println(pt_wisdom);
        System.out.println(pt_wisModifier);
        System.out.println(pt_charisma);
        System.out.println(pt_chaModifier);
        System.out.println("");
    }

    private void printcombat() {
        System.out.println("//Combat Stats\\\\");
        System.out.println(pt_initiative);
        System.out.println(pt_maxHitPoints);
        System.out.println("-Armor Class-");
        System.out.println(pt_armorClass);
        System.out.println(pt_touchArmorClass);
        System.out.println(pt_flatFootedArmorClass);
        System.out.println("-Damage Bonus-");
        System.out.println(pt_baseAttackBonus);
        System.out.println(pt_sizeAttackModifier);
        System.out.println(pt_meleeAttackBonus);
        System.out.println(pt_rangeAttackBonus);
        System.out.println("-Resistence-");
        System.out.println(pt_spellResistance);
        System.out.println("-Combat Maneuvers-");
        System.out.println(pt_cmBonus);
        System.out.println(pt_cmDefense);
        System.out.println("");
    }

    private void printsavingthrows() {
        System.out.println("//Saving Throws\\\\");
        System.out.println(pt_savThrowFortitude);
        System.out.println(pt_savThrowReflex);
        System.out.println(pt_savThrowWisdom);
        System.out.println("");
    }

    private void printspeedstats() {
        System.out.println("//Speed Stats\\\\");
        System.out.println(pt_baseSpeed);
        System.out.println("");
    }

    private void printskillstats() {
        System.out.println("//Skill Stats\\\\");
        System.out.println(pt_acrobatics);
        System.out.println(pt_appraise);
        System.out.println(pt_bluff);
        System.out.println(pt_climb);
        System.out.println(pt_craft);
        System.out.println(pt_diplomacy);
        System.out.println(pt_disableDevice);
        System.out.println(pt_disguise);
        System.out.println(pt_escapeArtist);
        System.out.println(pt_fly);
        System.out.println(pt_handleAnimal);
        System.out.println(pt_heal);
        System.out.println(pt_intimidate);
        System.out.println(pt_knowledgeArcana);
        System.out.println(pt_knowledgeDungeoneering);
        System.out.println(pt_knowledgeEngineering);
        System.out.println(pt_knowledgeGeography);
        System.out.println(pt_knowledgeHistory);
        System.out.println(pt_knowledgeLocal);
        System.out.println(pt_knowledgeNature);
        System.out.println(pt_knowledgeNobility);
        System.out.println(pt_knowledgeNobility);
        System.out.println(pt_knowledgePlanes);
        System.out.println(pt_knowledgeReligion);
        System.out.println(pt_linguistics);
        System.out.println(pt_perception);
        System.out.println(pt_perform);
        System.out.println(pt_profession);
        System.out.println(pt_ride);
        System.out.println(pt_senseMotive);
        System.out.println(pt_sleightOfHand);
        System.out.println(pt_spellcraft);
        System.out.println(pt_stealth);
        System.out.println(pt_survival);
        System.out.println(pt_swim);
        System.out.println(pt_useMagicalDevice);
        System.out.println("");
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
            statsStream.newLineAtOffset(25, 775);
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
            statsStream.newLineAtOffset(25, 725);
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
            statsStream.newLine();
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

            //Saving Throws\\
            statsStream.showText("//Saving Throws\\\\");
            statsStream.newLine();
            statsStream.showText(pt_savThrowFortitude);
            statsStream.newLine();
            statsStream.showText(pt_savThrowReflex);
            statsStream.newLine();
            statsStream.showText(pt_savThrowWisdom);
            statsStream.newLine();
            statsStream.newLine();

            //Base Speed
            statsStream.showText("//Speed\\\\");
            statsStream.newLine();
            statsStream.showText(pt_baseSpeed);
            statsStream.newLine();
            statsStream.newLine();

            //Finish Stats Column
            statsStream.endText();

            //Start Skills Column
            statsStream.beginText();
            System.out.println("-Start Writing Header");
            statsStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            statsStream.setLeading(14.5f);
            statsStream.newLineAtOffset(250, 725);
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
            statsStream.showText(pt_intimidate);
            statsStream.newLine();
            statsStream.showText(pt_knowledgeArcana);
            statsStream.newLine();
            statsStream.showText(pt_knowledgeDungeoneering);
            statsStream.newLine();
            statsStream.showText(pt_knowledgeEngineering);
            statsStream.newLine();
            statsStream.showText(pt_knowledgeGeography);
            statsStream.newLine();
            statsStream.showText(pt_knowledgeHistory);
            statsStream.newLine();
            statsStream.showText(pt_knowledgeLocal);
            statsStream.newLine();
            statsStream.showText(pt_knowledgeNature);
            statsStream.newLine();
            statsStream.showText(pt_knowledgeNobility);
            statsStream.newLine();
            statsStream.showText(pt_knowledgePlanes);
            statsStream.newLine();
            statsStream.showText(pt_knowledgeReligion);
            statsStream.newLine();
            statsStream.showText(pt_linguistics);
            statsStream.newLine();
            statsStream.showText(pt_perception);
            statsStream.newLine();
            statsStream.showText(pt_perform);
            statsStream.newLine();
            statsStream.showText(pt_profession);
            statsStream.newLine();
            statsStream.showText(pt_ride);
            statsStream.newLine();
            statsStream.showText(pt_senseMotive);
            statsStream.newLine();
            statsStream.showText(pt_sleightOfHand);
            statsStream.newLine();
            statsStream.showText(pt_spellcraft);
            statsStream.newLine();
            statsStream.showText(pt_stealth);
            statsStream.newLine();
            statsStream.showText(pt_survival);
            statsStream.newLine();
            statsStream.showText(pt_swim);
            statsStream.newLine();
            statsStream.showText(pt_useMagicalDevice);
            statsStream.newLine();
            statsStream.newLine();

            //Finish Skills Column
            statsStream.endText();

            //Close Editing
            System.out.println("-Finished Writing");
            statsStream.close();
            System.out.println("-Closed Writer");
            plainTextTemp.save(this.directory + "\\output\\pdfs\\" + playerName + "_plainText.pdf");
            System.out.println("Document Created");
            plainTextTemp.close();
            System.out.println("//------------------------------\\\\");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    //====================\\

    //====================\\
    //Export to Pathfinder Character Template PDF

    private void createpathfindertemppdf() throws IOException {
        System.out.println("");
        System.out.println("//------------------------------\\\\");
        File template = new File(this.directory + "\\data\\templates\\default_pathtemp1.pdf");
        PDDocument newtemp = PDDocument.load(template);
        System.out.println("Template Loaded");
        try {
            PDDocumentCatalog docCatalog = newtemp.getDocumentCatalog();
            PDAcroForm acroForm = docCatalog.getAcroForm();
            //Names\\
            //Set Player Name
            addToPDFTemplate(acroForm, "str", "Player", playerName, 0);
            //Set Character Name
            addToPDFTemplate(acroForm, "str", "Character Name", characterName, 0);
            //Roleplay\\
            //Set Alignment
            addToPDFTemplate(acroForm, "str", "Alignment", alignment, 0);
            //Set Race
            addToPDFTemplate(acroForm, "str", "Race", race, 0);
            //Set Size
            addToPDFTemplate(acroForm, "str", "Size", size, 0);
            //Set Gender
            addToPDFTemplate(acroForm, "str", "Gender", gender, 0);
            //Set Age
            addToPDFTemplate(acroForm, "int", "Age", "", age);
            //Set Weight
            addToPDFTemplate(acroForm, "int", "Weight", "", weight);
            //Set Hair
            addToPDFTemplate(acroForm, "str", "Hair", hair, 0);
            //Set Deity
            addToPDFTemplate(acroForm, "str", "Deity", deity, 0);
            //Set Homeland
            addToPDFTemplate(acroForm, "str", "Homeland", homeland, 0);
            //Level/Exp/Class\\
            //
            newtemp.save(this.directory + "\\output\\pdfs\\" + playerName + "_pathtemp1.pdf"); // save changes to another file
            newtemp.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    private void addToPDFTemplate(PDAcroForm acroForm, String type, String fieldName, String valueString, int valueINT ) throws IOException {
        try {
            PDField pdfield_target = acroForm.getField(fieldName);
            if (type == "str") {
                pdfield_target.setValue(valueString);
            }
            else if (type == "int") {
                pdfield_target.setValue(Integer.toString(valueINT));
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
