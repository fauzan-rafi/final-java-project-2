package admin;

import config.*;
import inventoryapp.LoginPage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.Border;
/**
 *
 * @author ACER
 */
public class DashboardAdmin extends javax.swing.JFrame {

   DatabaseModel dbModel = new DatabaseModel();
    String nama,alamat,email,nomor;
    /**
     * Creates new form Dashboard
     */
    Config config = new Config();
    
    Border default_border = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(46,49,49));
    
    Border yellow_border = BorderFactory.createMatteBorder(1, 0, 1, 0, Color.YELLOW);
    
    JLabel[] menuLabels = new JLabel[5];
    
    JPanel[] panels = new JPanel[5];
    
    public DashboardAdmin(String id) {
        initComponents();
        loadData(Integer.parseInt(id));
        
//        array for menu labels
        menuLabels[0] = jLabel_menuItem1;
        menuLabels[1] = jLabel_menuItem2;
        menuLabels[2] = jLabel_menuItem3;
        menuLabels[3] = jLabel_menuItem4;
        menuLabels[4] = jLabel_menuItem5;
        
//        array for dashboard
        panels[0] = jPanel_dashboard;
        panels[1] = jPanel_user;
        panels[2] = jPanel_request;
        panels[3] = jPanel_item;
        panels[4] = jPanel_contact;
        
        
        addActionToMenuLabels();
        
        dbModel.showRequest(table_request);
    }
    
    public void setLabelBackground(JLabel label){
        
        for(JLabel menuItem : menuLabels){
            menuItem.setBackground(new Color(46,49,49));
            menuItem.setForeground(Color.white);
        }
        
        
        label.setBackground(Color.white);
        label.setForeground(Color.black);
    }
    
