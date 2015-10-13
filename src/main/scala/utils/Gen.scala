package utils

import scala.util.Random
/**
 * @author dengels
 */
trait Gen[+T] { self =>

  def generate: T

  def map[S](f: T => S) = new Gen[S] {
    def generate = f(self.generate)
  }

  def flatMap[S](f: T => Gen[S]) = new Gen[S] {
    def generate = f(self.generate).generate
  }
  
  def foreach[U](f: T => U) = toIterator.foreach { f }

  def toIterator = Iterator.continually(generate)
}

object Gen {
  private val rand = new Random();
  
  trait RandomProvider[T] {
    def nextRand() : T
  }
  
  implicit val randomLong = new RandomProvider[Long]{
    def nextRand = rand.nextLong()
  }

  def pairs[S, T](genS: Gen[S], genT: Gen[T]): Gen[(S, T)] = for (s <- genS; t <- genT) yield (s, t)

  def random[T](implicit gen0: RandomProvider[T]) = new Gen[T] {
    def generate = gen0.nextRand()
  }
}