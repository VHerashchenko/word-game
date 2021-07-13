package com.he.wordgame.service;

import com.he.wordgame.model.WordArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.stream.Stream;

class WordArrayServiceTest {

    private static WordArrayService wordArrayService;

    @BeforeAll private static void setUp(){
        wordArrayService = new WordArrayService();
    }

    private static Stream<WordArray> dataTest1() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("fish");
        linkedList.add("horse");
        linkedList.add("egg");
        linkedList.add("goose");
        linkedList.add("eagle");
        return Stream.of(new WordArray(linkedList));
    }

    private static Stream<WordArray> dataTest2() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("fish");
        linkedList.add("horse");
        linkedList.add("snake");
        linkedList.add("goose");
        linkedList.add("eagle");
        return Stream.of(new WordArray(linkedList));
    }

    private static Stream<WordArray> dataTest3() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("fish");
        linkedList.add("horse");
        linkedList.add("");
        linkedList.add("goose");
        linkedList.add("eagle");
        return Stream.of(new WordArray(linkedList));
    }

    private static Stream<WordArray> dataTest4() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("");
        linkedList.add("horse");
        linkedList.add("");
        linkedList.add("goose");
        linkedList.add("eagle");
        return Stream.of(new WordArray(linkedList));
    }

    @ParameterizedTest
    @MethodSource("dataTest1")
    void wordGameLogicTest1(WordArray wordArray) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("fish");
        linkedList.add("horse");
        linkedList.add("egg");
        linkedList.add("goose");
        linkedList.add("eagle");

        Assertions.assertEquals(linkedList, wordArrayService.wordGameLogic(wordArray).getWordsList());
    }

    @ParameterizedTest
    @MethodSource("dataTest2")
    void wordGameLogicTest2(WordArray wordArray) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("fish");
        linkedList.add("horse");

        Assertions.assertEquals(linkedList, wordArrayService.wordGameLogic(wordArray).getWordsList());
    }

    @ParameterizedTest
    @MethodSource("dataTest3")
    void wordGameLogicTest3(WordArray wordArray) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("fish");
        linkedList.add("horse");

        Assertions.assertEquals(linkedList, wordArrayService.wordGameLogic(wordArray).getWordsList());
    }

    @ParameterizedTest
    @MethodSource("dataTest4")
    void wordGameLogicTest4(WordArray wordArray) {
        LinkedList<String> linkedList = new LinkedList<>();

        Assertions.assertEquals(linkedList, wordArrayService.wordGameLogic(wordArray).getWordsList());
    }
}