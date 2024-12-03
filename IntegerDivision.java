import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntegerDivision {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Integer Division");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel and layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 5, 5));

        // Create components
        JLabel label1 = new JLabel("Num1:");
        JTextField num1Field = new JTextField();
        JLabel label2 = new JLabel("Num2:");
        JTextField num2Field = new JTextField();
        JButton divideButton = new JButton("Divide");
        JLabel resultLabel = new JLabel("Result:");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        // Add components to panel
        panel.add(label1);
        panel.add(num1Field);
        panel.add(label2);
        panel.add(num2Field);
        panel.add(divideButton);
        panel.add(new JLabel()); // Empty cell
        panel.add(resultLabel);
        panel.add(resultField);

        // Add panel to frame
        frame.add(panel);

        // Add action listener to button
        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(num1Field.getText());
                    int num2 = Integer.parseInt(num2Field.getText());
                    if (num2 == 0) {
                        throw new ArithmeticException("Cannot divide by zero.");
                    }
                    int result = num1 / num2;
                    resultField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid integers.", "Number Format Error", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Arithmetic Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Make frame visible
        frame.setVisible(true);
    }
}
