/**
 * 
 */
package com.sbdb.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sbdb.constant.SBDBClosedApproachDataEndpoints;
import com.sbdb.model.SBDBClosedApproachData;
import com.sbdb.utility.SBDBClosedApproachDataConfigManager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * @author Prashant Manakar
 *
 */
public class SBDBCloseApproachDataHelper {
	/**
	 * The base URI that's used by REST assured when making requests if a non-fully qualified URI is used in the request.
	 * Default value is {@value #DEFAULT_URI}.
	 */
	private static final String BASE_URL = SBDBClosedApproachDataConfigManager.getInstance( ).getString("base_url");

	/**
	 * The port that's used by REST assured when it's left out of the specified URI when making a request.
	 * Default port will evaluate to {@value #DEFAULT_PORT}.
	 */
	private static final String PORT = SBDBClosedApproachDataConfigManager.getInstance( ).getString("port");

	private RestAssured restAssured;

	/**
	 * SBDBCloseApproachDataHelper is constructor is used to assign the BASE_URL and PORT of application to perform next actions
	 * 
	 * Use relaxed HTTP validation with protocol {@value #SSL}. This means that you'll trust all hosts regardless if the SSL certificate is invalid. By using this
	 * method you don't need to specify a keystore (see {@link #keyStore(String, String)} or trust store (see {@link #trustStore(java.security.KeyStore)}.
	 *
	 * 
	 */
	public SBDBCloseApproachDataHelper() {
		RestAssured.baseURI = BASE_URL;
	}


	/**
	 * 
	 * This method will hit the get request and return the entire POJO response
	 * 
	 * @return SBDBClosedApproachData
	 */
	public SBDBClosedApproachData getAllSBDBClosedApproachData() {

		/*
		 * Hit GET request by using RestAssured with below end-points
		 */
		Response response = RestAssured
				.given( ).log( ).all( )
				.contentType(ContentType.JSON)
				.get(SBDBClosedApproachDataEndpoints.GET_ALL_SBDB_CLOSED_APPROACH_RESPONSE)
				.andReturn();

		/**
		 * Convert the entire JSON resonse to POJO objects 
		 */
		return convertJSONResponseToPOJOResponse(response);

	}


	/**
	 * 
	 * This method will hit the get request and return the entire POJO response
	 * 
	 * @return SBDBClosedApproachData
	 */
	public SBDBClosedApproachData getAllSBDBClosedApproachDataWithQueryParameter(
			String asteroid, String startDate,String endDate,String distMax) {

		/*
		 * Hit GET request by using RestAssured with below end-points
		 */
		Response response = RestAssured
				.given( ).log().all().
			//	queryParam("des", asteroid).
				queryParam("date-min", startDate).
				queryParam("date-max", endDate).
				queryParam("dist-max", distMax)
				.contentType(ContentType.JSON)
				.get(SBDBClosedApproachDataEndpoints.GET_ALL_SBDB_CLOSED_APPROACH_RESPONSE)
				.andReturn( );

		/**
		 * Convert the entire JSON resonse to POJO objects 
		 */
		return convertJSONResponseToPOJOResponse(response);

	}



	/**
	 * Method to convert Response objects to POJO Objects 
	 * @param response
	 * @return SBDBClosedApproachData object
	 */
	public SBDBClosedApproachData convertJSONResponseToPOJOResponse(Response response) {
		return response.as(new TypeReference<SBDBClosedApproachData>( ) {
		}.getType( ));
	}

	/**
	 * This method will take as SBDBClosedApproachData entire response and return dates List
	 * 
	 * @param format
	 * @param sBDBClosedApproachDataObject
	 * @param column
	 * @param columnName
	 * @return List<Date>
	 */
	public List<Date> getDateListFromResponse(String format,SBDBClosedApproachData sBDBClosedApproachDataObject,int column,String columnName) {
		//	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd HH:mm");
		/**
		 * SimpleDateFormat object to parse String JSON response to Date 
		 */
		SimpleDateFormat formatter = new SimpleDateFormat(format);

		/**
		 * Date lists to store the parsed String 
		 */
		List<Date> datesList = new ArrayList<Date>();
		/*
		 * Iterate through the All records with specified column
		 */

		sBDBClosedApproachDataObject.getData().forEach(x-> {
			/**
			 * Condition to verify the MApping of Data column to Fields column mapping
			 * //TODO We will created seperate API of Fields mapping to Data colum in later phase
			 */
			if(sBDBClosedApproachDataObject.getFields().get(column).equals(columnName)){
				try {
					datesList.add(formatter.parse(x.get(column)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		return datesList;
	}

	/**
	 * This method will take as SBDBClosedApproachData entire response and return dates List
	 * 
	 * @param format
	 * @param sBDBClosedApproachDataObject
	 * @param column
	 * @param columnName
	 * @return List<String>
	 */
	public List<String> getDateListFromResponse(SBDBClosedApproachData sBDBClosedApproachDataObject,int column,String columnName) {
		/**
		 * Date lists to store the parsed String 
		 */
		List<String> valueList = new ArrayList<String>();
		/*
		 * Iterate through the All records with specified column
		 */

		sBDBClosedApproachDataObject.getData().forEach(x-> {
			/**
			 * Condition to verify the Mapping of Data column to Fields column mapping
			 * //TODO We will created separate API of Fields mapping to Data column in later phase
			 */
			if(sBDBClosedApproachDataObject.getFields().get(column).equals(columnName)){
				valueList.add(x.get(column));}

		});
		return valueList;
	}
	/**
	 * Convert String<>
	 * 
	 * @param stringList
	 * @return List<Double>
	 */
	public List<Double> getDoubleFromStringList(List<String> stringList){
		return stringList.stream().map(Double::parseDouble).collect(Collectors.toList());
	}

}
