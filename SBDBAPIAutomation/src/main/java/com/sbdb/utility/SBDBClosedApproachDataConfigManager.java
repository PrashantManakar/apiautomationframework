/**
 * 
 */
package com.sbdb.utility;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Prashant Manakar
 *
 */
public class SBDBClosedApproachDataConfigManager {
	/**
	 * 
	 */
	private static SBDBClosedApproachDataConfigManager manager;
	
	/**
	 * 
	 */

	private static final Properties PROPS = new Properties();
	/**
	 * 
	 */

	private SBDBClosedApproachDataConfigManager() {
		try (InputStream stream = SBDBClosedApproachDataConfigManager.class.getResourceAsStream("/config.properties")) {
			PROPS.load(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
	public static SBDBClosedApproachDataConfigManager getInstance() {
		if (manager == null) {
			synchronized (SBDBClosedApproachDataConfigManager.class) {
				manager = new SBDBClosedApproachDataConfigManager();
			}
		}
		return manager;
	}

	/**
	 * 
	 */
	public String getString(String key) {
		return System.getProperty(key, PROPS.getProperty(key));
	}



}
