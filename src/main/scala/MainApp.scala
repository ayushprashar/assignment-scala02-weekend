import Utilities.Calculator.TotalCommission
import Utilities.{ClientSideCommission, Commission, StreetSideCommission}
import org.apache.log4j.Logger

object MainApp extends App {

  val log = Logger.getLogger(this.getClass)

  val listElement1 = 50
  val listElement2 = 100
  val listElement3 = 75
  val listElement4 = 69
  val listElement5 = 89

  val streetListElement1 = new StreetSideCommission(listElement1)
  val streetListElement2 = new StreetSideCommission(listElement2)
  val streetListElement3 = new StreetSideCommission(listElement3)
  val streetListElement4 = new StreetSideCommission(listElement4)
  val streetListElement5 = new StreetSideCommission(listElement5)

  val streetList = List(streetListElement1,streetListElement2,streetListElement3,streetListElement4,streetListElement5)

  val performStreetCalc = new TotalCommission[StreetSideCommission]
  log.info(s"${performStreetCalc.getTotalCommission(streetList)} \n")

  val clientListElement1 = new ClientSideCommission(listElement1)
  val clientListElement2 = new ClientSideCommission(listElement2)
  val clientListElement3 = new ClientSideCommission(listElement3)
  val clientListElement4 = new ClientSideCommission(listElement4)
  val clientListElement5 = new ClientSideCommission(listElement5)

  val clientList = List(clientListElement1,clientListElement2,clientListElement3,clientListElement4,clientListElement5)

  val performClientCalc = new TotalCommission[ClientSideCommission]
  log.info(s"${performClientCalc.getTotalCommission(clientList)} \n")

  val mixList = List(streetListElement1,clientListElement2,streetListElement3,clientListElement4,streetListElement5)

  val performMixCalc = new TotalCommission[Commission]
  log.info(s"${performMixCalc.getTotalCommission(mixList)} \n")

}
