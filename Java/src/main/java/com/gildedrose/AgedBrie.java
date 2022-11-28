package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateItemQualityForToday() {
        if (sellIn < 0) {
            increaseQuality(2);
        } else {
            increaseQuality(1);
        }
    }
}
