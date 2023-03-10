####################################################################################################################     
########    ######  ##      ###### ###### ##     ###### ##  ## ##     ######  ########  ######  ######    #########                                          ####################
########    ##  ##  ##      ##     ##  ## ##     ##     ##  ## ##     ##  ##     ##     ##  ##  ##  ##    #########
########    ######  ##      ##     ###### ##     ##     ##  ## ##     ######     ##     ##  ##  ######    #########
########    ##      ##      ###### ##  ## ###### ###### ###### ###### ##  ##     ##     ######  ##  ####  #########
###################################################################################################################

------------- version 1.0.0 --------------

# Getting started 
This microservice use three different methods in order to calculate Pi number in different ages of human history:

-  from 1300 to 1910 age (Method of arctan(1) with correction method used)  -> implemented for PiCalculatorMethodCE class
-  from 1910 to current age (Indian mathematician Srinivasa Ramanujan Method used) -> implemented for PiCalculatorCurrentMethod class
-  BCE age (best of methods egyptian, archimedes lowest and highest correction used) -> implemented for PiCalculatorMethodBCE class

if you need more information about theses historical methods, visit the followings links:

- [https://en.wikipedia.org/wiki/Approximations_of_%CF%80](https://en.wikipedia.org/wiki/Chronology_of_computation_of_%CF%80)
- [https://en.wikipedia.org/wiki/Chronology_of_computation_of_%CF%80](https://en.wikipedia.org/wiki/Chronology_of_computation_of_%CF%80)



# Rest services structure 

This microservice contains the following methods that you can use as a client:

 - GET {host}/piCalculator/result/{{digits}}/{{age}}
   - method which calculates pi number with a determined number of decimals provided and age when the most famous method was used.
     3 methods are available in this version 1.0.0.
     - digits: is the number of decimals that you want to receive from the pi number. In this beta version, the number of 
       iterations is a constant which limited the precision of pi number.
     - age: is the BCE or CE age. Currently, are available three different ranges: [200BCE , 0] , [1300 to 1910 CE] and [1910 to 2022]



#### Design patterns used

## Creational patterns

   - Abstract factory: to implement pi calculator methology in order to implement thre methods and
        to implement piFactory
   - Factory method: between PiCalculatorGeneric class and subclass PiCalculatorAndAgeSelector class 
        which is more concrete
   - Singleton: which is used in any bean that was created (service, factory and calculators)


## Structural patterns

   - Adapter: procedure used in PiCalculatorAndAgeSelector implementation
   - Facade: used to decide which implementation needs to be used to calculate pi number with data 
        provided by the client (Methodology -> 3 implementations)

## Behavioral patterns

   - Chain of responsibility: when the client request pass to specified method to be calculated
        through a handler (controller -> factory -> selector -> calculator )
   - Iterator: used to iterate which a method provided by a mathematician and a determined number of
        iterations, an approach of the pi value




