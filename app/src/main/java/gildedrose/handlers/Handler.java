package gildedrose.handlers;

import gildedrose.Item;

public interface Handler {
    public default Item handle(final Item item) {
        return new Item(
            item.name,
            calculateSellIn(item),
            calculateQuality(item)
        );
    }

    public int calculateSellIn(Item item);
    public int calculateQuality(Item item);
    public int getQualityScalar(Item item);
    public int getQualityUpperLimit();
    public int getQualityLowerLimit();
}
