package DBeverageMenu..beveragemenu;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import DBeverageMenu..core.MenuDecorator;
import DBeverageMenu..core.Menu;
import DBeverageMenu..core.MenuComponent;

@Entity(name="_beveragemenu")
@Table(name="_beveragemenu")
public class MenuImpl extends MenuDecorator {

	public boolean isIced;
	public MenuImpl(
        super();
        this.objectName = MenuImpl.class.getName();
    }
    
    public MenuImpl(boolean isIced) {
    	super();
		this.isIced = isIced;
		this.objectName = MenuImpl.class.getName();
    }
	
	public MenuImpl(MenuComponent record, boolean isIced) {
		super(record);
		this.isIced = isIced;
		this.objectName = MenuImpl.class.getName();
	}



}
