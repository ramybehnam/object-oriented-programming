package p6;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Input extends JPanel implements ActionListener{
	private Controller controller;
	private JButton btnReadCol = new JButton("Read Column");
	private JButton btnWriteCol = new JButton("Write Column");
	private JButton btnReadRow = new JButton("Read Row");
	private JButton btnWriteRow = new JButton("Write Row");
	private JTextField txtCol = new JTextField("");
	private JTextField txtRow = new JTextField("");
	private JLabel lblCol = new JLabel("Column nbr:");
	private JLabel lblRow = new JLabel("Row nbr:");
	private JTextField[] colArray = new JTextField[7];
	private JTextField[] rowArray = new JTextField[7];
	private JPanel pnlCol = new JPanel();
	private JPanel pnlRow = new JPanel();
	private JPanel pnlFuse = new JPanel();
	private Border blackline = BorderFactory.createLineBorder(Color.BLACK, 2);

	public Input(/*Controller controller*/) {
		//this.controller = controller;
		setButton();
		setPanel();
	}
	private void setPanel() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(400,400));
		colPanel();
		rowPanel();
		pnlFuse.setLayout(new GridLayout(2,1));
//		pnlFuse.setPreferredSize(new Dimension(300,300));
//		pnlFuse.setMaximumSize(new Dimension(400,400));
		pnlFuse.add(pnlCol);
		pnlFuse.add(pnlRow);
		pnlFuse.setBorder(blackline);
		add(pnlFuse, BorderLayout.CENTER);
		add(sampleArr("row"), BorderLayout.SOUTH);
		add(sampleArr("col"), BorderLayout.EAST);
	}
	private void setButton() {
		btnWriteCol.addActionListener( this );
		btnWriteRow.addActionListener( this );
		btnReadRow.addActionListener( this );
		btnReadCol.addActionListener( this );
	}
	private JPanel sampleArr(String type) {
		JTextField[] array = null;
		JPanel display = new JPanel();
		display.setPreferredSize(new Dimension(100,100));
		if(type.equals("row")) {
			array = rowArray;
			display.setLayout(new GridLayout(1,7));
		}
		else if(type.equals("col")) {
			array = colArray;
			display.setLayout(new GridLayout(7,1));
		}
		for(int i=0;i<array.length;i++) {
			array[i] = new JTextField();
			array[i].setText("0");
			//	tf.setPreferredSize(new Dimension(20,20));
			display.add(array[i]);
		}
		return display;
	}
	private void colPanel() {
		JPanel pnl = new JPanel();
		pnl.setLayout(new GridLayout(1,2));
		pnl.add(lblCol);
		pnl.add(txtCol);

		pnlCol.setLayout(new GridLayout(3,1));
		pnlCol.add(pnl);
		pnlCol.add(btnReadCol);
		pnlCol.add(btnWriteCol);
	}
	private void rowPanel() {
		JPanel pnl = new JPanel();
		pnl.setLayout(new GridLayout(1,2));
		pnl.add(lblRow);
		pnl.add(txtRow);

		pnlRow.setLayout(new GridLayout(3,1));
		pnlRow.add(pnl);
		pnlRow.add(btnReadRow);
		pnlRow.add(btnWriteRow);
	}
	private boolean checkInput(int input) {
		return (input>0&&input<=7);
	}
	private void errorMessage(String msg) {
		JOptionPane.showMessageDialog(pnlFuse, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}
	private int[] toIntArray(JTextField[] tf) {
		int[] arr = new int[tf.length];
		for(int i=0;i<tf.length;i++) {
			arr[i]=Integer.parseInt(tf[i].getText());
		}
		return arr;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == btnWriteRow ) {
			try {
				int row = Integer.parseInt(txtRow.getText());
				if(checkInput(row)){
					System.out.println(row);
					Array7 arr7 = new Array7();
					arr7.setArray(toIntArray(rowArray));
					controller.writeRow(row, arr7);
				}
				else {
					errorMessage("The number is out of bounds of the 7x7-array.\nNumber: "+row);
				}
			}catch(NumberFormatException err) {
				errorMessage(err.toString());
			}
		}
		if( e.getSource() == btnWriteCol ) {
			try {
				int col = Integer.parseInt(txtCol.getText());
				if(checkInput(col)){
					System.out.println(col);
					Array7 arr7 = new Array7();
					arr7.setArray(toIntArray(colArray));
					controller.writeRow(col, arr7);
				}
				else {
					errorMessage("The number is out of bounds of the 7x7-array.\nNumber: "+col);
				}
			}catch(NumberFormatException err) {
				errorMessage(err.toString());
			}
		}
		if( e.getSource() == btnReadRow ) {
			try {
				int row = Integer.parseInt(txtRow.getText());
				if(checkInput(row)){
					System.out.println(row);
					controller.readRow(row);
				}
				else {
					errorMessage("The number is out of bounds of the 7x7-array.\nNumber: "+row);
				}
			}catch(NumberFormatException err) {
				errorMessage(err.toString());
			}

		}
		if( e.getSource() == btnReadCol ) {
			try {
				int col = Integer.parseInt(txtCol.getText());
				if(checkInput(col)){
					System.out.println(col);
					controller.readRow(col);
				}
				else {
					errorMessage("The number is out of bounds of the 7x7-array.\nNumber: "+col);
				}
			}catch(NumberFormatException err) {
				errorMessage(err.toString());
			}
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Input");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Input(/*new Controller()*/));
		frame.pack();
		frame.setVisible(true);
	}
}
