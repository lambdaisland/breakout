(ns breakout.views.swatches
  (:require [breakout.game :as g]))

(defn color-swatch [{:keys [index on-click]}]
  (let [size g/swatch-size
        margin g/swatch-margin]
    [:rect {:class (g/color-class index)
            :x margin
            :y (+ margin (* index (+ margin size)))
            :width size
            :height size
            :on-click on-click}]))

(defn selection-marker [{:keys [index]}]
  (let [size g/swatch-size
        margin g/swatch-margin]
    [:rect {:x (- margin 3)
            :y (+ margin (* index (+ margin size)) -3)
            :width (+ size 6)
            :height (+ size 6)
            :stroke "white"
            :stroke-width 3
            :fill-opacity "0"}]))
