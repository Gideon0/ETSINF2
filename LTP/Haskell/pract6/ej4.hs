module Ej4 where

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

    instance (Eq a) => Eq (Queue a) where
    
        (==) (EmptyQueue) (EmptyQueue) = True
        (==) (EmptyQueue) (Item a x) = False
        (==) (Item a x) (EmptyQueue) = False
        (==) (Item a x) (Item b y) = a==b && x==y