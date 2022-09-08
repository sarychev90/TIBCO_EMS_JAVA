# TIBCO EMS JAVA SPRING BOOT

This is a simple project to implement a Java Spring Boot message producer and consumer through a TIBCO Enterprise Message Service version 10.1. 
For more details please use link: https://www.tibco.com/products/tibco-enterprise-message-service

## What you need to run the application
1. Install TIBCO EMS to your local machine.
2. Load the required libraries (jars) to your local Maven repository
3. Start TIBCO EMS
4. Start Consumer and Produser Java Spring Boot apps

## Installation TIBCO EMS

You can download installation files from the official site or use file from the project`s folder tibcoEmsServer\installer\os. 

## Loading the required libraries

You can use already generated libs from the project`s folder tibcoEmsServer/installer/libs/ or generate libs by yoursalfe:

1. Navigate to tibco libs placeholder directory on your local machine to ..tibco/ems/10.1/lib/
2. Run the command line from this folder
3. Run the follownig commands:

	mvn install:install-file -DgroupId=javax.jms -DartifactId=jms -Dversion=2.0 -Dpackaging=jar -Dfile=jms-2.0.jar

	mvn install:install-file -DgroupId=com.tibco -DartifactId=tibjms -Dversion=10.1 -Dpackaging=jar -Dfile=tibjms-10.1.jar

4. Build project.

## Starting TIBCO EMS

For starting TIBCO EMS you need to follow the steps below: 

1. Navigate to tibco bin placeholder directory on your local machine to ..tibco/ems/10.1/bin/
2. Run the follownig commands:

	tibemsd -config tibemsd.conf

	tibemsadmin -server "tcp://localhost:7222"

	create user first_user password=secret

	create queue ems.test.queue

Note: all above commands must be successfully completed.

