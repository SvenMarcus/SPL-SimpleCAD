package de.tu_bs.cs.isf.spl.simplecad.core.input; 

import java.util.HashMap; 
import java.util.Map; 

public  class  MouseInputHandler {
	


    private Map<String, ButtonCommand> buttonClickPolicies = new HashMap<String, ButtonCommand>();

	
    private Map<String, DragAndDropCommand> buttonDragPolicies = new HashMap<String, DragAndDropCommand>();

	
    private boolean dragging;

	

    public MouseInputHandler() {
    }

	

    public void registerClickPolicy(String buttonId, ButtonCommand policy) {
        buttonClickPolicies.put(buttonId, policy);
    }

	

    public void registerDragAndDropPolicy(String buttonId, DragAndDropCommand policy) {
        buttonDragPolicies.put(buttonId, policy);
    }

	

    public void click(int x, int y, String buttonId) {
        getCommand(buttonClickPolicies, buttonId).execute(x, y);
    }

	

    public void drag(int x, int y, String buttonId) {
        getDragAndDropCommand(buttonId).drag(x, y);
        dragging = true;
    }

	

    public void release(int x, int y, String buttonId) {
        if (dragging) {
            dragging = false;
            getDragAndDropCommand(buttonId).drop(x, y);
        }
    }

	

    private ButtonCommand getCommand(Map<String, ButtonCommand> map, String buttonId) {
        ButtonCommand policy = map.get(buttonId);
        if (policy == null)
            return new NullButtonCommand();
        return policy;
    }

	

    private DragAndDropCommand getDragAndDropCommand(String buttonId) {
        DragAndDropCommand policy = buttonDragPolicies.get(buttonId);
        if (policy == null)
            return new NullDragAndDropCommand();
        return policy;
    }


}
