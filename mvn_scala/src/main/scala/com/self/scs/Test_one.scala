package com.self.scs

import java.io.{FileInputStream, FileNotFoundException, FileOutputStream}
import java.nio.file.Path

import scala.io.Source
import scala.util.Random
import scala.util.control.{BreakControl, Breaks}

/**
  * @author hasee
  */

class Test_one
object Test_one {
  def main(args: Array[String]): Unit = {
    fileInAndOut()
  }
  //s来从字符串中进行取值计算
  def getValueFromS(): Unit ={
    val name = "fread"
    val age = 23
    println(s"$name is $age  years")
  }
  //for and yield 来遍历一个字符串：
  def rangeStr={
    var str="this is a string"
   str= str.map(_.toUpper)
  }

  //通过for和yield来进行遍历一个字符串数组：
  def rangeArray(): Unit ={
    var str="hellow world"
    var str2=for(i<- str)yield i.toUpper

    str2.foreach(print(_))
  }

  //遍历字符串中的某个字符的时候，string的charAt()，或者是scala中的自带的一个数组的访问方式：
  def askString():Unit={
    var str="hellow this is for string"
    println(str.charAt(3))//java特性通过charAt来进行访问。
    println(str(3))//数组访问，scala特性
  }
  //字符串转换成为数字：scala中的to*  方法和java中的 类似的INterger.parseInt()等 的方式来实现：

  def changeToNumber(): Unit ={
   var str="34"

    println(str.toInt)//通过scala的方式来实现
    println(Integer.parseInt(str))
  }

  //对于一个数字变量通过什么方式来进行数字的重载，（也就是数字的类型这里）
  def overload(): Unit ={
    var int_value=1
    var double_value=1d
    var long_value=1L
    //这一种是通过具体声明某个数据是某个类型来实现的
    var int_value1:Int=1
    var double_value1:Double=1
    var long_value1:Long=1
    //这一种是通过声明变量的类型来实现的
  }

  //对于字符的计算类似于java中的++ --操作在scala中是通过  += -=来实现的
  def changeValue(): Unit ={
    var num=2
    num+=1
    println(num)//通过num首先增加1然后在再来进行打印操作
    num-=1  //
    //  num++ 这种在scala中是不能使用的 。
  }

  //scala中来创建一个随机数Random来生成随机数：
  def gerRandom(): Unit ={
    var randoms=Random
    var intvars=randoms.nextInt(100)//生成的是0到100之间的
    println(intvars)
  }

  //scala中来生成一个根据to形式形成一个数字序列；
  def makeValue(): Unit ={
    var arr=1 to 10 by 2
    arr.foreach(println(_))
  }

  //to ,until的区别：
  def toAndUntil(): Unit ={
    //to的形式会从1,2,3都会有
    for(i<- 1 to 3){
      println(i)
    }
    //until的方式仅仅1,2 最后的3不会包括了。
    //相当于是一个前闭，后开的数组。
    for(i<- 1 until  3){
      println(i)
    }
  }

  //scala中通过使用一个for循环来实现一个map的遍历：
  def rangeMap(): Unit ={
    var maps=Map((1,"a"),(2,"b"))
    for((k,v)<-maps){
      println(s"key is $k, value is $v")
    }
  }

  //for 循环中可以通过使用多个计数器来实现一个数据的遍历，当for循环中有多个计数器的时候，这个时候的for循环中可以使用一个大括号来进行
  //表示。
  def mulityNumber(): Unit ={
   for{j<- 1 to 3; i<- 3 to 5}{
     println(s"j ：$j  ,i  : $i")
   }
  }

  //for yield来进行联合使用的过程，通过遍历一个for的同时来将遍历的数据放置到yield中去形成一个新的序列
  def forYield(): Unit ={
    var newArr=for(i<- 1 to 2) yield  i*2
    newArr.foreach(println(_))
    //通过将数据进行一个，遍历和转换的过程，将新生成的数据放置到一个新的数组中去。
  }


  //scala中通过一个breakable的方式来实现java中的一个break的语句方式：
  def breaktest(): Unit ={
    Breaks.breakable{
      for(i<- 1 to 10){
        if(i==5) Breaks.break
        println(i)
      }
    }
  }

  //这里是对于scala中的break的解释，当使用这个break的时候，当执行到这个的时候
  //实际上是会产生一个异常，通过这个异常来结束当前的代码：
  def explainBreak(): Unit = {
    Breaks.breakable {
      try {
        for (i <- 1 to 3) {
          println(i)
          if (i == 2) {
            Breaks.break()
          }
        }
      } catch {
        case ex: Exception => {
          println(ex.getCause)
        }
      }
    }
  }

