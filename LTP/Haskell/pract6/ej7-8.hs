 module Ej78 where   
    
    type Side = Float
    type Apothem = Float
    type Radius = Float
    type Height = Float
    type Volume = Float
    type Surface = Float

    data Pentagon = Pentagon Side Apothem
    data Circle = Circle Radius
    
    class Shape a where
        perimeter :: a -> Float
        area :: a -> Float
    
    instance Shape Pentagon where
        perimeter (Pentagon s a) = 5 * s
        area (Pentagon s a) = (5 * s * a)/2
        
    instance Shape Circle where
        perimeter (Circle r) = 2 * pi * r
        area (Circle r) = pi*(r^2)
        
    volumePrism :: (Shape a) => a -> Height -> Volume
    volumePrism base height = (area base) * height

    surfacePrism :: (Shape a) => a -> Height -> Surface
    surfacePrism base height = 2*area(base) + perimeter(base)*height