package com.ganeshadsul.checkyouriq

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ganeshadsul.checkyouriq.databinding.FragmentGameBinding


class GameFragment : Fragment() {

    data class Question(val quest: String, val answers: List<String>)

    private val questions: MutableList<Question> = mutableListOf(
        Question(
            quest = "At a conference, 12 members shook hands with each other before & after the meeting. How many total number of hand shakes occurred?",
            answers = listOf("132", "100", "145", "144", "121")),
        Question(
            quest = "The day after the day after tomorrow is four days before Monday. What day is it today?",
            answers = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")),
        Question(
            quest = "6121135 is to flame as 21215120 is to ?",
            answers = listOf("Bloat", "Voice", "Bald", "Castle", "Steel")),
        Question(
            quest = "Forest is to tree as tree is to ?",
            answers = listOf("Leaf", "Plant", "Branch", "Mangrove ", "Root")),
        Question(
            quest = "Which number is the odd one out?",
            answers = listOf("47632", "84129", "32418", "36119", "67626")),
        Question(
            quest = "There are four boys. Tom is shorter than John. Dave is taller than Tom but shorter than John. James is shorter than John but taller than Dave. Who is shortest?",
            answers = listOf("Tom", "John", "Dave", "James", "None")),
        Question(
            quest = "3 cats, 2 parrots, 1 cow are put together. How many legs will be there in all?",
            answers = listOf("20", "22", "18", "16", " 26"))
    )
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numOfQuestions = questions.size

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game, container, false)
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,R.layout.fragment_game,container,false)
        return binding.root
        //Binding this fragment class to the layout
        binding.game = this

    }

}
