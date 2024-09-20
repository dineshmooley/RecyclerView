package com.example.assignment7.secondScreen

import android.os.Bundle
import android.util.Log
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
import com.example.assignment7.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var secondViewModel: SecondViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        secondViewModel = ViewModelProvider(this)[SecondViewModel::class.java]
        binding.viewModel = secondViewModel
        val args = SecondFragmentArgs.fromBundle(requireArguments())
        val adapter = SecondScreenAdapter(args.colors)
        //Log.i(context.toString(), args.colors.toString())
        binding.colorItemList.adapter = adapter

        secondViewModel.navigateToFirst.observe(viewLifecycleOwner, Observer{
            if(it)  {
                secondViewModel.doneNavigating()
                findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToFirstFragment())
            }
        })

        return binding.root
    }
}