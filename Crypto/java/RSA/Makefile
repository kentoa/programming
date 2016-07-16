all: RSAPubKey RSASecKey RSATest

RSAPubKey: RSAPubKey.java
	javac RSAPubKey.java

RSASecKey: RSASEcKey.java
	javac RSASecKey.java

RSATest: RSATest.java
	javac RSATest.java
	java RSATest

clean:
	rm *.class rm *.java~
