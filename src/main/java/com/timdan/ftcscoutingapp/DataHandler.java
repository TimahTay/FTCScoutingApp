/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timdan.ftcscoutingapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Admin
 */
public class DataHandler {
    
    public static TreeMap<Integer, ArrayList<String>> importData() throws FileNotFoundException, IOException, InvalidFormatException {
        /*
        Key for ArrayList:
        0  - team
        1  - auto:jewel
        2  - auto:park
        3  - auto:glyph:nonbonus
        4  - auto:glyph:bonus
        5  - teleop:glyph:scored
        6  - teleop:glyph:rows
        7  - teleop:glyph:columns
        8  - teleop:glyph:cipher
        9  - endgame:relic:1
        10 - endgame:relic:2
        11 - endgame:park
        12 - notes
        */
        TreeMap<Integer, ArrayList<String>> matchData = new TreeMap();
        
        //TODO: IMPORT FROM EXCEL FILE WITH APACHE POI
        System.out.println("IMPORT DATA WORKING");
        
        InputStream inp = new FileInputStream("C:\\Users\\Admin\\Documents\\GitHub\\FTCScoutingApp\\Scouting_Template.xlsx"); //TODO: Make the FileInputStream editable with import

        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(1);
        cell.setCellType(CellType.STRING);
        //cell.setCellValue("a test");

        Iterator rows = sheet.rowIterator();
        row = (Row) rows.next();
        Iterator cells = row.cellIterator();
        int rowCount = 0;
        
        while(cells.hasNext()){
            cell = (Cell) cells.next();
            if(cell.getCellType() == Cell.CELL_TYPE_STRING && !cell.getStringCellValue().isEmpty()){
                matchData.put(rowCount, null);
                rowCount++;
            }
        }
        return matchData;
    }
  
    
}
