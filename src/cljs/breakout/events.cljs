(ns breakout.events
  (:require [re-frame.core :refer [reg-event-db reg-event-fx]]
            [breakout.db :as db]
            [breakout.game :as g]))

(reg-event-db :initialize-db
              (fn  [_ _]
                db/default-db))

(reg-event-db :select-color
              (fn [db [_ idx]]
                (assoc db :selected-color idx)))

(reg-event-db :create-block
              (fn [db [_ [x y]]]
                (update db :blocks
                        assoc [(g/px->x x)
                               (g/px->y y)]
                        (:selected-color db))))

(reg-event-db :update-block
              (fn [db [_ coords]]
                (update db :blocks assoc coords (:selected-color db))))

(reg-event-db :remove-block
              (fn [db [_ coords]]
                (update db :blocks dissoc coords)))

(reg-event-fx :block-clicked
              (fn [cofx [_ x y]]
                (if (= (-> cofx :db :selected-color) 5)
                  {:dispatch [:remove-block [x y]]}
                  {:dispatch [:update-block [x y]]})))
