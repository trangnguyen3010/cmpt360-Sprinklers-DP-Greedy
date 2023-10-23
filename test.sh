#!/bin/bash

for i in {1..5}
do
  echo "Check test $i:"
  javac -d ./out/ ./src/main/*.java
  java -cp "./out/" "main.SprinklerProgram" < "./src/test/in/test$i" > "./out/test/result/test$i"
  diff "./src/test/out/test$i" "./out/test/result/test$i" | tr -d "\\" | tr -d " No newline at end of file"
  echo "---------------------------------"
done