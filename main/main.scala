package test

object Runner {
  private var _test: Test3 = _
  def test = _test

  def main(args: Array[String]): Unit = {
    _test = new Test3(new Test1)
  }
}
