/**
 * 
 */
package com.sbdb.apiTest;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sbdb.constant.CommonConstants;
import com.sbdb.helpers.SBDBCloseApproachDataHelper;
import com.sbdb.model.SBDBClosedApproachData;
import com.sbdb.utility.CommonUtility;

/**
 * @author pmanakar
 *
 */
public class SBDBClosedApproachDataTestSuite {
	SBDBCloseApproachDataHelper sBDBCloseApproachDataHelper = null;
	
	private String distMax;
	
	@BeforeClass
	public void init() {
		System.out.println(" Test started");
		sBDBCloseApproachDataHelper = new SBDBCloseApproachDataHelper();
		
	}
	/**
	 * Purpose: Verify SBDBClosedApproachData API is giving response and response is not null
	 */
	@Test
	public void verifyGetAllSBDBClosedApproachData() {
		SBDBClosedApproachData resonseData = sBDBCloseApproachDataHelper.getAllSBDBClosedApproachData();
		
		System.out.println("This is run on Maven");
		assertNotNull(resonseData.getData().isEmpty(), "Response data is not displayed");
	}
	
	
/*	@Test
	public void verifySBDBResponseDateFilteredWithinDateRange() throws ParseException {
		String startDate = CommonUtility.getPastFutureDate(0, CommonConstants.DATE_FORMAT);
		String endDate = CommonUtility.getPastFutureDate(5, CommonConstants.DATE_FORMAT);
		Date convertedStartDate = CommonUtility.convertStringToDate(startDate,CommonConstants.DATE_FORMAT);
		Date convertedendDate = CommonUtility.convertStringToDate(endDate, CommonConstants.DATE_FORMAT);
		
		SBDBClosedApproachData resonseData = sBDBCloseApproachDataHelper.getAllSBDBClosedApproachDataWithQueryParameter(
				CommonConstants.ASTROID , startDate, endDate, CommonConstants.DIST_MAX);
				
		assertNotNull(resonseData.getData().isEmpty(), "Response data is not displayed");

		List<Date> dateListFromApplication = sBDBCloseApproachDataHelper.getDateListFromResponse(
				CommonConstants.DATE_TIME_FORMAT, resonseData, CommonConstants.DATE_COLUMN, CommonConstants.DATE_COLUMN_NAME);
		
		assertTrue(CommonUtility.verifyListBetweenDatesFromResponse(dateListFromApplication, convertedStartDate, convertedendDate), "Response date is not belong to filtered criteria");
		
	}
	
	*/
	@AfterClass
	public void end() {
		System.out.println("Test end");
	}

}
