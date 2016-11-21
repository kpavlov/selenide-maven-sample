# Maven Selenide Tests

[![Build Status](https://travis-ci.org/kpavlov/selenide-maven-sample.svg?branch=master)](https://travis-ci.org/kpavlov/selenide-maven-sample)

This is an example of how you can run [Selenium][selenium] tests with [Selenide][selenide] under maven. See [my blog post](https://konstantinpavlov.net/blog/2016/05/12/selenium-tests-with-maven-and-selenide/?utm_source=github) with explainations. 

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

### Testing with Chrome

1. Download and install [chromedriver](https://sites.google.com/a/chromium.org/chromedriver/downloads) to directory `${HOME}/bin`

2. Run maven: `mvn test -Pchrome`

You may override the chromedriver path by passing system property to maven:
    
    mvn test -chrome -Dwebdriver.gecko.driver=<path-to>/chromedriver

### Testing with Firefox

Download [geckodriver](https://github.com/mozilla/geckodriver/releases) and install it to `${HOME}/bin` 

The Selenium client bindings will try to locate the geckodriver executable from the system path. But it may not work. So using system property `webdriver.gecko.driver` is the most stable solution. Original referene: [Firefox Marionette WebDriver](https://developer.mozilla.org/en-US/docs/Mozilla/QA/Marionette/WebDriver) 

You may override the geckodriver path by passing system property to maven:
    
    mvn test -Pfirefox -Dwebdriver.gecko.driver=<path-to>/geckodriver

## Testing with Safari

1. Start Safari and select _'Allow Remote Automation'_ option in Safari's Develop menu. Otherwise you'll see the following message in logs:

        "Could not create a session: You must enable the 'Allow Remote Automation' option in Safari's Develop menu to control"

2. Run maven: `mvn test -Psafari`

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
