package client.abuse_report.views.abuse_report;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import client.abuse_report.interfaces.CreateReportInterface;
import client.abuse_report.models.Abuser;
import client.abuse_report.models.Guardian;
import client.abuse_report.models.Reporter;
import client.abuse_report.models.Victim;
import common.DocumentSizeFilter;

public class VictimAdditionalInfoGUI extends JPanel implements CreateReportInterface {
	private JTextField otherServedText;
	
	// Bumper on left.
	private Insets leftInsetBumper = new Insets(5, 10, 5, 5);
	
	// Bumper on top.
	private Insets topInsetBumper = new Insets(10, 10, 5, 5); 
	
	private JTextField otherServiceText;
	private JTextField txtMm;
	private JTextField txtDd;
	private JTextField txtYyyy;
	private JTextField otherTypeOfAbuseText;

	// Single filter for this class.
	private static final DocumentSizeFilter filter = new DocumentSizeFilter(10);
	
	/**
	 * Create the panel.
	 */
	public VictimAdditionalInfoGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {365, 365};
		gridBagLayout.rowHeights = new int[]{213, 0, 0, 60};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		final JPanel currentlyServedByPanel = new JPanel();
		currentlyServedByPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_currentlyServedByPanel = new GridBagConstraints();
		gbc_currentlyServedByPanel.gridwidth = 2;
		gbc_currentlyServedByPanel.insets = new Insets(0, 0, 5, 0);
		gbc_currentlyServedByPanel.weightx = 0.5;
		gbc_currentlyServedByPanel.fill = GridBagConstraints.BOTH;
		gbc_currentlyServedByPanel.gridx = 0;
		gbc_currentlyServedByPanel.gridy = 0;
		add(currentlyServedByPanel, gbc_currentlyServedByPanel);
		GridBagLayout gbl_currentlyServedByPanel = new GridBagLayout();
		gbl_currentlyServedByPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_currentlyServedByPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_currentlyServedByPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_currentlyServedByPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		currentlyServedByPanel.setLayout(gbl_currentlyServedByPanel);
		
		JTextPane warnCurrServedNotSet = new JTextPane();
		warnCurrServedNotSet.setBackground(SystemColor.menu);
		warnCurrServedNotSet.setVisible(false);
		warnCurrServedNotSet.setEditable(false);
		warnCurrServedNotSet.setForeground(Color.RED);
		warnCurrServedNotSet.setText("*");
		GridBagConstraints gbc_warnCurrServedNotSet = new GridBagConstraints();
		gbc_warnCurrServedNotSet.insets = new Insets(0, 0, 5, 5);
		gbc_warnCurrServedNotSet.gridx = 0;
		gbc_warnCurrServedNotSet.gridy = 0;
		currentlyServedByPanel.add(warnCurrServedNotSet, gbc_warnCurrServedNotSet);
		
		JLabel currentlyServedByLabel = new JLabel("Currently Served By:");
		currentlyServedByLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_currentlyServedByLabel = new GridBagConstraints();
		gbc_currentlyServedByLabel.anchor = GridBagConstraints.WEST;
		gbc_currentlyServedByLabel.insets = topInsetBumper;
		gbc_currentlyServedByLabel.gridx = 1;
		gbc_currentlyServedByLabel.gridy = 0;
		currentlyServedByPanel.add(currentlyServedByLabel, gbc_currentlyServedByLabel);
		
		JCheckBox deptOfMentalHealthCb = new JCheckBox("Dept. of Mental Health");
		GridBagConstraints gbc_deptOfMentalHealthCb = new GridBagConstraints();
		gbc_deptOfMentalHealthCb.weightx = 0.3;
		gbc_deptOfMentalHealthCb.anchor = GridBagConstraints.WEST;
		gbc_deptOfMentalHealthCb.insets = leftInsetBumper;
		gbc_deptOfMentalHealthCb.gridx = 1;
		gbc_deptOfMentalHealthCb.gridy = 1;
		currentlyServedByPanel.add(deptOfMentalHealthCb, gbc_deptOfMentalHealthCb);
		
		JCheckBox massCommBlindCb = new JCheckBox("Mass Comm./Blind");
		GridBagConstraints gbc_massCommBlindCb = new GridBagConstraints();
		gbc_massCommBlindCb.weightx = 0.5;
		gbc_massCommBlindCb.anchor = GridBagConstraints.WEST;
		gbc_massCommBlindCb.insets = leftInsetBumper;
		gbc_massCommBlindCb.gridx = 3;
		gbc_massCommBlindCb.gridy = 1;
		currentlyServedByPanel.add(massCommBlindCb, gbc_massCommBlindCb);
		
