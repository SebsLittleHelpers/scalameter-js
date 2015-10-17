package javajs.io

object File {
  val pathSeparator  = "/"
  val pathSeparatorChar = '/'
  val separator = pathSeparator
}

class File(path : String) {
  def getAbsolutePath : String = ???
  def exists : Boolean = ???
  def isFile : Boolean = ???
  
  def mkdirs() : Unit = ???
  
}