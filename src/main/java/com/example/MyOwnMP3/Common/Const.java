package com.example.MyOwnMP3.Common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Const {


    public static String FTP_ADDRESS = "files.000webhost.com";
    public static String DATABASE_NAME = "musicdb028";

    public static String FTP_PW;
    @Value("${testpw}")
    public void setFptPw(String ftpPw) {
        FTP_PW = ftpPw;
    }

    public static String FTP_MUSIC_DIR = "/public_html/music/";
    public static String MUSIC_DIR = "https://musicdb028.000webhostapp.com/music/";
}
