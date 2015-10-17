package javajs.io

class ObjectOutputStream(os : OutputStream) extends OutputStream {
  def write(byte: Int): Unit = ???

  def write(buffer: Array[Byte]): Int = ???

  def close(): Unit = ???
  
  def writeObject(obj : Any) = ???
}