cp = gcc
all: main.out

main.out: main.o hello.o
	$(cp) -o main.out main.o hello.o
main.o: main.c
	$(cp) -c main.c
hello.o: hello.c
	$(cp) -c hello.c
