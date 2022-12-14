package vistas;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.ControladorAgendarInstalacion;
import modelos.ComboItem;
import modelos.EmpleadoView;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class DialogoSeleccionarTecnico extends JDialog {

	private JPanel contentPane;
	private JComboBox<EmpleadoView> comboBoxTecnicos;
	private JButton buttonConfirmar;
	
	

	/**
	 * Create the frame.
	 */
	public DialogoSeleccionarTecnico(JFrame padre, boolean esModal) {
		super(padre,esModal);
		setTitle("Seleccionar Tecnico");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 420, 117);
		this.setBackground(Color.WHITE);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel labelTecnicosDisponibles = new JLabel("Tecnicos Disponibles");
		labelTecnicosDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		labelTecnicosDisponibles.setFont(new Font(VistaConfig.labelFontFamily, Font.PLAIN, VistaConfig.labelFontSize));
		panelCentral.add(labelTecnicosDisponibles);
		
		this.comboBoxTecnicos= new JComboBox<EmpleadoView>();
		panelCentral.add(comboBoxTecnicos);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setOpaque(false);
		contentPane.add(panelInferior, BorderLayout.SOUTH);
		
		this.buttonConfirmar = VistaConfig.crearBotonFormateado("Confirmar", "CONFIRMAR_TECNICO");
		panelInferior.add(buttonConfirmar);
	}

	public void setTecnicosDisponibles(DefaultComboBoxModel<EmpleadoView> comboBoxModel) {
		this.comboBoxTecnicos.setModel(comboBoxModel);
	}
	
	public void setControlador(ControladorAgendarInstalacion controlador) {
		this.buttonConfirmar.addActionListener(controlador);
	}
	
	public EmpleadoView getTecnicoSeleccionado() {
		return (EmpleadoView) this.comboBoxTecnicos.getSelectedItem();
	}
	

	
	
}
