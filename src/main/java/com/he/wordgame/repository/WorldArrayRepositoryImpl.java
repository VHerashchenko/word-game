package com.he.wordgame.repository;

import com.he.wordgame.model.WordArray;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("wordRepo")
public class WorldArrayRepositoryImpl implements WordArrayRepository{

   private static final List<WordArray> DB = new ArrayList<>();

    @Override
    public void insertWordArray(UUID id, WordArray wordArray) {
        DB.add(new WordArray(id, wordArray.getWords()));
    }

    @Override
    public List<WordArray> selectAllWordArrays() {
        return DB;
    }

}
