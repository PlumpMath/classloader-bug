#!/bin/sh

echo "Building..."
sbt publish-local > /dev/null

sbt "project main" run

echo
echo "Should work fine"

rm -R test3
sbt compile  > /dev/null
sbt "project main" run

echo
echo "Should still work fine"

git reset --hard
git checkout -b play origin/play

echo
echo "please visit http://localhost:9000 when play started"
echo

sbt publish-local > /dev/null

sbt "project main" run

echo
echo "Application should start"

rm -R test3

echo
echo "please visit http://localhost:9000 again when play started"
echo

sbt compile > /dev/null

sbt "project main" run

echo "Application should fail to start with java.lang.NoClassDefFoundError: test/Test2"
