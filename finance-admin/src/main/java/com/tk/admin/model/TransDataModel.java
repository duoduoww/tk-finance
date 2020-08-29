package com.tk.admin.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @program: tk-finance
 * @description:
 * @author: kzc
 * @create: 2020-08-29 15:28
 **/
public class TransDataModel {

    @ApiModelProperty(value = "标题", required = true)
    public String title;
    @ApiModelProperty(value = "内容", required = true)
    public String content;
    @ApiModelProperty(value = "类型", required = true)
    public String type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TransDataModel [title=" + title + ", content=" + content + ", type=" + type + "]";
    }

}
