(ns onyx-datomic-cloud-ci.pipeline
  (:require [lambdacd.steps.manualtrigger :refer [wait-for-manual-trigger]]
            [lambdacd.steps.control-flow :refer [either with-workspace]]
            [onyx-datomic-cloud-ci.steps :refer :all]))

#_(def pipeline-def
    `(manualtrigger/wait-for-manual-trigger
      some-step-that-does-nothing
      (in-parallel
       some-step-that-echos-foo
       some-step-that-echos-bar)
      manualtrigger/wait-for-manual-trigger
      some-failing-step))

(def pipeline-def
  `((either
     wait-for-manual-trigger
     wait-for-repo)
    (with-workspace
      clone
      run-tests)))
