module Ej6 where

    type Side = Float
    type Apothem = Float
    type Radius = Float
    
    data Shape = Pentagon Side Apothem | Circle Radius deriving (Eq, Show)

    perimeter :: Shape -> Float
    perimeter (Pentagon s a) = 5 * s
    perimeter (Circle r) = 2 * pi * r

    area :: Shape -> Float
    area (Pentagon s a) = (5 * s * a)/2
    area (Circle r) = pi*(r^2)