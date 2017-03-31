package demo.workflow;

import demo.page.HasMainNavigation;


public class LoginFlow {

    private final HasMainNavigation hasMainNavigation;

    public LoginFlow(HasMainNavigation hasMainNavigation) {
        this.hasMainNavigation = hasMainNavigation;
    }

    public void login(String customerUsername, String customerPassword) {

    }
}
