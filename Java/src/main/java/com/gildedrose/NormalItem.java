package com.gildedrose;

public class NormalItem extends Item {
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateItemQualityForToday() {
        if (sellIn < 0) {
            decreaseQuality(2);
        } else {
            decreaseQuality(1);
        }
    }
}
