<img src="/DEMO/App-Logo.svg" width="100"/>

# Metro-Parking-App
(_also known as the Sydney Trains Parking App_)
<br>

An app developed using Java, that requests and displays the current parking status of all Sydney Car Parks connected to the publicly available CarParkAPI, see the  [**offical**](https://opendata.transport.nsw.gov.au/organization/transport-opendata-hub) website for documentation

<br>

<p align="center">
  <img src="/DEMO/App-demo.gif" width="199"/>
  <img src="/DEMO/App-Lines.png" width="199"/>
  <img src="/DEMO/App-Parkings.png" width="199"/>
  <img src="/DEMO/App-Parkings2.png" width="199"/>
</p>

# Features
* **O(1) lookup** [^1]:
* **O(n) calls** [^2]
* Refresh

[^1]: because the "Line names", and "Facility id's" are stored in a `HashMap` the lookup for the key/value pair (Line name/Facility id)
[^2]: where n is the relevant facilities: because the "Line names", and "Facility id's" are stored in a `HashMap` the API requests are only  for carparks that belong to the key (Station Line), decreasing the length of calling significantly `6.6s -> 0.5s calls` in lines like the "T2"(only one car park available

# Milestones
- [X] Displays output for a single car park in the console (`System.out.println([someOutput])`) 
- [X] Displays output for a single car park on the device (text field in `activity_main.xml`)
- [X] Uses Java `BufferedReader` to more securely read API key (from file instead of hardcoded as a variable)
- [X] Uses Android `RecyclerView` to support a more efficient future `View`s (when more than one car park is be displayed)
- [X] Uses asynchronous Android `executor` to call the CarParkAPI on a separate thread
- [X] Uses Android `handler` to delay API calls to <=5 per second (maximum for a developer)
- [X] Uses `https://github.com/FasterXML/jackson` to load Model classes with relevant `JSON` response during `exectuor.execute...` (see [OpenData](https://opendata.transport.nsw.gov.au/dataset/car-park-api) for official documentation on response data structure)
- [X] Uses `Map<Integer>, List<String>>` to load the relevant "Station Line" onto new objects, and store facility id's for API calling
- [X] Displays output for all car parks connected to the API on the device (using `RecylcerView`)
- [X] Create a separate Git Branch to test sorting by "Station Line" i.e. You select which Line you want to see parking for (M, T1, T2...)
- [X] Uses Android `ViewBinding` - faster, null safe, type safe, instead of `findViewById()` (see [Android Developers](https://developer.android.com/topic/libraries/view-binding) for official documentation on the benefits of `ViewBinding`)
- [X] Uses Android `RecyclerView` to display various Lines
- [X] Uses Android `View.OnClickListener` within the `RecyclerView` Adapter to allow users to select a Line and see relevant parking (i.e. "M" -> Tallawong Parking, Kellyville Parking etc.)
- [X] Make the new branch the new "main"
- [X] Update the Android `CardView` for the Facility `RecyclerView` to conform to the official [Material Design Card](https://m3.material.io/components/cards/overview) specifications for Android
- [X] Make a Logo for the App
- [ ] Use the Android `keystore` to store the API key for the APK instead of having it in an unencrypted text file (Not high priority, as you need your own API key to use the app in it's current state)


