package com.co.choucair.questions;

import com.co.choucair.userinterfaces.AuthUserInterface;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public final class LoginQuestion {

    private LoginQuestion() {
        throw new UnsupportedOperationException("Utility question class - cannot be instantiated");
    }

    public static Question<String> displayedUsername() {
        return Question.about("el texto del usuario conectado en la barra de navegación")
                .answeredBy(actor -> Text.of(AuthUserInterface.LBL_USER_WELCOME).answeredBy(actor));
    }
}