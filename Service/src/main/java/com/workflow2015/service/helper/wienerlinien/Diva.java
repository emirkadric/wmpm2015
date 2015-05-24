package com.workflow2015.service.helper.wienerlinien;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class Diva implements Serializable {

    @Expose
    private String branch;
    @Expose
    private String line;
    @Expose
    private String supplement;
    @Expose
    private String dir;
    @Expose
    private String project;
    @Expose
    private String network;
    @Expose
    private String stateless;
    @Expose
    private String operator;
    @Expose
    private String opCode;

    /**
     * @return The branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @param branch The branch
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * @return The line
     */
    public String getLine() {
        return line;
    }

    /**
     * @param line The line
     */
    public void setLine(String line) {
        this.line = line;
    }

    /**
     * @return The supplement
     */
    public String getSupplement() {
        return supplement;
    }

    /**
     * @param supplement The supplement
     */
    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }

    /**
     * @return The dir
     */
    public String getDir() {
        return dir;
    }

    /**
     * @param dir The dir
     */
    public void setDir(String dir) {
        this.dir = dir;
    }

    /**
     * @return The project
     */
    public String getProject() {
        return project;
    }

    /**
     * @param project The project
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * @return The network
     */
    public String getNetwork() {
        return network;
    }

    /**
     * @param network The network
     */
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * @return The stateless
     */
    public String getStateless() {
        return stateless;
    }

    /**
     * @param stateless The stateless
     */
    public void setStateless(String stateless) {
        this.stateless = stateless;
    }

    /**
     * @return The operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator The operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return The opCode
     */
    public String getOpCode() {
        return opCode;
    }

    /**
     * @param opCode The opCode
     */
    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

}
