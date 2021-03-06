package client.view.abuseReport;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import client.view.abuseReport.CreateReportInterface;
import client.model.*;
import common.ArestPanel;
import common.DocumentSizeFilter;

public class ReporterGUI extends ArestPanel implements CreateReportInterface, ViewReportInterface {
	
	private boolean mandated = false;
	private boolean nonmandated = false;
	
	private JLabel reporterLbl;
	private JLabel firstNameLbl;
	private JLabel lastNameLbl;
	private JLabel addrLbl;
	private JLabel relationshipLbl;
	private JLabel phoneNumberLbl;
	
	private JTextArea addrTextArea;
	
	private JCheckBox mandatedCB;
	private JCheckBox notMandatedCB;
	
	private JFormattedTextField relationshipTextField;
	private JFormattedTextField firstNameTextField;
	private JFormattedTextField lastNameTextField;
	private JFormattedTextField phoneAreaCode;
	private DocumentSizeFilter filter;

	// Bumper on left.
	private Insets leftInsetBumper = new Insets(5, 10, 5, 5);
	
	// Bumper on top.
	private Insets topInsetBumper = new Insets(10, 10, 5, 5); 
	private JPanel AbuserPanel;
	private JLabel abuserAddressLabel;
	private JLabel abuserRelationshipToVictim;
	private JTextArea abuserAddress;
	private JFormattedTextField abuserRelationship;
	private JFormattedTextField abuserFirstName;
	private JLabel abuserLastNameLabel;
	private JFormattedTextField abuserLastName;
	private JTextPane abuserFirstNameNotSetWarning;
	private JTextPane abuserAddressNotSetWarning;
	private JTextPane abuserRelationshipNotSetWarning;
	private JTextPane abuserLastNameNotSetWarning;
	private JLabel socSecurityLabel;
	private JTextPane socSecurityNotSetWarning;
	private JFormattedTextField socAreaNumber;
	private JLabel abuserDobLabel;
	private JFormattedTextField abuserDobDay;
	private JTextPane abuserDobNotSetWarning;
	private JLabel abuserphoneNumberLabel;
	private JPanel reporterPhonePanel;
	private JFormattedTextField phoneLastFour;
	private JFormattedTextField phoneFirstThree;
	private JTextPane firstNameNotSetWarning;
	private JTextPane addrNotSetWarning;
	private JTextPane phoneNotSetWarning;
	private JTextPane lastNameNotSetWarning;
	private JTextPane mandatedNotSetWarning;
	private JTextPane relationshipNotSetWarning;
	private JPanel socSecurityPanel;
	private JFormattedTextField socSerialNum;
	private JFormattedTextField socGroupNum;
	private JTextPane socAreaHyphon;
	private JTextPane socSerialHyphon;
	private JTextPane phoneAreaHyphon;
	private JTextPane textPane_8;
	private JPanel abuserPhonePanel;
	private JFormattedTextField abuserPhoneAreaCode;
	private JTextPane abuserPhoneHyphon1;
	private JFormattedTextField abuserPhoneFirstThree;
	private JTextPane abuserPhoneHyphon2;
	private JFormattedTextField abuserPhoneLastFour;
	private JPanel abuserDobPanel;
	private JFormattedTextField abuserDobMon;
	private JFormattedTextField abuserDobYear;
	private JTextPane abuserDobHyphon1;
	private JTextPane abuserDobHyphon2;
	private JTextPane abuserPhoneNotSetWarning;
	private JPanel ReporterPanel;
	
