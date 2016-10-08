(ns breakout.events
  (:require [re-frame.core :as re-frame :refer [reg-event-db]]
            [breakout.db :as db]))

(reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))


(reg-event-db
 :select-color
 (fn [db [_ idx]]
   (assoc db :color idx)))
