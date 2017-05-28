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
    public String playername;
    public String charactername;

    //Roleplay details
    public String alignment;
    public String race;
    String size;
    String gender;
    int age;
    int weight;
    String hair;
    String diety;
    String homeland;

    //Lvl EXP
    int exp;
    int totlvl;
    String[] classes = {};
    int[] classlvl = {};

    // Ability Stats
    int STR;
    int DEX;
    int CON;
    int INT;
    int WIS;
    int CHA;

    // Ability Modifiers
    int strmod;
    int dexmod;
    int conmod;
    int intmod;
    int wismod;
    int chamod;

    //Combat
    int initiative;
    int hp;
    String[] damred;
    int ac;
    int touchac;
    int ffac;
    int bab;
    int sizemod;
    int melee;
    int range;
    int splres;
    int cmbonus;
    int cmdefense;

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

    String inputFile;

    public charactertemplate() {
    }

    public static void main(String[] args) throws IOException {
        charactertemplate a = new charactertemplate();
        a.setInputFile("D:\\Users\\Methlodis\\OneDrive\\Terminus\\RoleplayCharacterApp\\data\\characterdata.xls");
        a.extractdata("#1");
        a.print();
    }

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
            this.playername = assignstring(sheet, 1, targetrow);
            this.charactername = assignstring(sheet, 2, targetrow);
            //Roleplay Details
            this.alignment = assignstring(sheet, 3, targetrow);
            this.race = assignstring(sheet, 4, targetrow);
            this.size = assignstring(sheet, 5, targetrow);
            this.gender = assignstring(sheet, 6, targetrow);
            this.age = assignint(sheet, 7, targetrow);
            this.weight = assignint(sheet, 8, targetrow);
            this.hair = assignstring(sheet, 9, targetrow);
            this.diety = assignstring(sheet, 10, targetrow);
            this.homeland = assignstring(sheet, 11, targetrow);
            //Lvl-Class-Exp
            this.exp = assignint(sheet, 12, targetrow);
            this.totlvl = assignint(sheet, 13, targetrow);
            //Need to add classes
            //need to add class levels
            //Ability Stats
            this.STR = assignint(sheet, 15, targetrow);
            this.DEX = assignint(sheet, 16, targetrow);
            this.CON = assignint(sheet, 17, targetrow);
            this.INT = assignint(sheet, 18, targetrow);
            this.WIS = assignint(sheet, 19, targetrow);
            this.CHA = assignint(sheet, 20, targetrow);
            //Ability Modifiers
            this.strmod = assignint(sheet, 21, targetrow);
            this.dexmod = assignint(sheet, 22, targetrow);
            this.conmod = assignint(sheet, 23, targetrow);
            this.intmod = assignint(sheet, 24, targetrow);
            this.wismod = assignint(sheet, 25, targetrow);
            this.chamod = assignint(sheet, 26, targetrow);
            //Combat
            this.initiative = assignint(sheet, 27, targetrow);
            this.hp = assignint(sheet, 28, targetrow);
            this.ac = assignint(sheet, 29, targetrow);
            this.touchac = assignint(sheet, 30, targetrow);
            this.ffac = assignint(sheet, 31, targetrow);
            this.bab = assignint(sheet, 32, targetrow);
            this.sizemod = assignint(sheet, 33, targetrow);
            this.melee = assignint(sheet, 34, targetrow);
            this.range = assignint(sheet, 35, targetrow);
            this.splres = assignint(sheet, 36, targetrow);
            this.cmbonus = assignint(sheet, 37, targetrow);
            this.cmdefense = assignint(sheet, 38, targetrow);
            //Saving Throw
            this.sav_fort = assignint(sheet, 39, targetrow);
            this.sav_ref = assignint(sheet, 40, targetrow);
            this.sav_wil = assignint(sheet, 41, targetrow);
            //Speed Stats
            this.basespeed = assignint(sheet, 42, targetrow);
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
        System.out.println("Diety: " + diety);
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
        System.out.println("Flat Footed Armor Class: +" + ffac);
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
        System.out.println("Heal: " + heal + " (Class Skill: " + classskillcheck(cs_bluff) + ")");
    }

    private String classskillcheck(boolean csboolean){
        if (csboolean){
            return "Yes";
        }else{
            return "No";
        }
    }

}
