package com.gildedrose;

import static java.nio.file.Path.of;

import java.nio.file.Path;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

public class TexttestFixture {
  public static void main(String[] args) {
    new TexttestFixture().mainTest(args);
  }

  @Test
  void mainTest(String[] args) {
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

    int days = 2;
    if (args.length > 0) {
      days = Integer.parseInt(args[0]) + 1;
    }

    Path filePath = of("src", "test", "resources", "newOutput.txt");

    var buffer = new StringBuffer();

    for (int i = 0; i < days; i++) {
      buffer.append("-------- day " + i + " --------");

      buffer.append("name, sellIn, quality");

      for (Item item : items) {
        buffer.append(item);
      }

      app.updateQuality();
    }

    Approvals.verify(buffer.toString());
  }
}
