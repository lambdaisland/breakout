(ns breakout.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame :refer [reg-sub]]))

(reg-sub
 :color
 (fn [db]
   (:color db)))

(reg-sub
 :blocks
 (fn [db]
   (map (fn [[[col row] color]]
          [col row color])
        (:blocks db))))
