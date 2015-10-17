package javajs.io

class FileInputStream(file: File) extends InputStream {
  def read: Int = ???
  def read(b: Array[Byte]) : Int = ???
  def close() : Unit = ???
}