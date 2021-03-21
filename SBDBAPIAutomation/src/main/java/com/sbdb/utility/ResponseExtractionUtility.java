/**
 * 
 */
package com.sbdb.utility;

import java.util.List;

import io.restassured.response.Response;

/**
 * @author Prashant Manakar
 *
 */
public class ResponseExtractionUtility {
	/**
	 * 
	 */
	Response response = null;
	/**
	 * 
	 * @param responseFromApp
	 */
	public ResponseExtractionUtility(Response responseFromApp){
		this.response = responseFromApp;
		
	}
	/**
	 * 
	 * @param field
	 * @return
	 */
	public String getResponseAsString(String field) {
		return response.path(field).toString();
	}
	/**
	 * 
	 * @param field
	 * @return
	 */
	public List<String> getResponseAsList(String field) {
		return response.path(field);
	}

}
