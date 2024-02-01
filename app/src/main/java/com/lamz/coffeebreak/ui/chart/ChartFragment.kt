package com.lamz.coffeebreak.ui.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.lamz.coffeebreak.databinding.FragmentChartBinding

class ChartFragment : Fragment() {

    private var _binding: FragmentChartBinding? = null

    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val chartViewModel =
            ViewModelProvider(this)[ChartViewModel::class.java]

        _binding = FragmentChartBinding.inflate(inflater, container, false)
        val root: View = binding?.root!!


        chartViewModel.text.observe(viewLifecycleOwner) {

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}