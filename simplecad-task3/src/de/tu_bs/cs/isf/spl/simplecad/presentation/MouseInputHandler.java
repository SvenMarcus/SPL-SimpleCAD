package de.tu_bs.cs.isf.spl.simplecad.presentation;

import de.tu_bs.cs.isf.spl.simplecad.presentation.buttonpolicies.ButtonCommand;

import java.util.HashMap;
import java.util.Map;

public class MouseInputHandler {


    private Map<String, ButtonCommand> buttonPolicies = new HashMap<String, ButtonCommand>();

    public MouseInputHandler() {
    }

    public void registerButtonPolicy(String buttonId, ButtonCommand policy) {
        buttonPolicies.put(buttonId, policy);
    }

    public void click(int x, int y, String buttonId) {
        ButtonCommand policy = buttonPolicies.get(buttonId);
        if (policy != null)
            policy.execute(x, y);
    }

}