		JCheckBox deptOfDevelServicesDb = new JCheckBox("Dept. of Developmental Services");
		GridBagConstraints gbc_deptOfDevelServicesDb = new GridBagConstraints();
		gbc_deptOfDevelServicesDb.insets = leftInsetBumper;
		gbc_deptOfDevelServicesDb.anchor = GridBagConstraints.WEST;
		gbc_deptOfDevelServicesDb.gridx = 1;
		gbc_deptOfDevelServicesDb.gridy = 2;
		currentlyServedByPanel.add(deptOfDevelServicesDb, gbc_deptOfDevelServicesDb);
		
		JCheckBox massCommDeafHHCb = new JCheckBox("Mass Comm./Deaf/HH");
		GridBagConstraints gbc_massCommDeafHHCb = new GridBagConstraints();
		gbc_massCommDeafHHCb.anchor = GridBagConstraints.WEST;
		gbc_massCommDeafHHCb.insets = leftInsetBumper;
		gbc_massCommDeafHHCb.gridx = 3;
		gbc_massCommDeafHHCb.gridy = 2;
		currentlyServedByPanel.add(massCommDeafHHCb, gbc_massCommDeafHHCb);
		
		JCheckBox massRehabCommCb = new JCheckBox("Mass. Rehab. Comm.");
		GridBagConstraints gbc_massRehabCommCb = new GridBagConstraints();
		gbc_massRehabCommCb.insets = leftInsetBumper;
		gbc_massRehabCommCb.anchor = GridBagConstraints.WEST;
		gbc_massRehabCommCb.gridx = 1;
		gbc_massRehabCommCb.gridy = 3;
		currentlyServedByPanel.add(massRehabCommCb, gbc_massRehabCommCb);
		
		JCheckBox unknownCb = new JCheckBox("Unknown");
		GridBagConstraints gbc_unknownCb = new GridBagConstraints();
		gbc_unknownCb.anchor = GridBagConstraints.WEST;
		gbc_unknownCb.insets = leftInsetBumper;
		gbc_unknownCb.gridx = 3;
		gbc_unknownCb.gridy = 3;
		currentlyServedByPanel.add(unknownCb, gbc_unknownCb);
		
		JCheckBox deptOfCorrectionCb = new JCheckBox("Dept. of Correction");
		GridBagConstraints gbc_deptOfCorrectionCb = new GridBagConstraints();
		gbc_deptOfCorrectionCb.insets = leftInsetBumper;
		gbc_deptOfCorrectionCb.anchor = GridBagConstraints.WEST;
		gbc_deptOfCorrectionCb.gridx = 1;
		gbc_deptOfCorrectionCb.gridy = 4;
		currentlyServedByPanel.add(deptOfCorrectionCb, gbc_deptOfCorrectionCb);
		
		JCheckBox otherSpecifyCb = new JCheckBox("Other (Specify)");
		GridBagConstraints gbc_otherSpecifyCb = new GridBagConstraints();
		gbc_otherSpecifyCb.anchor = GridBagConstraints.WEST;
		gbc_otherSpecifyCb.insets = leftInsetBumper;
		gbc_otherSpecifyCb.gridx = 3;
		gbc_otherSpecifyCb.gridy = 4;
		currentlyServedByPanel.add(otherSpecifyCb, gbc_otherSpecifyCb);
		
		otherServedText = new JTextField();
		filter.setupTextField(otherServedText, DocumentSizeFilter.ANY, 20);
		GridBagConstraints gbc_otherServedText = new GridBagConstraints();
		gbc_otherServedText.weightx = 0.5;
		gbc_otherServedText.insets = leftInsetBumper;
		gbc_otherServedText.fill = GridBagConstraints.HORIZONTAL;
		gbc_otherServedText.gridx = 4;
		gbc_otherServedText.gridy = 4;
		currentlyServedByPanel.add(otherServedText, gbc_otherServedText);
		otherServedText.setColumns(10);
		
		JCheckBox deptOfPublicHealthCb = new JCheckBox("Dept. of Public Health");
		GridBagConstraints gbc_deptOfPublicHealthCb = new GridBagConstraints();
		gbc_deptOfPublicHealthCb.insets = new Insets(5, 10, 0, 5);
		gbc_deptOfPublicHealthCb.anchor = GridBagConstraints.WEST;
		gbc_deptOfPublicHealthCb.gridx = 1;
		gbc_deptOfPublicHealthCb.gridy = 5;
		currentlyServedByPanel.add(deptOfPublicHealthCb, gbc_deptOfPublicHealthCb);
		
		JCheckBox nonCb = new JCheckBox("None");
		GridBagConstraints gbc_nonCb = new GridBagConstraints();
		gbc_nonCb.anchor = GridBagConstraints.WEST;
		gbc_nonCb.insets = new Insets(5, 10, 0, 5);
		gbc_nonCb.gridx = 3;
		gbc_nonCb.gridy = 5;
		currentlyServedByPanel.add(nonCb, gbc_nonCb);
		
