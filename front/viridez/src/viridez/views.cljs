(ns viridez.views
  (:require [re-frame.core :as rf]
            [viridez.events :as events]
            [viridez.routes :as routes]
            [viridez.subs :as subs]))


;; home

(defn home-panel []
  (let [name (rf/subscribe [::subs/name])]
    [:div
     [:h1 (str "Hello from " @name ". This is the Home Page.")]
     [:div
      [:button {:on-click #(rf/dispatch [::events/test])} "Test"]
      [:a {:on-click #(rf/dispatch [::events/navigate :about])} "go to About Page"]]]))

(defmethod routes/panels :home-panel [] [home-panel])

;; about

(defn about-panel []
  [:div
   [:h1 "This is the About Page."]
   [:div
    [:a {:on-click #(rf/dispatch [::events/navigate :home])} "go to Home Page"]]])

(defmethod routes/panels :about-panel [] [about-panel])

;; main

(defn main-panel []
  (let [active-panel (rf/subscribe [::subs/active-panel])]
    (routes/panels @active-panel)))