//    function for show panel
    public void showPanel(JPanel panel){
        for(JPanel pnl : panels){
            pnl.setVisible(false);
        }
        
        panel.setVisible(true);
    }
    
    public void addActionToMenuLabels(){
         Component[] components = jPanel_menu.getComponents();
         
         for(Component component : components){
             if(component instanceof JLabel){
                 JLabel label = (JLabel) component;
                 
                 label.addMouseListener(new MouseListener() {
                     @Override
                     public void mouseClicked(MouseEvent arg0) {
                         setLabelBackground(label);
                         
                         switch (label.getText().trim()){
                             case "Dashboard":
                                 showPanel(jPanel_dashboard);
                                 break;
                             case "Users":
                                 showPanel(jPanel_user);
                                 break;
                             case "Request":
                                 showPanel(jPanel_request);
                                 break;
                             case "Item":
                                 showPanel(jPanel_item);
                                 break;
                             case "Contact":
                                 showPanel(jPanel_contact);
                                 break;
                         }
                     }

                     @Override
                     public void mousePressed(MouseEvent arg0) {
                     }

                     @Override
                     public void mouseReleased(MouseEvent arg0) {
                     }

                     @Override
                     public void mouseEntered(MouseEvent arg0) {
                         label.setBorder(yellow_border);
                     }

                     @Override
                     public void mouseExited(MouseEvent arg0) {
                         label.setBorder(default_border);
                     }
                 });
             }
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

        jPanel1 = new javax.swing.JPanel();
        jPanel_menu = new javax.swing.JPanel();
        jLabel_menuItem1 = new javax.swing.JLabel();
        jLabel_menuItem2 = new javax.swing.JLabel();
        jLabel_menuItem3 = new javax.swing.JLabel();
        jLabel_menuItem4 = new javax.swing.JLabel();
        jLabel_menuItem5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel_dashboard = new javax.swing.JPanel();
        btn_logout = new javax.swing.JButton();
        fld_sewa = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fld_kembali = new javax.swing.JLabel();
        fld_total = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel_user = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel_request = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_request = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        fld_idTransaksi = new javax.swing.JTextField();
        btn_approve = new javax.swing.JButton();
        btn_refuse = new javax.swing.JButton();
        jPanel_item = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel_contact = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        setForeground(new java.awt.Color(204, 255, 255));
        setName("Dashboard"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel_menu.setBackground(new java.awt.Color(51, 51, 51));

        jLabel_menuItem1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel_menuItem1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_menuItem1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_menuItem1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_menuItem1.setText("Dashboard");
        jLabel_menuItem1.setOpaque(true);

        jLabel_menuItem2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel_menuItem2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_menuItem2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_menuItem2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_menuItem2.setText("Users");
        jLabel_menuItem2.setOpaque(true);

        jLabel_menuItem3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel_menuItem3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_menuItem3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_menuItem3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_menuItem3.setText("Request");
        jLabel_menuItem3.setOpaque(true);

        jLabel_menuItem4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel_menuItem4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_menuItem4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_menuItem4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_menuItem4.setText("Item");
        jLabel_menuItem4.setOpaque(true);

        jLabel_menuItem5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel_menuItem5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_menuItem5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_menuItem5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_menuItem5.setText("Contact");
        jLabel_menuItem5.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(102, 255, 255));
        jLabel6.setOpaque(true);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Admin");

        javax.swing.GroupLayout jPanel_menuLayout = new javax.swing.GroupLayout(jPanel_menu);
        jPanel_menu.setLayout(jPanel_menuLayout);
        jPanel_menuLayout.setHorizontalGroup(
            jPanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_menuItem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel_menuItem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel_menuItem3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel_menuItem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel_menuItem5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel_menuLayout.setVerticalGroup(
            jPanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_menuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jLabel_menuItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_menuItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_menuItem3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_menuItem4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_menuItem5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        jPanel_dashboard.setBackground(new java.awt.Color(230, 126, 34));
        jPanel_dashboard.setPreferredSize(new java.awt.Dimension(600, 350));

        btn_logout.setBackground(new java.awt.Color(255, 51, 102));
        btn_logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setText("Logout");
        btn_logout.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 255, 255), new java.awt.Color(102, 255, 255), new java.awt.Color(102, 255, 255), new java.awt.Color(102, 255, 255)));
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        fld_sewa.setBackground(new java.awt.Color(142, 68, 173));
        fld_sewa.setOpaque(true);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("JogoGudang");

        fld_kembali.setBackground(new java.awt.Color(241, 196, 15));
        fld_kembali.setOpaque(true);

        fld_total.setBackground(new java.awt.Color(231, 76, 60));
        fld_total.setOpaque(true);

        jLabel16.setBackground(new java.awt.Color(153, 153, 153));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Request");

        jLabel18.setBackground(new java.awt.Color(153, 153, 153));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Pinjaman");

        jLabel19.setBackground(new java.awt.Color(153, 153, 153));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Total Barang");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Selamat Datang");

        javax.swing.GroupLayout jPanel_dashboardLayout = new javax.swing.GroupLayout(jPanel_dashboard);
        jPanel_dashboard.setLayout(jPanel_dashboardLayout);
        jPanel_dashboardLayout.setHorizontalGroup(
            jPanel_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_dashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_dashboardLayout.createSequentialGroup()
                        .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_dashboardLayout.createSequentialGroup()
                        .addGroup(jPanel_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fld_sewa, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fld_kembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fld_total, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel_dashboardLayout.setVerticalGroup(
            jPanel_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_dashboardLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(jPanel_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fld_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fld_sewa, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fld_total, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel_user.setBackground(new java.awt.Color(204, 204, 204));
        jPanel_user.setPreferredSize(new java.awt.Dimension(600, 350));

        jLabel1.setText("Users");

        javax.swing.GroupLayout jPanel_userLayout = new javax.swing.GroupLayout(jPanel_user);
        jPanel_user.setLayout(jPanel_userLayout);
        jPanel_userLayout.setHorizontalGroup(
            jPanel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_userLayout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );
        jPanel_userLayout.setVerticalGroup(
            jPanel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_userLayout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        jPanel_request.setBackground(new java.awt.Color(30, 144, 255));
        jPanel_request.setPreferredSize(new java.awt.Dimension(600, 350));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Request");

        table_request.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table_request);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Approval");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Nomor Transaksi");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Aksi");

        btn_approve.setBackground(new java.awt.Color(150, 186, 233));
        btn_approve.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_approve.setForeground(new java.awt.Color(255, 255, 255));
        btn_approve.setText("Approve");
        btn_approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_approveActionPerformed(evt);
            }
        });

        btn_refuse.setBackground(new java.awt.Color(150, 186, 233));
        btn_refuse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_refuse.setForeground(new java.awt.Color(255, 255, 255));
        btn_refuse.setText("Refuse");

        javax.swing.GroupLayout jPanel_requestLayout = new javax.swing.GroupLayout(jPanel_request);
        jPanel_request.setLayout(jPanel_requestLayout);
        jPanel_requestLayout.setHorizontalGroup(
            jPanel_requestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_requestLayout.createSequentialGroup()
                .addGroup(jPanel_requestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_requestLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_requestLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_requestLayout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_requestLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel_requestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fld_idTransaksi)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_requestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_requestLayout.createSequentialGroup()
                        .addComponent(btn_approve)
                        .addGap(29, 29, 29)
                        .addComponent(btn_refuse))
                    .addGroup(jPanel_requestLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)))
                .addGap(39, 39, 39))
        );
        jPanel_requestLayout.setVerticalGroup(
            jPanel_requestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_requestLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_requestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_requestLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_requestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_refuse, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_approve, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_requestLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fld_idTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jLabel3.setText("Item");

        javax.swing.GroupLayout jPanel_itemLayout = new javax.swing.GroupLayout(jPanel_item);
        jPanel_item.setLayout(jPanel_itemLayout);
        jPanel_itemLayout.setHorizontalGroup(
            jPanel_itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_itemLayout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel_itemLayout.setVerticalGroup(
            jPanel_itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_itemLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        jLabel4.setText("Contact");

        javax.swing.GroupLayout jPanel_contactLayout = new javax.swing.GroupLayout(jPanel_contact);
        jPanel_contact.setLayout(jPanel_contactLayout);
        jPanel_contactLayout.setHorizontalGroup(
            jPanel_contactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_contactLayout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
        );
        jPanel_contactLayout.setVerticalGroup(
            jPanel_contactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_contactLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 200, Short.MAX_VALUE)
                    .addComponent(jPanel_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 200, Short.MAX_VALUE)
                    .addComponent(jPanel_request, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 199, Short.MAX_VALUE)
                    .addComponent(jPanel_item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 191, Short.MAX_VALUE)
                    .addComponent(jPanel_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel_user, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel_request, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel_item, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel_contact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_approveActionPerformed
        // TODO add your handling code here:
        int idTransaksi = Integer.parseInt(fld_idTransaksi.getText());
        dbModel.approveReq(idTransaksi);
        fld_idTransaksi.setText("");
        dbModel.showRequest(table_request);
    }//GEN-LAST:event_btn_approveActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
        new LoginPage().setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_logoutActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Dashboard().setVisible(true);
//            }
//        });
//    }
    private void loadData(int id){
        try{
            String query = "SELECT * FROM data_user WHERE id_user="+"'"+id+"'";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(query);
            while(res.next()){
//              lblName.setText(res.getString("nama_user"));
//              lblEmail.setText(res.getString("email_user"));
//              lblAlamat.setText(res.getString("alamat_user"));
//              lblNomor.setText(res.getString("nomor_user"));
//              lblStatus.setText(res.getString("status_user") ? );
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_approve;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_refuse;
    private javax.swing.JTextField fld_idTransaksi;
    private javax.swing.JLabel fld_kembali;
    private javax.swing.JLabel fld_sewa;
    private javax.swing.JLabel fld_total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_menuItem1;
    private javax.swing.JLabel jLabel_menuItem2;
    private javax.swing.JLabel jLabel_menuItem3;
    private javax.swing.JLabel jLabel_menuItem4;
    private javax.swing.JLabel jLabel_menuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_contact;
    private javax.swing.JPanel jPanel_dashboard;
    private javax.swing.JPanel jPanel_item;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JPanel jPanel_request;
    private javax.swing.JPanel jPanel_user;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_request;
    // End of variables declaration//GEN-END:variables
}
