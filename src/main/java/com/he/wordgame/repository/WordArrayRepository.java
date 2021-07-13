package com.he.wordgame.repository;

import com.he.wordgame.model.WordArray;

import java.util.List;

public interface WordArrayRepository {
    void insertWordArray(WordArray wordArray);

    List<WordArray> selectAllWordArrays();
}
