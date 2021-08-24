/************************************
 * Workshop #5
 * Course: JAC444 - Semester 4
 * Last Name: Truong
 * First Name: Hung
 * ID: 147779193
 * Section: NEE
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signature
 * Date: 3/7/2021
 */


package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Main extends Application {
	private static final String aBook = "addressbook.txt";
	
	final ObservableList<String> province = FXCollections.observableArrayList("Alberta", 
			"British Columbia", "New Brunswick", "Newfoundland and Labrador", "Nova Scotia", 
			"Ontario", "Prince Edward Island", "Quebec", "Saskatchewan", 
			"Northwest Territories", "Nunavut", "Yukon");
	int pos = 0;
	
	@Override
	public void start(Stage ps) throws Exception{
		File ab = new File(aBook);
		GridPane pn = new GridPane();
		pn.setAlignment(Pos.CENTER);
		pn.setHgap(6);
		pn.setVgap(10);
		
	    pn.add(new Text(20, 20, "First Name: "), 0, 0);
	    TextField tf_fn = new TextField();
	    pn.add(tf_fn, 1, 0, 5, 1);
	    
	    pn.add(new Text(20, 60, "Last Name: "), 0, 1);
	    TextField tf_ln = new TextField();
	    pn.add(tf_ln, 1, 1, 5, 1);
	    
	    pn.add(new Text(20, 120, "City: "), 0, 2);
	    TextField tf_ct = new TextField();
	    pn.add(tf_ct, 1, 2);
	    
	    pn.add(new Text(60, 120, "Province:"), 2, 2);
	    
	    ComboBox<String> tf_pv = new ComboBox<String>();
	    tf_pv.getItems().addAll(province);
	    
	    pn.add(tf_pv, 3, 2);
	    
	    pn.add(new Text(120, 120, "Postal Code:"), 4, 2);
	    TextField tf_pc = new TextField();
	    pn.add(tf_pc, 5, 2);
	    
	    Button add = new Button("Add");	    
	    add.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent e) {
	    		Boolean empty = tf_fn.getText().isEmpty() || tf_ln.getText().isEmpty() || 
	    				tf_ct.getText().isEmpty() || tf_pv.getSelectionModel().getSelectedItem().isEmpty()||
	    				tf_pc.getText().isEmpty() || tf_pc.getText().length() != 6;
	    		if(!empty) {
	    			try {
						addRecord(ab, tf_fn.getText(), tf_ln.getText(), tf_ct.getText(),
								tf_pv.getSelectionModel().getSelectedItem(), tf_pc.getText());
						System.out.println("Record Added!");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    		}
	    		else {
	    			if(tf_fn.getText().isEmpty()) {
	    				tf_fn.setText("Input First Name");
	    			}
	    			if(tf_ln.getText().isEmpty()) {
	    				tf_ln.setText("Input Last Name");
	    			}
	    			if(tf_ct.getText().isEmpty()) {
	    				tf_ct.setText("Input City Name");
	    			}
	    			if(tf_pc.getText().isEmpty() || (tf_pc.getText().length() != 6)) {
	    				tf_pc.setText("Input Valid Postal Code");
	    			}
	    			System.out.println("Fill in all blanks");
	    		}
	    	}
	    });
	    
	    Button first = new Button("First");
	    first.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent e) {
	    		pos = 0;
	    		try {
					String temp = getLine(ab, pos);
					String[] tempSplit = temp.split(",");
					String selPr = "";
					for(int i = 1; i < tempSplit[4].length(); i = i + 2) {
						selPr = selPr + tempSplit[4].charAt(i);
					}
					tf_fn.setText(tempSplit[1]);
					tf_ln.setText(tempSplit[2]);
					tf_ct.setText(tempSplit[3]);
					tf_pv.getSelectionModel().select(selPr);
					tf_pc.setText(tempSplit[5]);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
	    
	    Button next = new Button("Next");
	    next.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent e) {
	    		try {
					if(pos < getNumReco(ab) - 1) {
						pos++;
						try {
							Boolean empty = tf_fn.getText().isEmpty() || tf_ln.getText().isEmpty() || 
				    				tf_ct.getText().isEmpty() || tf_pv.getSelectionModel().getSelectedItem().isEmpty()||
				    				tf_pc.getText().isEmpty() || tf_pc.getText().length() != 6;
							if(!empty) {
								String temp = getLine(ab, pos);
								String[] tempSplit = temp.split(",");
								String selPr = "";
								for(int i = 1; i < tempSplit[4].length(); i = i + 2) {
									selPr = selPr + tempSplit[4].charAt(i);
								}
								
								tf_fn.setText(tempSplit[1]);
								tf_ln.setText(tempSplit[2]);
								tf_ct.setText(tempSplit[3]);
								tf_pv.getSelectionModel().select(selPr);
								tf_pc.setText(tempSplit[5]);
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else {
						System.out.println("At last record");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
	    
	    Button previous = new Button("Previous");
	    previous.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent e) {
	    		if(pos > 0) {
		    		pos--;
		    		try {
		    			Boolean empty = tf_fn.getText().isEmpty() || tf_ln.getText().isEmpty() || 
			    				tf_ct.getText().isEmpty() || tf_pv.getSelectionModel().getSelectedItem().isEmpty()||
			    				tf_pc.getText().isEmpty() || tf_pc.getText().length() != 6;
			    		if(!empty) {
			    			String temp = getLine(ab, pos);
							String[] tempSplit = temp.split(",");
							String selPr = "";
							for(int i = 1; i < tempSplit[4].length(); i = i + 2) {
								selPr = selPr + tempSplit[4].charAt(i);
							}
							
							tf_fn.setText(tempSplit[1]);
							tf_ln.setText(tempSplit[2]);
							tf_ct.setText(tempSplit[3]);
							tf_pv.getSelectionModel().select(selPr);
							tf_pc.setText(tempSplit[5]);
			    		}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    		}
	    		else {
	    			System.out.println("At first record");
	    		}
	    	}
	    });
	    
	    Button last = new Button("Last");
	    last.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent e) {
	    		try {
					String temp = getLastLine(ab);
					if(temp != null) {
						String[] tempSplit = temp.split(",");
						String selPr = "";
						for(int i = 1; i < tempSplit[4].length(); i = i + 2) {
							selPr = selPr + tempSplit[4].charAt(i);
						}
						tf_fn.setText(tempSplit[1]);
						tf_ln.setText(tempSplit[2]);
						tf_ct.setText(tempSplit[3]);
						tf_pv.getSelectionModel().select(selPr);
						tf_pc.setText(tempSplit[5]);
					}
					else {
						System.out.print("Empty String");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
	    		
	    	}
	    });
	    
	    Button update = new Button("Update");
	    update.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent e) {
	    		Boolean empty = tf_fn.getText().isEmpty() || tf_ln.getText().isEmpty() || 
	    				tf_ct.getText().isEmpty() || tf_pv.getSelectionModel().getSelectedItem().isEmpty()||
	    				tf_pc.getText().isEmpty() || tf_pc.getText().length() != 6;
	    		if(!empty) {
	    			try {
						updateRecord(ab, tf_fn.getText(), tf_ln.getText(), tf_ct.getText(),
								tf_pv.getSelectionModel().getSelectedItem(), tf_pc.getText(), pos);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    		}
	    		else {
	    			if(tf_fn.getText().isEmpty()) {
	    				tf_fn.setText("Input First Name");
	    			}
	    			if(tf_ln.getText().isEmpty()) {
	    				tf_ln.setText("Input Last Name");
	    			}
	    			if(tf_ct.getText().isEmpty()) {
	    				tf_ct.setText("Input City Name");
	    			}
	    			if(tf_pc.getText().isEmpty() || (tf_pc.getText().length() != 6)) {
	    				tf_pc.setText("Input Valid Postal Code");
	    			}
	    			System.out.println("Fill in all blanks");
	    		}
	    	}
	    });
	    
	    HBox hBox = new HBox (add, first, next, previous, last, update);
	    hBox.setSpacing(10);
	    hBox.setAlignment(Pos.CENTER);
	    
	    BorderPane borderPane = new BorderPane(pn);
	    borderPane.setBottom(hBox);
	    
	    Scene sc = new Scene(borderPane, 750, 150);
	    ps.setTitle("Address Book");
		ps.setScene(sc);
		
		ps.show();
		
	}
	
	public static void addRecord(File ab, String fn, String ln, String ct, String pv, String pc) 
			throws IOException {
		RandomAccessFile raf = new RandomAccessFile(ab, "rw");
		long eof = raf.length();
		int index = (int) (eof/300);
		raf.seek(eof);
		String temp = index + "," + fn + "," + ln + "," + ct + "," + pv + "," + pc + ",";
		for(int i = temp.length(); i < 147; i++) {
			temp = temp + "-";
		}
		temp = temp + "EL\n";
		raf.writeChars(temp);
		raf.close();
	}
	
	public static void updateRecord(File ab, String fn, String ln, String ct, String pv, String pc, int lineNum) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(ab, "rw");
		long lineIndex = lineNum * 300;
		raf.seek(lineIndex);
		String temp = lineNum + "," + fn + "," + ln + "," + ct + "," + pv + "," + pc + ",";
		for(int i = temp.length(); i < 147; i++) {
			temp = temp + "-";
		}
		temp = temp + "EL\n";
		raf.writeChars(temp);
		raf.close();
		System.out.println("Updated Line " + lineNum);
	}
	
	public static String getLine(File ab, int lineNum) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(ab, "r");
		String temp = null;
		if(lineNum*300 < raf.length()) {
			raf.seek(lineNum*300);
			temp = raf.readLine();
		}
		else {
			System.out.println("Unable to get Line");
		}
		raf.close();
		
		return temp;
	}
	
	public static String getLastLine(File ab) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(ab, "r");
		String temp = null;
		raf.seek(raf.length() - 300);
		temp = raf.readLine();
		System.out.println("Last Line");
		raf.close();
		return temp;
	}
	
	public static int getNumReco(File ab) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(ab, "r");
		int numReco = (int) (raf.length()/300);
		raf.close();
		return numReco;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
