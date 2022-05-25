package br.com.fiap.listaFilmes.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.fiap.listaFilmes.dao.MoviesDAO;
import br.com.fiap.listaFilmes.model.MoviesList;
import br.com.fiap.listaFilmes.view.Window;

public class ButtonListener implements ActionListener, MouseListener{

	 private Window window; 
	 MoviesDAO dao = new MoviesDAO();
	 
	 public ButtonListener(Window janela) {
			this.window = janela;
		}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MoviesList moviesList = new MoviesList();
		moviesList.setTitle(window.getInputText().getText());
		moviesList.setSynopsis(window.getMyTextArea().getText());
		moviesList.setGenre(window.getGenre().getSelectedItem().toString());
		moviesList.setWhereToWatch(window.getRadios().getSelectedButtonText());
		moviesList.setWatched(window.getWatched().isSelected());
		moviesList.setStarRate(window.getStarRater().getSelection());
		dao.insert(moviesList);
		window.loadData();
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			int resposta = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete a movie?");
			if(resposta == JOptionPane.YES_OPTION) {
				JTable tabela = (JTable) e.getSource();
				String id = (String) tabela.getValueAt(tabela.getSelectedRow(), 0);
				dao.deleteId(Long.valueOf(id));
				window.loadData();
			}
		}	
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
