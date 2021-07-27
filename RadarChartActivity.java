package com.example.charts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class RadarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radar_chart);

        RadarChart radarchart = findViewById(R.id.radarChart);

        ArrayList<RadarEntry> visiotrsForWebsite = new ArrayList<>();
        visiotrsForWebsite.add(new RadarEntry(420));
        visiotrsForWebsite.add(new RadarEntry(490));
        visiotrsForWebsite.add(new RadarEntry(520));
        visiotrsForWebsite.add(new RadarEntry(670));
        visiotrsForWebsite.add(new RadarEntry(594));
        visiotrsForWebsite.add(new RadarEntry(550));
        visiotrsForWebsite.add(new RadarEntry(620));

        RadarDataSet radarDataSet = new RadarDataSet(visiotrsForWebsite, "Website 1");
        radarDataSet.setColors(Color.RED);
        radarDataSet.setLineWidth(2f);
        radarDataSet.setValueTextColor(Color.GREEN);
        radarDataSet.setValueTextSize(14f);

        // *************************************************************************

        ArrayList<RadarEntry> visiotrsForWebsite2 = new ArrayList<>();
        visiotrsForWebsite2.add(new RadarEntry(310));
        visiotrsForWebsite2.add(new RadarEntry(420));
        visiotrsForWebsite2.add(new RadarEntry(685));
        visiotrsForWebsite2.add(new RadarEntry(820));
        visiotrsForWebsite2.add(new RadarEntry(490));
        visiotrsForWebsite2.add(new RadarEntry(730));
        visiotrsForWebsite2.add(new RadarEntry(200));

        RadarDataSet radarDataSet2 = new RadarDataSet(visiotrsForWebsite2, "Website 2");
        radarDataSet2.setColors(Color.BLUE);
        radarDataSet2.setLineWidth(2f);
        radarDataSet2.setValueTextColor(Color.YELLOW);
        radarDataSet2.setValueTextSize(14f);

        RadarData radarData = new RadarData();
        radarData.addDataSet(radarDataSet);
        radarData.addDataSet(radarDataSet2);


        String [] labels  = {"2014", "2015", "2016", "2017", "2018", "2019", "2020"};

        XAxis xAxis = radarchart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        radarchart.setData(radarData);

        radarchart.getDescription().setText("Radar Chart Example");
        radarchart.animate();
    }
}