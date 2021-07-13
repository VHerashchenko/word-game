package com.he.wordgame.controllers;

import com.he.wordgame.model.WordArray;
import com.he.wordgame.service.WordArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/word-array")
@RestController
public class WordArrayController {

    private final WordArrayService wordArrayService;

    @Autowired
    public WordArrayController(WordArrayService wordArrayService) {
        this.wordArrayService = wordArrayService;
    }

    @PostMapping("/create")
    public void addWordArray(@RequestBody WordArray wordArray){
        wordArrayService.addWordArray(wordArray);
    }

    @GetMapping("/all")
    public List<WordArray> getAllWordArrays(){
        return wordArrayService.getAllWordArrays();
    }

}
