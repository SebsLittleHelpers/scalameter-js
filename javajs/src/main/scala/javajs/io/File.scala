package javajs.io

object File {
  val pathSeparator  = "/"
  val pathSeparatorChar = '/'
}

class File(path : String) {
  def getAbsolutePath = path
}