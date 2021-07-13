package com.he.wordgame.repository;

import com.he.wordgame.model.WordArray;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WorldArrayRepositoryImpl implements WordArrayRepository{

   private static final List<WordArray> DB = new ArrayList<>();

    @Override
    public void insertWordArray(WordArray wordArray) {
        DB.add(new WordArray(wordArray.getWordsList()));
    }

    @Override
    public List<WordArray> selectAllWordArrays() {
        return DB;
    }

}
