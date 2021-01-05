-- ******************************
-- Test - Exercise 5 - Practice 6
--
-- Execute this program to test: 
-- * Queue v2, toList, fromList
-- ******************************

import Ej5 -- if toList and fromList were in Ej5P6 module
-- Or not to import Ej5P6 module and write here toList and fromList functions

main = do
   let queue0 = empty :: Queue Int
   let queue1 = dequeue (enqueue 1 empty)
   let queue2 = enqueue 10 (enqueue 5 empty)
   let queue3 = enqueue 20 (enqueue 10 (enqueue 5 empty))
   let queue4 = enqueue "ana" (enqueue "isabel" (enqueue "lola" empty))
   let queue5 = empty :: Queue String
   let queue6 = enqueue "javi" (enqueue "luis" (enqueue "pepe" queue4))
   
   putStrLn ("queue0 = " ++ show queue0)
   putStrLn ("queue1 = " ++ show queue1)
   putStrLn ("queue2 = " ++ show queue2)
   putStrLn ("queue3 = " ++ show queue3)
   putStrLn ("queue4 = " ++ show queue4)
   putStrLn ("queue5 = " ++ show queue5)
   putStrLn ("queue6 = " ++ show queue6)

   putStrLn ("list queue0 = " ++ show (toList queue0))
   putStrLn ("list queue1 = " ++ show (toList queue1))
   putStrLn ("list queue2 = " ++ show (toList queue2))
   putStrLn ("list queue3 = " ++ show (toList queue3))
   putStrLn ("list queue4 = " ++ show (toList queue4))
   putStrLn ("list queue5 = " ++ show (toList queue5))
   putStrLn ("list queue6 = " ++ show (toList queue6))

   let lista0 = [] :: [Int]
   let lista1 = [0]
   let lista2 = [1,2,3]
   let lista3 = ["a","b","c","d","e","f"]
   let lista4 = ["lola","isabel","ana","pepe","luis","javi"]

   putStrLn ("queue lista0 = " ++ show (fromList lista0)) 
   putStrLn ("queue lista1 = " ++ show (fromList lista1))
   putStrLn ("queue lista2 = " ++ show (fromList lista2))
   putStrLn ("queue lista3 = " ++ show (fromList lista3))
   putStrLn ("queue lista4 = " ++ show (fromList lista4))

   putStrLn ("program ended\n");
