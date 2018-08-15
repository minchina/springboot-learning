package org.ncmao.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Date 2018/7/26 9:38
 * @description
 */
public class ExcelExportUtil {

    public static final String FILE_PATH = "C:/temp/sxssf.xlsx";





    public void generateSXSSF() throws IOException {
        Workbook wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
        Sheet sh = wb.createSheet();
        for (int rownum = 0; rownum < 100 * 100; rownum++) {
            Row row = sh.createRow(rownum);
            for (int cellnum = 0; cellnum < 10; cellnum++) {
                Cell cell = row.createCell(cellnum);
                String address = new CellReference(cell).formatAsString();
                cell.setCellValue(address);
            }
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(FILE_PATH);

        } catch (FileNotFoundException e) {
            File file = new File(FILE_PATH);
        }

        wb.write(out);
        out.close();
    }
}
