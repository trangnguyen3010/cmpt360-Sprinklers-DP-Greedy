javac -d ./out/ ./src/main/*.java
jar -cvf ./lib/SprinklerCalculator.jar -C ./out .
javac -cp :./lib/SprinklerCalculator.jar:./lib/hamcrest-core-1.3.jar:./lib/junit-4.13.2.jar -d ./out ./src/test/SprinklerCalculatorTest.java
cd ./out
java -cp :../lib/SprinklerCalculator.jar:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar org.junit.runner.JUnitCore test.SprinklerCalculatorTest
cd ..