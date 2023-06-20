Java SE 8
---------------------------------------------------------------------------------------------

    Lab Setup
        JDK 1.8
        Eclipse IDE
        MySQL as Database Engine

    Intro

        Tokens?
            Identifiers
            Keywords
            Operators
            Comments
            Literals

        prmitive data types

            byte
            short
            int
            long
            double
            float
            char
            boolean
            void

        User Defined Types
            arrays
            classes
            interfaces
            enums
            annotations

        
    java.lang

        Object

            is the top-most super class.
            hashcode()
            toString()
            equals(Object)
            
            wait()
            notify()
            notifyAll()

        System

            err
            in
            out

            gc()

        Math

        String
        StringBuilder
        StringBuffer

Exception Handling

        Throwable
            ↑
            ---------------------
            ↑                   ↑
            Exception           Error
            ↑
            RuntimeException


        Excepiton and all its sub-classes except RuntimeException are called CHECKED EXCEPTIONS
        RuntimeExcepiton and all its sub-classes are called UNCHECKED EXCEPTIONS

        class Employee {
            private int empId;
            private String name;
            private String[] skills;

            //constructors, getters and setter.........

            public String getSkillByIndex(int index){
                return skills==null || index<0 || index>=skills.length? null : skills[index];
            }
        }

        //multiple catch 

        try{
            //statements
        }catch(ExceptionType1 exp){
            //exception handling code..
        }catch(ExceptionType2 exp){
            //exception handling code..
        }catch(ExceptionType3 exp){
            //exception handling code..
        }catch(ExceptionType4 exp){
            //exception handling code..
        }finally{
            //code that has to execute at any cost.
        }

        //multi catch
        try{
            //statements
        }catch(ExceptionType1  | ExceptionType2  | ExceptionType3 | ExceptionType4 exp){
            //exception handling code..
        }finally{
            //code that has to execute at any cost.
        }

        //try-with-resources
        try(FileInputStream fin = new FileInputStream(fileName)){
            //work with the fin
        }catch(IOException exp){
            //handle the ioexception....
        }
        
        //the fin object is clsoed automatically no need of a finally block.

        throw //raise an exception
        throws //transfers an exception from a method to its caller method


    Case Study - BankingOperations

        com.cts.exceptionsdemo.model.BankAccount
            - accountNumber : String
            - balance : double
            + default and paramatrised constructor
            + getters and setters
            + toString()

        com.cts.exceptionsdemo.service.BankingService
            + deposite(BankAccount account,double amonut) : void 
            + withdraw(BankAccount account,double amount) : void

        com.cts.exceptionsdemo.excpetions.DepositeException
        com.cts.exceptionsdemo.excpetions.WithdrawException

        com.cts.exceptionsdemo.BankingApplication
            + static void main
                /*
                1. create a bankaccount
                2. accept 'DEPOSIT/WITHDRAW/BALANCE/QUIT
                3. perform the givne operation until QUIT
                4. Handle the exceptions when they occur
                */


