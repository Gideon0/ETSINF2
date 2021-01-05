-- ***********************************
-- Test - Exercises 7,8,9 - Practice 6
-- ***********************************

import Ej9 -- if code of exercises 7,8,9 were in Ej789P6 module
-- Or not to import such a module and write here the code of exercises 7,8,9

main = do
  let c = Circle 3.0
  let p = Pentagon 4.0 3.0
  let q = Pentagon 3.0 2.0
  putStrLn (show (perimeter c))         -- 18.849556
  putStrLn (show (perimeter p))         -- 20.0
  putStrLn (show (area c))              -- 28.274334
  putStrLn (show (area p))              -- 30.0  
  putStrLn (show (volumePrism c 2.0))   -- 56.548668
  putStrLn (show (volumePrism q 4.0))   -- 60.0
  putStrLn (show (surfacePrism c 2.0))  -- 94.24778
  putStrLn (show (surfacePrism q 5.0))  -- 105.0
  putStrLn (show p)                     -- Pentagon, side: 4.0, apothem: 3.0
  putStrLn (show c)                     -- "Circle, radius: 3.0"
  let c1 = Circle 3.0
  let c2 = Circle 3.3
  putStrLn (show ((c == c1)))           -- True
  putStrLn (show ((c1 == c2)))          -- False
  let p1 = Pentagon 4.0 7.0
  let p2 = Pentagon 4.0 7.0
  let p3 = Pentagon 5.0 3.5
  let p4 = Pentagon 5.0 3.8
  putStrLn (show (p1 == p2))            -- True
  putStrLn (show (p1 == p3))            -- False
  putStrLn (show (p3 == p4))            -- False  
