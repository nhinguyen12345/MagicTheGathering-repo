/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DBMSDemo;

import bo.Wishlist;

import dao.WishlistHandler;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nhinguyen
 */
public class FrmViewWishList extends javax.swing.JInternalFrame {
private WishlistHandler WishlistHandler = new WishlistHandler(); 
    private void refreshTable(){
        try {
            populateWishlist();
        } catch (SQLException ex) {
            Logger.getLogger(FrmViewCardMarket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    List<Wishlist> Wishlist;
    private void populateWishlist() throws SQLException{
        String keyword = txtKeyWord.getText();
        Wishlist = WishlistHandler.loadWishlist(keyword);
        String columns[] = new String[]{"UserId", "CardId", "RankPreference"};
        DefaultTableModel tblModel = new DefaultTableModel(columns,0){
            @Override
            public boolean isCellEditable(int i, int i1){
                return false;
            }
        };    
        Wishlist.forEach((card)->{
            //Convert card to a row and add it
            tblModel.addRow(card.getRow());  
        });
        tblwl.setModel(tblModel);
      
         
    }
    public FrmViewWishList() {
        initComponents();
        try {
            populateWishlist();
        } catch (SQLException ex) {
            Logger.getLogger(FrmViewWishList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Creates new form NewJInternalFrame
     */
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtKeyWord = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblwl = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Wish List");

        jLabel1.setText("Search");

        btnSearch.setText("Enter");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tblwl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblwl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblwlMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblwl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtKeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearch))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btnRefresh))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelete)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnRefresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            populateWishlist();
        } catch (SQLException ex) {
            Logger.getLogger(FrmViewWishList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //Get the selected row:
        int selectedRow = tblwl.getSelectedRow();
        if(selectedRow!=-1){
            int UserId = (int) tblwl.getValueAt(selectedRow, 0);//1st column
            int ret = JOptionPane.showConfirmDialog(this, String.format("Deleting card ID %d", UserId));
            if (ret == JOptionPane.OK_OPTION){
                WishlistHandler.deleteCard(UserId);
                refreshTable();
            }

        }else{
            JOptionPane.showMessageDialog(this, "Please select card to delete");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblwlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblwlMouseClicked
        //know if it is double click
        if(evt.getClickCount()==2){
            //get the selected card
            Wishlist WishList = Wishlist.get(tblwl.getSelectedRow());
            FrmUpdateWishList frmUpdateWishlist = new FrmUpdateWishList(null, true);
            frmUpdateWishlist.setCard(WishList);
            frmUpdateWishlist.setVisible(true);
            if (frmUpdateWishlist.getReturnStatus() == FrmUpdateWishList.RET_OK){
                refreshTable();
            }
        }
    }//GEN-LAST:event_tblwlMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblwl;
    private javax.swing.JTextField txtKeyWord;
    // End of variables declaration//GEN-END:variables
}
