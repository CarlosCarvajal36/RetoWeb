package com.co.choucair.tasks;

import com.co.choucair.userinterfaces.AuthUserInterface;
import com.co.choucair.utils.CredentialGenerator;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public final class RegisterUser {

    private RegisterUser() {
        throw new UnsupportedOperationException("Utility task class - cannot be instantiated");
    }

    public static Performable dynamicallyWithPrefix(String prefix, String password) {
        return Task.where("{0} se registra con un usuario dinámico usando el prefijo " + prefix,
                actor -> {
                    String dynamicUsername = CredentialGenerator.generateUniqueUsername(prefix);

                    actor.remember("DYNAMIC_USER", dynamicUsername);
                    actor.remember("DYNAMIC_PASSWORD", password);

                    actor.attemptsTo(
                            WaitUntil.the(AuthUserInterface.BTN_SIGNUP_MENU, isClickable()).forNoMoreThan(5).seconds(),
                            Click.on(AuthUserInterface.BTN_SIGNUP_MENU),
                            WaitUntil.the(AuthUserInterface.TXT_SIGNUP_USERNAME, isClickable()).forNoMoreThan(5).seconds(),
                            Enter.theValue(dynamicUsername).into(AuthUserInterface.TXT_SIGNUP_USERNAME),
                            Enter.theValue(password).into(AuthUserInterface.TXT_SIGNUP_PASSWORD),
                            Click.on(AuthUserInterface.BTN_SIGNUP_SUBMIT),
                            // Pausa controlada para asegurar que la alerta nativa esté disponible
                            Task.where("espera a que aparezca la alerta de registro", a -> {
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                            }),
                            Switch.toAlert().andAccept()
                    );
                }
        );
    }
}