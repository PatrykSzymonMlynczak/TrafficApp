TrafficApp
------


### About: 
This application calculate travel time between two locations.
Created to find good time to travel without wasting time.


### Properties

`here.api.key=your_HERE_api_key`
`here.destination="destination place address"`
`here.start="starting point address "`
`hourly.schedule.interval=schedule_time_in_ms`


### How to run ? 
To run need ApiKey form HERE (it's a service name)
Need to create account, add credit card and generate ApiKey
https://platform.here.com/sign-up?step=verify-identity
Exceeding 30000 requests per month is paid !!

With set properties, just run app. 
Running app with defined schedule interval 60000, destination "Katowice" and staring point "Łaziska" 
will be saving on each minute travel times into file `travel_times.txt`
