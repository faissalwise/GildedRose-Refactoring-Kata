package com.gildedrose;

public class Conjured extends Item {
    public Conjured(int sellIn, int quality) {
        super("Conjured Mana Cake", sellIn, quality);
    }

    @Override
    protected void updateItemQualityForToday() {
        if (sellIn < 0) {
            decreaseQuality(4);
        } else {
            decreaseQuality(2);
        }
    }
}
