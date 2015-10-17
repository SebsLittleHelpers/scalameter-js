package javajs.nio

class ByteBuffer {
  
  def array() = ???
  
  def get = ???
  
  def put(x : Byte) : this.type = ???
  
  def put(x : Array[Byte]) : this.type = ???
  
  def getChar = ???
  
  def putChar(x : Char) : this.type = ???
  
  def getShort = ???
  
  def putShort(x : Short) : this.type = ???
  
  def getInt = ???
  
  def putInt(x : Int) : this.type = ???
  
  def getLong = ???
  
  def putLong(x : Long) : this.type = ???
  
  def getFloat = ???
  
  def putFloat(x : Float) : this.type = ???
  
  def getDouble = ???
  
  def putDouble(x: Double) : this.type = ???
}

object ByteBuffer {
  
  def allocate(capacity : Int) : ByteBuffer = ???
  
  def wrap(array : Array[Byte]) : ByteBuffer = ???
  
  def wrap(array : Array[Byte], offset: Int, length : Int) : ByteBuffer = ???

}