package com.example.charts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        BarChart bchart = findViewById(R.id.barChart);

        ArrayList<BarEntry> visistors = new ArrayList<>();
        visistors.add(new BarEntry(2014, 20)); //x and y values
        visistors.add(new BarEntry(2015, 475));
        visistors.add(new BarEntry(2016, 508));
        visistors.add(new BarEntry(2017, 680));
        visistors.add(new BarEntry(2018, 550));
        visistors.add(new BarEntry(2020, 483));

        BarDataSet barDataSet = new BarDataSet(visistors,"Visitors");
        barDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        barDataSet.setValueTextColor(Color.BLUE);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData((barDataSet));

        bchart.setFitBars(true);
        bchart.setData(barData);
        bchart.getDescription().setText("BAr Chart Example ");
        bchart.animateY(2000);


    }
}