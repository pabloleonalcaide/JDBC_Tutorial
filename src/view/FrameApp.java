package view;

import javax.swing.*;

import controller.ButtonController;
import controller.MenusController;
import java.awt.*;
/**
 * Main view, a simple frame with two Combobox and a Button
 * @author pablo
 *
 */
public class FrameApp extends JFrame {
	private JComboBox secciones;

	private JComboBox paises;

	private JTextArea resultado;

	public FrameApp() {

		setTitle("Consulta BBDD");

		setBounds(500, 300, 400, 400);

		setLayout(new BorderLayout());

		JPanel menus = new JPanel();

		menus.setLayout(new FlowLayout());

		secciones = new JComboBox();

		secciones.setEditable(false);

		secciones.addItem("Todos");

		paises = new JComboBox();

		paises.setEditable(false);

		paises.addItem("Todos");

		resultado = new JTextArea(4, 50);

		resultado.setEditable(false);

		add(resultado);

		menus.add(secciones);

		menus.add(paises);

		add(menus, BorderLayout.NORTH);

		add(resultado, BorderLayout.CENTER);

		JButton botonConsulta = new JButton("Consulta");

		add(botonConsulta, BorderLayout.SOUTH);

		// add window listener to the combobox
		addWindowListener(new MenusController(this));
		// add action listener to the button
		botonConsulta.addActionListener(new ButtonController(this));
	}

	public JComboBox getPaises() {
		return paises;
	}

	public void setPaises(JComboBox paises) {
		this.paises = paises;
	}

	public JComboBox getSecciones() {
		return secciones;
	}

	public void setSecciones(JComboBox secciones) {
		this.secciones = secciones;
	}

	public JTextArea getResultado() {
		return resultado;
	}

	public void setResultado(JTextArea resultado) {
		this.resultado = resultado;
	}


}
