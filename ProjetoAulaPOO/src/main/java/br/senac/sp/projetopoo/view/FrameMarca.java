package br.senac.sp.projetopoo.view;

import java.awt.EventQueue;

import br.senac.sp.projetopoo.dao.ConnectionFactory;
import br.senac.sp.projetopoo.modelo.Marca;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameMarca extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfNome;
	private Marca marca;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMarca frame = new FrameMarca();
					frame.setVisible(true);
					ConnectionFactory.getConexao();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameMarca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 11, 66, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setBounds(10, 47, 66, 22);
		contentPane.add(lblNewLabel_1);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(51, 12, 86, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(51, 48, 196, 20);
		contentPane.add(tfNome);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(Color.LIGHT_GRAY);
		lblLogo.setForeground(Color.BLACK);
		lblLogo.setOpaque(true);
		lblLogo.setBounds(348, 11, 76, 58);
		contentPane.add(lblLogo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfNome.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(FrameMarca.this, "Informe o nome", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					tfNome.requestFocus();
				} else {
					marca = new Marca();
					marca.setNome(tfNome.getText().trim());
					
				}
			}
		});
		btnSalvar.setBounds(10, 98, 95, 23);
		contentPane.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(115, 98, 95, 23);
		contentPane.add(btnExcluir);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(220, 98, 95, 23);
		contentPane.add(btnLimpar);
	}
}
