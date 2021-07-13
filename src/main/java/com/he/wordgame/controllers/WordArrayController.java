package com.he.wordgame.controllers;

import com.he.wordgame.model.WordArray;
import com.he.wordgame.service.WordArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/word-array")
@RestController
public class WordArrayController {

    private final WordArrayService wordArrayService;

    @Autowired
    public WordArrayController(WordArrayService wordArrayService) {
        this.wordArrayService = wordArrayService;
    }

    @PostMapping("/create")
    public void addWordArray(@Valid @RequestBody WordArray wordArray){
        wordArrayService.addWordArray(wordArray);
    }

    @GetMapping("/all")
    public List<WordArray> getAllWordArrays(){
        return wordArrayService.getAllWordArrays();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
