package br.com.fiap.listaFilmes.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.fiap.listaFilmes.components.ButtonListener;
import br.com.fiap.listaFilmes.components.Input;
import br.com.fiap.listaFilmes.components.Label;
import br.com.fiap.listaFilmes.components.Radios;
import br.com.fiap.listaFilmes.components.TextArea;
import br.com.fiap.listaFilmes.components.StarRater;
import br.com.fiap.listaFilmes.dao.MoviesDAO;
import br.com.fiap.listaFilmes.model.MoviesList;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	Input inputText = new Input();
	TextArea myTextArea = new TextArea();
	Label title = new Label("Title");
	Label synopsis = new Label(" Synopsis");
	Label genreLabel = new Label("Genre");
	Label rating = new Label("Rating");
	JButton save = new JButton("Save");
	JButton cancel = new JButton("Cancel");
	String[] genres = {"", "Comedy", "Adventure", "Fiction"};
	JComboBox<String> genre = new JComboBox<>(genres);
	JCheckBox watched = new JCheckBox("Watched");
    StarRater starRater = new StarRater();
	Radios radio = new Radios(Arrays.asList("Netflix", "Prime Video", "Pirate Bay"));
	String[] columns =  {"Id", "Title", "Synopsis", "Genre", "Where to watch", "Watched", "StasRate"};
	DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
	JTable table = new JTable(tableModel);
	ButtonListener listenerSalvar = new ButtonListener(this); 
	
	JPanel center = new JPanel(new GridLayout(0,1,0,0));
	JPanel lineEnd = new JPanel();
	JPanel lineStart = new JPanel();
	JPanel pageEnd = new JPanel(new FlowLayout());
	JTabbedPane tabs = new JTabbedPane();
	
	public Window() {
		setSize(600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void init() {
	JPanel register = new JPanel();
	register.setLayout(new BorderLayout(20,30));
	
	//Center panel
	center.add(title);
	center.add(inputText);
	center.add(synopsis);
	center.add(myTextArea);
	center.add(genreLabel);
	
	center.add(genre);
    
    //Left panel
	lineEnd.setLayout(new BoxLayout(lineEnd, BoxLayout.PAGE_AXIS));
	Label whereToWatch = new Label("Where to watch");
	lineEnd.add(Box.createVerticalStrut(10));
	lineEnd.add(whereToWatch);
    lineEnd.add(radio.getComponent(0));
    lineEnd.add(radio.getComponent(0));
    lineEnd.add(radio.getComponent(0));
    lineEnd.add(watched);
    lineEnd.add(rating);
    lineEnd.add(starRater);
    
	//Right panel
    JLabel img = new JLabel(new ImageIcon("src/image/minion.jpg"));
    lineStart.add(Box.createHorizontalStrut(10));
    lineStart.add(img);
    
    
    // Lower panel
	pageEnd.add(Box.createHorizontalStrut(15));
	pageEnd.add(save);
	pageEnd.add(cancel);
	
	
	// Adding all to register view	
	register.add(lineStart,BorderLayout.LINE_START);
	register.add(center, BorderLayout.CENTER);
	register.add(lineEnd, BorderLayout.LINE_END);
	register.add(pageEnd, BorderLayout.PAGE_END);
	

	// Incluiding both tabs
	tabs.add("Register", register);
	tabs.add("List", new JScrollPane(table));
	
	
	add(tabs);
	setTitle("FIAP MOVIES - NAC III");
	
	loadData();
	
	table.addMouseListener(listenerSalvar);
	table.setDefaultEditor(Object.class, null);
	
	
	setVisible(true);
	
	
	save.addActionListener(listenerSalvar);
	}
	public void loadData() {
		
		tableModel.setRowCount(0);
		List<MoviesList> list = new MoviesDAO().showAll();
		list.forEach(filme -> tableModel.addRow(filme.getData()));
		
	}

	public Input getInputText() {
		return inputText;
	}

	public TextArea getMyTextArea() {
		return myTextArea;
	}

	public JComboBox<String> getGenre() {
		return genre;
	}

	public JCheckBox getWatched() {
		return watched;
	}

	public Radios getRadios() {
		return radio;
	}

	public StarRater getStarRater() {
		return starRater;
	}
}
	


