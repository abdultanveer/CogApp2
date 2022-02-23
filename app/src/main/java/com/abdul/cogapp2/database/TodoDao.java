package com.abdul.cogapp2.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TodoDao {

   @Insert
   void insert(Todo todo);

  /* @Update
   public void updateWords(Word... words);*/

  /* @Query("DELETE FROM word_table")
   void deleteAll();

   @Query("SELECT * from word_table ORDER BY word ASC")
   List<Word> getAllWords();

   @Query("SELECT * FROM word_table WHERE word LIKE :word ")
   public List<Word> findWord(String word);*/

} 
