package db;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class CouchDB {
	public void put(String db, String id, String content) throws IOException, ClientProtocolException {
		//CouchDB URL
		String url = "http://127.0.0.1:5984/"  + db + "/" + id;
		
		// create HTTP Client 
		HttpClient httpClient = HttpClientBuilder.create().build();
		// Create new putRequest
		HttpPut putRequest = new HttpPut(url);
		putRequest.setEntity(new StringEntity(content));
		
		// Execute your request and catch response
		HttpResponse response = httpClient.execute(putRequest);
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		System.out.println("Response: " + responseString);
	}
}
