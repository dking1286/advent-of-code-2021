(ns dev.dking.advent-2021.day-1
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def part-1-example [199
                     200
                     208
                     210
                     100
                     207
                     240
                     269
                     260
                     263])

(defn part-1
  []
  (->> (str/split-lines (slurp (io/file (io/resource "day_01_part_01.txt"))))
       (map #(Integer/parseInt %))
       (partition 2 1)
       (filter (fn [[x y]] (> y x)))
       count))

(defn part-2
  []
  (->> (str/split-lines (slurp (io/file (io/resource "day_01_part_01.txt"))))
       (map #(Integer/parseInt %))
       (partition 3 1)
       (map (partial reduce +))
       (partition 2 1)
       (filter (fn [[x y]] (> y x)))
       count))

(comment
  (->> (str/split-lines (slurp (io/file (io/resource "day_01_part_01.txt"))))
       (map #(Integer/parseInt %))
       (partition 2 1)
       (filter (fn [[x y]] (> y x)))
       count)

  (->> part-1-example
       (partition 3 1)
       (map (partial reduce +))
       (partition 2 1)
       (filter (fn [[x y]] (> y x)))
       count)

  (->> (str/split-lines (slurp (io/file (io/resource "day_01_part_01.txt"))))
       (map #(Integer/parseInt %))
       (partition 3 1)
       (map (partial reduce +))
       (partition 2 1)
       (filter (fn [[x y]] (> y x)))
       count))