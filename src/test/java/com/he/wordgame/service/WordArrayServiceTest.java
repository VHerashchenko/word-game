package com.he.wordgame.service;

import com.he.wordgame.model.WordArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class WordArrayServiceTest {

    private WordArrayService wordArrayService = new WordArrayService();

    private static Stream<Arguments> dataTest() {
        List<String> l1 = List.of("fish", "horse", "egg", "goose", "eagle");
        List<String> eL1 = List.of("fish", "horse", "egg", "goose", "eagle");

        List<String> l2 = List.of("fish", "horse", "snake", "goose", "eagle");
        List<String> eL2 = List.of("fish", "horse");

        List<String> l3 = List.of("fish", "horse", "", "goose", "eagle");
        List<String> eL3 = List.of("fish", "horse");

        List<String> l4 = List.of("", "horse", "", "goose", "eagle");
        List<String> eL4 = Collections.emptyList();

        return Stream.of(
                Arguments.of(new WordArray(l1), new WordArray(eL1)),
                Arguments.of(new WordArray(l2), new WordArray(eL2)),
                Arguments.of(new WordArray(l3), new WordArray(eL3)),
                Arguments.of(new WordArray(l4), new WordArray(eL4)));
    }

    @ParameterizedTest
    @MethodSource("dataTest")
    void wordGameLogicTest1(WordArray wordArray, WordArray expectedWordArray) {
        Assertions.assertEquals(expectedWordArray.getWordsList(),
                wordArrayService.wordGameLogic(wordArray).getWordsList());
    }

}