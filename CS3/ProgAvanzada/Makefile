CPP = /usr/local/opt/llvm/bin/clang
CPPFLAGS = -I/usr/local/opt/llvm/include -fopenmp
LDFLAGS = -L/usr/local/opt/llvm/lib

omp_build: testOPENMP.c
	$(CPP) $(CPPFLAGS) $^ -o $@ $(LDFLAGS)


run: omp_build
	./omp_build

fast: testOPENMP.c
	$(CPP) $(CPPFLAGS) $^ -o $@ $(LDFLAGS) && ./omp_build

tarea5: tarea5_2.c
	$(CPP) $(CPPFLAGS) $^ -o $@ $(LDFLAGS) 

runTarea: tarea5
	./tarea5
