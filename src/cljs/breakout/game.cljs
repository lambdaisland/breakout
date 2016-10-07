(ns breakout.game)

(def width 1000)
(def height 560)

(def swatch-size 40)
(def swatch-margin 10)

(def block-width 188)
(def block-height 28)
(def block-margin 10)

(def block-colors ["fill--color1 stroke--black"
                   "fill--color2 stroke--black"
                   "fill--color3 stroke--black"
                   "fill--color4 stroke--gray1"
                   "fill--color5 stroke--gray1"
                   "fill--gray3 stroke--gray1 stroke--dashed"])

(defn color-class [col-idx]
  (get block-colors col-idx))

(defn block-attrs [x y color]
  {:x (+ block-margin (* x (+ block-width block-margin)))
   :y (+ block-margin (* y (+ block-height block-margin)))
   :width block-width
   :height block-height
   :class (color-class color)})
