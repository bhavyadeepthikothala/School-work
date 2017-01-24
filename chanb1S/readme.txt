Steps for running the server

1. Put all the files in the directory home/brc110/cs512/assn3/chanb1S
2. Execute all the java files using javac *.java
3. Crete the stub files for the code base by executing
   rmic RaceListServant
   rmic RaceServant
4. start the rmiregistry by executing the following in another shell
   rmiregistry portnumber &
5. run the server program
   java -Djava.security.policy=java.policy -Djava.rmi.server.codebase="file:/cs512/assn3/chanb1S" RaceListServer


Steps for running the client

1. Put all the files in the directory home/brc110/cs512/assn3/chanb1C
2. Execute all the java files using javac *.java
3. Crete the stub files for the code base by executing
   rmic RaceListServant
   rmic RaceServant
4. run the client program   
   java -Djava.security.policy=java.policy -classpath . RaceListClient  1 (or) 2
     1: add new race information
     2: process all the client requests