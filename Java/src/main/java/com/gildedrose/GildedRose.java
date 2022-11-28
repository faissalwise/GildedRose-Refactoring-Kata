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

      increaseQuality(item, 1);

      if (item.sellIn < 0) {
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
      decreaseQuality(item);
      if (item.sellIn < 0) {
        decreaseQuality(item);
      }
    }
  }

  private void decreaseQuality(Item item) {
    if (item.quality > 0) {
      item.quality = item.quality - 1;
    }
  }

  private void increaseQuality(Item item, int improvement) {
    item.quality = Math.min(item.quality + improvement, 50);
  }
}
