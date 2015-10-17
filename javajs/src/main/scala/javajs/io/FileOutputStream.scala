package javajs.io

class FileOutputStream(file: File) extends OutputStream {
  def write(byte: Int): Unit = ???

  def write(buffer: Array[Byte]): Int = ???

  def close(): Unit = ???
}