
# Sydney-Trains-Parking-App (formerly Metro-Parking-App)

An app developed using Java, which requests and displays the current parking status of all Sydney CarParks connected to the publicly available CarParkAPI, see the **offical** "[OpenData](https://opendata.transport.nsw.gov.au/dataset/car-park-api)" website for official documentation.
<br>

# Tasks

# Issues
- ~~I was getting a FileIOException Error (couldn't find the file).~~
> A: Still not sure why it wasn't working when I specified where it was using the project root. But I solved it by making an assets folder and using the inbuilt getAssets().open([filename]) instead.

<br>

# Things I'd like to get done
- [X] Make a new class for the ~~ApiRequest~~ (name changed to CarParkAPI) function 
- [X] Make new classes for the results from CarParkAPI (read the [documentation]([url](https://opendata.transport.nsw.gov.au/dataset/car-park-api)) for the data structure)
- [X] Make a better GUI <br>
_(Okay the 'GUI' isn't exactly the best, but I want to move onto this)_
- [ ] Incorporate OKHttp/Retrofit for dynamic API requests (need to make sure <5 requests are sent a second)
- [ ] Use notifyDataSetHasChanged() to make the recycler view adapt to the calls (instead of having to wait for all the calls to be done)

# Things that have been done
...
* make a test app where you can navigate two activities

