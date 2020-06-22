package com.example.quizuygulamas.ui.quiz

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.quizuygulamas.data.QuestionDB
import com.example.quizuygulamas.data.QuestionDao
import com.example.quizuygulamas.model.Question

class QuizRepository (context:Context){
    private val db by lazy {
        QuestionDB.getInstance(context)
    }
    private val dao:QuestionDao = db.questionDao()

    fun getAllQuestion():LiveData<List<Question>>{
       return dao.getAllQuestions()
    }
}