package com.stou.tec;

import javax.swing.*;
import java.awt.*;

public class FormHeader extends JPanel {
    public FormHeader() {
        initializeComponent();
    }

    private void initializeComponent() {
        setLayout(new GridBagLayout());
        setBackground(FormConstants.BACKGROUND_COLOR);

        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel(FormConstants.COMPANY_NAME, SwingConstants.CENTER);
        titleLabel.setFont(FormConstants.TITLE_FONT);
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 5, 0);
        add(titleLabel, gbc);

        JLabel subtitleLabel = new JLabel(FormConstants.FORM_SUBTITLE, SwingConstants.CENTER);
        subtitleLabel.setFont(FormConstants.NORMAL_FONT);
        gbc.gridy = 1;
        add(subtitleLabel, gbc);

        JLabel descLabel1 = new JLabel(FormConstants.FORM_DESC1, SwingConstants.CENTER);
        descLabel1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        gbc.gridy = 2;
        add(descLabel1, gbc);

        JLabel descLabel2 = new JLabel(FormConstants.FORM_DESC2, SwingConstants.CENTER);
        descLabel2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 15, 0);
        add(descLabel2, gbc);
    }
}