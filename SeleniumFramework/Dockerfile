FROM openjdk:8u191-jre-alpine3.8

WORKDIR /usr/share/docs

ADD target/SeleniumFramework-1.0-SNAPSHOT.jar       SeleniumFramework-1.0-SNAPSHOT.jar
ADD target/SeleniumFramework-1.0-SNAPSHOT-tests.jar SeleniumFramework-1.0-SNAPSHOT-tests.jar
ADD target/libs                                     libs

ADD AccountSuite.xml    AccountSuite.xml
ADD SearchSuite.xml     SearchSuite.xml

ENTRYPOINT java -cp SeleniumFramework-1.0-SNAPSHOT.jar:SeleniumFramework-1.0-SNAPSHOT-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE