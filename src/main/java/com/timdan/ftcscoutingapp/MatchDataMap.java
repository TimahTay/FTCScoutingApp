package com.timdan.ftcscoutingapp;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tjtat
 */
public class MatchDataMap extends TreeMap {

    private final TreeMap<Integer, ArrayList<Object>> matchData;
    private final ArrayList<Object> scores;
    private final InputStream inp;
    private Workbook wb;
    private Sheet sheet;
    
    public MatchDataMap(InputStream i) throws IOException, InvalidFormatException {
        /*
        Key for scores ArrayList:
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
        
        inp = i;
        matchData = new TreeMap();
        scores = new ArrayList();
        
        wb = WorkbookFactory.create(inp);
        sheet = wb.getSheetAt(0);

        Iterator rows = sheet.rowIterator();
        rows.next();rows.next();rows.next(); //Optimal
        Row row = (Row) rows.next();

        Iterator cells;
        Cell cell = row.getCell(0);
        int count = 1;
        
        //Sets the keys of matchData to the match number
        while (rows.hasNext() && cell != null && cell.getCellTypeEnum() != CellType.BLANK) {
            cells = row.cellIterator();
            //Sets the values of matchData to an arrylist with data from the row
            while (cells.hasNext()  && cell.getCellTypeEnum() != CellType.BLANK) {
                cell = (Cell) cells.next();
                if (cell.getCellTypeEnum() == CellType.STRING) {
                    scores.add(cell.getStringCellValue());
                } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                    scores.add(cell.getNumericCellValue());
                }
            }
            matchData.put(count, scores);
            row = (Row) rows.next();
            cell = row.getCell(0);
            System.out.println("Scores: " + scores.toString()); //prints each rows data to check that it's working
            scores.clear();
            count++;
        }
    }

    public TreeMap<Integer, ArrayList<Object>> getMatchData() {
        return matchData;
    }

    public ArrayList<Object> getScores(int r) {
        Row row = sheet.getRow(r);
        
        Iterator cells;
        Cell cell = row.getCell(0);
        int count = 1;
        
        cells = row.cellIterator();
        while (cells.hasNext() && cell != null && cell.getCellTypeEnum() != CellType.BLANK) {
            cell = (Cell) cells.next();
            if (cell.getCellTypeEnum() == CellType.STRING) {
                scores.add(cell.getStringCellValue());
            } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                scores.add(cell.getNumericCellValue());
            }
        }
        return scores;
    }

    public InputStream getInp() {
        return inp;
    }
    
    public Workbook getWorkbook() {
        return wb;
    }
    
    public void setWorkbook(Workbook wb){
        this.wb = wb;
    }
    
    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    @Override
    public String toString() {
        /*Iterator rows = sheet.rowIterator();
        rows.next();
        rows.next();
        rows.next(); //Optimal
        Row row = (Row) rows.next();

        Iterator cells;
        Cell cell = row.getCell(0);
        int count = 1;

        //Sets the keys of matchData to the match number
        while (rows.hasNext() && cell != null && cell.getCellTypeEnum() != CellType.BLANK) {
            cells = row.cellIterator();
            //Sets the values of matchData to an arrylist with data from the row
            while (cells.hasNext() && cell.getCellTypeEnum() != CellType.BLANK) {
                cell = (Cell) cells.next();
                if (cell.getCellTypeEnum() == CellType.STRING) {
                    scores.add(cell.getStringCellValue());
                } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                    scores.add(cell.getNumericCellValue());
                }
            }
            matchData.put(count, scores);
            row = (Row) rows.next();
            cell = row.getCell(0);
            System.out.println("Scores: " + scores.toString()); //prints each rows data to check that it's working
            scores.clear();
            count++;*/
        return "tostring isnt working rn";
    }
}
