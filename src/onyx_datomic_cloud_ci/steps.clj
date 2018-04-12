(ns onyx-datomic-cloud-ci.steps
  (:require [environ.core :refer [env]]
            [lambdacd-git.core :as git]
            [lambdacd.steps.shell :as shell]))

(def onyx-datomic-repo "https://github.com/onyx-platform/onyx-datomic.git")

(def branch (or (env :onyx-datomic-branch) "master"))

(defn wait-for-repo [_ ctx]
  (git/wait-for-git ctx onyx-datomic-repo :ref branch))

(defn clone [args ctx]
  (git/clone ctx onyx-datomic-repo branch (:cwd args)))

(defn run-tests [{cwd :cwd} ctx]
  (shell/bash ctx cwd
              {"DATOMIC_CLOUD_PROXY_PORT" (env :datomic-cloud-proxy-port)
               "DATOMIC_CLOUD_QUERY_GROUP" (env :datomic-cloud-query-group)
               "DATOMIC_CLOUD_REGION" (env :datomic-cloud-region)
               "DATOMIC_CLOUD_SYSTEM" (env :datomic-cloud-system)}
              "lein with-profile cloud test :cloud"))
