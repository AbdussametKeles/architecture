package com.example.quizuygulamas.ui.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.quizuygulamas.R

class QuizActivity : AppCompatActivity() {

    private lateinit var viewModel: QuizViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        viewModel.allQuestion.observe(this, Observer {

        })
    }
}