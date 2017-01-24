parent(sean, tom).
parent(tom, unis).
parent(unis, veins).
parent(unis, vics).
parent(james, tyler).
parent(james, king).
parent(james, aron).
parent(tyler, ungaro).
parent(ungaro, vics).
parent(king, laura).
parent(george, huges).
parent(huges, peter).
parent(peter, jane).
parent(douglas, cathy).
parent(cathy, jane).
male(vics).
male(ungaro).
male(peter).
male(tyler).
male(king).
male(aron).
female(jane).
female(cathy).
female(unis).
wife(jane, vics).

ancestor(X,Y):- parent(X, Y).
ancestor(X, Y) :- parent(X,Z), ancestor(Z,Y).

des(X,Y) :- ancestor(Y, X).

greatgrand(X, Y):- parent(X, W), parent(W,Z),parent(Z,Y).

motherinlaw(X,Y):- parent(X, V), spouse(Y,V), female(X).

nephew(X, Y):- parent(P, X), parent(W, Y), parent(W, P), male(X), P \== Y.

brother(X, Y):- parent(P,X), parent(P, Y), male(X), X \== Y.

spouse(X, Y):- wife(X, Y).
spouse(Y, X):- wife(X, Y).
spouse(X, Y):- parent(X, V), parent(Y, V), X \== Y.

