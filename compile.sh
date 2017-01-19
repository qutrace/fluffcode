find -name "*.java" > sources.txt
javac -cp .:lib/*:native/* @sources.txt -d build/
