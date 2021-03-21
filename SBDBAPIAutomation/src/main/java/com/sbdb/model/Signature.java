/**
 * 
 */
package com.sbdb.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author pmanakar
 *
 */
public class Signature {
	@SerializedName("source")
	@Expose
	private String source;
	@SerializedName("version")
	@Expose
	private String version;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
