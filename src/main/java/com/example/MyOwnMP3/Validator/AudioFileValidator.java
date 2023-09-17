package com.example.MyOwnMP3.Validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.executable.ExecutableValidator;
import jakarta.validation.metadata.BeanDescriptor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@Component
public class AudioFileValidator{

    public boolean IsValidContentType(List<MultipartFile> files) {
        boolean isValid = true;
        for (MultipartFile file: files) {
            String contentType = file.getContentType();
            System.out.println(contentType);
            if(!contentType.equals("audio/mpeg")
                && !contentType.equals("audio/mp4")
                && !contentType.equals("audio/m4a")
                && !contentType.equals("audio/x-m4a")
            ) {
                isValid = false;
            }
        }
        System.out.println(isValid);
        return isValid;
    }

}
