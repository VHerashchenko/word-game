package com.he.wordgame.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Getter
public class WordArray {
    @JsonProperty("id")
    private final UUID id;

    @JsonProperty("words")
    private List<String> words;

    public void setWords(List<String> words){
        this.words = words;
    }
}
