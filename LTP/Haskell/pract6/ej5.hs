module Ej5 where

    data Queue a = EmptyQueue | Item a (Queue a) deriving Show
    
    empty = EmptyQueue
    enqueue x EmptyQueue = Item x EmptyQueue
    enqueue x (Item a q) = Item a (enqueue x q)
    dequeue (Item _ q) = q
    first (Item a _) = a
    isEmpty EmptyQueue = True
    isEmpty _ = False
    size EmptyQueue = 0
    size (Item _ q) = 1 + size q

    toList :: (Queue a) -> [a]
    toList x
        |isEmpty x = []
        |otherwise = (first x):(toList(dequeue x))

    fromList :: [a] -> (Queue a)
    fromList x
        |null x = empty
        |otherwise = enqueue (last x) (fromList (take ((length x) - 1) x))
