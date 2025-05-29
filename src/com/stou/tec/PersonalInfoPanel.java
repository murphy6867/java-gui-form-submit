package com.stou.tec;

import javax.swing.*;
import java.awt.*;

public class PersonalInfoPanel extends JPanel {
    private JTextField apIdField;
    private JTextField apNameField;
    private JTextField apAddressField;
    private JTextField apChwField;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private ButtonGroup genderGroup;
    private JTextField apEdField;
    private JTextField apMajField;

    public PersonalInfoPanel() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        apIdField = new JTextField(20);
        apNameField = new JTextField(20);
        apAddressField = new JTextField(20);
        apChwField = new JTextField(15);
        apEdField = new JTextField(20);
        apMajField = new JTextField(20);

        maleRadio = new JRadioButton("ชาย", true);
        femaleRadio = new JRadioButton("หญิง");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        setBackground(FormConstants.BACKGROUND_COLOR);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        int row = 0;

        gbc.gridx = 0; gbc.gridy = row;
        add(new JLabel("เลขประจำตัวของผู้สมัคร:"), gbc);
        gbc.gridx = 1;
        add(apIdField, gbc);
        row++;

        gbc.gridx = 0; gbc.gridy = row;
        add(new JLabel("ชื่อ-นามสกุล:"), gbc);
        gbc.gridx = 1;
        add(apNameField, gbc);
        row++;

        gbc.gridx = 0; gbc.gridy = row;
        add(new JLabel("ที่อยู่:"), gbc);
        gbc.gridx = 1;
        add(apAddressField, gbc);
        row++;

        gbc.gridx = 0; gbc.gridy = row;
        add(new JLabel("จังหวัด:"), gbc);
        gbc.gridx = 1;
        add(apChwField, gbc);
        row++;

        gbc.gridx = 0; gbc.gridy = row;
        add(new JLabel("เพศ:"), gbc);
        gbc.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        genderPanel.setBackground(FormConstants.BACKGROUND_COLOR);
        genderPanel.add(maleRadio);
        genderPanel.add(Box.createHorizontalStrut(20));
        genderPanel.add(femaleRadio);
        add(genderPanel, gbc);
        row++;

        gbc.gridx = 0; gbc.gridy = row;
        add(new JLabel("วุฒิการศึกษาขั้นสูงสุด:"), gbc);
        gbc.gridx = 1;
        add(apEdField, gbc);
        row++;

        gbc.gridx = 1; gbc.gridy = row;
        JLabel eduNote = new JLabel("(เช่น B.S., B.A., M.S., M.BA., M.A.)");
        eduNote.setFont(FormConstants.SMALL_FONT);
        add(eduNote, gbc);
        row++;

        gbc.gridx = 0; gbc.gridy = row;
        add(new JLabel("วิชาเอก:"), gbc);
        gbc.gridx = 1;
        add(apMajField, gbc);
    }

    public void populateData(ApplicantData data) {
        data.setApId(apIdField.getText());
        data.setApName(apNameField.getText());
        data.setApAddress(apAddressField.getText());
        data.setApChw(apChwField.getText());
        data.setApSex(maleRadio.isSelected() ? "ชาย" : "หญิง");
        data.setApEd(apEdField.getText());
        data.setApMaj(apMajField.getText());
    }
}
