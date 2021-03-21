/**
 * 
 */
package com.sbdb.constant;

/**
 * This class is created the handle End points in API. 
 * Changes in one place will effect in entire suite.
 * End points are static also we can pass dynamic variable at time of test suite creation.
 * 
 * @author Prashant Manakar
 *
 */
public class SBDBClosedApproachDataEndpoints {
	/**
	 * GET_ALL_SBDB_CLOSED_APPROACH_RESPONSE this end point is used retrieve all response from request 
	 */
	public static final String GET_ALL_SBDB_CLOSED_APPROACH_RESPONSE = "/cad.api";
	
	/**
	 * GET_ASTROID_RESPONSE_BY_FILTERED_DATE  
	 * 
	 * get all close-approach data for 
	 * asteroid {asteroid}  Eros within {distMax} between {dateMin} and {dateMax}
	 * {asteroid}  We are passing dynamic value to this API from test 
	 * {dateMin} exclude data earlier than this date YYYY-MM-DD or date/time YYYY-MM-DDThh:mm:ss or now for the current date
	
	 * {distMax} exclude data later than this date YYYY-MM-DD or date/time YYYY-MM-DDThh:mm:ss or now for the current date or +D for “D” days after now 
	 * 
	 */
	public static final String GET_ASTROID_RESPONSE_BY_FILTERED_DATE = 
			"/cad.api?des={asteroid}&date-min={dateMin}&date-max={dateMax}&dist-max={distMax}";
	
	/** GET_NEO_LUNARS_RESPONSE_BY_FILTERED_DATE
	 * 
	 * {distMax} exclude data with an approach distance greater than this (see dist-min)
	 *  
	 * {dateMin} exclude data earlier than this date YYYY-MM-DD or date/time YYYY-MM-DDThh:mm:ss or now for the current date
	 */
	public static final String GET_NEO_LUNARS_RESPONSE_BY_FILTERED_DATE =
			"/cad.api?dist-max={distMax}&date-min={dateMin}&sort=dist";


}
