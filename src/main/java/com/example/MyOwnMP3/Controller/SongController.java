package com.example.MyOwnMP3.Controller;

import com.example.MyOwnMP3.Common.Const;
import com.example.MyOwnMP3.Common.MessageResponseBody;
import com.example.MyOwnMP3.Service.SongService;
import com.example.MyOwnMP3.Validator.AudioFileValidator;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value = "/API/song")
public class SongController {

    @Autowired
    private SongService songService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    private AudioFileValidator audioFileValidator;
    @GetMapping(value = "/getallsong")
    public ResponseEntity<?> GetAllSong() {
        return new ResponseEntity<>(songService.GetAllSong(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> GetSongsByName(@RequestParam String n){
        try{
            return new ResponseEntity<>(songService.GetSongsByName(n), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {


        String FTP_ADDRESS = Const.FPT_ADDRESS;
        String LOGIN = Const.DATABASE_NAME;
        String PSW = Const.FPT_PW;
        String PATH = Const.FPT_MUSIC_DIR + file.getOriginalFilename();

        FTPClient con = null;

        try {
            con = new FTPClient();
            con.connect(FTP_ADDRESS);

            if (con.login(LOGIN, PSW)) {
                con.enterLocalPassiveMode(); // important!
                con.setFileType(FTP.BINARY_FILE_TYPE);

                // Upload file to storage
                boolean result = con.storeFile(PATH, file.getInputStream());
                con.logout();
                con.disconnect();
                redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded " + file.getOriginalFilename() + "!");

                // Store the file url to database
                songService.HandleUploadSong(file.getOriginalFilename());
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message",
                    "Could not upload " + file.getOriginalFilename() + "!");
        }

        return "redirect:/";
    }

    @PostMapping("/upload")
    public ResponseEntity<?> handleMultipleFileUpload(@RequestParam("lstSongs") List<MultipartFile> lstSongs,
                                           RedirectAttributes redirectAttributes) throws MultipartException {
        String FTP_ADDRESS = Const.FPT_ADDRESS;
        String LOGIN = Const.DATABASE_NAME;
        String PSW = Const.FPT_PW;
        try {
            if (!audioFileValidator.IsValidContentType(lstSongs)) {
                throw new MultipartException("Invalid content type");
            }
        } catch (MultipartException e) {
            return new ResponseEntity<>(messageSource.getMessage("01", null, Locale.getDefault()),
                    HttpStatus.BAD_REQUEST);
        }


        FTPClient con = null;

        try {
            con = new FTPClient();
            con.connect(FTP_ADDRESS);

            if (con.login(LOGIN, PSW)) {
                con.enterLocalPassiveMode(); // important!
                con.setFileType(FTP.BINARY_FILE_TYPE);

                // Upload file to storage
                for (MultipartFile song:lstSongs) {
                    String MUSIC_PATH = Const.FPT_MUSIC_DIR + song.getOriginalFilename();
                    boolean result = con.storeFile(MUSIC_PATH, song.getInputStream());
                }
                con.logout();
                con.disconnect();
                // Store the file url to database
                songService.HandleUploadMultipleSong(lstSongs);
            }
        } catch (Exception e) {}
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
