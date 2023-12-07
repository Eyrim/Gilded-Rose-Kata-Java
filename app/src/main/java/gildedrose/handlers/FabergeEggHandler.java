package gildedrose.handlers;

import gildedrose.Item;

public class FabergeEggHandler implements Handler {
    /**
     * Faberge eggs have no sell-by
     */
    @Override
    public int calculateSellIn(Item item) {
        return item.sellIn;
    }

    @Override
    public int calculateQuality(Item item) {
        return item.quality;
    }

    /**
     * Faberge eggs never decrease in quality
     */
    @Override
    public int getQualityScalar(Item item) {
        return 0;
    }

    @Override
    public int getQualityUpperLimit() {
        return 80;
    }

    @Override
    public int getQualityLowerLimit() {
        return -1;
    }
}
