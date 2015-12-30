#!/bin/bash
set -e
cd "$( cd "$( dirname "$0" )" && pwd )/.."

RUNS=50
WD=hu.bme.mit.mabel.examples.primes
RESULTS=results/results.csv
APP=target/hu.bme.mit.mabel.examples.primes-0.0.1-SNAPSHOT.jar

# convert the $RESULTS variable to an absolute path
RESULTS=$(pwd)/$RESULTS

# go to the working directory
cd $WD

rm -f $RESULTS
java -jar $APP Base $RUNS | tee -a $RESULTS
java -server -XX:+TieredCompilation -XX:CompileThreshold=1 -jar $APP server-TieredCompilation-CompileThreshold=1 $RUNS | tee -a $RESULTS
