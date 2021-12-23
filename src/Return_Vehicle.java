
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.*;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arbaaz Makandar
 */
public class Return_Vehicle extends javax.swing.JFrame {
    List<String> list3 = new Vector<String>();
                                  
        
    /**
     * Creates new form Return_Vehicle
     */
    public Return_Vehicle(String cname) {
        initComponents();
        itembharo(cname);
        
        Timer tm=new Timer(1,new ActionListener(){
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {       Calendar c=Calendar.getInstance();
               int a = c.get(Calendar.HOUR_OF_DAY);
               int b = c.get(Calendar.MINUTE);
               int g = c.get(Calendar.SECOND);
               int d = c.get((Calendar.DAY_OF_MONTH));
               int e = c.get(Calendar.MONTH);
               int f = c.get(Calendar.YEAR);
               String b1=""+b;
               String g1=""+g;
               String a1=""+a;
               String d1=""+d;
               String e1=""+(e+1);
               if(b<10)
                {
                    b1="0"+b;
                }
               if(a<10)
                {
                    a1="0"+a;
                }
               if(g<10)
                {
                   g1="0"+g;
                }
               if(d<10)
                {
                    d1="0"+d;
                }
               if((e+1)<10)
                {
                     e1="0"+(e+1);
                }
               String dt = ""+f+"-"+e1+"-"+d1+" "+a1+":"+b1+":"+g1;
               lblTime1.setText(dt);
               
        }
        });
        tm.start();
    }

    public void fillItemInBookingHistory(){
        
            Connection cn=null;
            Statement st=null;
            ResultSet rs= null;
            
             try
            {
                try
                {
                    Class.forName("java.sql.Driver");
                    cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tavs","root","1234");
                    st=cn.createStatement();
                   System.out.println(list3);
                    String sq="insert into BookingHistory values("+list3.get(0)+",'"+list3.get(1)+"',"+list3.get(2)+","+list3.get(3)+","+list3.get(4)+",'"+list3.get(5)+"','"+list3.get(6)+"','"+list3.get(7)+"','"+list3.get(8)+"',"+list3.get(9)+","+list3.get(10)+");" ;
                    st.executeUpdate(sq);
                   System.out.println(sq);
                    
                  
                    JOptionPane.showMessageDialog(null,"Booking History Update Success");
                    
                }

                catch(Exception e)

                {
                    JOptionPane.showMessageDialog(null,e.getMessage());

                }
                finally
                {

                    st.close();
                    cn.close();
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
        
        
 
    
   
    public void itembharo(String cname)
    {
        DefaultTableModel dc1= (DefaultTableModel)tb_vehicle.getModel();
        Connection cn=null;
        Statement st=null;
        ResultSet rs=null,rs1=null;
        String sql="select distinct * from Booking,Vehicle,Pickup where Vehicle.V_id = Booking.V_id AND Pickup.B_id = Booking.B_id and booking_status ='PICKED' and Booking.C_name = '"+cname +"';";
        
        try
        {
                try
                    {
                        Class.forName("java.sql.Driver");
                        cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tavs","root","1234");
                        st=cn.createStatement();
                        rs=st.executeQuery(sql);
                        dc1.setRowCount(0);
                            while(rs.next())
                                {
                                  Object a=""+rs.getInt(1);
                                  Object b=rs.getString(2);
                                  Object c=rs.getString(3);
                                  Object d=rs.getString(4);
                                  Object e=""+rs.getInt(8);
                                  Object f=""+rs.getString(12);
                                  Object g=""+rs.getString(14);
                                  Object h=""+rs.getInt(9);
                                  
                                  list3.add(""+a);
                                  list3.add(""+b);
                                  list3.add(""+c);
                                  list3.add(""+d);
                                  list3.add(""+e);
                                  list3.add(""+f);
                                  list3.add(""+g);
                                  list3.add(rs.getString(20));
                                  
                                  Object obj[]= {a,b,c,d,e,f,g,h};
                                  dc1.addRow(obj);
                                }
                          
                             
                    }
                 catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }
                finally
                {
                  rs.close();
                  st.close();
                  cn.close();
                
                }
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_vehicle = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_reading1 = new javax.swing.JTextField();
        tf_reading2 = new javax.swing.JTextField();
        dt = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        tf3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf4 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        tf_reading = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tf_ch1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tf_ch2 = new javax.swing.JLabel();
        tf_ch3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblTime1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf5 = new javax.swing.JTextField();
        bt_back = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        jLabel1.setText("Return Vehicle");

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tb_vehicle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Booking ID", "Customer Name", "Customer ID", "Customer Contact", "Vehicle ID", "Vehicle Name", "Vehicle Type", "Advance Payment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_vehicle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_vehicleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_vehicle);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("PAY BILL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Return Data"));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("RETURN METER READING :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("RETURN DATE & TIME :");

        tf_reading2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_reading2ActionPerformed(evt);
            }
        });

