package com.he.wordgame.repository;

import com.he.wordgame.model.WordArray;

import java.util.List;
import java.util.UUID;

public interface WordArrayRepository {
    void insertWordArray(UUID id, WordArray wordArray);

    default void insertWordArray(WordArray wordArray){
        UUID id = UUID.randomUUID();
        insertWordArray(id, wordArray);
    }

    List<WordArray> selectAllWordArrays();
}
