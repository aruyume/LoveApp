package com.example.loveapp.ui.fragments.calculate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loveapp.R
import com.example.loveapp.databinding.FragmentLoveResultBinding

class LoveResultFragment : Fragment() {
    private val binding by lazy {
        FragmentLoveResultBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firstName = arguments?.getString("firstName")
        val secondName = arguments?.getString("secondName")
        val percentage = arguments?.getInt("percentage")

        binding.tvFirstNameResult.text = firstName
        binding.tvSecondNameResult.text = secondName
        binding.tvPercentage.text = "$percentage%"

        binding.btnTryAgain.setOnClickListener {
            val loveCalculatorFragment = LoveCalculatorFragment()

            parentFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, loveCalculatorFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}