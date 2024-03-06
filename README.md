
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
- [X] Uses `Map<Integer>, List<String>>` to load relevant "Station Line" onto new objects, and store facility id's for API calls
- [X] Displays output for all car parks (on the device using `RecylcerView` in `facility_item_row.xml`)
- [X] Create separate Git Branch to test sorting by "Station Line" i.e. you can sort which station parkings you want to see, by selecting the line (M, T8, T9...)

# Features
* Because the "Line names", and "Facility id's" are stored in a `HashMap` the lookup for the key/value pair (Line name/Facility id) is always O(1).
* Because the "Line names", and "Facility id's" are stored in a `HashMap` the API requests can only be for carparks that belong to the key (Station Line), decreasing the length of loading significantly `6.6s -> 0.5s call` in cases like the "T2" line (only one car park available)

