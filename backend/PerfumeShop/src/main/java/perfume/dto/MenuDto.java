package perfume.dto;

import java.util.List;

import perfume.entity.ChildMenu;
import perfume.entity.ParentMenu;

public class MenuDto extends ParentMenu {
	List<ChildMenu> listChild ;

	public List<ChildMenu> getListChild() {
		return listChild;
	}

	public void setListChild(List<ChildMenu> listChild) {
		this.listChild = listChild;
	}
	
	
}
