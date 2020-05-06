package prijemni.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prijemni.OrganizacijaPrijemnogIspita;
import prijemni.PrijemniIspit;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PrijemniGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelNorth;
	private JLabel lblNazivFajla;
	private JTextField txtNazivFajla;
	private JButton btnUcitaj;
	private JButton btnIspisi;
	private JButton btnIzadji;
	private JTextArea textArea;
	
	private OrganizacijaPrijemnogIspita organizacijaPrijemnog = new OrganizacijaPrijemnogIspita();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrijemniGUI frame = new PrijemniGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrijemniGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelNorth(), BorderLayout.NORTH);
		contentPane.add(getTextArea(), BorderLayout.CENTER);
	}

	private JPanel getPanelNorth() {
		if (panelNorth == null) {
			panelNorth = new JPanel();
			panelNorth.setPreferredSize(new Dimension(10, 140));
			panelNorth.setLayout(null);
			panelNorth.add(getLblNazivFajla());
			panelNorth.add(getTxtNazivFajla());
			panelNorth.add(getBtnUcitaj());
			panelNorth.add(getBtnIspisi());
			panelNorth.add(getBtnIzadji());
		}
		return panelNorth;
	}
	private JLabel getLblNazivFajla() {
		if (lblNazivFajla == null) {
			lblNazivFajla = new JLabel("Naziv fajla");
			lblNazivFajla.setBounds(12, 13, 74, 16);
		}
		return lblNazivFajla;
	}
	private JTextField getTxtNazivFajla() {
		if (txtNazivFajla == null) {
			txtNazivFajla = new JTextField();
			txtNazivFajla.setBounds(12, 42, 116, 22);
			txtNazivFajla.setColumns(10);
		}
		return txtNazivFajla;
	}
	private JButton getBtnUcitaj() {
		if (btnUcitaj == null) {
			btnUcitaj = new JButton("Ucitaj");
			btnUcitaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String fajl = txtNazivFajla.getText();
					try {
						organizacijaPrijemnog.ucitajIzFajlaUListu(fajl);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Greska", "Greska pri ucitavanju iz fajla", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnUcitaj.setBounds(12, 102, 97, 25);
		}
		return btnUcitaj;
	}
	private JButton getBtnIspisi() {
		if (btnIspisi == null) {
			btnIspisi = new JButton("Ispisi");
			btnIspisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					List<PrijemniIspit> uspesni = organizacijaPrijemnog.vratiUspesnePrijemneIspite();
					for (PrijemniIspit prijemniIspit : uspesni) {
						textArea.append(prijemniIspit.toString());
					}
				}
			});
			btnIspisi.setBounds(210, 102, 97, 25);
		}
		return btnIspisi;
	}
	private JButton getBtnIzadji() {
		if (btnIzadji == null) {
			btnIzadji = new JButton("Izadji");
			btnIzadji.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnIzadji.setBounds(429, 102, 97, 25);
		}
		return btnIzadji;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
