package com.example.MyOwnMP3.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputArtistInfoDTO {

    private String artist_name;
    private Integer age;
    private Integer gender;
}
