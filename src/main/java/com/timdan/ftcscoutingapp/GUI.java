package com.timdan.ftcscoutingapp;
import com.timdan.ftcscoutingapp.MatchDataMap;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Tim Tersigni & Daniel Lee
 */
public class GUI extends javax.swing.JFrame {
    InputStream inp;
    MatchDataMap matchData;
    
    String startCB[] = {"Total Score"};
    String autoCB[] = {"Total Autonomous Score", "Glyph Score"};
    String teleopCB[] = {"Total Teleop Score", "Glyph Score", "Endgame Score", "Relic Score"};
    
    /**
     * Creates new form GUI
     */
    public GUI() throws FileNotFoundException, IOException, InvalidFormatException {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableTeamRankings = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableMatchData = new javax.swing.JTable();
        lableMatchData = new javax.swing.JLabel();
        lableTeamRankings = new javax.swing.JLabel();
        comboBox_Phase = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        comboBox_Criteria = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        button_Sort = new javax.swing.JButton();
        button_OpenInstructions = new javax.swing.JButton();
        button_OpenTemplate = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuItemImport = new javax.swing.JMenuItem();
        menuItemExport = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scouting Calculator");

        tableTeamRankings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Team", "Score", "Ranking"
            }
        ));
        jScrollPane1.setViewportView(tableTeamRankings);
        if (tableTeamRankings.getColumnModel().getColumnCount() > 0) {
            tableTeamRankings.getColumnModel().getColumn(1).setMinWidth(50);
            tableTeamRankings.getColumnModel().getColumn(1).setMaxWidth(50);
            tableTeamRankings.getColumnModel().getColumn(2).setMinWidth(50);
            tableTeamRankings.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        tableMatchData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Team", "Autonomous Score", "Teleop Score (Glyphs)", "Endgame Score", "Total Score"
            }
        ));
        jScrollPane3.setViewportView(tableMatchData);

        lableMatchData.setText("Match Data");

        lableTeamRankings.setText("Team Rankings");

        comboBox_Phase.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Autonomous", "Teleop" }));
        comboBox_Phase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_PhaseActionPerformed(evt);
            }
        });

        jLabel1.setText("Sort By:");

        comboBox_Criteria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT GAME PHASE" }));
        comboBox_Criteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_CriteriaActionPerformed(evt);
            }
        });

        jLabel2.setText("Game Phase");

        jLabel3.setText("Criteria");

        button_Sort.setText("Sort Teams");
        button_Sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_SortActionPerformed(evt);
            }
        });

        button_OpenInstructions.setText("Open Instructions");
        button_OpenInstructions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_OpenInstructionsActionPerformed(evt);
            }
        });

        button_OpenTemplate.setText("Open Template");
        button_OpenTemplate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_OpenTemplateActionPerformed(evt);
            }
        });

        MenuBar.setName("Scouting Calculator GUI"); // NOI18N

        menuFile.setText("File");

        menuItemImport.setText("Import");
        menuItemImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemImportActionPerformed(evt);
            }
        });
        menuFile.add(menuItemImport);

        menuItemExport.setText("Export");
        menuItemExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExportActionPerformed(evt);
            }
        });
        menuFile.add(menuItemExport);

        MenuBar.add(menuFile);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lableMatchData))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lableTeamRankings)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(comboBox_Phase, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboBox_Criteria, 0, 194, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addComponent(button_Sort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(button_OpenInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_OpenTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lableMatchData)
                    .addComponent(lableTeamRankings))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(comboBox_Phase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox_Criteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(button_Sort)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_OpenInstructions, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(button_OpenTemplate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemImportActionPerformed

        JOptionPane.showMessageDialog(this, "Make sure your match data file is in .xlsx format!");
        JFileChooser jfc = new JFileChooser();
        if (jfc.showOpenDialog(menuFile) == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            try {
                inp = new FileInputStream(file.getAbsolutePath());
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "ERROR: Import Failed, can not find file");
            }
            try {
                matchData = new MatchDataMap(inp);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ERROR: Import Failed, wrong file type");
            }
            matchData.setMatchData();
            setTable();
        }
    }//GEN-LAST:event_menuItemImportActionPerformed

    private void comboBox_PhaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_PhaseActionPerformed
                
        String phase = (String)comboBox_Phase.getSelectedItem();
        
        switch (phase) {
            case "Autonomous":
                comboBox_Criteria.removeAllItems();
                for (int i = 0; i < autoCB.length; i++) {
                    comboBox_Criteria.addItem(autoCB[i]);
                }
                break;
            case "Teleop":
                comboBox_Criteria.removeAllItems();
                for (int i = 0; i < teleopCB.length; i++) {
                    comboBox_Criteria.addItem(teleopCB[i]);
                }
                break;
            default:
                comboBox_Criteria.removeAllItems();
                for (int i = 0; i < startCB.length; i++) {
                    comboBox_Criteria.addItem(startCB[i]);
                }
                break;
        }
    }//GEN-LAST:event_comboBox_PhaseActionPerformed

    private void comboBox_CriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_CriteriaActionPerformed
   
    }//GEN-LAST:event_comboBox_CriteriaActionPerformed

    private void button_SortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_SortActionPerformed
        
        String phase = (String)comboBox_Phase.getSelectedItem();
        String criteria = (String)comboBox_Criteria.getSelectedItem();
        
        switch (phase) {
            case "Autonomous":
                if (criteria.equals(autoCB[0])) {
                    DefaultTableModel model = (DefaultTableModel) tableTeamRankings.getModel();
                    model.setRowCount(0);
                    for (int i = 0; i < matchData.getRowCount(); i++) {
                        model.addRow(rank(14)[i]);
                    }
                } else if (criteria.equals(autoCB[1])) {
                    DefaultTableModel model = (DefaultTableModel) tableTeamRankings.getModel();
                    model.setRowCount(0);
                    for (int i = 0; i < matchData.getRowCount(); i++) {
                        model.addRow(rank(3)[i]);
                    }
                }
                
                break;
            case "Teleop":
                if (criteria.equals(teleopCB[0])) {
                    DefaultTableModel model = (DefaultTableModel) tableTeamRankings.getModel();
                    model.setRowCount(0);
                    for (int i = 0; i < matchData.getRowCount(); i++) {
                        model.addRow(rank(15)[i]);
                    }
                } else if (criteria.equals(teleopCB[1])) {
                    DefaultTableModel model = (DefaultTableModel) tableTeamRankings.getModel();
                    model.setRowCount(0);
                    for (int i = 0; i < matchData.getRowCount(); i++) {
                        model.addRow(rank(5)[i]);
                    }
                } else if (criteria.equals(teleopCB[2])) {
                    DefaultTableModel model = (DefaultTableModel) tableTeamRankings.getModel();
                    model.setRowCount(0);
                    for (int i = 0; i < matchData.getRowCount(); i++) {
                        model.addRow(rank(16)[i]);
                    }
                } else if (criteria.equals(teleopCB[3])) {
                    DefaultTableModel model = (DefaultTableModel) tableTeamRankings.getModel();
                    model.setRowCount(0);
                    for (int i = 0; i < matchData.getRowCount(); i++) {
                        model.addRow(rank(9)[i]);
                    }
                }
                break;
            default:
                if (criteria.equals(startCB[0])) {
                    DefaultTableModel model = (DefaultTableModel) tableTeamRankings.getModel();
                    model.setRowCount(0);
                    for (int i = 0; i < matchData.getRowCount(); i++) {
                        model.addRow(rank(17)[i]);
                    }
                }
                break;
        }
    }//GEN-LAST:event_button_SortActionPerformed

    private void menuItemExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExportActionPerformed
        // Creates new excel sheet for output
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Team Rankings");
       
        // Loops through Jtable and copies to a 2D array "teamRankings"
        Object[][] teamRankings = new Object[tableTeamRankings.getRowCount()][tableTeamRankings.getColumnCount()];
        int arraySpotX = 0;
        int arraySpotY = 0;
        for(int row = 0; row < tableTeamRankings.getRowCount(); row++){
            for(int col = 0; col < tableTeamRankings.getColumnCount(); col++){
                teamRankings[arraySpotY][arraySpotX] = tableTeamRankings.getValueAt(row, col);
                arraySpotX++;
            }
            arraySpotY++;
            arraySpotX = 0;
        }
        System.out.println(Arrays.deepToString(teamRankings));
        
        // Populates excel file with data from 2D array
        int rowCount = 0;
       
        for (Object[] i : teamRankings){
            Row row = sheet.createRow(++rowCount);
           
            int columnCount = 0;
           
            for(int j = 0; j < i.length; j++){
                Cell cell = row.createCell(columnCount);
                columnCount++;
                if (i[j] instanceof String) {
                    cell.setCellValue((String) i[j]);
                } else if (i[j] instanceof Integer) {
                    cell.setCellValue((Integer) j);
                }
                else if (i[j] instanceof Double) {
                    cell.setCellValue(Math.round((Double) i[j]));
                }
            }
            sheet.setColumnWidth(0, 10000);
        }
       
        JFileChooser jfc = new JFileChooser();
       
            try {
                jfc.setFileSelectionMode(2);
                if (jfc.showSaveDialog(menuFile) == JFileChooser.APPROVE_OPTION) {
                    String path = jfc.getSelectedFile().getAbsolutePath();
                    String filename = jfc.getSelectedFile().getName();
                    FileOutputStream outputStream = new FileOutputStream(path);
                    workbook.write(outputStream);
                    JOptionPane.showMessageDialog(this, "Team Rankings List Exported Successfully!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ERROR: Export Failed. Please be sure file location\n" + "is accesible and privileges are correct: \n" + ex.toString());
            }
    }//GEN-LAST:event_menuItemExportActionPerformed

    private void button_OpenInstructionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_OpenInstructionsActionPerformed
        ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "instructions.txt");
        
        try {
            pb.start();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_OpenInstructionsActionPerformed

    private void button_OpenTemplateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_OpenTemplateActionPerformed
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI("https://docs.google.com/spreadsheets/d/1VUj6pTyMhXqdFx52PZCcmLmfDHATZcK8M7c4OJICE7Y/edit#gid=0");
            desktop.browse(oURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_button_OpenTemplateActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException, FileNotFoundException, InvalidFormatException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidFormatException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    public void setTable() {
        ArrayList<Object> output;
        for (int i = 0; i < matchData.getRowCount(); i++) {
            output = (ArrayList<Object>)matchData.getMatchData().get(i);
            tableMatchData.getModel().setValueAt(output.get(0), i, 0);
            tableMatchData.getModel().setValueAt(Math.round((Double)(output.get(14))), i, 1);
            tableMatchData.getModel().setValueAt(Math.round((Double)(output.get(15))), i, 2);
            tableMatchData.getModel().setValueAt(Math.round((Double)(output.get(16))), i, 3);
            tableMatchData.getModel().setValueAt(Math.round((Double)(output.get(17))), i, 4);
        }
    }
    
    public Object[][] rank(int index) {
        
        /*
        ArrayList<Object> team = new ArrayList();
        ArrayList<Double> value = new ArrayList();
        
        for (int i = 0; i < matchData.getRowCount(); i++) {
            value.add((Double)matchData.getMatchData().get(i).get(index));
        }
        
        for (int i = 0; i < matchData.getRowCount(); i++) {
            if (!team.contains(matchData.getMatchData().get(i).get(0))) {
                team.set(i, matchData.getMatchData().get(i).get(0));
            } else {
                double hold = value.get(team.indexOf(matchData.getMatchData().get(i).get(0)));
                //value.set(team.indexOf(matchData.getMatchData().get(i).get(0)), hold+);
                team.set(i, null);
            }
        }
    
        
        Map<Object,Integer> multiMap = new HashMap();
        
        for (int i = 0; i < matchData.getRowCount(); i++) {
            if (!multiMap.containsKey(matchData.getMatchData().get(i).get(0))) {
                //multiMap.put(matchData.getMatchData().get(i).get(0)), );
            }
        }
        */
        
        // Sorts by criteria
        Object[][] ranking = new Object[matchData.getRowCount()][2];
        for (int i = 0; i < matchData.getRowCount(); i++) {
            ranking[i][0] = matchData.getMatchData().get(i).get(0);
            if (index == 3)       ranking[i][1] = (double)(matchData.getMatchData().get(i).get(index))*15.0 
                                                + (matchData.getMatchData().get(i).get(index+1).equals("Y") ? 30.0 : 0.0);
            else if (index == 5)  ranking[i][1] = (double)(matchData.getMatchData().get(i).get(index))*2.0
                                                + (double)matchData.getMatchData().get(i).get(index+1)*10.0
                                                + (double)matchData.getMatchData().get(i).get(index+2)*20.0
                                                + (double)matchData.getMatchData().get(i).get(index+3)*30.0;
            else if (index == 9)  ranking[i][1] = ((double)matchData.getMatchData().get(i).get(index) == 1.0 ? 10.0 
                                                  : (double)matchData.getMatchData().get(i).get(index) == 2.0 ? 20.0 
                                                  : (double)matchData.getMatchData().get(i).get(index) == 3.0 ? 40.0 : 0.0) 
                                                + (matchData.getMatchData().get(i).get(index+1).equals("Y") ? 15.0 : 0.0)
                                                + ((double)matchData.getMatchData().get(i).get(index+2) == 1.0 ? 10.0 
                                                  : (double)matchData.getMatchData().get(i).get(index+2) == 2.0 ? 20.0 
                                                  : (double)matchData.getMatchData().get(i).get(index+2) == 3.0 ? 40.0 : 0.0) 
                                                + (matchData.getMatchData().get(i).get(index+3).equals("Y") ? 15.0 : 0.0);
            else if (index == 15) ranking[i][1] = (double)matchData.getMatchData().get(i).get(index)
                                                + (double)matchData.getMatchData().get(i).get(index+1); 
            else ranking[i][1] = matchData.getMatchData().get(i).get(index); 
        }

        for (int i = (ranking.length - 1); i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                double a = (double)(ranking[j-1][1]);
                double b = (double)(ranking[j][1]);
                String a1 = ""+ranking[j-1][0];
                String b1 = ""+ranking[j][0];
                if (a < b) {
                    double temp = a;
                    ranking[j-1][1] = b;
                    ranking[j][1] = temp;
                    
                    String buffer = a1;
                    ranking[j-1][0] = b1;
                    ranking[j][0] = buffer;
                }
            }
        }
        
        System.out.println(Arrays.deepToString(ranking));
        
        return ranking;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton button_OpenInstructions;
    private javax.swing.JButton button_OpenTemplate;
    private javax.swing.JButton button_Sort;
    private javax.swing.JComboBox<String> comboBox_Criteria;
    private javax.swing.JComboBox<String> comboBox_Phase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lableMatchData;
    private javax.swing.JLabel lableTeamRankings;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuItemExport;
    private javax.swing.JMenuItem menuItemImport;
    private javax.swing.JTable tableMatchData;
    private javax.swing.JTable tableTeamRankings;
    // End of variables declaration//GEN-END:variables
}
