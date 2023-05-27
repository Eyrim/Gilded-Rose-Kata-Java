package gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

class ExampleTest {

    @Test
    void foo() {
        List<Item> items = Arrays.asList(new Item("foo", 0, 0));
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals("foo", gildedRose.items.get(0).name);
    }
}
