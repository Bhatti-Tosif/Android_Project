package com.example.android_practice.screens.tagB.dataModel

object Data {
    private val RentalList = ArrayList<RentalModel>()
    fun getRentalData(): java.util.ArrayList<RentalModel> {
        RentalList.add( RentalModel("A1B1C1","24582- Alpha mall Parking",ReservationType.Daily, "Oct 15,2020", "Oct 15,2020", 20,"8:00" ,"8:00",null,false) )
        RentalList.add( RentalModel("A1B1C1","24582- Alpha mall Parking",ReservationType.Daily, "Oct 15,2020", "Oct 15,2020", 20,"8:00" ,"8:00",4.2,false) )
        RentalList.add( RentalModel("A1B1C1","24582- Alpha mall Parking",ReservationType.Monthly, "Oct 15,2020", "Oct 15,2020", 20,"8:00" ,"8:00",null,false) )
        RentalList.add( RentalModel("A1B1C1","24582- Alpha mall Parking",ReservationType.Daily, "Oct 15,2020", "Oct 15,2020", 20,"8:00" ,"8:00",4.2,false) )
        RentalList.add( RentalModel("A1B1C1","24582- Alpha mall Parking",ReservationType.Hourly, "Oct 15,2020", "Oct 15,2020", 20,"8:00" ,"8:00",null,false) )
        RentalList.add( RentalModel("A1B1C1","24582- Alpha mall Parking",ReservationType.Daily, "Oct 15,2020", "Oct 15,2020", 20,"8:00" ,"8:00",4.2,false) )
        return RentalList
    }
}
enum class ReservationType {
    Hourly,
    Daily,
    Monthly
}