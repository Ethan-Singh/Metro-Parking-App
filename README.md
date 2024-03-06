
# Sydney-Trains-Parking-App (_formerly Metro-Parking-App_)

An app developed using Java, that requests and displays the current parking status of all Sydney Car Parks connected to the publicly available CarParkAPI, see the  [**offical**](https://opendata.transport.nsw.gov.au/organization/transport-opendata-hub) website for documentation.

<br>

# Milestones
- [X] Displays output for a single car park (in the console using `System.out.println([someOutput])`)
- [X] Displays output for a single car park (on the device using a text field in `activity_main.xml`)
- [X] Uses Java `BufferedReader` to read api key from file instead of hardcoding to a variable
- [X] Uses Android `RecyclerView` to support more efficient displays in the future (when more than one car park status can be displayed)
- [X] Uses asynchronous Android `executor` to request api on a separate thread
- [X] Uses Android `handler` to delay API calls to <5 per second (maximum for a developer)
- [X] Uses `https://github.com/FasterXML/jackson` to load Model classes during `exectuor.execute...` with relevant `JSON` response data (see [OpenData](https://opendata.transport.nsw.gov.au/dataset/car-park-api) for official documentation on response data structure)
- [X] Displays output for all car parks (on the device using `RecylcerView` in `facility_item_row.xml`)
- [X] Create separate Git Branch to test incoporating "Station Lines" i.e. you can sort which station parkings' you want to see, by selecting the line (M, T8, T9...) they run on
- [X]  


- [X] Make a new class for the ApiRequest function
- [X] Make new classes for the results from CarParkAPI (read the [documentation]([url](https://opendata.transport.nsw.gov.au/dataset/car-park-api)) for the data structure)
- [X] Make a better GUI <br>
_(Okay the 'GUI' isn't exactly the best, but I want to move onto this)_
- [ ] Incorporate OKHttp/Retrofit for dynamic API requests (need to make sure <5 requests are sent a second)
- [ ] Use notifyDataSetHasChanged() to make the recycler view adapt to the calls (instead of having to wait for all the calls to be done)

# Things that have been done
...
* make a test app where you can navigate two activities

