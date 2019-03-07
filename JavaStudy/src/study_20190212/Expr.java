package study_20190212;

import java.util.Map;

public class Expr {
	 int eval(Map<String, Integer> context) ;
	 
	 static Expr num(int number) { // terminal
		 return context -> number;
	 }
	 
	 static Expr var(String name) { // terminal
		 return context -> context.getOrDefault(name, 0);
	 }
	 
	 static Expr plus(Expr left, Expr right) { // nonterminal
		 return context -> left.eval(context) + right.eval(context);
	 }
	 
	 static Expr minus(Expr left, Expr right) { // nonterminal
		 return context -> left.eval(context) - right.eval(context);
	 }
}
