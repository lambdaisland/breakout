(ns breakout.events
  (:require [re-frame.core :as re-frame :refer [reg-event-db]]
            [breakout.db :as db]
            [breakout.game :as g]))

(reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))


(reg-event-db
 :select-color
 (fn [db [_ idx]]
   (assoc db :color idx)))


(reg-event-db
 :create-block
 (fn [db [_ [x y]]]
   (update db :blocks
           assoc [(g/px->col x)
                  (g/px->row y)]
           (:color db))))
