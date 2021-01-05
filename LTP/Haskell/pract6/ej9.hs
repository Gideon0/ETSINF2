module Ej9 where

    type Side = Float
    type Apothem = Float
    type Radius = Float
    type Height = Float
    type Volume = Float
    type Surface = Float

    data Pentagon = Pentagon Side Apothem
    data Circle = Circle Radius

    class (Eq a, Show a) => Shape a where
        perimeter :: a -> Float
        area :: a -> Float
    
    instance Eq Pentagon where
        Pentagon a c == Pentagon b d = a==b && c==d
    instance Show Pentagon where
        show (Pentagon a b) = "Pentagon (Side= " ++ show a ++ ", Apothem= " ++ show b ++ ")"
    instance Shape Pentagon where
        perimeter (Pentagon s a) = 5 * s
        area (Pentagon s a) = (5 * s * a)/2
        
    instance Eq Circle where
        Circle a == Circle b = a==b
    instance Show Circle where
        show (Circle r) = "Circle (Radius= " ++ show r ++ ")"
    instance Shape Circle where
        perimeter (Circle r) = 2 * pi * r
        area (Circle r) = pi*(r^2)
    
    volumePrism :: (Shape a) => a -> Height -> Volume
    volumePrism base height = (area base) * height

    surfacePrism :: (Shape a) => a -> Height -> Surface
    surfacePrism base height = 2*area(base) + perimeter(base)*height