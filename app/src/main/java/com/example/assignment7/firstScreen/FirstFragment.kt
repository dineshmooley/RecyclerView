package com.example.assignment7.firstScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.assignment7.R
import com.example.assignment7.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var firstViewModel: FirstViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        firstViewModel = ViewModelProvider(this)[FirstViewModel::class.java]
        binding.viewModel = firstViewModel

        val adapter = FirstScreenAdapter(firstViewModel.colors)
        binding.colorList.adapter = adapter

        firstViewModel.navigateToSecond.observe(viewLifecycleOwner, Observer{
            if(it)  {
                firstViewModel.doneNavigatingToSecond()
                findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(firstViewModel.colors))
            }
        })

        return binding.root
    }
}