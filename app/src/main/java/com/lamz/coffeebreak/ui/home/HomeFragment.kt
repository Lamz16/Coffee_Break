package com.lamz.coffeebreak.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lamz.coffeebreak.R
import com.lamz.coffeebreak.databinding.FragmentHomeBinding
import com.lamz.coffeebreak.dummy.ContentPopular
import com.lamz.coffeebreak.ui.adapter.MenuAdapter
import com.lamz.coffeebreak.ui.detail.DetailActivity

class HomeFragment : Fragment() {

    private val list = ArrayList<ContentPopular>()
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.bannerOffer.buy.setOnClickListener {
            val intent = Intent(activity, DetailActivity::class.java)
            startActivity(intent)
        }
        homeViewModel.text.observe(viewLifecycleOwner) {

        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvMenu.setHasFixedSize(true)
        list.addAll(getListContent())
        showRecyclerView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showRecyclerView(){
        binding.rvMenu.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
        val listContent = MenuAdapter(list)
        binding.rvMenu.adapter =listContent
    }

    @SuppressLint("Recycle")
    private fun getListContent(): ArrayList<ContentPopular>{
        val dataName = resources.getStringArray(R.array.menu_item)
        val dataPrice = resources.getStringArray(R.array.price)
        val dataImages = resources.obtainTypedArray(R.array.images)

        val listContent = ArrayList<ContentPopular>()

        for (i in dataName.indices){
            val content = ContentPopular(dataName[i], dataPrice[i], dataImages.getResourceId(i,-1))
            listContent.add(content)
        }
        return listContent
    }
}