		JPanel typeOfServicePanel = new JPanel();
		typeOfServicePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_typeOfServicePanel = new GridBagConstraints();
		gbc_typeOfServicePanel.gridwidth = 2;
		gbc_typeOfServicePanel.insets = new Insets(0, 0, 5, 0);
		gbc_typeOfServicePanel.weightx = 0.5;
		gbc_typeOfServicePanel.fill = GridBagConstraints.BOTH;
		gbc_typeOfServicePanel.gridx = 0;
		gbc_typeOfServicePanel.gridy = 1;
		add(typeOfServicePanel, gbc_typeOfServicePanel);
		GridBagLayout gbl_typeOfServicePanel = new GridBagLayout();
		gbl_typeOfServicePanel.columnWidths = new int[] {0, 0, 0, 0, 0, 30};
		gbl_typeOfServicePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_typeOfServicePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_typeOfServicePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		typeOfServicePanel.setLayout(gbl_typeOfServicePanel);
		
		JTextPane warnTypeOfServiceNotSet = new JTextPane();
		warnTypeOfServiceNotSet.setVisible(false);
		warnTypeOfServiceNotSet.setText("*");
		warnTypeOfServiceNotSet.setForeground(Color.RED);
		warnTypeOfServiceNotSet.setEditable(false);
		warnTypeOfServiceNotSet.setBackground(SystemColor.menu);
		GridBagConstraints gbc_warnTypeOfServiceNotSet = new GridBagConstraints();
		gbc_warnTypeOfServiceNotSet.insets = new Insets(0, 0, 5, 5);
		gbc_warnTypeOfServiceNotSet.gridx = 0;
		gbc_warnTypeOfServiceNotSet.gridy = 0;
		typeOfServicePanel.add(warnTypeOfServiceNotSet, gbc_warnTypeOfServiceNotSet);
		
		JLabel lblTypeOfService = new JLabel("Type of Service");
		lblTypeOfService.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblTypeOfService = new GridBagConstraints();
		gbc_lblTypeOfService.anchor = GridBagConstraints.WEST;
		gbc_lblTypeOfService.insets = topInsetBumper;
		gbc_lblTypeOfService.gridx = 1;
		gbc_lblTypeOfService.gridy = 0;
		typeOfServicePanel.add(lblTypeOfService, gbc_lblTypeOfService);
		
		JCheckBox institutionalCb = new JCheckBox("Institutional");
		GridBagConstraints gbc_institutionalCb = new GridBagConstraints();
		gbc_institutionalCb.weightx = 0.6;
		gbc_institutionalCb.anchor = GridBagConstraints.WEST;
		gbc_institutionalCb.insets = leftInsetBumper;
		gbc_institutionalCb.gridx = 1;
		gbc_institutionalCb.gridy = 1;
		typeOfServicePanel.add(institutionalCb, gbc_institutionalCb);
		
		JCheckBox serviceCoordinationCb = new JCheckBox("Service Coordination");
		GridBagConstraints gbc_serviceCoordinationCb = new GridBagConstraints();
		gbc_serviceCoordinationCb.weightx = 0.4;
		gbc_serviceCoordinationCb.anchor = GridBagConstraints.WEST;
		gbc_serviceCoordinationCb.insets = leftInsetBumper;
		gbc_serviceCoordinationCb.gridx = 3;
		gbc_serviceCoordinationCb.gridy = 1;
		typeOfServicePanel.add(serviceCoordinationCb, gbc_serviceCoordinationCb);
		
		JCheckBox residentialCb = new JCheckBox("Residential");
		GridBagConstraints gbc_residentialCb = new GridBagConstraints();
		gbc_residentialCb.insets = leftInsetBumper;
		gbc_residentialCb.anchor = GridBagConstraints.WEST;
		gbc_residentialCb.gridx = 1;
		gbc_residentialCb.gridy = 2;
		typeOfServicePanel.add(residentialCb, gbc_residentialCb);
		
		JCheckBox fosterCb = new JCheckBox("Foster / Spec. Home Care");
		GridBagConstraints gbc_fosterCb = new GridBagConstraints();
		gbc_fosterCb.anchor = GridBagConstraints.WEST;
		gbc_fosterCb.insets = leftInsetBumper;
		gbc_fosterCb.gridx = 3;
		gbc_fosterCb.gridy = 2;
		typeOfServicePanel.add(fosterCb, gbc_fosterCb);
		
		JCheckBox dayProgramCb = new JCheckBox("Day Program");
		GridBagConstraints gbc_dayProgramCb = new GridBagConstraints();
		gbc_dayProgramCb.insets = leftInsetBumper;
		gbc_dayProgramCb.anchor = GridBagConstraints.WEST;
		gbc_dayProgramCb.gridx = 1;
		gbc_dayProgramCb.gridy = 3;
		typeOfServicePanel.add(dayProgramCb, gbc_dayProgramCb);
		
