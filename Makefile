MF=META-INF/MANIFEST.MF
FILES= Makefile $(MF)
PROJ=poof
I=-Dimport=test.import -Din=test.in -Dout=test.outhyp poof.textui.Shell
all:
	javac -encoding utf-8 `find $(PROJ) pt -name "*.java"`
	jar -cfm $(PROJ)-`date "+%Y%m%d%H%M%S"`.jar $(MF) `find $(PROJ) pt -name "*.java"` $(FILES)
	jar -cf pt.jar `find pt -name "*.class"`
	jar -cfm $(PROJ).jar $(MF) pt.jar `find $(PROJ) -name "*.class"`
	chmod +x runtests.sh
run:
	java -jar $(PROJ).jar
swing:
	java -Dui=swing -jar $(PROJ).jar
clean:
	rm -f `find $(PROJ) pt -name "*.class"`
	rm -f `find $(PROJ) pt . -name "*.jar"`
teste:
	sh ./runtests.sh