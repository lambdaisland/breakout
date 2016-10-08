(ns breakout.views
  (:require [re-frame.core :as re-frame :refer [subscribe dispatch]]
            [breakout.views.helpers :as helpers :refer [background-box translate]]
            [breakout.views.swatches :refer [color-swatch selection-marker]]
            [breakout.game :as g]))

(defn color-picker []
  (let [color-idx (subscribe [:color])]
    (fn []
      [:g
       [background-box {:x 0 :y 0 :width 60 :height 310}]
       (for [idx (range 6)]
         [color-swatch {:index idx
                        :on-click #(dispatch [:select-color idx])
                        :key (str "color-" idx)}])
       [selection-marker {:index @color-idx}]])))

(defn block [{:keys [row column color]}]
  [:rect {:x (g/col->px column)
          :y (g/row->px row)
          :width g/block-width
          :height g/block-height
          :class (g/color-class color)
          :on-click #(dispatch [:block-clicked column row])}])

(defn blocks []
  (let [blocks (subscribe [:blocks])]
    (fn []
      [:g
       (for [[column row color] @blocks]
         [block {:row row
                 :column column
                 :color color
                 :key (str row "--" column)}])])))

(defn main-panel []
  [:div.game
   [:h1 "BREAKOUT LEVEL EDITOR"]
   [:svg {:style {:width (+ g/width 70) :height g/height}}
    [background-box {:x 0
                     :y 0
                     :width g/width
                     :height g/height
                     :on-click #(dispatch [:create-block (helpers/click-pos %)])}]
    [blocks]
    [translate {:x 1009 :y 0}
     [color-picker]]
    ]
   #_[:pre (pr-str @re-frame.db/app-db)]])
