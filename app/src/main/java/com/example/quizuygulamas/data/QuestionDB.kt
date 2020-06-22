package com.example.quizuygulamas.data

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.quizuygulamas.model.Question

@Database(entities = arrayOf(Question::class),version = 1)
abstract class QuestionDB :RoomDatabase(){
    abstract fun questionDao():QuestionDao

    companion object{
        @Volatile
        var instance:QuestionDB? = null

        @Synchronized
        fun getInstance(context: Context):QuestionDB{
            if(instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuestionDB::class.java,
                    "question_db"
                )   .addCallback(roomDBCallback)
                    .build()
            }
            return  instance as QuestionDB
        }

        private val roomDBCallback = object :RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateAsyncTask(instance).execute()

            }
        }

        class PopulateAsyncTask(private val db: QuestionDB?):AsyncTask<Void,Void,Void> () {
            private val dao: QuestionDao? by lazy{ db?.questionDao()}
            override fun doInBackground(vararg params: Void?): Void? {

                    var question = Question(
                        question = "deneme",
                        optionA = "1",
                        optionB = "2",
                        optionC = "3",
                        answer = "2"
                    )
                   dao?.addQuestion(question)
                question = Question(
                    question = "deneme2",
                    optionA = "1",
                    optionB = "2",
                    optionC = "3",
                    answer = "1"
                )
                dao?.addQuestion(question)
                question = Question(
                    question = "deneme3",
                    optionA = "1",
                    optionB = "2",
                    optionC = "3",
                    answer = "3"
                )
                dao?.addQuestion(question)
                return null
            }

        }

    }
}
