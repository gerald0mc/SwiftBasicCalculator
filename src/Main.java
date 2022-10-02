import javax.swing.*;

public class Main {
    public static final String VERSION = "1.0";

    public enum MathType {ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION}

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Calculator v" + VERSION);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel("Enter both your numbers, then set the math type, then press calculate.");
        JTextField firstIntField = new JTextField("Number One");
        JTextField secondIntField = new JTextField("Number Two");
        JComboBox comboBox = new JComboBox(MathType.values());
        JButton calculateButton = new JButton("Calculate!");
        calculateButton.addActionListener(event -> {
            double firstInt;
            double secondInt;
            try {
                firstInt = Double.parseDouble(firstIntField.getText());
            } catch (Exception e) {
                displayInfoFrame("You entered a incorrect type of number please retry.");
                return;
            }
            try {
                secondInt = Double.parseDouble(secondIntField.getText());
            } catch (Exception e) {
                displayInfoFrame("You entered a incorrect type of number please retry.");
                return;
            }
            displayInfoFrame("Your calculation came out to [" + performCalculation(firstInt, secondInt, (MathType) comboBox.getSelectedItem()) + "]!");
        });
        panel.add(titleLabel);
        panel.add(firstIntField);
        panel.add(secondIntField);
        panel.add(comboBox);
        panel.add(calculateButton);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static Double performCalculation(double firstInt, double secondInt, MathType mathType) {
        return switch (mathType) {
            case ADDITION -> firstInt + secondInt;
            case SUBTRACTION -> firstInt - secondInt;
            case MULTIPLICATION -> firstInt * secondInt;
            case DIVISION -> firstInt / secondInt;
        };
    }

    public static void displayInfoFrame(String errorMessage) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Calculator v" + VERSION);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel(errorMessage);
        JButton button = new JButton("Close!");
        button.addActionListener(event -> frame.setVisible(false));
        panel.add(label);
        panel.add(button);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}