module Pract4 where

  import Data.Char
  nextchar :: Char -> Char
  nextchar c = chr ((ord c) + 1)
  
  fact :: Int -> Int
  fact 0 = 1
  fact n = n * fact (n - 1)
  
  numCbetw2 :: Char -> Char -> Int
  numCbetw2 a b
    |a==b = 0 
    |otherwise = abs(ord a - ord b) - 1

  addRange :: Int -> Int -> Int
  addRange a b
    |a==b = a
    |a>b = a + (addRange (a-1) b)
    |otherwise = a + (addRange (a+1) b)

  max' :: Int -> Int -> Int
  max' a b
    |a>=b = a
    |otherwise = b

  leapyear :: Int -> Bool
  leapyear a
    |(mod a 400) == 0 = True
    |(mod a 100) == 0 = False
    |(mod a 4) == 0 = True
    |otherwise = False

  daysAmonth :: Int -> Int -> Int
  daysAmonth a b
    |a==2 && leapyear b = 29
    |a==2 && not (leapyear b) = 28
    |a < 8 && (mod a 2) == 0 = 30
    |a >= 8 && (mod a 2) /= 0 = 30
    |otherwise = 31

  remainder :: Int -> Int -> Int
  remainder a b
    |a==b = 0
    |a<b = a
    |otherwise = remainder (a-b) b

  sumFacts :: Int -> Int
  sumFacts a
    |a == 1 = 1
    |otherwise = (fact a) + sumFacts(a-1)