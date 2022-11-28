package com.gildedrose;

public abstract class Item {
    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void decreaseQuality(int deterioration) {
        quality = Math.max(quality - deterioration, 0);
    }

    void increaseQuality(int improvement) {
        quality = Math.min(quality + improvement, 50);
    }

    void updateItemQuality() {
        growByOneDay();
        updateItemQualityForToday();
    }

    protected void growByOneDay() {
        sellIn--;
    }

    protected abstract void updateItemQualityForToday();
}
