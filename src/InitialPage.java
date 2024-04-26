import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
public class InitialPage extends JPanel
{
    private JLabel gameName;
    private TextField username;
    private TextField initialMoney;
    private JButton beginGame;

    public InitialPage()
    {
        this.setLayout(new BorderLayout(100, 50));
        this.setBorder(BorderFactory.createEmptyBorder(200, 0, 200, 0));
        this.gameName = new JLabel("CapitalistSimulator", SwingConstants.CENTER);
        gameName.setFont(new Font("Courier New", Font.BOLD, 100));
        this.add(gameName, BorderLayout.NORTH);
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(0, 500, 0, 500));
        this.username = new TextField("USERNAME", 20);
        center.add(username);
        center.add(Box.createVerticalStrut(50));
        this.initialMoney = new TextField("INITIAL MONEY", 20);
        center.add(initialMoney);
        center.add(Box.createVerticalStrut(50));
        this.beginGame = new JButton("START");
        beginGame.setFont(new Font("Courier New", Font.BOLD, 20));
        center.add(beginGame);
        this.add(center, BorderLayout.CENTER);
    }

    public String getUsername()
    {
        return username.getText();
    }

    public int getInitialMoney()
    {
        String amount = initialMoney.getText();
        boolean isNumber = true;
        if(amount.equals(""))
        {
            isNumber = false;
        }
        for(int i = 0; (i < amount.length()) && (isNumber); i++)
        {
            char digit = amount.charAt(i);
            if(!Character.isDigit(digit))
            {
                isNumber = false;
            }
        }
        if(isNumber)
        {
            return Integer.parseInt(amount);
        }
        return((int) (Math.random() * 500000));
    }
}