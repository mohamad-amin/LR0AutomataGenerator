# Samples
Here are some samples of working with this project. for information about this project refere to [project's main page](https://github.com/mohamad-amin/LR0AutomataGenerator).

## Sample 1
We want to create an LR0 Automata for this grammer:
```
Terminals: { a, b, c, d, h, r, g }
Non-Terminals: { S, A, B }
Productions:
  S -> aS
  S -> bA
  S -> cB
  A -> d
  A -> h
  B -> r
  B -> g
```

#### Input

```
Enter terminals separated with a whitespace character
a b c d h r g
Enter non-terminals separated with a whitespace character
S A B
Enter start symbol
S
Enter number of rules: 
7
Enter a rule, starting with a non-terminal, then '->' and then some terminal/non-terminal (s), 
Note: every terminal and '-> sign' in a rule must be separated from the previous tokens with a whitespace
S -> a S
Enter a rule, starting with a non-terminal, then '->' and then some terminal/non-terminal (s), 
Note: every terminal and '-> sign' in a rule must be separated from the previous tokens with a whitespace
S -> b A
Enter a rule, starting with a non-terminal, then '->' and then some terminal/non-terminal (s), 
Note: every terminal and '-> sign' in a rule must be separated from the previous tokens with a whitespace
S -> c B
Enter a rule, starting with a non-terminal, then '->' and then some terminal/non-terminal (s), 
Note: every terminal and '-> sign' in a rule must be separated from the previous tokens with a whitespace
A -> d
Enter a rule, starting with a non-terminal, then '->' and then some terminal/non-terminal (s), 
Note: every terminal and '-> sign' in a rule must be separated from the previous tokens with a whitespace
A -> h
Enter a rule, starting with a non-terminal, then '->' and then some terminal/non-terminal (s), 
Note: every terminal and '-> sign' in a rule must be separated from the previous tokens with a whitespace
B -> r
Enter a rule, starting with a non-terminal, then '->' and then some terminal/non-terminal (s), 
Note: every terminal and '-> sign' in a rule must be separated from the previous tokens with a whitespace
B -> g
```

#### Output
```
--------------------------------------------
----------------- RESULT -------------------
--------------------------------------------
Start state -> 0
--------------------------------------------
State 0
Rules:
	S -> .aS
	S -> .bA
	S -> .cB
Links:
	a -> 1
	b -> 3
	c -> 7
--------------------------------------------
State 1
Rules:
	S -> a.S
	S -> .aS
	S -> .bA
	S -> .cB
Links:
	a -> 1
	b -> 3
	S -> 2
	c -> 7
--------------------------------------------
State 2
Rules:
	S -> aS.
--------------------------------------------
State 3
Rules:
	S -> b.A
	A -> .d
	A -> .h
Links:
	A -> 4
	d -> 5
	h -> 6
--------------------------------------------
State 4
Rules:
	S -> bA.
--------------------------------------------
State 5
Rules:
	A -> d.
--------------------------------------------
State 6
Rules:
	A -> h.
--------------------------------------------
State 7
Rules:
	S -> c.B
	B -> .r
	B -> .g
Links:
	B -> 8
	r -> 9
	g -> 10
--------------------------------------------
State 8
Rules:
	S -> cB.
--------------------------------------------
State 9
Rules:
	B -> r.
--------------------------------------------
State 10
Rules:
	B -> g.
--------------------------------------------
```

## Sample 2
We want to create an LR0 Automata for this grammer:
```
Terminals: { ;, (, ), int, + }
Non-Terminals: { S, E, T }
Productions:
  S -> E
  E ->T;
  E ->T+E
  T -> int
  T -> (E)
```

#### Input

```
Enter terminals separated with a whitespace character
; + int ( )
Enter non-terminals separated with a whitespace character
S T E
Enter start symbol
S
Enter number of rules: 
5
Enter a rule, starting with a non-terminal, then '->' and then some terminal/non-terminal (s), 
Note: every terminal and '-> sign' in a rule must be separated from the previous tokens with a whitespace
S -> E
Enter a rule, starting with a non-terminal, then '->' and then some terminal/non-terminal (s), 
Note: every terminal and '-> sign' in a rule must be separated from the previous tokens with a whitespace
E -> T ;
Enter a rule, starting with a non-terminal, then '->' and then some terminal/non-terminal (s), 
Note: every terminal and '-> sign' in a rule must be separated from the previous tokens with a whitespace
E -> T + E
Enter a rule, starting with a non-terminal, then '->' and then some terminal/non-terminal (s), 
Note: every terminal and '-> sign' in a rule must be separated from the previous tokens with a whitespace
T -> int
Enter a rule, starting with a non-terminal, then '->' and then some terminal/non-terminal (s), 
Note: every terminal and '-> sign' in a rule must be separated from the previous tokens with a whitespace
T -> ( E )
```

#### Output
```
--------------------------------------------
----------------- RESULT -------------------
--------------------------------------------
Start state -> 0
--------------------------------------------
State 0
Rules:
	S -> .E
	E -> .T;
	T -> .int
	T -> .(E)
	E -> .T+E
Links:
	T -> 2
	E -> 1
	( -> 7
	int -> 6
--------------------------------------------
State 1
Rules:
	S -> E.
--------------------------------------------
State 2
Rules:
	E -> T.;
	E -> T.+E
Links:
	; -> 3
	+ -> 4
--------------------------------------------
State 3
Rules:
	E -> T;.
--------------------------------------------
State 4
Rules:
	E -> T+.E
	E -> .T;
	T -> .int
	T -> .(E)
	E -> .T+E
Links:
	T -> 2
	E -> 5
	( -> 7
	int -> 6
--------------------------------------------
State 5
Rules:
	E -> T+E.
--------------------------------------------
State 6
Rules:
	T -> int.
--------------------------------------------
State 7
Rules:
	T -> (.E)
	E -> .T;
	T -> .int
	T -> .(E)
	E -> .T+E
Links:
	T -> 2
	E -> 8
	( -> 7
	int -> 6
--------------------------------------------
State 8
Rules:
	T -> (E.)
Links:
	) -> 9
--------------------------------------------
State 9
Rules:
	T -> (E).
--------------------------------------------
```
