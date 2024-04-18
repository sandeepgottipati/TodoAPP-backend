package com.sandeep.TodoApp.HelloWorld;

public class HelloWorldBean {

    private String customMsg;
    public HelloWorldBean(String message){
        this.customMsg=message;
    }
    public String getMessage() {
        return customMsg;
    }
    public void setMessage(String message) {
        this.customMsg = message;
    }

    
    
}