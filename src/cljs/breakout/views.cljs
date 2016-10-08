(ns breakout.views
    (:require [re-frame.core :as re-frame :refer [subscribe dispatch]]
              [breakout.views.helpers :refer [background-box translate click-pos]]
              [breakout.views.swatches :refer [color-swatch selection-marker]]
              [breakout.game :as g]))

(defn color-picker []
  (let [selected-idx (subscribe [:color])]
    (fn []
      [:g
       [background-box {:x 0 :y 0 :width 60 :height 310}]
       (for [idx (range 6)]
         [color-swatch {:index idx
                        :key (str "color-" idx)
                        :on-click #(dispatch [:select-color idx])}])
       [selection-marker {:index @selected-idx
                          :key "marker"}]])))

(defn block [{:keys [x y color]}]
  [:rect {:x (g/x->px x)
          :y (g/y->px y)
          :width g/block-width
          :height g/block-height
          :class (g/color-class color)
          :on-click #(dispatch [:block-clicked x y])}])

(defn block-row [{:keys [x blocks]}]
  [:g
   (for [[y color] blocks]
     [block {:x x
             :y y
             :color color
             :key (str x "--" y)}])])

(defn blocks []
  (let [blocks (subscribe [:blocks])]
    (fn []
      [:g
       (for [[x row] @blocks]
         [block-row {:x x
                     :blocks row
                     :key (str "row-" x)}])])))

(defn main-panel []
  [:div.game
   [:h1 "BREAKOUT LEVEL EDITOR"]
   [:svg {:style {:width (+ g/width 70) :height g/height}}
    [background-box {:x 0
                     :y 0
                     :width g/width
                     :height g/height
                     :on-click #(dispatch [:create-block (click-pos %)])}]
    [blocks]
    [translate {:x 1009 :y 0}
     [color-picker]]]
   [:pre (pr-str @re-frame.db/app-db)]])
