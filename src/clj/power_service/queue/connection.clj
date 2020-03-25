(ns power-service.queue.connection
  (:require [bunnicula.component.connection :as connection]
            [power-service.config :refer [env]]
            [clojure.tools.logging :as log]))

(defonce conn-atom (atom ()))

(defn make-connection []
  (if (empty? (env :broker-url))
    (do
      (log/info "configuring " (env :broker-host) "/" (env :broker-port) "/" (env :broker-vhost))
      (connection/create {:host (env :broker-host)
                          :port (env :broker-port)
                          :username (env :broker-username)
                          :password (env :broker-password)
                          :vhost (env :broker-vhost)}))
    (do
      (log/info "configuring " (env :broker-url) "/" (env :broker-vhost))
      (connection/create {:url (env :broker-url)
                          :vhost (env :broker-vhost)}))))

(defn connection []
  (if (empty? @conn-atom)
    (do
      (log/info "opening broker connection")
      (reset! conn-atom (make-connection))))

  (log/info "returning broker connection " (:host @conn-atom))
  @conn-atom)



(comment

  (env :broker-vhost)
  (env :broker-url)

  (connection)
  ())



