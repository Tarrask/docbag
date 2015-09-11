package org.docbag.chart.jfree;

import junit.framework.Assert;

import org.docbag.chart.Chart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.junit.Test;

/**
 * LineChartTest
 *
 * @author Damien Plumettaz
 */
public class XYLineChartTest {
    final XYDataset dataSet = new DefaultXYDataset();
    final double[][] data ={{1,2,3,4}, {0,4,2,6}};

    @Test
    public void testGetType() {
    	XYLineChart chart = new XYLineChart.Builder(dataSet).build();
        Assert.assertEquals(Chart.Type.LineChart, chart.getType());
        Assert.assertTrue(chart.dataSet == dataSet);
    }
    
    @Test
    public void testAddSerie() {
    	XYLineChart chart = new XYLineChart.Builder(dataSet).build();
    	((DefaultXYDataset)dataSet).addSeries("A", data);
    	Assert.assertEquals(1, dataSet.getSeriesCount());
    	Assert.assertEquals(0.0, dataSet.getY(0, 0));
    	Assert.assertEquals(2.0, dataSet.getY(0, 2));
    }
}