  //在scala中if实现一个三目表达式来实现取值：
  def getIf(): Unit ={
    var flag=8
    var s=if(flag>2) flag else 23//通过
  }

  //仿照java中switch来在scala中实现case的模式匹配：(这里实现的是一个具体的值的匹配)
  def caseMatch(): Unit ={
    var cs=3
    var newValue=cs match {
      case 1=>1
      case 2=>2
      case  _ => 12
    }
    println(newValue)
  }

  //scala 中通过模式匹配一个变量 的类型：（这里实现的是一个类型的匹配）
  def matchCase(s:Any): Unit ={
    s match {
      case s:Int=>println("this var is int")
      case f:Float=>println("this var is float")
      case p:person=>println("this var is person")
      case _=>println("this var is any type not any real type")
    }
  }

  //scala中可以通过匹配多个字段用  "|"  符号来实现：


  //这里有一点就是当变量都满足这个case中的值的时候，会首先匹配第一个值，当第一个不匹配的时候，
  //才会去匹配第二个值。
  def matchAny(sk:Any): Unit ={
    sk match {
      case 1|2|3=> println("满足1,2,3都是可以的值")
      case s:Int=>println("是数值类型的变量")
    }
  }

  //通过模式匹配来判断类似于java中的父子类中多态的实现：
  /*def getFather(s:a): Unit ={
    case a: b=>println("这个类型的具体的实现是b这个类")
    case b: c=>println("这个类型的具体的实现是c这个类")
  }*/

  //通过模式匹配来匹配一个参数中的数值：
  def getMatchValue(v:Any) ={
    var ousk=v match {
      case o: Int=>3
      case  str:String=>"hellow"
    }
  }

  //scala中通过使用一Some和一None  来实现scala中的Option的模式匹配；
  def getOption(s:Any):Option[Int]={
    s match {
      case 3=>Some(3)
      case default=>None
    }
  }

  //scala中通过样例类来实现模式case的匹配过程：
  trait Animal
  case class Cat(name: String) extends Animal
  case class Dog(name: String) extends Animal
  def caseclass(s: Any): Unit = {
    s match {
      case x: Cat => println("猫的名字是 " + x.name)
      case d: Dog => println("dog'name is " + d.name)
    }
  }

  //case中设置匹配数据的if守卫：
  def testCaseIf(s:Any): Unit ={
    s match {
      case  a if a ==1 =>println("a's value is "+a)
      case b if b.getClass==classOf[String]=>println("b's class is String class")
      case c if c.getClass==classOf[Cat]=>println("c's class is Cat")
    }
  }

  //scala中抛出异常的时候，大多时候是catch，即捕获而不是去throw，下面是catch exception的时候的举例：
  def catchException(): Unit ={
    try{
      var a=3
      println(a)
    }catch {
        case e:Exception=> e.printStackTrace()
    }
  }

  //当需要和java交互，或者需要将异常向外进行抛的时候的解决@throws 加载方法的上来实现：
  @throws
  def throwExc(): Unit = {
    try {
      var ins = Source.fromFile("path")
    } catch  {
      case a: Exception => throw a
    }
  }
/*
* 在这里进行一个介绍，当使用scala中的异常来进行处理的时候，在scala中通常是，将exception直接catch住然后进行处理的
* 但是如果需要将exception 捉住之后，然后向调用这个的方法进行抛出的时候，可以通过在这个方法的脑袋上
* 使用一个@throws  然后将方法中catch住的异常抛出即可。
* */
  //这里是对于上面的方法的一个调用，测试被抛出的异常：
  def  testException(): Unit ={
    try{
    throwExc()
    }catch {
      case e:FileNotFoundException=>{
        println("当前路径下没有找到，需要的文件")
      }
    }
  }

  //scala中的通过输入和输出流来进行对于文件的一个读取和写的操作：
  def fileInAndOut(): Unit ={
    var in=None:Option[FileInputStream]
    var out=None:Option[FileOutputStream]
    try {
      in=Some(new FileInputStream("G:\\workBonc\\mulity_models\\mvn_scala\\ReadMe.txt"))
      out=Some(new FileOutputStream("G:\\workBonc\\mulity_models\\mvn_scala\\out.txt"))
      var c=0
      while ({c=in.get.read();c>0}){
        println(c)
        out.get.write(c)
      }
    } catch {
      case e:Exception=>println()
    }finally {
      if(in.isDefined){
        in.get.close()
      }
      if (out.isDefined)
      out.get.close()
    }
  }




}

class person(name:String)
trait a{}
class b extends  a
class c extends  a
