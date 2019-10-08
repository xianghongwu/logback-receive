package com.xhw.logbackreceive.treetest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Auther: xhw
 * @Date: 2019-09-24 17:22
 * @Description:
 */
public class TreeEntity {
    private Integer id;
    private Integer pid;
    private String name;
    private String fileUrl;
    private boolean isParent;

    public TreeEntity() {
    }


    @JsonProperty("isParent")
    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("pId")
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
