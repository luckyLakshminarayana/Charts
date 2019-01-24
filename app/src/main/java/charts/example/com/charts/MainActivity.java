package charts.example.com.charts;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
   private LineChart chart;
    private final LineChart[] charts = new LineChart[4];
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        chart = findViewById(R.id.chart1);
        chart.setViewPortOffsets(0, 0, 0, 0);
        chart.setBackgroundColor(Color.GRAY);

        // no description text
        chart.getDescription().setEnabled(false);

        // enable touch gestures
        chart.setTouchEnabled(true);

        // enable scaling and dragging
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(false);

        chart.setDrawGridBackground(false);
        chart.setMaxHighlightDistance(300);

        XAxis x = chart.getXAxis();
        x.setEnabled(false);

        YAxis y = chart.getAxisLeft();
     //   y.setTypeface(tfLight);
        y.setLabelCount(6, false);
        y.setTextColor(Color.WHITE);
        y.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        y.setDrawGridLines(false);
        y.setAxisLineColor(Color.WHITE);
        chart.getAxisRight().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.animateXY(2000, 2000);
        //mjnvjhv

        // don't forget to refresh the drawing
        chart.invalidate();

            setData(10, 3);

    }


    private final int[] colors = new int[] {
            ColorTemplate.VORDIPLOM_COLORS[0],
            ColorTemplate.VORDIPLOM_COLORS[1],
            ColorTemplate.VORDIPLOM_COLORS[2]
    };

    private void setData(int count, float range)
    {
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        for (int z = 0; z < 2; z++) {

            ArrayList<Entry> values = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                double val = (Math.random() *range) + 3;
                values.add(new Entry(i, (float) val));
            }

            LineDataSet d = new LineDataSet(values, "DataSet " + (z + 1));
            d.setLineWidth(2.5f);
            d.setCircleRadius(4f);

            int color = colors[z % colors.length];
            d.setColor(color);
            d.setCircleColor(color);
            dataSets.add(d);
        }

        //((LineDataSet) dataSets.get(0)).enableDashedLine(10, 10, 0);
        ((LineDataSet) dataSets.get(0)).setColors(Color.WHITE);
        ((LineDataSet) dataSets.get(0)).setCircleColors(Color.BLACK);
        ((LineDataSet) dataSets.get(0)).setMode(LineDataSet.Mode.CUBIC_BEZIER);
        ((LineDataSet) dataSets.get(0)).setFillAlpha(250);
        ((LineDataSet) dataSets.get(0)).setDrawFilled(true);
        ((LineDataSet) dataSets.get(0)).setFillColor(Color.GREEN);

       // ((LineDataSet) dataSets.get(1)).enableDashedLine(10, 10, 0);
        ((LineDataSet) dataSets.get(1)).setColors(Color.YELLOW);
        ((LineDataSet) dataSets.get(1)).setCircleColors(Color.BLACK);
        ((LineDataSet) dataSets.get(1)).setMode(LineDataSet.Mode.CUBIC_BEZIER);
        ((LineDataSet) dataSets.get(1)).setFillAlpha(250);
        ((LineDataSet) dataSets.get(1)).setDrawFilled(true);
        ((LineDataSet) dataSets.get(1)).setFillColor(Color.BLUE);



        LineData data = new LineData(dataSets);
        chart.setData(data);
        chart.invalidate();

       // LineDataSet set1;

            /*set1 = new LineDataSet(values, "DataSet 1");
            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            set1.setCubicIntensity(0.2f);
            set1.setDrawFilled(true);
            set1.setDrawCircles(false);
            set1.setLineWidth(1.8f);
            set1.setCircleRadius(4f);
            set1.setCircleColor(Color.WHITE);
            set1.setHighLightColor(Color.rgb(244, 117, 117));
            set1.setColor(Color.WHITE);
            set1.setFillColor(Color.WHITE);
            set1.setFillAlpha(100);
            set1.setDrawHorizontalHighlightIndicator(false);
            set1.setFillFormatter(new IFillFormatter() {
                @Override
                public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
                    return chart.getAxisLeft().getAxisMinimum();
                }
            });*/

            // create a data object with the data sets
          /*  LineData data = new LineData(set1);
            //data.setValueTypeface(tfLight);
            data.setValueTextSize(9f);
            data.setDrawValues(false);*/

            // set data
            //chart.setData(data);
        //}
    }
}
