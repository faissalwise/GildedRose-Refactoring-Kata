package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

public class TexttestFixture {

  public static void main(String[] args) {
    final TexttestFixture texttestFixture = new TexttestFixture();
    texttestFixture.extracted(texttestFixture.calculDays(args));
  }

  @Test
  void mainTest() {
    extracted(20);
  }

  private void extracted(int days) {
    Item[] items =
        new Item[] {
          new Item("+5 Dexterity Vest", 10, 20), //
          new Item("Aged Brie", 2, 0), //
          new Item("Elixir of the Mongoose", 5, 7), //
          new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
          new Item("Sulfuras, Hand of Ragnaros", -1, 80),
          new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
          new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
          new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
          // this conjured item does not work properly yet
          new Item("Conjured Mana Cake", 3, 6)
        };

    GildedRose app = new GildedRose(items);

    var buffer = new StringBuffer();

    for (int i = 0; i < days; i++) {
      buffer.append("-------- day " + i + " --------").append("\n");

      buffer.append("name, sellIn, quality");

      for (Item item : items) {
        buffer.append(item).append("\n");
      }

      app.updateQuality();
    }

    Approvals.verify(buffer.toString());
  }

  private int calculDays(String[] args) {
    int days = 2;
    if (args.length > 0) {
      days = Integer.parseInt(args[0]) + 1;
    }
    return days;
  }
}
