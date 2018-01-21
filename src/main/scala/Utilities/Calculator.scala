package Utilities
import scala.reflect.runtime.universe.{typeOf,TypeTag}

object Calculator {

  private sealed trait CommissionDisplay {
    def totalDisplayCommission: String
  }

  private implicit class Display[T <: Commission: TypeTag](domain: List[T]) extends CommissionDisplay {
    override def totalDisplayCommission: String = {
      typeOf[T] match {
        case client if client =:= typeOf[ClientSideCommission] =>
          s"Client side commission is ${domain.foldLeft(0)((a,b)=> a + b.value)}"
        case street if street =:= typeOf[StreetSideCommission] =>
          s"Street side commission is ${domain.foldLeft(0)((a,b)=> a + b.value)}"
        case _ =>s"Mingled commission is ${domain.foldLeft(0)((a,b)=> a + b.value)}"
      }
    }
  }

  class TotalCommission[T <: Commission : TypeTag] {
    def getTotalCommission(domain: List[T]): String = {
      domain.totalDisplayCommission
    }
  }

}
