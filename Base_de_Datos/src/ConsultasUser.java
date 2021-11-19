
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableCellEditor;

 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TheBlackTutorials
 */
public class ConsultasUser extends javax.swing.JFrame {
   Connection con = null;
   Statement stmt = null;
   String titulos[] = {"IdUser","Nombre","Apellido","Ciudad","Telefono","Profesion"};
   String fila[] = new String [7];
   DefaultTableModel modelo;

    public ConsultasUser() {
        initComponents();
        this.setTitle("Consulta de Usuarios");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        ImageIcon icono = new ImageIcon("");
        this.setIconImage(icono.getImage());
        
                try {
            
            String url = "jdbc:mysql://localhost:3306/datos";
            String usuario = "root";
            String contraseña = ""; 
            
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               con = DriverManager.getConnection(url,usuario,contraseña);
               if (con!= null)
                   System.out.println("Se ha establecido una conexion a la base de datos"+"\n"+url);
               
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery("select* from datos");
               
               modelo = new DefaultTableModel(null,titulos);
            
               while(rs.next()) {
                   
                   fila[0] = rs.getString("IdUser");
                   fila[1] = rs.getString("Nombre");
                   fila[2] = rs.getString("Apellido");
                   fila[3] = rs.getString("Ciudad");
                   fila[4] = rs.getString("Telefono");
                   fila[5] = rs.getString("Profesion");
                                      
                   modelo.addRow(fila);     
               }
               TableUsuarios.setModel(modelo);
                TableColumn ci = TableUsuarios.getColumn("IdUser");
                ci.setMaxWidth(100);
                TableColumn cn = TableUsuarios.getColumn("Nombre");
                cn.setMaxWidth(165);
                TableColumn cd = TableUsuarios.getColumn("Apellido");
                cd.setMaxWidth(160);
                TableColumn ct = TableUsuarios.getColumn("Ciudad");
                ct.setMaxWidth(120);
                TableColumn cnick = TableUsuarios.getColumn("Telefono");
                cnick.setMaxWidth(72);
                TableColumn cp = TableUsuarios.getColumn("Profesion");
                cp.setMaxWidth(300);
               
        }
        catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla" + e);
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

        jMenu1 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableUsuarios = new javax.swing.JTable();
        buscador = new javax.swing.JTextField();
        buscar = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        empresa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextId = new javax.swing.JTextField();
        jTextNombre = new javax.swing.JTextField();
        jTextApellido = new javax.swing.JTextField();
        jTextCd = new javax.swing.JTextField();
        jTextProfesion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextTel = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchi = new javax.swing.JMenu();
        registro = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableUsuarios.setBackground(new java.awt.Color(0, 0, 0));
        TableUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TableUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        TableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No. Usuario", "Nombre", "Apellido", "Ciudad", "Telefono", "Profesion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableUsuarios);
        TableUsuarios.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 690, 140));

        buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorActionPerformed(evt);
            }
        });
        buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscadorKeyPressed(evt);
            }
        });
        getContentPane().add(buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 180, -1));

        buscar.setBackground(new java.awt.Color(0, 0, 0));
        buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setText("Buscar:");
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 20));

        cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancel.setText("Cancelar");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 100, -1));

        empresa.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        empresa.setForeground(new java.awt.Color(255, 0, 0));
        empresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empresa.setText("BASE DE DATOS");
        getContentPane().add(empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 200, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("No. Usuario: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 90, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ciudad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Puesto: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jTextId.setEditable(false);
        jTextId.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(jTextId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 40, 30));

        jTextNombre.setEditable(false);
        jTextNombre.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 180, 30));

        jTextApellido.setEditable(false);
        jTextApellido.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(jTextApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 180, 30));
        getContentPane().add(jTextCd, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 110, 30));
        getContentPane().add(jTextProfesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 180, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Telefono: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 690, 20));
        getContentPane().add(jTextTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 110, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, -1, -1));

        menuArchi.setText("Archivo");
        menuArchi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArchiActionPerformed(evt);
            }
        });

        registro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        registro.setText("Registros");
        registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroActionPerformed(evt);
            }
        });
        menuArchi.add(registro);

        jMenuBar1.add(menuArchi);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void actualizar() {
        
        String cadena1,cadena4,cadena5,cadena6;
       
       cadena1 = jTextId.getText();
       cadena4 = jTextCd.getText();
       cadena5 = jTextTel.getText();
       cadena6 = jTextProfesion.getText();
             
     try { 
                  String url = "jdbc:mysql://localhost:3306/datos"; 
                  String usuario = "root"; 
                  String contraseña = ""; 
                  
                  Class.forName("com.mysql.jdbc.Driver").newInstance(); 
                  con = DriverManager.getConnection(url,usuario,contraseña); 
                  if ( con != null ) 
                    System.out.println("Se ha establecido una conexión a la base de datos " +  
                                       "\n " + url ); 
  
                  stmt = con.createStatement(); 
                  stmt.executeUpdate("update ignore datos set Ciudad = '"+cadena4+"', Telefono = '"+cadena5+"', Profesion = '"+cadena6+"' where IdUser='"+cadena1+"'"); 

                  System.out.println("Los valores han sido Actualizados"); 
                  } 
                  catch( Exception e ) { 
                      e.printStackTrace(); 
                  } 
  
              finally { 
                  if ( con != null ) { 
                      try    { 
                          con.close(); 
                          stmt.close(); 
                      } catch( Exception e ) { 
                          System.out.println( e.getMessage()); 
                      } 
                  } 
     }
     javax.swing.JOptionPane.showMessageDialog(this,"Actualizado correctamente!","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);

   this.jTextId.setText("");
        this.jTextNombre.setText("");
        this.jTextApellido.setText("");
        this.jTextCd.setText("");
        this.jTextTel.setText("");
        this.jTextProfesion.setText("");
        
        this.dispose();
        ConsultasUser cu = new ConsultasUser();
        cu.setLocationRelativeTo(null);
        cu.setVisible(true);        
    }

    
    private void menuArchiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArchiActionPerformed
        
    }//GEN-LAST:event_menuArchiActionPerformed

    private void registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroActionPerformed
       this.dispose();
        usuarios us = new usuarios();
        us.setLocationRelativeTo(null);
        us.setVisible(true);
    }//GEN-LAST:event_registroActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
        usuarios us = new usuarios();
        us.setLocationRelativeTo(null);
        us.setVisible(true);
    }//GEN-LAST:event_cancelActionPerformed

    private void buscadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorKeyPressed
        String[] titulos = {"IdUser","Nombre", "Apellido", "Ciudad", "Telefono", "Profesion"};

