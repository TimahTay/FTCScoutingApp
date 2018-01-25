/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timdan.ftcscoutingapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Admin
 */
public class DataHandler {
    
    public static TreeMap<Integer, ArrayList<String>> importData() throws FileNotFoundException, IOException {
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
        
        
        InputStream inp = new FileInputStream("C:\\Users\\Admin\\Documents\\GitHub\\FTCScoutingAppScouting Template.xls"); //TODO: Make the FileInputStream editable with import
        try {
            Workbook wb = WorkbookFactory.create(inp);
        } catch (InvalidFormatException ex) {
            System.out.println("ERROR: Invalid Format");
        } catch (EncryptedDocumentException ex) {
            System.out.println("ERROR: The Document is Encrypted");
        }
        HSSFWorkbook wb = new HSSFWorkbook(inp);
        
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row;
        HSSFCell cell;

        
        Iterator rows = sheet.rowIterator();
        //Iterates across each cell
        row = (HSSFRow) rows.next();
        Iterator cells = row.cellIterator();
        int rowCount = 0;
            
        while(cells.hasNext()) {
            cell = (HSSFCell) cells.next();
            if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING && !cell.getStringCellValue().isEmpty()) { //checks if the cell has a string, and is not blank (to avoid black formatting cells)
                //add the content of the cell to the key of the next entry in matchData
                matchData.put(rowCount, null);
                rowCount++;
            }
        }
        System.out.println(matchData.toString());
        return matchData;
    }
  
    
}
