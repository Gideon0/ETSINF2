-- ******************************
-- Test - Exercise 6 - Practice 6
-- ******************************

import Ej6 -- if code of exercise 6 were in Ej6P6 module
-- Or not to import such a module and write here the code of exercise 6

main = do
  let c = Circle 3.0
  let p = Pentagon 4.0 3.0
  putStrLn (show (perimeter c)) -- 18.849556
  putStrLn (show (perimeter p)) -- 20.0
  putStrLn (show (area c))      -- 28.274334
  putStrLn (show (area p))      -- 30.0  
