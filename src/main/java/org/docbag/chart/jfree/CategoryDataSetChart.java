package org.docbag.chart.jfree;

import java.util.ArrayList;
import java.util.List;

import org.jfree.data.category.CategoryDataset;

/**
 * Base class for all charts that require CategoryDataset type data set.
 *
 * @author Jakub Torbicki
 */
public abstract class CategoryDataSetChart extends BaseChart {
    protected final CategoryDataset dataSet;

    CategoryDataSetChart(Type type, Builder<? extends CategoryDataSetChart> builder) {
        super(type, builder);
        this.dataSet = builder.dataSet;
    }

    
	protected List<String> getLabels() {
		List<String> list = new ArrayList<String>();
		for(Object o: dataSet.getRowKeys()) {
			list.add(o.toString());
		}
        return list;
    }

    public abstract static class Builder<T extends CategoryDataSetChart> extends BaseChartBuilder<T> {
        private final CategoryDataset dataSet;

        public Builder(CategoryDataset dataSet) {
            this.dataSet = dataSet;
        }
    }
}