		JCheckBox respiteCb = new JCheckBox("Respite");
		GridBagConstraints gbc_respiteCb = new GridBagConstraints();
		gbc_respiteCb.anchor = GridBagConstraints.WEST;
		gbc_respiteCb.insets = leftInsetBumper;
		gbc_respiteCb.gridx = 3;
		gbc_respiteCb.gridy = 3;
		typeOfServicePanel.add(respiteCb, gbc_respiteCb);
		
		JCheckBox caseManagementCb = new JCheckBox("Case Management");
		GridBagConstraints gbc_caseManagementCb = new GridBagConstraints();
		gbc_caseManagementCb.anchor = GridBagConstraints.WEST;
		gbc_caseManagementCb.insets = new Insets(5, 10, 10, 5);
		gbc_caseManagementCb.gridx = 1;
		gbc_caseManagementCb.gridy = 4;
		typeOfServicePanel.add(caseManagementCb, gbc_caseManagementCb);
		
		JCheckBox otherServiceCb = new JCheckBox("Other (Specify)");
		GridBagConstraints gbc_otherServiceCb = new GridBagConstraints();
		gbc_otherServiceCb.anchor = GridBagConstraints.WEST;
		gbc_otherServiceCb.insets = new Insets(5, 10, 10, 5);
		gbc_otherServiceCb.gridx = 3;
		gbc_otherServiceCb.gridy = 4;
		typeOfServicePanel.add(otherServiceCb, gbc_otherServiceCb);
		
		otherServiceText = new JTextField();
		filter.setupTextField(otherServiceText, DocumentSizeFilter.ANY, 20);
		GridBagConstraints gbc_otherServiceText = new GridBagConstraints();
		gbc_otherServiceText.insets = new Insets(5, 10, 10, 5);
		gbc_otherServiceText.weightx = 0.5;
		gbc_otherServiceText.fill = GridBagConstraints.HORIZONTAL;
		gbc_otherServiceText.gridx = 4;
		gbc_otherServiceText.gridy = 4;
		typeOfServicePanel.add(otherServiceText, gbc_otherServiceText);
		otherServiceText.setColumns(10);
		
		JPanel reportAwarenessPanel = new JPanel();
		reportAwarenessPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_reportAwarenessPanel = new GridBagConstraints();
		gbc_reportAwarenessPanel.gridwidth = 2;
		gbc_reportAwarenessPanel.insets = new Insets(0, 0, 5, 0);
		gbc_reportAwarenessPanel.weighty = 0.1;
		gbc_reportAwarenessPanel.weightx = 0.5;
		gbc_reportAwarenessPanel.fill = GridBagConstraints.BOTH;
		gbc_reportAwarenessPanel.gridx = 0;
		gbc_reportAwarenessPanel.gridy = 2;
		add(reportAwarenessPanel, gbc_reportAwarenessPanel);
		GridBagLayout gbl_reportAwarenessPanel = new GridBagLayout();
		gbl_reportAwarenessPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_reportAwarenessPanel.rowHeights = new int[]{0, 0, 0};
		gbl_reportAwarenessPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_reportAwarenessPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		reportAwarenessPanel.setLayout(gbl_reportAwarenessPanel);
		
		JTextPane warnVictimAwarenessNotSet = new JTextPane();
		warnVictimAwarenessNotSet.setVisible(false);
		warnVictimAwarenessNotSet.setText("*");
		warnVictimAwarenessNotSet.setForeground(Color.RED);
		warnVictimAwarenessNotSet.setEditable(false);
		warnVictimAwarenessNotSet.setBackground(SystemColor.menu);
		GridBagConstraints gbc_warnVictimAwarenessNotSet = new GridBagConstraints();
		gbc_warnVictimAwarenessNotSet.insets = new Insets(0, 0, 5, 5);
		gbc_warnVictimAwarenessNotSet.gridx = 0;
		gbc_warnVictimAwarenessNotSet.gridy = 0;
		reportAwarenessPanel.add(warnVictimAwarenessNotSet, gbc_warnVictimAwarenessNotSet);
		
		JLabel isVictimAwareLabel = new JLabel("Is victim aware of report?");
		isVictimAwareLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_isVictimAwareLabel = new GridBagConstraints();
		gbc_isVictimAwareLabel.anchor = GridBagConstraints.WEST;
		gbc_isVictimAwareLabel.weightx = 0.1;
		gbc_isVictimAwareLabel.insets = leftInsetBumper;
		gbc_isVictimAwareLabel.gridx = 1;
		gbc_isVictimAwareLabel.gridy = 0;
		reportAwarenessPanel.add(isVictimAwareLabel, gbc_isVictimAwareLabel);
		
		JCheckBox yesCb = new JCheckBox("Yes");
		GridBagConstraints gbc_yesCb = new GridBagConstraints();
		gbc_yesCb.anchor = GridBagConstraints.WEST;
		gbc_yesCb.weightx = 0.2;
		gbc_yesCb.insets = new Insets(0, 0, 0, 5);
		gbc_yesCb.gridx = 2;
		gbc_yesCb.gridy = 1;
		reportAwarenessPanel.add(yesCb, gbc_yesCb);
		
