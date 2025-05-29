package com.stou.tec;

import javax.swing.*;
import java.awt.*;

public class QualificationPanel extends JPanel {
    private JComboBox<String>[] qualComboBoxes;

    @SuppressWarnings("unchecked")
    public QualificationPanel() {
        initializeComponents();
        setupLayout();
    }

    @SuppressWarnings("unchecked")
    private void initializeComponents() {
        qualComboBoxes = new JComboBox[5];

        for (int i = 0; i < 5; i++) {
            qualComboBoxes[i] = new JComboBox<>(FormConstants.QUALIFICATION_OPTIONS);
            qualComboBoxes[i].setSelectedItem(i);
        }
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        setBackground(FormConstants.BACKGROUND_COLOR);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Section title
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel qualTitle = new JLabel("ความรู้ความสามารถหรือคุณสมบัติเฉพาะตัวแบบนั้น (ตอบได้ไม่เกิน 5 รายการ): ");
        qualTitle.setFont(FormConstants.SECTION_FONT);
        add(qualTitle, gbc);
        gbc.gridwidth = 1;

        // Qualification dropdowns
        for (int i = 0; i < 5; i++) {
            gbc.gridx = 0; gbc.gridy = i + 1;
            add(new JLabel("ความรู้ความสามารถ " + (i + 1)), gbc);
            gbc.gridx = 1;
            add(qualComboBoxes[i], gbc);
        }
    }

    public void populateData(ApplicantData data) {
        String[] qualifications = new String[5];

        for (int i = 0; i < 5; i++) {
            String selectedValue = (String) qualComboBoxes[i].getSelectedItem();
            if (selectedValue != null && selectedValue.equals("เลือกความรู้ความสามารถ")) {
                qualifications[i] = null;
            } else {
                qualifications[i] = selectedValue;
            }
        }
        data.setQualifications(qualifications);
    }
}