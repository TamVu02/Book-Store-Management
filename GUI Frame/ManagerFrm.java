/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import bookstore_projectcsd301.book;
import bookstore_projectcsd301.bookData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static View.HomeFrm.manager;
import static View.HomeFrm.bookTree;
import static View.HomeFrm.selectedBook;
import bookstore_projectcsd301.manageBook;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class ManagerFrm extends javax.swing.JFrame implements ActionListener {

    private ArrayList<bookData> inorder;
    private ArrayList<bookData> postorder;
    private ArrayList<bookData> preorder;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private DefaultTableModel model3;
    private int selectedIndex;
    private javax.swing.JTable selectedTable;

    /**
     * Creates new form ManagerFrm
     */
    public ManagerFrm() {
        initComponents();
        inorder = manager.inorderGUI(bookTree);
        preorder = manager.preorderGUI(bookTree);
        postorder = manager.postorderGUI(bookTree);
        setLocationRelativeTo(null);
        btnDelete.addActionListener(this);
        btnSearch.addActionListener(this);
        btnCancel.addActionListener(this);
        btnRefresh.addActionListener(this);
        model1 = (DefaultTableModel) tblBookInorder.getModel();
        model2 = (DefaultTableModel) tblBookPreorder.getModel();
        model3 = (DefaultTableModel) tblBookPostorder.getModel();
        this.setTitle("Manager Menu");
        showResult();

    }

    public boolean updateBookWithBtnSearch(manageBook manager, book bookTree, bookData newBook) {
       int id = selectedBook.getBookID();
        if (!manager.checkDuplicateUpdate(bookTree, id, newBook.getBookID())) {
            this.deleteBook(bookTree, manager, id);
            this.insertBook(bookTree, manager, newBook);
            showResult();
            return true;
        }
        else{
            return false;
        }
    }

    public boolean updateBookWtihBtnUpdate(manageBook manager, book bookTree, bookData newBook) {
        int selectedTab = jTabbedPane1.getSelectedIndex();
        int id = 0;
        if (selectedTab == 0) {
            id = inorder.get(selectedIndex).getBookID();
        }
        if (selectedTab == 1) {
            id = preorder.get(selectedIndex).getBookID();
        }
        if (selectedTab == 2) {
            id = postorder.get(selectedIndex).getBookID();
        }
        if (!manager.checkDuplicateUpdate(bookTree, id, newBook.getBookID())) {
            this.deleteBook(bookTree, manager, id);
            this.insertBook(bookTree, manager, newBook);
            showResult();
            return true;
        }
        else{
            return false;
        }

    }

    public void deleteBook(book bookTree, manageBook manager, int id) {
        manager.setHeader(bookTree);
        manager.delBookFromTree(bookTree, id);
        bookTree = manager.getHeader();
        manager.updateTree(bookTree);
        showResult();
    }

    public void insertBook(book bookTree, manageBook manager, bookData newBook) {
        manager.setHeader(bookTree);
        manager.insert(newBook);
        bookTree = manager.getHeader();
        manager.updateTree(bookTree);
        showResult();
    }

    public void showResult() {
        inorder = manager.inorderGUI(bookTree);
        preorder = manager.preorderGUI(bookTree);
        postorder = manager.postorderGUI(bookTree);
        int length = inorder.size();
        model1.setRowCount(0);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String toPrint = "";
        for (int i = 0; i < length; i++) {
            bookData b = inorder.get(i);
            try {
                toPrint = format.format(b.getPublicDate());
            } catch (Exception e) {
            }
            model1.addRow(new Object[]{
                b.getBookID(), b.getTitle(), b.getAuthors(), b.getNumPage(), b.getAvgRating(), toPrint, b.getPublisher()
            });
        }
        model2.setRowCount(0);
        for (int i = 0; i < length; i++) {
            bookData b = preorder.get(i);
            try {
                toPrint = format.format(b.getPublicDate());
            } catch (Exception e) {
            }
            model2.addRow(new Object[]{
                b.getBookID(), b.getTitle(), b.getAuthors(), b.getNumPage(), b.getAvgRating(), toPrint, b.getPublisher()
            });
        }
        model3.setRowCount(0);
        for (int i = 0; i < length; i++) {
            bookData b = postorder.get(i);
            try {
                toPrint = format.format(b.getPublicDate());
            } catch (Exception e) {
            }
            model3.addRow(new Object[]{
                b.getBookID(), b.getTitle(), b.getAuthors(), b.getNumPage(), b.getAvgRating(), toPrint, b.getPublisher()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBookInorder = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBookPreorder = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBookPostorder = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSearch.setText("Search");
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

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Manager Menu");

        jLabel2.setText("Available Books");

        tblBookInorder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Authors", "Number of Pages", "Rating", "Publish Date", "Publisher"
            }
        ));
        jScrollPane1.setViewportView(tblBookInorder);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Inorder", jPanel1);

        jLabel3.setText("Available Books");

        tblBookPreorder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Authors", "Number of Pages", "Rating", "Publish Date", "Publisher"
            }
        ));
        jScrollPane2.setViewportView(tblBookPreorder);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Preorder", jPanel2);

        jLabel4.setText("Available Books");

        tblBookPostorder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Authors", "Number of Pages", "Rating", "Publish Date", "Publisher"
            }
        ));
        jScrollPane3.setViewportView(tblBookPostorder);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("PostOrder", jPanel3);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(59, 59, 59)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addGap(41, 41, 41)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnInsert)
                .addGap(28, 28, 28)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addGap(81, 81, 81))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnRefresh))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        InputFrm inputFrm = new InputFrm(this, rootPaneCheckingEnabled);
        inputFrm.setVisible(true);
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int selectedTab = jTabbedPane1.getSelectedIndex();
        if (selectedTab == 0) {
            selectedTable = tblBookInorder;
        }
        if (selectedTab == 1) {
            selectedTable = tblBookPreorder;
        }
        if (selectedTab == 2) {
            selectedTable = tblBookPostorder;
        }
        selectedIndex = selectedTable.getSelectedRow();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(rootPane, "Please choose one row then click Update","", JOptionPane.ERROR_MESSAGE);
        } else {
            UpdateFrm update = new UpdateFrm(this, rootPaneCheckingEnabled);
            if (selectedTab == 0) {
                update.setEditData(inorder.get(selectedIndex));
            }
            if (selectedTab == 1) {
                update.setEditData(preorder.get(selectedIndex));
            }
            if (selectedTab == 2) {
                update.setEditData(postorder.get(selectedIndex));
            }

            update.setVisible(true);
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int id = 0;
        int selectedTab = jTabbedPane1.getSelectedIndex();
        if (selectedTab == 0) {
            selectedTable = tblBookInorder;
        }
        if (selectedTab == 1) {
            selectedTable = tblBookPreorder;
        }
        if (selectedTab == 2) {
            selectedTable = tblBookPostorder;
        }
        selectedIndex = selectedTable.getSelectedRow();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(rootPane, "Please choose one row then click Delete","", JOptionPane.ERROR_MESSAGE);
        } else {
            if (selectedTab == 0) {
                id = inorder.get(selectedIndex).getBookID();
            }
            if (selectedTab == 1) {
                id = preorder.get(selectedIndex).getBookID();
            }
            if (selectedTab == 2) {
                id = postorder.get(selectedIndex).getBookID();
            }
            this.deleteBook(bookTree, manager, id);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        int id = 0;
        boolean isOK = true;
        try {
            id = Integer.parseInt(JOptionPane.showInputDialog(rootPane, "PLease enter Book ID:"));
            selectedBook = manager.searchBookFromTree(bookTree, id).data;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Input must be a positive integer","", JOptionPane.ERROR_MESSAGE);
            isOK = false;
        }
        if (isOK) {
            if (!manager.checkDuplicate(bookTree, id)) {
                JOptionPane.showMessageDialog(rootPane, "Id not found","", JOptionPane.ERROR_MESSAGE);
            } else {
                SearchThenManageFrm search = new SearchThenManageFrm(this, rootPaneCheckingEnabled);
                search.setEditDataUpdate(manager.searchBookFromTree(bookTree, id).data);
                search.setVisible(true);
            }
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        new HomeFrm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        showResult();
    }//GEN-LAST:event_btnRefreshActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(ManagerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerFrm().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblBookInorder;
    private javax.swing.JTable tblBookPostorder;
    private javax.swing.JTable tblBookPreorder;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
