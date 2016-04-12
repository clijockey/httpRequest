package main;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.rwhitear.ucsdHttpRequest.UCSDHttpRequest;
import com.rwhitear.ucsdHttpRequest.constants.HttpRequestConstants;

public class TestMain {

	public static void main(String[] args) throws HttpException, IOException {
		
		//UCSDHttpRequest request = new UCSDHttpRequest("10.113.89.25","https", 5392);
		UCSDHttpRequest request = new UCSDHttpRequest("api.ciscospark.com","https", 443);
		
		//System.setProperty("https.protocols", "TLSv1.1");
		
		request.addContentTypeHeader(HttpRequestConstants.CONTENT_TYPE_JSON);
		//request.setProxyServer("proxy.esl.cisco.com");
		//request.setProxyPort(8080);
		
		//request.addRequestHeaders("X-Cloupia-Request-Key", "1234567890");
		//request.setUri("/v1/tokens");
		request.setMethodType("GET");
		//request.setBodyText("{\"data\":{\"username\":\"hacker\",\"password\":\"l3tm3In\"}}");
		
		request.setUri("/v1/people/me");
	    request.addRequestHeaders("Authorization", "Bearer k");
	 
		
		
		request.execute();
		
		
		System.out.println("HTTP Response:\n\n" +request.getHttpResponse());	
		System.out.println("Method Type: " +request.getMethodType());
		System.out.println("Status Code: " +request.getStatusCode());
	}

}
