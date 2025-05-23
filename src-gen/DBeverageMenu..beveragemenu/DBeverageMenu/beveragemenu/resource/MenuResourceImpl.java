package DBeverageMenu..beveragemenu;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import DBeverageMenu..core.MenuResourceDecorator;
import DBeverageMenu..core.MenuImpl;
import DBeverageMenu..core.MenuResourceComponent;

public class MenuResourceImpl extends MenuResourceDecorator {
    public MenuResourceImpl (MenuResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/beveragemenu/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		invalidBeverageMenu invalidbeveragemenu = createinvalidBeverageMenu(vmjExchange);
		invalidbeveragemenuRepository.saveObject(invalidbeveragemenu);
		return getAllinvalidBeverageMenu(vmjExchange);
	}

    public  createinvalidBeverageMenu(VMJExchange vmjExchange){
		boolean isIced = (boolean) vmjExchange.getRequestBodyForm("isIced");
		
		invalidBeverageMenu invalidbeveragemenu = record.createinvalidBeverageMenu(vmjExchange);
		invalidBeverageMenu invalidbeveragemenudeco = invalidBeverageMenuFactory.createinvalidBeverageMenu("DBeverageMenu.beveragemenu.core.MenuImpl", invalidbeveragemenu, 
		isIced
		);
			return invalidbeveragemenudeco;
	}


    public  createinvalidBeverageMenu(VMJExchange vmjExchange, int id){
		boolean isIced = (boolean) vmjExchange.getRequestBodyForm("isIced");
		invalidBeverageMenu invalidbeveragemenu = invalidbeveragemenuRepository.getObject(id);
		int recordinvalidBeverageMenuId = (((invalidBeverageMenuDecorator) savedinvalidBeverageMenu.getRecord()).getId();
		
		invalidBeverageMenu invalidbeveragemenu = record.createinvalidBeverageMenu(vmjExchange);
		invalidBeverageMenu invalidbeveragemenudeco = invalidBeverageMenuFactory.createinvalidBeverageMenu("DBeverageMenu.beveragemenu.core.MenuImpl", id, invalidbeveragemenu, 
		isIced
		);
			return invalidbeveragemenudeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/beveragemenu/update")
    public HashMap<String, Object> updateinvalidBeverageMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		invalidBeverageMenu invalidbeveragemenu = invalidbeveragemenuRepository.getObject(id);
		invalidbeveragemenu = createinvalidBeverageMenu(vmjExchange, id);
		
		invalidbeveragemenuRepository.updateObject(invalidbeveragemenu);
		invalidbeveragemenu = invalidbeveragemenuRepository.getObject(id);
		//to do: fix association attributes
		
		return invalidbeveragemenu.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/beveragemenu/detail")
    public HashMap<String, Object> getinvalidBeverageMenu(VMJExchange vmjExchange){
		return record.getinvalidBeverageMenu(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/beveragemenu/list")
    public List<HashMap<String,Object>> getAllinvalidBeverageMenu(VMJExchange vmjExchange){
		List<invalidBeverageMenu> invalidbeveragemenuList = invalidbeveragemenuRepository.getAllObject("invalidbeveragemenu_impl");
		return transforminvalidBeverageMenuListToHashMap(invalidbeveragemenuList);
	}

    public List<HashMap<String,Object>> transforminvalidBeverageMenuListToHashMap(List<invalidBeverageMenu> invalidBeverageMenuList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < invalidBeverageMenuList.size(); i++) {
            resultList.add(invalidBeverageMenuList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/beveragemenu/delete")
    public List<HashMap<String,Object>> deleteinvalidBeverageMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		invalidbeveragemenuRepository.deleteObject(id);
		return getAllinvalidBeverageMenu(vmjExchange);
	}

	
}
