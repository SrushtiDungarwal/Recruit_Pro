package com.jbk.enums;

public enum InterviewStatus {

	    SCHEDULED("Scheduled"),
	    COMPLETED("Completed"),
	    CANCELLED("Cancelled");

	    private final String interviewStatus;

	    // Constructor
	    InterviewStatus(String interviewStatus) {
	        this.interviewStatus = interviewStatus;
	    }

	    // Getter method to retrieve the status value
	    public String getInterviewStatus() {
	        return interviewStatus;
	    }
}
