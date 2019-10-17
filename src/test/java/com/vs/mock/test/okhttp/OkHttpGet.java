package com.vs.mock.test.okhttp;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class OkHttpGet {

	private static final String BASE_URL = "http://localhost:9090" + "/spring-rest";
	
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	
	private OkHttpClient client;
	
	//@Rule
	//public MockWeb mMockWebServer = new MockWebServer();
	
	@Before
    public  void  init(){
        MockitoAnnotations.initMocks(this);
        client =  new OkHttpClient();
    }
	
	@Test
	public void testOkHttpGet() throws IOException{
		Request request = new Request.Builder()
				.url(BASE_URL + "/getdata")
				.build();
		System.out.println(request);
		Call call = client.newCall(request);
		Response response =  call.execute();
		ResponseBody responseBody = response.body();
		System.out.println(response.code() + "44 : "+responseBody.string());
		Assert.assertEquals(response.code(), 200);
	}
	
	@Test
	public void testOkHttpPost() {
		/**RequestBody requestBody = new MultipartBody.Builder()
		        .setType(MultipartBody.FORM)
		        **/
		
		List<Map<Integer,String>> list = new LinkedList<>();
		list.add(new HashMap<Integer, String>(){{put(1,"A"); }});
		list.add(new HashMap<Integer, String>(){{put(2,"B"); }});
		
		        
	}
}
