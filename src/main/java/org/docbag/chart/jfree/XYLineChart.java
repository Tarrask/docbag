package org.docbag.chart.jfree;

import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.data.xy.XYDataset;

/**
 * LineChart
 *
 * <p>To create:</p>
 *
 * <pre>
 *      new XYLineChart.Builder(getXYData()).build();
 * </pre>
 *
 * <p>To create customized:</p>
 *
 * <pre>
 *     Map<String, Style> styles = new HashMap<String, Style>();
 *     styles.put("Label Name", new Style(Color.white));
 *     styles.put("Label Name 2", new Style(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f)));
 *     new LineChart.Builder(getBarData()).title("Line Chart").styles(styles).build();
 * </pre>
 *
 * @author Damien Plumettaz
 */
public class XYLineChart extends XYDataSetChart {
    private XYLineChart(Builder builder) {
        super(Type.LineChart, builder);
    }

    protected org.jfree.chart.JFreeChart createChart() {
        if (isThirdDimension()) {
            return ChartFactory.createXYLineChart(getTitle(), getxAxisLabel(), getyAxisLabel(), dataSet, getPlotOrientation(), isLegend(),
                isTooltips(), isUrls());
        } else {
            return ChartFactory.createXYLineChart(getTitle(), getxAxisLabel(), getyAxisLabel(), dataSet, getPlotOrientation(), isLegend(),
                isTooltips(), isUrls());
        }
    }
    
    @Override
	protected List<String> getLabels() {
    	List<String> labelList = new ArrayList<String>();
    	for(int i = 0; i < dataSet.getSeriesCount(); i++) {
    		labelList.add(dataSet.getSeriesKey(i).toString());
    	}
		return labelList;
	}
	
    public static class Builder extends XYDataSetChart.Builder<XYLineChart> {
        public Builder(XYDataset dataSet) {
            super(dataSet);
        }

        public XYLineChart build() {
            return new XYLineChart(this);
        }
    }
}
