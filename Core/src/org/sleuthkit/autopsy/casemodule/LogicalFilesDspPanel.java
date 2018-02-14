/*
 * Autopsy Forensic Browser
 *
 * Copyright 2011-2016 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.casemodule;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;
import org.sleuthkit.autopsy.corecomponentinterfaces.DataSourceProcessor;
import org.sleuthkit.autopsy.coreutils.Logger;

@Messages({
    "LogicalFilesDspPanel.subTypeComboBox.localFilesOption.text=Local files and folders",
    "LogicalFilesDspPanel.subTypeComboBox.l01FileOption.text=Logical evidence file (L01)"
})
/**
 * Add input wizard subpanel for adding local files / dirs to the case
 */
final class LogicalFilesDspPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private static LocalFilesPanel localFilesPanel = new LocalFilesPanel();
    private static LogicalEvidenceFilePanel l01panel = LogicalEvidenceFilePanel.createInstance();
    private static LogicalFilesDspPanel instance;
    private static final Logger logger = Logger.getLogger(LogicalFilesDspPanel.class.getName());

    /**
     * Creates new form LocalFilesPanel
     */
    private LogicalFilesDspPanel() {
        initComponents();
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
        jPanel1.add(l01panel);
        jPanel1.add(localFilesPanel);
        l01panel.setVisible(false);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        localFilesPanel.addPropertyChangeListener(listener);
        l01panel.addPropertyChangeListener(listener); 
    }
    @Override
     public void removePropertyChangeListener(PropertyChangeListener listener) {
        super.removePropertyChangeListener(listener);
        localFilesPanel.removePropertyChangeListener(listener);
        l01panel.removePropertyChangeListener(listener); 
     }
    
    static synchronized LogicalFilesDspPanel getDefault() {
        if (instance == null) {
            instance = new LogicalFilesDspPanel();
        }
        return instance;
    }

    public String getContentType() {
        return NbBundle.getMessage(this.getClass(), "LocalFilesPanel.contentType.text");
    }

    void select() {
        jComboBox1.setSelectedIndex(0);
        localFilesPanel.setVisible(true);
        l01panel.setVisible(false);
        localFilesPanel.reset();
        l01panel.reset();
        jPanel1.repaint();
    }

    @Override
    public String toString() {
        return NbBundle.getMessage(this.getClass(), "LocalFilesDSProcessor.toString.text");
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
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.setPreferredSize(new java.awt.Dimension(467, 160));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {Bundle.LogicalFilesDspPanel_subTypeComboBox_localFilesOption_text(), Bundle.LogicalFilesDspPanel_subTypeComboBox_l01FileOption_text()}));
        jComboBox1.setMinimumSize(new java.awt.Dimension(379, 20));
        jComboBox1.setPreferredSize(new java.awt.Dimension(379, 20));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
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
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if (evt.getSource() instanceof JComboBox<?>) {
            JComboBox<?> cb = (JComboBox<?>) evt.getSource();
            String selectedSubType = jComboBox1.getSelectedItem().toString();
            if (selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_localFilesOption_text())) {
                localFilesPanel.setVisible(true);
                l01panel.setVisible(false);
            } else if (selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_l01FileOption_text())) {
                localFilesPanel.setVisible(false);
                l01panel.setVisible(true);
            }
            firePropertyChange(DataSourceProcessor.DSP_PANEL_EVENT.UPDATE_UI.toString(), false, true);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    boolean validatePanel() {
        // display warning if there is one (but don't disable "next" button)

        String selectedSubType = jComboBox1.getSelectedItem().toString();
        if (selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_localFilesOption_text())) {
            return localFilesPanel.validatePanel();
        } else if (selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_l01FileOption_text())) {
            return l01panel.validatePanel();
        } else {
            return false;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    boolean contentsAreL01() {
        String selectedSubType = jComboBox1.getSelectedItem().toString();
        return selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_l01FileOption_text());
    }

    List<String> getContentPaths() {
        String selectedSubType = jComboBox1.getSelectedItem().toString();
        if (selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_localFilesOption_text())) {
            return localFilesPanel.getContentPaths();
        } else if (selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_l01FileOption_text())) {
            return l01panel.getContentPaths();
        } else {
            return new ArrayList<>();
        }

    }

    String getFileSetName() {
        String selectedSubType = jComboBox1.getSelectedItem().toString();
        if (selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_localFilesOption_text())) {
            return localFilesPanel.getFileSetName();
        } else if (selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_l01FileOption_text())) {
            return l01panel.getFileSetName();
        } else {
            return "";
        }
    }
}
