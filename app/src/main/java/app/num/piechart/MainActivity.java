package app.num.piechart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/*
app直下のbuild.gradleに以下の文を追加

repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.PhilJay:MPAndroidChart:v2.1.6'
}


*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PieChart pieChart = (PieChart) findViewById(R.id.chart);

        ArrayList<Entry> entries = new ArrayList<>();
        //グラフにデータを追加
        entries.add(new Entry(10, 0));
        entries.add(new Entry(8, 1));

        PieDataSet dataset = new PieDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        //データの名前の設定
        labels.add("残り予算");
        labels.add("課金額");

        PieData data = new PieData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.setDescription("Description");
        pieChart.setData(data);

        pieChart.animateY(2000);
        //アニメーションの時間設定小さくなればはやい 無効にすることも可能

        pieChart.saveToGallery("/sd/mychart.jpg", 85); // 85 is the quality of the image

        pieChart.setDrawHoleEnabled(true);
        //真ん中に円状の穴を開けるか開けないか

        pieChart.setDrawCenterText(true);
        //真ん中の円状の穴にテキスト表示
        pieChart.setCenterText("残り予算\n~円");
        //テキストの内容
        pieChart.setRotationEnabled(false);
        //円グラフを触って回転させるかさせないか




    }
}
