package com.he.wordgame.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WordArray {

    @JsonProperty("words")
    @NotNull
    @NotEmpty
    private LinkedList<String> wordsList;

    public void setWords(LinkedList<String> wordsList){
        this.wordsList = wordsList;
    }
}
