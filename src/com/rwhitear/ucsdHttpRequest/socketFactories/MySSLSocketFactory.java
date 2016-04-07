package com.rwhitear.ucsdHttpRequest.socketFactories;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
 
 
/**
 * 
 * An SSL socket factory used to bypass self-signed certificate limitations on web servers. Note
 * that accepting self signed certificates is a security vulnerability and you should therefore
 * know the validity of the server you are connecting to before proceeding.
 * 
 * This code was sourced from:
 * 
 * http://www.javaexample.net/2011/12/23/bypass-self-signed-certificate-on-httpclient/
 * 
 * @author rwhitear@cisco.com
 * 
 * @version 1.0
 *
 */
public class MySSLSocketFactory implements ProtocolSocketFactory {
 
	private TrustManager[] getTrustManager() {
 
		TrustManager[] trustAllCerts = new TrustManager[] {
 
		new X509TrustManager() {
 
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
 
				return null;
 
			}
 
			public void checkClientTrusted(
 
			java.security.cert.X509Certificate[] certs, String authType) {
 
			}
 
			public void checkServerTrusted(
 
			java.security.cert.X509Certificate[] certs, String authType) {
 
			}
 
		}
 
		};
 
		return trustAllCerts;
 
	}
 
	public Socket createSocket(String host, int port) throws IOException,
			UnknownHostException {
 
		TrustManager[] trustAllCerts = getTrustManager();
 
		try {
 
			SSLContext sc = SSLContext.getInstance("SSL");
 
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
 
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());
 
			SocketFactory socketFactory = HttpsURLConnection
					.getDefaultSSLSocketFactory();
 
			return socketFactory.createSocket(host, port);
 
		}
 
		catch (Exception ex) {
 
			throw new UnknownHostException("Problems to connect " + host
					+ ex.toString());
 
		}
 
	}
 
	public Socket createSocket(Socket socket, String host, int port,
			boolean flag) throws IOException, UnknownHostException {
 
		TrustManager[] trustAllCerts = getTrustManager();
 
		try {
 
			SSLContext sc = SSLContext.getInstance("SSL");
 
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
 
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());
 
			SocketFactory socketFactory = HttpsURLConnection
					.getDefaultSSLSocketFactory();
 
			return socketFactory.createSocket(host, port);
 
		}
 
		catch (Exception ex) {
 
			throw new UnknownHostException("Problems to connect " + host
					+ ex.toString());
 
		}
 
	}
 
	public Socket createSocket(String host, int port, InetAddress clientHost,
			int clientPort) throws IOException, UnknownHostException {
 
		TrustManager[] trustAllCerts = getTrustManager();
 
		try {
 
			SSLContext sc = SSLContext.getInstance("SSL");
 
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
 
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());
 
			SocketFactory socketFactory = HttpsURLConnection
					.getDefaultSSLSocketFactory();
 
			return socketFactory.createSocket(host, port, clientHost,
					clientPort);
 
		}
 
		catch (Exception ex) {
 
			throw new UnknownHostException("Problems to connect " + host
					+ ex.toString());
 
		}
 
	}
 
	@Override
	public Socket createSocket(String host, int port, InetAddress localAddress,
			int localPort, HttpConnectionParams arg4) throws IOException,
			UnknownHostException, ConnectTimeoutException {
		TrustManager[] trustAllCerts = getTrustManager();
 
		try {
 
			SSLContext sc = SSLContext.getInstance("SSL");
 
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
 
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());
 
			SocketFactory socketFactory = HttpsURLConnection
					.getDefaultSSLSocketFactory();
 
			return socketFactory.createSocket(host, port);
 
		}
 
		catch (Exception ex) {
 
			throw new UnknownHostException("Problems to connect " + host
					+ ex.toString());
 
		}
 
	}
 
}
