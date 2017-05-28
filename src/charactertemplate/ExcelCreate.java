package charactertemplate;
import java.io.File;

//Import the JExcel API
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/*
 * Created on Apr 3, 2009 By Shabarish Vijayakumar
 *
 * This Java class is used to create an Excel File output
 * from a given String
 *
 */

public class ExcelCreate {

    public static void main(String[] args) {
        try {

            /* The assumption is that the data has the field separator as comma (,) and the
             * end separator for each record is found by the literal END
             */

            // Assume the below is the input file format
            String input =
                    "100,Anakin Skywalker,EAS,ConsultantEND200,Darth Vader,Java,Sr. ProgrammerEND300,Obi-Wan Kenobi,MSTechmologies,Project ManagerEND";

            int counter = 0;

            WritableWorkbook workbook =
                    Workbook.createWorkbook(new File("output.xls"));
            WritableSheet sheet = workbook.createSheet("Page1", 0);

            //Set Header

            String Header[] = new String[4];
            Header[0] = "Emp ID";
            Header[1] = "Name";
            Header[2] = "Department";
            Header[3] = "Designation";

            //Setting Background colour for Cells
            Colour bckcolor = Colour.DARK_GREEN;
            WritableCellFormat cellFormat = new WritableCellFormat();
            cellFormat.setBackground(bckcolor);

            //Setting Colour & Font for the Text

            WritableFont font = new WritableFont(WritableFont.ARIAL);
            font.setColour(Colour.GOLD);
            cellFormat.setFont(font);

            // Write the Header to the excel file
            for (int i = 0; i < Header.length; i++) {
                Label label = new Label(i, 0, Header[i]);
                sheet.addCell(label);
                WritableCell cell = sheet.getWritableCell(i, 0);
                cell.setCellFormat(cellFormat);

            }

            String inputArray[] = input.split("END");

            for (int i = 0; i < inputArray.length; i++) {

                counter++;

                String fieldValuesArray[] = inputArray[i].split(",");

                for (int j = 0; j < fieldValuesArray.length; j++) {

                    Label label =
                            new Label(j, counter, fieldValuesArray[j].toString());
                    sheet.addCell(label);
                }
            }

            workbook.write();
            workbook.close();

        } catch (Exception e) {
            /* Write your logic to handle exception.
             * For a module, recommendation is to write
             * out trace/log messages so that error tracking
             * is easy via the adapter logs
             */
        }
    }
}
