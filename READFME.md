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