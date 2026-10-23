# **Project 1 - Bank Account**

  

## **Part 1**

-   ​**Why might two threads overwrite each other's balance updates**?

Two threads can overwrite each other due to a race condition caused by unsynchronized access to the shared state. Updating a balance is not atomic; it involves multiple steps.

Without synchronization, two threads will autonomously read and write to update the balance, overwriting each other. 

• **What happens if two customers both read the same balance before either updates it?**

Inconsistent state and incorrect balances. One customer's transaction can be ignored or overwritten by the other read. 

**• Why did we add Thread.yield() between reading and writing the balance?**

​Thread.yield() encourages interleaving, meaning that we can debug the race conditions more easily. Yielding creates scheduling behavior between the two operations and can still produce an incorrect result.

​-   ​  
    
-   ​
​​

​

​

​