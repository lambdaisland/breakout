(ns breakout.events
  (:require [re-frame.core :as re-frame :refer [reg-event-db reg-event-fx]]
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


(reg-event-fx
 :block-clicked
 (fn [cofx [_ col row]]
   (if (= (-> cofx :db :color) 5)
     {:dispatch [:remove-block [col row]]}
     {:dispatch [:update-block [col row]]})))

(reg-event-db
 :update-block
 (fn [db [_ coords]]
   (update db :blocks assoc coords (:color db))))

(reg-event-db
 :remove-block
 (fn [db [_ coords]]
   (update db :blocks dissoc coords)))
