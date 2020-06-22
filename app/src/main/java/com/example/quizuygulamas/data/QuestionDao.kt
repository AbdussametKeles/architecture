package com.example.quizuygulamas.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quizuygulamas.model.Question

@Dao
interface QuestionDao {
    @Query("SELECT * FROM question")
    fun getAllQuestions():LiveData<List<Question>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addQuestion(question: Question)

    @Query("DELETE FROM question")
    fun deleteAll()

}