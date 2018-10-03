package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import model.*;
import view.*;

public class MenusController extends WindowAdapter {
	
	LoadMenus loadMenus = new LoadMenus();
	
	private FrameApp frame;
	
	// Constructor
	public MenusController(FrameApp frameApp) {
		this.frame = frameApp;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void windowOpened(WindowEvent e) {
		loadMenus.executeQuery();
		
		try {
			// by default, resulset places between first and second element, so we need to move one before
			loadMenus.getResultSet().previous();
			loadMenus.getResultSet2().previous();
			while(loadMenus.getResultSet().next()) { // Insert on the combobox frame the sections returned by the loadSections query
		
				frame.getSecciones().addItem(loadMenus.getResultSet().getString(1));
			}
			while(loadMenus.getResultSet2().next()) {
				frame.getPaises().addItem(loadMenus.getResultSet2().getString(1));
			}	
			loadMenus.getResultSet().close();
		} catch (Exception exception) {
			System.out.println("Error on Section Controller");
			System.out.println(exception.getMessage());
		}
	}
}
