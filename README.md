# Swagger Gradle Plugin Error Demo

This repo has been created to clearly demonstrate issues found within the
[gradle swagger plugin](https://github.com/gigaSproule/swagger-gradle-plugin), specifically around
the use of model substitution. Some of the problems can be demonstrated by adding unit test to the project directly,
I will be creating a pull request to add these shortly. There is one issue that is particularly difficult to recreate
with a unit test because it only occurs when using the plugin to try and perform a model substitution where the classes
that you are trying to use in the substitution are not directly in the project using the plugin.

The example in this project demonstrates this by importing the javax.money:money-api:1.0.3 dependency and then setting
up a model substitution file that will take the MonetaryAmount value defined in uk.co.mruoc.SimpleRequest and swap it
with a uk.co.mruoc.CustomMonetaryAmount class found in the project.

Using the currently released version of the plugin (1.0.2 at the time of writing) the model substitution fails, this is
due to an issue with the way the model substitution file is loaded. It is recreated by running the following command:

```
./gradlew clean build generateSwaggerDocumentation
```

When the command is run, it will fail with the following error:

```
FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':generateSwaggerDocumentation'.
> Cannot invoke method eachLine() on null object

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.

* Get more help at https://help.gradle.org

BUILD FAILED in 2s
5 actionable tasks: 5 executed
```

As mentioned above, this particular error can be replicated with a unit test on the plugin project itself (pull
request coming soon!) Once this issue is solved, there is another problem with the class loading in the project which
means it is unable to find the javax.money.MonetaryAmount class, and so is unable to perform the model substitution.
This is the issue which is difficult to replicate with a test, and so I am using this repo as the test for it instead.

I have added mavenLocal() as a buildscript repository so that it is possible for you to publish the plugin to your local
maven repository and then make use of it in this project so it is possible to test changes made to the plugin from your
local machine.