		JCheckBox noCb = new JCheckBox("No");
		GridBagConstraints gbc_noCb = new GridBagConstraints();
		gbc_noCb.anchor = GridBagConstraints.WEST;
		gbc_noCb.weightx = 0.4;
		gbc_noCb.gridx = 3;
		gbc_noCb.gridy = 1;
		reportAwarenessPanel.add(noCb, gbc_noCb);
		
		JPanel frequencyOfAbusePanel = new JPanel();
		frequencyOfAbusePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_frequencyOfAbusePanel = new GridBagConstraints();
		gbc_frequencyOfAbusePanel.weighty = 0.5;
		gbc_frequencyOfAbusePanel.weightx = 0.5;
		gbc_frequencyOfAbusePanel.insets = new Insets(0, 0, 0, 5);
		gbc_frequencyOfAbusePanel.fill = GridBagConstraints.BOTH;
		gbc_frequencyOfAbusePanel.gridx = 0;
		gbc_frequencyOfAbusePanel.gridy = 3;
		add(frequencyOfAbusePanel, gbc_frequencyOfAbusePanel);
		GridBagLayout gbl_frequencyOfAbusePanel = new GridBagLayout();
		gbl_frequencyOfAbusePanel.columnWidths = new int[]{0, 0, 102, 90, 0};
		gbl_frequencyOfAbusePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_frequencyOfAbusePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_frequencyOfAbusePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frequencyOfAbusePanel.setLayout(gbl_frequencyOfAbusePanel);
		
		JTextPane warnFreqOfAbuseNotSet = new JTextPane();
		warnFreqOfAbuseNotSet.setVisible(false);
		warnFreqOfAbuseNotSet.setText("*");
		warnFreqOfAbuseNotSet.setForeground(Color.RED);
		warnFreqOfAbuseNotSet.setEditable(false);
		warnFreqOfAbuseNotSet.setBackground(SystemColor.menu);
		GridBagConstraints gbc_warnFreqOfAbuseNotSet = new GridBagConstraints();
		gbc_warnFreqOfAbuseNotSet.insets = new Insets(0, 0, 5, 5);
		gbc_warnFreqOfAbuseNotSet.gridx = 0;
		gbc_warnFreqOfAbuseNotSet.gridy = 0;
		frequencyOfAbusePanel.add(warnFreqOfAbuseNotSet, gbc_warnFreqOfAbuseNotSet);
		
		JLabel freqOfAbuseLabel = new JLabel("Frequency of Abuse");
		freqOfAbuseLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_freqOfAbuseLabel = new GridBagConstraints();
		gbc_freqOfAbuseLabel.gridwidth = 2;
		gbc_freqOfAbuseLabel.anchor = GridBagConstraints.WEST;
		gbc_freqOfAbuseLabel.insets = new Insets(10, 10, 5, 5);
		gbc_freqOfAbuseLabel.gridx = 1;
		gbc_freqOfAbuseLabel.gridy = 0;
		frequencyOfAbusePanel.add(freqOfAbuseLabel, gbc_freqOfAbuseLabel);
		
		JCheckBox dailyCb = new JCheckBox("Daily");
		GridBagConstraints gbc_dailyCb = new GridBagConstraints();
		gbc_dailyCb.weighty = 0.5;
		gbc_dailyCb.weightx = 0.5;
		gbc_dailyCb.anchor = GridBagConstraints.WEST;
		gbc_dailyCb.insets = leftInsetBumper;
		gbc_dailyCb.gridx = 1;
		gbc_dailyCb.gridy = 1;
		frequencyOfAbusePanel.add(dailyCb, gbc_dailyCb);
		
		JCheckBox increasingCb = new JCheckBox("Increasing");
		GridBagConstraints gbc_increasingCb = new GridBagConstraints();
		gbc_increasingCb.weightx = 0.5;
		gbc_increasingCb.anchor = GridBagConstraints.WEST;
		gbc_increasingCb.insets = leftInsetBumper;
		gbc_increasingCb.gridx = 2;
		gbc_increasingCb.gridy = 1;
		frequencyOfAbusePanel.add(increasingCb, gbc_increasingCb);
		
		JCheckBox freqOfAbuseUnknownCb = new JCheckBox("Unknown");
		GridBagConstraints gbc_freqOfAbuseUnknownCb = new GridBagConstraints();
		gbc_freqOfAbuseUnknownCb.weightx = 0.5;
		gbc_freqOfAbuseUnknownCb.anchor = GridBagConstraints.WEST;
		gbc_freqOfAbuseUnknownCb.insets = new Insets(5, 10, 5, 0);
		gbc_freqOfAbuseUnknownCb.gridx = 3;
		gbc_freqOfAbuseUnknownCb.gridy = 1;
		frequencyOfAbusePanel.add(freqOfAbuseUnknownCb, gbc_freqOfAbuseUnknownCb);
		
