package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
import view.FrameApp;

/**
 * Control the click event on the button
 * @author pablo
 *
 */
public class ButtonController implements ActionListener{
	private FrameApp frame;
	private ExecuteQueries executeQueries = new ExecuteQueries();
	private ResultSet resultQuery;
	public ButtonController(FrameApp frame) {
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String sectionSelected = (String) frame.getSecciones().getSelectedItem();
		String countrySelected = (String) frame.getPaises().getSelectedItem();
		resultQuery =  executeQueries.filterDB(sectionSelected, countrySelected);
		
		try {
			frame.getResultado().setText("");
			while (resultQuery.next()) {
				frame.getResultado().append(resultQuery.getString(1));
				frame.getResultado().append(", ");
				frame.getResultado().append(resultQuery.getString(2));
				frame.getResultado().append(", ");
				frame.getResultado().append(resultQuery.getString(3));
				frame.getResultado().append(", ");
				frame.getResultado().append(resultQuery.getString(4));
				frame.getResultado().append("\n");
			}
		} catch (SQLException exception) {
			System.out.println(exception);
		}
	}

}
