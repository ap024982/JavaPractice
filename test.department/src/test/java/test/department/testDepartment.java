package test.department;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

public class testDepartment {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost postRequest = new HttpPost(
			"http://localhost:8080/createDepartment/");

		StringEntity input = new StringEntity("{\"ID\":80,\"name\":\"System Engineer\",\"location\":\"Hyderabad\"}",
				ContentType.APPLICATION_JSON);
		postRequest.setEntity(input);

		HttpResponse response = httpClient.execute(postRequest);

	}

}
