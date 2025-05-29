package com.stou.tec;

import javax.swing.*;
import java.awt.*;

public class PositionPanel extends JPanel {
    private JComboBox<String>[] positionComboBoxes;

    public PositionPanel() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        positionComboBoxes = new JComboBox[3];

        for (int i = 0; i < 3; i++) {
            positionComboBoxes[i] = new JComboBox<>(FormConstants.POSITION_OPTIONS);
            positionComboBoxes[i].setSelectedItem(i);
        }
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        setBackground(FormConstants.BACKGROUND_COLOR);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel qualTitle = new JLabel("ตำแหน่่งที่ต้องการสมัคร (ตอบได้ไม่เกิน 3 ตำแหน่ง): ");
        qualTitle.setFont(FormConstants.SECTION_FONT);
        add(qualTitle, gbc);
        gbc.gridwidth = 1;

        for (int i = 0; i < 3; i++) {
            gbc.gridx = 0; gbc.gridy = i + 1;
            add(new JLabel("ตำแหน่งที่ต้องการสมัคร " + (i + 1)), gbc);
            gbc.gridx = 1;
            add(positionComboBoxes[i], gbc);
        }
    }

    public void populateData(ApplicantData data) {
        String[] positions = new String[3];

        for (int i = 0; i < 3; i++) {
            String selectedValue = (String) positionComboBoxes[i].getSelectedItem();
            if (selectedValue != null && selectedValue.equals("เลือกตำแหน่งที่ต้องการสมัคร")) {
                positions[i] = null;
            } else {
                positions[i] = selectedValue;
            }
        }
        data.setPositions(positions);
    }
}