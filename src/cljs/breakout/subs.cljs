(ns breakout.subs
    (:require [re-frame.core :refer [reg-sub]]))

(reg-sub :color
         (fn [db _]
           (:selected-color db)))

(reg-sub :blocks
         (fn [db _]
           (:blocks db)))
