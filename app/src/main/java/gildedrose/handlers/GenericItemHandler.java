package gildedrose.handlers;

import gildedrose.Item;

public class GenericItemHandler implements Handler {
    @Override
    public int calculateSellIn(Item item) {
        return item.sellIn - 1;
    }

    @Override
    public int calculateQuality(Item item) {
        final int qualityScalar = getQualityScalar(item);

        if ((item.quality + qualityScalar) > getQualityUpperLimit()) {
            return item.quality;
        }

        return item.quality + qualityScalar;
    }

    @Override
    public int getQualityScalar(Item item) {
        return -1;
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
