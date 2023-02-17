
package com.proj1.Entities;


public class Message {
    private String content;
    private String type;
    private String cssClass;

    public Message(String content, String type, String cssClass) {
        this.content = content;
        this.type = type;
        this.cssClass = cssClass;
    }
//for getting value of the datamembers
    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }

    public String getCssClass() {
        return cssClass;
    }
    
    //for setting value of the datamembers

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }
    
    
    
}
