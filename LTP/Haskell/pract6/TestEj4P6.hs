-- ******************************
-- Test - Exercise 4 - Practice 6
--
-- Execute this program to test: 
-- * Queue v1 (recursive), 
-- * Show and Eq instances
-- ******************************

import Ej4

main = do
   -- -- testing Show ...
   putStrLn ("testing Show in Queue v1 ...")
   
   -- an empty queue
   let e = empty :: Queue Int
   putStrLn ("e = " ++ show e)
   
   -- a queue after queueing 4 elements
   let q = (enqueue 42 (enqueue 28 (enqueue 14 (enqueue 71 empty))))
   putStrLn ("q = " ++ show q)
   
   -- a queue after dequeueing 1 element
   let p = dequeue q
   putStrLn ("p = " ++ show p)
   
   -- a queue after queueing another 4 elements
   let q = (enqueue 34 (enqueue 59 (enqueue 82 (enqueue 6 p))))
   putStrLn ("q = " ++ show q)
   
   -- a queue equals the previous one
   let r = p   
   putStrLn ("r = " ++ show r)
   
   -- another empty queue
   let s = dequeue (dequeue (dequeue r))   
   putStrLn ("s = " ++ show s)
   
   -- testing Eq ...
   putStrLn ("testing Eq in Queue v1 ...")
   putStrLn ("e == s = " ++ show(e == s))
   putStrLn ("e == q = " ++ show(e == q))
   putStrLn ("p == q = " ++ show(p == q))
   putStrLn ("r == p = " ++ show(r == p))
   putStrLn ("r == q = " ++ show(r == q))
 
