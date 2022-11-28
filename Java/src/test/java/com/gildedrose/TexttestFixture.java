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
          new NormalItem("+5 Dexterity Vest", 10, 20), //
          new AgedBrie(2, 0), //
          new NormalItem("Elixir of the Mongoose", 5, 7), //
          new Sulfuras(0, 80), //
          new Sulfuras(-1, 80),
          new BackstagePass(15, 20),
          new BackstagePass(10, 49),
          new BackstagePass(5, 49),
          // this conjured item does not work properly yet
          new Conjured(3, 20)
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
