module Pract5 where
  
  decBin :: Int -> [Int]
  decBin x = if x < 2 then [x]
             else (x `mod` 2) : decBin (x `div` 2)

  binDec :: [Int] -> Int
  binDec (x:[]) = x
  binDec (x:y) = x + binDec y * 2

  divisors :: Int -> [Int]
  divisors x = [d | d <- [1..x], x `mod` d == 0]
  
  divisors2 :: Int -> [Int]
  divisors2 = auxDivisors2 1

  auxDivisors2 :: Int -> Int -> [Int]
  auxDivisors2 a n
    | n == a = [n]
    | n > a && n `mod` a == 0 = a : auxDivisors2 (a + 1) n
    | n > a = auxDivisors2 (a + 1) n
    | otherwise = []

  member :: Int -> [Int] -> Bool
  member x y
    |y == [] = False
    |x == head y = True
    |otherwise = member x (tail y)
  
  isPrime :: Int -> Bool
  isPrime x = if length ([i | i <- [1..x], x `mod` i == 0]) == 2 then True
              else False
                
  primes :: Int -> [Int]
  primes x = take x [p | p <- [1..], isPrime p]
    
  selectEven :: [Int] -> [Int]
  selectEven x
    |x == [] = []
    |(head x `mod` 2 == 0) = (head x:selectEven (tail x))
    |length x == 1 = []
    |otherwise = selectEven (tail x)

  selectEvenPos :: [Int] -> [Int]
  selectEvenPos x = [i | (e,i) <- zip [0.. length(x)] x, e `mod` 2 == 0]

  ins :: Int -> [Int] -> [Int]
  ins x y
    |y == [] = [x]
    |x<=(head y) = x:y
    |otherwise = head y:ins x (tail y)

  iSort :: [Int] -> [Int]
  iSort x
    |x == [] = []
    |otherwise = ins (head x) (iSort (tail x))

  doubleAll :: [Int] -> [Int]
  doubleAll x = map (2*) x

  map' :: (a -> b) -> [a] -> [b]
  map' x y = [x m | m <- y]

  filter' :: (a -> Bool) -> [a] -> [a]
  filter' x y = [f | f <- y, x f]

  
  type Person = String
  type Book = String
  type  Database = [(Person, Book)]
  
  exampleBase :: Database
  exampleBase = [("Alicia", "El nombre de la rosa"), 
                 ("Juan", "La hija del canibal"), 
                 ("Pepe", "Odesa"), 
                 ("Alicia", "La ciudad de las bestias")]

  obtain :: Database -> Person -> [Book]
  obtain dBase thisPerson = [book | (person,book) <- dBase, person == thisPerson]
  
  borrow :: Database -> Book -> Person -> Database
  borrow x l p = x ++ [(p,l)]

  return' :: Database -> (Person, Book) -> Database
  return' x y = [r | r <- x, r /= y]


  data Tree a = Leaf a | Branch (Tree a) (Tree a) deriving Show


  symmetric :: Tree a -> Tree a
  symmetric (Leaf a) = Leaf a
  symmetric (Branch t1 t2) = Branch (symmetric t2) (symmetric t1)

  listToTree :: [a] -> Tree a
  listToTree (x:xs)
    |null xs = Leaf x
    |otherwise = Branch (Leaf x) (listToTree xs)

  treeToList :: Tree a -> [a]
  treeToList (Leaf x) = [x]
  treeToList (Branch x1 x2) = treeToList (x1) ++ treeToList (x2)


  data BinTreeInt = Void | Node Int BinTreeInt BinTreeInt deriving Show
  

  insTree :: Int -> BinTreeInt -> BinTreeInt
  insTree x Void = Node x Void Void
  insTree x (Node y b1 b2)
    |x < y = Node y (insTree x b1) b2
    |x == y = (Node y b1 b2)
    |otherwise = Node y b1 (insTree x b2)
    
  creaTree :: [Int] -> BinTreeInt
  creaTree [] = Void
  creaTree (x:[]) = Node x Void Void
  creaTree (x:xs) = insTree x (creaTree(xs))

  treeElem :: Int -> BinTreeInt -> Bool
  treeElem x Void = False
  treeElem x (Node y b1 b2)
    |x==y = True
    |x<y = treeElem x b1
    |otherwise = treeElem x b2

  repeated :: Int -> [Int] -> Int
  repeated x y
    |y==[] = 0
    |x==head(y) = 1 + repeated x (tail y)
    |otherwise = repeated x (tail y)
  
  concate :: [[a]] -> [a]
  concate x
    |null x = []
    |otherwise = (head x)++concate(tail x)
  
  square :: Int -> Int
  square x = x*x

  -- numleaves :: Tree a -> Int
  numleaves (Leaf x) = 1
  numleaves (Branch a b) = numleaves a + numleaves b

  dupElem :: BinTreeInt -> BinTreeInt
  dupElem Void = Void
  dupElem (Node x b1 b2) = Node (x*2) (dupElem(b1)) (dupElem(b2))


  data Tree' a = Branch' a (Tree' a) (Tree' a) | Void' deriving Show
  

  countProperty :: (a -> Bool) -> (Tree' a) -> Int
  countProperty x Void' = 0
  countProperty x (Branch' y t1 t2) 
    |x y = 1 + (countProperty x t1) + (countProperty x t2)
    |otherwise = (countProperty x t1) + (countProperty x t2)
