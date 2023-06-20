package com.serand.assignment.model;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "candidates")
public class Candidate {
    @Id
    private String id;
    private String name;
    private List<Job> jobsApplied;
    private String candidates;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCandidates() {
		return candidates;
	}

	public void setCandidates(String candidates) {
		this.candidates = candidates;
	}

	public List<Job> getJobsApplied() {
		return jobsApplied;
	}

	public void setJobsApplied(List<Job> jobsApplied) {
		this.jobsApplied = jobsApplied;
	}
    
}
