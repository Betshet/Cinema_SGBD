package view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.controlWindow;
import model.Clap;
import model.IndoorScene;
import model.OutdoorScene;
import model.Scene;
import model.Setup;

import javax.swing.JButton;
import javax.persistence.EntityManagerFactory;
import javax.sound.sampled.Control;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ClapWindow extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	private EntityManagerFactory factory;

	/**
	 * Create the frame.
	 */
	public ClapWindow(List<Clap> clapList, EntityManagerFactory factory) {
		this.factory=factory;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		String[] columns = {"Clap ID", "Duration", "Film roll ID"};

		DefaultTableModel model = new DefaultTableModel(convert(clapList),columns){
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(186, Short.MAX_VALUE))
		);
		
		
		contentPane.setLayout(gl_contentPane);
		
	}
	
	public void afficher()
	{
		setVisible(true);
	}
	
	public Object[][] convert(List<Clap> clapList){
		Object[][] obj = new Object[clapList.size()][3];
		for(int i = 0; i < clapList.size(); i++) {
			Clap cl = clapList.get(i);
			obj[i][0] = cl.getId();
			obj[i][1] = Double.toString(Math.round(cl.getSceneDuration()/3600.0 * 100.0)/100.0)+"h";
			obj[i][2] = cl.getRoll().getId();
		}
		return obj;
	}
	
}
