package com.stou.tec;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class STOUTECForm extends JFrame {
    private FormHeader headerPanel;
    private PersonalInfoPanel personalInfoPanel;
    private QualificationPanel qualificationPanel;
    private PositionPanel positionPanel;
    private JButton submitButton;

    public STOUTECForm() {
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        configureWindow();
    }

    private void initializeComponents() {
        headerPanel = new FormHeader();
        personalInfoPanel = new PersonalInfoPanel();
        qualificationPanel = new QualificationPanel();
        positionPanel = new PositionPanel();
        submitButton = new JButton("ตกลง");
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(FormConstants.BACKGROUND_COLOR);

        JPanel formContentPanel = new JPanel(new GridBagLayout());
        formContentPanel.setBackground(FormConstants.BACKGROUND_COLOR);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 0, 10, 0);

        gbc.gridy = 0;
        formContentPanel.add(personalInfoPanel, gbc);
        gbc.gridy = 1;
        formContentPanel.add(qualificationPanel, gbc);
        gbc.gridy = 2;
        formContentPanel.add(positionPanel, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(FormConstants.BACKGROUND_COLOR);
        buttonPanel.add(submitButton);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(formContentPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void setupEventHandlers() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });
    }

    private void configureWindow() {
        setTitle(FormConstants.WINDOW_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        pack();
        setLocationRelativeTo(null);
    }

    private void handleSubmit() {
        ApplicantData data = new ApplicantData();

        personalInfoPanel.populateData(data);
        qualificationPanel.populateData(data);
        positionPanel.populateData(data);

        JOptionPane.showMessageDialog(this, data.toString(),
                "ข้อมูลการสมัคร - 6696010161", JOptionPane.INFORMATION_MESSAGE);
    }
}