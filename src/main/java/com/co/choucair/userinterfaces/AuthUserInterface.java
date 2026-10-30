package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class AuthUserInterface {

    private AuthUserInterface() {
        throw new UnsupportedOperationException("Utility user interface class - cannot be instantiated");
    }

    // Menú superior
    public static final Target BTN_SIGNUP_MENU = Target.the("botón de registro en el menú").located(By.id("signin2"));
    public static final Target BTN_LOGIN_MENU = Target.the("botón de inicio de sesión en el menú").located(By.id("login2"));

    // Formulario de Registro
    public static final Target TXT_SIGNUP_USERNAME = Target.the("campo de usuario para registro").located(By.id("sign-username"));
    public static final Target TXT_SIGNUP_PASSWORD = Target.the("campo de contraseña para registro").located(By.id("sign-password"));
    public static final Target BTN_SIGNUP_SUBMIT = Target.the("botón de enviar registro").located(By.xpath("//button[contains(text(),'Sign up')]"));

    // Formulario de Login
    public static final Target TXT_LOGIN_USERNAME = Target.the("campo de usuario para login").located(By.id("loginusername"));
    public static final Target TXT_LOGIN_PASSWORD = Target.the("campo de contraseña para login").located(By.id("loginpassword"));
    public static final Target BTN_LOGIN_SUBMIT = Target.the("botón de enviar login").located(By.xpath("//button[contains(text(),'Log in')]"));

    // Bienvenida
    public static final Target LBL_USER_WELCOME = Target.the("etiqueta de bienvenida del usuario").located(By.id("nameofuser"));
}