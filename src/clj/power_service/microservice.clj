(ns power-service.microservice
  (:require [power-service.power-data-service :as pds]
            [power-service.queue.publisher :as publisher]))

;get env variables to have variable sleep time

(def datasources
  [{:name    :power-data
    :read-fn :power-service.power-data-service/fetch-data}
   ;:schedule {:in    [0 :seconds]
   ;           :every [30 :seconds]}}
   ])



(defn start [ms]
  (while true
    ;(prn (pds/fetch-data))
    (publisher/publish {:exchange "my-exchange" :queue "power.queue"
                         :msg_type "edn" :content (pds/fetch-data)})
    (Thread/sleep ms)))
