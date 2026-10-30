package com.co.choucair.tasks;

import com.co.choucair.userinterfaces.AuthUserInterface;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public final class LoginUser {

    private LoginUser() {
        throw new UnsupportedOperationException("Utility task class - cannot be instantiated");
    }

    public static Performable withRememberedCredentials() {
        return Task.where("{0} inicia sesión con las credenciales registradas",
                actor -> {
                    String username = actor.recall("DYNAMIC_USER");
                    String password = actor.recall("DYNAMIC_PASSWORD");

                    actor.attemptsTo(
                            WaitUntil.the(AuthUserInterface.BTN_LOGIN_MENU, isClickable()).forNoMoreThan(5).seconds(),
                            Click.on(AuthUserInterface.BTN_LOGIN_MENU),
                            WaitUntil.the(AuthUserInterface.TXT_LOGIN_USERNAME, isClickable()).forNoMoreThan(5).seconds(),
                            Enter.theValue(username).into(AuthUserInterface.TXT_LOGIN_USERNAME),
                            Enter.theValue(password).into(AuthUserInterface.TXT_LOGIN_PASSWORD),
                            Click.on(AuthUserInterface.BTN_LOGIN_SUBMIT)
                    );
                }
        );
    }
}