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
import org.apache.poi.ss.formula.functions.Column;
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
    //TODO change back to value type ArrayList<String>
    public static MatchDataMap importData() throws FileNotFoundException, IOException, InvalidFormatException { //Method takes MatchDataMap, and inputs to tableMatchData
        
        /*Key for ArrayList:
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

        ArrayList<Object> scores = new ArrayList();
        
        InputStream inp = new FileInputStream("Scouting_Template.xlsx"); //TODO: make the FileInputStream changable with import
        MatchDataMap matchData = new MatchDataMap(inp);

        Sheet sheet = matchData.getWorkbook().getSheetAt(0);

        Iterator rows = sheet.rowIterator();
        rows.next(); rows.next(); rows.next(); //Optimal
        Row row = (Row)rows.next();
        
        Iterator cells = row.cellIterator();
        Cell cell = row.getCell(0);
        int count = 1;
        
        
        //Sets the keys of matchData to the match number
        while (rows.hasNext() && cell != null && cell.getCellTypeEnum() != CellType.BLANK) {
            cells = row.cellIterator();
            //Sets the values of matchData to an arrylist with data from the row
            while (cells.hasNext() && cell.getCellTypeEnum() != CellType.BLANK) {
                cell = (Cell) cells.next();
                if (cell.getCellTypeEnum() == CellType.STRING)
                    scores.add(cell.getStringCellValue());
                else if (cell.getCellTypeEnum() == CellType.NUMERIC)
                    scores.add(cell.getNumericCellValue());
            }
            matchData.put(count, scores);
            row = (Row)rows.next();
            cell = row.getCell(0);
            //System.out.println("Scores: " + scores.toString()); //prints each rows data to check that it's working
            scores.clear();
            count++;
        }
        
        return matchData;
        
    }
}












// Old inport method code in case we need it back
//public static MatchDataMap importData() throws FileNotFoundException, IOException, InvalidFormatException{
        /*
*/
