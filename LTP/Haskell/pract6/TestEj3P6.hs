-- ******************************
-- Test - Exercise 3 - Practice 6
--
-- Execute this program to test: 
-- * Queue v2, Show instance
-- ******************************

import Ej3

main = do
   -- testing Show ...
   putStrLn ("testing Show in Queue v2 ...")
   
   -- some examples of queues of integers
   let e = empty :: Queue Int
   putStrLn ("e = " ++ show e)
   let q = (enqueue 42 (enqueue 28 (enqueue 14 (enqueue 71 empty))))
   putStrLn ("q = " ++ show q)
   let p = dequeue q
   putStrLn ("p = " ++ show p)
   let q = (enqueue 34 (enqueue 59 (enqueue 82 (enqueue 6 p))))
   putStrLn ("q = " ++ show q)
   let r = p   
   putStrLn ("r = " ++ show r)
   let s = dequeue (dequeue (dequeue r))   
   putStrLn ("s = " ++ show s)

   -- some examples of queues of strings
   let x = empty :: Queue String
   putStrLn ("x = " ++ show x)
   let y = (enqueue "sal" (enqueue "tomate" (enqueue "pimienta" x)))
   putStrLn ("y = " ++ show y)
   let z = dequeue y
   putStrLn ("z = " ++ show z)
   
