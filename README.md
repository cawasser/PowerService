# power-service

generated using Luminus version "3.63"

A microservice that emits generated power management data at a 
specified interval to a RabbitMQ queue.

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To set the duration of time between produced messages, you must 
set a `service_delay=5000` environment variable in your given environment.
Delay is set in millisecond, 5000 is equal to 5 seconds.

You also must be running a RabbitMQ broker instance, either locally or in a docker.
This service is hardcoded to emit to `my-exchange`// `power.queue`.

You will need a local copy of the `dev-config.edn` file at the root dir that should contain something like this:
    
    {:dev true
     :port 5001
     :nrepl-port 7001
    
     :service-delay 5000

     :broker-host "127.0.0.1"
     :broker-port 5672
     :broker-username "guest"
     :broker-password "guest"
     :broker-vhost "/main"
    }

To start the web server for the application, run:

    lein run 

You should see messages being produced to the specified queue in your RabbitMQ console.
## License

Copyright © 2020 FIXME
