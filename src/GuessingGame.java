import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame{
	private JTextField textGuess;
	private JLabel lblOutput;
	private int theNumber;
	public void checkGuess() {
		String guessText = textGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
				
			if (guess < theNumber) { message = guess + "is too low. Try again."; }
			else if (guess > theNumber) { message = guess + "is too high. Try again."; }
			else { 
				message = guess + "is correct. You win!. Let' play again!"; 
				newGame();
			}
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100.";
		} finally {
			lblOutput.setText(message);
			textGuess.requestFocus();
			textGuess.selectAll();
		}
	}
	
	public void newGame ( ) {
		theNumber = (int)(Math.random() * 100 + 1);
	}
	
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tissue's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tissue's Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 422, 28);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(10, 71, 287, 20);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(172, 149, 89, 23);
		getContentPane().add(btnGuess);
		
		textGuess = new JTextField();
		textGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		textGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		textGuess.setBounds(307, 72, 96, 18);
		getContentPane().add(textGuess);
		textGuess.setColumns(10);
		
		lblOutput = new JLabel(" Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(63, 166, 316, 18);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame =  new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);

	}
}
