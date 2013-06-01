package test

class Test3(t: Test1) extends Test2(t) {
  override val test = t.test + 2
}
