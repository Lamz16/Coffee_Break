package com.lamz.coffeebreak.ui.detail

import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.lamz.coffeebreak.R
import com.lamz.coffeebreak.databinding.ActivityDetailBinding
import com.lamz.coffeebreak.utils.one
import com.lamz.coffeebreak.utils.zero

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }

        val dataBtnSize = resources.getStringArray(R.array.size_drink)
        val dataBtnAdditive = resources.getStringArray(R.array.addittives)

        for (i in dataBtnSize.indices) {
            when (i) {
                0 -> {
                    with(binding) {
                        size300.text = dataBtnSize[0]
                        sugar.text = dataBtnAdditive[0]
                    }
                }

                1 -> {
                    with(binding) {
                        size400.text = dataBtnSize[1]
                        cinnamon.text = dataBtnAdditive[1]
                    }
                }

                2 -> {
                    with(binding) {
                        size500.text = dataBtnSize[2]
                        syrup.text = dataBtnAdditive[2]
                    }
                }
            }
        }


        var countChart = zero
        with(binding){
                remove.setOnClickListener {
                    if (countChart > 0){
                        countChart -= one
                        count.text = countChart.toString()
                    }
                }
            add.setOnClickListener {
                countChart += one
                count.text = countChart.toString()
            }

            var state = false
            favorite.setOnClickListener {
                state = !state

                if (state){
                    favorite.setImageDrawable(ContextCompat.getDrawable(this@DetailActivity, R.drawable.ic_favorited))
                }else{
                    favorite.setImageDrawable(ContextCompat.getDrawable(this@DetailActivity, R.drawable.ic_favorite))
                }
            }

        }

    }

}