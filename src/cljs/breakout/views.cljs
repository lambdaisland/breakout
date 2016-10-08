(ns breakout.views
  (:require [re-frame.core :as re-frame]
            [breakout.views.helpers :refer [background-box translate]]
            [breakout.views.swatches :refer [color-swatch selection-marker]]
            [breakout.game :as g]))

(defn color-picker []
  [:g
   [background-box {:x 0 :y 0 :width 60 :height 310}]
   (for [idx (range 6)]
     [color-swatch {:index idx
                    :key (str "color-" idx)}])
   [selection-marker {:index 0
                      :key "marker"}]])

(defn block [{:keys [row column color]}]
  [:rect {:x (g/col->px column)
          :y (g/row->px row)
          :width g/block-width
          :height g/block-height
          :class (g/color-class color)}])

(defn blocks []
  (let [blocks [[3 5 0] [2 8 1] [1 1 4]]]
    [:g
     (for [[column row color] blocks]
       [block {:row row
               :column column
               :color color
               :key (str row "--" column)}])]))

(defn main-panel []
  [:div.game
   [:h1 "BREAKOUT LEVEL EDITOR"]
   [:svg {:style {:width (+ g/width 70) :height g/height}}
    [background-box {:x 0 :y 0 :width g/width :height g/height}]
    [blocks]
    [translate {:x 1009 :y 0}
     [color-picker]]]])
