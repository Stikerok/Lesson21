package com.example.lesson21.ui.main

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.graphics.drawable.AnimationDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.lesson21.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var imageView: ImageView
    private var start: Boolean = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button1 = view.findViewById(R.id.button1)
        button2 = view.findViewById(R.id.button2)
        imageView = view.findViewById(R.id.imageView)
        button1.setOnClickListener {
            (AnimatorInflater.loadAnimator(requireContext(), R.animator.animation) as AnimatorSet)
                .apply {
                    setTarget(button1)
                    start()
                }
        }
        button2.setOnClickListener {
            imageView.setBackgroundResource(
                if (start) R.drawable.animation_list
                else R.drawable.animation_list_rev
            )
            (imageView.background as AnimationDrawable).apply {
                start()
                start = !start
            }
        }
    }

}