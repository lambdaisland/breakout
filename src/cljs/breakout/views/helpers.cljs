(ns breakout.views.helpers)

(defn background-box
  "Draw a grey box with black border, factoring in the border width"
  [x y width height]
  [:rect.fill--gray3.stroke--black {:x (inc x)
                                    :y (inc y)
                                    :width (- width 2)
                                    :height (- height 2)
                                    :key (str "box-" x "--" y)}])

(defn translate
  "Move a group of elements to a new location"
  [attrs & children]
  (into
   [:g {:transform (str "translate(" (attrs :x) " " (attrs :y) ")")}]
   children))
