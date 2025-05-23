package DBeverageMenu..beveragemenu;

import java.util.*;

import vmj.routing.route.VMJExchange;

import DBeverageMenu..core.MenuServiceDecorator;
import DBeverageMenu..core.MenuImpl;
import DBeverageMenu..core.MenuServiceComponent;

public class MenuServiceImpl extends MenuServiceDecorator {
    public MenuServiceImpl (MenuServiceComponent record) {
        super(record);
    }

    
}
