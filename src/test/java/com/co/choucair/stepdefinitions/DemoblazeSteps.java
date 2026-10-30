package com.co.choucair.stepdefinitions;

import com.co.choucair.questions.LoginQuestion;
import com.co.choucair.tasks.LoginUser;
import com.co.choucair.tasks.RegisterUser;
import io.cucumber.java.Before; // <-- Importante: Usar el Before de Cucumber
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;

public class DemoblazeSteps {

    @Before // <-- Hook de Cucumber para inicializar el escenario antes de cada prueba
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario");
    }

    @Dado("que el usuario genera un nuevo registro dinámico en Demoblaze")
    public void registrarUsuarioDinamico() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url("https://www.demoblaze.com/"),
                RegisterUser.dynamicallyWithPrefix("coloso", "Password123*")
        );
    }

    @Y("el usuario inicia sesión con la cuenta recién creada")
    public void iniciarSesion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginUser.withRememberedCredentials()
        );
    }

    @Entonces("debería visualizar el mensaje de bienvenida con su usuario")
    public void verificarUsuarioConectado() {
        String expectedUser = OnStage.theActorInTheSpotlight().recall("DYNAMIC_USER");
        OnStage.theActorInTheSpotlight().should(
                seeThat("el usuario logueado en la barra", LoginQuestion.displayedUsername(), containsString(expectedUser))
        );
    }
}