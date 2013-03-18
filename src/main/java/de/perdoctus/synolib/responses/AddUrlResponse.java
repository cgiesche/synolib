package de.perdoctus.synolib.responses;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * User: cgiesche
 * Date: 2/24/12
 * Time: 4:03 PM
 */
public class AddUrlResponse extends DownloadRedirectorResponse {
	
	@JsonProperty("task_error_limit")
	private String taskErrorLimit;
	
	public String getTaskErrorLimit() {
		return taskErrorLimit;
	}
	
	public void setTaskErrorLimit(String taskErrorLimit) {
		this.taskErrorLimit = taskErrorLimit;
	}
}
