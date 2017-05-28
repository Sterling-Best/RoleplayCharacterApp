package charactertemplate;

import java.util.Arrays;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



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
    private String playername;
    private String charactername;

    //Roleplay details
    private String alignment;
    private String race;
    private String size;
    private String gender;
    private int age;
    private int weight;
    private String hair;
    private String deity;
    private String homeland;

    //Lvl EXP
    private int exp;
    private int totlvl;
    private String[] classes = {};
    private int[] classlvl = {};

    // Ability Stats
    private int STR;
    private int DEX;
    private int CON;
    private int INT;
    private int WIS;
    private int CHA;

    // Ability Modifiers
    private int strmod;
    private int dexmod;
    private int conmod;
    private int intmod;
    private int wismod;
    private int chamod;

    //Combat
    private int initiative;
    private int hp;
    private String[] damred;
    private int ac;
    private int touchac;
    private int ffac;
    private int bab;
    private int sizemod;
    private int melee;
    private int range;
    private int splres;
    private int cmbonus;
    private int cmdefense;

    //Saving throws
    private int sav_fort;
    private int sav_ref;
    private int sav_wil;

    //Speed
    private int basespeed;

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
    boolean cs_disdev = false;
    int disdev = 0;
    boolean cs_disguise = false;
    int disguise = 0;
    boolean cs_escart = false;
    int escart = 0;
    boolean cs_fly = false;
    int fly = 0;
    boolean cs_hanani = false;
    int hanani = 0;
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
    boolean cs_geoknw = false;
    int geoknw = 0;
    boolean cs_hisknw= false;
    int hisknw = 0;
    boolean cs_locknw = false;
    int locknw = 0;
    boolean cs_natknw = false;
    int natknw = 0;
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

    String inputFile;

    public charactertemplate() {
    }

    public static void main(String[] args) throws IOException {
        charactertemplate a = new charactertemplate();
        a.setInputFile("C:/Users/methl/OneDrive/Terminus/RoleplayCharacterApp/data/characterdata.xls");
        a.extractdata("#1");
        a.print();
    }

    //--Read Character from Spreadsheet--\\

    private void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    private void extractdata(String charid) throws IOException  {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            Cell storedcharacterid = sheet.findCell(charid);
            int characterrow = storedcharacterid.getRow();
            //Character
            this.playername = assignstring(sheet, "Player Name", characterrow);
            this.charactername = assignstring(sheet, "Character Name", characterrow);
            //Roleplay Details
            this.alignment = assignstring(sheet, "Alignment", characterrow);
            this.race = assignstring(sheet, "Race", characterrow);
            this.size = assignstring(sheet, "Size", characterrow);
            this.gender = assignstring(sheet, "Gender", characterrow);
            this.age = assignint(sheet, "Age", characterrow);
            this.weight = assignint(sheet, "Weight", characterrow);
            this.hair = assignstring(sheet, "Hair", characterrow);
            this.deity = assignstring(sheet, "Deity", characterrow);
            this.homeland = assignstring(sheet, "Homeland", characterrow);
            //Lvl-Class-Exp
            this.exp = assignint(sheet, "Experience", characterrow);
            this.totlvl = assignint(sheet, "Total Level", characterrow);
            //Need to add classes
            //need to add class levels
            //Ability Stats
            this.STR = assignint(sheet, "Strength", characterrow);
            this.DEX = assignint(sheet, "Dexterity", characterrow);
            this.CON = assignint(sheet, "Constitution", characterrow);
            this.INT = assignint(sheet, "Intelligence", characterrow);
            this.WIS = assignint(sheet, "Wisdom", characterrow);
            this.CHA = assignint(sheet, "Charisma", characterrow);
            //Ability Modifiers
            this.strmod = assignint(sheet, "Strength Modifier", characterrow);
            this.dexmod = assignint(sheet, "Dexterity Modifier", characterrow);
            this.conmod = assignint(sheet, "Constitution Modifier", characterrow);
            this.intmod = assignint(sheet, "Intelligence Modifier", characterrow);
            this.wismod = assignint(sheet, "Wisdom Modifier", characterrow);
            this.chamod = assignint(sheet, "Charisma Modifier", characterrow);
            //Combat
            this.initiative = assignint(sheet, "Initiative", characterrow);
            this.hp = assignint(sheet, "Hit Points", characterrow);
            this.ac = assignint(sheet, "Armor Class", characterrow);
            this.touchac = assignint(sheet, "Touch Armor Class", characterrow);
            this.ffac = assignint(sheet, "Flat-Footed Armor Class", characterrow);
            this.bab = assignint(sheet, "Base Attack Bonus", characterrow);
            this.sizemod = assignint(sheet, "Size Modifier", characterrow);
            this.melee = assignint(sheet, "Melee Damage Bonus", characterrow);
            this.range = assignint(sheet,"Range Damage Bonus", characterrow);
            this.splres = assignint(sheet, "Spell Resistance", characterrow);
            this.cmbonus = assignint(sheet, "Combat Maneuver Bonus", characterrow);
            this.cmdefense = assignint(sheet, "Combat Maneuver Defense", characterrow);
            //Saving Throw
            this.sav_fort = assignint(sheet, "Fortitude Saving Throw", characterrow);
            this.sav_ref = assignint(sheet, "Reflex Saving Throw", characterrow);
            this.sav_wil = assignint(sheet, "Will Saving Throw", characterrow);
            //Speed Stats
            this.basespeed = assignint(sheet, "Base Speed", characterrow);
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    private String assignstring(Sheet target, String collabel, int row){
        Cell label = target.findLabelCell(collabel);
        int col = label.getColumn();
        Cell cell = target.getCell(col, row);
        return cell.getContents();
    }

    private int assignint(Sheet target, String collabel, int row){
        Cell label = target.findLabelCell(collabel);
        int col = label.getColumn();
        Cell cell = target.getCell(col, row);
        String contents  = cell.getContents();
        return Integer.parseInt(contents);
    }

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
        System.out.println(playername);
        System.out.println( "--" + charactername + "--");
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
        System.out.println("Experience: " + exp);
        System.out.println("Level: " + totlvl);
        for (String cl: classes){
            int index = Arrays.asList(classes).indexOf(cl);
            System.out.println("Class: " + cl + " (" + classlvl[index] + ")");
        }
        System.out.println("");
    }

    private void printabilstats() {
        System.out.println("//Ability Stats\\\\");
        System.out.println("Strength: " + STR);
        if (strmod >= 0) {
            System.out.println("Strength Modifier: +" + strmod);
        }else{
            System.out.println("Strength Modifier: " + strmod);
        }
        System.out.println("Dexterity: " + DEX);
        if (dexmod >= 0) {
            System.out.println("Dexterity Modifier: +" + dexmod);
        }else{
            System.out.println("Dexterity Modifier: " + strmod);
        }
        System.out.println("Constitution: " + CON);
        if (dexmod >= 0) {
            System.out.println("Constitution Modifier: +" + conmod);
        }else{
            System.out.println("Constitution Modifier: " + conmod);
        }
        System.out.println("Intelligence: " + INT);
        if (dexmod >= 0) {
            System.out.println("Intelligence Modifier: +" + intmod);
        }else{
            System.out.println("Intelligence Modifier: " + intmod);
        }
        System.out.println("Wisdom: " + WIS);
        if (dexmod >= 0) {
            System.out.println("Wisdom Modifier: +" + wismod);
        }else{
            System.out.println("Wisdom Modifier: " + wismod);
        }
        System.out.println("Charisma: " + CHA);
        if (dexmod >= 0) {
            System.out.println("Charisma Modifier: +" + chamod);
        }else{
            System.out.println("Charisma Modifier: " + chamod);
        }
        System.out.println("");
    }

    private void printcombat() {
        System.out.println("//Combat Stats\\\\");
        System.out.println("Initiative: " + initiative);
        System.out.println("Hit Points: " + hp);
        System.out.println("-Armor Class-");
        System.out.println("Armor Class: " + ac);
        System.out.println("Touch Armor Class: " + touchac);
        System.out.println("Flat Footed Armor Class: " + ffac);
        System.out.println("-Damage Bonus-");
        System.out.println("Base Damage Bonus: " + bab);
        System.out.println("Size Modifier: " + sizemod);
        System.out.println("Melee Damage Bonus: " + melee);
        System.out.println("Range Damage Bonus: " + range);
        System.out.println("-Resistence-");
        System.out.println("Spell Resistence: " + splres);
        System.out.println("-Combat Maneuvers-");
        System.out.println("Combat Maneuver Bonus: " + cmbonus);
        System.out.println("Combat Maneuver Defense: " + cmdefense);
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
        System.out.println("Disable Device: " + disdev + " (Class Skill: " + classskillcheck(cs_disdev) + ")");
        System.out.println("Disguise: " + disguise + " (Class Skill: " + classskillcheck(cs_disguise) + ")");
        System.out.println("Escape Artist: " + escart + " (Class Skill: " + classskillcheck(cs_escart) + ")");
        System.out.println("Fly: " + fly + " (Class Skill: " + classskillcheck(cs_fly) + ")");
        System.out.println("Handle Animal: " + hanani + " (Class Skill: " + classskillcheck(cs_hanani) + ")");
        System.out.println("Heal: " + heal + " (Class Skill: " + classskillcheck(cs_heal) + ")");
        System.out.println("Intimidate: " + intimidate + " (Class Skill: " + classskillcheck(cs_intimidate) + ")");
        System.out.println("Knowledge (Arcana): " + arcaneknw + " (Class Skill: " + classskillcheck(cs_arcaneknw) + ")");
        System.out.println("Knowledge (Dungeoneering): " + dungknw + " (Class Skill: " + classskillcheck(cs_dungknw) + ")");
        System.out.println("Knowledge (Engineering): " + engknw + " (Class Skill: " + classskillcheck(cs_engknw) + ")");
        System.out.println("Knowledge (Geography): " + geoknw + " (Class Skill: " + classskillcheck(cs_geoknw) + ")");
        System.out.println("Knowledge (History): " + hisknw + " (Class Skill: " + classskillcheck(cs_hisknw) + ")");
        System.out.println("Knowledge (Local): " + locknw + " (Class Skill: " + classskillcheck(cs_locknw) + ")");
        System.out.println("Knowledge (Nature): " + natknw + " (Class Skill: " + classskillcheck(cs_natknw) + ")");
        System.out.println("Knowledge (Nobility): " + nobknw + " (Class Skill: " + classskillcheck(cs_nobknw) + ")");
        System.out.println("Knowledge (Planes): " + planknw + " (Class Skill: " + classskillcheck(cs_planknw) + ")");
        System.out.println("Knowledge (Religion): " + relknw + " (Class Skill: " + classskillcheck(cs_relknw) + ")");

    }

    private String classskillcheck(boolean csboolean){
        if (csboolean){
            return "Yes";
        }else{
            return "No";
        }
    }

}
