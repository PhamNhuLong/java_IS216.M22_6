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
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import DAO.*;
import Object.*;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class QuanLyPhieuTraSachPanel extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyPhieuTraSachPanel
     */
    public static String sql = "select * from PHIEUTRASACH order by MAPHIEUTRA asc";
    private String madg;
    private String strMS = "";
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    String ngayht = formatter.format(date);

    public QuanLyPhieuTraSachPanel() {
        initComponents();
        setBackground(Color.white);
        showtb();
        loadcbb();
        loadsach();
        txtNgayTra.setText(ngayht);
        txtTienThu.setVisible(false);
        labelTienThu.setVisible(false);
        labelTienPhat.setVisible(false);
        txtTienPhatKiNay.setVisible(false);
        labelMaPhieuTra.setVisible(false);
        txtMaPhieuTra.setVisible(false);
        tbMaSach.setVisible(false);
        lbTenDocGia.setVisible(false);
        txtTenDocGia.setVisible(false);
    }

    public final void showtb() {
        DuLieuBang.Load(sql, tbPhieuTraSach);
    }

    public void loadcbb() {
        cbbMaDG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        ArrayList<String> list = PhieuTraSachDAO.LoadDataCbb();
        for (String item : list) {
            cbbMaDG.addItem(item.toString());
        }
    }

    public void loadsach() {
        ArrayList<String> list = PhieuTraSachDAO.LoadSach(madg);
//        final DefaultListModel vegName = new DefaultListModel();
        String[] mang = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            mang[i] = list.get(i);
        }
        listSach.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = mang;

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        listSach.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tbMaSach1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btThemMoi = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btXoa = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btCapNhat = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btLamMoi = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        labelMaPhieuTra = new javax.swing.JLabel();
        txtMaPhieuTra = new javax.swing.JTextField();
        lbMaDG = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelTienPhat = new javax.swing.JLabel();
        txtTienPhatKiNay = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMaSach = new javax.swing.JTable();
        cbbMaDG = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listSach = new javax.swing.JList<>();
        labelChonSach = new javax.swing.JLabel();
        txtNgayTra = new javax.swing.JTextField();
        labelTienThu = new javax.swing.JLabel();
        txtTienThu = new javax.swing.JTextField();
        txtTenDocGia = new javax.swing.JTextField();
        lbTenDocGia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPhieuTraSach = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();

        tbMaSach1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "MASACH", "TENDAUSACH"
            }
        ));
        jScrollPane3.setViewportView(tbMaSach1);

        jLabel7.setText("jLabel7");

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
        jToolBar1.add(jSeparator2);

        btXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bill.png"))); // NOI18N
        btXoa.setFocusable(false);
        btXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });
        jToolBar1.add(btXoa);
        jToolBar1.add(jSeparator3);

        btCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-edit-50.png"))); // NOI18N
        btCapNhat.setFocusable(false);
        btCapNhat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCapNhat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCapNhatActionPerformed(evt);
            }
        });
        jToolBar1.add(btCapNhat);
        jToolBar1.add(jSeparator4);

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

        labelMaPhieuTra.setText("Mã phiếu trả");

        txtMaPhieuTra.setEditable(false);

        lbMaDG.setText("Mã độc giả");

        jLabel4.setText("Ngày trả");

        labelTienPhat.setText("Tiền phạt kì này");

        txtTienPhatKiNay.setEditable(false);
        txtTienPhatKiNay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienPhatKiNayActionPerformed(evt);
            }
        });

        tbMaSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MASACH", "TENDAUSACH", "SONGAY", "TIENPHAT"
            }
        ));
        jScrollPane2.setViewportView(tbMaSach);

        cbbMaDG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaDGActionPerformed(evt);
            }
        });

        listSach.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "hai" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listSach.setToolTipText("");
        jScrollPane4.setViewportView(listSach);

        labelChonSach.setText("Chọn sách");

        txtNgayTra.setEditable(false);

        labelTienThu.setText("Tiền thu");

        txtTienThu.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtTienThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienThuActionPerformed(evt);
            }
        });

        lbTenDocGia.setText("Mã độc giả");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelTienThu, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(labelTienPhat, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(lbMaDG, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(labelMaPhieuTra, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(labelChonSach, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(lbTenDocGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenDocGia)
                            .addComponent(txtTienThu)
                            .addComponent(jScrollPane4)
                            .addComponent(txtTienPhatKiNay)
                            .addComponent(txtNgayTra)
                            .addComponent(cbbMaDG, 0, 226, Short.MAX_VALUE)
                            .addComponent(txtMaPhieuTra, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(13, 13, 13))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelMaPhieuTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaPhieuTra, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbMaDG, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(cbbMaDG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtNgayTra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenDocGia, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(lbTenDocGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelTienPhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTienPhatKiNay, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(labelChonSach, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTienThu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienThu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbPhieuTraSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MAPHIEUTRA", "MADOCGIA", "NGAYTRA", "TIENPHATKINAY"
            }
        ));
        tbPhieuTraSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPhieuTraSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPhieuTraSach);

        jButton1.setBackground(new java.awt.Color(255, 255, 153));
        jButton1.setText("HÓA ĐƠN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ PHIẾU TRẢ SÁCH");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtTimKiem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbPhieuTraSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhieuTraSachMouseClicked
        // TODO add your handling code here:
        labelTienPhat.setVisible(true);
        txtTienPhatKiNay.setVisible(true);
        labelMaPhieuTra.setVisible(true);
        txtMaPhieuTra.setVisible(true);
        tbMaSach.setVisible(true);
        listSach.setVisible(false);
        labelChonSach.setVisible(false);
        txtTienThu.setVisible(false);
        labelTienThu.setVisible(false);
        lbTenDocGia.setVisible(true);
        txtTenDocGia.setVisible(true);
        lbMaDG.setVisible(false);
        cbbMaDG.setVisible(false);
        try {
            int row = this.tbPhieuTraSach.getSelectedRow();
            String MArow = String.valueOf(this.tbPhieuTraSach.getModel().getValueAt(row, 0));
            String sql1 = " select MAPHIEUTRA, HOTEN , NGAYTRA,TIENPHATKINAY from PHIEUTRASACH,DOCGIA"
                    + " where PHIEUTRASACH.MADOCGIA =DOCGIA.MADOCGIA AND MAPHIEUTRA='" + MArow + "'";
            ResultSet rs = DuLieuBang.ShowTextField(sql1);
            String sql = " select CS.MASACH , DS.TENDAUSACH, CT.SONGAYTRATRE, CT.TIENPHAT\n"
                    + "from CUONSACH CS join DAUSACH DS on CS.MADAUSACH = DS.MADAUSACH join CTTS CT on CS.MASACH = CT.MASACH\n"
                    + "where CT.MAPHIEUTRA = '" + MArow + "'";
            DuLieuBang.Load(sql, tbMaSach);
            if (rs.next()) {
                this.txtMaPhieuTra.setText(rs.getString("MAPHIEUTRA"));
                this.txtNgayTra.setText(rs.getDate("NGAYTRA").toString());
                this.txtTienPhatKiNay.setText(rs.getString("TIENPHATKINAY"));
                this.txtTenDocGia.setText(rs.getString("HOTEN"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_tbPhieuTraSachMouseClicked

    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed
        // TODO add your handling code here:
        if (this.txtMaPhieuTra.getText().length() != 0) {
            String sql2 = " select * from PhieuTraSach where MAPHIEUTRA like '%" + this.txtMaPhieuTra.getText() + "%' ";
            DuLieuBang.Load(sql2, tbPhieuTraSach);
//       }  else if (this.txtMaDocGia.getText().length() != 0) {
//            String sql1 = " select * from PHIEUTRASACH where MADOCGIA like '%" + this.txtMaDocGia.getText() + "%' ";
//            DuLieuBang.Load(sql1, tbPhieuTraSach);
        } else if (this.txtTimKiem.getText().length() != 0) {
            String sql = "SELECT * FROM PHIEUTRASACH where MAPHIEUTRA like'%" + this.txtTimKiem.getText() + "%' "
                    + "or MADOCGIA like '%" + this.txtTimKiem.getText() + "%'";
            DuLieuBang.Load(sql, tbPhieuTraSach);

        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập", "Thông báo", 1);
        }
    }//GEN-LAST:event_btTimKiemActionPerformed

    private void btThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemMoiActionPerformed
        // TODO add your handling code here:
        if (listSach.getSelectedIndex() != -1) {
            for (Object vegetable : listSach.getSelectedValues()) {
                strMS += vegetable + ",";
            }
            strMS = strMS.substring(0, strMS.length() - 1);

            try {
                int result = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm phiếu trả sách này", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    PhieuTraSach pts = new PhieuTraSach();
                    pts.setmAPHIEUTRA(0);
                    pts.setmADOCGIA(Integer.valueOf(madg));
                    java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
                    pts.setnGAYTRA(sqlStartDate);
                    pts.settIENPHATKINAY(0);

                    PhieuTraSachDAO.InsertPhieuTraSach(pts);
                    int ma = PhieuTraSachDAO.getMa();
                    ChiTietTraSachDAO.InsertCTTS2(ma, strMS);
                    JOptionPane.showMessageDialog(null, "Phiếu trả sách được thêm vào thành công", "Thông báo", 1);
                    showtb();

                }
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "Lỗi!"+ e.getMessage(),"Thông báo",1 );
                if (e.getMessage().contains("ORA-00001: unique constraint (SINHVIEN02.PK_PHIEUTRASACH) violated")) {
                    JOptionPane.showMessageDialog(null, "Mã phiếu trả sách đã tồn tại, vui lòng nhập lại ", "Lỗi", JOptionPane.WARNING_MESSAGE);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sách", "Thông báo", 1);
        }

    }//GEN-LAST:event_btThemMoiActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        // TODO add your handling code here:
        if (this.txtMaPhieuTra.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn phiếu trả", "Thông báo", 1);
        } else {
            if (HoaDonDAO.kiemtra(this.txtMaPhieuTra.getText()) == 0) {
                txtTienThu.setVisible(true);
                labelTienThu.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Đã thu tiền phiếu này rồi", "Thông báo", 1);
            }

        }

    }//GEN-LAST:event_btXoaActionPerformed

    private void btCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCapNhatActionPerformed
        // TODO add your handling code here:
        if (this.txtMaPhieuTra.getText().length() == 0)
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn phiếu trả", "Thông báo", 1);
        else if (this.txtTienThu.getText().length() == 0)
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập tiền thu", "Thông báo", 1);
        else {
            try {
                int result = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn tạo phiếu thu này", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    int tienno = Integer.valueOf(txtTienPhatKiNay.getText());
                    int tienthu = Integer.valueOf(txtTienThu.getText());
                    if (tienno != tienthu) {
                        JOptionPane.showMessageDialog(null, "Tiền thu phải bằng tiền nợ", "Thông báo", 1);
                    } else {
                        String mapts = this.txtMaPhieuTra.getText();
                        HoaDon hd = new HoaDon();
                        hd.setmAHD(0);
                        hd.setmAPHIEUTRA(Integer.valueOf(mapts));
                        hd.settIENTHU(tienthu);
                        hd.settIENNO(0);
                        if (HoaDonDAO.ThemHoaDon(hd)) {
                            JOptionPane.showMessageDialog(null, "Hóa đơn được thêm vào thành công", "Thông báo", 1);
                            showtb();
                            lammoi();
                            inhoadon(mapts);
                        }

                    }
                }
            } catch (Exception e) {
                //  JOptionPane.showMessageDialog(null, "Lỗi!"+ e.getMessage(),"Thông báo",1 );
                //ORA-01407:
                if (e.getMessage().contains("ORA-01407")) {
                    JOptionPane.showMessageDialog(null, "Cập nhật không thành công!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }//GEN-LAST:event_btCapNhatActionPerformed

    private void lammoi() {
        txtMaPhieuTra.setText("");
        txtNgayTra.setText(ngayht);
        txtTienPhatKiNay.setText("");
        txtTimKiem.setText("");
        txtTienThu.setText("");
        txtTienThu.setVisible(false);
        labelTienThu.setVisible(false);
        labelTienPhat.setVisible(false);
        txtTienPhatKiNay.setVisible(false);
        labelMaPhieuTra.setVisible(false);
        txtMaPhieuTra.setVisible(false);
        tbMaSach.setVisible(false);
        listSach.setVisible(true);
        labelChonSach.setVisible(true);
        lbTenDocGia.setVisible(false);
        txtTenDocGia.setVisible(false);
        lbMaDG.setVisible(true);
        cbbMaDG.setVisible(true);
    }

    private void btLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLamMoiActionPerformed
        // TODO add your handling code here:
        lammoi();
        DefaultTableModel tableModel = (DefaultTableModel) tbMaSach.getModel();
        tableModel.setRowCount(0);
        showtb();
    }//GEN-LAST:event_btLamMoiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new QuanLyHoaDon().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String sql = "SELECT * FROM PHIEUTRASACH where MAPHIEUTRA like'%" + this.txtTimKiem.getText() + "%' "
                    + "or MADOCGIA like '%" + this.txtTimKiem.getText() + "%'";
            DuLieuBang.Load(sql, tbPhieuTraSach);
        }
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void cbbMaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaDGActionPerformed
        // TODO add your handling code here:
        String selectedValue = cbbMaDG.getSelectedItem().toString();
        String[] word = selectedValue.split(",");
        madg = word[0];
        loadsach();
    }//GEN-LAST:event_cbbMaDGActionPerformed

    private void txtTienThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienThuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienThuActionPerformed

    private void txtTienPhatKiNayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienPhatKiNayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienPhatKiNayActionPerformed
    
    private void inhoadon(String mapt){
       int mahd = HoaDonDAO.getMa();
       ArrayList<ChiTietTraSachHoaDon> list = HoaDonDAO.inhoadon(mapt);
       int sum = 0;
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<html>");
        htmlContent.append("<head>");
        htmlContent.append("<style>\n"
                + "table {\n"
                + "  font-family: arial, sans-serif;\n"
                + "  border-collapse: collapse;\n"
                + "  width: 100%;\n"
                + "}\n"
                + "\n"
                + "td, th {\n"
                + "  border: 1px solid #dddddd;\n"
                + "  text-align: left;\n"
                + "  padding: 8px;\n"
                + "}\n"
                + "\n"
                + "</style>");
        htmlContent.append("</head>");
        htmlContent.append("<body >");
        htmlContent.append("<h2 align=\"center\" style=\"color:green;font-weight:normal;margin:0\">Hóa đơn</h2>");
        htmlContent.append("<p align=\"right\">");
        htmlContent.append(ngayht);
        htmlContent.append("</p>");
        htmlContent.append("<p> Mã hóa đơn: ");
        htmlContent.append(mahd);
        htmlContent.append("</p>");
        htmlContent.append("<table cellspacing = \"0\" >");
        htmlContent.append("<tr>\n"
                + "        <th>STT</th>\n"
                + "        <th>Tên đầu sách</th>\n"
                + "        <th>Số ngày trả trễ</th>\n"
                + "        <th>Tiền phạt</th>\n"
                + "    </tr>");
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i).gettIENPHAt();
            htmlContent.append("<tr>");
             htmlContent.append("<td>");
            htmlContent.append(i+1);
            htmlContent.append("</td>");
            htmlContent.append("<td>");
            htmlContent.append(list.get(i).getTenDauSach());
            htmlContent.append("</td>");
            htmlContent.append("<td>");
            htmlContent.append(list.get(i).getsONGAYTRATRE());
            htmlContent.append("</td>");
            htmlContent.append("<td>");
            htmlContent.append(list.get(i).gettIENPHAt());
            htmlContent.append("</td>");
            htmlContent.append("</tr>");
        }
        htmlContent.append("<tr></tr>");
        htmlContent.append("</table>");
        htmlContent.append("<p align=\"right\">Tổng cộng tiền nợ: ");
        htmlContent.append(sum);
        htmlContent.append("</p>");
        htmlContent.append("</body>");
        htmlContent.append("</html>");
       
        JEditorPane bill = new JEditorPane();
        bill.setContentType("text/html");
        bill.setText(htmlContent.toString());
        try {
            bill.print();
        } catch (PrinterException ex) {
            Logger.getLogger(QuanLyPhieuTraSachPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCapNhat;
    private javax.swing.JButton btLamMoi;
    private javax.swing.JButton btThemMoi;
    private javax.swing.JButton btTimKiem;
    private javax.swing.JButton btXoa;
    private javax.swing.JComboBox<String> cbbMaDG;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelChonSach;
    private javax.swing.JLabel labelMaPhieuTra;
    private javax.swing.JLabel labelTienPhat;
    private javax.swing.JLabel labelTienThu;
    private javax.swing.JLabel lbMaDG;
    private javax.swing.JLabel lbTenDocGia;
    private javax.swing.JList<String> listSach;
    private javax.swing.JTable tbMaSach;
    private javax.swing.JTable tbMaSach1;
    private javax.swing.JTable tbPhieuTraSach;
    public static javax.swing.JTextField txtMaPhieuTra;
    private javax.swing.JTextField txtNgayTra;
    private javax.swing.JTextField txtTenDocGia;
    private javax.swing.JTextField txtTienPhatKiNay;
    private javax.swing.JTextField txtTienThu;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
