package Utilities

abstract class Commission {
  val value: Int
}

case class ClientSideCommission(override val value: Int) extends Commission

case class StreetSideCommission(override val value: Int) extends Commission



