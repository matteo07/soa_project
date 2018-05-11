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
	public void put(String id, String db, String content) throws IOException, ClientProtocolException {
		String url = "http://127.0.0.1:5984/";
		// create HTTP Client 
		HttpClient httpClient = HttpClientBuilder.create().build();
		// Create new getRequest with below mentioned URL
		HttpPut getRequest = new HttpPut(url + db + "/" + id);
		getRequest.setEntity(new StringEntity(content));
		
		// Execute your request and catch response
		HttpResponse response = httpClient.execute(getRequest);
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		System.out.println("Response: " + responseString);
	}
}