		JCheckBox weeklyCb = new JCheckBox("Weekly");
		GridBagConstraints gbc_weeklyCb = new GridBagConstraints();
		gbc_weeklyCb.weighty = 0.5;
		gbc_weeklyCb.anchor = GridBagConstraints.WEST;
		gbc_weeklyCb.insets = leftInsetBumper;
		gbc_weeklyCb.gridx = 1;
		gbc_weeklyCb.gridy = 2;
		frequencyOfAbusePanel.add(weeklyCb, gbc_weeklyCb);
		
		JCheckBox decreasingCb = new JCheckBox("Decreasing");
		GridBagConstraints gbc_decreasingCb = new GridBagConstraints();
		gbc_decreasingCb.anchor = GridBagConstraints.WEST;
		gbc_decreasingCb.insets = leftInsetBumper;
		gbc_decreasingCb.gridx = 2;
		gbc_decreasingCb.gridy = 2;
		frequencyOfAbusePanel.add(decreasingCb, gbc_decreasingCb);
		
		JCheckBox episodicCb = new JCheckBox("Episodic");
		GridBagConstraints gbc_episodicCb = new GridBagConstraints();
		gbc_episodicCb.weighty = 0.5;
		gbc_episodicCb.anchor = GridBagConstraints.WEST;
		gbc_episodicCb.insets = leftInsetBumper;
		gbc_episodicCb.gridx = 1;
		gbc_episodicCb.gridy = 3;
		frequencyOfAbusePanel.add(episodicCb, gbc_episodicCb);
		
		JCheckBox constantCb = new JCheckBox("Constant");
		GridBagConstraints gbc_constantCb = new GridBagConstraints();
		gbc_constantCb.anchor = GridBagConstraints.WEST;
		gbc_constantCb.insets = leftInsetBumper;
		gbc_constantCb.gridx = 2;
		gbc_constantCb.gridy = 3;
		frequencyOfAbusePanel.add(constantCb, gbc_constantCb);
		
		JTextPane warnDateOfIncidentNotSet = new JTextPane();
		warnDateOfIncidentNotSet.setVisible(false);
		warnDateOfIncidentNotSet.setText("*");
		warnDateOfIncidentNotSet.setForeground(Color.RED);
		warnDateOfIncidentNotSet.setEditable(false);
		warnDateOfIncidentNotSet.setBackground(SystemColor.menu);
		GridBagConstraints gbc_warnDateOfIncidentNotSet = new GridBagConstraints();
		gbc_warnDateOfIncidentNotSet.insets = new Insets(0, 0, 0, 5);
		gbc_warnDateOfIncidentNotSet.gridx = 0;
		gbc_warnDateOfIncidentNotSet.gridy = 4;
		frequencyOfAbusePanel.add(warnDateOfIncidentNotSet, gbc_warnDateOfIncidentNotSet);
		
		JLabel dateOfLastIncidentLabel = new JLabel("Date of last incident:");
		dateOfLastIncidentLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_dateOfLastIncidentLabel = new GridBagConstraints();
		gbc_dateOfLastIncidentLabel.weighty = 0.5;
		gbc_dateOfLastIncidentLabel.gridwidth = 2;
		gbc_dateOfLastIncidentLabel.insets = new Insets(0, 0, 0, 5);
		gbc_dateOfLastIncidentLabel.gridx = 1;
		gbc_dateOfLastIncidentLabel.gridy = 4;
		frequencyOfAbusePanel.add(dateOfLastIncidentLabel, gbc_dateOfLastIncidentLabel);
		
		JPanel dateOfLastIncidentPanel = new JPanel();
		GridBagConstraints gbc_dateOfLastIncidentPanel = new GridBagConstraints();
		gbc_dateOfLastIncidentPanel.insets = new Insets(0, 0, 0, 10);
		gbc_dateOfLastIncidentPanel.fill = GridBagConstraints.BOTH;
		gbc_dateOfLastIncidentPanel.gridx = 3;
		gbc_dateOfLastIncidentPanel.gridy = 4;
		frequencyOfAbusePanel.add(dateOfLastIncidentPanel, gbc_dateOfLastIncidentPanel);
		GridBagLayout gbl_dateOfLastIncidentPanel = new GridBagLayout();
		gbl_dateOfLastIncidentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_dateOfLastIncidentPanel.rowHeights = new int[]{0, 0};
		gbl_dateOfLastIncidentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_dateOfLastIncidentPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		dateOfLastIncidentPanel.setLayout(gbl_dateOfLastIncidentPanel);
		
