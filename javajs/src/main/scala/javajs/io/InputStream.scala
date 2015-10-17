package javajs.io

trait InputStream {
  def read(): Int
  def read(b: Array[Byte]): Int
  def close(): Unit
}