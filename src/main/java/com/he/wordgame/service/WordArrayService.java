package com.he.wordgame.service;

import com.he.wordgame.model.WordArray;
import com.he.wordgame.repository.WordArrayRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Service
@NoArgsConstructor
public class WordArrayService {
    private WordArrayRepository wordArrayRepository;

    @Autowired
    public WordArrayService(WordArrayRepository wordArrayRepository) {
        this.wordArrayRepository = wordArrayRepository;
    }

    public void addWordArray(WordArray wordArray){
        wordArrayRepository.insertWordArray(wordGameLogic(wordArray));
    }

    public List<WordArray> getAllWordArrays(){
        return wordArrayRepository.selectAllWordArrays();
    }

    public WordArray wordGameLogic(WordArray wordArray){
    List<String> uncheckedList = wordArray.getWordsList();

    List<String> correctList = new LinkedList<>();

    if(!uncheckedList.get(0).equals("")) {

        correctList.add(uncheckedList.get(0).toLowerCase(Locale.ROOT));

        for (int i = 0; i < uncheckedList.size() - 1; ++i) {
            String firstChecked = uncheckedList.get(i).toLowerCase(Locale.ROOT);
            String secondChecked = uncheckedList.get(i + 1);

            if(secondChecked.equals("")){
                break;
            }
            else
                secondChecked = secondChecked.toLowerCase(Locale.ROOT);

            if (firstChecked.charAt(firstChecked.length() - 1) == secondChecked.charAt(0)) {
                correctList.add(secondChecked);
            }
            else
                break;
        }
    }
        wordArray.setWordsList(correctList);
        return wordArray;
    }
}
