import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {
    CButton[] numberButtons;
    JLabel calculation;
    public MainPanel(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(406, 612));
        this.setBackground(new Color(0xF3F3F3));
        calculation = new JLabel("0");
        calculation.setForeground(new Color(0x1A1A1A));
        calculation.setFont(new Font("Segoe UI", Font.BOLD, 45));
        calculation.setBounds(46, 77, 347, 60);
        calculation.setHorizontalAlignment(SwingConstants.RIGHT);


        numberButtons = new CButton[10];

        for (int i=0, buttonNumber = 7, x = 5, y = 345; i < numberButtons.length; ++i){
            numberButtons[i] = new CButton(buttonNumber, Color.WHITE, 5);
            numberButtons[i].setBounds(x, y, 96, 62);
            numberButtons[i].addActionListener(this);
            this.add(numberButtons[i]);

            x += 100;
            buttonNumber++;
            if (((i + 1) % 3) == 0){
                x = 5;
                y += 66;
                buttonNumber -= 6;
                if ((i + 2) == numberButtons.length){
                    x = 105;
                    y = 543;
                    buttonNumber = 0;
                }
            }

        }
        this.add(calculation);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (CButton button : numberButtons){
            if (e.getSource() == button){
                if (Double.parseDouble(calculation.getText()) == 0D)
                    calculation.setText(button.getText());
                else
                    calculation.setText(calculation.getText() + button.getText());
            }
        }
    }
}
