/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien;

/**
 *
 * @author minh
 */
import DAO.DuLieuBang;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import DAO.*;
import Object.*;
import java.awt.event.InputEvent;
//import com.sun.glass.events.KeyEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class QuanLyPhieuMuonSachPanel extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyPhieuMuonSachPanel
     */
    public static String sql = "select * from PHIEUMUONSACH order by MAPHIEUMUONSACH asc";
    public static String sql1 = "select count(*) as tong from PHIEUMUONSACH ";
    public static Connection conn = Connect.getConnect();
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public ArrayList<Sach> listSach = new ArrayList<Sach>();
    private String strMS = "";
    private String madg;
    SimpleDateFormat formatter = new SimpleDateFormat("d MMM, y");
    java.util.Date date = new java.util.Date();

    public QuanLyPhieuMuonSachPanel() {
        initComponents();
        showtb();
        loadcbb();
        loadsach();
        setBackground(Color.white);

        txtMaPhieuMuonSach.setVisible(false);
        lbMaPhieuMuonSach.setVisible(false);
        lbMaDocGia.setVisible(false);
        txtMaDocGia.setVisible(false);
        txtNgayMuon.setText(formatter.format(date));
        
    }

    public final void showtb() {
        DuLieuBang.Load(sql, tbPhieuMuonSach);
    }

    public int dem() {
        int temp = 0;

        try {
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            while (rs.next()) {
                temp = rs.getInt("tong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyPhieuMuonSachPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }

    public void loadcbb() {
        cbbMaDG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        cbbMaDG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        ArrayList<String> list = PhieuMuonSachDAO.LoadDataCbb();
        for (String item : list) {
            cbbMaDG.addItem(item.toString());
        }
    }

    public void loadsach() {
        ArrayList<String> list = PhieuMuonSachDAO.LoadSach();
//        final DefaultListModel vegName = new DefaultListModel();
        String[] mang = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            mang[i] = list.get(i);
        }
        listSachMuon.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = mang;

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btThemMoi = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btLamMoi = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbMaPhieuMuonSach = new javax.swing.JLabel();
        lbcbb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaPhieuMuonSach = new javax.swing.JTextField();
        lbMaSach = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMaSach = new javax.swing.JTable();
        cbbMaDG = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listSachMuon = new javax.swing.JList<>();
        txtMaDocGia = new javax.swing.JTextField();
        lbMaDocGia = new javax.swing.JLabel();
        txtNgayMuon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPhieuMuonSach = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1074, 571));

        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        btThemMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-add-50.png"))); // NOI18N
        btThemMoi.setFocusable(false);
        btThemMoi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btThemMoi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemMoiActionPerformed(evt);
            }
        });
        jToolBar1.add(btThemMoi);
        jToolBar1.add(jSeparator3);

        btLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-refresh-50.png"))); // NOI18N
        btLamMoi.setFocusable(false);
        btLamMoi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btLamMoi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLamMoiActionPerformed(evt);
            }
        });
        jToolBar1.add(btLamMoi);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.pink, null));
        jPanel1.setPreferredSize(new java.awt.Dimension(309, 394));

        lbMaPhieuMuonSach.setText("Mã phiếu mượn sách");

        lbcbb.setText("Mã độc giả");
        lbcbb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setText("Ngày mượn");

        txtMaPhieuMuonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhieuMuonSachActionPerformed(evt);
            }
        });

        lbMaSach.setText("Mã sách");

        tbMaSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "MASACH", "TENDAUSACH", "TINHTRANG"
            }
        ));
        tbMaSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMaSachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbMaSach);

        cbbMaDG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaDGActionPerformed(evt);
            }
        });

        listSachMuon.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "sách hiện có" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listSachMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSachMuonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listSachMuon);

        txtMaDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDocGiaActionPerformed(evt);
            }
        });

        lbMaDocGia.setText("Mã độc giả");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbMaSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbcbb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(lbMaDocGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbMaDG, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(txtMaDocGia)
                            .addComponent(txtNgayMuon)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbMaPhieuMuonSach)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaPhieuMuonSach)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbcbb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtNgayMuon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbMaSach, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaPhieuMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPhieuMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tbPhieuMuonSach.setModel(new javax.swing.table.DefaultTableModel(
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
                "MAPHIEUMUONSACH", "MADOCGIA", "NGAYMUON"
            }
        ));
        tbPhieuMuonSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPhieuMuonSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPhieuMuonSach);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ PHIẾU MƯỢN SÁCH");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 204), null));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        btTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/timkiem.png"))); // NOI18N
        btTimKiem.setFocusable(false);
        btTimKiem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btTimKiem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 153));
        jButton1.setText("CHI TIẾT MƯỢN SÁCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void tbPhieuMuonSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhieuMuonSachMouseClicked
        // TODO add your handling code here:
        try {
            lbcbb.setVisible(false);
            cbbMaDG.setVisible(false);
            listSachMuon.setVisible(false);
            lbMaDocGia.setVisible(true);
            txtMaDocGia.setVisible(true);

            int row = this.tbPhieuMuonSach.getSelectedRow();
            int MArow = (int) (this.tbPhieuMuonSach.getModel().getValueAt(row, 0));
            String sql1 = " select MAPHIEUMUONSACH, HOTEN , NGAYMUON from PHIEUMUONSACH,DOCGIA"
                    + " where PHIEUMUONSACH.MADOCGIA =DOCGIA.MADOCGIA AND MAPHIEUMUONSACH='" + MArow + "'";
            ResultSet rs = DuLieuBang.ShowTextField(sql1);
            String sql = " select CS.MASACH , DS.TENDAUSACH, CT.TINHTRANG\n "
                    + "from CUONSACH CS join DAUSACH DS on CS.MADAUSACH = DS.MADAUSACH join CTMS CT on CS.MASACH = CT.MASACH\n"
                    + "where CT.MAPHIEUMUONSACH = '" + MArow + "'";
            DuLieuBang.Load(sql, tbMaSach);
            if (rs.next()) {
                this.txtMaPhieuMuonSach.setText(rs.getString("MAPHIEUMUONSACH"));
                this.txtMaDocGia.setText(rs.getString("HOTEN"));
                this.txtNgayMuon.setText(rs.getString("NGAYMUON"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_tbPhieuMuonSachMouseClicked


    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed

        if (this.txtMaPhieuMuonSach.getText().length() != 0) {
            String sql2 = " select * from PHIEUMUONSACH where MAPHIEUMUONSACH like '%" + this.txtMaPhieuMuonSach.getText() + "%' ";
            DuLieuBang.Load(sql2, tbPhieuMuonSach);
        } else if (this.txtMaDocGia.getText().length() != 0) {
            String sql1 = " select * from PHIEUMUONSACH where MADOCGIA like '%" + this.txtMaDocGia.getText() + "%' ";
            DuLieuBang.Load(sql1, tbPhieuMuonSach);
        }  else if (this.txtTimKiem.getText().length() != 0) {
            String sql1 = "SELECT * FROM PHIEUMUONSACH where MAPHIEUMUONSACH like'%" + this.txtTimKiem.getText() + "%' "
                    + "or MADOCGIA like '%" + this.txtTimKiem.getText() + "%'";
            DuLieuBang.Load(sql1, tbPhieuMuonSach);
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập", "Thông báo", 1);
        }
//            } catch (SQLException ex) {
//                Logger.getLogger(QuanLyPhieuMuonSachPanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
        // Thread.sleep(4000);
        //  conn.commit();

        // } catch (SQLException ex) {
        //    Logger.getLogger(QuanLyPhieuMuonSachPanel.class.getName()).log(Level.SEVERE, null, ex);

    }//GEN-LAST:event_btTimKiemActionPerformed

    private void btThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemMoiActionPerformed
        // TODO add your handling code here:
//        if(this.txtMaPhieuMuonSach.getText().length()==0)
//            JOptionPane.showMessageDialog(null,"Bạn chưa nhập mã phiếu mượn sách","Thông báo",1);
//        else
//            if(this.txtMaDocGia.getText().length()==0)
//                JOptionPane.showMessageDialog(null,"Bạn chưa nhập mã độc giả","Thông báo",1);
//        else
//            {

        try {
            int result = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm phiếu mượn sách này", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                int sl = PhieuMuonSachDAO.kiemtraSL(madg);
                int count = 0;
                if (listSachMuon.getSelectedIndex() != -1) {
                    for (Object vegetable : listSachMuon.getSelectedValues()) {
                        strMS += vegetable + ",";
                        count++;
                    }
                    strMS = strMS.substring(0, strMS.length() - 1);
                }
                if (!DocGiaDAO.checkHanDocGia(madg)) {
                    JOptionPane.showMessageDialog(null, "Độc giả đã hết hạn", "Thông báo", 1);
                } else if (PhieuMuonSachDAO.kiemtraQuaHan(madg) >= 1) {
                    JOptionPane.showMessageDialog(null, "Độc giả có sách quá hạn", "Thông báo", 1);
                } else if (sl >= 4) {
                    JOptionPane.showMessageDialog(null, "Độc giả đã mượn 4 cuốn sách", "Thông báo", 1);
                } else if (sl + count > 4) {
                    JOptionPane.showMessageDialog(null, "Độc giả đã mượn " + sl + " cuốn sách. Quá số lượng rồi", "Thông báo", 1);
                } else if (DocGiaDAO.checkHanDocGia(madg)) {
                    PhieuMuonSach pms = new PhieuMuonSach();
                    pms.setmAPHIEUMUONSACH(txtMaPhieuMuonSach.getText());
                    pms.setmADOCGIA(madg);
                    if (date.getTime() != 0) {
                        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
                        pms.setnGAYMUON(sqlStartDate);
                    }

                    if (PhieuMuonSachDAO.InsertPhieuMuonSach(pms, strMS)) {
                        String[] word = strMS.split(",");
                        for (int i = 0; i < word.length; i++) {
                            int chon = Integer.valueOf(word[i]);
                            int madausach = ChiTietMuonSachDAO.getMadausach(chon);
                            ChiTietMuonSachDAO.capnhatdausach(madausach);
                            ChiTietMuonSachDAO.capnhatcuonsach(chon);
                        }
                        JOptionPane.showMessageDialog(null, "Phiếu mượn sách được thêm vào thành công", "Thông báo", 1);
                        showtb();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Độc giả đã hết hạn", "Thông báo", 1);
                }

            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Lỗi!" + e.getMessage(),"Thông báo",1 );
            if (e.getMessage().contains("ORA-00001: unique constraint (SINHVIEN02.PK_PHIEUMUONSACH) violated")) {
                JOptionPane.showMessageDialog(null, "Mã phiếu mượn sách đã tồn tại, vui lòng nhập lại ", "Lỗi", JOptionPane.WARNING_MESSAGE);
            }
            if (e.getMessage().contains("ORA-04088")) {
                JOptionPane.showMessageDialog(null, "Ngày mượn sách phải lớn hơn ngày lập thẻ.", "Lỗi", JOptionPane.WARNING_MESSAGE);
            }

        }
//            }
    }//GEN-LAST:event_btThemMoiActionPerformed

    private void btLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLamMoiActionPerformed
        // TODO add your handling code here:
        txtMaPhieuMuonSach.setText("");
        txtMaDocGia.setText("");
        txtNgayMuon.setText(formatter.format(date));
        txtTimKiem.setText("");
        lbcbb.setVisible(true);
        cbbMaDG.setVisible(true);
        listSachMuon.setVisible(true);
        lbMaDocGia.setVisible(false);
        txtMaDocGia.setVisible(false);
        DefaultTableModel tableModel = (DefaultTableModel) tbMaSach.getModel();
        tableModel.setRowCount(0);
        showtb();
    }//GEN-LAST:event_btLamMoiActionPerformed

    private void txtMaPhieuMuonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhieuMuonSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhieuMuonSachActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String sql = "SELECT * FROM PHIEUMUONSACH where MAPHIEUMUONSACH like'%" + this.txtTimKiem.getText() + "%' "
                    + "or MADOCGIA like '%" + this.txtTimKiem.getText() + "%'";
            DuLieuBang.Load(sql, tbPhieuMuonSach);
        }
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void tbMaSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMaSachMouseClicked
        // TODO add your handling code here:
        if (evt.getModifiers() == InputEvent.BUTTON3_MASK) {

        }
    }//GEN-LAST:event_tbMaSachMouseClicked

    private void cbbMaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaDGActionPerformed
        // TODO add your handling code here:
        String selectedValue = cbbMaDG.getSelectedItem().toString();
        String[] word = selectedValue.split(",");
        madg = word[0];

    }//GEN-LAST:event_cbbMaDGActionPerformed

    private void listSachMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSachMuonMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_listSachMuonMouseClicked

    private void txtMaDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDocGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDocGiaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new QuanLyChiTietMuonSach().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLamMoi;
    private javax.swing.JButton btThemMoi;
    private javax.swing.JButton btTimKiem;
    private javax.swing.JComboBox<String> cbbMaDG;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbMaDocGia;
    private javax.swing.JLabel lbMaPhieuMuonSach;
    private javax.swing.JLabel lbMaSach;
    private javax.swing.JLabel lbcbb;
    private javax.swing.JList<String> listSachMuon;
    private javax.swing.JTable tbMaSach;
    private javax.swing.JTable tbPhieuMuonSach;
    private javax.swing.JTextField txtMaDocGia;
    public static javax.swing.JTextField txtMaPhieuMuonSach;
    private javax.swing.JTextField txtNgayMuon;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
