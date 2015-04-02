#! /bin/bash

javac -encoding UTF-8 Main.java
java Main

javac -encoding UTF-8 EvalExpr.java
java EvalExpr exprs.in eval.out

