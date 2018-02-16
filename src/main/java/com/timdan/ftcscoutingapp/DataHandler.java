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
        
        /*
        Key for scores ArrayList:
        0  - team
        1  - auto:jewel
        2  - auto:park
        3  - auto:glyph:scored
        4  - auto:glyph:bonus
        5  - teleop:glyph:scored
        6  - teleop:glyph:rows
        7  - teleop:glyph:columns
        8  - teleop:glyph:ciphers
        9  - endgame:relic1:zone
        10 - endgame:relic1:standing
        11 - endgame:relic2:zone
        12 - endgame:relic2:standing
        13 - endgame:balanced
        14 - notes
        15 - scores:autonomous
        16 - scores:teleop
        17 - scores:endgame
        18 - scores:final
        */

        ArrayList<Object> scores = new ArrayList();
        
        InputStream inp = new FileInputStream("Scouting_Template.xlsx"); //TODO: make the FileInputStream changable with import
        MatchDataMap matchData = new MatchDataMap(inp);

        Sheet sheet = matchData.getWorkbook().getSheetAt(0);

        Iterator rows = sheet.rowIterator();
        rows.next(); rows.next(); rows.next(); //Muy Optimal
        Row row = (Row)rows.next();
        
        Iterator cells = row.cellIterator();
        Cell cell = row.getCell(0);
        int count = 1;
        
        //Sets the keys of matchData to the match number
        while (rows.hasNext() && cell != null && cell.getCellTypeEnum() != CellType.BLANK) {
            cells = row.cellIterator();
            //Sets the values of matchData to an arrylist with data from the row
            while (cells.hasNext()) {
                cell = (Cell) cells.next();
                if (cell.getCellTypeEnum() == CellType.STRING)
                    scores.add(cell.getStringCellValue());
                else if (cell.getCellTypeEnum() == CellType.NUMERIC)
                    scores.add(cell.getNumericCellValue());
            }
            row = (Row)rows.next();
            matchData.put(count, scores);
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