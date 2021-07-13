package com.he.wordgame.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WordArray {

    @JsonProperty("words")
    @NotNull
    @NotEmpty
    private List<String> wordsList;

}
