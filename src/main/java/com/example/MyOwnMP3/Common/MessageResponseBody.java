package com.example.MyOwnMP3.Common;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;


import java.util.Locale;

@NoArgsConstructor
public class MessageResponseBody {

    MessageSource messageSource;
    public MessageResponseBody(String MsgCode, String error){
        messageSource.getMessage(MsgCode, null, Locale.getDefault());
    }



}
