package br.com.fiap.listaFilmes.components;

import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Radios extends JPanel{
	private static final long serialVersionUID = 1L;
	private ButtonGroup group = new ButtonGroup();
	private List<String> options;

	
	public Radios(List<String> opcoes) {
		this.options = opcoes;
		init();
	}

	private void init() {
		// Arrow function
		options.forEach(option -> {
			JRadioButton radio = new JRadioButton(option);
			this.group.add(radio);
			this.add(radio);
		});
	}
	
	public String getSelectedButtonText( ) {
        for (Enumeration<AbstractButton> buttons = this.group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
	
}