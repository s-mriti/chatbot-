import java.awt.*;
import java.awt.event.*;

public class AWTControlExample extends Frame implements ActionListener, ItemListener, WindowListener {

    // Declare components
    Label lblName, lblGender, lblLang, lblChoice, lblOutput;
    TextField txtName;
    Button btnSubmit, btnClear;
    Checkbox chkJava, chkPython;
    CheckboxGroup genderGroup;
    Checkbox male, female;
    Choice choiceCountry;

    public AWTControlExample() {

        // Set layout and frame properties
        setLayout(new FlowLayout());
        setTitle("AWT Controls and Event Handling Example");
        setSize(400, 400);

        // Initialize components
        lblName = new Label("Name:");
        txtName = new TextField(20);

        lblGender = new Label("Gender:");
        genderGroup = new CheckboxGroup();
        male = new Checkbox("Male", genderGroup, false);
        female = new Checkbox("Female", genderGroup, false);

        lblLang = new Label("Languages Known:");
        chkJava = new Checkbox("Java");
        chkPython = new Checkbox("Python");

        lblChoice = new Label("Country:");
        choiceCountry = new Choice();
        choiceCountry.add("Select Country");
        choiceCountry.add("India");
        choiceCountry.add("Bahrain");
        choiceCountry.add("Chile");


        btnSubmit = new Button("Submit");
        btnClear = new Button("Clear");

        lblOutput = new Label("");

        // Add components to frame
        add(lblName);
        add(txtName);
        add(lblGender);
        add(male);
        add(female);
        add(lblLang);
        add(chkJava);
        add(chkPython);
        add(lblChoice);
        add(choiceCountry);
        add(btnSubmit);
        add(btnClear);
        add(lblOutput);

        // Register listeners
        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);
        chkJava.addItemListener(this);
        chkPython.addItemListener(this);
        male.addItemListener(this);
        female.addItemListener(this);
        addWindowListener(this);

        setVisible(true);
    }

    // ActionListener method
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            String name = txtName.getText();
            String gender = genderGroup.getSelectedCheckbox() != null
                    ? genderGroup.getSelectedCheckbox().getLabel()
                    : "";
            String lang = "";
            if (chkJava.getState()) lang += "Java ";
            if (chkPython.getState()) lang += "Python ";

            String country = choiceCountry.getSelectedItem();

            lblOutput.setText("Name: " + name + ", Gender: " + gender +
                    ", Languages: " + lang + ", Country: " + country);
        }

        if (e.getSource() == btnClear) {
            txtName.setText("");
            genderGroup.setSelectedCheckbox(null);
            chkJava.setState(false);
            chkPython.setState(false);
            choiceCountry.select(0);
            lblOutput.setText("");
        }
    }

    // ItemListener method
    public void itemStateChanged(ItemEvent e) {
        // Optional: handle item changes if needed
    }

    // WindowListener methods
    public void windowClosing(WindowEvent e) {
        dispose();
    }

    public void windowOpened(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}

    // Main method
    public static void main(String[] args) {
        new AWTControlExample();
    }
}