package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.time.OffsetDateTime;

public class Tachograph {
  private final Table<Integer, String, Object> table = HashBasedTable.create();
  private int index = 0;

  public void add(OffsetDateTime time, Integer position, Double speed) {
    table.put(index, "time", time);
    table.put(index, "position", position);
    table.put(index, "speed", speed);
    index+=1;
  }

  public int count() {
    return table.rowKeySet().size();
  }
}