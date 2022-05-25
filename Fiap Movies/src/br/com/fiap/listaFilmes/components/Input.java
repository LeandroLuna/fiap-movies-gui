package br.com.fiap.listaFilmes.components;

import java.awt.Color;

import javax.swing.JTextField;

public class Input extends JTextField {
	
	private static final long serialVersionUID = 1L;

	public Input() {
		super(20);
		init();
	}

	private void init() {
		this.setForeground(new Color(50,50,50));
		this.setBackground(Color.WHITE);
		this.setSize(100,10);
		
		this.setBorder(BorderFactory.criar()); 
	}

}