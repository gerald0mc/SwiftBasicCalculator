import javax.swing.*;

public class Main {
    //Program version
    public static final String VERSION = "1.0";
    //Types of math you can do with this calculator
    public enum MathType {ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION}

    public static void main(String[] args) {
        //A new initialization for our frame
        JFrame frame = new JFrame();
        //Makes it so when you click the close button, it actually closes
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Sets the title of the frame
        frame.setTitle("Calculator v" + VERSION);
        //Sets the frames location to the center of the screen
        frame.setLocationRelativeTo(null);
        //A new initialization for our panel
        JPanel panel = new JPanel();
        //Sets the panels layout to a vertical up and down layout
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //A new initialization for a label with a bit of info
        JLabel titleLabel = new JLabel("Enter both your numbers, then set the math type, then press calculate.");
        //A new initialization for a text field for the first number that is entered
        JTextField firstIntField = new JTextField("Number One");
        //A new initialization for a text field for the second number that is entered
        JTextField secondIntField = new JTextField("Number Two");
        //A new initialization for a combo box containing all the MathType values
        JComboBox comboBox = new JComboBox(MathType.values());
        //A new initialization for a button that contains a bit of info
        JButton calculateButton = new JButton("Calculate!");
        //Adds a listener to the button
        calculateButton.addActionListener(event -> {
            //A new initialization for the first number
            double firstNum;
            //A new initialization for the second number
            double secondNum;
            try {
                //Try to parse the first text fields text to a double
                firstNum = Double.parseDouble(firstIntField.getText());
            } catch (Exception e) {
                //Catch and display a frame if the number entered was not actually a number
                displayInfoFrame("You entered a incorrect type of number please retry.");
                //Return
                return;
            }
            try {
                //Try to parse the second text fields text to a double
                secondNum = Double.parseDouble(secondIntField.getText());
            } catch (Exception e) {
                //Catch and display a frame if the number entered was not actually a number
                displayInfoFrame("You entered a incorrect type of number please retry.");
                //Return
                return;
            }
            //Displays a new frame with the result of your calculation if everything went according to plan
            displayInfoFrame("Your calculation came out to [" + performCalculation(firstNum, secondNum, (MathType) comboBox.getSelectedItem()) + "]!");
        });
        //Add the first box
        panel.add(titleLabel);
        //Add the second box
        panel.add(firstIntField);
        //Add the third box
        panel.add(secondIntField);
        //Add the fourth box
        panel.add(comboBox);
        //Add the fifth box
        panel.add(calculateButton);
        //Add the panel containing all the Swift comps
        frame.add(panel);
        //Makes everything fit together properly
        frame.pack();
        //Sets the frames visibility to true (you can see it now)
        frame.setVisible(true);
    }

    /**
     * <p>A method that takes in the first and second numbers, along with a MathType to perform a basic calculation and send the response in the log.</p>
     * @param firstNum The first number the User is trying to calculate.
     * @param secondNum The second number the User is trying to calculate.
     * @param mathType The type of calculation type you are performing.
     * @return The result of the calculation.
     * @since 1.0
     */
    public static Double performCalculation(double firstNum, double secondNum, MathType mathType) {
        return switch (mathType) {
            case ADDITION -> firstNum + secondNum;
            case SUBTRACTION -> firstNum - secondNum;
            case MULTIPLICATION -> firstNum * secondNum;
            case DIVISION -> firstNum / secondNum;
        };
    }

    //Method that is used multiple time, is just a label with a message that you set and a button that closes the frame
    public static void displayInfoFrame(String message) {
        //A new initialization of a frame
        JFrame frame = new JFrame();
        //Makes it so when you click the close button, it actually closes
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Sets the title of the frame
        frame.setTitle("Calculator v" + VERSION);
        //Sets the frames location to the center of the screen
        frame.setLocationRelativeTo(null);
        //A new initialization of a panel
        JPanel panel = new JPanel();
        //Sets the panels layout to a vertical up and down layout
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //A new initialization of a label with the message you set
        JLabel label = new JLabel(message);
        //A new initialization of a button with a bit of info
        JButton button = new JButton("Close!");
        //Sets the buttons action listener to setting the visibility of the frame to false, in other words closing it
        button.addActionListener(event -> frame.setVisible(false));
        //Add the first box
        panel.add(label);
        //Add the second box
        panel.add(button);
        //Add the third box
        frame.add(panel);
        //Makes everything fit together properly
        frame.pack();
        //Sets the frames visibility to true (you can see it now)
        frame.setVisible(true);
    }
}
