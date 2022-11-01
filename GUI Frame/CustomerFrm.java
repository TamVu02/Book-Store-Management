/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static View.HomeFrm.bookTree;
import bookstore_projectcsd301.book;
import bookstore_projectcsd301.bookData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static View.HomeFrm.manager;
import static View.HomeFrm.manager;
import static View.HomeFrm.selectedBook;
import bookstore_projectcsd301.manageBook;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.scripts.JO;

/**
 *
 * @author ADMIN
 */
public class CustomerFrm extends javax.swing.JFrame implements ActionListener {

    private ArrayList<bookData> inorder, postorder, preorder;
    private DefaultTableModel model1, model2, model3, modelCart;
    private int selectedIndex;
    private javax.swing.JTable selectedTable;
    private ArrayList<bookData> cart;

    /**
     * Creates new form ManagerFrm
     */
    public CustomerFrm() {
        initComponents();
        inorder = manager.inorderGUI(bookTree);
        preorder = manager.preorderGUI(bookTree);
        postorder = manager.postorderGUI(bookTree);
        setLocationRelativeTo(null);
        btnAddToCart.addActionListener(this);
        btnSearch.addActionListener(this);
        btnCancel.addActionListener(this);
        btnRefresh.addActionListener(this);
        model1 = (DefaultTableModel) tblBookInorder.getModel();
        model2 = (DefaultTableModel) tblBookPreorder.getModel();
        model3 = (DefaultTableModel) tblBookPostorder.getModel();
        modelCart = (DefaultTableModel) tblCart.getModel();
        cart = new ArrayList<>();
        this.setTitle("Customer Menu");
        showResultInformationTable();

    }

    public void showResulCartTable() {
        modelCart.setRowCount(0);
        if (!cart.isEmpty()) {
            for (bookData b : cart) {
                modelCart.addRow(new Object[]{
                    b.getBookID(), b.getTitle()
                });
            }
        }
    }

    public void showResultInformationTable() {
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
        btnAddToCart = new javax.swing.JButton();
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
        btnInformation = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        btnRemoveFromCart = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAddToCart.setText("Add to Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Customer Menu");

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

        btnInformation.setText("Infomation");
        btnInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformationActionPerformed(evt);
            }
        });

        btnCheckOut.setText("CheckOut");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title"
            }
        ));
        jScrollPane4.setViewportView(tblCart);
        if (tblCart.getColumnModel().getColumnCount() > 0) {
            tblCart.getColumnModel().getColumn(0).setResizable(false);
            tblCart.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        btnRemoveFromCart.setText("Remove from Cart");
        btnRemoveFromCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFromCartActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Cart");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnAddToCart)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                            .addComponent(btnRemoveFromCart)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh)
                        .addGap(41, 41, 41)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel)
                            .addComponent(btnRefresh)
                            .addComponent(btnInformation)
                            .addComponent(btnSearch)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddToCart)
                            .addComponent(btnRemoveFromCart)
                            .addComponent(btnCheckOut))))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
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
            JOptionPane.showMessageDialog(rootPane, "Please choose one book first", "", JOptionPane.ERROR_MESSAGE);
        } else {
            if (selectedTab == 0) {
                selectedBook = inorder.get(selectedIndex);
            } else if (selectedTab == 1) {
                selectedBook = preorder.get(selectedIndex);
            } else {
                selectedBook = postorder.get(selectedIndex);
            }
            cart.add(selectedBook);
            showResulCartTable();
        }
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        int id = 0;
        boolean isOK = true;
        try {
            id = Integer.parseInt(JOptionPane.showInputDialog(rootPane, "PLease enter Book ID:"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Input must be a positive integer", "", JOptionPane.ERROR_MESSAGE);
            isOK = false;
        }
        if (isOK) {
            if (!manager.checkDuplicate(bookTree, id)) {
                JOptionPane.showMessageDialog(rootPane, "Id not found", "", JOptionPane.ERROR_MESSAGE);
            } else {
                selectedBook = manager.searchBookFromTree(bookTree, id).data;
                SearchThenBuyFrm search = new SearchThenBuyFrm(this, rootPaneCheckingEnabled);
                search.setEditDataDelete(selectedBook);
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
        showResultInformationTable();
        showResulCartTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnRemoveFromCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFromCartActionPerformed
        // TODO add your handling code here:

        selectedIndex = tblCart.getSelectedRow();
        if (cart.size() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please adding a book to Cart first", "", JOptionPane.ERROR_MESSAGE);
        }
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(rootPane, "Please choose one book from Cart first", "", JOptionPane.ERROR_MESSAGE);
        } else {
            selectedBook = cart.get(selectedIndex);
            if (JOptionPane.showConfirmDialog(rootPane, "Do you really want to delete this book from Cart", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
                cart.remove(selectedBook);
                showResulCartTable();
                JOptionPane.showMessageDialog(rootPane, "Remove successfully");
            }
        }
    }//GEN-LAST:event_btnRemoveFromCartActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        // TODO add your handling code here:
        if (cart.size() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Cart empty", "", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(rootPane, "Do you realy want to check out", "", JOptionPane.YES_NO_OPTION) == 0) {
                int length = cart.size();
                for (int i = 0; i < length; i++) {
                    cart.remove(0);
                }
                showResulCartTable();
                JOptionPane.showMessageDialog(rootPane, "Buy succsessfully");
            }
        }
    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void btnInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformationActionPerformed
        // TODO add your handling code here:
        if (tblCart.getSelectedRow() > -1) {
            selectedBook = cart.get(tblCart.getSelectedRow());
            InformationFrm info = new InformationFrm(this, rootPaneCheckingEnabled);
            info.setEditDataDelete(selectedBook);
            info.setVisible(true);
        } else {
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
                JOptionPane.showMessageDialog(rootPane, "Please choose one book first", "", JOptionPane.ERROR_MESSAGE);
            } else {
                if (selectedTab == 0) {
                    selectedBook = inorder.get(selectedIndex);
                } else if (selectedTab == 1) {
                    selectedBook = preorder.get(selectedIndex);
                } else {
                    selectedBook = postorder.get(selectedIndex);
                }
                InformationFrm info = new InformationFrm(this, rootPaneCheckingEnabled);
                info.setEditDataDelete(selectedBook);
                info.setVisible(true);

            }

        }
    }//GEN-LAST:event_btnInformationActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnInformation;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRemoveFromCart;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblBookInorder;
    private javax.swing.JTable tblBookPostorder;
    private javax.swing.JTable tblBookPreorder;
    private javax.swing.JTable tblCart;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    void addToCart(bookData b) {
        cart.add(b);
        showResulCartTable();
    }

}