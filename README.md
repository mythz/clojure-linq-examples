101 LINQ Samples in Clojure
===========================

Port of [C#'s' 101 LINQ Samples](http://code.msdn.microsoft.com/101-LINQ-Samples-3fb9811b) translated into Clojure.

Execute and display the results of all the examples with:

    lein run

_Note: Run specific examples by excluding others in [core.clj -main](https://github.com/mythz/clojure-linq-examples/blob/master/src/clj_linq/core.clj). You can also compare these [LINQ examples in Dart](https://github.com/dartist/101LinqSamples)._

#### Contributions into more idiomatic and readable Clojure examples are welcome!

#### [LINQ - Restriction Operators](https://github.com/mythz/clojure-linq-examples/blob/master/src/clj_linq/linq_restrictions.clj) / [MSDN C#](http://code.msdn.microsoft.com/LINQ-to-DataSets-09787825)
#### [LINQ - Projection Operators](https://github.com/mythz/clojure-linq-examples/blob/master/src/clj_linq/linq_projections.clj) / [MSDN C#](http://code.msdn.microsoft.com/LINQ-Partitioning-Operators-c68aaccc)
#### [LINQ - Partitioning Operators](https://github.com/mythz/clojure-linq-examples/blob/master/src/clj_linq/linq_partitioning.clj) / [MSDN C#](http://code.msdn.microsoft.com/SQL-Ordering-Operators-050af19e)
#### [LINQ - Ordering Operators](https://github.com/mythz/clojure-linq-examples/blob/master/src/clj_linq/linq_ordering.clj) / [MSDN C#](http://code.msdn.microsoft.com/SQL-Ordering-Operators-050af19e)
#### [LINQ - Grouping Operators](https://github.com/mythz/clojure-linq-examples/blob/master/src/clj_linq/linq_grouping.clj) / [MSDN C#](http://code.msdn.microsoft.com/LINQ-to-DataSets-Grouping-c62703ea)
#### [LINQ - Set Operators](https://github.com/mythz/clojure-linq-examples/blob/master/src/clj_linq/linq_setoperators.clj) / [MSDN C#](http://code.msdn.microsoft.com/LINQ-Set-Operators-374f34fe)
#### [LINQ - Conversion Operators](https://github.com/mythz/clojure-linq-examples/blob/master/src/clj_linq/linq_conversions.clj) / [MSDN C#](http://code.msdn.microsoft.com/LINQ-Conversion-Operators-e4e59714)
#### [LINQ - Element Operators](https://github.com/mythz/clojure-linq-examples/blob/master/src/clj_linq/linq_elementoperators.clj) / [MSDN C#](http://code.msdn.microsoft.com/LINQ-Element-Operators-0f3f12ce)
#### [LINQ - Generation Operators](https://github.com/mythz/clojure-linq-examples/blob/master/src/clj_linq/linq_generationoperators.clj) / [MSDN C#](http://code.msdn.microsoft.com/LINQ-Generation-Operators-8a3fbff7)
#### [LINQ - Quantifiers](https://github.com/mythz/clojure-linq-examples/blob/master/src/clj_linq/linq_quantifiers.clj) / [MSDN C#](http://code.msdn.microsoft.com/LINQ-Quantifiers-f00e7e3e)
#### [LINQ - Aggregate Operators](https://github.com/mythz/clojure-linq-examples/blob/master/src/clj_linq/linq_aggregateoperators.clj) / [MSDN C#](http://code.msdn.microsoft.com/LINQ-Aggregate-Operators-c51b3869)
#### [LINQ - Miscellaneous Operators](https://github.com/mythz/clojure-linq-examples/blob/master/src/clj_linq/linq_miscoperators.clj) / [MSDN C#](http://code.msdn.microsoft.com/LINQ-Miscellaneous-6b72bb2a)
#### [LINQ - Query Execution](https://github.com/mythz/clojure-linq-examples/blob/master/src/clj_linq/linq_queryexecution.clj) / [MSDN C#](http://code.msdn.microsoft.com/LINQ-Query-Execution-ce0d3b95)
#### [LINQ - Join Operators](https://github.com/mythz/clojure-linq-examples/blob/master/src/clj_linq/linq_joinoperators.clj) / [MSDN C#](http://code.msdn.microsoft.com/LINQ-Join-Operators-dabef4e9)

##  Side-by-side - C# LINQ vs Clojure

For a side-by-side comparison, the original **C#** source code is displayed above the equivalent **Clojure** translation.

  - The **Output** shows the console output of running the **Clojure** sample.
  - Outputs ending with `...` illustrates only a partial response is displayed.
  - The source-code for C# and Clojure utils used are included once under the first section they're used in.
  - The C# ObjectDumper util used is downloadable from MSDN - [ObjectDumper.zip](http://code.msdn.microsoft.com/Visual-Studio-2008-C-d295cdba/file/46086/1/ObjectDumper.zip)

LINQ - Restriction Operators
----------------------------

### linq1: Where - Simple 1

```csharp
//c#
public void Linq1()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var lowNums =
        from n in numbers
        where n < 5
        select n;

    Console.WriteLine("Numbers < 5:");
    foreach (var x in lowNums)
    {
        Console.WriteLine(x);
    }
}
```
```clojure
//clojure
(defn linq1 []
  (def numbers [4 5 1 3 9 8 6 7 2 0])

  (def low-nums (filter #(< % 5) numbers))

  (println "Numbers < 5:")
  (doall (map println low-nums))
)
```
#### Output

    Numbers < 5:
    4
    1
    3
    2
    0

### linq2: Where - Simple 2
```csharp
//c#
public void Linq2()
{
    List<Product> products = GetProductList();

    var soldOutProducts =
        from p in products
        where p.UnitsInStock == 0
        select p;

    Console.WriteLine("Sold out products:");
    foreach (var product in soldOutProducts)
    {
        Console.WriteLine("{0} is sold out!", product.ProductName);
    }
}
```
```clojure
//clojure
(defn linq2 []
  (def products products-list)
  (def sold-out-products
    (filter #(= 0 (:units-in-stock %))
            products))

  (println "Sold out products:")
  (doseq [p sold-out-products]
    (println (:product-name p) " is sold out"))
)
```
#### Output

    Sold out products:
    Chef Anton's Gumbo Mix  is sold out
    Alice Mutton  is sold out
    Thüringer Rostbratwurst  is sold out
    Gorgonzola Telino  is sold out
    Perth Pasties  is sold out

### linq3: Where - Simple 3
```csharp
//c#
public void Linq3()
{
    List<Product> products = GetProductList();

    var expensiveInStockProducts =
        from p in products
        where p.UnitsInStock > 0 && p.UnitPrice > 3.00M
        select p;

    Console.WriteLine("In-stock products that cost more than 3.00:");
    foreach (var product in expensiveInStockProducts)
    {
        Console.WriteLine("{0} is in stock and costs more than 3.00.", product.ProductName);
    }
}
```
```clojure
//clojure
(defn linq3 []
  (def products products-list)
  (def expensive-in-stock-products
    (filter #(and
               (> 0 (:units-in-stock %))
               (> 3 (:unit-price %)))
            products))

  (println "In-stock products that cost more than 3.00:")
  (doseq [p expensive-in-stock-products]
    (println (:product-name p) "is in stock and costs more than 3.00"))
)
```
#### Output

    In-stock products that cost more than 3.00:
    Chef Anton's Gumbo Mix is in stock and costs more than 3.00
    Alice Mutton is in stock and costs more than 3.00
    Thüringer Rostbratwurst is in stock and costs more than 3.00
    Gorgonzola Telino is in stock and costs more than 3.00
    Perth Pasties is in stock and costs more than 3.00

### linq4: Where - Drilldown
```csharp
//c#
public void Linq4()
{
    List<Customer> customers = GetCustomerList();

    var waCustomers =
        from c in customers
        where c.Region == "WA"
        select c;

    Console.WriteLine("Customers from Washington and their orders:");
    foreach (var customer in waCustomers)
    {
        Console.WriteLine("Customer {0}: {1}", customer.CustomerID, customer.CompanyName);
        foreach (var order in customer.Orders)
        {
            Console.WriteLine("  Order {0}: {1}", order.OrderID, order.OrderDate);
        }
    }
}
```
```clojure
//clojure
(defn linq4 []
  (def customers customers-list)
  (def wa-customers
    (filter #(= (:region %) "WA") customers))

  (println "Customers from Washington and their orders:")
  (doseq [c wa-customers]
    (println "Customer" (:customer-id c) ": " (:company-name c) ":")
    (doseq [o (:orders c)]
      (println "    Order" (:order-id o) ":" (:order-date o)))
  )
)
```
#### Output

    Customers from Washington and their orders:
    Customer LAZYK :  Lazy K Kountry Store :
        Order 10482 : #<DateTime 1997-03-21T00:00:00.000-05:00>
        Order 10545 : #<DateTime 1997-05-22T00:00:00.000-04:00>
    Customer TRAIH :  Trail's Head Gourmet Provisioners :
        Order 10574 : #<DateTime 1997-06-19T00:00:00.000-04:00>
        Order 10577 : #<DateTime 1997-06-23T00:00:00.000-04:00>
        Order 10822 : #<DateTime 1998-01-08T00:00:00.000-05:00>
    ...

### linq5: Where - Indexed
```csharp
//c#
public void Linq5()
{
    string[] digits = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var shortDigits = digits.Where((digit, index) => digit.Length < index);

    Console.WriteLine("Short digits:");
    foreach (var d in shortDigits)
    {
        Console.WriteLine("The word {0} is shorter than its value.", d);
    }
}
```
```clojure
//clojure
(defn linq5 []
  (def digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])
  (def short-digits
    (map last
         (filter (fn [[i digit]] (> i (count digit)))
                 (map-indexed (fn [i digit] [i digit]) digits))))

  (println "Short digits:")
  (doseq [d short-digits]
    (println "The word" d "is shorter than its value"))
)
```
#### Output

    Short digits:
    The word five is shorter than its value
    The word six is shorter than its value
    The word seven is shorter than its value
    The word eight is shorter than its value
    The word nine is shorter than its value


LINQ - Projection Operators
---------------------------

### linq6: Select - Simple 1
```csharp
//c#
public void Linq6()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var numsPlusOne =
        from n in numbers
        select n + 1;

    Console.WriteLine("Numbers + 1:");
    foreach (var i in numsPlusOne)
    {
        Console.WriteLine(i);
    }
}
```
```clojure
//clojure
(defn linq6 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def nums-plus-one (map inc numbers))

  (println "Numbers + 1:")
  (doall (map println nums-plus-one))
)
```
#### Output

    Numbers + 1:
    6
    5
    2
    4
    10
    9
    7
    8
    3
    1

### linq7: Select - Simple 2
```csharp
//c#
public void Linq7()
{
    List<Product> products = GetProductList();

    var productNames =
        from p in products
        select p.ProductName;

    Console.WriteLine("Product Names:");
    foreach (var productName in productNames)
    {
        Console.WriteLine(productName);
    }
}
```
```clojure
//clojure
(defn linq7 []
  (def products products-list)
  (def product-names (map #(:product-name %) products))

  (println "Product Names:")
  (doall (map println product-names))
)
```
#### Output

    Product Names:
    Chai
    Chang
    Aniseed Syrup
    Chef Anton's Cajun Seasoning
    Chef Anton's Gumbo Mix
    ...

### linq8: Select - Transformation
```csharp
//c#
public void Linq8()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
    string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var textNums =
        from n in numbers
        select strings[n];

    Console.WriteLine("Number strings:");
    foreach (var s in textNums)
    {
        Console.WriteLine(s);
    }
}
```
```clojure
//clojure
(defn linq8 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def strings ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])

  (def text-nums (map #(strings %) numbers))

  (println "Number strings:")
  (doall (map println text-nums))
)
```
#### Output

    Number strings:
    five
    four
    one
    three
    nine
    eight
    six
    seven
    two
    zero

### linq9: Select - Anonymous Types 1
```csharp
//c#
public void Linq9()
{
    string[] words = { "aPPLE", "BlUeBeRrY", "cHeRry" };

    var upperLowerWords =
        from w in words
        select new { Upper = w.ToUpper(), Lower = w.ToLower() };

    foreach (var ul in upperLowerWords)
    {
        Console.WriteLine("Uppercase: {0}, Lowercase: {1}", ul.Upper, ul.Lower);
    }
}
```
```clojure
//clojure
(defn linq9 []
  (def words ["aPPLE", "BlUeBeRrY", "cHeRry"])

  (def upper-lower-words
    (map #(hash-map :lower (str/lower-case %), :upper (str/upper-case %)) words))

  (doseq [ul upper-lower-words]
    (println "Uppercase:" (:upper ul) ", Lowercase:" (:lower ul)))
)
```
#### Output

    Uppercase: APPLE , Lowercase: apple
    Uppercase: BLUEBERRY , Lowercase: blueberry
    Uppercase: CHERRY , Lowercase: cherry

### linq10: Select - Anonymous Types 2
```csharp
//c#
public void Linq10()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
    string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var digitOddEvens =
        from n in numbers
        select new { Digit = strings[n], Even = (n % 2 == 0) };

    foreach (var d in digitOddEvens)
    {
        Console.WriteLine("The digit {0} is {1}.", d.Digit, d.Even ? "even" : "odd");
    }
}
```
```clojure
//clojure
(defn linq10 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def strings ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])

  (def digit-odd-evens
    (map (fn [n] {:digit (strings n), :even (= (mod n 2) 0)}) numbers))

  (doseq [d digit-odd-evens]
    (println "The digit" (:digit d) "is" (if (:even d) "even" "odd")))
)
```
#### Output

    The digit five is odd
    The digit four is even
    The digit one is odd
    The digit three is odd
    The digit nine is odd
    The digit eight is even
    The digit six is even
    The digit seven is odd
    The digit two is even
    The digit zero is even

### linq11: Select - Anonymous Types 3
```csharp
//c#
public void Linq11()
{
    List<Product> products = GetProductList();

    var productInfos =
        from p in products
        select new { p.ProductName, p.Category, Price = p.UnitPrice };

    Console.WriteLine("Product Info:");
    foreach (var productInfo in productInfos)
    {
        Console.WriteLine("{0} is in the category {1} and costs {2} per unit.", productInfo.ProductName, productInfo.Category, productInfo.Price);
    }
}
```
```clojure
//clojure
(defn linq11 []
  (def products products-list)

  (def product-infos
    (map #(hash-map :product-name (:product-name %), :category (:category %), :price (:unit-price %)) products))

  (println "Product Info:")
  (doseq [p product-infos]
    (println (:product-name p) "is in the category" (:category p) "and costs" (:price p)))
)
```
#### Output

    Product Info:
    Chai is in the category Beverages and costs 18.0
    Chang is in the category Beverages and costs 19.0
    Aniseed Syrup is in the category Condiments and costs 10.0
    ...

### linq12: Select - Indexed
```csharp
//c#
public void Linq12()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var numsInPlace = numbers.Select((num, index) => new { Num = num, InPlace = (num == index) });

    Console.WriteLine("Number: In-place?");
    foreach (var n in numsInPlace)
    {
        Console.WriteLine("{0}: {1}", n.Num, n.InPlace);
    }
}
```
```clojure
//clojure
(defn linq12 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])

  (def nums-in-place
    (map-indexed (fn [i num] {:num num, :in-place (= num i)}) numbers))

  (println "Number: In-place?")
  (doseq [n nums-in-place]
    (println (:num n) ":" (:in-place n)))
)
```
#### Output

    Number: In-place?
    5 : false
    4 : false
    1 : false
    3 : true
    9 : false
    8 : false
    6 : true
    7 : true
    2 : false
    0 : false

### linq13: Select - Filtered
```csharp
//c#
public void Linq13()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
    string[] digits = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var lowNums =
        from n in numbers
        where n < 5
        select digits[n];

    Console.WriteLine("Numbers < 5:");
    foreach (var num in lowNums)
    {
        Console.WriteLine(num);
    }
}
```
```clojure
//clojure
(defn linq13 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])

  (def low-nums
    (map #(digits %) (filter #(< % 5) numbers)))

  (println "Numbers < 5:")
  (doall (map println low-nums))
)
```
#### Output

    Numbers < 5:
    four
    one
    three
    two
    zero

### linq14: SelectMany - Compound from 1
```csharp
//c#
public void Linq14()
{
    int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
    int[] numbersB = { 1, 3, 5, 7, 8 };

    var pairs =
        from a in numbersA
        from b in numbersB
        where a < b
        select new { a, b };

    Console.WriteLine("Pairs where a < b:");
    foreach (var pair in pairs)
    {
        Console.WriteLine("{0} is less than {1}", pair.a, pair.b);
    }
}
```
```clojure
//clojure
(defn linq14 []
  (def numbers-a [0 2 4 5 6 8 9])
  (def numbers-b [1 3 5 7 8])

  (def pairs
    (flatten
      (map (fn [a] (map #(hash-map :a a, :b %)
                   (filter #(< a %) numbers-b)))
           numbers-a)))

  (println "Pairs where a < b:")
  (doseq [pair pairs]
    (println (:a pair) "is less than" (:b pair)))
)
```
#### Output

    Pairs where a < b:
    0 is less than 1
    0 is less than 3
    0 is less than 5
    0 is less than 7
    0 is less than 8
    2 is less than 3
    2 is less than 5
    2 is less than 7
    2 is less than 8
    4 is less than 5
    4 is less than 7
    4 is less than 8
    5 is less than 7
    5 is less than 8
    6 is less than 7
    6 is less than 8

### linq15: SelectMany - Compound from 2
```csharp
//c#
public void Linq15()
{
    List<Customer> customers = GetCustomerList();

    var orders =
        from c in customers
        from o in c.Orders
        where o.Total < 500.00M
        select new { c.CustomerID, o.OrderID, o.Total };

    ObjectDumper.Write(orders);
}
```
```clojure
//clojure
(defn linq15 []
  (def customers customers-list)

  (def orders
    (flatten
     (map
      (fn [c]
        (map #(hash-map :customer-id (:customer-id c), :order-id (:order-id %), :total (:total %))
             (filter #(< (:total %) 500) (:orders c))))
      customers)))

  (doall (map println orders))
)
```
#### Output

    {:order-id 10702, :total 330.00M, :customer-id ALFKI}
    {:order-id 10952, :total 471.20M, :customer-id ALFKI}
    {:order-id 10308, :total 88.80M, :customer-id ANATR}
    {:order-id 10625, :total 479.75M, :customer-id ANATR}
    ...

### linq16: SelectMany - Compound from 3
```csharp
//c#
public void Linq16()
{
    List<Customer> customers = GetCustomerList();

    var orders =
        from c in customers
        from o in c.Orders
        where o.OrderDate >= new DateTime(1998, 1, 1)
        select new { c.CustomerID, o.OrderID, o.OrderDate };

    ObjectDumper.Write(orders);
}
```
```clojure
//clojure
(defn linq16 []
  (def customers customers-list)

  (def orders
    (flatten
     (map
      (fn [c]
        (map #(hash-map :customer-id (:customer-id c), :order-id (:order-id %), :order-date (:order-date %))
             (filter #(time/after? (:order-date %) (time/date-time 1998 1 1))
                     (:orders c))))
      customers)))

  (doall (map println orders))
)
```
#### Output

    {:order-id 10835, :customer-id ALFKI, :order-date #<DateTime 1998-01-15T00:00:00.000-05:00>}
    {:order-id 10952, :customer-id ALFKI, :order-date #<DateTime 1998-03-16T00:00:00.000-05:00>}
    {:order-id 11011, :customer-id ALFKI, :order-date #<DateTime 1998-04-09T00:00:00.000-04:00>}
    {:order-id 10926, :customer-id ANATR, :order-date #<DateTime 1998-03-04T00:00:00.000-05:00>}
    {:order-id 10856, :customer-id ANTON, :order-date #<DateTime 1998-01-28T00:00:00.000-05:00>}
    ...

### linq17: SelectMany - from Assignment
```csharp
//c#
public void Linq17()
{
    List<Customer> customers = GetCustomerList();

    var orders =
        from c in customers
        from o in c.Orders
        where o.Total >= 2000.0M
        select new { c.CustomerID, o.OrderID, o.Total };

    ObjectDumper.Write(orders);
}
```
```clojure
//clojure
(defn linq17 []
  (def customers customers-list)

  (def orders
    (flatten
     (map
      (fn [c]
        (map #(hash-map :customer-id (:customer-id c), :order-id (:order-id %), :total (:total %))
             (filter #(>= (:total %) 2000) (:orders c))))
      customers)))

  (doall (map println orders))
)
```
#### Output

    {:order-id 10573, :total 2082.00M, :customer-id ANTON}
    {:order-id 10558, :total 2142.90M, :customer-id AROUT}
    {:order-id 10953, :total 4441.25M, :customer-id AROUT}
    {:order-id 10384, :total 2222.40M, :customer-id BERGS}
    {:order-id 10524, :total 3192.65M, :customer-id BERGS}
    ...

### linq18: SelectMany - Multiple from
```csharp
//c#
public void Linq18()
{
    List<Customer> customers = GetCustomerList();

    DateTime cutoffDate = new DateTime(1997, 1, 1);

    var orders =
        from c in customers
        where c.Region == "WA"
        from o in c.Orders
        where o.OrderDate >= cutoffDate
        select new { c.CustomerID, o.OrderID };

    ObjectDumper.Write(orders);
}
```
```clojure
//clojure
(defn linq18 []
  (def customers customers-list)
  (def cutoff-date (time/date-time 1997 1 1))

  (def orders
    (flatten
     (map
      (fn [c]
        (map #(hash-map :customer-id (:customer-id c), :order-id (:order-id %))
             (filter #(time/after? (:order-date %) cutoff-date)
                     (:orders c))))
      (filter #(= (:region %) "WA") customers))))

  (doall (map println orders))
)
```
#### Output

    {:order-id 10482, :customer-id LAZYK}
    {:order-id 10545, :customer-id LAZYK}
    {:order-id 10574, :customer-id TRAIH}
    {:order-id 10577, :customer-id TRAIH}
    {:order-id 10822, :customer-id TRAIH}
    {:order-id 10469, :customer-id WHITC}
    {:order-id 10483, :customer-id WHITC}
    {:order-id 10504, :customer-id WHITC}
    {:order-id 10596, :customer-id WHITC}
    {:order-id 10693, :customer-id WHITC}
    {:order-id 10696, :customer-id WHITC}
    {:order-id 10723, :customer-id WHITC}
    {:order-id 10740, :customer-id WHITC}
    {:order-id 10861, :customer-id WHITC}
    {:order-id 10904, :customer-id WHITC}
    {:order-id 11032, :customer-id WHITC}
    {:order-id 11066, :customer-id WHITC}

### linq19: SelectMany - Indexed
```csharp
//c#
public void Linq19()
{
    List<Customer> customers = GetCustomerList();

    var customerOrders =
        customers.SelectMany(
            (cust, custIndex) =>
            cust.Orders.Select(o => "Customer #" + (custIndex + 1) +
                                    " has an order with OrderID " + o.OrderID));

    ObjectDumper.Write(customerOrders);
}
```
```clojure
//clojure
(defn linq19 []
  (def customers customers-list)

  (def customer-orders
    (flatten
     (map-indexed
      (fn [i c]
        (map #(str "Customer #" (inc i) " has an order with OrderID " (:order-id %))
             (:orders c)))
      customers)))

  (doall (map println customer-orders))
)
```
#### Output

    Customer #1 has an order with OrderID 10643
    Customer #1 has an order with OrderID 10692
    Customer #1 has an order with OrderID 10702
    Customer #1 has an order with OrderID 10835
    Customer #1 has an order with OrderID 10952
    Customer #1 has an order with OrderID 11011
    Customer #2 has an order with OrderID 10308
    Customer #2 has an order with OrderID 10625
    Customer #2 has an order with OrderID 10759
    Customer #2 has an order with OrderID 10926
    ...

LINQ - Partitioning Operators
-----------------------------

### linq20: Take - Simple
```csharp
//c#
public void Linq20()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var first3Numbers = numbers.Take(3);

    Console.WriteLine("First 3 numbers:");

    foreach (var n in first3Numbers)
    {
        Console.WriteLine(n);
    }
}
```
```clojure
//clojure
(defn linq20 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def first-3-numbers (take 3 numbers))

  (println "First 3 numbers:")
  (doall (map println first-3-numbers))
)
```
#### Output

    First 3 numbers:
    5
    4
    1

### linq21: Take - Nested
```csharp
//c#
public void Linq21()
{
    List<Customer> customers = GetCustomerList();

    var first3WAOrders = (
        from c in customers
        from o in c.Orders
        where c.Region == "WA"
        select new { c.CustomerID, o.OrderID, o.OrderDate })
        .Take(3);

    Console.WriteLine("First 3 orders in WA:");
    foreach (var order in first3WAOrders)
    {
        ObjectDumper.Write(order);
    }
}
```
```clojure
//clojure
(defn linq21 []
  (def customers customers-list)

  (def first-3-wa-orders
    (take 3 (flatten
     (map
      (fn [c]
        (map #(hash-map :customer-id (:customer-id c),
                        :order-id (:order-id %),
                        :order-date (:order-date %))
             (:orders c)))
      (filter #(= (:region %) "WA") customers)))))

  (println "First 3 orders in WA:")
  (doall (map println first-3-wa-orders))
)
```
#### Output

    First 3 orders in WA:
    {:order-id 10482, :customer-id LAZYK, :order-date #<DateTime 1997-03-21T00:00:00.000-05:00>}
    {:order-id 10545, :customer-id LAZYK, :order-date #<DateTime 1997-05-22T00:00:00.000-04:00>}
    {:order-id 10574, :customer-id TRAIH, :order-date #<DateTime 1997-06-19T00:00:00.000-04:00>}

### linq22: Skip - Simple
```csharp
//c#
public void Linq22()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var allButFirst4Numbers = numbers.Skip(4);

    Console.WriteLine("All but first 4 numbers:");
    foreach (var n in allButFirst4Numbers)
    {
        Console.WriteLine(n);
    }
}
```
```clojure
//clojure
(defn linq22 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def all-but-first-4-numbers (drop 4 numbers))

  (println "All but first 4 numbers:")
  (doall (map println all-but-first-4-numbers))
)
```
#### Output

    All but first 4 numbers:
    9
    8
    6
    7
    2
    0

### linq23: Skip - Nested
```csharp
//c#
public void Linq23()
{
    List<Customer> customers = GetCustomerList();

    var waOrders =
        from c in customers
        from o in c.Orders
        where c.Region == "WA"
        select new { c.CustomerID, o.OrderID, o.OrderDate };

    var allButFirst2Orders = waOrders.Skip(2);

    Console.WriteLine("All but first 2 orders in WA:");
    foreach (var order in allButFirst2Orders)
    {
        ObjectDumper.Write(order);
    }
}
```
```clojure
//clojure
(defn linq23 []
  (def customers customers-list)

  (def all-but-first-2-orders
    (drop 2 (flatten
     (map
      (fn [c]
        (map #(hash-map :customer-id (:customer-id c),
                        :order-id (:order-id %),
                        :order-date (:order-date %))
             (:orders c)))
      (filter #(= (:region %) "WA") customers)))))

  (println "All but first 2 orders in WA:")
  (doall (map println all-but-first-2-orders))
)
```
#### Output

    All but first 2 orders in WA:
    {:order-id 10574, :customer-id TRAIH, :order-date #<DateTime 1997-06-19T00:00:00.000-04:00>}
    {:order-id 10577, :customer-id TRAIH, :order-date #<DateTime 1997-06-23T00:00:00.000-04:00>}
    {:order-id 10822, :customer-id TRAIH, :order-date #<DateTime 1998-01-08T00:00:00.000-05:00>}
    {:order-id 10269, :customer-id WHITC, :order-date #<DateTime 1996-07-31T00:00:00.000-04:00>}
    {:order-id 10344, :customer-id WHITC, :order-date #<DateTime 1996-11-01T00:00:00.000-05:00>}
    {:order-id 10469, :customer-id WHITC, :order-date #<DateTime 1997-03-10T00:00:00.000-05:00>}
    {:order-id 10483, :customer-id WHITC, :order-date #<DateTime 1997-03-24T00:00:00.000-05:00>}
    {:order-id 10504, :customer-id WHITC, :order-date #<DateTime 1997-04-11T00:00:00.000-04:00>}
    {:order-id 10596, :customer-id WHITC, :order-date #<DateTime 1997-07-11T00:00:00.000-04:00>}
    {:order-id 10693, :customer-id WHITC, :order-date #<DateTime 1997-10-06T00:00:00.000-04:00>}
    {:order-id 10696, :customer-id WHITC, :order-date #<DateTime 1997-10-08T00:00:00.000-04:00>}
    {:order-id 10723, :customer-id WHITC, :order-date #<DateTime 1997-10-30T00:00:00.000-05:00>}
    {:order-id 10740, :customer-id WHITC, :order-date #<DateTime 1997-11-13T00:00:00.000-05:00>}
    {:order-id 10861, :customer-id WHITC, :order-date #<DateTime 1998-01-30T00:00:00.000-05:00>}
    {:order-id 10904, :customer-id WHITC, :order-date #<DateTime 1998-02-24T00:00:00.000-05:00>}
    {:order-id 11032, :customer-id WHITC, :order-date #<DateTime 1998-04-17T00:00:00.000-04:00>}
    {:order-id 11066, :customer-id WHITC, :order-date #<DateTime 1998-05-01T00:00:00.000-04:00>}

### linq24: TakeWhile - Simple
```csharp
//c#
public void Linq24()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var firstNumbersLessThan6 = numbers.TakeWhile(n => n < 6);

    Console.WriteLine("First numbers less than 6:");
    foreach (var n in firstNumbersLessThan6)
    {
        Console.WriteLine(n);
    }
}
```
```clojure
//clojure
(defn linq24 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def first-numbers-less-than-6 (take-while #(< % 6) numbers))

  (println "First numbers less than 6:")
  (doall (map println first-numbers-less-than-6))
)
```
#### Output

    First numbers less than 6:
    5
    4
    1
    3

### linq25: TakeWhile - Indexed
```csharp
//c#
public void Linq25()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var firstSmallNumbers = numbers.TakeWhile((n, index) => n >= index);

    Console.WriteLine("First numbers not less than their position:");
    foreach (var n in firstSmallNumbers)
    {
        Console.WriteLine(n);
    }
}
```
```clojure
//clojure
(defn linq25 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def first-small-numbers
    (map (fn [[i num]] num)
      (take-while (fn [[i num]] (>= num i)) (with-index numbers))))

  (println "First numbers not less than their position:")
  (doall (map println first-small-numbers))
)
```
#### Output

    First numbers not less than their position:
    5
    4

### linq26: SkipWhile - Simple
```csharp
//c#
public void Linq26()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var allButFirst3Numbers = numbers.SkipWhile(n => n % 3 != 0);

    Console.WriteLine("All elements starting from first element divisible by 3:");
    foreach (var n in allButFirst3Numbers)
    {
        Console.WriteLine(n);
    }
}
```
```clojure
//clojure
(defn linq26 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def all-but-first-3-numbers (drop-while #(not= (mod % 3) 0) numbers))

  (println "All elements starting from first element divisible by 3:")
  (doall (map println all-but-first-3-numbers))
)
```
#### Output

    All elements starting from first element divisible by 3:
    3
    9
    8
    6
    7
    2
    0

### linq27: SkipWhile - Indexed
```csharp
//c#
public void Linq27()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var laterNumbers = numbers.SkipWhile((n, index) => n >= index);

    Console.WriteLine("All elements starting from first element less than its position:");
    foreach (var n in laterNumbers)
    {
        Console.WriteLine(n);
    }
}
```
```clojure
//clojure
(defn linq27 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def later-numbers
    (map (fn [[i num]] num)
      (drop-while (fn [[i num]] (>= num i)) (with-index numbers))))

  (println "All elements starting from first element less than its position:")
  (doall (map println later-numbers))
)
```
#### Output

    All elements starting from first element less than its position:
    1
    3
    9
    8
    6
    7
    2
    0


LINQ - Ordering Operators
-------------------------

### C# utils added

```csharp
public class CaseInsensitiveComparer : IComparer<string>
{
    public int Compare(string x, string y)
    {
        return string.Compare(x, y, StringComparison.OrdinalIgnoreCase);
    }
}
```

### Clojure utils added

```clojure
(defn case-insensitive-compare [s1 s2]
  (compare (.toLowerCase s1) (.toLowerCase s2)))

(defn order-by-comparers [comparers xs]
  (sort-by
   pass-thru
   (fn [a1 a2]
     (let [ret (first (drop-while #(= 0 %) (map #(% a1 a2) comparers)))]
       (if (nil? ret) 0 ret)))
   xs))

(defn order-by [fns xs]
  (order-by-comparers (map #(fn [a1 a2] (compare (% a1) (% a2))) fns) xs))
```

### linq28: OrderBy - Simple 1
```csharp
//c#
public void Linq28()
{
    string[] words = { "cherry", "apple", "blueberry" };

    var sortedWords =
        from w in words
        orderby w
        select w;

    Console.WriteLine("The sorted list of words:");
    foreach (var w in sortedWords)
    {
        Console.WriteLine(w);
    }
}
```
```clojure
//clojure
(defn linq28 []
  (def words ["cherry" "apple" "blueberry"])
  (def sorted-words (sort words))

  (println "The sorted list of words:")
  (doall (map println sorted-words))
)
```
#### Output

    The sorted list of words:
    apple
    blueberry
    cherry

### linq29: OrderBy - Simple 2
```csharp
//c#
public void Linq29()
{
    string[] words = { "cherry", "apple", "blueberry" };

    var sortedWords =
        from w in words
        orderby w.Length
        select w;

    Console.WriteLine("The sorted list of words (by length):");
    foreach (var w in sortedWords)
    {
        Console.WriteLine(w);
    }
}
```
```clojure
//clojure
(defn linq29 []
  (def words ["cherry" "apple" "blueberry"])
  (def sorted-words (sort-by count words))

  (println "The sorted list of words (by length):")
  (doall (map println sorted-words))
)
```
#### Output

    The sorted list of words (by length):
    apple
    cherry
    blueberry

### linq30: OrderBy - Simple 3
```csharp
//c#
public void Linq30()
{
    List<Product> products = GetProductList();

    var sortedProducts =
        from p in products
        orderby p.ProductName
        select p;

    ObjectDumper.Write(sortedProducts);
}
```
```clojure
//clojure
(defn linq30 []
  (def products products-list)
  (def sorted-products (sort-by :product-name products))

  (doall (map println sorted-products))
)
```
#### Output

    #clj_linq.data.Product{:product-id 17, :product-name Alice Mutton, :category Meat/Poultry, :unit-price 39.0, :units-in-stock 0}
    #clj_linq.data.Product{:product-id 3, :product-name Aniseed Syrup, :category Condiments, :unit-price 10.0, :units-in-stock 13}
    #clj_linq.data.Product{:product-id 40, :product-name Boston Crab Meat, :category Seafood, :unit-price 18.4, :units-in-stock 123}
    #clj_linq.data.Product{:product-id 60, :product-name Camembert Pierrot, :category Dairy Products, :unit-price 34.0, :units-in-stock 19}
    #clj_linq.data.Product{:product-id 18, :product-name Carnarvon Tigers, :category Seafood, :unit-price 62.5, :units-in-stock 42}
    ...

### linq31: OrderBy - Comparer
```csharp
//c#
public void Linq31()
{
    string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

    var sortedWords = words.OrderBy(a => a, new CaseInsensitiveComparer());

    ObjectDumper.Write(sortedWords);
}
```
```clojure
//clojure
(defn linq31 []
  (def words ["aPPLE" "AbAcUs" "bRaNcH" "BlUeBeRrY" "ClOvEr" "cHeRry"])
  (def sorted-words (sort-by identity case-insensitive-compare words))

  (doall (map println sorted-words))
)
```
#### Output

    AbAcUs
    aPPLE
    BlUeBeRrY
    bRaNcH
    cHeRry
    ClOvEr

### linq32: OrderByDescending - Simple 1
```csharp
//c#
public void Linq32()
{
    double[] doubles = { 1.7, 2.3, 1.9, 4.1, 2.9 };

    var sortedDoubles =
        from d in doubles
        orderby d descending
        select d;

    Console.WriteLine("The doubles from highest to lowest:");
    foreach (var d in sortedDoubles)
    {
        Console.WriteLine(d);
    }
}
```
```clojure
//clojure
(defn linq32 []
  (def dbls [1.7 2.3 1.9 4.1 2.9])
  (def sorted-doubles (reverse (sort dbls)))

  (println "The doubles from highest to lowest:")
  (doall (map println sorted-doubles))
)
```
#### Output

    The doubles from highest to lowest:
    4.1
    2.9
    2.3
    1.9
    1.7

### linq33: OrderByDescending - Simple 2
```csharp
//c#
public void Linq33()
{
    List<Product> products = GetProductList();

    var sortedProducts =
        from p in products
        orderby p.UnitsInStock descending
        select p;

    ObjectDumper.Write(sortedProducts);
}
```
```clojure
//clojure
(defn linq33 []
  (def products products-list)
  (def sorted-products (reverse (sort-by :units-in-stock products)))

  (doall (map println sorted-products))
)
```
#### Output

    #clj_linq.data.Product{:product-id 75, :product-name Rhönbräu Klosterbier, :category Beverages, :unit-price 7.75, :units-in-stock 125}
    #clj_linq.data.Product{:product-id 40, :product-name Boston Crab Meat, :category Seafood, :unit-price 18.4, :units-in-stock 123}
    #clj_linq.data.Product{:product-id 6, :product-name Grandma's Boysenberry Spread, :category Condiments, :unit-price 25.0, :units-in-stock 120}
    #clj_linq.data.Product{:product-id 55, :product-name Pâté chinois, :category Meat/Poultry, :unit-price 24.0, :units-in-stock 115}
    #clj_linq.data.Product{:product-id 61, :product-name Sirop d'érable, :category Condiments, :unit-price 28.5, :units-in-stock 113}
    ...

### linq34: OrderByDescending - Comparer
```csharp
//c#
public void Linq34()
{
    string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

    var sortedWords = words.OrderByDescending(a => a, new CaseInsensitiveComparer());

    ObjectDumper.Write(sortedWords);
}
```
```clojure
//clojure
(defn linq34 []
  (def words ["aPPLE" "AbAcUs" "bRaNcH" "BlUeBeRrY" "ClOvEr" "cHeRry"])
  (def sorted-words (->> words
                         (sort-by identity case-insensitive-compare)
                         reverse))

  (doall (map println sorted-words))
)
```
#### Output

    ClOvEr
    cHeRry
    bRaNcH
    BlUeBeRrY
    aPPLE
    AbAcUs

### linq35: ThenBy - Simple
```csharp
//c#
public void Linq35()
{
    string[] digits = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var sortedDigits =
        from d in digits
        orderby d.Length, d
        select d;

    Console.WriteLine("Sorted digits:");
    foreach (var d in sortedDigits)
    {
        Console.WriteLine(d);
    }
}
```
```clojure
//clojure
(defn linq35 []
  (def digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])

  (def sorted-digits (order-by [count identity] digits))

  (println "Sorted digits:")
  (doall (map println sorted-digits))
)
```
#### Output

    Sorted digits:
    one
    six
    two
    five
    four
    nine
    zero
    eight
    seven
    three

### linq36: ThenBy - Comparer
```csharp
//c#
public void Linq36()
{
    string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

    var sortedWords =
        words.OrderBy(a => a.Length)
             .ThenBy(a => a, new CaseInsensitiveComparer());

    ObjectDumper.Write(sortedWords);
}
```
```clojure
//clojure
(defn linq36 []
  (def words ["aPPLE" "AbAcUs" "bRaNcH" "BlUeBeRrY" "ClOvEr" "cHeRry"])
  (def sorted-words (order-by [count (fn [x] (.toLowerCase x))] words))

  (doall (map println sorted-words))
)
```
#### Output

    aPPLE
    AbAcUs
    bRaNcH
    cHeRry
    ClOvEr
    BlUeBeRrY

### linq37: ThenByDescending - Simple
```csharp
//c#
public void Linq37()
{
    List<Product> products = GetProductList();

    var sortedProducts =
        from p in products
        orderby p.Category, p.UnitPrice descending
        select p;

    ObjectDumper.Write(sortedProducts);
}
```
```clojure
//clojure
(defn linq37 []
  (def products products-list)
  (def sorted-products (order-by [:category #(* -1 (:unit-price  %))] products))

  (doall (map println sorted-products))
)
```
#### Output

    #clj_linq.data.Product{:product-id 38, :product-name Côte de Blaye, :category Beverages, :unit-price 263.5, :units-in-stock 17}
    #clj_linq.data.Product{:product-id 43, :product-name Ipoh Coffee, :category Beverages, :unit-price 46.0, :units-in-stock 17}
    #clj_linq.data.Product{:product-id 2, :product-name Chang, :category Beverages, :unit-price 19.0, :units-in-stock 17}
    #clj_linq.data.Product{:product-id 1, :product-name Chai, :category Beverages, :unit-price 18.0, :units-in-stock 39}
    #clj_linq.data.Product{:product-id 35, :product-name Steeleye Stout, :category Beverages, :unit-price 18.0, :units-in-stock 20}
    #clj_linq.data.Product{:product-id 39, :product-name Chartreuse verte, :category Beverages, :unit-price 18.0, :units-in-stock 69}
    #clj_linq.data.Product{:product-id 76, :product-name Lakkalikööri, :category Beverages, :unit-price 18.0, :units-in-stock 57}
    #clj_linq.data.Product{:product-id 70, :product-name Outback Lager, :category Beverages, :unit-price 15.0, :units-in-stock 15}
    #clj_linq.data.Product{:product-id 34, :product-name Sasquatch Ale, :category Beverages, :unit-price 14.0, :units-in-stock 111}
    ...

### linq38: ThenByDescending - Comparer
```csharp
//c#
public void Linq38()
{
    string[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

    var sortedWords =
        words.OrderBy(a => a.Length)
             .ThenByDescending(a => a, new CaseInsensitiveComparer());

    ObjectDumper.Write(sortedWords);
}
```
```clojure
//clojure
(defn linq38 []
  (def words ["aPPLE" "AbAcUs" "bRaNcH" "BlUeBeRrY" "ClOvEr" "cHeRry"])
  (def sorted-words (order-by-comparers
                     [#(compare (count %1) (count %2))
                      #(case-insensitive-compare %2 %1)]
                     words))

  (doall (map println sorted-words))
)
```
#### Output

    aPPLE
    ClOvEr
    cHeRry
    bRaNcH
    AbAcUs
    BlUeBeRrY

### linq39: Reverse
```csharp
//c#
public void Linq39()
{
    string[] digits = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var reversedIDigits = (
        from d in digits
        where d[1] == 'i'
        select d)
        .Reverse();

    Console.WriteLine("A backwards list of the digits with a second character of 'i':");
    foreach (var d in reversedIDigits)
    {
        Console.WriteLine(d);
    }
}
```
```clojure
//clojure
(defn linq39 []
  (def digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])

  (def sorted-digits (->> digits
                          (filter #(= (get % 1) \i))
                          reverse))

  (println "A backwards list of the digits with a second character of 'i':")
  (doall (map println sorted-digits))
)
```
#### Output

    A backwards list of the digits with a second character of 'i':
    nine
    eight
    six
    five

LINQ - Grouping Operators
-------------------------

### C# utils added

```csharp
public class AnagramEqualityComparer : IEqualityComparer<string>
{
    public bool Equals(string x, string y)
    {
        return getCanonicalString(x) == getCanonicalString(y);
    }

    public int GetHashCode(string obj)
    {
        return getCanonicalString(obj).GetHashCode();
    }

    private string getCanonicalString(string word)
    {
        char[] wordChars = word.ToCharArray();
        Array.Sort<char>(wordChars);
        return new string(wordChars);
    }
}
```

### Clojure utils added

```clojure
(defn anagram-comparer [a b] (compare (sort (.toCharArray a)) (sort (.toCharArray b))))
```

### linq40: GroupBy - Simple 1
```csharp
//c#
public void Linq40()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var numberGroups =
        from n in numbers
        group n by n % 5 into g
        select new { Remainder = g.Key, Numbers = g };

    foreach (var g in numberGroups)
    {
        Console.WriteLine("Numbers with a remainder of {0} when divided by 5:", g.Remainder);
        foreach (var n in g.Numbers)
        {
            Console.WriteLine(n);
        }
    }
}
```
```clojure
//clojure
(defn linq40 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def number-groups (map #(hash-map :remainder (% 0), :numbers (% 1))
                          (group-by #(mod % 5) numbers)))

  (doseq [g number-groups]
    (println "Numbers with a remainder of" (:remainder g) "when divided by 5:")
    (doall (map println (:numbers g))))
)
```
#### Output

    Numbers with a remainder of 0 when divided by 5:
    5
    0
    Numbers with a remainder of 4 when divided by 5:
    4
    9
    Numbers with a remainder of 1 when divided by 5:
    1
    6
    Numbers with a remainder of 3 when divided by 5:
    3
    8
    Numbers with a remainder of 2 when divided by 5:
    7
    2

### linq41: GroupBy - Simple 2
```csharp
//c#
public void Linq41()
{
    string[] words = { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" };

    var wordGroups =
        from w in words
        group w by w[0] into g
        select new { FirstLetter = g.Key, Words = g };

    foreach (var g in wordGroups)
    {
        Console.WriteLine("Words that start with the letter '{0}':", g.FirstLetter);
        foreach (var w in g.Words)
        {
            Console.WriteLine(w);
        }
    }
}
```
```clojure
//clojure
(defn linq41 []
  (def words ["blueberry" "chimpanzee" "abacus" "banana" "apple" "cheese"])
  (def word-groups (map #(hash-map :first-letter (% 0), :words (% 1))
                          (group-by #(get % 0) words)))

  (doseq [g word-groups]
    (println "Words that start with the letter: " (:first-letter g))
    (doall (map println (:words g))))
)
```

#### Output

    Words that start with the letter:  b
    blueberry
    banana
    Words that start with the letter:  c
    chimpanzee
    cheese
    Words that start with the letter:  a
    abacus
    apple

### linq42: GroupBy - Simple 3
```csharp
//c#
public void Linq42()
{
    List<Product> products = GetProductList();

    var orderGroups =
        from p in products
        group p by p.Category into g
        select new { Category = g.Key, Products = g };

    ObjectDumper.Write(orderGroups, 1);
}
```
```clojure
//clojure
(defn linq42 []
  (def products products-list)
  (def order-groups (map #(hash-map :category (% 0), :products (% 1))
                          (group-by #(:category %) products)))

  (doall (map println order-groups))
)
```
#### Output

    {:products [#clj_linq.data.Product{:product-id 1, :product-name Chai, :category Beverages, :unit-price 18.0, :units-in-stock 39} #clj_linq.data.Product{:product-id 2, :product-name Chang, :category Beverages, :unit-price 19.0, :units-in-stock 17} #clj_linq.data.Product{:product-id 24, :product-name Guaraná Fantástica, :category Beverages, :unit-price 4.5, :units-in-stock 20} #clj_linq.data.Product{:product-id 34, :product-name Sasquatch Ale, :category Beverages, :unit-price 14.0, :units-in-stock 111} #clj_linq.data.Product{:product-id 35, :product-name Steeleye Stout, :category Beverages, :unit-price 18.0, :units-in-stock 20} #clj_linq.data.Product{:product-id 38, :product-name Côte de Blaye, :category Beverages, :unit-price 263.5, :units-in-stock 17} #clj_linq.data.Product{:product-id 39, :product-name Chartreuse verte, :category Beverages, :unit-price 18.0, :units-in-stock 69} #clj_linq.data.Product{:product-id 43, :product-name Ipoh Coffee, :category Beverages, :unit-price 46.0, :units-in-stock 17} #clj_linq.data.Product{:product-id 67, :product-name Laughing Lumberjack Lager, :category Beverages, :unit-price 14.0, :units-in-stock 52} #clj_linq.data.Product{:product-id 70, :product-name Outback Lager, :category Beverages, :unit-price 15.0, :units-in-stock 15} #clj_linq.data.Product{:product-id 75, :product-name Rhönbräu Klosterbier, :category Beverages, :unit-price 7.75, :units-in-stock 125} #clj_linq.data.Product{:product-id 76, :product-name Lakkalikööri, :category Beverages, :unit-price 18.0, :units-in-stock 57}], :category Beverages}
    {:products [#clj_linq.data.Product{:product-id 3, :product-name Aniseed Syrup, :category Condiments, :unit-price 10.0, :units-in-stock 13} #clj_linq.data.Product{:product-id 4, :product-name Chef Anton's Cajun Seasoning, :category Condiments, :unit-price 22.0, :units-in-stock 53} #clj_linq.data.Product{:product-id 5, :product-name Chef Anton's Gumbo Mix, :category Condiments, :unit-price 21.35, :units-in-stock 0} #clj_linq.data.Product{:product-id 6, :product-name Grandma's Boysenberry Spread, :category Condiments, :unit-price 25.0, :units-in-stock 120} #clj_linq.data.Product{:product-id 8, :product-name Northwoods Cranberry Sauce, :category Condiments, :unit-price 40.0, :units-in-stock 6} #clj_linq.data.Product{:product-id 15, :product-name Genen Shouyu, :category Condiments, :unit-price 15.5, :units-in-stock 39} #clj_linq.data.Product{:product-id 44, :product-name Gula Malacca, :category Condiments, :unit-price 19.45, :units-in-stock 27} #clj_linq.data.Product{:product-id 61, :product-name Sirop d'érable, :category Condiments, :unit-price 28.5, :units-in-stock 113} #clj_linq.data.Product{:product-id 63, :product-name Vegie-spread, :category Condiments, :unit-price 43.9, :units-in-stock 24} #clj_linq.data.Product{:product-id 65, :product-name Louisiana Fiery Hot Pepper Sauce, :category Condiments, :unit-price 21.05, :units-in-stock 76} #clj_linq.data.Product{:product-id 66, :product-name Louisiana Hot Spiced Okra, :category Condiments, :unit-price 17.0, :units-in-stock 4} #clj_linq.data.Product{:product-id 77, :product-name Original Frankfurter grüne Soße, :category Condiments, :unit-price 13.0, :units-in-stock 32}], :category Condiments}

### linq43: GroupBy - Nested
```csharp
//c#
public void Linq43()
{
    List<Customer> customers = GetCustomerList();

    var customerOrderGroups =
        from c in customers
        select
            new
            {
                c.CompanyName,
                YearGroups =
                    from o in c.Orders
                    group o by o.OrderDate.Year into yg
                    select
                        new
                        {
                            Year = yg.Key,
                            MonthGroups =
                                from o in yg
                                group o by o.OrderDate.Month into mg
                                select new { Month = mg.Key, Orders = mg }
                        }
            };

    ObjectDumper.Write(customerOrderGroups, 3);
}
```
```clojure
//clojure
(defn linq43 []
  (def customers customers-list)
  (def customer-order-groups
    (map #(hash-map
           :company-name (:company-name %),
           :year-groups
           (map (fn [yg]
                  (hash-map :year (get yg 0)
                            :month-groups
                            (map (fn [mg] {:month (time/month (get mg 0)), :orders (get mg 1)})
                                 (group-by (fn [o] (:order-date o)) (get yg 1)))
                            ))
                (group-by (fn [o] (:year o)) (:orders %)))
           )
     customers))

  (doall (map println customer-order-groups))
)
```
#### Output

    {:company-name Alfreds Futterkiste, :year-groups ({:month-groups ({:month 8, :orders [#clj_linq.data.Order{:order-id 10643, :order-date #<DateTime 1997-08-25T00:00:00.000-04:00>, :total 814.50M}]} {:month 10, :orders [#clj_linq.data.Order{:order-id 10692, :order-date #<DateTime 1997-10-03T00:00:00.000-04:00>, :total 878.00M}]} {:month 10, :orders [#clj_linq.data.Order{:order-id 10702, :order-date #<DateTime 1997-10-13T00:00:00.000-04:00>, :total 330.00M}]} {:month 1, :orders [#clj_linq.data.Order{:order-id 10835, :order-date #<DateTime 1998-01-15T00:00:00.000-05:00>, :total 845.80M}]} {:month 3, :orders [#clj_linq.data.Order{:order-id 10952, :order-date #<DateTime 1998-03-16T00:00:00.000-05:00>, :total 471.20M}]} {:month 4, :orders [#clj_linq.data.Order{:order-id 11011, :order-date #<DateTime 1998-04-09T00:00:00.000-04:00>, :total 933.50M}]}), :year nil})}

### linq44: GroupBy - Comparer
```csharp
//c#
public void Linq44()
{
    string[] anagrams = { "from   ", " salt", " earn ", "  last   ", " near ", " form  " };

    var orderGroups = anagrams.GroupBy(w => w.Trim(), new AnagramEqualityComparer());

    ObjectDumper.Write(orderGroups, 1);
}
```
```clojure
//clojure
(defn linq44 []
  (def anagrams ["from   " " salt" " earn " "  last   " " near " " form  "])
  (def order-groups (group-by #(sort (.toCharArray (.trim %))) anagrams))

  (doall (map #(println (get % 1)) order-groups))
)
```

#### Output

    [from     form  ]
    [ salt   last   ]
    [ earn   near ]

### linq45: GroupBy - Comparer, Mapped
```csharp
//c#
public void Linq45()
{
    string[] anagrams = { "from   ", " salt", " earn ", "  last   ", " near ", " form  " };

    var orderGroups = anagrams.GroupBy(
                w => w.Trim(),
                a => a.ToUpper(),
                new AnagramEqualityComparer()
                );

    ObjectDumper.Write(orderGroups, 1);
}
```
```clojure
//clojure
(defn linq45 []
  (def anagrams ["from   " " salt" " earn " "  last   " " near " " form  "])
  (def order-groups (group-by #(sort (.toCharArray (.trim %))) (map #(.toUpperCase %) anagrams)))

  (doall (map #(println (get % 1)) order-groups))
)
```
#### Output

    [FROM     FORM  ]
    [ SALT   LAST   ]
    [ EARN   NEAR ]


LINQ - Set Operators
--------------------

### linq46: Distinct - 1
```csharp
//c#
public void Linq46()
{
    int[] factorsOf300 = { 2, 2, 3, 5, 5 };

    var uniqueFactors = factorsOf300.Distinct();

    Console.WriteLine("Prime factors of 300:");
    foreach (var f in uniqueFactors)
    {
        Console.WriteLine(f);
    }
}
```
```clojure
//clojure
(defn linq46 []
  (def factors-of-300 [2, 2, 3, 5, 5])
  (def unique-factors (distinct factors-of-300))

  (println "Prime factors of 300:")
  (doall (map println unique-factors))
)
```
#### Output

    Prime factors of 300:
    2
    3
    5

### linq47: Distinct - 2
```csharp
//c#
public void Linq47()
{
    List<Product> products = GetProductList();

    var categoryNames = (
        from p in products
        select p.Category)
        .Distinct();

    Console.WriteLine("Category names:");
    foreach (var n in categoryNames)
    {
        Console.WriteLine(n);
    }
}
```
```clojure
//clojure
(defn linq47 []
  (def products products-list)
  (def category-names (->> products
                           (map :category)
                           distinct))

  (println "Category names:")
  (doall (map println category-names))
)
```
#### Output

    Category names:
    Beverages
    Condiments
    Produce
    Meat/Poultry
    Seafood
    Dairy Products
    Confections
    Grains/Cereals

### linq48: Union - 1
```csharp
//c#
public void Linq48()
{
    int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
    int[] numbersB = { 1, 3, 5, 7, 8 };

    var uniqueNumbers = numbersA.Union(numbersB);

    Console.WriteLine("Unique numbers from both arrays:");
    foreach (var n in uniqueNumbers)
    {
        Console.WriteLine(n);
    }
}
```
```clojure
//clojure
(defn linq48 []
  (def numbers-a [0 2 4 5 6 8 9])
  (def numbers-b [1 3 5 7 8])

  (def unique-numbers (union (set numbers-a) (set numbers-b)))

  (println "Unique numbers from both arrays:")
  (doall (map println unique-numbers))
)
```
#### Output

    Unique numbers from both arrays:
    0
    1
    2
    3
    4
    5
    6
    7
    8
    9

### linq49: Union - 2
```csharp
//c#
public void Linq49()
{
    List<Product> products = GetProductList();
    List<Customer> customers = GetCustomerList();

    var productFirstChars =
        from p in products
        select p.ProductName[0];
    var customerFirstChars =
        from c in customers
        select c.CompanyName[0];

    var uniqueFirstChars = productFirstChars.Union(customerFirstChars);

    Console.WriteLine("Unique first letters from Product names and Customer names:");
    foreach (var ch in uniqueFirstChars)
    {
        Console.WriteLine(ch);
    }
}
```
```clojure
//clojure
(defn linq49 []
  (def products products-list)
  (def customers customers-list)

  (def product-first-chars (map #(get (:product-name %) 0) products))
  (def customer-first-chars (map #(get (:company-name %) 0) customers))

  (def unique-first-chars (union (set product-first-chars) (set customer-first-chars)))

  (println "Unique first letters from Product names and Customer names:")
  (doall (map println unique-first-chars))
)```
#### Output

    Unique first letters from Product names and Customer names:
    A
    B
    C
    D
    E
    F
    G
    H
    I
    J
    K
    L
    M
    N
    O
    P
    Q
    R
    S
    T
    U
    V
    W
    Z

### linq50: Intersect - 1
```csharp
//c#
public void Linq50()
{
    int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
    int[] numbersB = { 1, 3, 5, 7, 8 };

    var commonNumbers = numbersA.Intersect(numbersB);

    Console.WriteLine("Common numbers shared by both arrays:");
    foreach (var n in commonNumbers)
    {
        Console.WriteLine(n);
    }
}
```
```clojure
//clojure
(defn linq50 []
  (def numbers-a [0 2 4 5 6 8 9])
  (def numbers-b [1 3 5 7 8])

  (def common-numbers (intersection (set numbers-a) (set numbers-b)))

  (println "Common numbers shared by both arrays:")
  (doall (map println common-numbers))
)
```
#### Output

    Common numbers shared by both arrays:
    5
    8

### linq51: Intersect - 2
```csharp
//c#
public void Linq51()
{
    List<Product> products = GetProductList();
    List<Customer> customers = GetCustomerList();

    var productFirstChars =
        from p in products
        select p.ProductName[0];
    var customerFirstChars =
        from c in customers
        select c.CompanyName[0];

    var commonFirstChars = productFirstChars.Intersect(customerFirstChars);

    Console.WriteLine("Common first letters from Product names and Customer names:");
    foreach (var ch in commonFirstChars)
    {
        Console.WriteLine(ch);
    }
}
```
```clojure
//clojure
(defn linq51 []
  (def products products-list)
  (def customers customers-list)

  (def product-first-chars (map #(get (:product-name %) 0) products))
  (def customer-first-chars (map #(get (:company-name %) 0) customers))

  (def common-first-chars (intersection (set product-first-chars) (set customer-first-chars)))

  (println "Common first letters from Product names and Customer names:")
  (doall (map println common-first-chars))
)
```
#### Output

    Common first letters from Product names and Customer names:
    A
    B
    C
    E
    F
    G
    I
    K
    L
    M
    N
    O
    P
    Q
    R
    S
    T
    V
    W

### linq52: Except - 1
```csharp
//c#
public void Linq52()
{
    int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
    int[] numbersB = { 1, 3, 5, 7, 8 };

    IEnumerable<int> aOnlyNumbers = numbersA.Except(numbersB);

    Console.WriteLine("Numbers in first array but not second array:");
    foreach (var n in aOnlyNumbers)
    {
        Console.WriteLine(n);
    }
}
```
```clojure
//clojure
(defn linq52 []
  (def numbers-a [0 2 4 5 6 8 9])
  (def numbers-b [1 3 5 7 8])

  (def a-only-numbers (difference (set numbers-a) (set numbers-b)))

  (println "Numbers in first array but not second array:")
  (doall (map println a-only-numbers))
)
```
#### Output

    Numbers in first array but not second array:
    0
    2
    4
    6
    9

### linq53: Except - 2
```csharp
//c#
public void Linq53()
{
    List<Product> products = GetProductList();
    List<Customer> customers = GetCustomerList();

    var productFirstChars =
        from p in products
        select p.ProductName[0];
    var customerFirstChars =
        from c in customers
        select c.CompanyName[0];

    var productOnlyFirstChars = productFirstChars.Except(customerFirstChars);

    Console.WriteLine("First letters from Product names, but not from Customer names:");
    foreach (var ch in productOnlyFirstChars)
    {
        Console.WriteLine(ch);
    }
}
```
```clojure
//clojure
(defn linq53 []
  (def products products-list)
  (def customers customers-list)

  (def product-first-chars (map #(get (:product-name %) 0) products))
  (def customer-first-chars (map #(get (:company-name %) 0) customers))

  (def product-only-first-chars (difference (set product-first-chars) (set customer-first-chars)))

  (println "First letters from Product names, but not from Customer names:")
  (doall (map println product-only-first-chars))
)
```
#### Output

    First letters from Product names, but not from Customer names:
    J
    U
    Z


LINQ - Conversion Operators
---------------------------

### linq54: ToArray
```csharp
//c#
public void Linq54()
{
    double[] doubles = { 1.7, 2.3, 1.9, 4.1, 2.9 };

    var sortedDoubles =
        from d in doubles
        orderby d descending
        select d;
    var doublesArray = sortedDoubles.ToArray();

    Console.WriteLine("Every other double from highest to lowest:");
    for (int d = 0; d < doublesArray.Length; d += 2)
    {
        Console.WriteLine(doublesArray[d]);
    }
}
```
```clojure
//clojure
(defn linq54 []
  (def dbls [1.7 2.3 1.9 4.1 2.9])
  (def sorted-doubles (->> dbls sort reverse))

  (println "Every other double from highest to lowest:")
  (doall (map println (take-nth 2 sorted-doubles)))
)
```
#### Output

    Every other double from highest to lowest:
    4.1
    2.3
    1.7

### linq55: ToList
```csharp
//c#
public void Linq55()
{
    string[] words = { "cherry", "apple", "blueberry" };

    var sortedWords =
        from w in words
        orderby w
        select w;
    var wordList = sortedWords.ToList();

    Console.WriteLine("The sorted word list:");
    foreach (var w in wordList)
    {
        Console.WriteLine(w);
    }
}
```
```clojure
//clojure
(defn linq55 []
  (def words ["cherry", "apple", "blueberry"])
  (def sorted-words (->> words
                         sort
                         (apply list)))

  (println "The sorted word list:")
  (doall (map println sorted-words))
)
```
#### Output

    The sorted word list:
    apple
    blueberry
    cherry

### linq56: ToDictionary
```csharp
//c#
public void Linq56()
{
    var scoreRecords = new[] { new {Name = "Alice", Score = 50},
                                new {Name = "Bob"  , Score = 40},
                                new {Name = "Cathy", Score = 45}
                            };

    var scoreRecordsDict = scoreRecords.ToDictionary(sr => sr.Name);

    Console.WriteLine("Bob's score: {0}", scoreRecordsDict["Bob"]);
}
```
```clojure
//clojure
(defn linq56 []
  (def sorted-records [{:name "Alice", :score 50}
                       {:name "Bob", :score 40}
                       {:name "Cathy", :score 45}])

  (def sorted-records-dict (->> sorted-records
                                (map #(hash-map (:name %) (:score %)))
                                (into {})))
  (println "Bob's score:" (sorted-records-dict "Bob"))
)
```
#### Output

    Bob's score: 40

### linq57: OfType
```csharp
//c#
public void Linq57()
{
    object[] numbers = { null, 1.0, "two", 3, "four", 5, "six", 7.0 };

    var doubles = numbers.OfType<double>();

    Console.WriteLine("Numbers stored as doubles:");
    foreach (var d in doubles)
    {
        Console.WriteLine(d);
    }
}
```
```clojure
//clojure
(defn linq57 []
  (def numbers [nil 1.0 "two" 3 "four" 5 "six" 7.0])

  (def dbls (filter #(= (type %) java.lang.Double) numbers))

  (println "Numbers stored as doubles:")
  (doall (map println dbls))
)
```
#### Output

    Numbers stored as doubles:
    1.0
    7.0


LINQ - Element Operators
------------------------

### linq58: First - Simple
```csharp
//c#
public void Linq58()
{
    List<Product> products = GetProductList();

    Product product12 = (
        from p in products
        where p.ProductID == 12
        select p)
        .First();

    ObjectDumper.Write(product12);
}
```
```clojure
//clojure
(defn linq58 []
  (def products products-list)

  (def product-12 (->> products
                      (filter #(= (:product-id %) 12))
                       first))

  (println product-12)
)
```
#### Output

    #clj_linq.data.Product{:product-id 12, :product-name Queso Manchego La Pastora, :category Dairy Products, :unit-price 38.0, :units-in-stock 86}

### linq59: First - Condition
```csharp
//c#
public void Linq59()
{
    string[] strings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    string startsWithO = strings.First(s => s[0] == 'o');

    Console.WriteLine("A string starting with 'o': {0}", startsWithO);
}
```
```clojure
//clojure
(defn linq59 []
  (def strings ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"])

  (def starts-with-o (first (filter #(= (get % 0) \o) strings)))

  (println "A string starting with 'o':" starts-with-o)
)
```
#### Output

    A string starting with 'o': one

### linq61: FirstOrDefault - Simple
```csharp
//c#
public void Linq61()
{
    int[] numbers = { };

    int firstNumOrDefault = numbers.FirstOrDefault();

    Console.WriteLine(firstNumOrDefault);
}
```
```clojure
//clojure
(defn linq61 []
  (def numbers [])

  (def first-num-or-default (get numbers 0 0))

  (println first-num-or-default)
)
```
#### Output

    0

### linq62: FirstOrDefault - Condition
```csharp
//c#
public void Linq62()
{
    List<Product> products = GetProductList();

    Product product789 = products.FirstOrDefault(p => p.ProductID == 789);

    Console.WriteLine("Product 789 exists: {0}", product789 != null);
}
```
```clojure
//clojure
(defn linq62 []
  (def products products-list)

  (def product-789 (->> products
                      (filter #(= (:product-id %) 789))
                       first))

  (println "Product 789 exists:" (not= product-789 nil))
)
```
#### Output

    Product 789 exists: false

### linq64: ElementAt
```csharp
//c#
public void Linq64()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    int fourthLowNum = (
        from n in numbers
        where n > 5
        select n)
        .ElementAt(1);  // second number is index 1 because sequences use 0-based indexing

    Console.WriteLine("Second number > 5: {0}", fourthLowNum);
}
```
```clojure
//clojure
(defn linq64 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])

  (def fourth-low-num (->> numbers
                      (filter #(> % 5))
                       second))

  (println "Second number > 5:" fourth-low-num)
)
```
#### Output

    Second number > 5: 8


LINQ - Generation Operators
---------------------------

### linq65: Range
```csharp
//c#
public void Linq65()
{
    var numbers =
        from n in Enumerable.Range(100, 50)

        select new { Number = n, OddEven = n % 2 == 1 ? "odd" : "even" };

    foreach (var n in numbers)
    {
        Console.WriteLine("The number {0} is {1}.", n.Number, n.OddEven);
    }
}
```
```clojure
//clojure
(defn linq65 []

  (def numbers (map #(hash-map
                     :number %,
                     :odd-even (if (= (mod % 2) 1) "odd" "even"))
                    (range 100 151)))

  (doall (map #(println "The number" (:number %) "is" (:odd-even %)) numbers))
)
```
#### Output

    The number 100 is even
    The number 101 is odd
    The number 102 is even
    The number 103 is odd
    The number 104 is even
    The number 105 is odd
    The number 106 is even
    The number 107 is odd
    The number 108 is even
    The number 109 is odd
    The number 110 is even
    ...

### linq66: Repeat
```csharp
//c#
public void Linq66()
{
    var numbers = Enumerable.Repeat(7, 10);

    foreach (var n in numbers)
    {
        Console.WriteLine(n);
    }
}
```
```clojure
//clojure
(defn linq66 []
  (def numbers (repeat 10 7))
  (doall (map println numbers))
)
```
#### Output

    7
    7
    7
    7
    7
    7
    7
    7
    7
    7


LINQ - Quantifiers
------------------

### linq67: Any - Simple
```csharp
//c#
public void Linq67()
{
    string[] words = { "believe", "relief", "receipt", "field" };

    bool iAfterE = words.Any(w => w.Contains("ei"));

    Console.WriteLine("There is a word that contains in the list that contains 'ei': {0}", iAfterE);
}
```
```clojure
//clojure
(defn linq67 []
  (def words ["believe" "relief" "receipt" "field"])

  (def i-after-e (some #(.contains % "ie") words))

  (println "There is a word that contains in the list that contains 'ei':" i-after-e)
)
```
#### Output

    There is a word that contains in the list that contains 'ei': true

### linq69: Any - Grouped
```csharp
//c#
public void Linq69()
{
    List<Product> products = GetProductList();
    var productGroups =
        from p in products
        group p by p.Category into g
        where g.Any(p => p.UnitsInStock == 0)
        select new { Category = g.Key, Products = g };

    ObjectDumper.Write(productGroups, 1);
}
```
```clojure
//clojure
(defn linq69 []
  (def products products-list)

  (def product-groups
    (->> products
         (group-by :category)
         (filter #(some (fn [p] (= (:units-in-stock p) 0)) (get % 1)))
         (map #(hash-map :category (get % 0), :products (get % 1)))))

  (doall (map println product-groups))
)
```
#### Output

    {:products [#clj_linq.data.Product{:product-id 3, :product-name Aniseed Syrup, :category Condiments, :unit-price 10.0, :units-in-stock 13} #clj_linq.data.Product{:product-id 4, :product-name Chef Anton's Cajun Seasoning, :category Condiments, :unit-price 22.0, :units-in-stock 53} #clj_linq.data.Product{:product-id 5, :product-name Chef Anton's Gumbo Mix, :category Condiments, :unit-price 21.35, :units-in-stock 0} #clj_linq.data.Product{:product-id 6, :product-name Grandma's Boysenberry Spread, :category Condiments, :unit-price 25.0, :units-in-stock 120} #clj_linq.data.Product{:product-id 8, :product-name Northwoods Cranberry Sauce, :category Condiments, :unit-price 40.0, :units-in-stock 6} #clj_linq.data.Product{:product-id 15, :product-name Genen Shouyu, :category Condiments, :unit-price 15.5, :units-in-stock 39} #clj_linq.data.Product{:product-id 44, :product-name Gula Malacca, :category Condiments, :unit-price 19.45, :units-in-stock 27} #clj_linq.data.Product{:product-id 61, :product-name Sirop d'érable, :category Condiments, :unit-price 28.5, :units-in-stock 113} #clj_linq.data.Product{:product-id 63, :product-name Vegie-spread, :category Condiments, :unit-price 43.9, :units-in-stock 24} #clj_linq.data.Product{:product-id 65, :product-name Louisiana Fiery Hot Pepper Sauce, :category Condiments, :unit-price 21.05, :units-in-stock 76} #clj_linq.data.Product{:product-id 66, :product-name Louisiana Hot Spiced Okra, :category Condiments, :unit-price 17.0, :units-in-stock 4} #clj_linq.data.Product{:product-id 77, :product-name Original Frankfurter grüne Soße, :category Condiments, :unit-price 13.0, :units-in-stock 32}], :category Condiments}
    ...

### linq70: All - Simple
```csharp
//c#
public void Linq70()
{
    int[] numbers = { 1, 11, 3, 19, 41, 65, 19 };

    bool onlyOdd = numbers.All(n => n % 2 == 1);

    Console.WriteLine("The list contains only odd numbers: {0}", onlyOdd);
}
```
```clojure
//clojure
(defn linq70 []
  (def numbers [1 11 3 19 41 65 19])

  (def only-odd (every? #(= (mod % 2) 1) numbers))

  (println "The list contains only odd numbers:" only-odd)
)
```
#### Output

    The list contains only odd numbers: true

### linq72: All - Grouped
```csharp
//c#
public void Linq72()
{
    List<Product> products = GetProductList();

    var productGroups =
        from p in products
        group p by p.Category into g
        where g.All(p => p.UnitsInStock > 0)
        select new { Category = g.Key, Products = g };

    ObjectDumper.Write(productGroups, 1);
}
```
```clojure
//clojure
(defn linq72 []
  (def products products-list)

  (def product-groups
    (->> products
         (group-by :category)
         (filter #(every? (fn [p] (> (:units-in-stock p) 0)) (get % 1)))
         (map #(hash-map :category (get % 0), :products (get % 1)))
         ))

  (doall (map println product-groups))
)
```
#### Output

    {:products [#clj_linq.data.Product{:product-id 1, :product-name Chai, :category Beverages, :unit-price 18.0, :units-in-stock 39} #clj_linq.data.Product{:product-id 2, :product-name Chang, :category Beverages, :unit-price 19.0, :units-in-stock 17} #clj_linq.data.Product{:product-id 24, :product-name Guaraná Fantástica, :category Beverages, :unit-price 4.5, :units-in-stock 20} #clj_linq.data.Product{:product-id 34, :product-name Sasquatch Ale, :category Beverages, :unit-price 14.0, :units-in-stock 111} #clj_linq.data.Product{:product-id 35, :product-name Steeleye Stout, :category Beverages, :unit-price 18.0, :units-in-stock 20} #clj_linq.data.Product{:product-id 38, :product-name Côte de Blaye, :category Beverages, :unit-price 263.5, :units-in-stock 17} #clj_linq.data.Product{:product-id 39, :product-name Chartreuse verte, :category Beverages, :unit-price 18.0, :units-in-stock 69} #clj_linq.data.Product{:product-id 43, :product-name Ipoh Coffee, :category Beverages, :unit-price 46.0, :units-in-stock 17} #clj_linq.data.Product{:product-id 67, :product-name Laughing Lumberjack Lager, :category Beverages, :unit-price 14.0, :units-in-stock 52} #clj_linq.data.Product{:product-id 70, :product-name Outback Lager, :category Beverages, :unit-price 15.0, :units-in-stock 15} #clj_linq.data.Product{:product-id 75, :product-name Rhönbräu Klosterbier, :category Beverages, :unit-price 7.75, :units-in-stock 125} #clj_linq.data.Product{:product-id 76, :product-name Lakkalikööri, :category Beverages, :unit-price 18.0, :units-in-stock 57}], :category Beverages}
    ...


LINQ - Aggregate Operators
--------------------------

### Clojure utils added
```clojure
(defn average [coll] (/ (reduce + coll) (count coll)))
```

### linq73: Count - Simple
```csharp
//c#
public void Linq73()
{
    int[] factorsOf300 = { 2, 2, 3, 5, 5 };

    int uniqueFactors = factorsOf300.Distinct().Count();

    Console.WriteLine("There are {0} unique factors of 300.", uniqueFactors);
}
```
```clojure
//clojure
(defn linq73 []
  (def factors-of-300 [2 2 3 5 5])

  (def unique-factors (count (distinct factors-of-300)))

  (println "There are" unique-factors "unique factors of 300.")
)
```
#### Output

    There are 3 unique factors of 300.

### linq74: Count - Conditional
```csharp
//c#
public void Linq74()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    int oddNumbers = numbers.Count(n => n % 2 == 1);

    Console.WriteLine("There are {0} odd numbers in the list.", oddNumbers);
}
```
```clojure
//clojure
(defn linq74 []
  (def numbers [4 5 1 3 9 0 6 7 2 0])

  (def odd-numbers (count (filter #(= 1 (mod % 2)) numbers)))

  (println "There are" odd-numbers "odd numbers in the list.")
)
```
#### Output

    There are 5 odd numbers in the list.

### linq76: Count - Nested
```csharp
//c#
public void Linq76()
{
    List<Customer> customers = GetCustomerList();

    var orderCounts =
        from c in customers
        select new { c.CustomerID, OrderCount = c.Orders.Count() };

    ObjectDumper.Write(orderCounts);
}
```
```clojure
//clojure
(defn linq76 []
  (def customers customers-list)

  (def order-counts (map #(hash-map :customer-id (:customer-id %)
                                    :order-count (count (:orders %)))
                         customers))

  (doall (map println order-counts))
)
```
#### Output

    {:customer-id ALFKI, :order-count 6}
    {:customer-id ANATR, :order-count 4}
    {:customer-id ANTON, :order-count 7}
    {:customer-id AROUT, :order-count 13}
    {:customer-id BERGS, :order-count 18}
    {:customer-id BLAUS, :order-count 7}
    {:customer-id BLONP, :order-count 11}
    ...

### linq77: Count - Grouped
```csharp
//c#
public void Linq77()
{
    List<Product> products = GetProductList();

    var categoryCounts =
        from p in products
        group p by p.Category into g
        select new { Category = g.Key, ProductCount = g.Count() };

    ObjectDumper.Write(categoryCounts
}
```
```clojure
//clojure
(defn linq77 []

  (def products products-list)

  (def category-counts
    (->> products
         (group-by :category)
         (map #(hash-map :category (get % 0),
                         :product-count (count (get % 1))))))

  (doall (map println category-counts))
)
```
#### Output

    {:product-count 12, :category Beverages}
    {:product-count 12, :category Condiments}
    {:product-count 5, :category Produce}
    {:product-count 6, :category Meat/Poultry}
    {:product-count 12, :category Seafood}
    {:product-count 10, :category Dairy Products}
    {:product-count 13, :category Confections}
    {:product-count 7, :category Grains/Cereals}

### linq78: Sum - Simple
```csharp
//c#
public void Linq78()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    double numSum = numbers.Sum();

    Console.WriteLine("The sum of the numbers is {0}.", numSum);
}
```
```clojure
//clojure
(defn linq78 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])

  (def num-sum (reduce + numbers))

  (println "The sum of the numbers is " num-sum)
)
```
#### Output

    The sum of the numbers is  45

### linq79: Sum - Projection
```csharp
//c#
public void Linq79()
{
    string[] words = { "cherry", "apple", "blueberry" };

    double totalChars = words.Sum(w => w.Length);

    Console.WriteLine("There are a total of {0} characters in these words.", totalChars);
}
```
```clojure
//clojure
(defn linq79 []
  (def words ["cherry", "apple", "blueberry"])

  (def total-chars (reduce + (map count words)))

  (println "There are a total of" total-chars "characters in these words.")
)
```
#### Output

    There are a total of 20 characters in these words.

### linq80: Sum - Grouped
```csharp
//c#
public void Linq80()
{
    List<Product> products = GetProductList();

    var categories =
        from p in products
        group p by p.Category into g
        select new { Category = g.Key, TotalUnitsInStock = g.Sum(p => p.UnitsInStock) };

    ObjectDumper.Write(categories);
}
```
```clojure
//clojure
(defn linq80 []
  (def products products-list)

  (def categories
    (->> products
         (group-by :category)
         (map #(hash-map :category (get % 0),
                         :total-units-in-stock (reduce + (map :units-in-stock (get % 1)))))))

  (doall (map println categories))
)
```
#### Output

    {:total-units-in-stock 559, :category Beverages}
    {:total-units-in-stock 507, :category Condiments}
    {:total-units-in-stock 100, :category Produce}
    {:total-units-in-stock 165, :category Meat/Poultry}
    {:total-units-in-stock 701, :category Seafood}
    {:total-units-in-stock 393, :category Dairy Products}
    {:total-units-in-stock 386, :category Confections}
    {:total-units-in-stock 308, :category Grains/Cereals}

### linq81: Min - Simple
```csharp
//c#
public void Linq81()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    int minNum = numbers.Min();

    Console.WriteLine("The minimum number is {0}.", minNum);
}
```
```clojure
//clojure
(defn linq81 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])

  (def min-num (apply min numbers))

  (println "The minimum number is" min-num)
)
```
#### Output

    The minimum number is 0

### linq82: Min - Projection
```csharp
//c#
public void Linq82()
{
    string[] words = { "cherry", "apple", "blueberry" };

    int shortestWord = words.Min(w => w.Length);

    Console.WriteLine("The shortest word is {0} characters long.", shortestWord);
}
```
```clojure
//clojure
(defn linq82 []
  (def words ["cherry", "apple", "blueberry"])

  (def shortest-word (apply min (map count words)))

  (println "The shortest word is" shortest-word "characters long.")
)
```
#### Output

    The shortest word is 5 characters long.

### linq83: Min - Grouped
```csharp
//c#
public void Linq83()
{
    List<Product> products = GetProductList();

    var categories =
        from p in products
        group p by p.Category into g
        select new { Category = g.Key, CheapestPrice = g.Min(p => p.UnitPrice) };

    ObjectDumper.Write(categories);
}
```
```clojure
//clojure
(defn linq83 []
  (def products products-list)

  (def categories
    (->> products
         (group-by :category)
         (map #(hash-map :category (get % 0),
                         :cheapest-price (apply min (map :unit-price (get % 1)))))))

  (doall (map println categories))
)
```
#### Output

    {:cheapest-price 4.5, :category Beverages}
    {:cheapest-price 10.0, :category Condiments}
    {:cheapest-price 10.0, :category Produce}
    {:cheapest-price 7.45, :category Meat/Poultry}
    {:cheapest-price 6.0, :category Seafood}
    {:cheapest-price 2.5, :category Dairy Products}
    {:cheapest-price 9.2, :category Confections}
    {:cheapest-price 7.0, :category Grains/Cereals}

### linq84: Min - Elements
```csharp
//c#
public void Linq84()
{
    List<Product> products = GetProductList();

    var categories =
        from p in products
        group p by p.Category into g
        let minPrice = g.Min(p => p.UnitPrice)
        select new { Category = g.Key, CheapestProducts = g.Where(p => p.UnitPrice == minPrice) };

    ObjectDumper.Write(categories, 1);
}
```
```clojure
//clojure
(defn linq84 []
  (def products products-list)

  (def categories
    (->> products
         (group-by :category)
         (map (fn [g]
           (let [min-price (apply min (map :unit-price (get g 1)))]
             (hash-map
              :category (get g 0)
              :cheapest-products
              (filter #(= (:unit-price %) min-price)
                      (get g 1))
              )
             )))
         ))

  (doall (map println categories))
)
```
#### Output

    {:cheapest-products (#clj_linq.data.Product{:product-id 24, :product-name Guaraná Fantástica, :category Beverages, :unit-price 4.5, :units-in-stock 20}), :category Beverages}
    {:cheapest-products (#clj_linq.data.Product{:product-id 3, :product-name Aniseed Syrup, :category Condiments, :unit-price 10.0, :units-in-stock 13}), :category Condiments}
    {:cheapest-products (#clj_linq.data.Product{:product-id 74, :product-name Longlife Tofu, :category Produce, :unit-price 10.0, :units-in-stock 4}), :category Produce}
    {:cheapest-products (#clj_linq.data.Product{:product-id 54, :product-name Tourtière, :category Meat/Poultry, :unit-price 7.45, :units-in-stock 21}), :category Meat/Poultry}
    {:cheapest-products (#clj_linq.data.Product{:product-id 13, :product-name Konbu, :category Seafood, :unit-price 6.0, :units-in-stock 24}), :category Seafood}
    {:cheapest-products (#clj_linq.data.Product{:product-id 33, :product-name Geitost, :category Dairy Products, :unit-price 2.5, :units-in-stock 112}), :category Dairy Products}
    {:cheapest-products (#clj_linq.data.Product{:product-id 19, :product-name Teatime Chocolate Biscuits, :category Confections, :unit-price 9.2, :units-in-stock 25}), :category Confections}
    {:cheapest-products (#clj_linq.data.Product{:product-id 52, :product-name Filo Mix, :category Grains/Cereals, :unit-price 7.0, :units-in-stock 38}), :category Grains/Cereals}

### linq85: Max - Simple
```csharp
//c#
public void Linq85()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    int maxNum = numbers.Max();

    Console.WriteLine("The maximum number is {0}.", maxNum);
}
```
```clojure
//clojure
(defn linq85 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])

  (def max-num (apply max numbers))

  (println "The maximum number is" max-num)
)
```
#### Output

    The maximum number is 9

### linq86: Max - Projection
```csharp
//c#
public void Linq86()
{
    string[] words = { "cherry", "apple", "blueberry" };

    int longestLength = words.Max(w => w.Length);

    Console.WriteLine("The longest word is {0} characters long.", longestLength);
}
```
```clojure
//clojure
(defn linq86 []
  (def words ["cherry", "apple", "blueberry"])

  (def longest-word (apply max (map count words)))

  (println "The longest word is" longest-word "characters long.")
)
```
#### Output

    The longest word is 9 characters long.

### linq87: Max - Grouped
```csharp
//c#
public void Linq87()
{
    List<Product> products = GetProductList();

    var categories =
        from p in products
        group p by p.Category into g
        select new { Category = g.Key, MostExpensivePrice = g.Max(p => p.UnitPrice) };

    ObjectDumper.Write(categories);
}
```
```clojure
//clojure
(defn linq87 []
  (def products products-list)

  (def categories
    (->> products
         (group-by :category)
         (map #(hash-map :category (get % 0),
                         :most-expensive-price (apply max (map :unit-price (get % 1)))))))

  (doall (map println categories))
)
```
#### Output

    {:most-expensive-price 263.5, :category Beverages}
    {:most-expensive-price 43.9, :category Condiments}
    {:most-expensive-price 53.0, :category Produce}
    {:most-expensive-price 123.79, :category Meat/Poultry}
    {:most-expensive-price 62.5, :category Seafood}
    {:most-expensive-price 55.0, :category Dairy Products}
    {:most-expensive-price 81.0, :category Confections}
    {:most-expensive-price 38.0, :category Grains/Cereals}

### linq88: Max - Elements
```csharp
//c#
public void Linq88()
{
    List<Product> products = GetProductList();

    var categories =
        from p in products
        group p by p.Category into g
        let maxPrice = g.Max(p => p.UnitPrice)
        select new { Category = g.Key, MostExpensiveProducts = g.Where(p => p.UnitPrice == maxPrice) };

    ObjectDumper.Write(categories, 1);
}
```
```clojure
//clojure
(defn linq88 []
  (def products products-list)

  (def categories
    (->> products
         (group-by :category)
         (map (fn [g]
           (let [max-price (apply max (map :unit-price (get g 1)))]
             (hash-map
              :category (get g 0)
              :most-expensive-products
              (filter #(= (:unit-price %) max-price)
                      (get g 1))
              )
             )))
         ))

  (doall (map println categories))
)
```
#### Output

    {:most-expensive-products (#clj_linq.data.Product{:product-id 38, :product-name Côte de Blaye, :category Beverages, :unit-price 263.5, :units-in-stock 17}), :category Beverages}
    {:most-expensive-products (#clj_linq.data.Product{:product-id 63, :product-name Vegie-spread, :category Condiments, :unit-price 43.9, :units-in-stock 24}), :category Condiments}
    {:most-expensive-products (#clj_linq.data.Product{:product-id 51, :product-name Manjimup Dried Apples, :category Produce, :unit-price 53.0, :units-in-stock 20}), :category Produce}
    {:most-expensive-products (#clj_linq.data.Product{:product-id 29, :product-name Thüringer Rostbratwurst, :category Meat/Poultry, :unit-price 123.79, :units-in-stock 0}), :category Meat/Poultry}
    {:most-expensive-products (#clj_linq.data.Product{:product-id 18, :product-name Carnarvon Tigers, :category Seafood, :unit-price 62.5, :units-in-stock 42}), :category Seafood}
    {:most-expensive-products (#clj_linq.data.Product{:product-id 59, :product-name Raclette Courdavault, :category Dairy Products, :unit-price 55.0, :units-in-stock 79}), :category Dairy Products}
    {:most-expensive-products (#clj_linq.data.Product{:product-id 20, :product-name Sir Rodney's Marmalade, :category Confections, :unit-price 81.0, :units-in-stock 40}), :category Confections}
    {:most-expensive-products (#clj_linq.data.Product{:product-id 56, :product-name Gnocchi di nonna Alice, :category Grains/Cereals, :unit-price 38.0, :units-in-stock 21}), :category Grains/Cereals}

### linq89: Average - Simple
```csharp
//c#
public void Linq89()
{
    int[] numbers = { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    double averageNum = numbers.Average();

    Console.WriteLine("The average number is {0}.", averageNum);
}
```
```clojure
//clojure
(defn linq89 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])

  (def avg (average numbers))

  (println "The average number is" avg)
)
```
#### Output

    The average number is 9/2

### linq90: Average - Projection
```csharp
//c#
public void Linq90()
{
    string[] words = { "cherry", "apple", "blueberry" };

    double averageLength = words.Average(w => w.Length);

    Console.WriteLine("The average word length is {0} characters.", averageLength);
}
```
```clojure
//clojure
(defn linq90 []
  (def words ["cherry", "apple", "blueberry"])

  (def average-length (average (map count words)))

  (println "The average word length is" average-length "characters.")
)
```
#### Output

    The average word length is 20/3 characters.

### linq91: Average - Grouped
```csharp
//c#
public void Linq91()
{
    List<Product> products = GetProductList();

    var categories =
        from p in products
        group p by p.Category into g
        select new { Category = g.Key, AveragePrice = g.Average(p => p.UnitPrice) };

    ObjectDumper.Write(categories);
}
```
```clojure
//clojure
(defn linq91 []
  (def products products-list)

  (def categories
    (->> products
         (group-by :category)
         (map #(hash-map :category (get % 0),
                         :average-price (average (map :unit-price (get % 1)))))))

  (doall (map println categories))
)
```
#### Output

    {:average-price 37.979166666666664, :category Beverages}
    {:average-price 23.0625, :category Condiments}
    {:average-price 32.37, :category Produce}
    {:average-price 54.00666666666667, :category Meat/Poultry}
    {:average-price 20.6825, :category Seafood}
    {:average-price 28.73, :category Dairy Products}
    {:average-price 25.16, :category Confections}
    {:average-price 20.25, :category Grains/Cereals}

### linq92: Aggregate - Simple
```csharp
//c#
public void Linq92()
{
    double[] doubles = { 1.7, 2.3, 1.9, 4.1, 2.9 };

    double product = doubles.Aggregate((runningProduct, nextFactor) => runningProduct * nextFactor);

    Console.WriteLine("Total product of all numbers: {0}", product);
}
```
```clojure
//clojure
(defn linq92 []
  (def dbls [1.7 2.3 1.9 4.1 2.9])

  (def product (reduce * dbls))

  (println "Total product of all numbers:" product)
)
```
#### Output

    Total product of all numbers: 88.33080999999999

### linq93: Aggregate - Seed
```csharp
//c#
public void Linq93()
{
    double startBalance = 100.0;

    int[] attemptedWithdrawals = { 20, 10, 40, 50, 10, 70, 30 };

    double endBalance =
        attemptedWithdrawals.Aggregate(startBalance,
            (balance, nextWithdrawal) =>
                ((nextWithdrawal <= balance) ? (balance - nextWithdrawal) : balance));

    Console.WriteLine("Ending balance: {0}", endBalance);
}
```
```clojure
//clojure
(defn linq93 []
  (def start-balance 100)
  (def attempted-withdrawls [20 10 40 50 10 70 30])

  (def end-balance (reduce #(identity (if (<= %2 %1) (- %1 %2) %1))
                           start-balance attempted-withdrawls))

  (println "Ending balance:" end-balance)
)
```
#### Output

    Ending balance: 20


LINQ - Miscellaneous Operators
------------------------------

### linq94: Concat - 1
```csharp
//c#
public void Linq94()
{
    int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
    int[] numbersB = { 1, 3, 5, 7, 8 };

    var allNumbers = numbersA.Concat(numbersB);

    Console.WriteLine("All numbers from both arrays:");
    foreach (var n in allNumbers)
    {
        Console.WriteLine(n);
    }
}
```
```clojure
//clojure
(defn linq94 []
  (def numbers-a [0 2 4 5 6 8 9])
  (def numbers-b [1 3 5 7 8])

  (def all-numbers (flatten [numbers-a numbers-b]))

  (println "All numbers from both arrays:")
  (doall (map println all-numbers))
)
```
#### Output

    All numbers from both arrays:
    0
    2
    4
    5
    6
    8
    9
    1
    3
    5
    7
    8

### linq95: Concat - 2
```csharp
//c#
public void Linq95()
{
    List<Customer> customers = GetCustomerList();
    List<Product> products = GetProductList();

    var customerNames =
        from c in customers
        select c.CompanyName;
    var productNames =
        from p in products
        select p.ProductName;

    var allNames = customerNames.Concat(productNames);

    Console.WriteLine("Customer and product names:");
    foreach (var n in allNames)
    {
        Console.WriteLine(n);
    }
}
```
```clojure
//clojure
(defn linq95 []
  (def products products-list)
  (def customers customers-list)

  (def customer-names (map :company-name customers))
  (def product-names (map :product-name products))

  (def all-names (flatten [customer-names product-names]))

  (println "Customer and product names:")
  (doall (map println all-names))
)
```
#### Output

    Customer and product names:
    Alfreds Futterkiste
    Ana Trujillo Emparedados y helados
    Antonio Moreno Taquería
    Around the Horn
    Berglunds snabbköp
    Blauer See Delikatessen
    ...

### linq96: EqualAll - 1
```csharp
//c#
public void Linq96()
{
    var wordsA = new string[] { "cherry", "apple", "blueberry" };
    var wordsB = new string[] { "cherry", "apple", "blueberry" };

    bool match = wordsA.SequenceEqual(wordsB);

    Console.WriteLine("The sequences match: {0}", match);
}
```
```clojure
//clojure
(defn linq96 []
  (def words-a ["cherry" "apple" "blueberry"])
  (def words-b ["cherry" "apple" "blueberry"])

  (def match (= words-a words-b))

  (println "The sequences match:" match)
)
```
#### Output

    The sequences match: true

### linq97: EqualAll - 2
```csharp
//c#
public void Linq97()
{
    var wordsA = new string[] { "cherry", "apple", "blueberry" };
    var wordsB = new string[] { "apple", "blueberry", "cherry" };

    bool match = wordsA.SequenceEqual(wordsB);

    Console.WriteLine("The sequences match: {0}", match);
}
```
```clojure
//clojure
(defn linq97 []
  (def words-a ["cherry" "apple" "blueberry"])
  (def words-b ["apple" "blueberry" "cherry"])

  (def match (= words-a words-b))

  (println "The sequences match:" match)
)
```
#### Output

    The sequences match: false


LINQ - Query Execution
----------------------

### linq99: Deferred Execution
```csharp
//c#
public void Linq99()
{
    // Sequence operators form first-class queries that
    // are not executed until you enumerate over them.

    int[] numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    int i = 0;
    var q =
        from n in numbers
        select ++i;

    // Note, the local variable 'i' is not incremented
    // until each element is evaluated (as a side-effect):
    foreach (var v in q)
    {
        Console.WriteLine("v = {0}, i = {1}", v, i);
    }
}
```
```clojure
//clojure
(defn linq99 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])

  (def i (atom 0))
  (def q (map (fn [x] (swap! i inc)) (range 10)))

  (println @i (count q) @i)
)
```
#### Output

    0 10 10

### linq100: Immediate Execution
```csharp
//c#
public void Linq100()
{
    // Methods like ToList() cause the query to be
    // executed immediately, caching the results.

    int[] numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    int i = 0;
    var q = (
        from n in numbers
        select ++i)
        .ToList();

    // The local variable i has already been fully
    // incremented before we iterate the results:
    foreach (var v in q)
    {
        Console.WriteLine("v = {0}, i = {1}", v, i);
    }
}
```
```clojure
//clojure
(defn linq100 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])

  (def i (atom 0))
  (def q (into [] (map (fn [x] (swap! i inc)) (range 10))))

  (println @i (count q) @i)
)
```
#### Output

    10 10 10

### linq101: Query Reuse
```csharp
//c#
public void Linq101()
{
    // Deferred execution lets us define a query once
    // and then reuse it later after data changes.

    int[] numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
    var lowNumbers =
        from n in numbers
        where n <= 3
        select n;

    Console.WriteLine("First run numbers <= 3:");
    foreach (int n in lowNumbers)
    {
        Console.WriteLine(n);
    }

    for (int i = 0; i < 10; i++)
    {
        numbers[i] = -numbers[i];
    }

    // During this second run, the same query object,
    // lowNumbers, will be iterating over the new state
    // of numbers[], producing different results:
    Console.WriteLine("Second run numbers <= 3:");
    foreach (int n in lowNumbers)
    {
        Console.WriteLine(n);
    }
}
```
```clojure
//clojure
(defn linq101 []
  (def ^:dynamic numbers [5 4 1 3 9 8 6 7 2 0])

  (defn low-numbers []
    (filter #(<= % 3) numbers))

  (println "First run numbers <= 3:")
  (doall (map println (low-numbers)))

  (println "Second run numbers <= 3")
  (binding [numbers (map #(* -1 %) numbers)]
    (doall (map println (low-numbers))))
)
```
#### Output

    First run numbers <= 3:
    1
    3
    2
    0
    Second run numbers <= 3
    -5
    -4
    -1
    -3
    -9
    -8
    -6
    -7
    -2
    0


LINQ - Join Operators
---------------------

### Clojure utils added

```clojure
(defn join [coll with-coll matcher]
  (map (fn [x] {:key x :items (filter (fn [y] (matcher x y)) with-coll)})
       coll))
```

### linq102: Cross Join
```csharp
//c#
public void Linq102()
{
    string[] categories = new string[]{
        "Beverages",
        "Condiments",
        "Vegetables",
        "Dairy Products",
        "Seafood" };

    List<Product> products = GetProductList();

    var q =
        from c in categories
        join p in products on c equals p.Category
        select new { Category = c, p.ProductName };

    foreach (var v in q)
    {
        Console.WriteLine(v.ProductName + ": " + v.Category);
    }
}
```
```clojure
//clojure
(defn linq102 []
  (let [categories ["Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"]
        products products-list
        q (flatten 
           (map (fn [pc] (map #(identity {:category (:key pc), :product-name (:product-name %)})
                              (:items pc)))
                (join categories products #(= %1 (:category %2)))))]
    (doseq [v q]
      (println (:product-name v) ":" (:category v)))))
```
#### Output

    Chai : Beverages
    Chang : Beverages
    Guaraná Fantástica : Beverages
    Sasquatch Ale : Beverages
    Steeleye Stout : Beverages
    Côte de Blaye : Beverages
    Chartreuse verte : Beverages
    Ipoh Coffee : Beverages
    ...

### linq103: Group Join
```csharp
//c#
public void Linq103()
{
    string[] categories = new string[]{
        "Beverages",
        "Condiments",
        "Vegetables",
        "Dairy Products",
        "Seafood" };

    List<Product> products = GetProductList();

    var q =
        from c in categories
        join p in products on c equals p.Category into ps
        select new { Category = c, Products = ps };

    foreach (var v in q)
    {
        Console.WriteLine(v.Category + ":");
        foreach (var p in v.Products)
        {
            Console.WriteLine("   " + p.ProductName);
        }
    }
}
```
```clojure
//clojure
(defn linq103[]
  (let [categories ["Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"]
        products products-list
        q (for [pc (join categories products #(= %1 (:category %2)))] 
            {:category (:key pc), :products (:items pc)})]

    (doseq [pc q]
      (println (:category pc))
      (doseq [product (:products pc)]
        (println " " (:product-name product))))))
```
#### Output

    Beverages
      Chai
      Chang
      Guaraná Fantástica
      Sasquatch Ale
      Steeleye Stout
      Côte de Blaye
      Chartreuse verte
      Ipoh Coffee
      Laughing Lumberjack Lager
      Outback Lager
      Rhönbräu Klosterbier
      Lakkalikööri
    Condiments
      Aniseed Syrup
      Chef Anton's Cajun Seasoning
      Chef Anton's Gumbo Mix
      Grandma's Boysenberry Spread
      Northwoods Cranberry Sauce
      Genen Shouyu
      Gula Malacca
      Sirop d'érable
      Vegie-spread
      Louisiana Fiery Hot Pepper Sauce
      Louisiana Hot Spiced Okra
      Original Frankfurter grüne Soße
    ...

### linq104: Cross Join with Group Join
```csharp
//c#
public void Linq104()
{
    string[] categories = new string[]{
        "Beverages",
        "Condiments",
        "Vegetables",
        "Dairy Products",
        "Seafood" };

    List<Product> products = GetProductList();

    var q =
        from c in categories
        join p in products on c equals p.Category into ps
        from p in ps
        select new { Category = c, p.ProductName };

    foreach (var v in q)
    {
        Console.WriteLine(v.ProductName + ": " + v.Category);
    }
}
```
```clojure
//clojure
(defn linq104[]
  (let [categories ["Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"]
        products products-list
        q (flatten 
           (for [pc (join categories products #(= %1 (:category %2)))]
             (for [p (:items pc)] 
               {:category (:key pc), 
                :product-name (:product-name p)})))]
    (doseq [p q]
    (println (:product-name p) ":" (:category p)))))
```
#### Output

    Chai : Beverages
    Chang : Beverages
    Guaraná Fantástica : Beverages
    Sasquatch Ale : Beverages
    Steeleye Stout : Beverages
    Côte de Blaye : Beverages
    Chartreuse verte : Beverages
    Ipoh Coffee : Beverages
    Laughing Lumberjack Lager : Beverages
    Outback Lager : Beverages
    Rhönbräu Klosterbier : Beverages
    Lakkalikööri : Beverages
    Aniseed Syrup : Condiments
    Chef Anton's Cajun Seasoning : Condiments
    Chef Anton's Gumbo Mix : Condiments
    ...

### linq105: Left Outer Join
```csharp
//c#
public void Linq105()
{
    string[] categories = new string[]{
        "Beverages",
        "Condiments",
        "Vegetables",
        "Dairy Products",
        "Seafood" };

    List<Product> products = GetProductList();

    var q =
        from c in categories
        join p in products on c equals p.Category into ps
        from p in ps.DefaultIfEmpty()
        select new { Category = c, ProductName = p == null ? "(No products)" : p.ProductName };

    foreach (var v in q)
    {
        Console.WriteLine(v.ProductName + ": " + v.Category);
    }
}
```
```clojure
//clojure
(defn linq105 []
  (let [categories ["Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"]
        products products-list
        q (flatten
           (for [pc (join categories products #(= %1 (:category %2)))]
             (if (empty? (:items pc))
               {:category (:key pc), :product-name "(No products)"}
               (for [p (:items pc)]
                 {:category (:key pc), 
                  :product-name (:product-name p)}))))]
    (doseq [p q]
      (println (:product-name p) ":" (:category p)))))
```
#### Output

    Chai: Beverages
    Chang: Beverages
    Guaraná Fantástica: Beverages
    Sasquatch Ale: Beverages
    Steeleye Stout: Beverages
    Côte de Blaye: Beverages
    Chartreuse verte: Beverages
    Ipoh Coffee: Beverages
    Laughing Lumberjack Lager: Beverages
    Outback Lager: Beverages
    Rhönbräu Klosterbier: Beverages
    Lakkalikööri: Beverages
    Aniseed Syrup: Condiments
    Chef Anton's Cajun Seasoning: Condiments
    Chef Anton's Gumbo Mix: Condiments
    Grandma's Boysenberry Spread: Condiments
    Northwoods Cranberry Sauce: Condiments
    Genen Shouyu: Condiments
    Gula Malacca: Condiments
    Sirop d'érable: Condiments
    Vegie-spread: Condiments
    Louisiana Fiery Hot Pepper Sauce: Condiments
    Louisiana Hot Spiced Okra: Condiments
    Original Frankfurter grüne Soße: Condiments
    (No products): Vegetables
    ...


### Contributors

  - [mythz](https://github.com/mythz) (Demis Bellot)
