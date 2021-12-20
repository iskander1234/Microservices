package com.example.mailsender.emailRequest;


import com.example.mailsender.MessageType;

import java.util.Date;
import java.util.List;

public class EmailSendRequest {
    private MessageType messageType;
    private List<String> conversionMultipleList;
    private List<String> emailList;
    private String value;
    private Date date;

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<String> emailList) {
        this.emailList = emailList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getConversionMultipleList() {
        return conversionMultipleList;
    }

    public void setConversionMultipleList(List<String> railcarList) {
        this.conversionMultipleList = railcarList;
    }

    public String getValue() {
        if( value != null && !"".equals(value) ){
            return value;
        } else {
            return "";
        }
    }

    public void setValue(String value) {
        this.value = value;
    }
}