		txtMm = new JTextField();
		txtMm.setText("MM");
		GridBagConstraints gbc_txtMm = new GridBagConstraints();
		gbc_txtMm.weighty = 0.5;
		gbc_txtMm.weightx = 0.3;
		gbc_txtMm.insets = new Insets(0, 0, 0, 5);
		gbc_txtMm.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMm.gridx = 0;
		gbc_txtMm.gridy = 0;
		dateOfLastIncidentPanel.add(txtMm, gbc_txtMm);
		txtMm.setColumns(10);
		filter.setupTextField(txtMm, DocumentSizeFilter.NO, 2);
		
		txtDd = new JTextField();
		txtDd.setText("DD");
		GridBagConstraints gbc_txtDd = new GridBagConstraints();
		gbc_txtDd.weighty = 0.5;
		gbc_txtDd.weightx = 0.3;
		gbc_txtDd.insets = new Insets(0, 0, 0, 5);
		gbc_txtDd.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDd.gridx = 1;
		gbc_txtDd.gridy = 0;
		dateOfLastIncidentPanel.add(txtDd, gbc_txtDd);
		txtDd.setColumns(10);
		filter.setupTextField(txtDd, DocumentSizeFilter.NO, 2);
		
		txtYyyy = new JTextField();
		txtYyyy.setText("YYYY");
		GridBagConstraints gbc_txtYyyy = new GridBagConstraints();
		gbc_txtYyyy.weighty = 0.5;
		gbc_txtYyyy.weightx = 0.5;
		gbc_txtYyyy.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYyyy.gridx = 2;
		gbc_txtYyyy.gridy = 0;
		dateOfLastIncidentPanel.add(txtYyyy, gbc_txtYyyy);
		txtYyyy.setColumns(10);
		filter.setupTextField(txtYyyy, DocumentSizeFilter.NO, 4);
		
		JPanel typesOfAbusePanel = new JPanel();
		typesOfAbusePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_typesOfAbusePanel = new GridBagConstraints();
		gbc_typesOfAbusePanel.weighty = 0.5;
		gbc_typesOfAbusePanel.weightx = 0.5;
		gbc_typesOfAbusePanel.fill = GridBagConstraints.BOTH;
		gbc_typesOfAbusePanel.gridx = 1;
		gbc_typesOfAbusePanel.gridy = 3;
		add(typesOfAbusePanel, gbc_typesOfAbusePanel);
		GridBagLayout gbl_typesOfAbusePanel = new GridBagLayout();
		gbl_typesOfAbusePanel.columnWidths = new int[]{0, 117, 128, 167, 0};
		gbl_typesOfAbusePanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_typesOfAbusePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_typesOfAbusePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		typesOfAbusePanel.setLayout(gbl_typesOfAbusePanel);
		
		JTextPane warnTypesOfAbuseNotSet = new JTextPane();
		warnTypesOfAbuseNotSet.setVisible(false);
		warnTypesOfAbuseNotSet.setText("*");
		warnTypesOfAbuseNotSet.setForeground(Color.RED);
		warnTypesOfAbuseNotSet.setEditable(false);
		warnTypesOfAbuseNotSet.setBackground(SystemColor.menu);
		GridBagConstraints gbc_warnTypesOfAbuseNotSet = new GridBagConstraints();
		gbc_warnTypesOfAbuseNotSet.insets = new Insets(0, 0, 5, 5);
		gbc_warnTypesOfAbuseNotSet.gridx = 0;
		gbc_warnTypesOfAbuseNotSet.gridy = 0;
		typesOfAbusePanel.add(warnTypesOfAbuseNotSet, gbc_warnTypesOfAbuseNotSet);
		
		JLabel typesOfAbuseLabel = new JLabel("Types of Abuse");
		typesOfAbuseLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_typesOfAbuseLabel = new GridBagConstraints();
		gbc_typesOfAbuseLabel.anchor = GridBagConstraints.WEST;
		gbc_typesOfAbuseLabel.gridwidth = 2;
		gbc_typesOfAbuseLabel.insets = topInsetBumper;
		gbc_typesOfAbuseLabel.gridx = 1;
		gbc_typesOfAbuseLabel.gridy = 0;
		typesOfAbusePanel.add(typesOfAbuseLabel, gbc_typesOfAbuseLabel);
		
		JLabel listAllWhichApplyLabel = new JLabel("(List all which apply)");
		listAllWhichApplyLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_listAllWhichApplyLabel = new GridBagConstraints();
		gbc_listAllWhichApplyLabel.gridx = 3;
		gbc_listAllWhichApplyLabel.gridy = 0;
		gbc_listAllWhichApplyLabel.insets = new Insets(10, 10, 5, 15);
		typesOfAbusePanel.add(listAllWhichApplyLabel, gbc_listAllWhichApplyLabel);
		
		JCheckBox physicalCb = new JCheckBox("Physical");
		GridBagConstraints gbc_physicalCb = new GridBagConstraints();
		gbc_physicalCb.weighty = 0.5;
		gbc_physicalCb.weightx = 0.5;
		gbc_physicalCb.anchor = GridBagConstraints.WEST;
		gbc_physicalCb.insets = leftInsetBumper;
		gbc_physicalCb.gridx = 1;
		gbc_physicalCb.gridy = 1;
		typesOfAbusePanel.add(physicalCb, gbc_physicalCb);
		
