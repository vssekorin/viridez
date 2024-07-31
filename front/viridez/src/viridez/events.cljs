(ns viridez.events
  (:require [re-frame.core :as rf]
            [day8.re-frame.http-fx]
            [ajax.core :as ajax]
            [viridez.db :as db]
            [viridez.config :as config]))

(rf/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(rf/reg-event-fx
  ::navigate
  (fn [_ [_ handler]]
   {:navigate handler}))

(rf/reg-event-fx
 ::set-active-panel
 (fn [{:keys [db]} [_ active-panel]]
   {:db (assoc db :active-panel active-panel)}))

(rf/reg-event-fx
 ::test-result
 (fn [v1 v2]
   (println v1)
   (println v2)))

(rf/reg-event-fx
 ::test
 (fn [_ _]
   {:http-xhrio {:method          :get
                 :uri             (str config/backend-url "/tech/status/")
                 :timeout         5000
                 :response-format (ajax/text-response-format)
                 :on-success      [::test-result]
                 :on-failure      [::test-result]}}))
