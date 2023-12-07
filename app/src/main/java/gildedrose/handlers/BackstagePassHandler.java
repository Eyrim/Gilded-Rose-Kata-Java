package gildedrose.handlers;

import gildedrose.Item;

public class BackstagePassHandler implements Handler {
    @Override
    public int calculateSellIn(Item item) {
        return item.sellIn - 1;
    }

    @Override
    public int calculateQuality(Item item) {
        final int qualityScalar = getQualityScalar(item);

        return item.quality + qualityScalar;
    }

    @Override
    public int getQualityScalar(Item item) {
        if (item.sellIn == 0) { return -item.quality; }
        if (item.sellIn <= 5) { return 3; }
        if (item.sellIn < 10) { return 2; }

        return 1;
    }

    @Override
    public int getQualityUpperLimit() {
        return 50;
    }

    @Override
    public int getQualityLowerLimit() {
        return 0;
    }
}