		JCheckBox omissionCb = new JCheckBox("Omission");
		GridBagConstraints gbc_omissionCb = new GridBagConstraints();
		gbc_omissionCb.anchor = GridBagConstraints.WEST;
		gbc_omissionCb.insets = leftInsetBumper;
		gbc_omissionCb.gridx = 2;
		gbc_omissionCb.gridy = 1;
		typesOfAbusePanel.add(omissionCb, gbc_omissionCb);
		
		JCheckBox sexualCb = new JCheckBox("Sexual");
		GridBagConstraints gbc_sexualCb = new GridBagConstraints();
		gbc_sexualCb.weighty = 0.5;
		gbc_sexualCb.weightx = 0.5;
		gbc_sexualCb.anchor = GridBagConstraints.WEST;
		gbc_sexualCb.insets = leftInsetBumper;
		gbc_sexualCb.gridx = 1;
		gbc_sexualCb.gridy = 2;
		typesOfAbusePanel.add(sexualCb, gbc_sexualCb);
		
		JCheckBox otherTypeOfAbuseCb = new JCheckBox("Other (Specify)");
		GridBagConstraints gbc_otherTypeOfAbuseCb = new GridBagConstraints();
		gbc_otherTypeOfAbuseCb.weighty = 0.5;
		gbc_otherTypeOfAbuseCb.weightx = 0.5;
		gbc_otherTypeOfAbuseCb.anchor = GridBagConstraints.WEST;
		gbc_otherTypeOfAbuseCb.insets = leftInsetBumper;
		gbc_otherTypeOfAbuseCb.gridx = 2;
		gbc_otherTypeOfAbuseCb.gridy = 2;
		typesOfAbusePanel.add(otherTypeOfAbuseCb, gbc_otherTypeOfAbuseCb);
		
		otherTypeOfAbuseText = new JTextField();
		filter.setupTextField(otherTypeOfAbuseText, DocumentSizeFilter.ANY, 20);
		GridBagConstraints gbc_otherTypeOfAbuseText = new GridBagConstraints();
		gbc_otherTypeOfAbuseText.weighty = 0.5;
		gbc_otherTypeOfAbuseText.weightx = 0.5;
		gbc_otherTypeOfAbuseText.insets = new Insets(0, 0, 5, 15);
		gbc_otherTypeOfAbuseText.fill = GridBagConstraints.HORIZONTAL;
		gbc_otherTypeOfAbuseText.gridx = 3;
		gbc_otherTypeOfAbuseText.gridy = 2;
		typesOfAbusePanel.add(otherTypeOfAbuseText, gbc_otherTypeOfAbuseText);
		otherTypeOfAbuseText.setColumns(10);
		
		JCheckBox emotionalCb = new JCheckBox("Emotional");
		GridBagConstraints gbc_emotionalCb = new GridBagConstraints();
		gbc_emotionalCb.weightx = 0.5;
		gbc_emotionalCb.weighty = 0.5;
		gbc_emotionalCb.anchor = GridBagConstraints.WEST;
		gbc_emotionalCb.insets = new Insets(5, 10, 0, 5);
		gbc_emotionalCb.gridx = 1;
		gbc_emotionalCb.gridy = 3;
		typesOfAbusePanel.add(emotionalCb, gbc_emotionalCb);

		for(int i=0; i<currentlyServedByPanel.getComponents().length; i++) {
			if(currentlyServedByPanel.getComponent(i) instanceof JCheckBox) {
				JCheckBox myCb = new JCheckBox();
				myCb = (JCheckBox) currentlyServedByPanel.getComponent(i);
				myCb.addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent event) {
						if((event.getStateChange() == ItemEvent.SELECTED) || (event.getStateChange() == ItemEvent.DESELECTED)) {
							toggleAllCheckBoxesInPanel(currentlyServedByPanel, event.getItem());
						}
						
					}
				});
			}
		}
		
	}

	@Override
	public boolean isValidInfo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reporter commitReporter(Reporter reporter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Abuser commitAbuser(Abuser abuser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Victim commitVictim(Victim victim) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void toggleAllCheckBoxesInPanel(Container container, Object cb){
		JCheckBox myCb;
		String    cbText;
		boolean enableText = false;
		for(int i=0; i<container.getComponents().length; i++){	
			if(container.getComponent(i) instanceof JCheckBox) {
				myCb = (JCheckBox) container.getComponent(i);
				cbText = myCb.getText();
				if(cbText.matches("^(Other)\\.+")) {
					System.out.println("Got the regex");
				} else {
					System.out.println("Text = " + cbText);
				}
			}
		}
	}

	@Override
	public Guardian commitGuardian(Guardian guardian) {
		// TODO Auto-generated method stub
		return null;
	}

}
