link(hope,love).
link(hope,goodness).
link(hope,faith).
link(love,pride).
link(goodness,mercy).
link(pride,faith).
link(mercy,life).
link(patience,life).
link(patience,faith).
link(faith,goodness).

paths(X,Y) :- link(X,Y).
paths(X,Y) :- link(X,Z),paths(Z,Y).
