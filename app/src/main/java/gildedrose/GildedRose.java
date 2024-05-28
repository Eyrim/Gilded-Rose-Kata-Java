package gildedrose;

import java.util.Hashtable;
import java.util.List;

import gildedrose.handlers.AgedBrieHandler;
import gildedrose.handlers.BackstagePassHandler;
import gildedrose.handlers.FabergeEggHandler;
import gildedrose.handlers.GenericItemHandler;
import gildedrose.handlers.Handler;

class GildedRose {
    List<Item> items;

    private final Hashtable<String, Handler> ITEM_NAME_HANDLER_MAP = new Hashtable<>() {
        {
            put("Aged Brie", new AgedBrieHandler());
            put("Backstage passes to a Coldplay concert", new BackstagePassHandler());
            put("Fabergé egg", new FabergeEggHandler());
        }
    };

    private final GenericItemHandler GENERIC_ITEM_HANDLER = new GenericItemHandler();

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    private Item findHandler(Item item) {
        if (this.ITEM_NAME_HANDLER_MAP.containsKey(item.name)) {
            return this.ITEM_NAME_HANDLER_MAP.get(item.name).handle(item);
        }

        return this.GENERIC_ITEM_HANDLER.handle(item);
    }

    public void updateQuality() {
        items = items.stream()
                .map(this::findHandler)
                .toList();

        // for (int i = 0; i < items.size(); i++) {
        // if (!items.get(i).name.equals("Aged Brie")
        // && !items.get(i).name.equals("Backstage passes to a Coldplay concert")) {
        // if (items.get(i).quality > 0) {
        // if (!items.get(i).name.equals("Fabergé egg")) {
        // items.get(i).quality = items.get(i).quality - 1;
        // }
        // }
        // } else {
        // if (items.get(i).quality < 50) {
        // items.get(i).quality = items.get(i).quality + 1;
        //
        // if (items.get(i).name.equals("Backstage passes to a Coldplay concert")) {
        // if (items.get(i).sellIn < 11) {
        // if (items.get(i).quality < 50) {
        // items.get(i).quality = items.get(i).quality + 1;
        // }
        // }
        //
        // if (items.get(i).sellIn < 6) {
        // if (items.get(i).quality < 50) {
        // items.get(i).quality = items.get(i).quality + 1;
        // }
        // }
        // }
        // }
        // }
        //
        // if (!items.get(i).name.equals("Fabergé egg")) {
        // items.get(i).sellIn = items.get(i).sellIn - 1;
        // }
        //
        // if (items.get(i).sellIn < 0) {
        // if (!items.get(i).name.equals("Aged Brie")) {
        // if (!items.get(i).name.equals("Backstage passes to a Coldplay concert")) {
        // if (items.get(i).quality > 0) {
        // if (!items.get(i).name.equals("Fabergé egg")) {
        // items.get(i).quality = items.get(i).quality - 1;
        // }
        // }
        // } else {
        // items.get(i).quality = items.get(i).quality - items.get(i).quality;
        // }
        // } else {
        // if (items.get(i).quality < 50) {
        // items.get(i).quality = items.get(i).quality + 1;
        // }
        // }
        // }
        // }
    }

    @Override
    public String toString() {
        String output = "";

        for (var i = 0; i < items.size(); i++) {
            if (output.length() > 0) {
                output += ", ";
            }

            output += items.get(i).toString();
        }

        return output;
    }
}
