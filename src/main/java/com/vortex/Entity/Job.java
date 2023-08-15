package com.vortex.Entity;

public class Job {
    private int jobId;//职位ID
    private String jobName;//职位名称
    private int jobCount;//职位数量
    private int jobForDepartmentId;//职位所属部门
    private String jobInfo;//职位描述

    public Job() {
    }

    public Job(String jobName, int jobCount, int jobForDepartmentId, String jobInfo) {
        this.jobName = jobName;
        this.jobCount = jobCount;
        this.jobForDepartmentId = jobForDepartmentId;
        this.jobInfo = jobInfo;
    }

    public Job(int jobId, String jobName, int jobCount, int jobForDepartmentId, String jobInfo) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobCount = jobCount;
        this.jobForDepartmentId = jobForDepartmentId;
        this.jobInfo = jobInfo;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getJobCount() {
        return jobCount;
    }

    public void setJobCount(int jobCount) {
        this.jobCount = jobCount;
    }

    public int getJobForDepartmentId() {
        return jobForDepartmentId;
    }

    public void setJobForDepartmentId(int jobForDepartmentId) {
        this.jobForDepartmentId = jobForDepartmentId;
    }

    public String getJobInfo() {
        return jobInfo;
    }

    public void setJobInfo(String jobInfo) {
        this.jobInfo = jobInfo;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", jobCount=" + jobCount +
                ", jobForDepartmentId=" + jobForDepartmentId +
                ", jobInfo='" + jobInfo + '\'' +
                '}';
    }
}