        dt.setText("Use Current Date & Time");
        dt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dtItemStateChanged(evt);
            }
        });

        jLabel16.setText("(YYYY-MM-DD HH:MM:SS)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_reading1)
                    .addComponent(dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_reading2))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_reading2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dt)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_reading1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Fare"));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Distance Traveled :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Duration (Hours):");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Nights Held  (Rs 150/night) :");

        tf1.setEditable(false);
        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });

        tf2.setEditable(false);

        tf3.setEditable(false);
        tf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf3ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Total Amount :");

        tf4.setEditable(false);
        tf4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(tf1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(tf2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf3)
                            .addComponent(tf4))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tf3)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf4))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pickup Data"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("PICKUP DATE & TIME :");

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTime.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tf_reading.setEditable(false);
        tf_reading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_readingActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("PICKUP METER READING:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_reading, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_reading, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Booked Vehicle Charges"));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("PICKUP DATE & TIME :");

        tf_ch1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_ch1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Price(per KM) :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Price(Min if less than 4 hrs) :");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Price(per Hour) :");

        tf_ch2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_ch2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tf_ch3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_ch3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tf_ch2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(tf_ch3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_ch1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ch1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ch2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ch3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("CALCULATE FARE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblTime1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTime1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Total Amount Payable :");

        tf5.setEditable(false);
        tf5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf5ActionPerformed(evt);
            }
        });

        bt_back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_back.setText("GO BACK");
        bt_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_backActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("GET RECEIPT");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(bt_back, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(tf5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf5))
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel dc1 = (DefaultTableModel)tb_vehicle.getModel();
        String V_id =  ""+dc1.getValueAt(tb_vehicle.getSelectedRow(),4);
        if(tb_vehicle.getSelectedRow()==-1)
        {
            JOptionPane.showMessageDialog(null,"Please select a Booking from table");
        }
        else
        {
            Connection cn=null;
            Statement st=null;
            ResultSet rs= null;

            try
            {
                try
                {
                    Class.forName("java.sql.Driver");
                    cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tavs","root","1234");
                    st=cn.createStatement();
                    String B_id = ""+dc1.getValueAt(tb_vehicle.getSelectedRow(),0);
                    String sql2="insert into returnvehicle values("+B_id+",'"+tf_reading2.getText()+"',"+tf_reading1.getText()+","+tf4.getText()+");" ;
                    st.executeUpdate(sql2);

                    String sql3="update booking set Booking_Status = 'COMPLETE' where B_id ="+B_id+" ;" ;
                    st.executeUpdate(sql3);
                    
                    String sql4="update vehicle set status = 'AVAILABLE' where V_id ="+V_id+" ;" ;
                    st.executeUpdate(sql4);
                    System.out.println(sql4);
                    
                    /*
                    String sql3="update vehicle set status = 'RENTED' where V_id = "+tf_id.getText()+";";
                    st.executeUpdate(sql3);
                    */
                    fillItemInBookingHistory();
                    JOptionPane.showMessageDialog(null,"Vehicle Returned Successfully");
                }

                catch(Exception e)

                {
                    JOptionPane.showMessageDialog(null,e.getMessage());

                }
                finally
                {

                    st.close();
                    cn.close();
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }          // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tb_vehicleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_vehicleMouseClicked
DefaultTableModel dc1= (DefaultTableModel)tb_vehicle.getModel();
String B_id =""+ dc1.getValueAt(tb_vehicle.getSelectedRow(),0);
String V_id =""+ dc1.getValueAt(tb_vehicle.getSelectedRow(),4);
        Connection cn=null;
        Statement st=null;
        ResultSet rs=null,rs1=null;
        String sql="select * from pickup where B_id = "+B_id+" ;";
        String sql2="select charge_1,charge_2,charge_3 from vehicle where V_id = "+V_id+" ;";
        
        try
        {
                try
                    {
                        Class.forName("java.sql.Driver");
                        cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tavs","root","1234");
                        st=cn.createStatement();
                        rs=st.executeQuery(sql);
                            if(rs.next())
                                {
                                  lblTime.setText(rs.getString(2));
                                  tf_reading.setText(""+rs.getInt(3));
                                }
                            
                        rs=st.executeQuery(sql2);
                            if(rs.next())
                                {
                                  tf_ch1.setText(""+rs.getInt(1));
                                  tf_ch2.setText(""+rs.getInt(2));
                                  tf_ch3.setText(""+rs.getInt(3));
                                }
                         
                          
                             
                    }
                 catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }
                finally
                {
                  rs.close();
                  st.close();
                  cn.close();
                
                }
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,e.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tb_vehicleMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tf_readingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_readingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_readingActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
    String rt_dt = tf_reading2.getText();
    String pk_dt = lblTime.getText();
    int pk_rd = Integer.parseInt(tf_reading.getText());
    int rt_rd = Integer.parseInt(tf_reading1.getText());
    
    DefaultTableModel dc1=(DefaultTableModel)tb_vehicle.getModel();
    int adv = Integer.parseInt(""+dc1.getValueAt(tb_vehicle.getSelectedRow(),7));
    if(rt_dt.equals("") || (""+rt_rd).equals("") || adv==-1)
    {
        JOptionPane.showMessageDialog(null,"Enter Return Data First");
    }
    else
    {   int night_day=0;
        int hrs=0;
        int rd_diff = rt_rd -pk_rd;
    
        Connection cn=null;
        Statement st=null;
        ResultSet rs=null,rs1=null;
        String sql="select DATEDIFF('"+rt_dt+"','"+pk_dt+"');";
        String sql2="select TIMESTAMPDIFF(second,'"+pk_dt+"','"+rt_dt+"');";
        try
        {
                try
                    {
                        Class.forName("java.sql.Driver");
                        cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tavs","root","1234");
                        st=cn.createStatement();
                        rs=st.executeQuery(sql);
                            if(rs.next())
                                {
                                    
                                  night_day=rs.getInt(1);
                                  System.out.println(night_day);
                                }
                        
                        rs=st.executeQuery(sql2);
                            if(rs.next())
                                {
                                  hrs=rs.getInt(1);
                                  hrs = hrs/3600;
                                  System.out.println(hrs);
                                }
                            
                             
                    }
                 catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }
                finally
                {
                  rs.close();
                  st.close();
                  cn.close();
                
                }
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
        tf1.setText(""+rd_diff);
        list3.add(""+rd_diff);
        tf2.setText(""+hrs);
        tf3.setText(""+night_day);
        int ch1=Integer.parseInt(tf_ch1.getText());
        int ch2=Integer.parseInt(tf_ch2.getText());
        int ch3=Integer.parseInt(tf_ch3.getText());
        
        int total = Math.max(ch1*hrs, Math.max(ch2*rd_diff,ch3));
        total =total + 150*night_day;
        tf4.setText(""+total);
        list3.add(""+total);
        tf5.setText(""+(total -adv ));
        
        
    }
    
    // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void dtItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dtItemStateChanged
if(dt.isSelected()==true)
{
    tf_reading2.setText(""+lblTime1.getText());
    tf_reading2.setEditable(false);
}
else if(dt.isSelected()==false)
{
    tf_reading2.setText("");
    tf_reading2.setEditable(true);
}
list3.add(8,tf_reading2.getText());
    // TODO add your handling code here:
    }//GEN-LAST:event_dtItemStateChanged

    private void tf_reading2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_reading2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_reading2ActionPerformed

    private void tf3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf3ActionPerformed

    private void tf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf4ActionPerformed

    private void tf5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf5ActionPerformed

    private void bt_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backActionPerformed

        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_backActionPerformed

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1ActionPerformed
    
//    public static double toPPI (double inch){
//        return toPPI(inch*72d);
//    }
//    
//    public static double cm_to_pp (double cm){
//        return toPPI(cm*0.393600787);
//    }
//    
//    public PageFormat getPageFormat(PrinterJob pj){
//        PageFormat pf = pj.defaultPage();
//        Paper paper = pf.getPaper();
//        
//        double bodyHeight = 0.0;
//        double headerHeight = 5.0;
//        double footerHeight = 5.0;
//        double width = cm_to_pp(8);
//        double height = cm_to_pp(headerHeight + bodyHeight + footerHeight);
//        paper.setSize(width,height);
//        paper.setImageableArea(0,10,width,height - cm_to_pp(1));
//        pf.setOrientation(PageFormat.PORTRAIT);
//        pf.setPaper(paper);
//        return pf;
//    }
//    
//    
//public class BillPrintable implements Printable {
//    
//   
//    
//    
//  public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
//  throws PrinterException 
//  {    
//      
//    
// 
//      int result = NO_SUCH_PAGE;    
//        if (pageIndex == 0) {                    
//        
//            Graphics2D g2d = (Graphics2D) graphics;                    
//            double width = pageFormat.getImageableWidth();                               
//            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 
//
//
//
//          //  FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
//        
//        try{
//            int y=20;
//            int yShift = 10;
//            int headerRectHeight=15;
//           // int headerRectHeighta=40;
//            
//                
//            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
//           
//            g2d.drawString("-------------------------------------",12,y);y+=yShift;
//            g2d.drawString("         Car Rental Services        ",12,y);y+=yShift;
//            g2d.drawString("   No 00000 Address Line One ",12,y);y+=yShift;
//            g2d.drawString("   Address Line 02 INDIA ",12,y);y+=yShift;
//            g2d.drawString("   www.facebook.com/carrental ",12,y);y+=yShift;
//            g2d.drawString("        +910000000000      ",12,y);y+=yShift;
//            g2d.drawString("-------------------------------------",12,y);y+=headerRectHeight;
//
//            g2d.drawString(" Item Name                  Price   ",10,y);y+=yShift;
//            g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
//     
//            
//            g2d.drawString(" "+itemName.get(s)+"                            ",10,y);y+=yShift;
//            g2d.drawString("      "+quantity.get(s)+" * "+itemPrice.get(s),10,y); g2d.drawString(subtotal.get(s),160,y);y+=yShift;
//
//            
//          
//            g2d.drawString("-------------------------------------",10,y);y+=yShift;
//            g2d.drawString(" Total amount:               "+txttotalAmount.getText()+"   ",10,y);y+=yShift;
//            g2d.drawString("-------------------------------------",10,y);y+=yShift;
//            g2d.drawString(" Cash      :                 "+txtcash.getText()+"   ",10,y);y+=yShift;
//            g2d.drawString("-------------------------------------",10,y);y+=yShift;
//            g2d.drawString(" Balance   :                 "+txtbalance.getText()+"   ",10,y);y+=yShift;
//  
//            g2d.drawString("*************************************",10,y);y+=yShift;
//            g2d.drawString("       THANK YOU VISIT AGAIN            ",10,y);y+=yShift;
//            g2d.drawString("*************************************",10,y);y+=yShift;
//            g2d.drawString("       SOFTWARE BY:ARBAAZ MAKANDAR     ",10,y);y+=yShift;
//            g2d.drawString("   CONTACT: carrental@gmail.com       ",10,y);y+=yShift;       
//           
//
//    }
//    catch(Exception e){
//    e.printStackTrace();
//    }
//
//              result = PAGE_EXISTS;    
//          }    
//          return result;    
//      }
//   }
//


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Return_Vehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Return_Vehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Return_Vehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Return_Vehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Return_Vehicle("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_back;
    private javax.swing.JCheckBox dt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTime1;
    private javax.swing.JTable tb_vehicle;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    private javax.swing.JLabel tf_ch1;
    private javax.swing.JLabel tf_ch2;
    private javax.swing.JLabel tf_ch3;
    private javax.swing.JTextField tf_reading;
    private javax.swing.JTextField tf_reading1;
    private javax.swing.JTextField tf_reading2;
    // End of variables declaration//GEN-END:variables
}
