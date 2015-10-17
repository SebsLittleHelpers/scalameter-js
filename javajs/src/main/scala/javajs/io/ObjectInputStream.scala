package javajs.io

class ObjectInputStream(is : InputStream) extends InputStream {
  def read: Int = ???
  def read(b: Array[Byte]) : Int = ???
  def close() : Unit = ???
  def readObject() : Any = ???
}