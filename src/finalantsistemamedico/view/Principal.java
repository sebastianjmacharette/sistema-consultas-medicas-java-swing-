
package finalantsistemamedico.view;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import finalantsistemamedico.controller.ConsultaDAO;
import finalantsistemamedico.controller.PacienteDAO;
import finalantsistemamedico.model.Consulta;
import finalantsistemamedico.model.Paciente;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class Principal extends javax.swing.JFrame {
private static Principal instancia;
    private Connection connection; // Agregar un atributo de tipo Connection
        private int idPacienteSeleccionado = 0; // Inicialmente no hay paciente seleccionado
    


    public Principal(Connection connection) {
        this.connection = connection; // Asignar la conexión

        initComponents();
        fillTableWithPatients();
        setLocationRelativeTo(null);
    }
 // Método para actualizar la tabla de pacientes
    public void actualizarTablaPacientes() {
        DefaultTableModel model = (DefaultTableModel) tablePacientes.getModel();
        // Limpiar los datos existentes en la tabla
        model.setRowCount(0);
        // Llenar la tabla con los datos actualizados desde la base de datos
        fillTableWithPatients();
    }
 
 private void fillTableWithPatients() {
     
    PacienteDAO pacienteDAO = new PacienteDAO(connection);
    List<Paciente> pacientes = null;
    try {
        pacientes = pacienteDAO.getAll();
    } catch (SQLException e) {
        System.out.println(pacientes);
        e.printStackTrace();
    }

    if (pacientes != null) {
        DefaultTableModel model = (DefaultTableModel) tablePacientes.getModel();
        model.setRowCount(0); // Limpiar los datos existentes en la tabla
        
        for (Paciente paciente : pacientes) {
            Object[] rowData = {
                paciente.getId(),
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getFechaNacimiento(),
                paciente.getObraSocial(),
                paciente.getNumeroSocio(),
                paciente.getAntecedentesPersonales(),
                paciente.getAntecedentesFamiliares()
            };
            model.addRow(rowData);
        }
    }
       // Agregar un listener de selección a la tabla
 tablePacientes.getSelectionModel().addListSelectionListener(e -> {
    if (!e.getValueIsAdjusting()) {
        try {
            // Obtener el valor de la columna invisible de ID del paciente seleccionado
            int selectedRow = tablePacientes.getSelectedRow();
            int idPacienteSeleccionado = (int) tablePacientes.getValueAt(selectedRow, 0); // Cambia 0 por el índice correcto de la columna

            // Puedes almacenar idPacienteSeleccionado como una variable de clase en tu objeto Principal
            this.idPacienteSeleccionado = idPacienteSeleccionado;
        } catch (ArrayIndexOutOfBoundsException ex) {
            // Manejar la excepción aquí, por ejemplo, imprimir un mensaje de error o mostrar un diálogo de error
            System.err.println("Error: Paciente no indexado");
        }
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

        panel1 = new org.edisoncor.gui.panel.Panel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePacientes = new javax.swing.JTable();
        panelRectTranslucido1 = new org.edisoncor.gui.panel.PanelRectTranslucido();
        btnSalirr = new org.edisoncor.gui.button.ButtonAction();
        btnBuscar = new org.edisoncor.gui.button.ButtonAction();
        txtBuscar = new org.edisoncor.gui.textField.TextField();
        btnLimpiar = new org.edisoncor.gui.button.ButtonAction();
        btnAgregar = new org.edisoncor.gui.button.ButtonAction();
        btnEliminar = new org.edisoncor.gui.button.ButtonAction();
        btnConsulta = new org.edisoncor.gui.button.ButtonAction();
        btnHistorial = new org.edisoncor.gui.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalantsistemamedico/images/1.png"))); // NOI18N

        tablePacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PACIENTE", "NOMBRE", "APELLIDO", "FEC NACIMIENTO"
            }
        ));
        jScrollPane1.setViewportView(tablePacientes);

        panelRectTranslucido1.setAnchoDeBorde(1.0F);
        panelRectTranslucido1.setAnchoDeSegundoBorde(0.1F);
        panelRectTranslucido1.setTran(0.0F);

        btnSalirr.setBackground(new java.awt.Color(0, 204, 255));
        btnSalirr.setForeground(new java.awt.Color(255, 0, 0));
        btnSalirr.setText("SALIR");
        btnSalirr.setColorDeSombra(new java.awt.Color(0, 153, 255));
        btnSalirr.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSalirr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirrActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(0, 204, 255));
        btnBuscar.setForeground(new java.awt.Color(204, 255, 0));
        btnBuscar.setText("BUSCAR");
        btnBuscar.setColorDeSombra(new java.awt.Color(0, 153, 255));
        btnBuscar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(0, 204, 255));
        btnLimpiar.setForeground(new java.awt.Color(204, 255, 102));
        btnLimpiar.setText("ACTUALIZAR");
        btnLimpiar.setColorDeSombra(new java.awt.Color(0, 153, 255));
        btnLimpiar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(0, 204, 255));
        btnAgregar.setForeground(new java.awt.Color(51, 204, 0));
        btnAgregar.setText("AGREGAR");
        btnAgregar.setColorDeSombra(new java.awt.Color(0, 153, 255));
        btnAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(0, 204, 255));
        btnEliminar.setForeground(new java.awt.Color(255, 0, 51));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setColorDeSombra(new java.awt.Color(0, 153, 255));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnConsulta.setBackground(new java.awt.Color(0, 204, 255));
        btnConsulta.setForeground(new java.awt.Color(0, 255, 51));
        btnConsulta.setText("CONSULTA");
        btnConsulta.setColorDeSombra(new java.awt.Color(0, 153, 255));
        btnConsulta.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        btnHistorial.setBackground(new java.awt.Color(0, 204, 255));
        btnHistorial.setForeground(new java.awt.Color(51, 255, 51));
        btnHistorial.setText("HISTORIAL");
        btnHistorial.setColorDeSombra(new java.awt.Color(0, 153, 255));
        btnHistorial.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRectTranslucido1Layout = new javax.swing.GroupLayout(panelRectTranslucido1);
        panelRectTranslucido1.setLayout(panelRectTranslucido1Layout);
        panelRectTranslucido1Layout.setHorizontalGroup(
            panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRectTranslucido1Layout.createSequentialGroup()
                        .addComponent(btnSalirr, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRectTranslucido1Layout.createSequentialGroup()
                        .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panelRectTranslucido1Layout.setVerticalGroup(
            panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRectTranslucido1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(btnSalirr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(110, 110, 110))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirrActionPerformed
           Salir confirmDialog = new Salir(); // Crear el JFrame de confirmación
    confirmDialog.setVisible(true); // Mostrar el JFrame de confirmación
    }//GEN-LAST:event_btnSalirrActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
      PacienteDAO pacienteDAO = new PacienteDAO(connection);

        String nombre = txtBuscar.getText(); // Obtener el texto del campo de búsqueda
    String apellido = txtBuscar.getText(); // Obtener el texto del campo de búsqueda
    
    try {
        List<Paciente> pacientesEncontrados = pacienteDAO.buscarPorNombreOApellido(nombre, apellido);
        
        DefaultTableModel model = (DefaultTableModel) tablePacientes.getModel();
        model.setRowCount(0); // Limpiar los datos existentes en la tabla
        
        for (Paciente paciente : pacientesEncontrados) {
            Object[] rowData = {
                paciente.getId(),
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getFechaNacimiento(),
                paciente.getObraSocial(),
                paciente.getNumeroSocio(),
                paciente.getAntecedentesPersonales(),
                paciente.getAntecedentesFamiliares()
            };
            model.addRow(rowData); // Agregar fila a la tabla
        }
    } catch (SQLException e) {
        // Manejar la excepción (mostrar mensaje de error, registro de error, etc.)
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        PacienteDAO pacienteDAO = new PacienteDAO(connection); 
         try {
        List<Paciente> pacientes = pacienteDAO.getAll();
        
        DefaultTableModel model = (DefaultTableModel) tablePacientes.getModel();
        model.setRowCount(0); // Limpiar los datos existentes en la tabla
        
        for (Paciente paciente : pacientes) {
            Object[] rowData = {
                paciente.getId(),
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getFechaNacimiento(),
                paciente.getObraSocial(),
                paciente.getNumeroSocio(),
                paciente.getAntecedentesPersonales(),
                paciente.getAntecedentesFamiliares()
            };
            model.addRow(rowData); // Agregar fila a la tabla
        }
        
        txtBuscar.setText(""); // Limpiar el campo de búsqueda
    } catch (SQLException e) {
        // Manejar la excepción (mostrar mensaje de error, registro de error, etc.)
    }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
         NuevoPaciente nuevoPacienteFrame = new NuevoPaciente(connection);
        nuevoPacienteFrame.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
     int selectedRow = tablePacientes.getSelectedRow();

    if (selectedRow >= 0 && selectedRow < tablePacientes.getRowCount()) {
        int confirmResult = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar el paciente seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION);
        
        if (confirmResult == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) tablePacientes.getModel();
            int pacienteId = (int) model.getValueAt(selectedRow, 0);

            try {
                PacienteDAO pacienteDAO = new PacienteDAO(connection);
                pacienteDAO.delete(pacienteId); // Eliminar el paciente de la base de datos

                model.removeRow(selectedRow); // Eliminar la fila de la tabla

                JOptionPane.showMessageDialog(this, "Paciente eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el paciente.", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un paciente válido para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    
    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
    // Obtener el índice de la fila seleccionada en la tabla
    int selectedRow = tablePacientes.getSelectedRow();
    if (selectedRow == -1) {
        // No hay ninguna fila seleccionada en la tabla
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un paciente en la tabla", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Obtener los valores de las celdas de la fila seleccionada
    String nombrePaciente = (String) tablePacientes.getValueAt(selectedRow, 1); // Cambia 1 por el índice correcto de la columna
    String apellidoPaciente = (String) tablePacientes.getValueAt(selectedRow, 2); // Cambia 2 por el índice correcto de la columna

    // Crear una instancia de la clase NuevaConsulta y proporcionarle una conexión a la base de datos
    NuevaConsulta nuevaConsulta = new NuevaConsulta(connection, nombrePaciente, apellidoPaciente, idPacienteSeleccionado);
    nuevaConsulta.setVisible(true);
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
  int selectedRow = tablePacientes.getSelectedRow();
    
    if (selectedRow >= 0) {
        int idPacienteSeleccionado = (int) tablePacientes.getValueAt(selectedRow, 0);
        
        try {
            PacienteDAO pacienteDAO = new PacienteDAO(connection);
            ConsultaDAO consultaDAO = new ConsultaDAO(connection);
            
            Paciente paciente = pacienteDAO.getPacienteById(idPacienteSeleccionado);
            List<Consulta> consultas = consultaDAO.getConsultasByPacienteId(idPacienteSeleccionado);
            
            // Crear un nuevo documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("HistorialPaciente.pdf"));
            document.open();
            
            // Agregar información del paciente al PDF
            Paragraph header = new Paragraph("Historial del Paciente");
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);
            
            document.add(new Paragraph("Nombre: " + paciente.getNombre() + " " + paciente.getApellido()));
            document.add(new Paragraph("Fecha de Nacimiento: " + paciente.getFechaNacimiento()));
            document.add(new Paragraph("Obra Social: " + paciente.getObraSocial()));
            
            // Agregar información de las consultas
            document.add(new Paragraph("Consultas:"));
            for (Consulta consulta : consultas) {
                document.add(new Paragraph("Título: " + consulta.getTitulo()));
                document.add(new Paragraph("Diagnóstico: " + consulta.getDiagnostico()));
                document.add(new Paragraph("-----------------------"));
            }
            
            document.close();
            JOptionPane.showMessageDialog(this, "PDF generado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (DocumentException | IOException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar el PDF.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un paciente para generar el historial.", "Error", JOptionPane.ERROR_MESSAGE);
    }
  
    }//GEN-LAST:event_btnHistorialActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction btnAgregar;
    private org.edisoncor.gui.button.ButtonAction btnBuscar;
    private org.edisoncor.gui.button.ButtonAction btnConsulta;
    private org.edisoncor.gui.button.ButtonAction btnEliminar;
    private org.edisoncor.gui.button.ButtonAction btnHistorial;
    private org.edisoncor.gui.button.ButtonAction btnLimpiar;
    private org.edisoncor.gui.button.ButtonAction btnSalirr;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    private javax.swing.JTable tablePacientes;
    private org.edisoncor.gui.textField.TextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
