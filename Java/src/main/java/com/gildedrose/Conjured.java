package com.gildedrose;

public class Conjured extends Item {
    public Conjured(int sellIn, int quality) {
        super("Conjured Mana Cake", sellIn, quality);
    }

    @Override
    void updateItemQuality() {
        sellIn = sellIn - 1;
        if (sellIn < 0) {
            decreaseQuality(4);
        } else {
            decreaseQuality(2);
        }
    }
}
