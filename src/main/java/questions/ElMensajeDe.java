package questions;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ElMensajeDe implements Question<Integer>{

	@Override
	public Integer answeredBy(Actor actor) {
		// TODO Auto-generated method stub
		 return lastResponse().getStatusCode();
	}
	public static ElMensajeDe deRespuestaEs() {
		return new ElMensajeDe();
	}
}
