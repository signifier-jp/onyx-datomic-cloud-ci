(defproject onyx-datomic-cloud-ci "0.1.0-SNAPSHOT"
            :description "Continous integration for Onyx Datomic plugin against Datomic Cloud"
            :url "http://example.com/FIXME"
            :local-repo "m2"
            :dependencies [[lambdacd "0.13.5"]
                           [lambdacd-git "0.4.0"]
                           [lambdaui "1.0.0"]
                           [environ "1.1.0"]
                           [http-kit "2.2.0"]
                           [mount "0.1.12"]
                           [org.clojure/clojure "1.8.0"]
                           [org.clojure/tools.logging "0.3.1"]
                           [org.slf4j/slf4j-api "1.7.5"]
                           [ch.qos.logback/logback-core "1.0.13"]
                           [ch.qos.logback/logback-classic "1.0.13"]]
            :profiles {:uberjar {:aot :all}}
            :main onyx-datomic-cloud-ci.core)
