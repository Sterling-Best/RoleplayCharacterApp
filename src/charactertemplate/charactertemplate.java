package charactertemplate;

import java.util.Arrays;

/**
 * Created by Sterling on 2017-05-25.
 */

public class charactertemplate {
    // Character
    private String playername = "Sterling Best";
    private String charactername = "Logan";

    //Roleplay details
    public String alignment = "Nuetral Good";
    public String race = "Human";
    String size = "Medium";
    String gender = "Male";
    int age = 34;
    int weight = 156;
    String hair = "Brown";
    String diety = "God";
    String homeland = "Canada";

    //Lvl EXP
    int exp = 900;
    int totlvl = 3;
    String[] classes = {"Fighter", "Wizard"};
    int[] classlvl = {2, 1};

    // Ability Stats
    int STR = 10;
    int DEX = 10;
    int CON = 10;
    int INT = 10;
    int WIS = 10;
    int CHA = 10;

    // Ability Modifiers
    int strmod = 0;
    int dexmod = 0;
    int conmod = 0;
    int intmod = 0;
    int wismod = 0;
    int chamod = 0;

    //Combat
    int initiative = 0;
    double hp = 24.0;
    String[] damred = {"10/cold iron"};
    int ac = 14;
    int touchac = 10;
    int ffac = 10;
    int bab = 2;
    int sizemod = 0;
    int melee = 2;
    int range = 2;
    int splres = 0;
    int cmb = 2;
    int cmd = 12;

    //Saving throws
    int sav_fort = 3;
    int sav_ref = 0;
    int sav_wil = 3;

    //Speed
    int basespeed = 30;

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
    boolean cs_displomacy = false;
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

    public static void main(String[] args) {
        charactertemplate a = new charactertemplate();
        a.print();
    }

    public void print() {
        printnames();
        printroleplay();
        printlvlexp();
        printabilstats();
    }

    public void printnames() {
        System.out.println(playername);
        System.out.println( "--" + charactername + "--");
        System.out.println("");
    }

    public void printroleplay() {
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

    public void printlvlexp() {
        System.out.println("//Level/Exp/Class\\\\");
        System.out.println("Experience: " + exp);
        System.out.println("Level: " + totlvl);
        for (String cl: classes){
            int index = Arrays.asList(classes).indexOf(cl);
            System.out.println("Class: " + cl + " (" + classlvl[index] + ")");
        }
        System.out.println("");
    }

    public void printabilstats() {
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
    }
}