String sql = "SELECT *FROM datos WHERE IdUser like '%00000000" + buscador.getText() + "%'"
+ "or Nombre like '%" + buscador.getText() + "%'"
+ "OR Apellido like '%" + buscador.getText() + "%'"
+ "OR Ciudad like '%" + buscador.getText() + "%'"
+ "OR Profesion like '%" + buscador.getText() + "%'";
modelo = new DefaultTableModel(null, titulos);
try {
Statement st = (Statement) con.createStatement();
ResultSet rs = st.executeQuery(sql);
while (rs.next()) {
fila[0] = rs.getString("IdUser");
fila[1] = rs.getString("Nombre");
fila[2] = rs.getString("Apellido");
fila[3] = rs.getString("Ciudad");
fila[4] = rs.getString("Telefono");
fila[5] = rs.getString("Profesion");
modelo.addRow(fila);
}
TableUsuarios.setModel(modelo);
} catch (Exception ex) {
JOptionPane.showMessageDialog(null, ex);
}
    }//GEN-LAST:event_buscadorKeyPressed

    private void buscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorActionPerformed

    private void TableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableUsuariosMouseClicked

        jTextId.setText(modelo.getValueAt(TableUsuarios.getSelectedRow(), 0)+"");
        jTextNombre.setText(modelo.getValueAt(TableUsuarios.getSelectedRow(), 1)+"");
        jTextApellido.setText(modelo.getValueAt(TableUsuarios.getSelectedRow(), 2)+"");
        jTextCd.setText(modelo.getValueAt(TableUsuarios.getSelectedRow(), 3)+"");
        jTextTel.setText(modelo.getValueAt(TableUsuarios.getSelectedRow(), 4)+"");
        jTextProfesion.setText(modelo.getValueAt(TableUsuarios.getSelectedRow(), 5)+"");

    }//GEN-LAST:event_TableUsuariosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       actualizar();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultasUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultasUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultasUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultasUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultasUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableUsuarios;
    private javax.swing.JTextField buscador;
    private javax.swing.JLabel buscar;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel empresa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextApellido;
    private javax.swing.JTextField jTextCd;
    private javax.swing.JTextField jTextId;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextProfesion;
    private javax.swing.JTextField jTextTel;
    private javax.swing.JMenu menuArchi;
    private javax.swing.JMenuItem registro;
    // End of variables declaration//GEN-END:variables
}
