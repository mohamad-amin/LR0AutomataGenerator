# Samples
Here are some samples of working with this project. for information about this project refere to [README file](https://github.com/mohamad-amin/LR0AutomataGenerator/blob/master/README.md).

## Sample 2
We want to create an LR0 Automata for this grammer:
```
Terminals: { ;, (, ), int, + }
Non-Terminals: {S, E, T }
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
