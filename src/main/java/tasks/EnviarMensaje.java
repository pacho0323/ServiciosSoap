package tasks;

import models.Usuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class EnviarMensaje implements Task {
	private String dominio;
	private String tipoDocumento;
	private String documento;


	public EnviarMensaje(Usuario usuario) {
		this.dominio = usuario.getDominio();
		this.tipoDocumento = usuario.getTipoDocumento();
		this.documento = usuario.getDocumento();
	}
	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		actor.attemptsTo(Post.to(dominio).with(request -> request
				.header("Content-Type", "application/soap+xml;charset=UTF-8").accept("application/soap+xml")
				.header("soapaction", "")
				.body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.eps.com\">\r\n"
						+ "   <soapenv:Header/>\r\n" + "   <soapenv:Body>\r\n" + "      <ser:getEmpleador>\r\n"
						+ "         <ser:tipoDocumento>"+tipoDocumento+"</ser:tipoDocumento>\r\n"
						+ "         <ser:numeroDocumento>"+documento+"</ser:numeroDocumento>\r\n"
						+ "      </ser:getEmpleador>\r\n" + "   </soapenv:Body>\r\n" + "</soapenv:Envelope>")));
	}


	public static EnviarMensaje post(Usuario usuario) {
		return Tasks.instrumented(EnviarMensaje.class,usuario);
	}
}
