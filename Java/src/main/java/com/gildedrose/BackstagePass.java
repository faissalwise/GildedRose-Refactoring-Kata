package com.gildedrose;

public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    void updateItemQuality() {
        sellIn = sellIn - 1;
        if (sellIn < 0) {
            quality = 0;
        } else if (sellIn < 5) {
            increaseQuality(3);
        } else if (sellIn < 10) {
            increaseQuality(2);
        } else {
            increaseQuality(1);
        }
    }
}
