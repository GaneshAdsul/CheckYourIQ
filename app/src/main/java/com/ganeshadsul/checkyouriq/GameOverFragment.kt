package com.ganeshadsul.checkyouriq

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.ganeshadsul.checkyouriq.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game_over, container, false)
        val binding = DataBindingUtil.inflate<FragmentGameOverBinding>(inflater,R.layout.fragment_game_over,container,false)

       binding.tryAgainButton.setOnClickListener {
           view!!.findNavController().navigate(R.id.action_gameOverFragment_to_gameFragment)
       }

        return binding.root
    }
}
