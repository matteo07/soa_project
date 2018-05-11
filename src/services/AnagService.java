package services;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import db.CouchDB;

import javax.ws.rs.FormParam;

@Path("/anagrafica")
public class AnagService {
	@POST
	public Response redirectToQuestion(@FormParam("cf") String cf, @FormParam("nome") String nome, @FormParam("cognome") 
			String cognome, @FormParam("data") String data, @FormParam("indirizzo") String indirizzo, @FormParam("tel") 
			String tel) throws URISyntaxException, IOException {
		
		String json = String.format("{" + 
				" \"nome\":\"%s\"," + 
				" \"cognome\":\"%s\"," + 
				" \"data di nascita\": \"%s\"," + 
				" \"indirizzo\":\"%s\"," + 
				" \"numero tel\": \"%s\"" + 
				"}",nome, cognome, data, indirizzo, tel);
		
		CouchDB db = new CouchDB();
		db.put("anagrafica", cf, json);
		
		return Response.temporaryRedirect(new URI("../questionario.jsp?cf=" + cf + "&tel=" + tel)).build();
	}
}
