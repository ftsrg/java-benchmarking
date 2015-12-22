#!/bin/bash

RUNS=50
WD=hu.bme.mit.mabel.example
RESULTS=results/results.csv
APP=target/hu.bme.mit.mabel.example-0.0.1-SNAPSHOT.jar

# convert the $RESULTS variable to an absolute path
RESULTS=$(pwd)/$RESULTS

# go to the working directory
cd $WD

rm -f $RESULTS
echo "VmArgs,Run,Phase,Time" | tee -a $RESULTS
java -jar $APP Base $RUNS | tee -a $RESULTS
java -server -XX:+TieredCompilation -XX:CompileThreshold=1 -jar $APP server-TieredCompilation-CompileThreshold=1 $RUNS | tee -a $RESULTS
