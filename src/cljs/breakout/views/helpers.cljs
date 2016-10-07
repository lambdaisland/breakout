(ns breakout.views.helpers)

(defn background-box
  "Draw a grey box with black border, factoring in the border width"
  [{:keys [x y width height on-click]}]
  [:rect.fill--gray3.stroke--black {:x (inc x)
                                    :y (inc y)
                                    :width (- width 2)
                                    :height (- height 2)
                                    :on-click on-click}])

(defn translate
  "Move a group of elements to a new location"
  [attrs & children]
  (into
   [:g {:transform (str "translate(" (attrs :x) " " (attrs :y) ")")}]
   children))


(defn click-pos
  "Get the position of a mouse event relative to the element's bounding box."
  [event]
  (let [bounds (.. event -target getBoundingClientRect)
        bounds-left (.-left bounds)
        bounds-top (.-top bounds)
        event-x (.-clientX event)
        event-y (.-clientY event)]
    [(- event-x bounds-left)
     (- event-y bounds-top)]))
