package com.example.barchart_piechart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.barchart_piechart.databinding.ActivityMainBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val barEntry = arrayListOf<BarEntry>()
        val arabaModel = arrayOf("kiwi","lemon","strawberry","grape","kiwi")

        barEntry.add(BarEntry(0f,50.116f))
        barEntry.add(BarEntry(1f,32.645f))
        barEntry.add(BarEntry(2f,24.562f))
        barEntry.add(BarEntry(3f,19.272f))
        barEntry.add(BarEntry(4f,16.111f))

        val barDataSet = BarDataSet(barEntry,"fruit group")
        barDataSet.valueTextSize = 15f
        barDataSet.setColors(*ColorTemplate.MATERIAL_COLORS)

        val barData = BarData(barDataSet)
        binding.barChart.animateY(1500)
        binding.barChart.setFitBars(true)
        binding.barChart.data = barData
        binding.barChart.description.text = "fruit"
        binding.barChart.xAxis.valueFormatter = IndexAxisValueFormatter(arabaModel)
        binding.barChart.xAxis.position = XAxis.XAxisPosition.BOTTOM

        //PieChart
        val pieEntry = arrayListOf<PieEntry>()
        pieEntry.add(PieEntry(30f,"watermelon"))
        pieEntry.add(PieEntry(20f,"lemon"))
        pieEntry.add(PieEntry(10f,"strawberry"))
        pieEntry.add(PieEntry(5f,"grape"))
        pieEntry.add(PieEntry(2f,"kiwi"))

        val pieDataSet = PieDataSet(pieEntry,"fruit group")
        pieDataSet.valueTextSize = 15f
        pieDataSet.setColors(*ColorTemplate.COLORFUL_COLORS)

        val pieData = PieData(pieDataSet)

        binding.pieChart.data = pieData
        binding.pieChart.description.text = "fruit"
        binding.pieChart.centerText = "fruit group"




    }
}