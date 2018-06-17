package com.design;

import java.io.FileInputStream;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

import com.ctrl.NaiveBayesianClassifier;
/*
 * Homepage.java
 *
 * Created on __DATE__, __TIME__
 */

/**
 *
 * @author  __USER__
 */
public class Homepage extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Creates new form Homepage */
	public Homepage() {
		initComponents();
	}

	
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		txtTraining = new javax.swing.JTextField();
		btnTraingBrowse = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		txtTesting = new javax.swing.JTextField();
		btnTextBrowse = new javax.swing.JButton();
		btnK2 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jtaK2 = new javax.swing.JTextArea();
		btnBay = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		jtaBay = new javax.swing.JTextArea();
		btnJuction = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jLabel1.setText("Training Dataset");
		getContentPane().add(jLabel1);
		jLabel1.setBounds(40, 50, 150, 14);
		getContentPane().add(txtTraining);
		txtTraining.setBounds(40, 70, 450, 20);

		btnTraingBrowse.setText("Browse");
		btnTraingBrowse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTraingBrowseActionPerformed(evt);
			}
		});
		getContentPane().add(btnTraingBrowse);
		btnTraingBrowse.setBounds(380, 90, 110, 23);

		jLabel2.setText("Testing Dataset");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(40, 100, 150, 14);
		getContentPane().add(txtTesting);
		txtTesting.setBounds(40, 120, 450, 20);

		btnTextBrowse.setText("Browse");
		btnTextBrowse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTextBrowseActionPerformed(evt);
			}
		});
		getContentPane().add(btnTextBrowse);
		btnTextBrowse.setBounds(380, 140, 110, 23);

		btnK2.setText("K2 Process");
		btnK2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnK2ActionPerformed(evt);
			}
		});
		getContentPane().add(btnK2);
		btnK2.setBounds(40, 160, 170, 23);

		jtaK2.setColumns(20);
		jtaK2.setRows(5);
		jScrollPane1.setViewportView(jtaK2);

		getContentPane().add(jScrollPane1);
		jScrollPane1.setBounds(40, 200, 450, 120);

		btnBay.setText("Bayesian Network");
		btnBay.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBayActionPerformed(evt);
			}
		});
		getContentPane().add(btnBay);
		btnBay.setBounds(40, 330, 180, 23);

		jtaBay.setColumns(20);
		jtaBay.setRows(5);
		jScrollPane2.setViewportView(jtaBay);

		getContentPane().add(jScrollPane2);
		jScrollPane2.setBounds(40, 360, 450, 110);

		btnJuction.setText("Junction Tree");
		btnJuction.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnJuctionActionPerformed(evt);
			}
		});
		getContentPane().add(btnJuction);
		btnJuction.setBounds(170, 480, 190, 23);

		jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 1, 24));
		jLabel3.setForeground(new java.awt.Color(102, 51, 255));
		jLabel3.setText("       Adaptive IDS");
		getContentPane().add(jLabel3);
		jLabel3.setBounds(120, 10, 350, 30);

		setSize(550, 550);
		setTitle("Intrusion Detection System");
		setResizable(false);
		setVisible(true);
	}// </editor-fold>
	//GEN-END:initComponents

	private void btnJuctionActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		new JunctionTree().init(taianpath,testpath);
	}

	private void btnBayActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		nc.classify(jtaBay);
	}

	private void btnTextBrowseActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		browseTest();
		txtTesting.setText(testpath);
	}

	private void btnTraingBrowseActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		browseTrain();
		txtTraining.setText(taianpath);
		nc.setFile(taianpath);
		
	}

	private void btnK2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		nc.training(jtaK2);
	}
	private void browseTest() {
		// TODO Auto-generated method stub
		JFileChooser jfr = new JFileChooser();
		int check = jfr.showOpenDialog(this);
		try {
			if (check == JFileChooser.APPROVE_OPTION) {
				testpath = jfr.getSelectedFile().getPath();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void browseTrain() {
		// TODO Auto-generated method stub
		JFileChooser jfr = new JFileChooser();
		int check = jfr.showOpenDialog(this);
		try {
			if (check == JFileChooser.APPROVE_OPTION) {
				taianpath = jfr.getSelectedFile().getPath();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	String testpath;
	String taianpath;
	NaiveBayesianClassifier nc=new NaiveBayesianClassifier();

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Homepage().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnBay;
	private javax.swing.JButton btnJuction;
	private javax.swing.JButton btnK2;
	private javax.swing.JButton btnTextBrowse;
	private javax.swing.JButton btnTraingBrowse;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea jtaBay;
	private javax.swing.JTextArea jtaK2;
	private javax.swing.JTextField txtTesting;
	private javax.swing.JTextField txtTraining;
	// End of variables declaration//GEN-END:variables

}