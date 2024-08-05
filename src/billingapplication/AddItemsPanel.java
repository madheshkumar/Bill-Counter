package billingapplication;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class AddItemsPanel extends JPanel {

    // Variables declaration
    private JPanel innerPanel;

    private JLabel title;
    private JLabel mealLabel;
    private JLabel priceLabel;
    private JLabel mealtypeLabel;

    private JTextField meal;
    private JTextField price;

    private ButtonGroup mealButtonGroup;
    private JRadioButton vegButton;
    private JRadioButton nonvegButton;

    private JLabel validate;
    private JButton addItem;
    private JButton backButton;

    private final Color textLabelColor = new Color(24, 46, 87);
    private final Color textFieldColor = new Color(52, 69, 97);
    private final Font textFont = new Font("Segoe UI", 1, 18);
    private final LineBorder lineBorder = new LineBorder(new Color(62, 62, 105), 2, true);
    private final BevelBorder bevelBorder = new BevelBorder(BevelBorder.RAISED);

    public AddItemsPanel() {
        initComponents();
    }

    private void initComponents() {

        title = new JLabel();
        innerPanel = new JPanel();
        mealLabel = new JLabel();
        priceLabel = new JLabel();
        meal = new JTextField();
        price = new JTextField();

        mealtypeLabel = new JLabel();
        mealButtonGroup = new ButtonGroup();
        vegButton = new JRadioButton();
        nonvegButton = new JRadioButton();

        validate = new JLabel();

        addItem = new JButton();
        backButton = new JButton();

        title.setText("ADD ITEM");
        title.setForeground(new Color(60, 68, 126));
        title.setFont(new Font("Segoe UI", 1, 22));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        title.setRequestFocusEnabled(false);
        title.setBounds(300, 0, 200, 50);
        add(title);

        mealLabel.setText("Meal Name");
        mealLabel.setForeground(textLabelColor);
        mealLabel.setFont(textFont);
        mealLabel.setBounds(100, 100, 200, 30);
        mealLabel.setHorizontalAlignment(SwingConstants.LEFT);

        priceLabel.setText("Price (in Rs)");
        priceLabel.setForeground(textLabelColor);
        priceLabel.setFont(textFont);
        priceLabel.setBounds(100, 160, 200, 30);
        priceLabel.setHorizontalAlignment(SwingConstants.LEFT);

        meal.setBounds(300, 100, 250, 40);
        meal.setFont(textFont);
        meal.setHorizontalAlignment(SwingConstants.LEFT);
        meal.setBorder(lineBorder);
        meal.setForeground(textFieldColor);

        price.setBounds(300, 160, 250, 40);
        price.setFont(textFont);
        price.setHorizontalAlignment(SwingConstants.LEFT);
        price.setBorder(lineBorder);
        price.setForeground(textFieldColor);

        mealtypeLabel.setText("Meal Type");
        mealtypeLabel.setForeground(textLabelColor);
        mealtypeLabel.setFont(textFont);
        mealtypeLabel.setBounds(100, 220, 200, 30);
        mealtypeLabel.setHorizontalAlignment(SwingConstants.LEFT);

        vegButton.setText("Veg");
        vegButton.setFont(textFont);
        vegButton.setBackground(null);
        vegButton.setBounds(300, 220, 100, 30);
        vegButton.setForeground(new Color(19, 145, 34));
        vegButton.setFocusPainted(false);

        nonvegButton.setText("Non-Veg");
        nonvegButton.setBackground(null);
        nonvegButton.setFont(textFont);
        nonvegButton.setBounds(400, 220, 150, 30);
        nonvegButton.setForeground(new Color(209, 35, 23));
        nonvegButton.setFocusPainted(false);

        mealButtonGroup.add(vegButton);
        mealButtonGroup.add(nonvegButton);

        validate.setText("");
        validate.setFont(new Font("Segoe UI", 1, 16));
        validate.setForeground(new Color(209, 35, 23));
        validate.setBounds(300, 260, 200, 30);


        addItem.setText("Add Item");
        addItem.setFont(textFont);
        addItem.setBounds(300, 300, 200, 40);
        addItem.setBackground(new Color(37, 64, 105));
        addItem.setForeground(new Color(193, 213, 245));
        addItem.setBorder(lineBorder);
        addItem.setFocusPainted(false);

        backButton.setText("Back to menu");
        backButton.setFont(textFont);
        backButton.setBounds(300, 380, 200, 40);
        backButton.setBackground(new Color(102, 136, 186));
        backButton.setForeground(new Color(37, 64, 105));
        backButton.setBorder(lineBorder);
        backButton.setFocusPainted(false);

        innerPanel.add(mealLabel);
        innerPanel.add(priceLabel);
        innerPanel.add(meal);
        innerPanel.add(price);
        innerPanel.add(mealtypeLabel);
        innerPanel.add(vegButton);
        innerPanel.add(nonvegButton);
        innerPanel.add(validate);
        innerPanel.add(addItem);
        innerPanel.add(backButton);


        innerPanel.setBackground(new Color(153, 153, 255));
        innerPanel.setBorder(bevelBorder);
        innerPanel.setLayout(null);
        innerPanel.setBounds(20, 50, 740, 480);

        add(innerPanel);

        setLayout(null);
        setBackground(new Color(193, 213, 245));
        
    }

    public JTextField getMeal() {
        return meal;
    }

    public JTextField getPrice() {
        return price;
    }

    public JRadioButton getVegButton() {
        return vegButton;
    }

    public JRadioButton getNonvegButton() {
        return nonvegButton;
    }


    public JButton getAddItem() {
        return addItem;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JLabel getValidate() {
        return validate;
    }


}
