# Maven Selenide Tests

[![Build Status](https://travis-ci.org/kpavlov/selenide-maven-sample.svg?branch=master)](https://travis-ci.org/kpavlov/selenide-maven-sample)

This is an example of how you can run [Selenium][selenium] tests with [Selenide][selenide] under maven. See [my blog post](https://blog.konstantinpavlov.net/2016/05/12/selenium-tests-with-maven-and-selenide/) with explainations. 

Use maven 3.3+ and JDK 1.8 to run the tests
Default maven goal is "clean test", default browser is "firefox".

Command line:
```bash
mvn
```

In case of failure, Selenide create screenshots at ${basedir}/build

## Use different browsers
Specify maven profile to use different browsers

```bash
mvn test -P<browser>
```
where browsers are:
- chrome
- firefox
- phantomjs
- ie

## Leave browser open after test

If selenide property `holdBrowserOpen` is `true`, browser window stays open after running tests.
It may be useful for debugging. Can be configured either programmatically or by system property `-Dselenide.holdBrowserOpen=true`.

To activate this property use maven profile "local":

```bash
mvn test -P<browser>,local
```

## Running in Selenium Grid

Selenium grid URL: http://jenkins.fxpro.local:4444/grid (monitoring)
Selenium Hub Url: http://jenkins.fxpro.local:4444/wd/hub (to conenct to)

Specify profile "jenkins" in addition to browser profile to use with selenium hub.
```bash
# Remote chrome
mvn -Pci-server,chrome

# Remote firefox
mvn -Pci-server,firefox
```

Specify parameter **selenium.hub.url** to override, e.g:

 ```bash
 mvn clean test -Pci-server -Dselenium.hub.url=http://localhost:4444/wd/hub
 ```

[selenide]: http://selenide.org
[selenium]: http://www.seleniumhq.org