Multi Threading

    multi-tasking vs multi-threading

    java.lang.Runnable
                ↑
                java.lang.Thread

                            Thread()
                            Thread(Runnable job)
                            Thread(String name,Runnable job)

                            start()
                            join()
                            currentThread() : Thread
                            sleep(long)



                new Thread()
                    (initiation)
                        ↓
                    [ READY... ] --------(when the resources are available ) -------|
                         ↑                                                          |
                         |                                                          |
                         |                                                          ↓
                    [ PAUSED .. ]  ←--------sleep()------------------------  [ EXECUTION..... ] run()
                                                                                    |
                                                                                    | onCompletion
                                                                                    ↓    
                                                                                [ STOP .. ]

    Date and Time api

        java.time

            LocalDate           .of(year,month,day),.now()
            LocalTime           .of(hour,minute,second),.now()
            LocalDateTime       .of(year,month,day,hour,minute,second),.now()
            ZonedDateTime       .of(year,month,day,hour,minute,second,zondId),.now(zoneId)

            Period              .between(startDate,endDate)
            Duration            .between(startTime,endTime)

            DateTiemFormaater   .ofPattern("")

    Collections

        java.util.Collection
                    ↑
                ------------------------
                ↑                      ↑
                List                  Set
                                        ↑
                                        SortedSet

                Collection
                    void add(Object)
                    int size()
                    boolean isEmpty()
                    boolean contains(Object)
                    void remove(Object)
                    Stream stream()
                    void clear()

                List
                        1. is a linear data structure
                        2. each element in the list is given an index, and hence random access is possible
                        3. an element can duplicate itself in the lsit
                        4. nulls are also allowed in the list

                        ArrayList       is a growable unsynchronized array implementation
                        Vector          is a growable synchronronized array implementation
                        LinkedList      is a doublelly linked list implmentation

                Set
                        1. is a non linear data structure
                        2. the elements in a set does not have index.
                        3. set are implimentations of tree data-structure.
                        4. duplication is not allowed
                        5. only one null is allowed

                        HashSet             does not have any order of retrival
                        LinkedHashSet       retrives elements in entry order
                        TreeSet             retrives elements in sorted order

            java.util.Map
            java.utilSortedMap

                        1. is a key-value pair
                        2. the key is not expected to repeat or null.

                        HashMap         doest not ahve nay order on the keys
                        LinkedHashMap   has the keys in entry order
                        TreeMap         has the keys in sorted order

            java.util.Comparator
            java.lang.Comparable

            java.util.Collections

    Case Study Assignment 
    --------------------------------------------------------------------------------

        Develop a console application that is menu driven to perform add, retriving, and deleting Employee
        object from a list.

            com.cts.hrapp
                    HRApp.java
                    HRMenu.java (ADD,LIST,FIND,DELETE,QUIT)
            com.cts.hrapp.model
                    Employee.java
            com.cts.hrapp.dao
                    EmployeeDao.java
                    EmployeeDaoImpl.java        //we will have to perform operations on a list
            com.cts.hrapp.service
                    EmployeeService
                    EmployeeServiceImpl.java    //we will have to validate data before passing it to dao
            com.cts.hrapp.exception
                    EmployeeException.java

    Functional Interfaces and Lambda Expressions

        Functional Interfaces
            Supplier
            Consumer
            Predicate
            Functional

        java.util.function 

        a lambda expression is an inline implementation of a functional interface.

        FunctonalInterface obj1 = (paramsList) -> returnValue ;

        FunctonalInterface obj2 = oneParam -> returnValue ;

        FunctonalInterface obj3 = (paramsList) -> {
            
            /*************
                implementation code
            *******************/

            return  returnValue ;
        }

    Streams API

        java.util.stream

                    Stream

                        is a flow of data and can facilitate execution of a chain of 
                        operations on that data.

                        Stream s1 = empList.stream();
                        Stream s2 = empSet.stream();
                        Stream s3 = Stream.of(empArray);

                        Integer[] nums = new Integer[]{1,2,3,4,5,6,7,8,9};

                        filter      that accepts a predicate, and returns a new stream that contians those elements
                                        for those the predicate returns true. (intermidiate operation)

                                    Streams stream1 = Stream.of(nums).filter( n -> x%2==0);
                        
                        map         that accepts a transformer (accepts an x and returns a y), and returns a new stream
                                        of all resutls of the transformer for each element in the original stream.
                                        (intermidiate operation)

                                    Streams stream2 = Stream.of(nums).map( n -> n*n );

                        reduce      that accepts a binaryOperator, that binaryoperator is executed on each pair
                                    of elements until the whole stream is reduced to one single value and 
                                    that value is returned. (terminal operation)

                                    int s = Stream.of(nums).reduce( (a,b) -> a+b ); //45

                        forEach     that accepts a consumer, and executes the consuemr on each ele of the stream,
                                    and has no return and hence called a terminal operation.
                        
                        collect     is sued to collect all the elements in stream into a list or set or an array.

                        
                        