package view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Clap;
import model.IndoorScene;
import model.OutdoorScene;
import model.Scene;
import model.Setup;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SceneWindow extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public SceneWindow(ArrayList<Scene> sceneList) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		String[] columns = {"Scene ID", "Description", "Indoor/Outdoor","Location/Theater ID", "Total time"};

		DefaultTableModel model = new DefaultTableModel(convert(sceneList),columns);
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
	
	public Object[][] convert(ArrayList<Scene> sceneList){
		Object[][] obj = new Object[sceneList.size()][5];
		for(int i = 0; i < sceneList.size(); i++) {
			Scene sc = sceneList.get(i);
			obj[i][0] = sc.getId();
			obj[i][1] = sc.getDesc();
			if(sc instanceof IndoorScene) {
				obj[i][2] = "Indoor";
				obj[i][3] = ((IndoorScene) sc).getTheater();
			}
			else {
				obj[i][2] = "Outdoor";
				obj[i][3] = ((OutdoorScene) sc).getLocation();
			}
			
			int totalTime = 0;
			for(Setup setup : sc.getListSetup()) {
				for(Clap clap : setup.getListClaps()) {
					totalTime += clap.getSceneDuration();
				}
			}
			obj[i][4] = totalTime;
		}
		return obj;
	}
	
}
