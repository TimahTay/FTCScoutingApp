package com.timdan.ftcscoutingapp;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class MatchDataMap extends TreeMap {

    private final InputStream inp;
    private Workbook wb;
    private Sheet sheet;
    
    private final TreeMap<Integer, ArrayList<Object>> matchData;
    private final ArrayList<Object> scores;
    
    private int rowCount = 0;
    
    
    public MatchDataMap(InputStream i) throws IOException, InvalidFormatException {
        
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
        14 - scores:autonomous
        15 - scores:teleop
        16 - scores:endgame
        17 - scores:final
        18 - notes
        */
        
        inp = i;
        wb = WorkbookFactory.create(inp);
        sheet = wb.getSheetAt(0);
        
        matchData = new TreeMap();
        scores = new ArrayList();
    }

    public TreeMap<Integer, ArrayList<Object>> getMatchData() {
        return matchData;
    }
    
    public ArrayList<Object> getScores() {
        return scores;
    }

    public ArrayList<Object> getExcelScore(int r) {
        
        Row row = sheet.getRow(r);
        Iterator cells = row.cellIterator();
        
        Cell cell = row.getCell(0);
        
        ArrayList scores = new ArrayList();

        for (int i = 0; i < 18; i++) {
            cell = (Cell) cells.next();
            if (cell.getCellTypeEnum() == CellType.STRING) {
                scores.add(cell.getStringCellValue());
            } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                scores.add(cell.getNumericCellValue());
            } else if (cell.getCellTypeEnum() == CellType.FORMULA) {
                scores.add(cell.getNumericCellValue());
            } else if (cell.getCellTypeEnum() == CellType.BLANK) {
                scores.add(null);
            }
        }
        
        return scores;
    }
    
    public void setMatchData() {
        
        Row row = sheet.getRow(3);
        
        int index = 3;
        while (sheet.getRow(index).getCell(0).getCellTypeEnum() != CellType.BLANK) {
            matchData.put(index-3, getExcelScore(index));
            index++;
            rowCount++;
        }
        
        Set set = matchData.entrySet();
        Iterator i = set.iterator();
        
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
    }

    public InputStream getInp() {
        return inp;
    }
    
    public Workbook getWorkbook() {
        return wb;
    }
    
    public int getRowCount() {
        return rowCount;
    }
    
    public void setWorkbook(Workbook wb){
        this.wb = wb;
    }
    
    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }
}
