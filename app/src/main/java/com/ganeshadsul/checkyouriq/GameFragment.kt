package com.ganeshadsul.checkyouriq

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
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

        //Binding this fragment class to the layout
        binding.game = this
        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view:View ->
            val checkAnswerId = binding.questionOptions.checkedRadioButtonId
            //Do nothing if answerIndex is -1
            if (-1 !=checkAnswerId) {
                var answerIndex = 0
                when(checkAnswerId){
                    //Get index of answer selected
                    R.id.second_answer_radio_option -> answerIndex =1
                    R.id.third_answer_radio_option -> answerIndex =2
                    R.id.forth_answer_radio_option -> answerIndex =3
                    R.id.fifth_answer_radio_option -> answerIndex =4
                }
                //check if the answer selected is right
                if (answers[answerIndex] == currentQuestion.answers[0]){
                    questionIndex++

                    //advance to next question
                    if (questionIndex < numOfQuestions){
                        currentQuestion = questions[questionIndex]
                        setQuestions()
                        binding.questionOptions.clearCheck()

                        binding.invalidateAll()
                    }
                    else{
                        //we won
                        //goto game won fragment
                        view.findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment)
                    }
                }
                else{
                    //we lost
                    //goto game lost fragment
                    view.findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
                }
            }
        }
        return binding.root

    }
    private fun randomizeQuestions(){
        questions.shuffle()
        questionIndex = 0
        setQuestions()
    }
    private fun setQuestions(){
        currentQuestion = questions[questionIndex]

        //shuffling answers of that questions
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
    }
}
