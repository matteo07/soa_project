package services;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.FormParam;


@Path("/anagrafica")
public class AnagService {
	@POST
	public Response redirectToQuestion(@FormParam("cf") String cf, @FormParam("tel") String tel) throws URISyntaxException {
		
		return Response.temporaryRedirect(new URI("../questionario.jsp?cf=" + cf + "&tel=" + tel)).build();
	}
}
