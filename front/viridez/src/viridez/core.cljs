(ns viridez.core
  (:require [reagent.dom :as rdom]
            [re-frame.core :as rf]
            [viridez.events :as events]
            [viridez.routes :as routes]
            [viridez.views :as views]
            [viridez.config :as config]))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (rf/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/main-panel] root-el)))

(defn init []
  (routes/start!)
  (rf/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
