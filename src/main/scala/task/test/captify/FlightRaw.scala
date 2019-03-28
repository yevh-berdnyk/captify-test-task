package task.test.captify

class FlightRaw(
                 var year: Int,
                 var quarter: Int,
                 var month: Int,
                 var day_of_month: Int,
                 var day_of_week: Int,
                 var fl_date: String,
                 var origin: String,
                 var dest: String
               ) {

  override def toString = s"\nFlightRaw($year, $quarter, $month, $day_of_month, $day_of_week, $fl_date, $origin, $dest)"
}