	/**
	 * Create the panel.
	 */
	public ReporterGUI() {
		// Used for setupTextField
		filter = new DocumentSizeFilter(10);
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		ReporterPanel = new JPanel();
		ReporterPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagLayout gbl_ReporterPanel = new GridBagLayout();
		gbl_ReporterPanel.columnWidths = new int[] {0};
		gbl_ReporterPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_ReporterPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_ReporterPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		ReporterPanel.setLayout(gbl_ReporterPanel);
		
		reporterLbl = new JLabel("Reporter");
		GridBagConstraints gbc_reporterLbl = new GridBagConstraints();
		gbc_reporterLbl.gridwidth = 6;
		gbc_reporterLbl.anchor = GridBagConstraints.NORTHWEST;
		gbc_reporterLbl.insets = new Insets(10, 10, 5, 0);//new Insets(10, 10, 5, 5);
		gbc_reporterLbl.gridx = 0;
		gbc_reporterLbl.gridy = 0;
		ReporterPanel.add(reporterLbl, gbc_reporterLbl);
		reporterLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		firstNameLbl = new JLabel("Name:");
		GridBagConstraints gbc_firstNameLbl = new GridBagConstraints();
		gbc_firstNameLbl.anchor = GridBagConstraints.NORTHEAST;
		gbc_firstNameLbl.insets = leftInsetBumper;//new Insets(10, 0, 5, 5);
		gbc_firstNameLbl.gridx = 0;
		gbc_firstNameLbl.gridy = 1;
		ReporterPanel.add(firstNameLbl, gbc_firstNameLbl);
		
		firstNameNotSetWarning = new JTextPane();
		firstNameNotSetWarning.setVisible(false);
		firstNameNotSetWarning.setText("*");
		firstNameNotSetWarning.setForeground(Color.RED);
		firstNameNotSetWarning.setEditable(false);
		firstNameNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_firstNameNotSetWarning = new GridBagConstraints();
		gbc_firstNameNotSetWarning.anchor = GridBagConstraints.NORTHWEST;
		gbc_firstNameNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameNotSetWarning.gridx = 1;
		gbc_firstNameNotSetWarning.gridy = 1;
		ReporterPanel.add(firstNameNotSetWarning, gbc_firstNameNotSetWarning);
		
		firstNameTextField = new JFormattedTextField();
		GridBagConstraints gbc_firstNameTextField = new GridBagConstraints();
		gbc_firstNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstNameTextField.anchor = GridBagConstraints.NORTH;
		gbc_firstNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameTextField.gridx = 2;
		gbc_firstNameTextField.gridy = 1;
		ReporterPanel.add(firstNameTextField, gbc_firstNameTextField);
		filter.setupTextField(firstNameTextField, DocumentSizeFilter.CHAR, 16);
		
		lastNameLbl = new JLabel("Last Name:");
		GridBagConstraints gbc_lastNameLbl = new GridBagConstraints();
		gbc_lastNameLbl.anchor = GridBagConstraints.NORTHEAST;
		gbc_lastNameLbl.insets = new Insets(0, 5, 5, 5);
		gbc_lastNameLbl.gridx = 3;
		gbc_lastNameLbl.gridy = 1;
		ReporterPanel.add(lastNameLbl, gbc_lastNameLbl);
		
		lastNameNotSetWarning = new JTextPane();
		lastNameNotSetWarning.setVisible(false);
		lastNameNotSetWarning.setText("*");
		lastNameNotSetWarning.setForeground(Color.RED);
		lastNameNotSetWarning.setEditable(false);
		lastNameNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_lastNameNotSetWarning = new GridBagConstraints();
		gbc_lastNameNotSetWarning.anchor = GridBagConstraints.NORTHWEST;
		gbc_lastNameNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameNotSetWarning.gridx = 4;
		gbc_lastNameNotSetWarning.gridy = 1;
		ReporterPanel.add(lastNameNotSetWarning, gbc_lastNameNotSetWarning);
		
		lastNameTextField = new JFormattedTextField();
		GridBagConstraints gbc_lastNameTextField = new GridBagConstraints();
		gbc_lastNameTextField.anchor = GridBagConstraints.NORTH;
		gbc_lastNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastNameTextField.insets = new Insets(0, 0, 5, 10);
		gbc_lastNameTextField.gridx = 5;
		gbc_lastNameTextField.gridy = 1;
		ReporterPanel.add(lastNameTextField, gbc_lastNameTextField);
		filter.setupTextField(lastNameTextField, DocumentSizeFilter.CHAR, 16);
		
		addrLbl = new JLabel("Address:");
		GridBagConstraints gbc_addrLbl = new GridBagConstraints();
		gbc_addrLbl.anchor = GridBagConstraints.NORTHEAST;
		gbc_addrLbl.insets = leftInsetBumper;//new Insets(0, 0, 5, 5);
		gbc_addrLbl.gridx = 0;
		gbc_addrLbl.gridy = 2;
		ReporterPanel.add(addrLbl, gbc_addrLbl);
		
		addrNotSetWarning = new JTextPane();
		addrNotSetWarning.setVisible(false);
		addrNotSetWarning.setText("*");
		addrNotSetWarning.setForeground(Color.RED);
		addrNotSetWarning.setEditable(false);
		addrNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_addrNotSetWarning = new GridBagConstraints();
		gbc_addrNotSetWarning.anchor = GridBagConstraints.WEST;
		gbc_addrNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_addrNotSetWarning.fill = GridBagConstraints.VERTICAL;
		gbc_addrNotSetWarning.gridx = 1;
		gbc_addrNotSetWarning.gridy = 2;
		ReporterPanel.add(addrNotSetWarning, gbc_addrNotSetWarning);
		
		addrTextArea = new JTextArea();
		addrTextArea.setColumns(10);
		addrTextArea.setLineWrap(true);
		addrTextArea.setWrapStyleWord(true);
		filter.setupTextField(addrTextArea, DocumentSizeFilter.ANY, 50);
		
				
				JScrollPane addrTextScrollPane = new JScrollPane(addrTextArea);
				GridBagConstraints gbc_addrTextScrollPane = new GridBagConstraints();
				gbc_addrTextScrollPane.weighty = 0.1;
				gbc_addrTextScrollPane.fill = GridBagConstraints.BOTH;
				gbc_addrTextScrollPane.insets = new Insets(0, 0, 5, 5);
				gbc_addrTextScrollPane.gridx = 2;
				gbc_addrTextScrollPane.gridy = 2;
				ReporterPanel.add(addrTextScrollPane, gbc_addrTextScrollPane);
				addrTextScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				
				phoneNumberLbl = new JLabel("Daytime Telephone:");
				GridBagConstraints gbc_phoneNumberLbl = new GridBagConstraints();
				gbc_phoneNumberLbl.weighty = 0.1;
				gbc_phoneNumberLbl.anchor = GridBagConstraints.NORTHEAST;
				gbc_phoneNumberLbl.insets = new Insets(30, 10, 5, 5);//new Insets(0, 0, 5, 5);
				gbc_phoneNumberLbl.gridx = 0;
				gbc_phoneNumberLbl.gridy = 3;
				ReporterPanel.add(phoneNumberLbl, gbc_phoneNumberLbl);
				
				phoneNotSetWarning = new JTextPane();
				phoneNotSetWarning.setVisible(false);
				phoneNotSetWarning.setText("*");
				phoneNotSetWarning.setForeground(Color.RED);
				phoneNotSetWarning.setEditable(false);
				phoneNotSetWarning.setBackground(SystemColor.menu);
				GridBagConstraints gbc_phoneNotSetWarning = new GridBagConstraints();
				gbc_phoneNotSetWarning.anchor = GridBagConstraints.NORTHWEST;
				gbc_phoneNotSetWarning.insets = new Insets(30, 0, 5, 5);
				gbc_phoneNotSetWarning.gridx = 1;
				gbc_phoneNotSetWarning.gridy = 3;
				ReporterPanel.add(phoneNotSetWarning, gbc_phoneNotSetWarning);
				
				reporterPhonePanel = new JPanel();
				GridBagConstraints gbc_reporterPhonePanel = new GridBagConstraints();
				gbc_reporterPhonePanel.anchor = GridBagConstraints.NORTH;
				gbc_reporterPhonePanel.fill = GridBagConstraints.HORIZONTAL;
				gbc_reporterPhonePanel.insets = new Insets(30, 0, 5, 5);
				gbc_reporterPhonePanel.gridx = 2;
				gbc_reporterPhonePanel.gridy = 3;
				ReporterPanel.add(reporterPhonePanel, gbc_reporterPhonePanel);
				GridBagLayout gbl_reporterPhonePanel = new GridBagLayout();
				gbl_reporterPhonePanel.rowHeights = new int[]{20, 0};
				gbl_reporterPhonePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
				gbl_reporterPhonePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
				reporterPhonePanel.setLayout(gbl_reporterPhonePanel);
				
				phoneAreaCode = new JFormattedTextField();
				GridBagConstraints gbc_phoneAreaCode = new GridBagConstraints();
				gbc_phoneAreaCode.weighty = 1.0;
				gbc_phoneAreaCode.weightx = 0.2;
				gbc_phoneAreaCode.fill = GridBagConstraints.HORIZONTAL;
				gbc_phoneAreaCode.gridx = 0;
				gbc_phoneAreaCode.gridy = 0;
				reporterPhonePanel.add(phoneAreaCode, gbc_phoneAreaCode);
				filter.setupTextField(phoneAreaCode, DocumentSizeFilter.NO, 3);
				
				phoneAreaHyphon = new JTextPane();
				phoneAreaHyphon.setText("-");
				phoneAreaHyphon.setEditable(false);
				phoneAreaHyphon.setBackground(SystemColor.menu);
				GridBagConstraints gbc_phoneAreaHyphon = new GridBagConstraints();
				gbc_phoneAreaHyphon.fill = GridBagConstraints.BOTH;
				gbc_phoneAreaHyphon.gridx = 1;
				gbc_phoneAreaHyphon.gridy = 0;
				reporterPhonePanel.add(phoneAreaHyphon, gbc_phoneAreaHyphon);
				
				phoneFirstThree = new JFormattedTextField();
				GridBagConstraints gbc_phoneFirstThree = new GridBagConstraints();
				gbc_phoneFirstThree.weighty = 1.0;
				gbc_phoneFirstThree.weightx = 0.2;
				gbc_phoneFirstThree.fill = GridBagConstraints.HORIZONTAL;
				gbc_phoneFirstThree.gridx = 2;
				gbc_phoneFirstThree.gridy = 0;
				reporterPhonePanel.add(phoneFirstThree, gbc_phoneFirstThree);
				filter.setupTextField(phoneFirstThree, DocumentSizeFilter.NO, 3);
				
				textPane_8 = new JTextPane();
				textPane_8.setText("-");
				textPane_8.setEditable(false);
				textPane_8.setBackground(SystemColor.menu);
				GridBagConstraints gbc_textPane_8 = new GridBagConstraints();
				gbc_textPane_8.fill = GridBagConstraints.BOTH;
				gbc_textPane_8.gridx = 3;
				gbc_textPane_8.gridy = 0;
				reporterPhonePanel.add(textPane_8, gbc_textPane_8);
				
				phoneLastFour = new JFormattedTextField();
				GridBagConstraints gbc_phoneLastFour = new GridBagConstraints();
				gbc_phoneLastFour.weighty = 1.0;
				gbc_phoneLastFour.weightx = 0.3;
				gbc_phoneLastFour.fill = GridBagConstraints.HORIZONTAL;
				gbc_phoneLastFour.gridx = 4;
				gbc_phoneLastFour.gridy = 0;
				reporterPhonePanel.add(phoneLastFour, gbc_phoneLastFour);
				filter.setupTextField(phoneLastFour, DocumentSizeFilter.NO, 4);
				
				mandatedNotSetWarning = new JTextPane();
				mandatedNotSetWarning.setVisible(false);
				mandatedNotSetWarning.setText("*");
				mandatedNotSetWarning.setForeground(Color.RED);
				mandatedNotSetWarning.setEditable(false);
				mandatedNotSetWarning.setBackground(SystemColor.menu);
				GridBagConstraints gbc_mandatedNotSetWarning = new GridBagConstraints();
				gbc_mandatedNotSetWarning.anchor = GridBagConstraints.SOUTHWEST;
				gbc_mandatedNotSetWarning.insets = new Insets(30, 0, 5, 5);
				gbc_mandatedNotSetWarning.gridx = 4;
				gbc_mandatedNotSetWarning.gridy = 3;
				ReporterPanel.add(mandatedNotSetWarning, gbc_mandatedNotSetWarning);
				
				notMandatedCB = new JCheckBox("Not Mandated");
				GridBagConstraints gbc_notMandatedCB = new GridBagConstraints();
				gbc_notMandatedCB.anchor = GridBagConstraints.SOUTHWEST;
				gbc_notMandatedCB.insets = new Insets(30, 0, 5, 0);
				gbc_notMandatedCB.gridx = 5;
				gbc_notMandatedCB.gridy = 3;
				ReporterPanel.add(notMandatedCB, gbc_notMandatedCB);
				
				notMandatedCB.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent event) {
						if(event.getStateChange() == ItemEvent.SELECTED) {
							mandatedCB.setEnabled(false);
							nonmandated = true;
						} else {
							nonmandated = false;
							mandatedCB.setEnabled(true);
						}
					}
				});
				
				relationshipLbl = new JLabel("Relationship to Alleged Victim:");
				GridBagConstraints gbc_relationshipLbl = new GridBagConstraints();
				gbc_relationshipLbl.weighty = 0.1;
				gbc_relationshipLbl.anchor = GridBagConstraints.NORTHEAST;
				gbc_relationshipLbl.insets = new Insets(5, 10, 50, 5); //new Insets(0, 0, 0, 5);
				gbc_relationshipLbl.gridx = 0;
				gbc_relationshipLbl.gridy = 4;
				ReporterPanel.add(relationshipLbl, gbc_relationshipLbl);
				
				relationshipNotSetWarning = new JTextPane();
				relationshipNotSetWarning.setVisible(false);
				relationshipNotSetWarning.setText("*");
				relationshipNotSetWarning.setForeground(Color.RED);
				relationshipNotSetWarning.setEditable(false);
				relationshipNotSetWarning.setBackground(SystemColor.menu);
				GridBagConstraints gbc_relationshipNotSetWarning = new GridBagConstraints();
				gbc_relationshipNotSetWarning.anchor = GridBagConstraints.NORTHWEST;
				gbc_relationshipNotSetWarning.insets = new Insets(0, 0, 0, 5);
				gbc_relationshipNotSetWarning.gridx = 1;
				gbc_relationshipNotSetWarning.gridy = 4;
				ReporterPanel.add(relationshipNotSetWarning, gbc_relationshipNotSetWarning);
				
				relationshipTextField = new JFormattedTextField();
				GridBagConstraints gbc_relationshipTextField = new GridBagConstraints();
				gbc_relationshipTextField.anchor = GridBagConstraints.NORTH;
				gbc_relationshipTextField.weightx = 0.2;
				gbc_relationshipTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_relationshipTextField.insets = new Insets(0, 0, 0, 5);
				gbc_relationshipTextField.gridx = 2;
				gbc_relationshipTextField.gridy = 4;
				ReporterPanel.add(relationshipTextField, gbc_relationshipTextField);
				filter.setupTextField(relationshipTextField, DocumentSizeFilter.ANY, 20);
				GridBagConstraints gbc_ReporterPanel = new GridBagConstraints();
				gbc_ReporterPanel.weightx = 1.0;
				gbc_ReporterPanel.fill = GridBagConstraints.BOTH;
				gbc_ReporterPanel.insets = new Insets(10, 10, 5, 10);
				gbc_ReporterPanel.gridx = 0;
				gbc_ReporterPanel.gridy = 0;
				gbc_ReporterPanel.weighty = 0.5;
				add(ReporterPanel, gbc_ReporterPanel);
				
				mandatedCB = new JCheckBox("Mandated");
				GridBagConstraints gbc_mandatedCB = new GridBagConstraints();
				gbc_mandatedCB.weightx = 0.5;
				gbc_mandatedCB.anchor = GridBagConstraints.NORTHWEST;
				gbc_mandatedCB.gridx = 5;
				gbc_mandatedCB.gridy = 4;
				ReporterPanel.add(mandatedCB, gbc_mandatedCB);
				
				mandatedCB.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent event) {
						if(event.getStateChange() == ItemEvent.SELECTED) {
							notMandatedCB.setEnabled(false);
							mandated = true;
						} else {
							mandated = false;
							notMandatedCB.setEnabled(true);
						}
					}
				});
		
		AbuserPanel = new JPanel();
		AbuserPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagLayout gbl_AbuserPanel = new GridBagLayout();
		gbl_AbuserPanel.columnWidths = new int[] {0};
		gbl_AbuserPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_AbuserPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		AbuserPanel.setLayout(gbl_AbuserPanel);
		
		JLabel allegedAbuserLabel = new JLabel("Alleged Abuser:    (Alleged Victim's Caretaker)");
		allegedAbuserLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_allegedAbuserLabel = new GridBagConstraints();
		gbc_allegedAbuserLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_allegedAbuserLabel.gridwidth = 6;
		gbc_allegedAbuserLabel.insets = new Insets(10, 10, 15, 0); //new Insets(0, 0, 5, 5);
		gbc_allegedAbuserLabel.gridx = 0;
		gbc_allegedAbuserLabel.gridy = 0;
		AbuserPanel.add(allegedAbuserLabel, gbc_allegedAbuserLabel);
		
		JLabel abuserFirstNameLabel = new JLabel("Name:");
		GridBagConstraints gbc_abuserFirstNameLabel = new GridBagConstraints();
		gbc_abuserFirstNameLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_abuserFirstNameLabel.insets = leftInsetBumper;//new Insets(5, 0, 5, 5); //new Insets(0, 0, 0, 5);
		gbc_abuserFirstNameLabel.gridx = 0;
		gbc_abuserFirstNameLabel.gridy = 1;
		AbuserPanel.add(abuserFirstNameLabel, gbc_abuserFirstNameLabel);
		
		abuserFirstNameNotSetWarning = new JTextPane();
		abuserFirstNameNotSetWarning.setVisible(false);
		abuserFirstNameNotSetWarning.setForeground(Color.RED);
		abuserFirstNameNotSetWarning.setEditable(false);
		abuserFirstNameNotSetWarning.setBackground(SystemColor.menu);
		abuserFirstNameNotSetWarning.setText("*");
		GridBagConstraints gbc_abuserFirstNameNotSetWarning = new GridBagConstraints();
		gbc_abuserFirstNameNotSetWarning.anchor = GridBagConstraints.NORTHWEST;
		gbc_abuserFirstNameNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_abuserFirstNameNotSetWarning.gridx = 1;
		gbc_abuserFirstNameNotSetWarning.gridy = 1;
		AbuserPanel.add(abuserFirstNameNotSetWarning, gbc_abuserFirstNameNotSetWarning);
		
		abuserFirstName = new JFormattedTextField();
		abuserFirstNameLabel.setLabelFor(abuserFirstName);
		GridBagConstraints gbc_abuserFirstName = new GridBagConstraints();
		gbc_abuserFirstName.weightx = 0.3;
		gbc_abuserFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_abuserFirstName.anchor = GridBagConstraints.NORTH;
		gbc_abuserFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_abuserFirstName.gridx = 2;
		gbc_abuserFirstName.gridy = 1;
		AbuserPanel.add(abuserFirstName, gbc_abuserFirstName);
		filter.setupTextField(abuserFirstName, DocumentSizeFilter.CHAR, 16);
		
		abuserLastNameLabel = new JLabel("Last Name:");
		GridBagConstraints gbc_abuserLastNameLabel = new GridBagConstraints();
		gbc_abuserLastNameLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_abuserLastNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_abuserLastNameLabel.gridx = 3;
		gbc_abuserLastNameLabel.gridy = 1;
		AbuserPanel.add(abuserLastNameLabel, gbc_abuserLastNameLabel);
		abuserLastNameLabel.setLabelFor(abuserLastName);
		
		abuserLastNameNotSetWarning = new JTextPane();
		abuserLastNameNotSetWarning.setVisible(false);
		abuserLastNameNotSetWarning.setText("*");
		abuserLastNameNotSetWarning.setForeground(Color.RED);
		abuserLastNameNotSetWarning.setEditable(false);
		abuserLastNameNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_abuserLastNameNotSetWarning = new GridBagConstraints();
		gbc_abuserLastNameNotSetWarning.anchor = GridBagConstraints.NORTHWEST;
		gbc_abuserLastNameNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_abuserLastNameNotSetWarning.gridx = 4;
		gbc_abuserLastNameNotSetWarning.gridy = 1;
		AbuserPanel.add(abuserLastNameNotSetWarning, gbc_abuserLastNameNotSetWarning);
		
		abuserLastName = new JFormattedTextField();
		GridBagConstraints gbc_abuserLastName = new GridBagConstraints();
		gbc_abuserLastName.anchor = GridBagConstraints.NORTH;
		gbc_abuserLastName.weightx = 0.4;
		gbc_abuserLastName.insets = new Insets(0, 0, 5, 10);
		gbc_abuserLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_abuserLastName.gridx = 5;
		gbc_abuserLastName.gridy = 1;
		AbuserPanel.add(abuserLastName, gbc_abuserLastName);
		filter.setupTextField(abuserLastName, DocumentSizeFilter.CHAR, 16);
		
		abuserAddressLabel = new JLabel("Address:");
		GridBagConstraints gbc_abuserAddressLabel = new GridBagConstraints();
		gbc_abuserAddressLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_abuserAddressLabel.insets = leftInsetBumper; //new Insets(0, 0, 0, 5);
		gbc_abuserAddressLabel.gridx = 0;
		gbc_abuserAddressLabel.gridy = 2;
		AbuserPanel.add(abuserAddressLabel, gbc_abuserAddressLabel);
		
		abuserAddressNotSetWarning = new JTextPane();
		abuserAddressNotSetWarning.setVisible(false);
		abuserAddressNotSetWarning.setText("*");
		abuserAddressNotSetWarning.setForeground(Color.RED);
		abuserAddressNotSetWarning.setEditable(false);
		abuserAddressNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_abuserAddressNotSetWarning = new GridBagConstraints();
		gbc_abuserAddressNotSetWarning.anchor = GridBagConstraints.NORTHWEST;
		gbc_abuserAddressNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_abuserAddressNotSetWarning.gridx = 1;
		gbc_abuserAddressNotSetWarning.gridy = 2;
		AbuserPanel.add(abuserAddressNotSetWarning, gbc_abuserAddressNotSetWarning);
		
		
		abuserAddress = new JTextArea();
		abuserAddress.setWrapStyleWord(true);
		abuserAddress.setLineWrap(true);
		abuserAddress.setColumns(10);		
		filter.setupTextField(abuserAddress, DocumentSizeFilter.ANY, 100);
		JScrollPane abuserAddressScrollPane = new JScrollPane(abuserAddress);
		abuserAddressLabel.setLabelFor(abuserAddressScrollPane);
		abuserAddressScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		GridBagConstraints gbc_abuserAddressScrollPane = new GridBagConstraints();
		gbc_abuserAddressScrollPane.weighty = 0.1;
		gbc_abuserAddressScrollPane.weightx = 0.1;
		gbc_abuserAddressScrollPane.fill = GridBagConstraints.BOTH;
		gbc_abuserAddressScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_abuserAddressScrollPane.gridx = 2;
		gbc_abuserAddressScrollPane.gridy = 2;
		AbuserPanel.add(abuserAddressScrollPane, gbc_abuserAddressScrollPane);
		
		abuserRelationshipToVictim = new JLabel("Relationship to Alleged Victim:");
		GridBagConstraints gbc_abuserRelationshipToVictim = new GridBagConstraints();
		gbc_abuserRelationshipToVictim.weighty = 0.1;
		gbc_abuserRelationshipToVictim.anchor = GridBagConstraints.EAST;
		gbc_abuserRelationshipToVictim.insets = new Insets(0, 0, 0, 5);
		gbc_abuserRelationshipToVictim.gridx = 0;
		gbc_abuserRelationshipToVictim.gridy = 3;
		gbc_abuserRelationshipToVictim.insets = leftInsetBumper;
		AbuserPanel.add(abuserRelationshipToVictim, gbc_abuserRelationshipToVictim);
		
		GridBagConstraints gbc_AbuserPanel = new GridBagConstraints();
		gbc_AbuserPanel.weighty = 0.5;
		gbc_AbuserPanel.fill = GridBagConstraints.BOTH;
		gbc_AbuserPanel.gridx = 0;
		gbc_AbuserPanel.gridy = 1;
		gbc_AbuserPanel.insets = new Insets(0, 10, 10, 10);
		gbc_AbuserPanel.weightx = 1.0;
		add(AbuserPanel, gbc_AbuserPanel);
		
		abuserRelationshipNotSetWarning = new JTextPane();
		abuserRelationshipNotSetWarning.setVisible(false);
		abuserRelationshipNotSetWarning.setText("*");
		abuserRelationshipNotSetWarning.setForeground(Color.RED);
		abuserRelationshipNotSetWarning.setEditable(false);
		abuserRelationshipNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_abuserRelationshipNotSetWarning = new GridBagConstraints();
		gbc_abuserRelationshipNotSetWarning.anchor = GridBagConstraints.WEST;
		gbc_abuserRelationshipNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_abuserRelationshipNotSetWarning.gridx = 1;
		gbc_abuserRelationshipNotSetWarning.gridy = 3;
		AbuserPanel.add(abuserRelationshipNotSetWarning, gbc_abuserRelationshipNotSetWarning);
		
		abuserRelationship = new JFormattedTextField();
		GridBagConstraints gbc_abuserRelationship = new GridBagConstraints();
		gbc_abuserRelationship.fill = GridBagConstraints.HORIZONTAL;
		gbc_abuserRelationship.weightx = 0.4;
		gbc_abuserRelationship.insets = new Insets(0, 0, 5, 5);
		gbc_abuserRelationship.gridx = 2;
		gbc_abuserRelationship.gridy = 3;
		AbuserPanel.add(abuserRelationship, gbc_abuserRelationship);
		filter.setupTextField(abuserRelationship, DocumentSizeFilter.CHAR, 20);
		
		socSecurityLabel = new JLabel("Social Security #");
		GridBagConstraints gbc_socSecurityLabel = new GridBagConstraints();
		gbc_socSecurityLabel.weighty = 0.1;
		gbc_socSecurityLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_socSecurityLabel.insets = leftInsetBumper;//new Insets(0, 0, 5, 5);
		gbc_socSecurityLabel.gridx = 0;
		gbc_socSecurityLabel.gridy = 4;
		AbuserPanel.add(socSecurityLabel, gbc_socSecurityLabel);
		
		socSecurityNotSetWarning = new JTextPane();
		socSecurityNotSetWarning.setVisible(false);
		socSecurityNotSetWarning.setText("*");
		socSecurityNotSetWarning.setForeground(Color.RED);
		socSecurityNotSetWarning.setEditable(false);
		socSecurityNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_socSecurityNotSetWarning = new GridBagConstraints();
		gbc_socSecurityNotSetWarning.anchor = GridBagConstraints.WEST;
		gbc_socSecurityNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_socSecurityNotSetWarning.fill = GridBagConstraints.VERTICAL;
		gbc_socSecurityNotSetWarning.gridx = 1;
		gbc_socSecurityNotSetWarning.gridy = 4;
		AbuserPanel.add(socSecurityNotSetWarning, gbc_socSecurityNotSetWarning);
		
		socSecurityPanel = new JPanel();
		GridBagConstraints gbc_socSecurityPanel = new GridBagConstraints();
		gbc_socSecurityPanel.fill = GridBagConstraints.BOTH;
		gbc_socSecurityPanel.insets = new Insets(0, 0, 5, 5);
		gbc_socSecurityPanel.gridx = 2;
		gbc_socSecurityPanel.gridy = 4;
		AbuserPanel.add(socSecurityPanel, gbc_socSecurityPanel);
		GridBagLayout gbl_socSecurityPanel = new GridBagLayout();
		gbl_socSecurityPanel.columnWidths = new int[]{6, 0, 0, 0, 0, 0};
		gbl_socSecurityPanel.rowHeights = new int[]{20, 0};
		gbl_socSecurityPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_socSecurityPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		socSecurityPanel.setLayout(gbl_socSecurityPanel);
		
		socAreaNumber = new JFormattedTextField();
		GridBagConstraints gbc_socAreaNumber = new GridBagConstraints();
		gbc_socAreaNumber.anchor = GridBagConstraints.NORTH;
		gbc_socAreaNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_socAreaNumber.weightx = 0.3;
		gbc_socAreaNumber.gridx = 0;
		gbc_socAreaNumber.gridy = 0;
		socSecurityPanel.add(socAreaNumber, gbc_socAreaNumber);
		filter.setupTextField(socAreaNumber, DocumentSizeFilter.NO, 3);
		
		socAreaHyphon = new JTextPane();
		socAreaHyphon.setEditable(false);
		socAreaHyphon.setBackground(SystemColor.menu);
		socAreaHyphon.setText("-");
		GridBagConstraints gbc_socAreaHyphon = new GridBagConstraints();
		gbc_socAreaHyphon.weightx = 0.1;
		gbc_socAreaHyphon.fill = GridBagConstraints.VERTICAL;
		gbc_socAreaHyphon.gridx = 1;
		gbc_socAreaHyphon.gridy = 0;
		socSecurityPanel.add(socAreaHyphon, gbc_socAreaHyphon);
		
		socGroupNum = new JFormattedTextField();
		GridBagConstraints gbc_socGroupNum = new GridBagConstraints();
		gbc_socGroupNum.anchor = GridBagConstraints.NORTH;
		gbc_socGroupNum.weighty = 1.0;
		gbc_socGroupNum.weightx = 0.2;
		gbc_socGroupNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_socGroupNum.gridx = 2;
		gbc_socGroupNum.gridy = 0;
		socSecurityPanel.add(socGroupNum, gbc_socGroupNum);
		filter.setupTextField(socGroupNum, DocumentSizeFilter.NO, 2);
		
		socSerialHyphon = new JTextPane();
		socSerialHyphon.setEditable(false);
		socSerialHyphon.setBackground(SystemColor.menu);
		socSerialHyphon.setText("-");
		GridBagConstraints gbc_socSerialHyphon = new GridBagConstraints();
		gbc_socSerialHyphon.weightx = 0.1;
		gbc_socSerialHyphon.fill = GridBagConstraints.VERTICAL;
		gbc_socSerialHyphon.gridx = 3;
		gbc_socSerialHyphon.gridy = 0;
		socSecurityPanel.add(socSerialHyphon, gbc_socSerialHyphon);
		
		socSerialNum = new JFormattedTextField();
		GridBagConstraints gbc_socSerialNum = new GridBagConstraints();
		gbc_socSerialNum.anchor = GridBagConstraints.NORTH;
		gbc_socSerialNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_socSerialNum.weighty = 1.0;
		gbc_socSerialNum.weightx = 0.4;
		gbc_socSerialNum.gridx = 4;
		gbc_socSerialNum.gridy = 0;
		socSecurityPanel.add(socSerialNum, gbc_socSerialNum);
		filter.setupTextField(socSerialNum, DocumentSizeFilter.NO, 4);
		
		abuserphoneNumberLabel = new JLabel("Telephone:");
		GridBagConstraints gbc_abuserphoneNumberLabel = new GridBagConstraints();
		gbc_abuserphoneNumberLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_abuserphoneNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_abuserphoneNumberLabel.gridx = 3;
		gbc_abuserphoneNumberLabel.gridy = 4;
		AbuserPanel.add(abuserphoneNumberLabel, gbc_abuserphoneNumberLabel);
		
		abuserPhoneNotSetWarning = new JTextPane();
		abuserPhoneNotSetWarning.setVisible(false);
		abuserPhoneNotSetWarning.setEditable(false);
		abuserPhoneNotSetWarning.setBackground(SystemColor.menu);
		abuserPhoneNotSetWarning.setForeground(Color.RED);
		abuserPhoneNotSetWarning.setText("*");
		GridBagConstraints gbc_abuserPhoneNotSetWarning = new GridBagConstraints();
		gbc_abuserPhoneNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_abuserPhoneNotSetWarning.fill = GridBagConstraints.BOTH;
		gbc_abuserPhoneNotSetWarning.gridx = 4;
		gbc_abuserPhoneNotSetWarning.gridy = 4;
		AbuserPanel.add(abuserPhoneNotSetWarning, gbc_abuserPhoneNotSetWarning);
		
		abuserPhonePanel = new JPanel();
		GridBagConstraints gbc_abuserPhonePanel = new GridBagConstraints();
		gbc_abuserPhonePanel.insets = new Insets(0, 0, 5, 10);
		gbc_abuserPhonePanel.fill = GridBagConstraints.BOTH;
		gbc_abuserPhonePanel.gridx = 5;
		gbc_abuserPhonePanel.gridy = 4;
		AbuserPanel.add(abuserPhonePanel, gbc_abuserPhonePanel);
		GridBagLayout gbl_abuserPhonePanel = new GridBagLayout();
		gbl_abuserPhonePanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_abuserPhonePanel.rowHeights = new int[]{20, 0};
		gbl_abuserPhonePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_abuserPhonePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		abuserPhonePanel.setLayout(gbl_abuserPhonePanel);
		
		abuserPhoneAreaCode = new JFormattedTextField();
		GridBagConstraints gbc_abuserPhoneAreaCode = new GridBagConstraints();
		gbc_abuserPhoneAreaCode.anchor = GridBagConstraints.NORTH;
		gbc_abuserPhoneAreaCode.weighty = 1.0;
		gbc_abuserPhoneAreaCode.weightx = 0.2;
		gbc_abuserPhoneAreaCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_abuserPhoneAreaCode.gridx = 0;
		gbc_abuserPhoneAreaCode.gridy = 0;
		abuserPhonePanel.add(abuserPhoneAreaCode, gbc_abuserPhoneAreaCode);
		filter.setupTextField(abuserPhoneAreaCode, DocumentSizeFilter.NO, 3);
		
		abuserPhoneHyphon1 = new JTextPane();
		abuserPhoneHyphon1.setText("-");
		abuserPhoneHyphon1.setEditable(false);
		abuserPhoneHyphon1.setBackground(SystemColor.menu);
		GridBagConstraints gbc_abuserPhoneHyphon1 = new GridBagConstraints();
		gbc_abuserPhoneHyphon1.fill = GridBagConstraints.BOTH;
		gbc_abuserPhoneHyphon1.gridx = 1;
		gbc_abuserPhoneHyphon1.gridy = 0;
		abuserPhonePanel.add(abuserPhoneHyphon1, gbc_abuserPhoneHyphon1);
		
		abuserPhoneFirstThree = new JFormattedTextField();
		GridBagConstraints gbc_abuserPhoneFirstThree = new GridBagConstraints();
		gbc_abuserPhoneFirstThree.anchor = GridBagConstraints.NORTH;
		gbc_abuserPhoneFirstThree.weighty = 1.0;
		gbc_abuserPhoneFirstThree.weightx = 0.2;
		gbc_abuserPhoneFirstThree.fill = GridBagConstraints.HORIZONTAL;
		gbc_abuserPhoneFirstThree.gridx = 2;
		gbc_abuserPhoneFirstThree.gridy = 0;
		abuserPhonePanel.add(abuserPhoneFirstThree, gbc_abuserPhoneFirstThree);
		filter.setupTextField(abuserPhoneFirstThree, DocumentSizeFilter.NO, 3);
		
		abuserPhoneHyphon2 = new JTextPane();
		abuserPhoneHyphon2.setText("-");
		abuserPhoneHyphon2.setEditable(false);
		abuserPhoneHyphon2.setBackground(SystemColor.menu);
		GridBagConstraints gbc_abuserPhoneHyphon2 = new GridBagConstraints();
		gbc_abuserPhoneHyphon2.fill = GridBagConstraints.BOTH;
		gbc_abuserPhoneHyphon2.gridx = 3;
		gbc_abuserPhoneHyphon2.gridy = 0;
		abuserPhonePanel.add(abuserPhoneHyphon2, gbc_abuserPhoneHyphon2);
		
		abuserPhoneLastFour = new JFormattedTextField();
		GridBagConstraints gbc_abuserPhoneLastFour = new GridBagConstraints();
		gbc_abuserPhoneLastFour.anchor = GridBagConstraints.NORTH;
		gbc_abuserPhoneLastFour.weighty = 1.0;
		gbc_abuserPhoneLastFour.weightx = 0.3;
		gbc_abuserPhoneLastFour.fill = GridBagConstraints.HORIZONTAL;
		gbc_abuserPhoneLastFour.gridx = 4;
		gbc_abuserPhoneLastFour.gridy = 0;
		abuserPhonePanel.add(abuserPhoneLastFour, gbc_abuserPhoneLastFour);
		filter.setupTextField(abuserPhoneLastFour, DocumentSizeFilter.NO, 4);
		
		abuserDobLabel = new JLabel("DOB:");
		GridBagConstraints gbc_abuserDobLabel = new GridBagConstraints();
		gbc_abuserDobLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_abuserDobLabel.insets = new Insets(5, 10, 50, 5);//new Insets(0, 0, 5, 5);
		gbc_abuserDobLabel.gridx = 0;
		gbc_abuserDobLabel.gridy = 5;
		AbuserPanel.add(abuserDobLabel, gbc_abuserDobLabel);
		
		abuserDobNotSetWarning = new JTextPane();
		abuserDobNotSetWarning.setVisible(false);
		abuserDobNotSetWarning.setText("*");
		abuserDobNotSetWarning.setForeground(Color.RED);
		abuserDobNotSetWarning.setEditable(false);
		abuserDobNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_abuserDobNotSetWarning = new GridBagConstraints();
		gbc_abuserDobNotSetWarning.anchor = GridBagConstraints.NORTHWEST;
		gbc_abuserDobNotSetWarning.insets = new Insets(0, 0, 0, 5);
		gbc_abuserDobNotSetWarning.gridx = 1;
		gbc_abuserDobNotSetWarning.gridy = 5;
		AbuserPanel.add(abuserDobNotSetWarning, gbc_abuserDobNotSetWarning);
		
		abuserDobPanel = new JPanel();
		GridBagConstraints gbc_abuserDobPanel = new GridBagConstraints();
		gbc_abuserDobPanel.fill = GridBagConstraints.BOTH;
		gbc_abuserDobPanel.insets = new Insets(0, 0, 0, 5);
		gbc_abuserDobPanel.gridx = 2;
		gbc_abuserDobPanel.gridy = 5;
		AbuserPanel.add(abuserDobPanel, gbc_abuserDobPanel);
		GridBagLayout gbl_abuserDobPanel = new GridBagLayout();
		gbl_abuserDobPanel.columnWidths = new int[]{6, 0, 0, 0, 0, 0};
		gbl_abuserDobPanel.rowHeights = new int[]{20, 0};
		gbl_abuserDobPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_abuserDobPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		abuserDobPanel.setLayout(gbl_abuserDobPanel);
		
		abuserDobDay = new JFormattedTextField();
		abuserDobDay.setText("DD");
		GridBagConstraints gbc_abuserDobDay = new GridBagConstraints();
		gbc_abuserDobDay.weightx = 0.3;
		gbc_abuserDobDay.anchor = GridBagConstraints.NORTH;
		gbc_abuserDobDay.fill = GridBagConstraints.HORIZONTAL;
		gbc_abuserDobDay.gridx = 0;
		gbc_abuserDobDay.gridy = 0;
		abuserDobPanel.add(abuserDobDay, gbc_abuserDobDay);
		filter.setupTextField(abuserDobDay, DocumentSizeFilter.NO, 2);
		
		abuserDobHyphon1 = new JTextPane();
		abuserDobHyphon1.setText("/");
		abuserDobHyphon1.setEditable(false);
		abuserDobHyphon1.setBackground(SystemColor.menu);
		GridBagConstraints gbc_abuserDobHyphon1 = new GridBagConstraints();
		gbc_abuserDobHyphon1.anchor = GridBagConstraints.NORTH;
		gbc_abuserDobHyphon1.fill = GridBagConstraints.HORIZONTAL;
		gbc_abuserDobHyphon1.gridx = 1;
		gbc_abuserDobHyphon1.gridy = 0;
		abuserDobPanel.add(abuserDobHyphon1, gbc_abuserDobHyphon1);
		
		abuserDobMon = new JFormattedTextField();
		abuserDobMon.setText("MM");
		GridBagConstraints gbc_abuserDobMon = new GridBagConstraints();
		gbc_abuserDobMon.anchor = GridBagConstraints.NORTH;
		gbc_abuserDobMon.weightx = 0.3;
		gbc_abuserDobMon.fill = GridBagConstraints.HORIZONTAL;
		gbc_abuserDobMon.gridx = 2;
		gbc_abuserDobMon.gridy = 0;
		abuserDobPanel.add(abuserDobMon, gbc_abuserDobMon);
		filter.setupTextField(abuserDobMon, DocumentSizeFilter.NO, 2);
		
		abuserDobHyphon2 = new JTextPane();
		abuserDobHyphon2.setText("/");
		abuserDobHyphon2.setEditable(false);
		abuserDobHyphon2.setBackground(SystemColor.menu);
		GridBagConstraints gbc_abuserDobHyphon2 = new GridBagConstraints();
		gbc_abuserDobHyphon2.anchor = GridBagConstraints.NORTH;
		gbc_abuserDobHyphon2.fill = GridBagConstraints.HORIZONTAL;
		gbc_abuserDobHyphon2.gridx = 3;
		gbc_abuserDobHyphon2.gridy = 0;
		abuserDobPanel.add(abuserDobHyphon2, gbc_abuserDobHyphon2);
		
		abuserDobYear = new JFormattedTextField();
		abuserDobYear.setText("YYYY");
		GridBagConstraints gbc_abuserDobYear = new GridBagConstraints();
		gbc_abuserDobYear.anchor = GridBagConstraints.NORTH;
		gbc_abuserDobYear.weightx = 0.5;
		gbc_abuserDobYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_abuserDobYear.gridx = 4;
		gbc_abuserDobYear.gridy = 0;
		abuserDobPanel.add(abuserDobYear, gbc_abuserDobYear);
		filter.setupTextField(abuserDobYear, DocumentSizeFilter.NO, 4);

	}

	/*public void setPanelEnabled(boolean panelEnabled) {
		ReporterPanel.setEnabled(panelEnabled);
		AbuserPanel.setEnabled(panelEnabled);
	}*/
	
	/**
	 * Checks that all information has been entered for a Reporter.
	 */
	@Override
	public boolean isValidInfo() {
		boolean validInfo = true;
		
		validInfo = isReporterPanelValid() & isAbuserPanelValid();
				
		return validInfo;
	}

	/**
	 * Performs necessary checks to see if the abuser information is valid in this view.
	 * @return true if valid, false otherwise.
	 */
	public boolean isAbuserPanelValid() {
		boolean validInfo = true;
		
		// Check first name contents
		if(!isTextComponentValid(abuserFirstName)) {
			abuserFirstNameNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			abuserFirstNameNotSetWarning.setVisible(false);
		}
		
		// Check lastname contents
		if(!isTextComponentValid(lastNameTextField)) {
			abuserLastNameNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			abuserLastNameNotSetWarning.setVisible(false);
		}
		
		// Check address contents
		if(!isTextComponentValid(abuserAddress)) {
			abuserAddressNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			abuserAddressNotSetWarning.setVisible(false);
		}
		
		// Check relationship contents
		if(!isTextComponentValid(abuserRelationship)) {
			abuserRelationshipNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			abuserRelationshipNotSetWarning.setVisible(false);
		}
		
		// Check social security number contents
		if(!isTextComponentValid(socAreaNumber, 3) || !isTextComponentValid(socGroupNum, 2) || !isTextComponentValid(socSerialNum, 4)) {
			socSecurityNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			socSecurityNotSetWarning.setVisible(false);
		}

		if(!isTextComponentValid(abuserDobDay, 2) || !isTextComponentValid(abuserDobMon, 2) || !isTextComponentValid(abuserDobYear, 4)) {
			abuserDobNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			abuserDobNotSetWarning.setVisible(false);
		}
		
		if(!isTextComponentValid(abuserPhoneAreaCode, 3) || !isTextComponentValid(abuserPhoneFirstThree, 3) || !isTextComponentValid(abuserPhoneLastFour, 4)) {
			abuserPhoneNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			abuserPhoneNotSetWarning.setVisible(false);
		}
		
		return validInfo;
	}
	
	/**
	 * Check the reporter panel for any issues in the entries from the user.
	 * @return
	 */
	public boolean isReporterPanelValid() {
		boolean validInfo = true;
		if(firstNameTextField.getText().equals("")){
			firstNameNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			firstNameNotSetWarning.setVisible(false);
		}
		if(lastNameTextField.getText().equals("")){
			lastNameNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			lastNameNotSetWarning.setVisible(false);
		}
		if(addrTextArea.getText().equals("")){
			addrNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			addrNotSetWarning.setVisible(false);
		}
		if(!mandatedCB.isSelected() && !notMandatedCB.isSelected()) {
			mandatedNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			mandatedNotSetWarning.setVisible(false);
		}
		if((phoneFirstThree.getText().length() != 3) || (phoneAreaCode.getText().length() != 3) || (phoneLastFour.getText().length() != 4)) {
			phoneNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			phoneNotSetWarning.setVisible(false);
		}
		if(relationshipTextField.getText().equals("")){
			relationshipNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			relationshipNotSetWarning.setVisible(false);
		}

		
		return validInfo;
	}

	@Override
	public Report updateReport(Report report) {
		Abuser abuser = report.getAbuser();
		Reporter reporter = report.getReporter();
		
		reporter.setFirstName(firstNameTextField.getText());
		reporter.setLastName(lastNameTextField.getText());
		reporter.setAddress(addrTextArea.getText());
		reporter.setMandated(mandatedCB.isSelected());
		reporter.setPhoneNumber(phoneAreaCode.getText().concat(phoneFirstThree.getText().concat(phoneLastFour.getText())));
		reporter.setRelationshipToVictim(relationshipTextField.getText());
		
		abuser.setFirstName(abuserFirstName.getText());
		abuser.setLastName(abuserLastName.getText());
		abuser.setAddress(abuserAddress.getText());
		abuser.setRelationshipToVictim(abuserRelationship.getText());
		abuser.setSocial(socAreaNumber.getText().concat(socGroupNum.getText().concat(socSerialNum.getText())));
		abuser.setPhoneNumber(abuserPhoneAreaCode.getText().concat(abuserPhoneFirstThree.getText().concat(abuserPhoneLastFour.getText())));
		abuser.setDob(abuserDobDay.getText().concat(abuserDobMon.getText().concat(abuserDobYear.getText())));
		
		report.setReporter(reporter);
		report.setAbuser(abuser);
		
		return report;
	}

	@Override
	public void updatePanel(Report report) {
		
		// Configure the reporter fields.
		firstNameTextField.setText(report.reporter.getFirstName());
		lastNameTextField.setText(report.reporter.getLastName());
		addrTextArea.setText(report.reporter.getAddress());
		if(report.reporter.isMandated())
			mandatedCB.setSelected(true);
		else
			notMandatedCB.setSelected(true);
		phoneAreaCode.setText(report.reporter.getPhoneNumber().substring(0, 3));
		phoneFirstThree.setText((String) report.reporter.getPhoneNumber().substring(3, 6));
		phoneLastFour.setText(report.reporter.getPhoneNumber().substring(6, 10));
		relationshipTextField.setText(report.reporter.getRelationshipToVictim());
		
		// Configure the abuser fields
		abuserFirstName.setText(report.abuser.getFirstName());
		abuserLastName.setText(report.abuser.getLastName());
		abuserAddress.setText(report.abuser.getAddress());
		abuserRelationship.setText(report.abuser.getRelationshipToVictim());
		socAreaNumber.setText(report.abuser.getSocial().substring(0, 3));
		socGroupNum.setText(report.abuser.getSocial().substring(3, 5));
		socSerialNum.setText(report.abuser.getSocial().substring(5, 9));
		abuserDobDay.setText(report.abuser.getDob().substring(0, 2));
		abuserDobMon.setText(report.abuser.getDob().substring(2, 4));
		abuserDobYear.setText(report.abuser.getDob().substring(4, 8));
		abuserPhoneAreaCode.setText(report.abuser.getPhoneNumber().substring(0, 3));
		abuserPhoneFirstThree.setText(report.abuser.getPhoneNumber().substring(3, 6));
		abuserPhoneLastFour.setText(report.abuser.getPhoneNumber().substring(6, 10));
		
	}
}
