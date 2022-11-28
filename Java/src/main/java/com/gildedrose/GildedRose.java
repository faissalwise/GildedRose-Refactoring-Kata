package com.gildedrose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      updateItemQuality(item);
    }
  }

  private void updateItemQuality(Item item) {

    item.sellIn = item.sellIn - 1;
    // first block
    if (item.name.equals("Aged Brie")) {

      if (item.sellIn < 0) {
        increaseQuality(item, 2);
      } else {
        increaseQuality(item, 1);
      }

    } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

      if (item.sellIn < 0) {
        item.quality = 0;
      } else if (item.sellIn < 5) {
        increaseQuality(item, 3);
      } else if (item.sellIn < 10) {
        increaseQuality(item, 2);
      } else {
        increaseQuality(item, 1);
      }
    } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
      item.sellIn = item.sellIn + 1;
    } else {
      if (item.sellIn < 0) {
        decreaseQuality(item, 2);
      } else {
        decreaseQuality(item, 1);
      }
    }
  }

  private void decreaseQuality(Item item, int deterioration) {
    item.quality = Math.max(item.quality - deterioration, 0);
  }

  private void increaseQuality(Item item, int improvement) {
    item.quality = Math.min(item.quality + improvement, 50);
  }
}
