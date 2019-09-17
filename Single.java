class Single {
  private static Single INSTANCE =new Single();
  private Single () {}              //私有化构造方法
  public static Single get Instance() {
  return INSTANCE;
  }
}