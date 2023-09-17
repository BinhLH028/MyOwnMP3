package com.example.MyOwnMP3.Common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Const {

    public  static String LOCAL_MAIL_LINK = "http://localhost:8080/API/AppUser/confirm?token=";
    public  static String SERVER_MAIL_LINK = "https://myownmp3.onrender.com/API/AppUser/confirm?token=";

    public static String REGEX_PATTERN = "^(.+)@(\\S+)$";

    //region Database
    public static String DB_USERNAME;
    public static String DB_PASSWORD;
    @Value("$spring.datasource.username")
    public void setDbUsername(String dbUsername) {
        DB_USERNAME = dbUsername;
    }
    @Value("${spring.datasource.password}")
    public void setDbPassword(String dbPassword) {
        DB_PASSWORD = dbPassword;
    }
    //endregion

    //region FTP
    public static String FTP_ADDRESS;
    public static String DATABASE_NAME;
    public static String FTP_PW;
    public static String FTP_MUSIC_DIR;
    public static String MUSIC_DIR;

    @Value("${FTP_ADDRESS}")
    public void setFtpAddress(String ftpAddress) {
        FTP_ADDRESS = ftpAddress;
    }
    @Value("${DATABASE_NAME}")
    public void setDatabaseName(String databaseName) {
        DATABASE_NAME = databaseName;
    }
    @Value("${FTP_PW}")
    public void setFtpPw(String ftpPw) {
        FTP_PW = ftpPw;
    }
    @Value("${FTP_MUSIC_DIR}")
    public void setFtpMusicDir(String ftpMusicDir) {
        FTP_MUSIC_DIR = ftpMusicDir;
    }
    @Value("${MUSIC_DIR}")
    public void setMusicDir(String musicDir) {
        MUSIC_DIR = musicDir;
    }
    //endregion

    //region Mail

    //endregion
}
