package javajs.io

trait OutputStream {
  def write(byte : Int): Unit
  
  def write(buffer: Array[Byte]): Int
  
  def close(): Unit
}