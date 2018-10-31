# Virtual Memory Simulator.

>This project seeks to simulate the virtual memory processes available in most CPUs

The following are what are implemented in the project:

- The reader of txt files for the purpose of test trace input.

- A simulator of MMU including:
    
    - TLB

    - Page Table

    - Simulated access, and fault times

---

## How to Compile and Run:

    gcc -o VirtualMemory VirtualMemory.c FileIO.c Auxiliary.c && ./VirtualMemory

---

### Final Notes:

>It is likely that this project uses more files and headers than strictly necessary, though it has been quite useful as practice for compilation and linking – using the <code>extern</code> keyword has been a bit of an odyssey unto itself! 