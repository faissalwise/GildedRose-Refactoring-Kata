package com.gildedrose;

public class NormalItem extends Item {
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    void updateItemQuality() {
        sellIn = sellIn - 1;
        if (sellIn < 0) {
            decreaseQuality(2);
        } else {
            decreaseQuality(1);
        }
    }
}
