# Metro-Parking-App
 An app developed using Java which requests the current parking status of the Sydney Metro Car Parks using the public CarParkAPI
 
# Issues
~~I am currently getting a 501 response from the server (too many requests), however, I've done some testing using https://jsonplaceholder.typicode.com/ and I should only be requesting once on startup. I am in the process of adding a refresh function to confirm.~~
A: If you call the api directly /carpark/ without specifying which one, it calls all of them, which translates into >5 requests a second as there are >5 metro car parks.
 

~~I was getting a FileIOException Error (couldn't find the file).~~
 A: Still not sure why it wasn't working when I specified where it was using the project root. But I solved it by making an assets folder and using the inbuilt getAssets().open([filename]) instead.

# Things I'd like to get done
[ ] Make a new class for the ApiRequest function 
[ ] Make new classes for the results from APIRequest (read the documentation for the data structure)
[ ] Make a better GUI
[ ] Incorporate OKHttp/Retrofit for dynamic API requests 
