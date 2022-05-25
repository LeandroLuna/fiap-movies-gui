package br.com.fiap.listaFilmes.components;

import javax.swing.JTextArea;

public class TextArea extends JTextArea {

	private static final long serialVersionUID = 1L;
	
	private int colunas = 10;
	private int linhas = 1;
	
	public TextArea() {
		init();
	}

	private void init() {
		this.setColumns(colunas);
		this.setRows(linhas);
		//this.setBorder(BorderFactory.criar());
	}

}