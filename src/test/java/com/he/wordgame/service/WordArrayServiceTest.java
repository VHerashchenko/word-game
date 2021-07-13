package com.he.wordgame.service;

import com.he.wordgame.model.WordArray;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class WordArrayServiceTest {

    public WordArrayService wordArrayService;

    public WordArray wordArray;

    public UUID id = UUID.randomUUID();

    @Test
    public void wordGameLogicTestAllGood() {
        List<String> testList = Arrays.asList("fish", "horse", "egg", "goose", "eagle");
        wordArray = new WordArray(id, testList);

        WordArray wordArrayChecked = wordArrayService.wordGameLogic(wordArray);

        List<String> actual = wordArrayChecked.getWords();
        List<String> expected = Arrays.asList("fish", "horse", "egg", "goose", "eagle");

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void wordGameLogicTestNotAllCorrect(){
        List<String> testList = Arrays.asList("fish", "horse", "snake", "goose", "eagle");
        wordArray = new WordArray(id, testList);

        WordArray wordArrayChecked = wordArrayService.wordGameLogic(wordArray);

        List<String> actual = wordArrayChecked.getWords();
        List<String> expected = Arrays.asList("fish", "horse");

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void wordGameLogicTestMissingWordCenter(){
        List<String> testList = Arrays.asList("fish", "horse", "", "goose", "eagle");
        wordArray = new WordArray(id, testList);

        WordArray wordArrayChecked = wordArrayService.wordGameLogic(wordArray);

        List<String> actual = wordArrayChecked.getWords();
        List<String> expected = Arrays.asList("fish", "horse");

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void wordGameLogicTestMissingWordBeginning(){
        List<String> testList = Arrays.asList("", "horse", "", "goose", "eagle");
        wordArray = new WordArray(id, testList);

        WordArray wordArrayChecked = wordArrayService.wordGameLogic(wordArray);

        List<String> actual = wordArrayChecked.getWords();
        List<String> expected = new ArrayList<>();

        Assert.assertEquals(actual, expected);
    }

}
