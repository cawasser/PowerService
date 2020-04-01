(ns power-service.microservice
  (:require [power-service.power-measurement-service :as pms]
            [power-service.queue.publisher :as publisher]))


(defn start [ms]
  (while true
    ;(prn (pms/fetch-data))
    (publisher/publish {:exchange "my-exchange" :queue "power.queue"
                         :msg_type "edn" :content (pms/fetch-data)})
    (Thread/sleep ms)))
