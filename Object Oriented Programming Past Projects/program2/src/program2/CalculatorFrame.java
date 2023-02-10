package program2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;


/**
* <b>Title:</b> Program 2<br>
* <b>Filename:</b> CalculatorFrame.java<br>
* <b>Date Written:</b> March 5, 2021<br>
* <b>Due Date:</b> March 7, 2021<br>
* <p>
* <b>Description:</b><br>
* A calculator that allows the user to input an equation and calculate the result.
* </p>
* <p><b>Algorithm:</b></p>
* <p>
* Gets an equation from the input. It then converts the equation which is<br>
* infix to postfix. The calculator then calculates the result of the equation.
*</p>
*@author Richard Kim (n00923815)
*/
@SuppressWarnings("serial")
class CalculatorFrame extends JFrame implements ActionListener  {
	JTextField jtfInfix = new JTextField(21); // for infix 
	JTextField jtfPostfix = new JTextField();  // for postix
	JTextField result = new JTextField("0");   // for result
	
	JButton[][] calcButton = new JButton[4][5];
	
	JPanel calcPanel = new JPanel();	
	JPanel topPanel = new JPanel();    

	
	public CalculatorFrame() {
		String[][] buttonText = 
				new String[][]{{"7","8","9","*","C"},{"4","5","6","/","B"},
				{"1","2","3","-","R"},{"0","(",")","+","="}};
				
		this.setTitle("CSC130 Calculator");
		this.setLayout(new BorderLayout(2,1));

		jtfInfix.setHorizontalAlignment(JTextField.RIGHT);
		jtfPostfix.setHorizontalAlignment(JTextField.RIGHT);
		result.setHorizontalAlignment(JTextField.RIGHT);
		jtfPostfix.setEnabled(false);
		result.setEnabled(false);
		//jtfInfix.setEditable(false); // hide text caret
		
		// set the font size to 34 for the text fields
		Font textFieldFont=new Font(jtfPostfix.getFont().getName(),jtfPostfix.getFont().getStyle(),24);
		jtfInfix.setFont(textFieldFont);
		jtfPostfix.setFont(textFieldFont);
		result.setFont(textFieldFont);
		
		topPanel.setLayout(new GridLayout(3,1));				
		topPanel.add(jtfInfix);		
		topPanel.add(jtfPostfix);
		topPanel.add(result);
		
		calcPanel.setLayout(new GridLayout(4,5,3,3));
		
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				calcButton[i][j]= new JButton("" + buttonText[i][j]);
				calcButton[i][j].setForeground(Color.blue);
				calcButton[i][j].setFont(new Font("sansserif",Font.BOLD,42));
				calcButton[i][j].addActionListener(this);
				calcButton[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
				calcPanel.add(calcButton[i][j]);
			}
		}
		this.add(topPanel,BorderLayout.NORTH);
		this.add(calcPanel,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {				
				if(e.getSource() == calcButton[i][j]){
					// clear
					if(i==0 && j == 4){
						jtfInfix.setText(null);
						jtfPostfix.setText(null);
						result.setText("0");
					}
					// backspace
					else if(i==1 && j == 4){
						if(jtfInfix.getDocument().getLength()>0)
							try {
								jtfInfix.setText(jtfInfix.getText(0, jtfInfix.getDocument().getLength()-1));
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						
					}
					// number or operator
					else if(j<4){
						jtfInfix.setText(jtfInfix.getText()
							+ calcButton[i][j].getText());
						}
					// = button pressed
					else if(i==3&&j==4){
						// erase contents of the postfix textfield
						jtfPostfix.setText(null);  
						// update the postfix textfield with the String returned  
						try {
							jtfPostfix.setText(infixToPostfix());
						} catch (StackFullException | StackEmptyException e1) {

						}
						// update the result textfield with the result of the computation
						try {
							result.setText("" + calculate());
						} catch (NumberFormatException e1) {
							
						} catch (StackFullException e1) {

						} catch (StackEmptyException e1) {
							
						}
					}
				}
			}
		}
    }
	
	
	/**
	 * <p>infixToPostfix</p>
	 * 
	 * Converts the equation from the input from infix to postfix.
	 * 
	 * @return The equation in postfix.
	 * @throws StackFullException If the stack is full.
	 * @throws StackEmptyException If the stack is empty.
	 */
	public String infixToPostfix() throws StackFullException, StackEmptyException{	
		String postFix = "";
		ArrayStack<String> operators = new ArrayStack<String>();
		String token;
		String expression = jtfInfix.getText();
		String delims = "+-*/() ";
		StringTokenizer strToken = new StringTokenizer(expression, delims, true);
		
		while(strToken.hasMoreTokens()){
			token = strToken.nextToken();
			
			// If the next token is a left parenthesis
			if(token.equals("(")) {
				operators.push(token);
			}
			// If the next token is a right parenthesis
			else if(token.equals(")")) {
				while(!operators.peek().equals("(")) {
					postFix += operators.pop() + " ";
				}
				operators.pop();
			}
			// If the next token is an operator
			else if(token.equals("+") ||
			token.equals("-") ||
			token.equals("*") ||
			token.equals("/")) {
				// Compares the operator on the stack to the token
				// to see which has precedence (if stack has operator).
				while(!operators.isEmpty() && (
						
				(token.equals("+") || token.equals("-")) &&
				(operators.peek().equals("+") || operators.peek().equals("-")) ||
						
				(token.equals("*") || token.equals("/")) &&
				(operators.peek().equals("*") || operators.peek().equals("/")) ||
						
				(token.equals("+") || token.equals("-")) &&
				(operators.peek().equals("*") || operators.peek().equals("/")))) {
					postFix += operators.pop() + " ";
				}
				operators.push(token);
			}
			// If the token is an operand, or a number.
			else {
				postFix += token + " ";
			}
		}
		
		// Pops the elements remaining in the stack.
		while(!(operators.isEmpty())) {
			postFix += operators.pop() + " ";
		}
		
		return postFix;
	}
	
	
	/**
	 * <p>calculate</p>
	 * 
	 * Calculates the postfix equation to get the final result from the input.
	 * 
	 * @return The calculated result
	 * @throws StackFullException If the stack is full.
	 * @throws NumberFormatException If the String being casted to an int is not a number.
	 * @throws StackEmptyException If the stack is empty.
	 */
	public String calculate() throws StackFullException, NumberFormatException, StackEmptyException {
		int first, second;
		ArrayStack<String> operands = new ArrayStack<String>();
		String token;
		String delims = "+-*/() ";
		StringTokenizer strToken = new StringTokenizer(jtfPostfix.getText(), delims, true);
		while(strToken.hasMoreTokens()) {
			token = strToken.nextToken();
			
			// If the token is a operand/number.
			if(!(token.equals("+") ||
			token.equals("-") ||
			token.equals("*") ||
			token.equals("/") ||
			token.equals(" "))) {
				operands.push(token);
			}
			// If the token is an operator.
			// It pops two elements from the stack and applies the operation.
			else {
				if(token.equals("+")) {
					first = Integer.parseInt(operands.pop());
					second = Integer.parseInt(operands.pop());
					operands.push(String.valueOf(second + first));
				}
				else if(token.equals("-")) {
					first = Integer.parseInt(operands.pop());
					second = Integer.parseInt(operands.pop());
					operands.push(String.valueOf(second - first));
				}
				else if(token.equals("*")) {
					first = Integer.parseInt(operands.pop());
					second = Integer.parseInt(operands.pop());
					operands.push(String.valueOf(second * first));
				}
				else if(token.equals("/")) {
					first = Integer.parseInt(operands.pop());
					second = Integer.parseInt(operands.pop());
					operands.push(String.valueOf(second / first));
				}
			}
		}
		
		return operands.pop();
	}
	
	static final int MAX_WIDTH = 398, MAX_HEIGHT = 440;
	
	public static void main(String arg[]){
		JFrame frame = new CalculatorFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(MAX_WIDTH,MAX_HEIGHT);	
		frame.setBackground(Color.white);		
		frame.setResizable(false);				
		frame.setVisible(true);
	}
}