package com.example.loveapp.ui.fragments.calculate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.loveapp.R
import com.example.loveapp.databinding.FragmentLoveCalculatorBinding
import com.example.loveapp.mvvm.viewmodel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoveCalculatorFragment : Fragment() {

    private val viewModel: LoveViewModel by viewModels()

    private val binding: FragmentLoveCalculatorBinding by lazy {
        FragmentLoveCalculatorBinding.inflate(layoutInflater)
    }

    private val progressBar: ProgressBar by lazy {
        binding.progressBar
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalculate.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val secondName = binding.etSecondName.text.toString()

            if (firstName.isBlank() || secondName.isBlank()) {
                Toast.makeText(requireContext(), "Enter both names", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            //ProgressBar
            progressBar.visibility = View.VISIBLE

            viewModel.getLoveResult(
                firstName = firstName,
                secondName = secondName
            ).observe(viewLifecycleOwner) { loveResults ->
                progressBar.visibility = View.GONE

                if (loveResults != null) {
                    val percentage = loveResults.percentage.toIntOrNull() ?: 0
                    val bundle = Bundle().apply {
                        putString("firstName", firstName)
                        putString("secondName", secondName)
                        putInt("percentage", percentage)
                    }

                    findNavController().navigate(
                        R.id.action_loveCalculatorFragment_to_loveResultFragment,
                        bundle
                    )
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Error: Failed to get results",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}