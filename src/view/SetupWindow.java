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
import javax.sound.sampled.Control;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SetupWindow extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public SetupWindow(List<Setup> setupList) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		String[] columns = {"Setup ID", "Description", "Total time"};

		DefaultTableModel model = new DefaultTableModel(convert(setupList),columns);
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
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            controlWindow ctrl = new controlWindow();
	            ctrl.launchClapWindow((int)table.getValueAt(table.getSelectedRow(), 0));
	           
	        }
	    });
	}
	
	public void afficher()
	{
		setVisible(true);
	}
	
	public Object[][] convert(List<Setup> setupList){
		Object[][] obj = new Object[setupList.size()][3];
		for(int i = 0; i < setupList.size(); i++) {
			Setup st = setupList.get(i);
			obj[i][0] = st.getId();
			obj[i][1] = st.getDesc();
			
			int totalTime = 0;
			
			for(Clap clap : st.getListClaps()) {
				totalTime += clap.getSceneDuration();
			}
			
			obj[i][2] = Double.toString(Math.round(totalTime/3600.0 * 100.0)/100.0)+"h";
		}
		return obj;
	}
	
}
