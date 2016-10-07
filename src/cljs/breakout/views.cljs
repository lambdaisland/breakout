(ns breakout.views
    (:require [re-frame.core :as re-frame]
              [breakout.helpers :refer [background-box translate]]
              [breakout.game :as g]))

(defn color-swatch [index]
  (let [size g/swatch-size
        margin g/swatch-margin]
    [:rect {:class (g/color-class index)
            :x margin
            :y (+ margin (* index (+ margin size)))
            :width size
            :height size}]))

(defn selection-marker [index]
  (let [size g/swatch-size
        margin g/swatch-margin]
    [:rect {:x (- margin 3)
            :y (+ margin (* index (+ margin size)) -3)
            :width (+ size 6)
            :height (+ size 6)
            :stroke "white"
            :stroke-width 3
            :fill-opacity "0"}]))

(defn color-selector []
  [:g
   [background-box 0 0 60 310]
   (for [idx (range (count g/block-colors))]
     [color-swatch idx])
   [selection-marker 0]])

(defn block [[x y color]]
  [:rect (g/block-attrs x y color)])

(defn blocks []
  (let [blocks [[3 5 0] [2 8 1] [1 1 4]]]
    [:g (map block blocks)]))

(defn main-panel []
  [:div.game
   [:h1 "BREAKOUT LEVEL EDITOR"]
   [:svg {:style {:width (+ g/width 70) :height g/height}}
    [background-box 0 0 g/width g/height]
    [blocks]
    [translate {:x 1009 :y 0}
     [color-selector]]]])
