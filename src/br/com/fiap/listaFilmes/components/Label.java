package br.com.fiap.listaFilmes.components;

import java.awt.Color;

import javax.swing.JLabel;

public class Label extends JLabel{

	
	private static final long serialVersionUID = 1L;

	public Label (String text){
		super(text);
		init();
	}

	private void init() {
		
		this.setForeground(Color.black);
		
	}
	
	

}
