import java.util.NoSuchElementException;

public class RunMed {

  private ALHeapMin _lilVals;
  private ALHeapMax _bigVals;

  public RunMed() {
    _lilVals = new ALHeapMin();
    _bigVals = new ALHeapMax();
  }

  public int getMedian() {
    if (_bigVals.size() == 0 && _lilVals.size() == 0) throw new NoSuchElementException("No elements given.");
    return (_bigVals.size() > _lilVals.size()) ? _bigVals.peekMax() : _lilVals.peekMin();
  }

  public void add(Integer newVal) {
    if (_bigVals.size() == 0 && _lilVals.size() == 0) {
      _bigVals.add(newVal);
      return;
    }
    int currMed = getMedian();
    if (newVal > currMed) _lilVals.add(newVal);
    else _bigVals.add(newVal);
    while (_bigVals.size() - 1 > _lilVals.size()) {
      _lilVals.add(_bigVals.removeMax());
      System.out.println("bigVals: " + _bigVals);
      System.out.println("lilVals: " + _lilVals);
    }
    while (_lilVals.size() - 1 > _bigVals.size()) {
      _bigVals.add(_lilVals.removeMin());
      System.out.println("bigVals: " + _bigVals);
      System.out.println("lilVals: " + _lilVals);
    }
  }
}
