package com.example.MyOwnMP3.Common;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

@NoArgsConstructor
public class MessageResponseBody {
    @Autowired
    MessageSource messageSource;

    public MessageResponseBody(String MsgCode, String error){
        messageSource.getMessage("MsgCode", null, Locale.getDefault());
    }

}
