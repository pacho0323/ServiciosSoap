package steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import models.Usuario;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import questions.ElMensajeDe;
import tasks.EnviarMensaje;

public class StepServicioSoap {

	@Before
	public void set_the_stage() {
		OnStage.setTheStage(new OnlineCast());
		
	}
	@Dado("^que el usuario ingrese la url del servicio (.*)$")
	public void queElUsuarioIngreseLaUrlDelServicioHttpEpsappslabSuramericanaComEpsSuraWSServices(String url)  {
	    // Write code here that turns the phrase above into concrete actions
		theActorCalled("juan").whoCan(CallAnApi.at(url));
	}


	@Cuando("^ingrese el mensaje con los datos$")
	public void ingreseElMensajeConLosDatos(List <Usuario> usuario) {
	    // Write code here that turns the phrase above into concrete actions
		theActorInTheSpotlight().attemptsTo(EnviarMensaje.post(usuario.get(0)));
	}

	@Entonces("^verá el código de respuesta (\\d+)$")
	public void veráElCódigoDeRespuesta(int codigo) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(SerenityRest.lastResponse().prettyPrint());
		theActorInTheSpotlight().should(seeThat(ElMensajeDe.deRespuestaEs(),equalTo(codigo)));
	}


}
